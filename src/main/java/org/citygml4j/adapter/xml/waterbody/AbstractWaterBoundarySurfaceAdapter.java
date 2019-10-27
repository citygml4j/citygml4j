package org.citygml4j.adapter.xml.waterbody;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.core.AbstractThematicSurfaceAdapter;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfAbstractWaterBoundarySurface;
import org.citygml4j.model.deprecated.DeprecatedProperties;
import org.citygml4j.model.waterbody.ADEPropertyOfAbstractWaterBoundarySurface;
import org.citygml4j.model.waterbody.AbstractWaterBoundarySurface;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.geometry.primitives.SurfacePropertyAdapter;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurface;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurfaceProperty;
import org.xmlobjects.gml.model.geometry.complexes.CompositeSurface;
import org.xmlobjects.gml.model.geometry.primitives.AbstractSurface;
import org.xmlobjects.gml.model.geometry.primitives.SurfaceProperty;
import org.xmlobjects.gml.util.copy.CopyBuilder;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWaterBoundarySurfaceAdapter<T extends AbstractWaterBoundarySurface> extends AbstractThematicSurfaceAdapter<T> {
    private final CopyBuilder copyBuilder = new CopyBuilder();
    private final QName[] substitutionGroups = new QName[] {
            new QName(CityGMLConstants.CITYGML_3_0_WATERBODY_NAMESPACE, "AbstractGenericApplicationPropertyOfAbstractWaterBoundarySurface"),
            new QName(CityGMLConstants.CITYGML_2_0_WATERBODY_NAMESPACE, "_GenericApplicationPropertyOfWaterBoundarySurface"),
            new QName(CityGMLConstants.CITYGML_1_0_WATERBODY_NAMESPACE, "_GenericApplicationPropertyOfWaterBoundarySurface"),
    };

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!name.getNamespaceURI().equals(CityGMLConstants.CITYGML_3_0_WATERBODY_NAMESPACE)) {
            switch (name.getLocalPart()) {
                case "lod2Surface":
                    object.setLod2MultiSurface(getMultiSurfaceProperty(reader.getObjectUsingBuilder(SurfacePropertyAdapter.class)));
                    return;
                case "lod3Surface":
                    object.setLod3MultiSurface(getMultiSurfaceProperty(reader.getObjectUsingBuilder(SurfacePropertyAdapter.class)));
                    return;
                case "lod4Surface":
                    object.getLocalProperties().set(DeprecatedProperties.LOD4_SURFACE, reader.getObjectUsingBuilder(SurfacePropertyAdapter.class));
                    return;
            }
        }

        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            ObjectBuilder<ADEPropertyOfAbstractWaterBoundarySurface> builder = reader.getXMLObjects().getBuilder(name, ADEPropertyOfAbstractWaterBoundarySurface.class);
            if (builder != null)
                object.getADEPropertiesOfAbstractWaterBoundarySurface().add(reader.getObjectUsingBuilder(builder));
            else if (CityGMLBuilderHelper.createAsGenericADEProperty(name, reader, substitutionGroups))
                object.getADEPropertiesOfAbstractWaterBoundarySurface().add(GenericADEPropertyOfAbstractWaterBoundarySurface.of(reader.getDOMElement()));
        } else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String waterBodyNamespace = CityGMLSerializerHelper.getWaterBodyNamespace(namespaces);

        if (!CityGMLConstants.CITYGML_3_0_WATERBODY_NAMESPACE.equals(waterBodyNamespace)) {
            if (object.getLod2MultiSurface() != null)
                writer.writeElementUsingSerializer(Element.of(waterBodyNamespace, "lod2Surface"), getSurfaceProperty(object.getLod2MultiSurface()), SurfacePropertyAdapter.class, namespaces);

            if (object.getLod3MultiSurface() != null)
                writer.writeElementUsingSerializer(Element.of(waterBodyNamespace, "lod3Surface"), getSurfaceProperty(object.getLod3MultiSurface()), SurfacePropertyAdapter.class, namespaces);

            if (object.getLocalProperties().contains(DeprecatedProperties.LOD4_SURFACE)) {
                SurfaceProperty property = object.getLocalProperties().get(DeprecatedProperties.LOD4_SURFACE, SurfaceProperty.class);
                writer.writeElementUsingSerializer(Element.of(waterBodyNamespace, "lod4Surface"), property, SurfacePropertyAdapter.class, namespaces);
            }
        }

        for (ADEPropertyOfAbstractWaterBoundarySurface property : object.getADEPropertiesOfAbstractWaterBoundarySurface())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }

    private MultiSurfaceProperty getMultiSurfaceProperty(SurfaceProperty src) {
        MultiSurface multiSurface = new MultiSurface();
        multiSurface.getSurfaceMember().add(src);

        return new MultiSurfaceProperty(multiSurface);
    }

    private SurfaceProperty getSurfaceProperty(MultiSurfaceProperty src) {
        SurfaceProperty dest;

        if (src.getObject() != null) {
            MultiSurface multiSurface = src.getObject();

            List<SurfaceProperty> properties = new ArrayList<>();
            for (SurfaceProperty property : multiSurface.getSurfaceMember())
                properties.add((SurfaceProperty) property.shallowCopy(copyBuilder));

            if (multiSurface.getSurfaceMembers() != null) {
                for (AbstractSurface surface : multiSurface.getSurfaceMembers().getObjects())
                    properties.add(new SurfaceProperty((AbstractSurface) surface.shallowCopy(copyBuilder)));
            }

            if (properties.size() == 0)
                dest = new SurfaceProperty();
            else if (properties.size() == 1)
                dest = properties.get(0);
            else
                dest = new SurfaceProperty(new CompositeSurface(properties));
        } else
            dest = new SurfaceProperty();

        dest.setReference(src);
        return dest;
    }
}
