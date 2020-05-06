/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2020 Claus Nagel <claus.nagel@gmail.com>
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
import org.citygml4j.model.core.AbstractSpaceBoundaryProperty;
import org.citygml4j.model.core.AbstractThematicSurface;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.util.reference.ReferenceResolver;
import org.citygml4j.xml.reader.ChunkMode;
import org.citygml4j.xml.reader.CityGMLInputFactory;
import org.citygml4j.xml.reader.CityGMLReader;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurface;
import org.xmlobjects.gml.model.geometry.primitives.AbstractSurface;
import org.xmlobjects.gml.model.geometry.primitives.SurfaceProperty;

import java.nio.file.Path;

public class ResolvingReferences {

    public static void main(String[] args) throws Exception {
        Logger log = Logger.start(ResolvingReferences.class);

        CityGMLContext context = CityGMLContext.newInstance();

        CityGMLInputFactory in = context.createCityGMLInputFactory()
                .useChunkMode(ChunkMode.CHUNK_BY_CITY_MODEL_MEMBERS)
                .withReferenceResolver(ReferenceResolver.newInstance());

        Path file = Util.SAMPLE_DATA_DIR.resolve("lod2_buildings_v3.gml");
        log.print("Reading the first building from the file " + file + " and resolving its XLink references");

        Building building = null;
        try (CityGMLReader reader = in.createCityGMLReader(file)) {
            while (reader.hasNext()) {
                AbstractFeature feature = reader.next();
                if (feature instanceof Building) {
                    building = (Building) feature;
                    log.print("Found " + reader.getName().getLocalPart() + " with gml:id " + feature.getId());
                    break;
                }
            }

            if (building == null)
                throw new Exception("Failed to read a building from file " + file);
        }

        log.print("Iterating through the thematic boundary surfaces of the building");

        int size = building.getBoundaries().size();
        int i = 1;

        for (AbstractSpaceBoundaryProperty property : building.getBoundaries()) {
            if (property.getObject() instanceof AbstractThematicSurface) {
                AbstractThematicSurface thematicSurface = (AbstractThematicSurface) property.getObject();
                log.print("[" + (i++) + "|" + size + "] Found " + thematicSurface.getClass().getSimpleName() + " with gml:id " + thematicSurface.getId());

                MultiSurface multiSurface = thematicSurface.getLod2MultiSurface().getObject();
                for (SurfaceProperty member : multiSurface.getSurfaceMember()) {
                    log.print("- The thematic surface has an XLink reference to " + member.getHref());
                    AbstractSurface surface = member.getLocalProperties().get(CityGMLConstants.REFERENCED_OBJECT, AbstractSurface.class);
                    if (surface != null) {
                        log.print("- The XLink resolves to a " + surface.getClass().getSimpleName() + " geometry");

                        AbstractFeature feature = surface.getParent(AbstractFeature.class);
                        if (feature != null)
                            log.print("- The geometry belongs to the " + feature.getClass().getSimpleName() + " feature with gml:id " + feature.getId());

                    } else
                        log.print("- The XLink cannot be resolved or does not point to a surface geometry");
                }
            }
        }

        log.finish();
    }
}
