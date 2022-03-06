/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2021 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.xml.adapter;

import org.citygml4j.core.model.core.AbstractSpace;
import org.citygml4j.core.model.core.StandardObjectClassifier;
import org.citygml4j.core.util.CityGMLConstants;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.basictypes.CodeAdapter;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;
import org.xmlobjects.gml.model.geometry.GeometryProperty;
import org.xmlobjects.gml.model.geometry.aggregates.*;
import org.xmlobjects.gml.model.geometry.primitives.*;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;

public class CityGMLBuilderHelper {

    public static boolean isBridgeNamespace(String namespaceURI) {
        return CityGMLConstants.CITYGML_3_0_BRIDGE_NAMESPACE.equals(namespaceURI)
                || CityGMLConstants.CITYGML_2_0_BRIDGE_NAMESPACE.equals(namespaceURI);
    }

    public static boolean isBuildingNamespace(String namespaceURI) {
        return CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE.equals(namespaceURI)
                || CityGMLConstants.CITYGML_2_0_BUILDING_NAMESPACE.equals(namespaceURI)
                || CityGMLConstants.CITYGML_1_0_BUILDING_NAMESPACE.equals(namespaceURI);
    }

    public static boolean isCityFurnitureNamespace(String namespaceURI) {
        return CityGMLConstants.CITYGML_3_0_CITYFURNITURE_NAMESPACE.equals(namespaceURI)
                || CityGMLConstants.CITYGML_2_0_CITYFURNITURE_NAMESPACE.equals(namespaceURI)
                || CityGMLConstants.CITYGML_1_0_CITYFURNITURE_NAMESPACE.equals(namespaceURI);
    }

    public static boolean isCityObjectGroupNamespace(String namespaceURI) {
        return CityGMLConstants.CITYGML_3_0_CITYOBJECTGROUP_NAMESPACE.equals(namespaceURI)
                || CityGMLConstants.CITYGML_2_0_CITYOBJECTGROUP_NAMESPACE.equals(namespaceURI)
                || CityGMLConstants.CITYGML_1_0_CITYOBJECTGROUP_NAMESPACE.equals(namespaceURI);
    }

    public static boolean isLandUseNamespace(String namespaceURI) {
        return CityGMLConstants.CITYGML_3_0_LANDUSE_NAMESPACE.equals(namespaceURI)
                || CityGMLConstants.CITYGML_2_0_LANDUSE_NAMESPACE.equals(namespaceURI)
                || CityGMLConstants.CITYGML_1_0_LANDUSE_NAMESPACE.equals(namespaceURI);
    }

    public static boolean isReliefNamespace(String namespaceURI) {
        return CityGMLConstants.CITYGML_3_0_RELIEF_NAMESPACE.equals(namespaceURI)
                || CityGMLConstants.CITYGML_2_0_RELIEF_NAMESPACE.equals(namespaceURI)
                || CityGMLConstants.CITYGML_1_0_RELIEF_NAMESPACE.equals(namespaceURI);
    }

    public static boolean isTransportationNamespace(String namespaceURI) {
        return CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE.equals(namespaceURI)
                || CityGMLConstants.CITYGML_2_0_TRANSPORTATION_NAMESPACE.equals(namespaceURI)
                || CityGMLConstants.CITYGML_1_0_TRANSPORTATION_NAMESPACE.equals(namespaceURI);
    }

    public static boolean isTunnelNamespace(String namespaceURI) {
        return CityGMLConstants.CITYGML_3_0_TUNNEL_NAMESPACE.equals(namespaceURI)
                || CityGMLConstants.CITYGML_2_0_TUNNEL_NAMESPACE.equals(namespaceURI);
    }

    public static boolean isVegetationNamespace(String namespaceURI) {
        return CityGMLConstants.CITYGML_3_0_VEGETATION_NAMESPACE.equals(namespaceURI)
                || CityGMLConstants.CITYGML_2_0_VEGETATION_NAMESPACE.equals(namespaceURI)
                || CityGMLConstants.CITYGML_1_0_VEGETATION_NAMESPACE.equals(namespaceURI);
    }

