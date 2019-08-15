package org.citygml4j.adapter.xml;

import com.sun.xml.xsom.XSElementDecl;
import com.sun.xml.xsom.XSSchemaSet;
import org.citygml4j.reader.xml.CityGMLInputFactory;
import org.citygml4j.reader.xml.MissingADESchemaException;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.schema.SchemaHandler;
import org.xmlobjects.schema.SchemaHandlerException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;

import javax.xml.namespace.QName;

public class CityGMLBuilderHelper {

    public static boolean isCityGMLGenericsNamespace(String namespaceURI) {
        return CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE.equals(namespaceURI)
                || CityGMLConstants.CITYGML_2_0_GENERICS_NAMESPACE.equals(namespaceURI)
                || CityGMLConstants.CITYGML_1_0_GENERICS_NAMESPACE.equals(namespaceURI);
    }

    public static boolean isCityGMLCoreNamespace(String namespaceURI) {
        return CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE.equals(namespaceURI)
                || CityGMLConstants.CITYGML_2_0_CORE_NAMESPACE.equals(namespaceURI)
                || CityGMLConstants.CITYGML_1_0_CORE_NAMESPACE.equals(namespaceURI);
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
}
