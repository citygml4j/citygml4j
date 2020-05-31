package org.citygml4j.xml.adapter;

import org.citygml4j.model.core.AbstractSpace;
import org.citygml4j.model.core.StandardObjectClassifier;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.gml.adapter.basictypes.CodeAdapter;
import org.xmlobjects.gml.adapter.geometry.aggregates.MultiCurvePropertyAdapter;
import org.xmlobjects.gml.adapter.geometry.aggregates.MultiSurfacePropertyAdapter;
import org.xmlobjects.gml.adapter.geometry.primitives.SolidPropertyAdapter;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

public class CityGMLSerializerHelper {

    public static String getBridgeNamespace(Namespaces namespaces) {
        if (namespaces.contains(CityGMLConstants.CITYGML_2_0_BRIDGE_NAMESPACE))
            return CityGMLConstants.CITYGML_2_0_BRIDGE_NAMESPACE;
        else
            return CityGMLConstants.CITYGML_3_0_BRIDGE_NAMESPACE;
    }

    public static String getBuildingNamespace(Namespaces namespaces) {
        if (namespaces.contains(CityGMLConstants.CITYGML_1_0_BUILDING_NAMESPACE))
            return CityGMLConstants.CITYGML_1_0_BUILDING_NAMESPACE;
        else if (namespaces.contains(CityGMLConstants.CITYGML_2_0_BUILDING_NAMESPACE))
            return CityGMLConstants.CITYGML_2_0_BUILDING_NAMESPACE;
        else
            return CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE;
    }

    public static String getCityFurnitureNamespace(Namespaces namespaces) {
        if (namespaces.contains(CityGMLConstants.CITYGML_1_0_CITYFURNITURE_NAMESPACE))
            return CityGMLConstants.CITYGML_1_0_CITYFURNITURE_NAMESPACE;
        else if (namespaces.contains(CityGMLConstants.CITYGML_2_0_CITYFURNITURE_NAMESPACE))
            return CityGMLConstants.CITYGML_2_0_CITYFURNITURE_NAMESPACE;
        else
            return CityGMLConstants.CITYGML_3_0_CITYFURNITURE_NAMESPACE;
    }

    public static String getCityObjectGroupNamespace(Namespaces namespaces) {
        if (namespaces.contains(CityGMLConstants.CITYGML_1_0_CITYOBJECTGROUP_NAMESPACE))
            return CityGMLConstants.CITYGML_1_0_CITYOBJECTGROUP_NAMESPACE;
        else if (namespaces.contains(CityGMLConstants.CITYGML_2_0_CITYOBJECTGROUP_NAMESPACE))
            return CityGMLConstants.CITYGML_2_0_CITYOBJECTGROUP_NAMESPACE;
        else
            return CityGMLConstants.CITYGML_3_0_CITYOBJECTGROUP_NAMESPACE;
    }

    public static String getLandUseNamespace(Namespaces namespaces) {
        if (namespaces.contains(CityGMLConstants.CITYGML_1_0_LANDUSE_NAMESPACE))
            return CityGMLConstants.CITYGML_1_0_LANDUSE_NAMESPACE;
        else if (namespaces.contains(CityGMLConstants.CITYGML_2_0_LANDUSE_NAMESPACE))
            return CityGMLConstants.CITYGML_2_0_LANDUSE_NAMESPACE;
        else
            return CityGMLConstants.CITYGML_3_0_LANDUSE_NAMESPACE;
    }

    public static String getReliefNamespace(Namespaces namespaces) {
        if (namespaces.contains(CityGMLConstants.CITYGML_1_0_RELIEF_NAMESPACE))
            return CityGMLConstants.CITYGML_1_0_RELIEF_NAMESPACE;
        else if (namespaces.contains(CityGMLConstants.CITYGML_2_0_RELIEF_NAMESPACE))
            return CityGMLConstants.CITYGML_2_0_RELIEF_NAMESPACE;
        else
            return CityGMLConstants.CITYGML_3_0_RELIEF_NAMESPACE;
    }

    public static String getTransportationNamespace(Namespaces namespaces) {
        if (namespaces.contains(CityGMLConstants.CITYGML_1_0_TRANSPORTATION_NAMESPACE))
            return CityGMLConstants.CITYGML_1_0_TRANSPORTATION_NAMESPACE;
        else if (namespaces.contains(CityGMLConstants.CITYGML_2_0_TRANSPORTATION_NAMESPACE))
            return CityGMLConstants.CITYGML_2_0_TRANSPORTATION_NAMESPACE;
        else
            return CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE;
    }

