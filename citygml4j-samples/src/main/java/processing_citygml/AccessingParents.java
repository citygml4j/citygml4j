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

package processing_citygml;

import helpers.Logger;
import helpers.Util;
import org.citygml4j.core.model.building.Building;
import org.citygml4j.core.model.core.AbstractFeature;
import org.citygml4j.core.model.landuse.LandUse;
import org.citygml4j.core.util.reference.DefaultReferenceResolver;
import org.citygml4j.xml.CityGMLContext;
import org.citygml4j.xml.reader.CityGMLInputFactory;
import org.citygml4j.xml.reader.CityGMLReader;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;

import java.nio.file.Path;

public class AccessingParents {

    public static void main(String[] args) throws Exception {
        Logger log = Logger.start(AccessingParents.class);

        CityGMLContext context = CityGMLContext.newInstance();

        CityGMLInputFactory in = context.createCityGMLInputFactory();

        Path file = Util.SAMPLE_DATA_DIR.resolve("lod3_building_v2.gml");
        log.print("Reading the file " + file + " into main memory");

        AbstractFeature feature;
        try (CityGMLReader reader = in.createCityGMLReader(file)) {
            feature = reader.next();
            log.print("Found " + reader.getName().getLocalPart() + " with gml:id " + feature.getId());
        }

        DefaultReferenceResolver resolver = DefaultReferenceResolver.newInstance();

        log.print("Searching the city model for an object with gml:id UUID_9c93de74-b75a-439a-8c95-938105c66a64");
        AbstractGeometry geometry = resolver.resolveReference("UUID_9c93de74-b75a-439a-8c95-938105c66a64", AbstractGeometry.class, feature);

        log.print("Found a " + geometry.getClass().getSimpleName() + " object matching this gml:id");
        log.print("Accessing the parents of the object");

        log.print("The direct parent is: " + geometry.getParent().getClass().getSimpleName());

        AbstractGeometry parentGeometry = geometry.getParent(AbstractGeometry.class);
        log.print("The parent geometry is: " + parentGeometry.getClass().getSimpleName() + " with gml:id " + parentGeometry.getId());

        AbstractFeature parentFeature = geometry.getParent(AbstractFeature.class);
        log.print("The parent feature is: " + parentFeature.getClass().getSimpleName() + " with gml:id " + parentFeature.getId());

        Building building = geometry.getParent(Building.class);
        log.print("The parent feature of type Building is: " + building.getClass().getSimpleName() + " with gml:id " + building.getId());

        LandUse landUse = geometry.getParent(LandUse.class);
        log.print("Is there a parent feature of type LandUse? " + (landUse != null ? "yes" : "no"));

        AbstractFeature root = parentFeature;
        while ((parentFeature = parentFeature.getParent(AbstractFeature.class)) != null)
            root = parentFeature;

        log.print("The root parent feature is: " + root.getClass().getSimpleName() + " with gml:id " + root.getId());

        log.finish();
    }
}