    public static boolean isWaterBodyNamespace(String namespaceURI) {
        return CityGMLConstants.CITYGML_3_0_WATERBODY_NAMESPACE.equals(namespaceURI)
                || CityGMLConstants.CITYGML_2_0_WATERBODY_NAMESPACE.equals(namespaceURI)
                || CityGMLConstants.CITYGML_1_0_WATERBODY_NAMESPACE.equals(namespaceURI);
    }

    public static boolean isGenericsNamespace(String namespaceURI) {
        return CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE.equals(namespaceURI)
                || CityGMLConstants.CITYGML_2_0_GENERICS_NAMESPACE.equals(namespaceURI)
                || CityGMLConstants.CITYGML_1_0_GENERICS_NAMESPACE.equals(namespaceURI);
    }

    public static boolean isAppearanceNamespace(String namespaceURI) {
        return CityGMLConstants.CITYGML_3_0_APPEARANCE_NAMESPACE.equals(namespaceURI)
                || CityGMLConstants.CITYGML_2_0_APPEARANCE_NAMESPACE.equals(namespaceURI)
                || CityGMLConstants.CITYGML_1_0_APPEARANCE_NAMESPACE.equals(namespaceURI);
    }

    public static boolean isCoreNamespace(String namespaceURI) {
        return CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE.equals(namespaceURI)
                || CityGMLConstants.CITYGML_2_0_CORE_NAMESPACE.equals(namespaceURI)
                || CityGMLConstants.CITYGML_1_0_CORE_NAMESPACE.equals(namespaceURI);
    }

    public static boolean buildStandardObjectClassifier(StandardObjectClassifier object, String localName, XMLReader reader) throws ObjectBuildException, XMLReadException {
        switch (localName) {
            case "class":
                object.setClassifier(reader.getObjectUsingBuilder(CodeAdapter.class));
                return true;
            case "function":
                object.getFunctions().add(reader.getObjectUsingBuilder(CodeAdapter.class));
                return true;
            case "usage":
                object.getUsages().add(reader.getObjectUsingBuilder(CodeAdapter.class));
                return true;
            default:
                return false;
        }
    }

    public static boolean assignDefaultGeometry(AbstractSpace object, int lod, GeometryProperty<?> property) {
        if (property != null && property.getObject() != null) {
            AbstractGeometry geometry = property.getObject();
            if (geometry instanceof AbstractSolid) {
                return object.setSolid(lod, new SolidProperty((AbstractSolid) geometry));
            } else if (geometry instanceof MultiSurface) {
                return object.setMultiSurface(lod, new MultiSurfaceProperty((MultiSurface) geometry));
            } else if (geometry instanceof AbstractSurface) {
                MultiSurface multiSurface = new MultiSurface();
                multiSurface.getSurfaceMember().add(new SurfaceProperty((AbstractSurface) geometry));
                return object.setMultiSurface(lod, new MultiSurfaceProperty(multiSurface));
            } else if (geometry instanceof MultiCurve) {
                return object.setMultiCurve(lod, new MultiCurveProperty((MultiCurve) geometry));
            } else if (geometry instanceof AbstractCurve) {
                MultiCurve multiCurve = new MultiCurve();
                multiCurve.getCurveMember().add(new CurveProperty((AbstractCurve) geometry));
                return object.setMultiCurve(lod, new MultiCurveProperty(multiCurve));
            } else if (geometry instanceof MultiSolid) {
                MultiSolid multiSolid = (MultiSolid) geometry;

                SolidProperty solidProperty = null;
                if (multiSolid.isSetSolidMember()) {
                    solidProperty = multiSolid.getSolidMember().get(0);
                } else if (multiSolid.getSolidMembers() != null && multiSolid.getSolidMembers().isSetObjects()) {
                    solidProperty = new SolidProperty(multiSolid.getSolidMembers().getObjects().get(0));
                }

                if (solidProperty != null) {
                    return object.setSolid(lod, solidProperty);
                }
            }
        }

        return false;
    }

    public static boolean isADENamespace(String namespaceURI) {
        return !namespaceURI.startsWith("http://www.opengis.net");
    }
}
