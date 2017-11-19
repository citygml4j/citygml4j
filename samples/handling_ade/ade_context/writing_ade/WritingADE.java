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
package handling_ade.ade_context.writing_ade;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.citygml.ade.noise.NoiseADEContext;
import org.citygml.ade.noise.model.NoiseRailwaySegment;
import org.citygml.ade.noise.model.NoiseRailwaySegmentProperty;
import org.citygml.ade.noise.model.NoiseRailwaySegmentPropertyElement;
import org.citygml.ade.noise.model.Train;
import org.citygml.ade.noise.model.TrainProperty;
import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.CityGMLBuilder;
import org.citygml4j.factory.GMLGeometryFactory;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.citygml.core.CityObjectMember;
import org.citygml4j.model.citygml.transportation.Railway;
import org.citygml4j.model.gml.basicTypes.Measure;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.gml.geometry.complexes.CompositeCurve;
import org.citygml4j.model.gml.geometry.complexes.GeometricComplexProperty;
import org.citygml4j.model.gml.geometry.primitives.CurveProperty;
import org.citygml4j.model.gml.geometry.primitives.LineString;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.util.bbox.BoundingBoxOptions;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.writer.CityGMLWriter;

public class WritingADE {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] ");

		/**
		 * For using ADE modules implemented against the ADEContext interface, 
		 * please apply the following steps:
		 * 
		 * 1. Create a CityGMLContext
		 * 2. Register all your ADE modules with the CityGMLContext
		 * 3. Create a CityGMLBuilder and use it to build factories
		 *    for reading/writing a dataset
		 * 
		 * The registered ADE modules are automatically supported by citygml4j.
		 * Thus, there is no need to write ADE-specific code for using default
		 * citygml4j features.
		 */

		System.out.println(df.format(new Date()) + "setting up citygml4j context");
		// step 1: create CityGML context
		CityGMLContext context = CityGMLContext.getInstance();

		// step 2: load NoiseADE context and register with CityGML context
		System.out.println(df.format(new Date()) + "loading NoiseADE context and registering with citygml4j context");
		NoiseADEContext noiseADEContext = new NoiseADEContext();
		context.registerADEContext(noiseADEContext);

		// step 3: create CityGMLBuilder which automatically supports the NoiseADE module
		System.out.println(df.format(new Date()) + "creating CityGMLBuilder object");
		CityGMLBuilder builder = context.createCityGMLBuilder();
		
		// create NoiseADE example using CityGML and ADE classes
		System.out.println(df.format(new Date()) + "creating sample CityGML and NoiseADE features");
		GMLGeometryFactory geometryFactory = new GMLGeometryFactory();
		
		// firstly, create a CityGML tran:Railway feature
		Railway railway = new Railway();
		
		// add a LoD 0 composite curve as network geometry
		CompositeCurve network = new CompositeCurve();
		LineString firstCurve = geometryFactory.createLineString(new double[] {2524175, 5707335, 188, 2524181, 5707338, 188, 2524185, 5707330, 188, 2524179, 5707327, 188}, 3);
		LineString secondCurve = geometryFactory.createLineString(new double[] {2524175, 5707335, 188, 2524181, 5707338, 188, 2524185, 5707330, 188, 2524179, 5707327, 188}, 3);

		network.addCurveMember(new CurveProperty(firstCurve));
		network.addCurveMember(new CurveProperty(secondCurve));
		railway.addLod0Network(new GeometricComplexProperty(network));		
		
		// secondly, create an ADE noise:RailwaySegment feature and add some thematic properties
		NoiseRailwaySegment railwaySegment = new NoiseRailwaySegment();
		railwaySegment.setRailwaySurfaceMaterial("ballast bed + wooden sleeper");
		
		Measure surfaceCorrection = new Measure(3.123);
		surfaceCorrection.setUom("dB");
		railwaySegment.setRailwaySurfaceCorrection(surfaceCorrection);
		
		railwaySegment.setBridge(true);
		railwaySegment.setCrossing(false);
		
		// add a LoD 0 geometry to the railway segment
		LineString baseLine = geometryFactory.createLineString(new double[] {2524175, 5707335, 188, 2524181, 5707338, 188, 2524185, 5707330, 188, 524179, 5707327, 188}, 3);
		railwaySegment.setLod0BaseLine(new CurveProperty(baseLine));
				
		// thirdly, create an ADE noise:Train feature and add some thematic properties
		Train train = new Train();
		train.setTrainType("vehicle with wheel disk brakes");
		
		Measure typeCorrection = new Measure(-2.123);
		typeCorrection.setUom("dB");
		train.setTrainTypeCorrection(typeCorrection);		
		
		// assign train to railway segment
		railwaySegment.addUsedBy(new TrainProperty(train));
		
		// now, let's assign the noise:RailwaySegment to the tran:Railway.
		// Since the tran:Railway does not have a corresponding feature property for noise:RailwaySegment,
		// we use the ADE hook mechanism to inject this feature property element	
		NoiseRailwaySegmentPropertyElement hookElement = new NoiseRailwaySegmentPropertyElement(new NoiseRailwaySegmentProperty(railwaySegment));
		railway.addGenericApplicationPropertyOfRailway(hookElement);
		
		// lastly, create a CityGML core:CityModel feature and assign the tran:Railway		
		CityModel cityModel = new CityModel();
		cityModel.addCityObjectMember(new CityObjectMember(railway));
		
		// calc BBOX of the city model and all contained features
		BoundingShape boundedBy = cityModel.calcBoundedBy(BoundingBoxOptions
				.defaults()
				.assignResultToFeatures(true));
		boundedBy.getEnvelope().setSrsName("EPSG:31466");
		
		// create CityGML writer and write the city model to a dataset
		System.out.println(df.format(new Date()) + "creating CityGML 2.0.0 writer");
		CityGMLOutputFactory out = builder.createCityGMLOutputFactory(CityGMLVersion.v2_0_0);

		CityGMLWriter writer = out.createCityGMLWriter(new File("LOD0_Railway_NoiseADE_example_v200.gml"), "utf-8");
		writer.setIndentString("  ");
		writer.setPrefixes(CityGMLVersion.v2_0_0);
		writer.setSchemaLocations(CityGMLVersion.v2_0_0);

		// set ADE-specific XML prefixes and schema locations for the writer (optional)
		writer.setPrefixes(context.getADEContexts());
		writer.setSchemaLocations(context.getADEContexts());
		
		System.out.println(df.format(new Date()) + "writing sample features to file LOD0_Railway_NoiseADE_example_v200.gml");
		writer.write(cityModel);
		writer.close();
		
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}
