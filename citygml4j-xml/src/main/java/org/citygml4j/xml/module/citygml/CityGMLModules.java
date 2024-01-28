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

package org.citygml4j.xml.module.citygml;

import org.citygml4j.core.ade.ADERegistry;
import org.citygml4j.core.model.CityGMLVersion;
import org.citygml4j.xml.CityGMLADELoader;
import org.citygml4j.xml.module.Module;
import org.citygml4j.xml.module.gml.GMLCoreModule;
import org.citygml4j.xml.module.gml.XLinkModule;
import org.citygml4j.xml.module.xal.XALCommonTypesModule;
import org.citygml4j.xml.module.xal.XALCoreModule;

import java.util.*;
import java.util.stream.Collectors;

public class CityGMLModules {
    public static final CityGMLModules v3_0;
    public static final CityGMLModules v2_0;
    public static final CityGMLModules v1_0;

    private final Map<String, Module> modules = new HashMap<>();
    private final CityGMLVersion version;

    static {
        v3_0 = new CityGMLModules(
                CityGMLVersion.v3_0,
                AppearanceModule.v3_0,
                BridgeModule.v3_0,
                BuildingModule.v3_0,
                CityFurnitureModule.v3_0,
                CityObjectGroupModule.v3_0,
                ConstructionModule.v3_0,
                CoreModule.v3_0,
                DynamizerModule.v3_0,
                GenericsModule.v3_0,
                LandUseModule.v3_0,
                PointCloudModule.v3_0,
                ReliefModule.v3_0,
                TransportationModule.v3_0,
                TunnelModule.v3_0,
                VegetationModule.v3_0,
                VersioningModule.v3_0,
                WaterBodyModule.v3_0,
                GMLCoreModule.v3_2,
                XLinkModule.v1_0,
                XALCoreModule.v3_0,
                XALCommonTypesModule.v3_0
        );

        v2_0 = new CityGMLModules(
                CityGMLVersion.v2_0,
                AppearanceModule.v2_0,
                BridgeModule.v2_0,
                BuildingModule.v2_0,
                CityFurnitureModule.v2_0,
                CityObjectGroupModule.v2_0,
                CoreModule.v2_0,
                GenericsModule.v2_0,
                LandUseModule.v2_0,
                ReliefModule.v2_0,
                TransportationModule.v2_0,
                TunnelModule.v2_0,
                VegetationModule.v2_0,
                WaterBodyModule.v2_0,
                GMLCoreModule.v3_1,
                XLinkModule.v1_0,
                XALCoreModule.v2_0
        );

        v1_0 = new CityGMLModules(
                CityGMLVersion.v1_0,
                AppearanceModule.v1_0,
                BuildingModule.v1_0,
                CityFurnitureModule.v1_0,
                CityObjectGroupModule.v1_0,
                CoreModule.v1_0,
                GenericsModule.v1_0,
                LandUseModule.v1_0,
                ReliefModule.v1_0,
                TransportationModule.v1_0,
                VegetationModule.v1_0,
                WaterBodyModule.v1_0,
                GMLCoreModule.v3_1,
                XLinkModule.v1_0,
                XALCoreModule.v2_0
        );
    }

    private CityGMLModules(CityGMLVersion version, Module... modules) {
        this.version = version;
        for (Module module : modules) {
            this.modules.put(module.getNamespaceURI(), module);
        }
    }

    public static List<CityGMLModules> all() {
        return List.of(v3_0, v2_0, v1_0);
    }

    public static CityGMLModules of(CityGMLVersion version) {
        return switch (version) {
            case v2_0 -> v2_0;
            case v1_0 -> v1_0;
            default -> v3_0;
        };
    }

    public static CityGMLModules of(String namespaceURI) {
        for (CityGMLModules context : all()) {
            Module module = context.getModule(namespaceURI);
            if (module != null) {
                return context;
            }
        }

        return null;
    }

    public static CityGMLVersion getCityGMLVersion(String namespaceURI) {
        CityGMLModules context = of(namespaceURI);
        return context != null ? context.getCityGMLVersion() : null;
    }

    public static Module getModuleFor(String namespaceURI) {
        for (CityGMLModules context : all()) {
            Module module = context.getModule(namespaceURI);
            if (module != null) {
                return module;
            }
        }

        return null;
    }

    public static <T extends Module> T getModuleFor(String namespaceURI, Class<T> type) {
        Module module = getModuleFor(namespaceURI);
        return type.isInstance(module) ? type.cast(module) : null;
    }

    public static boolean isCityGMLNamespace(String namespaceURI) {
        return namespaceURI != null && namespaceURI.startsWith("http://www.opengis.net/citygml");
    }

    public static boolean isCityGMLNamespace(String namespaceURI, CityGMLVersion version) {
        return isCityGMLNamespace(namespaceURI) && of(version).modules.containsKey(namespaceURI);
    }

    public static boolean isGMLNamespace(String namespaceURI) {
        return namespaceURI != null && namespaceURI.startsWith("http://www.opengis.net/gml");
    }

    public static boolean isXALNamespace(String namespaceURI) {
        return namespaceURI != null && namespaceURI.startsWith("urn:oasis:names:tc:ciq");
    }

    public List<Module> getModules() {
        List<Module> modules = new ArrayList<>(this.modules.values());
        modules.addAll(getCityGMLADELoader().getADEModules(version));
        return modules;
    }

    public Module getModule(String namespaceURI) {
        Module module = modules.get(namespaceURI);
        if (module == null) {
            module = getCityGMLADELoader().getADEModule(namespaceURI, version);
        }

        return module;
    }

    public <T extends Module> T getModule(Class<T> type) {
        for (Module module : getModules()) {
            if (type.isInstance(module)) {
                return type.cast(module);
            }
        }

        return null;
    }

    public Set<String> getNamespaces() {
        return getModules().stream()
                .map(Module::getNamespaceURI)
                .collect(Collectors.toSet());
    }

    public CityGMLVersion getCityGMLVersion() {
        return version;
    }

    private CityGMLADELoader getCityGMLADELoader() {
        return ADERegistry.getInstance().getADELoader(CityGMLADELoader.class);
    }
}
