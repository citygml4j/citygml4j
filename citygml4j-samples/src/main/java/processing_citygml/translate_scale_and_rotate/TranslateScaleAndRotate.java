/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright 2013-2017 Claus Nagel <claus.nagel@gmail.com>
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
package processing_citygml.translate_scale_and_rotate;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.copy.DeepCopyBuilder;
import org.citygml4j.builder.jaxb.CityGMLBuilder;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.geometry.Matrix;
import org.citygml4j.model.citygml.building.Building;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.gml.base.AbstractGML;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.gml.geometry.primitives.DirectPositionList;
import org.citygml4j.model.gml.geometry.primitives.LinearRing;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.util.bbox.BoundingBoxOptions;
import org.citygml4j.util.gmlid.DefaultGMLIdManager;
import org.citygml4j.util.walker.GMLWalker;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.writer.CityModelWriter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TranslateScaleAndRotate {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and CityGML builder");
		CityGMLContext ctx = CityGMLContext.getInstance();
		CityGMLBuilder builder = ctx.createCityGMLBuilder();

		System.out.println(df.format(new Date()) + "reading CityGML file LOD2_Building_v100.gml");
		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		CityGMLReader reader = in.createCityGMLReader(new File("datasets/LOD2_Building_v100.gml"));

		CityModel cityModel = (CityModel)reader.nextFeature();
		Building building = (Building)cityModel.getCityObjectMember().get(0).getCityObject();

		System.out.println(df.format(new Date()) + "deep copying building object");
		DeepCopyBuilder copyBuilder = new DeepCopyBuilder();
		Building copy = (Building)building.copy(copyBuilder);

		BoundingShape boundedBy = copy.calcBoundedBy(BoundingBoxOptions.defaults());
		BoundingBox bbox = boundedBy.getEnvelope().toBoundingBox();
		double width = bbox.getUpperCorner().getX() - bbox.getLowerCorner().getX();
		
		System.out.println(df.format(new Date()) + "translating, scaling, and rotating building");
		GMLVisitor gmlVisitor = new GMLVisitor(2 * width, 2, 90);
		copy.accept(gmlVisitor);

		System.out.println(df.format(new Date()) + "writing citygml4j object tree as CityGML 2.0.0 document");
		CityGMLOutputFactory out = builder.createCityGMLOutputFactory(CityGMLVersion.v2_0_0);
		
		CityModelWriter writer = out.createCityModelWriter(new File("output/LOD2_Building_v200.gml"));
		writer.setPrefixes(CityGMLVersion.v2_0_0);
		writer.setDefaultNamespace(CoreModule.v2_0_0);
		writer.setSchemaLocations(CityGMLVersion.v2_0_0);
		writer.setIndentString("  ");
		
		writer.writeStartDocument();
		writer.writeFeatureMember(building);
		writer.writeFeatureMember(copy);
		writer.writeEndDocument();
		
		writer.close();
		
		System.out.println(df.format(new Date()) + "CityGML file LOD2_Building_v200.gml written");
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

	private static class GMLVisitor extends GMLWalker {
		private Matrix translate;
		private Matrix scale;
		private Matrix rotate;
		
		GMLVisitor(double translateBy, double scaleBy, double rotateBy) {
			translate = new Matrix(new double[][]{
					{1,0,0,translateBy},
					{0,1,0,0},
					{0,0,1,0},
					{0,0,0,1}});
			
			scale = new Matrix(new double[][]{
					{scaleBy,0,0,0},
					{0,scaleBy,0,0},
					{0,0,scaleBy,0},
					{0,0,0,1}});
			
			rotateBy = Math.toRadians(90);
			rotate = new Matrix(new double[][]{
					{Math.cos(rotateBy),-Math.sin(rotateBy),0,0},
					{Math.sin(rotateBy),Math.cos(rotateBy),0,0},
					{0,0,1,0},
					{0,0,0,1}});
		}
		
		@Override
		public void visit(AbstractGML abstractGML) {
			if (abstractGML.isSetId())
				abstractGML.setId(DefaultGMLIdManager.getInstance().generateUUID());
			
			super.visit(abstractGML);
		}

		@Override
		public void visit(LinearRing linearRing) {

			if (linearRing.isSetPosList()) {
				DirectPositionList posList = linearRing.getPosList();
				List<Double> points = posList.toList3d();
				List<Double> newPoints = new ArrayList<Double>();

				for (int i = 0; i < points.size(); i += 3) {
					double[] vals = new double[]{ points.get(i), points.get(i+1), points.get(i+2), 1};
					Matrix v = new Matrix(vals, 1);
					Matrix trans = rotate.times(scale.times(translate));
					
					double[] newVals = trans.times(v.transpose()).toColumnPackedArray();
					newPoints.add(newVals[0]);
					newPoints.add(newVals[1]);
					newPoints.add(newVals[2]);
				}
				
				posList.setValue(newPoints);
			}

			super.visit(linearRing);
		}
	}
}
