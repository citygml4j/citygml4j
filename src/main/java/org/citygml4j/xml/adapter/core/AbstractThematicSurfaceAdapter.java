package org.citygml4j.xml.adapter.core;

import org.citygml4j.model.ade.generic.GenericADEOfAbstractThematicSurface;
import org.citygml4j.model.core.ADEOfAbstractThematicSurface;
import org.citygml4j.model.core.AbstractThematicSurface;
import org.citygml4j.model.core.QualifiedAreaProperty;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.geometry.aggregates.MultiCurvePropertyAdapter;
import org.xmlobjects.gml.adapter.geometry.aggregates.MultiSurfacePropertyAdapter;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public abstract class AbstractThematicSurfaceAdapter<T extends AbstractThematicSurface> extends AbstractSpaceBoundaryAdapter<T> {

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "area":
                    object.getAreas().add(reader.getObjectUsingBuilder(QualifiedAreaPropertyAdapter.class));
                    return;
                case "lod0MultiCurve":
                    object.setLod0MultiCurve(reader.getObjectUsingBuilder(MultiCurvePropertyAdapter.class));
                    return;
                case "lod0MultiSurface":
                    object.setLod0MultiSurface(reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "lod1MultiSurface":
                    object.setLod1MultiSurface(reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "lod2MultiSurface":
                    object.setLod2MultiSurface(reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "lod3MultiSurface":
                    object.setLod3MultiSurface(reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "pointCloud":
                    object.setPointCloud(reader.getObjectUsingBuilder(AbstractPointCloudPropertyAdapter.class));
                    return;
                case "adeOfAbstractThematicSurface":
                    ADEBuilderHelper.addADEContainer(ADEOfAbstractThematicSurface.class, object.getADEOfAbstractThematicSurface(), GenericADEOfAbstractThematicSurface::of, reader);
                    return;
            }
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String coreNamespace = CityGMLSerializerHelper.getCoreNamespace(namespaces);

        if (CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE.equals(coreNamespace)) {
            for (QualifiedAreaProperty property : object.getAreas())
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "area"), property, QualifiedAreaPropertyAdapter.class, namespaces);

            if (object.getLod0MultiCurve() != null)
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "lod0MultiCurve"), object.getLod0MultiCurve(), MultiCurvePropertyAdapter.class, namespaces);

            if (object.getLod0MultiSurface() != null)
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "lod0MultiSurface"), object.getLod0MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

            if (object.getLod1MultiSurface() != null)
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "lod1MultiSurface"), object.getLod1MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

            if (object.getLod2MultiSurface() != null)
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "lod2MultiSurface"), object.getLod2MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

            if (object.getLod3MultiSurface() != null)
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "lod3MultiSurface"), object.getLod3MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

            if (object.getPointCloud() != null)
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "pointCloud"), object.getPointCloud(), AbstractPointCloudPropertyAdapter.class, namespaces);

            for (ADEOfAbstractThematicSurface container : object.getADEOfAbstractThematicSurface())
                ADESerializerHelper.writeADEContainer(Element.of(coreNamespace, "adeOfAbstractThematicSurface"), container, namespaces, writer);
        }
    }
}
