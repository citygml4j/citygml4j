//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.02.22 um 01:15:44 PM CET 
//


package net.opengis.gml;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

public class LabelStyleRef
    extends JAXBElement<LabelStylePropertyType>
{

    protected final static QName NAME = new QName("http://www.opengis.net/gml", "labelStyle");

    public LabelStyleRef(LabelStylePropertyType value) {
        super(NAME, ((Class) LabelStylePropertyType.class), null, value);
    }

    public LabelStyleRef() {
        super(NAME, ((Class) LabelStylePropertyType.class), null, null);
    }

}
