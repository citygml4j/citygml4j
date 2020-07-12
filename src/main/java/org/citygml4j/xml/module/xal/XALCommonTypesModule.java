package org.citygml4j.xml.module.xal;

import org.xmlobjects.xal.util.XALConstants;

public class XALCommonTypesModule extends XALModule {
    public static final XALCommonTypesModule v3_0;

    static {
        v3_0 = new XALCommonTypesModule(
                XALConstants.XAL_3_0_CT_NAMESPACE,
                "ct",
                "http://docs.oasis-open.org/ciq/v3.0/cs02/xsd/default/xsd/CommonTypes.xsd"
        );
    }

    private XALCommonTypesModule(String namespaceURI, String namespacePrefix, String schemaLocation) {
        super(namespaceURI, namespacePrefix, schemaLocation);
    }
}
