/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2025 Claus Nagel <claus.nagel@gmail.com>
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

package using_xmlobjects;

import helpers.Logger;
import helpers.Util;
import org.citygml4j.core.model.CityGMLVersion;
import org.citygml4j.core.model.core.AbstractCityObjectProperty;
import org.citygml4j.core.model.core.AbstractFeature;
import org.citygml4j.core.model.core.CityModel;
import org.citygml4j.core.util.CityGMLConstants;
import org.citygml4j.xml.CityGMLContext;
import org.citygml4j.xml.reader.CityGMLInputFactory;
import org.citygml4j.xml.reader.CityGMLReader;
import org.citygml4j.xml.writer.CityGMLOutputFactory;
import org.citygml4j.xml.writer.CityGMLWriter;
import org.xmlobjects.XMLObjects;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.serializer.ObjectSerializer;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;
import org.xmlobjects.xml.TextContent;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.time.OffsetDateTime;

public class ReplacingAdapters {

    public static void main(String[] args) throws Exception {
        Logger log = Logger.start(ReplacingAdapters.class);

        CityGMLContext context = CityGMLContext.newInstance();

        CityGMLInputFactory in = context.createCityGMLInputFactory();

        Path file = Util.SAMPLE_DATA_DIR.resolve("lod2_buildings_v3.gml");
        log.print("Reading the file " + file + " into main memory");

        AbstractFeature feature;
        try (CityGMLReader reader = in.createCityGMLReader(file)) {
            feature = reader.next();
            log.print("Found " + reader.getName().getLocalPart() + " with gml:id " + feature.getId());
        }

        CityGMLVersion version = CityGMLVersion.v3_0;
        CityGMLOutputFactory out = context.createCityGMLOutputFactory(version);

        log.print("Replacing the predefined CityModel serializer with our own serializer to write a WFS 2.0 feature collection");
        XMLObjects xmlObjects = context.getXMLObjects();
        xmlObjects.registerSerializer(new WFSFeatureCollectionSerializer(),
                CityModel.class,
                CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE);

        Path output = Util.getGMLOutputFile();
        log.print("Writing the file as WFS 2.0 feature collection");

        try (CityGMLWriter writer = out.createCityGMLWriter(output, StandardCharsets.UTF_8.name())) {
            writer.withIndent("  ")
                    .withDefaultPrefixes()
                    .withPrefix("wfs", WFSFeatureCollectionSerializer.WFS_NAMESPACE)
                    .write(feature);
        }

        log.finish();
    }

    private static class WFSFeatureCollectionSerializer implements ObjectSerializer<CityModel> {
        private static final String WFS_NAMESPACE = "http://www.opengis.net/wfs/2.0";

        @Override
        public Element createElement(CityModel object, Namespaces namespaces) throws ObjectSerializeException {
            return Element.of(WFS_NAMESPACE, "FeatureCollection");
        }

        @Override
        public void initializeElement(Element element, CityModel object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
            element.addAttribute("timeStamp", TextContent.ofDateTime(OffsetDateTime.now().withNano(0)))
                    .addAttribute("numberMatched", TextContent.ofInteger(object.getCityObjectMembers().size()))
                    .addAttribute("numberReturned", TextContent.ofInteger(object.getCityObjectMembers().size()));
        }

        @Override
        public void writeChildElements(CityModel object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
            for (AbstractCityObjectProperty property : object.getCityObjectMembers()) {
                writer.writeStartElement(Element.of(WFS_NAMESPACE, "member"));
                writer.writeObject(property.getObject(), namespaces);
                writer.writeEndElement();
            }
        }
    }
}
