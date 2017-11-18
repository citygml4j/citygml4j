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
package handling_ade.ade_context.reading_ade;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ServiceLoader;

import javax.xml.namespace.QName;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.CityGMLBuilder;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.binding.ADEContext;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.LodRepresentation;
import org.citygml4j.model.module.Module;
import org.citygml4j.model.module.Modules;
import org.citygml4j.model.module.ade.ADEModule;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.reader.FeatureReadMode;

public class ReadingADE {

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

		// step 2: load ADE modules using a service loader and register with CityGML context
		// alternatively, you could directly register an instance of the NoiseADEModule
		// with the CityGMLContext
		System.out.println(df.format(new Date()) + "loading ADE contexts and registering with citygml4j context");
		for (ADEContext adeContext : ServiceLoader.load(ADEContext.class))
			context.registerADEContext(adeContext);

		// print registered ADE modules
		for (ADEContext adeContext : context.getADEContexts()) {
			for (ADEModule module : adeContext.getADEModules()) {
				System.out.println(df.format(new Date()) + "-- found ADE module for namespace " + module.getNamespaceURI()	+
						" and CityGML version " + module.getCityGMLVersion());
			}
		}

		// step 3: create CityGMLBuilder which automatically supports the ADE modules
		System.out.println(df.format(new Date()) + "creating CityGMLBuilder object");
		CityGMLBuilder builder = context.createCityGMLBuilder();

		// read an ADE-enriched dataset. There is no need for ADE-specific code.
		System.out.println(df.format(new Date()) + "reading ADE-enriched CityGML file LOD0_Railway_NoiseADE_v200.gml");
		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		in.setProperty(CityGMLInputFactory.FEATURE_READ_MODE, FeatureReadMode.SPLIT_PER_FEATURE);

		CityGMLReader reader = in.createCityGMLReader(new File("../../../datasets/LOD0_Railway_NoiseADE_v200.gml"));
		while (reader.hasNext()) {
			CityGML cityGML = reader.nextFeature();

			if (cityGML instanceof AbstractCityObject) {
				AbstractCityObject cityObject = (AbstractCityObject)cityGML;

				Module module = Modules.getModule(cityObject.getClass());
				QName featureName = module.getFeatureName(cityObject.getClass());
				
				System.out.println(df.format(new Date()) + "found city object " + featureName);
				System.out.println(df.format(new Date()) + "-- class: " + cityObject.getClass().getName());
				System.out.println(df.format(new Date()) + "-- is ADE: " + (cityGML.getCityGMLClass() == CityGMLClass.ADE_COMPONENT));				
				System.out.println(df.format(new Date()) + "-- gml:id: " + cityObject.getId());
			
				LodRepresentation lods = cityObject.getLodRepresentation();
				for (int lod = 0; lod < 5; lod++)
					System.out.println(df.format(new Date()) + "-- has LoD " + lod + " geometry: " + lods.isSetGeometry(lod));
			}
		}
		
		reader.close();
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}
