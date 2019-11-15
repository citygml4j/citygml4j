package org.citygml4j.adapter.xml.waterbody;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.core.AbstractThematicSurfaceAdapter;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfAbstractWaterBoundarySurface;
import org.citygml4j.model.waterbody.ADEPropertyOfAbstractWaterBoundarySurface;
import org.citygml4j.model.waterbody.AbstractWaterBoundarySurface;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public abstract class AbstractWaterBoundarySurfaceAdapter<T extends AbstractWaterBoundarySurface> extends AbstractThematicSurfaceAdapter<T> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_3_0_WATERBODY_NAMESPACE, "AbstractGenericApplicationPropertyOfAbstractWaterBoundarySurface");

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            ObjectBuilder<ADEPropertyOfAbstractWaterBoundarySurface> builder = reader.getXMLObjects().getBuilder(name, ADEPropertyOfAbstractWaterBoundarySurface.class);
            if (builder != null)
                object.getADEPropertiesOfAbstractWaterBoundarySurface().add(reader.getObjectUsingBuilder(builder));
            else if (CityGMLBuilderHelper.createAsGenericADEProperty(name, reader, substitutionGroup))
                object.getADEPropertiesOfAbstractWaterBoundarySurface().add(GenericADEPropertyOfAbstractWaterBoundarySurface.of(reader.getDOMElement()));
        } else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        for (ADEPropertyOfAbstractWaterBoundarySurface property : object.getADEPropertiesOfAbstractWaterBoundarySurface())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
