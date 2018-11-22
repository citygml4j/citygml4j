/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
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
package cityjson.writing_cityjson.using_gson;

import com.google.gson.Gson;
import com.google.gson.stream.JsonWriter;
import org.citygml4j.CityGMLContext;
import org.citygml4j.binding.cityjson.CityJSON;
import org.citygml4j.binding.cityjson.feature.BuildingAttributes;
import org.citygml4j.binding.cityjson.feature.BuildingType;
import org.citygml4j.binding.cityjson.geometry.SemanticsType;
import org.citygml4j.binding.cityjson.geometry.SolidSemanticsObject;
import org.citygml4j.binding.cityjson.geometry.SolidType;
import org.citygml4j.binding.cityjson.metadata.MetadataType;
import org.citygml4j.builder.cityjson.marshal.util.DefaultVerticesBuilder;
import org.citygml4j.builder.cityjson.unmarshal.CityJSONUnmarshaller;
import org.citygml4j.builder.jaxb.CityGMLBuilder;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.writer.CityGMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class GsonWriter {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		// creating a Gson instance. Note that we have to define the
		// date format as specified by CityJSON
		System.out.println(df.format(new Date()) + "setting up Gson builder");
		Gson gson = new Gson();
		
		/*
		 * step 1: create an LOD2 building using the Gson binding classes for CityJSON
		 */
		System.out.println(df.format(new Date()) + "creating LOD2 building as Gson in-memory object tree");

		// we are using a helper class for building the CityJSON "vertices" array.
		// this helper class makes sure that there are not duplicate vertices
		DefaultVerticesBuilder verticesBuilder = new DefaultVerticesBuilder();

		// ok, let's create a building
		BuildingType building = new BuildingType("ID_test-building");
		
		// add some attributes
		BuildingAttributes attributes = new BuildingAttributes();
		attributes.setCreationDate(LocalDate.now());
		attributes.setClazz("residential building");
		attributes.addGenericAttribute("noOfInhabitants", 5);
		building.setAttributes(attributes);

		// create vertices lists for the outer surfaces of the building
		List<Double> ground = Arrays.asList(0.0,0.0,0.0, 0.0,12.0,0.0, 6.0,12.0,0.0, 6.0,0.0,0.0);
		List<Double> wall_1 = Arrays.asList(6.0,0.0,0.0, 6.0,12.0,0.0, 6.0,12.0,6.0, 6.0,0.0,6.0);
		List<Double> wall_2 = Arrays.asList(0.0,0.0,0.0, 0.0,0.0,6.0, 0.0,12.0,6.0, 0.0,12.0,0.0);
		List<Double> wall_3 = Arrays.asList(0.0,0.0,0.0, 6.0,0.0,0.0, 6.0,0.0,6.0, 3.0,0.0,9.0, 0.0,0.0,6.0);
		List<Double> wall_4 = Arrays.asList(6.0,12.0,0.0, 0.0,12.0,0.0, 0.0,12.0,6.0, 3.0,12.0,9.0, 6.0,12.0,6.0);
		List<Double> roof_1 = Arrays.asList(6.0,0.0,6.0, 6.0,12.0,6.0, 3.0,12.0,9.0, 3.0,0.0,9.0);
		List<Double> roof_2 = Arrays.asList(0.0,0.0,6.0, 3.0,0.0,9.0, 3.0,12.0,9.0, 0.0,12.0,6.0);

		// now let's build a Gson solid geometry from the double lists
		SolidType solid = new SolidType();
		List<List<List<Integer>>> shell = new ArrayList<>();

		// in CityJSON, a surface is a list of list to model the exterior and interior rings
		// for this reason, we have to wrap the above double lists by a singleton list
		// moreover, we use a SimpleVerticesBuilder to avoid duplicate vertices
		shell.add(Collections.singletonList(verticesBuilder.addVertices(ground)));
		shell.add(Collections.singletonList(verticesBuilder.addVertices(wall_1)));
		shell.add(Collections.singletonList(verticesBuilder.addVertices(wall_2)));
		shell.add(Collections.singletonList(verticesBuilder.addVertices(wall_3)));
		shell.add(Collections.singletonList(verticesBuilder.addVertices(wall_4)));
		shell.add(Collections.singletonList(verticesBuilder.addVertices(roof_1)));
		shell.add(Collections.singletonList(verticesBuilder.addVertices(roof_2)));

		solid.addShell(shell);
		solid.setLod(2);

		// now let's add semantics
		// first define the list of thematic boundary surfaces
		SolidSemanticsObject semantics = new SolidSemanticsObject();
		semantics.addSurface(new SemanticsType("GroundSurface"));
		semantics.addSurface(new SemanticsType("WallSurface"));
		semantics.addSurface(new SemanticsType("WallSurface"));
		semantics.addSurface(new SemanticsType("WallSurface"));
		semantics.addSurface(new SemanticsType("WallSurface"));
		semantics.addSurface(new SemanticsType("RoofSurface"));
		semantics.addSurface(new SemanticsType("RoofSurface"));

		// next, we define an index list which points into the list
		// of boundary surfaces for each surface geometry
		List<Integer> values = Arrays.asList(0, 1, 2, 3, 4, 5, 6);

		// since a solid can have multiple shells with multiple surfaces
		// we again have to wrap the index list by a singleton list
		semantics.setValues(Collections.singletonList(values));

		solid.setSemantics(semantics);

		// add the geometry to the building		
		building.addGeometry(solid);

		// create the CityJSON root element and
		// add both the building and the vertices 
		CityJSON cityJSON = new CityJSON();
		cityJSON.addCityObject(building);
		cityJSON.setVertices(verticesBuilder.build());

		// add some metadata
		MetadataType metadata = new MetadataType();
		metadata.setGeographicalExtent(cityJSON.calcBoundingBox());
		metadata.setPresentLoDs(cityJSON.calcPresentLoDs());
		metadata.setDatasetTitle("LOD2 building created with citygml4j");
		cityJSON.setMetadata(metadata);

		/*
		 * step 2: write the CityJSON object to a file
		 */
		System.out.println(df.format(new Date()) + "writing Gson object tree as CityJSON file");
		Files.createDirectories(Paths.get("output"));

		JsonWriter writer = new JsonWriter(new FileWriter(new File("output/LOD2_Building.json")));
		writer.setIndent(" ");

		gson.toJson(cityJSON, CityJSON.class, writer);
		writer.close();
		
		System.out.println(df.format(new Date()) + "CityJSON file LOD2_Building.json written");
		
		/*
		 * setp 3: let's also create a CityGML representation
		 * This is just to again demonstrate the simple conversion from CityJSON to CityGML
		 */
		System.out.println(df.format(new Date()) + "mapping CityJSON content to a citygml4j object tree");
		CityJSONUnmarshaller unmarshaller = new CityJSONUnmarshaller();		
		CityModel cityModel = unmarshaller.unmarshal(cityJSON);
		
		System.out.println(df.format(new Date()) + "creating CityGML builder");
		CityGMLContext ctx = CityGMLContext.getInstance();
		CityGMLBuilder cityGMLBuilder = ctx.createCityGMLBuilder();

		// create a CityGML output factory
		System.out.println(df.format(new Date()) + "writing citygml4j object tree as CityGML v2.0 file");
		CityGMLOutputFactory out = cityGMLBuilder.createCityGMLOutputFactory();

		CityGMLWriter cityGMLWriter = out.createCityGMLWriter(new File("output/LOD2_Building_v200.gml"));
		cityGMLWriter.setIndentString("  ");
		cityGMLWriter.setPrefixes(CityGMLVersion.v2_0_0);
		cityGMLWriter.setDefaultNamespace(CoreModule.v2_0_0);
		cityGMLWriter.setSchemaLocations(CityGMLVersion.v2_0_0);

		cityGMLWriter.write(cityModel);
		cityGMLWriter.close();
		
		System.out.println(df.format(new Date()) + "CityGML file LOD2_Building_v200.gml written");
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}
