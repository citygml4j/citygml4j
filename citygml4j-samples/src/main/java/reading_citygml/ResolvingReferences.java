/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package reading_citygml;

import helpers.Logger;
import helpers.Util;
import org.citygml4j.core.model.building.Building;
import org.citygml4j.core.model.core.AbstractFeature;
import org.citygml4j.core.util.reference.DefaultReferenceResolver;
import org.citygml4j.xml.CityGMLContext;
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
                .withReferenceResolver(DefaultReferenceResolver.newInstance());

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
