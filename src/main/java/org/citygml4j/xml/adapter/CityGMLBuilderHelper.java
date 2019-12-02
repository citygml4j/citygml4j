package org.citygml4j.xml.adapter;

import com.sun.xml.xsom.XSElementDecl;
import com.sun.xml.xsom.XSSchemaSet;
import org.citygml4j.model.core.AbstractSpace;
import org.citygml4j.model.core.StandardObjectClassifier;
import org.citygml4j.xml.reader.CityGMLInputFactory;
import org.citygml4j.xml.reader.MissingADESchemaException;
import org.citygml4j.util.CityGMLConstants;
import org.w3c.dom.Element;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.basictypes.CodeAdapter;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;
import org.xmlobjects.gml.model.geometry.GeometryProperty;
import org.xmlobjects.gml.model.geometry.aggregates.MultiCurve;
import org.xmlobjects.gml.model.geometry.aggregates.MultiCurveProperty;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSolid;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurface;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurfaceProperty;
import org.xmlobjects.gml.model.geometry.primitives.AbstractSolid;
import org.xmlobjects.gml.model.geometry.primitives.SolidProperty;
import org.xmlobjects.schema.SchemaHandler;
import org.xmlobjects.schema.SchemaHandlerException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

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
            if (geometry instanceof AbstractSolid)
                return object.setSolid(lod, new SolidProperty((AbstractSolid) geometry));
            else if (geometry instanceof MultiSurface)
                return object.setMultiSurface(lod, new MultiSurfaceProperty((MultiSurface) geometry));
            else if (geometry instanceof MultiCurve)
                return object.setMultiCurve(lod, new MultiCurveProperty((MultiCurve) geometry));
            else if (geometry instanceof MultiSolid) {
                MultiSolid multiSolid = (MultiSolid) geometry;

                List<SolidProperty> properties = new ArrayList<>(multiSolid.getSolidMember());
                if (multiSolid.getSolidMembers() != null) {
                    for (AbstractSolid solid : multiSolid.getSolidMembers().getObjects())
                        properties.add(new SolidProperty(solid));
                }

                if (properties.size() == 1)
                    return object.setSolid(lod, properties.get(0));
            }
        }

        return false;
    }

    @SuppressWarnings("unchecked")
    public static <T> boolean addADEProperty(QName name, Class<? super T> type, List<? super T> properties, Function<Element, T> creator, XMLReader reader, QName... substitutionGroups) throws ObjectBuildException, XMLReadException {
        ObjectBuilder<? super T> builder = reader.getXMLObjects().getBuilder(name, type);
        if (builder != null) {
            properties.add((T) reader.getObjectUsingBuilder(builder));
            return true;
        } else if (CityGMLBuilderHelper.substitutes(name, reader, substitutionGroups)) {
            properties.add(creator.apply(reader.getDOMElement()));
            return true;
        }

        return false;
    }

    public static boolean substitutes(QName name, XMLReader reader, QName... substitutionGroups) throws XMLReadException {
        if (reader.isCreateDOMAsFallback() && reader.getSchemaHandler() != null) {
            try {
                SchemaHandler schemaHandler = reader.getSchemaHandler();
                schemaHandler.resolveAndParseSchema(name.getNamespaceURI());

                XSSchemaSet schemas = schemaHandler.getSchemaSet(name.getNamespaceURI());
                XSElementDecl element = schemas.getElementDecl(name.getNamespaceURI(), name.getLocalPart());
                if (element != null) {
                    XSElementDecl head = null;
                    while ((element = element.getSubstAffiliation()) != null)
                        head = element;

                    if (head != null) {
                        for (QName substitutionGroup : substitutionGroups) {
                            if (substitutionGroup.getNamespaceURI().equals(head.getTargetNamespace())
                                    && substitutionGroup.getLocalPart().equals(head.getName()))
                                return true;
                        }
                    }
                }
            } catch (SchemaHandlerException e) {
                if (reader.getProperties().getAndCompare(CityGMLInputFactory.FAIL_ON_MISSING_ADE_SCHEMA, true))
                    throw new MissingADESchemaException("Failed to load ADE schema document for target namespace '" + name.getNamespaceURI() + "'.", e);
            }
        }

        return false;
    }

    public static boolean isADENamespace(String namespaceURI) {
        return !namespaceURI.startsWith("http://www.opengis.net");
    }
}
