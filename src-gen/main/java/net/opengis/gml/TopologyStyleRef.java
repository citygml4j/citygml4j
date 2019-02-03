//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.02.03 um 11:14:53 PM CET 
//


package net.opengis.gml;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

public class TopologyStyleRef
    extends JAXBElement<TopologyStylePropertyType>
{

    protected final static QName NAME = new QName("http://www.opengis.net/gml", "topologyStyle");

    public TopologyStyleRef(TopologyStylePropertyType value) {
        super(NAME, ((Class) TopologyStylePropertyType.class), null, value);
    }

    public TopologyStyleRef() {
        super(NAME, ((Class) TopologyStylePropertyType.class), null, null);
    }

}
