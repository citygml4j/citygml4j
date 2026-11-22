/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml;

import org.citygml4j.core.model.CityGMLVersion;
import org.citygml4j.xml.ade.CityGMLADE;
import org.citygml4j.xml.module.ade.ADEModule;
import org.citygml4j.xml.schema.CityGMLSchemaHandler;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CityGMLContextTest {

    @Test
    void defaultSchemaHandlerIsRebuiltAfterAdeChanges() throws Exception {
        CityGMLADE ade = new CityGMLADE() {
            private final List<ADEModule> modules = List.of(new ADEModule("urn:test:ade", "test", CityGMLVersion.v3_0) {
            });

            @Override
            public List<ADEModule> getADEModules() {
                return modules;
            }

            @Override
            public String getName() {
                return "test";
            }

            @Override
            public String getVersion() {
                return "1.0";
            }
        };

        CityGMLContext context = CityGMLContext.newInstance();
        CityGMLSchemaHandler before = context.getDefaultSchemaHandler();
        assertSame(before, context.getDefaultSchemaHandler());

        context.loadADE(ade);
        CityGMLSchemaHandler afterLoad = context.getDefaultSchemaHandler();
        assertNotSame(before, afterLoad);

        context.unloadADE(ade);
        assertNotSame(afterLoad, context.getDefaultSchemaHandler());
    }
}
