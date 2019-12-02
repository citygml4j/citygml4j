package org.citygml4j.xml.module.citygml;

import org.citygml4j.model.CityGMLVersion;
import org.citygml4j.xml.module.Module;
import org.citygml4j.xml.module.gml.GMLBaseModule;
import org.citygml4j.xml.module.gml.XLinkModule;
import org.citygml4j.xml.module.xal.XALBaseModule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                GMLBaseModule.v3_2,
                XLinkModule.INSTANCE,
                XALBaseModule.v2_0
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
                GMLBaseModule.v3_1,
                XLinkModule.INSTANCE,
                XALBaseModule.v2_0
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
                GMLBaseModule.v3_1,
                XLinkModule.INSTANCE,
                XALBaseModule.v2_0
        );
    }

    private CityGMLModules(CityGMLVersion version, Module... modules) {
        this.version = version;
        for (Module module : modules)
            this.modules.put(module.getNamespaceURI(), module);
    }

    public static CityGMLModules of(CityGMLVersion version) {
        switch (version) {
            case v2_0:
                return v2_0;
            case v1_0:
                return v1_0;
            default:
                return v3_0;
        }
    }

    public static CityGMLModule getCityGMLModule(String namespaceURI) {
        for (CityGMLModules context : new CityGMLModules[] {v3_0, v2_0, v1_0}) {
            Module module = context.modules.get(namespaceURI);
            if (module instanceof CityGMLModule)
                return (CityGMLModule) module;
        }

        return null;
    }

    public List<Module> getModules() {
        return new ArrayList<>(modules.values());
    }

    public CityGMLVersion getCityGMLVersion() {
        return version;
    }
}
