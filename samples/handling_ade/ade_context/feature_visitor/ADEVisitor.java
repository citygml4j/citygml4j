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
package handling_ade.ade_context.feature_visitor;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.citygml.ade.noise.NoiseADEContext;
import org.citygml.ade.noise.model.Train;
import org.citygml.ade.noise.walker.NoiseADEFeatureWalker;
import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.CityGMLBuilder;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.util.walker.FeatureWalker;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;

public class ADEVisitor {

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

		// read an ADE-enriched dataset. There is no need for ADE-specific code.
		System.out.println(df.format(new Date()) + "reading ADE-enriched CityGML file LOD0_Railway_NoiseADE_v200.gml");
		CityGMLInputFactory in = builder.createCityGMLInputFactory();

		CityGMLReader reader = in.createCityGMLReader(new File("../../../datasets/LOD0_Railway_NoiseADE_v200.gml"));
		CityModel cityModel = (CityModel)reader.nextFeature();
		reader.close();

		// use default feature walker to visit all features contained in the city model.
		// Since a default walker has no special visit methods for ADE features,
		// we have to use a superclass to visit them.
		System.out.println(df.format(new Date()) + "step 1: using default walker to visit all features");

		FeatureWalker walker = new FeatureWalker() {
			@Override
			public void visit(AbstractFeature abstractFeature) {
				System.out.println(df.format(new Date()) + "[default walker] found feature of class " + abstractFeature);
				System.out.println(df.format(new Date()) + "[default walker] -- gml:id: " + abstractFeature.getId());
				super.visit(abstractFeature);
			}
		};
		
		cityModel.accept(walker);

		// overwrite the NoiseADE feature walker to be able to use the specific visit methods
		// of the NoiseADE features. The ADE walker has to registered with the default walker.
		System.out.println(df.format(new Date()) + "step 2: using default walker with ADE walker to visit all features");
		
		NoiseADEFeatureWalker noiseADEWalker = new NoiseADEFeatureWalker() {
			@Override
			public void visit(Train train) {
				super.visit(train);

				System.out.println(df.format(new Date()) + "[ADE walker] found noise:Train feature");
				System.out.println(df.format(new Date()) + "[ADE walker] -- noise:trainType: " + train.getTrainType());
				System.out.println(df.format(new Date()) + "[ADE walker] -- noise:trainTypeCorrection: " + train.getTrainTypeCorrection().getValue());
				System.out.println(df.format(new Date()) + "[ADE walker] -- noise:brakePortionDay: " + train.getBrakePortionDay().getValue());
				System.out.println(df.format(new Date()) + "[ADE walker] -- noise:brakePortionEvening: " + train.getBrakePortionEvening().getValue());
				System.out.println(df.format(new Date()) + "[ADE walker] -- noise:brakePortionNight: " + train.getBrakePortionNight().getValue());
				System.out.println(df.format(new Date()) + "[ADE walker] -- noise:lengthDay: " + train.getLengthDay().getValue());
				System.out.println(df.format(new Date()) + "[ADE walker] -- noise:lengthEvening: " + train.getLengthEvening().getValue());
				System.out.println(df.format(new Date()) + "[ADE walker] -- noise:lengthNight: " + train.getLengthNight().getValue());
				System.out.println(df.format(new Date()) + "[ADE walker] -- noise:speedDay: " + train.getSpeedDay().getValue());
				System.out.println(df.format(new Date()) + "[ADE walker] -- noise:speedEvening: " + train.getSpeedEvening().getValue());
				System.out.println(df.format(new Date()) + "[ADE walker] -- noise:speedNight: " + train.getSpeedNight().getValue());
				System.out.println(df.format(new Date()) + "[ADE walker] -- noise:additionalCorrectionTrain: " + train.getAdditionalCorrectionTrain().getValue());
			}
		};
		
		walker.useADEWalker(noiseADEWalker);
		cityModel.accept(walker);
		
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}
}
