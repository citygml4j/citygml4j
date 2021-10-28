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

package generic_ade_handling;

import com.sun.xml.xsom.XSElementDecl;
import com.sun.xml.xsom.XSSchemaSet;
import com.sun.xml.xsom.XSType;
import helpers.Logger;
import helpers.Util;
import org.citygml4j.CityGMLContext;
import org.citygml4j.model.ade.ADEContainer;
import org.citygml4j.model.ade.generic.ADEGenericContainer;
import org.citygml4j.model.building.Building;
import org.citygml4j.model.core.AbstractCityObject;
import org.citygml4j.model.core.AbstractCityObjectProperty;
import org.citygml4j.model.core.CityModel;
import org.citygml4j.xml.module.citygml.CoreModule;
import org.citygml4j.xml.module.gml.GMLCoreModule;
import org.citygml4j.xml.reader.CityGMLInputFactory;
import org.citygml4j.xml.reader.CityGMLReader;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xmlobjects.gml.model.common.GenericElement;
import org.xmlobjects.schema.SchemaHandler;

import java.nio.file.Path;

public class ReadingGenericADE {
    static Logger log = Logger.start(ReadingGenericADE.class);

    public static void main(String[] args) throws Exception {
        CityGMLContext context = CityGMLContext.newInstance();

        CityGMLInputFactory in = context.createCityGMLInputFactory()
                .createGenericADEContent(true);

        Path file = Util.SAMPLE_DATA_DIR.resolve("lod2_test_ade_v2.gml");
        log.print("Reading the TestADE file " + file + " into main memory");

        CityModel cityModel;
        try (CityGMLReader reader = in.createCityGMLReader(file)) {
            cityModel = (CityModel) reader.next();
        }

        SchemaHandler handler = in.getSchemaHandler();

        XSSchemaSet schemas = handler.getSchemaSet(CoreModule.v2_0.getNamespaceURI());
        XSType cityObjectType = schemas.getType(CoreModule.v2_0.getNamespaceURI(), "AbstractCityObjectType");
        XSType featureType = schemas.getType(GMLCoreModule.v3_1.getNamespaceURI(), "AbstractFeatureType");
        XSType geometryType = schemas.getType(GMLCoreModule.v3_1.getNamespaceURI(), "AbstractGeometryType");

        log.print("Iterating over the city object members");
        for (AbstractCityObjectProperty member : cityModel.getCityObjectMembers()) {
            if (member.isSetObject()) {
                AbstractCityObject cityObject = member.getObject();
                log.print("Found " + cityObject.getClass().getSimpleName() + " with gml:id " + cityObject.getId());

                if (cityObject instanceof Building) {
                    Building building = (Building) cityObject;
                    for (ADEContainer container : building.getADEOfAbstractBuilding()) {
                        if (container instanceof ADEGenericContainer) {
                            Element element = ((ADEGenericContainer) container).getValue();
                            log.print(indent(2) + "- with ADE property " + element.getLocalName() + " {" + element.getNamespaceURI() + "}");
                            printADEInfo(handler, element, cityObjectType, featureType, geometryType, 5);
                        }
                    }
                }
            } else if (member.isSetGenericElement()) {
                GenericElement genericElement = member.getGenericElement();
                log.print("Found ADE feature " + genericElement.getLocalName() + " {" + genericElement.getNamespaceURI() + "}");
                printADEInfo(handler, genericElement.getContent(), cityObjectType, featureType, geometryType, 2);
            }
        }

        log.finish();
    }

    static void printADEInfo(SchemaHandler handler, Element element, XSType cityObjectType, XSType featureType, XSType geometryType, int level) {
        StringBuilder builder = new StringBuilder(indent(level) + element.getLocalName());

        XSSchemaSet schemas = handler.getSchemaSet(element.getNamespaceURI());
        XSElementDecl elementDecl = schemas.getElementDecl(element.getNamespaceURI(), element.getLocalName());
        if (elementDecl != null) {
            XSType type = elementDecl.getType();
            if (type.isDerivedFrom(cityObjectType))
                builder.append(" [CityObject]");
            else if (type.isDerivedFrom(featureType))
                builder.append(" [Feature]");
            else if (type.isDerivedFrom(geometryType))
                builder.append(" [Geometry]");
        }

        NodeList children = element.getChildNodes();
        if (children.getLength() > 1) {
            log.print(builder.toString());
            for (int i = 0; i < children.getLength(); i++) {
                Node child = children.item(i);
                if (child.getNodeType() == Node.ELEMENT_NODE)
                    printADEInfo(handler, (Element) child, cityObjectType, featureType, geometryType, level + 1);
            }
        } else {
            if (element.getFirstChild().getNodeType() == Node.TEXT_NODE)
                builder.append(": ").append(element.getFirstChild().getNodeValue());

            log.print(builder.toString());
        }
    }

    static String indent(int level) {
        StringBuilder builder = new StringBuilder();
        while (level-- > 0)
            builder.append(" ");

        return builder.toString();
    }
}
