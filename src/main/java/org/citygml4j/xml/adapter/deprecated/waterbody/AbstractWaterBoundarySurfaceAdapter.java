package org.citygml4j.xml.adapter.deprecated.waterbody;

import org.citygml4j.model.ade.generic.GenericADEOfAbstractThematicSurface;
import org.citygml4j.model.core.ADEOfAbstractThematicSurface;
import org.citygml4j.model.core.AbstractThematicSurface;
import org.citygml4j.model.waterbody.ADEOfAbstractWaterBoundarySurface;
import org.citygml4j.model.waterbody.AbstractWaterBoundarySurface;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.citygml4j.xml.adapter.core.AbstractCityObjectAdapter;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.geometry.primitives.SurfacePropertyAdapter;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurface;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurfaceProperty;
import org.xmlobjects.gml.model.geometry.complexes.CompositeSurface;
import org.xmlobjects.gml.model.geometry.primitives.AbstractSurface;
import org.xmlobjects.gml.model.geometry.primitives.SurfaceProperty;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.util.copy.CopyBuilder;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWaterBoundarySurfaceAdapter<T extends AbstractThematicSurface> extends AbstractCityObjectAdapter<T> {
    private final CopyBuilder copyBuilder = new CopyBuilder();
    private final QName[] substitutionGroups = new QName[]{
            new QName(CityGMLConstants.CITYGML_2_0_WATERBODY_NAMESPACE, "_GenericApplicationPropertyOfWaterBoundarySurface"),
            new QName(CityGMLConstants.CITYGML_1_0_WATERBODY_NAMESPACE, "_GenericApplicationPropertyOfWaterBoundarySurface")
    };

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isWaterBodyNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "lod2Surface":
                    object.setLod2MultiSurface(getMultiSurfaceProperty(reader.getObjectUsingBuilder(SurfacePropertyAdapter.class)));
                    return;
                case "lod3Surface":
                    object.setLod3MultiSurface(getMultiSurfaceProperty(reader.getObjectUsingBuilder(SurfacePropertyAdapter.class)));
                    return;
                case "lod4Surface":
                    object.getDeprecatedProperties().setLod4MultiSurface(getMultiSurfaceProperty(reader.getObjectUsingBuilder(SurfacePropertyAdapter.class)));
                    return;
            }
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(T object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!ADEBuilderHelper.addADEContainer(name, ADEOfAbstractThematicSurface.class, object.getADEOfAbstractThematicSurface(),
                GenericADEOfAbstractThematicSurface::of, reader, substitutionGroups))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String waterBodyNamespace = CityGMLSerializerHelper.getWaterBodyNamespace(namespaces);

        if (object.getLod2MultiSurface() != null)
            writer.writeElementUsingSerializer(Element.of(waterBodyNamespace, "lod2Surface"), getSurfaceProperty(object.getLod2MultiSurface()), SurfacePropertyAdapter.class, namespaces);

        if (object.getLod3MultiSurface() != null)
            writer.writeElementUsingSerializer(Element.of(waterBodyNamespace, "lod3Surface"), getSurfaceProperty(object.getLod3MultiSurface()), SurfacePropertyAdapter.class, namespaces);

        if (object.getDeprecatedProperties().getLod4MultiSurface() != null)
            writer.writeElementUsingSerializer(Element.of(waterBodyNamespace, "lod4Surface"), getSurfaceProperty(object.getDeprecatedProperties().getLod4MultiSurface()), SurfacePropertyAdapter.class, namespaces);

        if (object instanceof AbstractWaterBoundarySurface) {
            AbstractWaterBoundarySurface boundarySurface = (AbstractWaterBoundarySurface) object;
            for (ADEOfAbstractWaterBoundarySurface container : boundarySurface.getADEOfAbstractWaterBoundarySurface())
                ADESerializerHelper.writeADEProperty(container, namespaces, writer);
        }

        for (ADEOfAbstractThematicSurface container : object.getADEOfAbstractThematicSurface())
            ADESerializerHelper.writeADEProperty(container, namespaces, writer);
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

        return dest;
    }
}
