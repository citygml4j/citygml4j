/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml;

import org.citygml4j.core.ade.ADEException;
import org.citygml4j.core.model.CityGMLVersion;
import org.citygml4j.xml.ade.CityGMLADE;
import org.citygml4j.xml.module.ade.ADEModule;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CityGMLADELoaderTest {

    private static ADEModule module(String namespaceURI, CityGMLVersion version) {
        return new ADEModule(namespaceURI, "test", version) {
        };
    }

    private static CityGMLADE ade(ADEModule... modules) {
        return new CityGMLADE() {
            @Override
            public List<ADEModule> getADEModules() {
                return List.of(modules);
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

    @Test
    void invalidModuleLeavesNoPartialRegistration() {
        CityGMLADELoader loader = new CityGMLADELoader();
        CityGMLADE ade = ade(module("urn:test:a", CityGMLVersion.v3_0), module("urn:test:b", null));

        assertThrows(ADEException.class, () -> loader.loadADE(ade));
        assertTrue(loader.getADEModules().isEmpty());
    }

    @Test
    void duplicateModuleWithinAdeIsRejected() {
        CityGMLADELoader loader = new CityGMLADELoader();
        CityGMLADE ade = ade(module("urn:test:a", CityGMLVersion.v3_0), module("urn:test:a", CityGMLVersion.v3_0));

        assertThrows(ADEException.class, () -> loader.loadADE(ade));
        assertTrue(loader.getADEModules().isEmpty());
    }

    @Test
    void conflictWithRegisteredModuleLeavesNoPartialRegistration() throws Exception {
        CityGMLADELoader loader = new CityGMLADELoader();
        loader.loadADE(ade(module("urn:test:b", CityGMLVersion.v3_0)));

        CityGMLADE ade = ade(module("urn:test:a", CityGMLVersion.v3_0), module("urn:test:b", CityGMLVersion.v3_0));
        assertThrows(ADEException.class, () -> loader.loadADE(ade));
        assertNull(loader.getADEModule("urn:test:a", CityGMLVersion.v3_0));
        assertEquals(1, loader.getADEModules().size());
    }
}
