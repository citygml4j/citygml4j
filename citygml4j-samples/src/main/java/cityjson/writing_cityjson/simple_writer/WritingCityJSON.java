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
package cityjson.writing_cityjson.simple_writer;

import org.citygml4j.CityGMLContext;
import org.citygml4j.binding.cityjson.metadata.MetadataType;
import org.citygml4j.builder.cityjson.CityJSONBuilder;
import org.citygml4j.builder.cityjson.json.io.writer.CityJSONOutputFactory;
import org.citygml4j.builder.cityjson.json.io.writer.CityJSONWriter;
import org.citygml4j.builder.jaxb.CityGMLBuilder;
import org.citygml4j.factory.GMLGeometryFactory;
import org.citygml4j.model.citygml.appearance.Appearance;
import org.citygml4j.model.citygml.appearance.AppearanceProperty;
import org.citygml4j.model.citygml.appearance.Color;
import org.citygml4j.model.citygml.appearance.SurfaceDataProperty;
import org.citygml4j.model.citygml.appearance.X3DMaterial;
import org.citygml4j.model.citygml.building.Building;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.citygml.core.CityObjectMember;
import org.citygml4j.model.citygml.landuse.LandUse;
import org.citygml4j.model.citygml.transportation.Road;
import org.citygml4j.model.citygml.transportation.TrafficArea;
import org.citygml4j.model.citygml.transportation.TrafficAreaProperty;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurface;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurfaceProperty;
import org.citygml4j.model.gml.geometry.primitives.Solid;
import org.citygml4j.model.gml.geometry.primitives.SolidProperty;
import org.citygml4j.model.gml.measures.Length;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.util.bbox.BoundingBoxOptions;
import org.citygml4j.util.gmlid.DefaultGMLIdManager;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.writer.CityGMLWriter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Date;

public class WritingCityJSON {

