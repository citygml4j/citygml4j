package org.citygml4j.xml.reader;

import org.citygml4j.model.CityGMLObject;
import org.citygml4j.util.IdCreator;
import org.citygml4j.xml.module.citygml.AppearanceModule;
import org.citygml4j.xml.module.citygml.CityGMLModules;
import org.citygml4j.xml.module.citygml.CityObjectGroupModule;
import org.citygml4j.xml.module.citygml.CoreModule;
import org.citygml4j.xml.module.gml.GMLCoreModule;
import org.citygml4j.xml.module.gml.XLinkModule;
import org.xml.sax.SAXException;
import org.xmlobjects.XMLObjects;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.feature.AbstractFeature;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLReaderFactory;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.TransformerException;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class CityGMLChunkReader extends CityGMLReader {
    private final ChunkMode chunkMode;
    private final XMLReaderFactory factory;
    private final XMLStreamReader streamReader;

    private final Deque<CityGMLChunk> chunks = new ArrayDeque<>();
    private final Map<String, Set<String>> properties = new HashMap<>();
    private final Map<String, Set<String>> excludes = new HashMap<>();

    private CityGMLChunk current;
    private IdCreator idCreator;
    private boolean keepInlineAppearance = true;
    private boolean hasNext = false;
    private int skipUntil = 0;

    public CityGMLChunkReader(XMLReader reader, ChunkMode chunkMode, XMLReaderFactory factory) {
        super(reader);
        this.chunkMode = chunkMode;
        this.factory = factory;
        streamReader = reader.getStreamReader();

        initialize();
    }

    @Override
    public boolean hasNext() throws CityGMLReadException {
        if (!hasNext) {
            try {
                XMLObjects xmlObjects = reader.getXMLObjects();
                boolean initialize = false;

                while (streamReader.hasNext()) {
                    int eventType = streamReader.next();

                    if (skipUntil == 0 && eventType == XMLStreamConstants.START_ELEMENT) {
                        ObjectBuilder<AbstractFeature> builder = xmlObjects.getBuilder(reader.getName(), AbstractFeature.class);
                        if (builder != null && CityGMLObject.class.isAssignableFrom(xmlObjects.getObjectType(builder))) {
                            if (current == null)
                                current = new CityGMLChunk(reader.getName(), factory);
                            else if (shouldChunk(reader.getName())) {
                                chunks.push(current);
                                current = new CityGMLChunk(reader.getName(), factory, current);
                                initialize = true;
                            }
                        }
                    } else if (skipUntil > 0
                            && eventType == XMLStreamConstants.END_ELEMENT
                            && skipUntil == reader.getDepth() + 1)
                        skipUntil = 0;

                    if (current != null) {
                        current.bufferEvent(streamReader);

                        if (initialize) {
                            setXLink();
                            initialize = false;
                        } else if (current.isComplete()) {
                            if (filter != null && !filter.accept(current.getFirstElement()))
                                current = !chunks.isEmpty() ? chunks.pop() : null;
                            else {
                                hasNext = true;
                                break;
                            }
                        }
                    }
                }
            } catch (XMLReadException | XMLStreamException | SAXException e) {
                throw new CityGMLReadException("Caused by:", e);
            }
        }

        return hasNext;
    }

    @Override
    public CityGMLObject next() throws CityGMLReadException {
        if (hasNext()) {
            try {
                return nextChunk().build(true);
            } finally {
                hasNext = false;
            }
        }

        throw new NoSuchElementException();
    }

    @Override
    public CityGMLChunk nextChunk() throws CityGMLReadException {
        if (hasNext()) {
            try {
                CityGMLChunk next = current;
                current = !chunks.isEmpty() ? chunks.pop() : null;

                if (transformer != null)
                    next.transform(transformer);

                return next;
            } catch (TransformerException e) {
                throw new CityGMLReadException("Caused by:", e);
            } finally {
                hasNext = false;
            }
        }

        throw new NoSuchElementException();
    }

    @Override
    public boolean hasParentInfo() {
        try {
            return getParentInfo() != null;
        } catch (CityGMLReadException e) {
            return false;
        }
    }

    @Override
    public ObjectInfo getParentInfo() throws CityGMLReadException {
        return current != null ? current.getObjectInfo() : null;
    }

    @Override
    public void close() throws CityGMLReadException {
        super.close();
        current = null;
        chunks.clear();
    }

    private boolean shouldChunk(QName name) {
        QName property = current.getLastElement();
        if (chunkMode == ChunkMode.PER_COLLECTION_MEMBER) {
            Set<String> properties = this.properties.get(property.getNamespaceURI());
            if (properties == null || !properties.contains(property.getLocalPart()))
                return false;
        }

        if (keepInlineAppearance
                && name.getLocalPart().equals("Appearance")
                && CityGMLModules.isCityGMLNamespace(name.getNamespaceURI())
                && (!property.getLocalPart().equals("appearanceMember")
                || !CityGMLModules.isCityGMLNamespace(property.getNamespaceURI()))) {
            skipUntil = reader.getDepth();
            return false;
        }

        Set<String> excludes = this.excludes.get(name.getNamespaceURI());
        return excludes == null || !excludes.contains(name.getLocalPart());
    }

    private void setXLink() {
        String gmlId = null;
        for (int i = 0; i < streamReader.getAttributeCount(); i++) {
            if (streamReader.getAttributeLocalName(i).equals("id")) {
                gmlId = streamReader.getAttributeValue(i);
                break;
            }
        }

        if (gmlId == null) {
            gmlId = idCreator.createId();
            current.getSAXBuffer().addAttribute(GMLCoreModule.v3_1.getNamespaceURI(), "id", "gml:id", "CDATA", gmlId);
            current.getSAXBuffer().addAttribute(GMLCoreModule.v3_2.getNamespaceURI(), "id", "gml:id", "CDATA", gmlId);
        }

        chunks.getFirst().getSAXBuffer().removeTrailingCharacters();
        chunks.getFirst().getSAXBuffer().addAttribute(XLinkModule.v1_0.getNamespaceURI(), "href", "xlink:href", "CDATA", "#" + gmlId);
    }

    CityGMLChunkReader chunkAtProperty(String namespaceURI, String localName) {
        properties.computeIfAbsent(namespaceURI, v -> new HashSet<>()).add(localName);
        return this;
    }

    CityGMLChunkReader chunkAtProperties(Collection<QName> properties) {
        if (properties != null)
            properties.forEach(p -> chunkAtProperty(p.getNamespaceURI(), p.getLocalPart()));

        return this;
    }

    CityGMLChunkReader excludeFromChunking(Collection<QName> properties) {
        if (properties != null) {
            for (QName property : properties)
                excludes.computeIfAbsent(property.getNamespaceURI(), v -> new HashSet<>()).add(property.getLocalPart());
        }

        return this;
    }

    CityGMLChunkReader keepInlineAppearance(boolean keepInlineAppearance) {
        this.keepInlineAppearance = keepInlineAppearance;
        return this;
    }

    CityGMLChunkReader withIdCreator(IdCreator idCreator) {
        this.idCreator = idCreator;
        return this;
    }

    private void initialize() {
        if (chunkMode == ChunkMode.PER_COLLECTION_MEMBER) {
            // default CityGML 3.0 collection properties
            chunkAtProperty(CoreModule.v3_0.getNamespaceURI(), "cityObjectMember");
            chunkAtProperty(CoreModule.v3_0.getNamespaceURI(), "appearanceMember");
            chunkAtProperty(CoreModule.v3_0.getNamespaceURI(), "featureMember");
            chunkAtProperty(CoreModule.v3_0.getNamespaceURI(), "versionMember");
            chunkAtProperty(CoreModule.v3_0.getNamespaceURI(), "versionTransitionMember");
            chunkAtProperty(CityObjectGroupModule.v3_0.getNamespaceURI(), "groupMember");
            chunkAtProperty(CityObjectGroupModule.v3_0.getNamespaceURI(), "parent");

            // default CityGML 2.0 collection properties
            chunkAtProperty(CoreModule.v2_0.getNamespaceURI(), "cityObjectMember");
            chunkAtProperty(AppearanceModule.v2_0.getNamespaceURI(), "appearanceMember");
            chunkAtProperty(CityObjectGroupModule.v2_0.getNamespaceURI(), "groupMember");
            chunkAtProperty(CityObjectGroupModule.v2_0.getNamespaceURI(), "parent");

            // default CityGML 1.0 collection properties
            chunkAtProperty(CoreModule.v1_0.getNamespaceURI(), "cityObjectMember");
            chunkAtProperty(AppearanceModule.v1_0.getNamespaceURI(), "appearanceMember");
            chunkAtProperty(CityObjectGroupModule.v1_0.getNamespaceURI(), "groupMember");
            chunkAtProperty(CityObjectGroupModule.v1_0.getNamespaceURI(), "parent");

            // default GML collection properties
            chunkAtProperty(GMLCoreModule.v3_1.getNamespaceURI(), "featureMember");
            chunkAtProperty(GMLCoreModule.v3_1.getNamespaceURI(), "featureMembers");
        }
    }
}
