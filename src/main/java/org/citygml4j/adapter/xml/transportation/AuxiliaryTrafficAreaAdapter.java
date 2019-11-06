package org.citygml4j.adapter.xml.transportation;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.core.AbstractThematicSurfaceAdapter;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfAuxiliaryTrafficArea;
import org.citygml4j.model.transportation.ADEPropertyOfAuxiliaryTrafficArea;
import org.citygml4j.model.transportation.AuxiliaryTrafficArea;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.basictypes.CodeAdapter;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElement(name = "AuxiliaryTrafficArea", namespaceURI = CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE)
public class AuxiliaryTrafficAreaAdapter extends AbstractThematicSurfaceAdapter<AuxiliaryTrafficArea> {
    private final QName substitutionGroup = new QName(CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE, "AbstractGenericApplicationPropertyOfAuxiliaryTrafficArea");

    @Override
    public AuxiliaryTrafficArea createObject(QName name) throws ObjectBuildException {
        return new AuxiliaryTrafficArea();
    }

    @Override
    public void buildChildObject(AuxiliaryTrafficArea object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE.equals(name.getNamespaceURI())) {
            if (CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
                return;

            if ("surfaceMaterial".equals(name.getLocalPart())) {
                object.setSurfaceMaterial(reader.getObjectUsingBuilder(CodeAdapter.class));
                return;
            }
        }

        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            ObjectBuilder<ADEPropertyOfAuxiliaryTrafficArea> builder = reader.getXMLObjects().getBuilder(name, ADEPropertyOfAuxiliaryTrafficArea.class);
            if (builder != null)
                object.getADEPropertiesOfAuxiliaryTrafficArea().add(reader.getObjectUsingBuilder(builder));
            else if (CityGMLBuilderHelper.createAsGenericADEProperty(name, reader, substitutionGroup))
                object.getADEPropertiesOfAuxiliaryTrafficArea().add(GenericADEPropertyOfAuxiliaryTrafficArea.of(reader.getDOMElement()));
        } else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(AuxiliaryTrafficArea object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE, "AuxiliaryTrafficArea");
    }

    @Override
    public void writeChildElements(AuxiliaryTrafficArea object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        CityGMLSerializerHelper.serializeStandardObjectClassifier(object, CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE, namespaces, writer);

        if (object.getSurfaceMaterial() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE, "surfaceMaterial"), object.getSurfaceMaterial(), CodeAdapter.class, namespaces);

        for (ADEPropertyOfAuxiliaryTrafficArea property : object.getADEPropertiesOfAuxiliaryTrafficArea())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
