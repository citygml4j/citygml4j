//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2015.02.20 um 10:38:51 PM CET 
//


package net.opengis.citygml.appearance._2;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

public class AppearancePropertyElement
    extends JAXBElement<AppearancePropertyType>
{

    protected final static QName NAME = new QName("http://www.opengis.net/citygml/appearance/2.0", "appearance");

    public AppearancePropertyElement(AppearancePropertyType value) {
        super(NAME, ((Class) AppearancePropertyType.class), null, value);
    }

    public AppearancePropertyElement() {
        super(NAME, ((Class) AppearancePropertyType.class), null, null);
    }

}
