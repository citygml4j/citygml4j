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

package processing_citygml;

import Jama.Matrix;
import helpers.Logger;
import helpers.Util;
import org.citygml4j.CityGMLContext;
import org.citygml4j.model.CityGMLVersion;
import org.citygml4j.model.building.Building;
import org.citygml4j.model.core.CityModel;
import org.citygml4j.visitor.ObjectWalker;
import org.citygml4j.xml.module.citygml.CoreModule;
import org.citygml4j.xml.reader.CityGMLInputFactory;
import org.citygml4j.xml.reader.CityGMLReader;
import org.citygml4j.xml.writer.CityGMLChunkWriter;
import org.citygml4j.xml.writer.CityGMLOutputFactory;
import org.xmlobjects.gml.model.base.AbstractGML;
import org.xmlobjects.gml.model.geometry.DirectPosition;
import org.xmlobjects.gml.model.geometry.DirectPositionList;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.model.geometry.GeometricPositionList;
import org.xmlobjects.gml.model.geometry.primitives.LinearRing;
import org.xmlobjects.gml.util.Matrices;
import org.xmlobjects.gml.util.id.DefaultIdCreator;
import org.xmlobjects.gml.util.id.IdCreator;
import org.xmlobjects.util.copy.CopyBuilder;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.List;

public class AffineTransformation {

    public static void main(String[] args) throws Exception {
        Logger log = Logger.start(AffineTransformation.class);

        CityGMLContext context = CityGMLContext.newInstance();

        CityGMLInputFactory in = context.createCityGMLInputFactory();

        Path file = Util.SAMPLE_DATA_DIR.resolve("lod3_building_v2.gml");
        log.print("Reading the building from the file " + file + " into main memory");

        Building building;
        try (CityGMLReader reader = in.createCityGMLReader(file)) {
            CityModel cityModel = (CityModel) reader.next();
            building = (Building) cityModel.getCityObjectMembers().get(0).getObject();
            log.print("Found Building with gml:id " + building.getId());
        }

        building.setAppearances(null);

        Envelope envelope = building.computeEnvelope();
        DirectPosition centerPoint = envelope.getCenter();
        double width = envelope.getUpperCorner().getValue().get(1) - envelope.getLowerCorner().getValue().get(1);

        log.print("Creating a deep copy of the building");
        CopyBuilder builder = new CopyBuilder();
        Building copy = builder.deepCopy(building);

        Matrix center = new Matrix(new double[][]{
                {1, 0, 0, -centerPoint.getValue().get(0)},
                {0, 1, 0, -centerPoint.getValue().get(1)},
                {0, 0, 1, -centerPoint.getValue().get(2)},
                {0, 0, 0, 1},
        });

        Matrix scale = new Matrix(new double[][]{
                {0.5, 0, 0, 0},
                {0, 0.5, 0, 0},
                {0, 0, 0.5, 0},
                {0, 0, 0, 1},
        });

        double rotateBy = Math.toRadians(90);
        Matrix rotate = new Matrix(new double[][]{
                {Math.cos(rotateBy), -Math.sin(rotateBy), 0, 0},
                {Math.sin(rotateBy), Math.cos(rotateBy), 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        });

        Matrix move = new Matrix(new double[][]{
                {1, 0, 0, centerPoint.getValue().get(0)},
                {0, 1, 0, centerPoint.getValue().get(1) - width},
                {0, 0, 1, centerPoint.getValue().get(2)},
                {0, 0, 0, 1},
        });

        Matrix transform = move.times(rotate.times(scale.times(center)));

        log.print("Scaling, rotating and translating the geometry of the copied building");
        IdCreator idCreator = DefaultIdCreator.newInstance();
        copy.accept(new ObjectWalker() {
            @Override
            public void visit(AbstractGML object) {
                object.setId(idCreator.createId());
                super.visit(object);
            }

            @Override
            public void visit(LinearRing linearRing) {
                List<Double> transformedCoordinates = Matrices.transform3D(linearRing, transform);

                DirectPositionList posList = new DirectPositionList(transformedCoordinates);
                posList.setSrsDimension(3);
                linearRing.setControlPoints(new GeometricPositionList(posList));
                super.visit(linearRing);
            }
        });

        CityGMLVersion version = CityGMLVersion.v2_0;
        CityGMLOutputFactory out = context.createCityGMLOutputFactory(version);

        Path output = Util.getOutputFile();
        log.print("Writing both buildings to the file " + output);

        try (CityGMLChunkWriter writer = out.createCityGMLChunkWriter(output, StandardCharsets.UTF_8.name())) {
            writer.withIndentString("  ")
                    .withDefaultSchemaLocations()
                    .withDefaultPrefixes()
                    .withDefaultNamespace(CoreModule.of(version).getNamespaceURI());

            writer.writeMember(building);
            writer.writeMember(copy);
        }

        log.finish();
    }
}
