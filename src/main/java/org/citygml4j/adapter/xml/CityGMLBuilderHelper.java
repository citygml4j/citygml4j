package org.citygml4j.adapter.xml;

import com.sun.xml.xsom.XSElementDecl;
import com.sun.xml.xsom.XSSchemaSet;
import org.citygml4j.model.core.StandardObjectClassifier;
import org.citygml4j.reader.xml.CityGMLInputFactory;
import org.citygml4j.reader.xml.MissingADESchemaException;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.basictypes.CodeAdapter;
import org.xmlobjects.schema.SchemaHandler;
import org.xmlobjects.schema.SchemaHandlerException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;

import javax.xml.namespace.QName;

public class CityGMLBuilderHelper {

    public static boolean isCityGMLBuildingNamespace(String namespaceURI) {
        return CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE.equals(namespaceURI)
                || CityGMLConstants.CITYGML_2_0_BUILDING_NAMESPACE.equals(namespaceURI)
                || CityGMLConstants.CITYGML_1_0_BUILDING_NAMESPACE.equals(namespaceURI);
    }

    public static boolean isCityGMLLandUseNamespace(String namespaceURI) {
        return CityGMLConstants.CITYGML_3_0_LANDUSE_NAMESPACE.equals(namespaceURI)
                || CityGMLConstants.CITYGML_2_0_LANDUSE_NAMESPACE.equals(namespaceURI)
                || CityGMLConstants.CITYGML_1_0_LANDUSE_NAMESPACE.equals(namespaceURI);
    }

    public static boolean isCityGMLGenericsNamespace(String namespaceURI) {
        return CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE.equals(namespaceURI)
                || CityGMLConstants.CITYGML_2_0_GENERICS_NAMESPACE.equals(namespaceURI)
                || CityGMLConstants.CITYGML_1_0_GENERICS_NAMESPACE.equals(namespaceURI);
    }

    public static boolean isCityGMLAppearanceNamespace(String namespaceURI) {
        return CityGMLConstants.CITYGML_3_0_APPEARANCE_NAMESPACE.equals(namespaceURI)
                || CityGMLConstants.CITYGML_2_0_APPEARANCE_NAMESPACE.equals(namespaceURI)
                || CityGMLConstants.CITYGML_1_0_APPEARANCE_NAMESPACE.equals(namespaceURI);
    }

    public static boolean isCityGMLCoreNamespace(String namespaceURI) {
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

    public static boolean createAsGenericADEProperty(QName name, XMLReader reader, QName... substitutionGroups) throws XMLReadException {
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
