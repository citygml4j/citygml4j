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

package processing_citygml;

import helpers.Logger;
import helpers.Util;
import org.citygml4j.CityGMLContext;
import org.citygml4j.model.CityGMLVersion;
import org.citygml4j.model.building.Building;
import org.citygml4j.model.construction.*;
import org.citygml4j.model.core.AbstractSpaceBoundaryProperty;
import org.citygml4j.model.core.AbstractThematicSurface;
import org.citygml4j.util.geometry.GeometryFactory;
import org.citygml4j.xml.module.citygml.CoreModule;
import org.citygml4j.xml.writer.CityGMLChunkWriter;
import org.citygml4j.xml.writer.CityGMLOutputFactory;
import org.xmlobjects.gml.model.feature.BoundingShape;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurfaceProperty;
import org.xmlobjects.gml.model.geometry.primitives.*;
import org.xmlobjects.gml.model.measures.Length;
import org.xmlobjects.gml.util.id.DefaultIdCreator;
import org.xmlobjects.gml.util.id.IdCreator;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.stream.Stream;

public class CreatingSimpleBuilding {
    private IdCreator idCreator;
    private GeometryFactory factory;

    public static void main(String[] args) throws Exception {
        new CreatingSimpleBuilding().doMain();
    }

    public void doMain() throws Exception {
        Logger log = Logger.start(CreatingSimpleBuilding.class);

        CityGMLContext context = CityGMLContext.newInstance();

        idCreator = DefaultIdCreator.newInstance();
        factory = GeometryFactory.newInstance()
                .withIdCreator(idCreator);

        log.print("Creating a simple LoD2 building using the citygml4j classes");
        Building building = new Building();

        Polygon groundPolygon = factory.createPolygon(new double[]{0, 0, 0, 0, 12, 0, 6, 12, 0, 6, 0, 0}, 3);
        Polygon wallPolygon_1 = factory.createPolygon(new double[]{6, 0, 0, 6, 12, 0, 6, 12, 6, 6, 0, 6}, 3);
        Polygon wallPolygon_2 = factory.createPolygon(new double[]{0, 0, 0, 0, 0, 6, 0, 12, 6, 0, 12, 0}, 3);
        Polygon wallPolygon_3 = factory.createPolygon(new double[]{0, 0, 0, 6, 0, 0, 6, 0, 6, 3, 0, 9, 0, 0, 6}, 3);
        Polygon wallPolygon_4 = factory.createPolygon(new double[]{6, 12, 0, 0, 12, 0, 0, 12, 6, 3, 12, 9, 6, 12, 6}, 3);
        Polygon roofPolygon_1 = factory.createPolygon(new double[]{6, 0, 6, 6, 12, 6, 3, 12, 9, 3, 0, 9}, 3);
        Polygon roofPolygon_2 = factory.createPolygon(new double[]{0, 0, 6, 3, 0, 9, 3, 12, 9, 0, 12, 6}, 3);

        building.addBoundary(processBoundarySurface(new GroundSurface(), groundPolygon));
        building.addBoundary(processBoundarySurface(new WallSurface(), wallPolygon_1));
        building.addBoundary(processBoundarySurface(new WallSurface(), wallPolygon_2));
        building.addBoundary(processBoundarySurface(new WallSurface(), wallPolygon_3));
        building.addBoundary(processBoundarySurface(new WallSurface(), wallPolygon_4));
        building.addBoundary(processBoundarySurface(new RoofSurface(), roofPolygon_1));
        building.addBoundary(processBoundarySurface(new RoofSurface(), roofPolygon_2));

        Shell shell = new Shell();
        Stream.of(groundPolygon, wallPolygon_1, wallPolygon_2, wallPolygon_3, wallPolygon_4, roofPolygon_1, roofPolygon_2)
                .map(p -> new SurfaceProperty("#" + p.getId()))
                .forEach(shell.getSurfaceMembers()::add);
        building.setLod2Solid(new SolidProperty(new Solid(shell)));

        Envelope envelope = building.computeEnvelope();
        Length measuredHeight = new Length(envelope.getUpperCorner().getValue().get(2) - envelope.getLowerCorner().getValue().get(2), "#m");
        building.getHeights().add(new HeightProperty(Height.ofMeasuredHeight(measuredHeight)));

        CityGMLVersion version = CityGMLVersion.v2_0;
        CityGMLOutputFactory out = context.createCityGMLOutputFactory(version);

        Path output = Util.getOutputFile();
        log.print("Creating CityGML " + version + " writer for the file " + output);

        try (CityGMLChunkWriter writer = out.createCityGMLChunkWriter(output, StandardCharsets.UTF_8.name())) {
            writer.withIndent("  ")
                    .withDefaultSchemaLocations()
                    .withDefaultPrefixes()
                    .withDefaultNamespace(CoreModule.of(version).getNamespaceURI())
                    .withHeaderComment("File created with citygml4j");

            log.print("Setting metadata on the CityModel of the output file");
            writer.getCityModelInfo().setBoundedBy(new BoundingShape(envelope));

            log.print("Writing the building object to the file");
            writer.writeMember(building);
        }

        log.finish();
    }

    private AbstractSpaceBoundaryProperty processBoundarySurface(AbstractThematicSurface thematicSurface, Polygon... polygons) {
        thematicSurface.setId(idCreator.createId());
        thematicSurface.setLod2MultiSurface(new MultiSurfaceProperty(factory.createMultiSurface(polygons)));
        return new AbstractSpaceBoundaryProperty(thematicSurface);
    }
}
