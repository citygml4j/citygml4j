package org.citygml4j.xml.module.xal;

import org.citygml4j.xml.module.AbstractModule;
import org.xmlobjects.xal.util.XALConstants;

public class XALBaseModule extends AbstractModule implements XALModule {
    public static final XALBaseModule v2_0;

    static {
        v2_0 = new XALBaseModule(
                XALConstants.XAL_2_0_NAMESPACE,
                "xAL",
                "http://schemas.opengis.net/citygml/xAL/xAL.xsd"
        );
    }

    private XALBaseModule(String namespaceURI, String namespacePrefix, String schemaLocation) {
        super(namespaceURI, namespacePrefix, schemaLocation);
    }
}