    public static String getTunnelNamespace(Namespaces namespaces) {
        if (namespaces.contains(CityGMLConstants.CITYGML_2_0_TUNNEL_NAMESPACE))
            return CityGMLConstants.CITYGML_2_0_TUNNEL_NAMESPACE;
        else
            return CityGMLConstants.CITYGML_3_0_TUNNEL_NAMESPACE;
    }

    public static String getVegetationNamespace(Namespaces namespaces) {
        if (namespaces.contains(CityGMLConstants.CITYGML_1_0_VEGETATION_NAMESPACE))
            return CityGMLConstants.CITYGML_1_0_VEGETATION_NAMESPACE;
        else if (namespaces.contains(CityGMLConstants.CITYGML_2_0_VEGETATION_NAMESPACE))
            return CityGMLConstants.CITYGML_2_0_VEGETATION_NAMESPACE;
        else
            return CityGMLConstants.CITYGML_3_0_VEGETATION_NAMESPACE;
    }

    public static String getWaterBodyNamespace(Namespaces namespaces) {
        if (namespaces.contains(CityGMLConstants.CITYGML_1_0_WATERBODY_NAMESPACE))
            return CityGMLConstants.CITYGML_1_0_WATERBODY_NAMESPACE;
        else if (namespaces.contains(CityGMLConstants.CITYGML_2_0_WATERBODY_NAMESPACE))
            return CityGMLConstants.CITYGML_2_0_WATERBODY_NAMESPACE;
        else
            return CityGMLConstants.CITYGML_3_0_WATERBODY_NAMESPACE;
    }

    public static String getGenericsNamespace(Namespaces namespaces) {
        if (namespaces.contains(CityGMLConstants.CITYGML_1_0_GENERICS_NAMESPACE))
            return CityGMLConstants.CITYGML_1_0_GENERICS_NAMESPACE;
        else if (namespaces.contains(CityGMLConstants.CITYGML_2_0_GENERICS_NAMESPACE))
            return CityGMLConstants.CITYGML_2_0_GENERICS_NAMESPACE;
        else
            return CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE;
    }

    public static String getAppearanceNamespace(Namespaces namespaces) {
        if (namespaces.contains(CityGMLConstants.CITYGML_1_0_APPEARANCE_NAMESPACE))
            return CityGMLConstants.CITYGML_1_0_APPEARANCE_NAMESPACE;
        else if (namespaces.contains(CityGMLConstants.CITYGML_2_0_APPEARANCE_NAMESPACE))
            return CityGMLConstants.CITYGML_2_0_APPEARANCE_NAMESPACE;
        else
            return CityGMLConstants.CITYGML_3_0_APPEARANCE_NAMESPACE;
    }

    public static String getCoreNamespace(Namespaces namespaces) {
        if (namespaces.contains(CityGMLConstants.CITYGML_1_0_CORE_NAMESPACE))
            return CityGMLConstants.CITYGML_1_0_CORE_NAMESPACE;
        else if (namespaces.contains(CityGMLConstants.CITYGML_2_0_CORE_NAMESPACE))
            return CityGMLConstants.CITYGML_2_0_CORE_NAMESPACE;
        else
            return CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE;
    }

    public static void serializeStandardObjectClassifier(StandardObjectClassifier object, String namespaceURI, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.getClassifier() != null)
            writer.writeElementUsingSerializer(Element.of(namespaceURI, "class"), object.getClassifier(), CodeAdapter.class, namespaces);

        for (Code function : object.getFunctions())
            writer.writeElementUsingSerializer(Element.of(namespaceURI, "function"), function, CodeAdapter.class, namespaces);

        for (Code usage : object.getUsages())
            writer.writeElementUsingSerializer(Element.of(namespaceURI, "usage"), usage, CodeAdapter.class, namespaces);
    }

    public static boolean serializeDefaultGeometry(AbstractSpace object, int lod, String propertyName, String namespaceURI, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.getSolid(lod) != null) {
            writer.writeElementUsingSerializer(Element.of(namespaceURI, propertyName), object.getSolid(lod), SolidPropertyAdapter.class, namespaces);
            return true;
        } else if (object.getMultiSurface(lod) != null) {
            writer.writeElementUsingSerializer(Element.of(namespaceURI, propertyName), object.getMultiSurface(lod), MultiSurfacePropertyAdapter.class, namespaces);
            return true;
        } else if (object.getMultiCurve(lod) != null) {
            writer.writeElementUsingSerializer(Element.of(namespaceURI, propertyName), object.getMultiCurve(lod), MultiCurvePropertyAdapter.class, namespaces);
            return true;
        }

        return false;
    }
}
