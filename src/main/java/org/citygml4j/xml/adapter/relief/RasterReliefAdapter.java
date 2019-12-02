package org.citygml4j.xml.adapter.relief;

import org.citygml4j.model.ade.generic.GenericADEPropertyOfRasterRelief;
import org.citygml4j.model.relief.ADEPropertyOfRasterRelief;
import org.citygml4j.model.relief.RasterRelief;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
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

@XMLElements({
        @XMLElement(name = "RasterRelief", namespaceURI = CityGMLConstants.CITYGML_3_0_RELIEF_NAMESPACE),
        @XMLElement(name = "RasterRelief", namespaceURI = CityGMLConstants.CITYGML_2_0_RELIEF_NAMESPACE),
        @XMLElement(name = "RasterRelief", namespaceURI = CityGMLConstants.CITYGML_1_0_RELIEF_NAMESPACE)
})
public class RasterReliefAdapter extends AbstractReliefComponentAdapter<RasterRelief> {
    private final QName[] substitutionGroups = new QName[]{
            new QName(CityGMLConstants.CITYGML_3_0_RELIEF_NAMESPACE, "AbstractGenericApplicationPropertyOfRasterRelief"),
            new QName(CityGMLConstants.CITYGML_2_0_RELIEF_NAMESPACE, "_GenericApplicationPropertyOfRasterRelief"),
            new QName(CityGMLConstants.CITYGML_1_0_RELIEF_NAMESPACE, "_GenericApplicationPropertyOfRasterRelief")
    };

    @Override
    public RasterRelief createObject(QName name) throws ObjectBuildException {
        return new RasterRelief();
    }

    @Override
    public void buildChildObject(RasterRelief object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isReliefNamespace(name.getNamespaceURI()) && "grid".equals(name.getLocalPart())) {
            object.setGrid(reader.getObjectUsingBuilder(GridPropertyAdapter.class));
            return;
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(RasterRelief object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfRasterRelief.class, object.getADEPropertiesOfRasterRelief(),
                GenericADEPropertyOfRasterRelief::of, reader, substitutionGroups))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(RasterRelief object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getReliefNamespace(namespaces), "RasterRelief");
    }

    @Override
    public void writeChildElements(RasterRelief object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String reliefNamespace = CityGMLSerializerHelper.getReliefNamespace(namespaces);

        if (object.getGrid() != null)
            writer.writeElementUsingSerializer(Element.of(reliefNamespace, "grid"), object.getGrid(), GridPropertyAdapter.class, namespaces);

        for (ADEPropertyOfRasterRelief<?> property : object.getADEPropertiesOfRasterRelief())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
