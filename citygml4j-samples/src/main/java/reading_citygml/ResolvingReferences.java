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

package reading_citygml;

import helpers.Logger;
import helpers.Util;
import org.citygml4j.CityGMLContext;
import org.citygml4j.model.building.Building;
import org.citygml4j.model.core.AbstractFeature;
import org.citygml4j.util.reference.ReferenceResolver;
import org.citygml4j.xml.reader.ChunkOptions;
import org.citygml4j.xml.reader.CityGMLInputFactory;
import org.citygml4j.xml.reader.CityGMLReadException;
import org.citygml4j.xml.reader.CityGMLReader;
import org.xmlobjects.gml.model.base.AbstractInlineOrByReferenceProperty;
import org.xmlobjects.gml.visitor.GeometryWalker;

import java.nio.file.Path;

public class ResolvingReferences {

    public static void main(String[] args) throws Exception {
        Logger log = Logger.start(ResolvingReferences.class);

        CityGMLContext context = CityGMLContext.newInstance();

        CityGMLInputFactory in = context.createCityGMLInputFactory()
                .withChunking(ChunkOptions.defaults())
                .withReferenceResolver(ReferenceResolver.newInstance());

        Path file = Util.SAMPLE_DATA_DIR.resolve("lod2_buildings_v3.gml");
        log.print("Reading the first building from the file " + file + " and resolving its XLink references");

        Building building;
        try (CityGMLReader reader = in.createFilteredCityGMLReader(in.createCityGMLReader(file),
                name -> name.getLocalPart().equals("Building"))) {
            if (reader.hasNext()) {
                building = (Building) reader.next();
                log.print("Found " + reader.getName().getLocalPart() + " with gml:id " + building.getId());
            } else {
                throw new CityGMLReadException("Failed to read a building from file " + file);
            }
        }

        log.print("Iterating over the geometry references of the LoD2 solid geometry of the building");

        if (building.getLod2Solid() != null && building.getLod2Solid().getObject() != null) {
            building.getLod2Solid().getObject().accept(new GeometryWalker() {
                @Override
                public void visit(AbstractInlineOrByReferenceProperty<?> property) {
                    if (property.isSetReferencedObject()) {
                        log.print("- Found geometry reference to " + property.getHref());
                        log.print("  The XLink resolves to a " + property.getObject().getClass().getSimpleName() + " geometry");

                        AbstractFeature feature = property.getObject().getParent(AbstractFeature.class);
                        if (feature != null) {
                            log.print("  The geometry belongs to the " + feature.getClass().getSimpleName() + " feature with gml:id " + feature.getId());
                        }
                    }
                }
            });
        }

        log.finish();
    }
}
