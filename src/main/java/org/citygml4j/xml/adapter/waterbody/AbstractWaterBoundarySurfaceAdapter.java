package org.citygml4j.xml.adapter.waterbody;

import org.citygml4j.model.ade.generic.GenericADEOfAbstractWaterBoundarySurface;
import org.citygml4j.model.waterbody.ADEOfAbstractWaterBoundarySurface;
import org.citygml4j.model.waterbody.AbstractWaterBoundarySurface;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.citygml4j.xml.adapter.core.AbstractThematicSurfaceAdapter;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public abstract class AbstractWaterBoundarySurfaceAdapter<T extends AbstractWaterBoundarySurface> extends AbstractThematicSurfaceAdapter<T> {

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_WATERBODY_NAMESPACE.equals(name.getNamespaceURI()) && "adeOfAbstractWaterBoundarySurface".equals(name.getLocalPart()))
            ADEBuilderHelper.addADEContainer(ADEOfAbstractWaterBoundarySurface.class, object.getADEOfAbstractWaterBoundarySurface(), GenericADEOfAbstractWaterBoundarySurface::new, reader);
        else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        for (ADEOfAbstractWaterBoundarySurface container : object.getADEOfAbstractWaterBoundarySurface())
            ADESerializerHelper.writeADEContainer(Element.of(CityGMLConstants.CITYGML_3_0_WATERBODY_NAMESPACE, "adeOfAbstractWaterBoundarySurface"), container, namespaces, writer);
    }
}
