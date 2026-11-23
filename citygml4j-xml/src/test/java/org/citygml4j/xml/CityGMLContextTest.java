/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml;

import org.citygml4j.core.model.CityGMLVersion;
import org.citygml4j.xml.ade.CityGMLADE;
import org.citygml4j.xml.module.ade.ADEModule;
import org.citygml4j.xml.reader.CityGMLInputFactory;
import org.citygml4j.xml.reader.CityGMLReader;
import org.citygml4j.xml.schema.CityGMLSchemaHandler;
import org.junit.jupiter.api.Test;

import java.io.StringReader;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CityGMLContextTest {

    private CityGMLADE testADE() {
        return new CityGMLADE() {
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
    }

    private CityGMLSchemaHandler readerSchemaHandler(CityGMLInputFactory in) throws Exception {
        try (CityGMLReader reader = in.createCityGMLReader(new StringReader(
                "<core:CityModel xmlns:core=\"http://www.opengis.net/citygml/3.0\"/>"))) {
            return in.getSchemaHandler();
        }
    }

    @Test
    void defaultSchemaHandlerIsRebuiltAfterAdeChanges() throws Exception {
        CityGMLADE ade = testADE();
        CityGMLContext context = CityGMLContext.newInstance();
        CityGMLSchemaHandler before = context.getDefaultSchemaHandler();
        assertSame(before, context.getDefaultSchemaHandler());

        context.loadADE(ade);
        CityGMLSchemaHandler afterLoad = context.getDefaultSchemaHandler();
        assertNotSame(before, afterLoad);

        context.unloadADE(ade);
        assertNotSame(afterLoad, context.getDefaultSchemaHandler());
    }

    @Test
    void inputFactoryUsesCurrentDefaultSchemaHandler() throws Exception {
        CityGMLADE ade = testADE();
        CityGMLContext context = CityGMLContext.newInstance();
        CityGMLInputFactory in = context.createCityGMLInputFactory().createGenericADEContent(true);

        assertSame(context.getDefaultSchemaHandler(), readerSchemaHandler(in));

        context.loadADE(ade);
        try {
            CityGMLSchemaHandler current = context.getDefaultSchemaHandler();
            assertSame(current, readerSchemaHandler(in));
        } finally {
            context.unloadADE(ade);
        }
    }

    @Test
    void inputFactoryKeepsUserSchemaHandler() throws Exception {
        CityGMLADE ade = testADE();
        CityGMLContext context = CityGMLContext.newInstance();
        CityGMLSchemaHandler handler = CityGMLSchemaHandler.newInstance();
        CityGMLInputFactory in = context.createCityGMLInputFactory()
                .createGenericADEContent(true)
                .withSchemaHandler(handler);

        context.loadADE(ade);
        try {
            assertSame(handler, readerSchemaHandler(in));
        } finally {
            context.unloadADE(ade);
        }
    }
}
