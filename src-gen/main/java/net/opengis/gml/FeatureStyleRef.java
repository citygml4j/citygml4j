//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.gml;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

public class FeatureStyleRef
    extends JAXBElement<FeatureStylePropertyType>
{

    protected final static QName NAME = new QName("http://www.opengis.net/gml", "featureStyle");

    public FeatureStyleRef(FeatureStylePropertyType value) {
        super(NAME, ((Class) FeatureStylePropertyType.class), null, value);
    }

    public FeatureStyleRef() {
        super(NAME, ((Class) FeatureStylePropertyType.class), null, null);
    }

}
