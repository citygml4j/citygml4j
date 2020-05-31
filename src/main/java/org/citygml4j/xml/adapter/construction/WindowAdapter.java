package org.citygml4j.xml.adapter.construction;

import org.citygml4j.model.ade.generic.GenericADEOfWindow;
import org.citygml4j.model.construction.ADEOfWindow;
import org.citygml4j.model.construction.Window;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.xmlobjects.annotation.XMLElement;
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

@XMLElement(name = "Window", namespaceURI = CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE)
public class WindowAdapter extends AbstractFillingElementAdapter<Window> {

    @Override
    public Window createObject(QName name) throws ObjectBuildException {
        return new Window();
    }

    @Override
    public void buildChildObject(Window object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE.equals(name.getNamespaceURI())) {
            if (CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
                return;
            else if ("adeOfWindow".equals(name.getLocalPart())) {
                ADEBuilderHelper.addADEContainer(ADEOfWindow.class, object.getADEOfWindow(), GenericADEOfWindow::new, reader);
                return;
            }
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(Window object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "Window");
    }

    @Override
    public void writeChildElements(Window object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        CityGMLSerializerHelper.serializeStandardObjectClassifier(object, CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, namespaces, writer);

        for (ADEOfWindow container : object.getADEOfWindow())
            ADESerializerHelper.writeADEContainer(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "adeOfWindow"), container, namespaces, writer);
    }
}
