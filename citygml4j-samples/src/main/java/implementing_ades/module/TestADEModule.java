/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package implementing_ades.module;

import org.citygml4j.core.model.CityGMLVersion;
import org.citygml4j.xml.module.ade.ADEModule;

import java.net.URL;

public class TestADEModule extends ADEModule {
    public static final String TESTADE_NAMESPACE = "http://www.citygml.org/ade/TestADE/2.0";

    public TestADEModule() {
        super(TESTADE_NAMESPACE, "test", CityGMLVersion.v3_0);
    }

    @Override
    public URL getSchemaResource() {
        return TestADEModule.class.getResource("/org/citygml4j/ade/testade/schemas/testADE.xsd");
    }
}
