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

package generic_ade_handling;

import helpers.Logger;
import helpers.Util;
import implementing_ades.module.TestADEModule;
import org.citygml4j.core.model.CityGMLVersion;
import org.citygml4j.core.model.ade.generic.GenericADEOfAbstractBuilding;
import org.citygml4j.core.model.building.Building;
import org.citygml4j.core.util.geometry.GeometryFactory;
import org.citygml4j.xml.CityGMLContext;
import org.citygml4j.xml.module.citygml.CityGMLModules;
import org.citygml4j.xml.module.citygml.CoreModule;
import org.citygml4j.xml.reader.ChunkOptions;
import org.citygml4j.xml.reader.CityGMLInputFactory;
import org.citygml4j.xml.reader.CityGMLReadException;
import org.citygml4j.xml.reader.CityGMLReader;
import org.citygml4j.xml.writer.CityGMLChunkWriter;
import org.citygml4j.xml.writer.CityGMLOutputFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xmlobjects.XMLObjects;
import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.geometry.primitives.Polygon;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.stream.XMLWriterFactory;
import org.xmlobjects.xml.Namespaces;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMResult;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class WritingGenericADE {

    public static void main(String[] args) throws Exception {
        Logger log = Logger.start(WritingGenericADE.class);

        CityGMLContext context = CityGMLContext.newInstance();

        CityGMLInputFactory in = context.createCityGMLInputFactory()
                .withChunking(ChunkOptions.defaults());

        Path file = Util.SAMPLE_DATA_DIR.resolve("lod2_buildings_v3.gml");
        log.print("Reading the first building from the file " + file + " by using a filtered reader");

        Building building;
        try (CityGMLReader reader = in.createFilteredCityGMLReader(in.createCityGMLReader(file),
                name -> name.getLocalPart().equals("Building"))) {
            if (reader.hasNext()) {
                building = (Building) reader.next();
                log.print("Found " + reader.getName().getLocalPart() + " with gml:id " + building.getId());
            } else
                throw new CityGMLReadException("Failed to read a building from file " + file);
        }

        log.print("Enriching the building with TestADE properties and features");
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        domFactory.setNamespaceAware(true);
        Document document = domFactory.newDocumentBuilder().newDocument();

        Element buildingProperties = document.createElementNS(TestADEModule.TESTADE_NAMESPACE, "BuildingProperties");
        building.addADEProperty(GenericADEOfAbstractBuilding.of(buildingProperties));

        log.print("Adding an owner name");
        buildingProperties
                .appendChild(document.createElementNS(TestADEModule.TESTADE_NAMESPACE, "ownerName"))
                .setTextContent("Smith");

        log.print("Adding an energy performance certification");
        Node certification = buildingProperties
                .appendChild(document.createElementNS(TestADEModule.TESTADE_NAMESPACE, "energyPerformanceCertification"))
                .appendChild(document.createElementNS(TestADEModule.TESTADE_NAMESPACE, "EnergyPerformanceCertification"));
        certification.appendChild(document.createElementNS(TestADEModule.TESTADE_NAMESPACE, "certificationName"))
                .setTextContent("certName");
        certification.appendChild(document.createElementNS(TestADEModule.TESTADE_NAMESPACE, "certificationId"))
                .setTextContent("certId");

        log.print("Adding a building underground object with LoD0 geometry and lighting facility");
        Node buildingUnderground = buildingProperties
                .appendChild(document.createElementNS(TestADEModule.TESTADE_NAMESPACE, "buildingUnderground"))
                .appendChild(document.createElementNS(TestADEModule.TESTADE_NAMESPACE, "BuildingUnderground"));

        GeometryFactory factory = GeometryFactory.newInstance();
        Polygon polygon = factory.createPolygon(new double[]{6.0, 0.0, -2.0, 0.0, 0.0, -2.0, 0.0, 8.0, -2.0, 6.0, 8.0, -2.0, 6.0, 0.0, -2.0}, 3);
        Node lod0GeometryProperty = buildingUnderground
                .appendChild(document.createElementNS(TestADEModule.TESTADE_NAMESPACE, "lod0GenericGeometry"));
        appendChild(lod0GeometryProperty, polygon, CityGMLVersion.v3_0, context.getXMLObjects());

        Element electricalPower = (Element) buildingUnderground
                .appendChild(document.createElementNS(TestADEModule.TESTADE_NAMESPACE, "equippedWith"))
                .appendChild(document.createElementNS(TestADEModule.TESTADE_NAMESPACE, "LightingFacility"))
                .appendChild(document.createElementNS(TestADEModule.TESTADE_NAMESPACE, "electricalPower"));
        electricalPower.setTextContent("4000.0");
        electricalPower.setAttribute("uom", "W");

        CityGMLVersion version = CityGMLVersion.v3_0;
        CityGMLOutputFactory out = context.createCityGMLOutputFactory(version);

        Path output = Util.getGMLOutputFile();
        log.print("Writing the ADE-enriched building as CityGML " + version + " file " + output);

        try (CityGMLChunkWriter writer = out.createCityGMLChunkWriter(output, StandardCharsets.UTF_8.name())) {
            writer.withIndent("  ")
                    .withSchemaLocation(TestADEModule.TESTADE_NAMESPACE, Util.OUTPUT_DIR.relativize(
                            Util.SCHEMAS_DIR.resolve("testADE.xsd")).toString())
                    .withDefaultPrefixes()
                    .withPrefix("test", TestADEModule.TESTADE_NAMESPACE)
                    .withDefaultNamespace(CoreModule.of(version).getNamespaceURI())
                    .writeMember(building);
        }

        log.finish();
    }

    static void appendChild(Node parent, GMLObject child, CityGMLVersion version, XMLObjects xmlObjects) throws XMLWriteException, ObjectSerializeException {
        DOMResult result = new DOMResult(parent);
        XMLWriterFactory xmlWriterFactory = XMLWriterFactory.newInstance(xmlObjects);
        XMLWriter writer = xmlWriterFactory.createWriter(result);
        xmlObjects.toXML(writer, child, Namespaces.of(CityGMLModules.of(version).getNamespaces()));
    }
}
