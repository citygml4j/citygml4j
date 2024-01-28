/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2024 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
