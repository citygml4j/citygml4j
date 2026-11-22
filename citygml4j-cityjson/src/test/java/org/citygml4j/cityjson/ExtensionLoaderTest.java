/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson;

import org.citygml4j.cityjson.extension.Extension;
import org.citygml4j.cityjson.model.CityJSONVersion;
import org.citygml4j.core.ade.ADEException;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ExtensionLoaderTest {

    private static Extension extension(String name, CityJSONVersion version) {
        return new Extension() {
            @Override
            public String getSchemaLocation() {
                return "https://example.org/" + name + ".ext.json";
            }

            @Override
            public CityJSONVersion getCityJSONVersion() {
                return version;
            }

            @Override
            public String getName() {
                return name;
            }

            @Override
            public String getVersion() {
                return "1.0";
            }
        };
    }

    @Test
    void sameNameForOtherVersionKeepsBoth() throws Exception {
        ExtensionLoader loader = new ExtensionLoader();
        Extension v1 = extension("Noise", CityJSONVersion.v1_1);
        Extension v2 = extension("Noise", CityJSONVersion.v2_0);
        loader.loadADE(v1);
        loader.loadADE(v2);

        assertSame(v1, loader.getExtension("Noise", CityJSONVersion.v1_1));
        assertSame(v2, loader.getExtension("Noise", CityJSONVersion.v2_0));
        assertSame(v2, loader.getExtension("Noise"));
        assertEquals(2, loader.getExtensions().size());
        assertEquals(Set.of("Noise"), loader.getExtensionNames());
    }

    @Test
    void unloadingOneVersionKeepsTheOther() throws Exception {
        ExtensionLoader loader = new ExtensionLoader();
        Extension v1 = extension("Noise", CityJSONVersion.v1_1);
        Extension v2 = extension("Noise", CityJSONVersion.v2_0);
        loader.loadADE(v1);
        loader.loadADE(v2);

        loader.unloadADE(v1);

        assertNull(loader.getExtension("Noise", CityJSONVersion.v1_1));
        assertSame(v2, loader.getExtension("Noise", CityJSONVersion.v2_0));
    }

    @Test
    void unloadingUnregisteredInstanceKeepsRegisteredOne() throws Exception {
        ExtensionLoader loader = new ExtensionLoader();
        Extension registered = extension("Noise", CityJSONVersion.v2_0);
        loader.loadADE(registered);

        loader.unloadADE(extension("Noise", CityJSONVersion.v2_0));

        assertSame(registered, loader.getExtension("Noise", CityJSONVersion.v2_0));
    }

    @Test
    void sameNameAndVersionIsRejected() throws Exception {
        ExtensionLoader loader = new ExtensionLoader();
        loader.loadADE(extension("Noise", CityJSONVersion.v2_0));
        assertThrows(ADEException.class, () -> loader.loadADE(extension("Noise", CityJSONVersion.v2_0)));
    }
}
