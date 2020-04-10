package org.citygml4j.xml.writer;

import org.citygml4j.model.CityGMLVersion;
import org.citygml4j.xml.module.Module;
import org.citygml4j.xml.module.ade.ADEModule;
import org.citygml4j.xml.module.citygml.CityGMLModule;
import org.citygml4j.xml.module.citygml.CityGMLModules;
import org.citygml4j.xml.module.citygml.CoreModule;
import org.citygml4j.xml.module.gml.GMLCompactEncodingModule;
import org.citygml4j.xml.module.gml.GMLExtendedBaseTypesModule;
import org.citygml4j.xml.transform.TransformerPipeline;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.stream.XMLWriterFactory;
import org.xmlobjects.xml.Namespaces;

public abstract class AbstractCityGMLWriter<T extends AbstractCityGMLWriter<?>> implements AutoCloseable {
    final XMLWriter writer;
    final CityGMLVersion version;
    final XMLWriterFactory factory;
    final Namespaces namespaces;

    TransformerPipeline transformer;

    AbstractCityGMLWriter(XMLWriter writer, CityGMLVersion version, XMLWriterFactory factory) {
        this.writer = writer;
        this.version = version;
        this.factory = factory;

        namespaces = Namespaces.newInstance();
        for (Module module : CityGMLModules.of(version).getModules())
            namespaces.add(module.getNamespaceURI());

        if (version == CityGMLVersion.v3_0) {
            namespaces.add(GMLCompactEncodingModule.v3_3.getNamespaceURI())
                    .add(GMLExtendedBaseTypesModule.v3_3.getNamespaceURI());
        }
    }

    public String getPrefix(String namespaceURI) {
        return writer.getPrefix(namespaceURI);
    }

    @SuppressWarnings("unchecked")
    public T withPrefix(String prefix, String namespaceURI) {
        writer.withPrefix(prefix,namespaceURI);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T withDefaultPrefixes() {
        for (Module module : CityGMLModules.of(version).getModules())
            withPrefix(module.getNamespacePrefix(), module.getNamespaceURI());

        return (T) this;
    }

    public String getNamespaceURI(String prefix) {
        return writer.getNamespaceURI(prefix);
    }

    @SuppressWarnings("unchecked")
    public T withDefaultNamespace(String namespaceURI) {
        writer.withDefaultNamespace(namespaceURI);
        return (T) this;
    }

    public String getIndentString() {
        return writer.getIndentString();
    }

    @SuppressWarnings("unchecked")
    public T withIndentString(String indent) {
        writer.withIndentString(indent);
        return (T) this;
    }

    public boolean isWriteXMLDeclaration() {
        return writer.isWriteXMLDeclaration();
    }

    @SuppressWarnings("unchecked")
    public T writeXMLDeclaration(boolean writeXMLDeclaration) {
        writer.writeXMLDeclaration(writeXMLDeclaration);
        return (T) this;
    }

    public String[] getHeaderComment() {
        return writer.getHeaderComment();
    }

    @SuppressWarnings("unchecked")
    public T withHeaderComment(String... headerComment) {
        writer.withHeaderComment(headerComment);
        return (T) this;
    }

    public String getSchemaLocation(String namespaceURI) {
        return writer.getSchemaLocation(namespaceURI);
    }

    @SuppressWarnings("unchecked")
    public T withSchemaLocation(String namespaceURI, String schemaLocation) {
        writer.withSchemaLocation(namespaceURI, schemaLocation);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T withDefaultSchemaLocations() {
        for (Module module : CityGMLModules.of(version).getModules()) {
            if (module.isSetSchemaLocation()
                    && ((module instanceof CityGMLModule && !(module instanceof CoreModule))
                    || module instanceof ADEModule))
                writer.withSchemaLocation(module.getNamespaceURI(), module.getSchemaLocation());
        }

        return (T) this;
    }

    public void flush() throws CityGMLWriteException {
        try {
            writer.flush();
        } catch (XMLWriteException e) {
            throw new CityGMLWriteException("Caused by:", e);
        }
    }

    @Override
    public void close() throws CityGMLWriteException {
        try {
            writer.close();
        } catch (XMLWriteException e) {
            throw new CityGMLWriteException("Caused by:", e);
        }
    }
}