	public static void main(String[] args) throws Exception {
		final SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and CityJSON builder");
		CityGMLContext ctx = CityGMLContext.getInstance();
		CityJSONBuilder builder = ctx.createCityJSONBuilder();

		/*
		 * let's create some dummy and simple city objects using
		 * the citygml4j model classes
		 */

		// create a city model
		System.out.println(df.format(new Date()) + "creating a sample LOD2 city model as citygml4j in-memory object tree");
		CityModel cityModel = new CityModel();
		GMLGeometryFactory geom = new GMLGeometryFactory();

		// create a building
		System.out.println(df.format(new Date()) + "adding a building to the city model");
		Building building = new Building();

		// add a LoD2 solid geometry to the building
		Solid buildingSolid = geom.createSolid(
				geom.createLinearPolygon(new double[] {0,0,0, 0,12,0, 6,12,0, 6,0,0}, 3),
				geom.createLinearPolygon(new double[] {6,0,0, 6,12,0, 6,12,6, 6,0,6}, 3),
				geom.createLinearPolygon(new double[] {0,0,0, 0,0,6, 0,12,6, 0,12,0}, 3),
				geom.createLinearPolygon(new double[] {0,0,0, 6,0,0, 6,0,6, 3,0,9, 0,0,6}, 3),
				geom.createLinearPolygon(new double[] {6,12,0, 0,12,0, 0,12,6, 3,12,9, 6,12,6}, 3),
				geom.createLinearPolygon(new double[] {6,0,6, 6,12,6, 3,12,9, 3,0,9}, 3),
				geom.createLinearPolygon(new double[] {0,0,6, 3,0,9, 3,12,9, 0,12,6}, 3));
		building.setLod2Solid(new SolidProperty(buildingSolid));
		buildingSolid.getExterior().getSurface().setId(DefaultGMLIdManager.getInstance().generateUUID());
		
		// let's paint the solid geometry in grey
		X3DMaterial material = new X3DMaterial();
		material.setDiffuseColor(new Color(0.8, 0.8, 0.8));
		material.addTarget("#" + buildingSolid.getExterior().getSurface().getId());

		Appearance appearance = new Appearance();
		appearance.setTheme("default");
		appearance.addSurfaceDataMember(new SurfaceDataProperty(material));
		building.addAppearance(new AppearanceProperty(appearance));

		// add some attributes to the building
		building.setMeasuredHeight(new Length(12.0));
		building.setYearOfConstruction(2017);
		building.setClazz(new Code("residential building"));

		// add the building to the city model
		cityModel.addCityObjectMember(new CityObjectMember(building));

		// create a road
		System.out.println(df.format(new Date()) + "adding a road to the city model");
		Road road = new Road();

		// create traffic area and add some geometry
		TrafficArea trafficArea = new TrafficArea();
		MultiSurface trafficAreaSurface = geom.createMultiSurface(geom.createLinearPolygon(new double[] {0,0,0, 0,-4,0, 18,-4,0, 18,0,0}, 3));
		trafficArea.setLod2MultiSurface(new MultiSurfaceProperty(trafficAreaSurface));

		// add some attributes to the traffic area
		trafficArea.setSurfaceMaterial(new Code("asphalt"));

		// add the traffic to the road and the road to the city model
		road.addTrafficArea(new TrafficAreaProperty(trafficArea));
		cityModel.addCityObjectMember(new CityObjectMember(road));

		// create a land use object and add some geometry
		System.out.println(df.format(new Date()) + "adding a land use object to the city model");
		LandUse landUse = new LandUse();

		MultiSurface landUseSurface = geom.createMultiSurface(geom.createLinearPolygon(new double[] {6,0,0, 18,0,0, 18,12,0, 6,12,0}, 3));
		landUse.setLod2MultiSurface(new MultiSurfaceProperty(landUseSurface));

		// add some attributes
		landUse.setClazz(new Code("park"));

		// add the land use object to the city model
		cityModel.addCityObjectMember(new CityObjectMember(landUse));

		// create metadata information for the CityJSON file
		// note: this metadata information is specific to CityJSON 
		// we therefore have to use CityJSON binding classes 
		MetadataType metadata = new MetadataType();

		// add a CRS
		metadata.setReferenceSystem(3068);

		// add some further metadata tags
		metadata.setDatasetTitle("CityJSON sample file created with citygml4j");
		metadata.setDatasetLanguage("en");
		metadata.setDatasetReferenceDate(ZonedDateTime.now());

		/*
		 * Now we are ready to write the citygml4j object tree as CityJSON.
		 * Similar to writing a CityGML file, you simply have to create a
		 * CityJSON output factory and use it to create a CityJSON writer.
		 */

		// create a CityJSON writer and write the city model to a file
		System.out.println(df.format(new Date()) + "writing citygml4j object tree as CityJSON file");
		CityJSONOutputFactory out = builder.createCityJSONOutputFactory();
		try (CityJSONWriter writer = out.createCityJSONWriter(new File("output/SimpleCityJSON.json"))) {
			// set writer options and metadata
			writer.setIndent(" ");
			writer.setHtmlSafe(true);
			writer.setMetadata(metadata);

			// finally, write city model
			writer.write(cityModel);
		}

		System.out.println(df.format(new Date()) + "CityJSON file SimpleCityJSON.json written");

		/*
		 * And we easily can write the same citygml4j object tree as CityGML... 
		 */

		// let's first set a bounding box on the city model
		BoundingShape boundedBy = cityModel.calcBoundedBy(BoundingBoxOptions.defaults());
		boundedBy.getEnvelope().setSrsName("EPSG:3068");
		cityModel.setBoundedBy(boundedBy);

		// ok, write the content as CityGML file
		System.out.println(df.format(new Date()) + "writing citygml4j object tree as CityGML v2.0.0 file");
		CityGMLBuilder cityGMLBuilder = ctx.createCityGMLBuilder();
		CityGMLOutputFactory cityGMLOut = cityGMLBuilder.createCityGMLOutputFactory(CityGMLVersion.v2_0_0);

		try (CityGMLWriter writer = cityGMLOut.createCityGMLWriter(new File("output/SimpleCityGML.gml"))) {
			writer.setPrefixes(CityGMLVersion.v2_0_0);			
			writer.setIndentString(" ");
			writer.write(cityModel);
		}

		System.out.println(df.format(new Date()) + "CityGML file SimpleCityGML.gml written");
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}
