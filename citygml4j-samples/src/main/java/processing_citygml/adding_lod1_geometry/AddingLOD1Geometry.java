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
package processing_citygml.adding_lod1_geometry;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.CityGMLBuilder;
import org.citygml4j.factory.GMLGeometryFactory;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.geometry.Point;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.building.Building;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.gml.geometry.complexes.CompositeSurface;
import org.citygml4j.model.gml.geometry.primitives.AbstractSurface;
import org.citygml4j.model.gml.geometry.primitives.Solid;
import org.citygml4j.model.gml.geometry.primitives.SolidProperty;
import org.citygml4j.model.gml.geometry.primitives.SurfaceProperty;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.util.bbox.BoundingBoxOptions;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.reader.FeatureReadMode;
import org.citygml4j.xml.io.writer.CityModelWriter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AddingLOD1Geometry {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and CityGML builder");
		CityGMLContext ctx = CityGMLContext.getInstance();
		CityGMLBuilder builder = ctx.createCityGMLBuilder();
	
		GMLGeometryFactory geom = new GMLGeometryFactory();
		
		System.out.println(df.format(new Date()) + "reading CityGML file LOD2_Buildings_v100.gml chunk-wise");
		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		in.setProperty(CityGMLInputFactory.FEATURE_READ_MODE, FeatureReadMode.SPLIT_PER_COLLECTION_MEMBER);
		in.setProperty(CityGMLInputFactory.KEEP_INLINE_APPEARANCE, false);
			
		CityGMLReader reader = in.createCityGMLReader(new File("datasets/LOD2_Buildings_v100.gml"));
		
		System.out.println(df.format(new Date()) + "opening CityGML writer");
		CityGMLOutputFactory out = builder.createCityGMLOutputFactory();
		out.setCityGMLVersion(CityGMLVersion.v1_0_0);

		CityModelWriter writer = out.createCityModelWriter(new File("output/LOD1_and_LOD2_Buildings_v100.gml"));
		writer.setPrefixes(CityGMLVersion.v1_0_0);
		writer.setDefaultNamespace(CoreModule.v1_0_0);
		writer.setSchemaLocations(CityGMLVersion.v1_0_0);
		writer.setIndentString("  ");

		writer.writeStartDocument();
		
		while (reader.hasNext()) {
			CityGML feature = reader.nextFeature();
			
			if (feature.getCityGMLClass() == CityGMLClass.BUILDING) {
				Building building = (Building)feature;
				System.out.println(df.format(new Date()) + "adding LOD1 geometry representation to building " + building.getId());
				
				BoundingShape boundingShape = building.calcBoundedBy(BoundingBoxOptions.defaults());
				building.setBoundedBy(boundingShape);
				BoundingBox bbox = boundingShape.getEnvelope().toBoundingBox();
				
				Point lowerCorner = bbox.getLowerCorner();
				Point upperCorner = bbox.getUpperCorner();
				
				double xmin = lowerCorner.getX();
				double ymin = lowerCorner.getY();
				double zmin = lowerCorner.getZ();
				
				double xmax = upperCorner.getX();
				double ymax = upperCorner.getY();
				double zmax = upperCorner.getZ();
				
				List<AbstractSurface> shell = new ArrayList<>();
				shell.add(geom.createLinearPolygon(new double[]{xmin,ymin,zmin, xmin,ymax,zmin, xmax,ymax,zmin, xmax,ymin,zmin}, 3));
				shell.add(geom.createLinearPolygon(new double[]{xmin,ymax,zmin, xmin,ymax,zmax, xmax,ymax,zmax, xmax,ymax,zmin}, 3));
				shell.add(geom.createLinearPolygon(new double[]{xmin,ymin,zmax, xmin,ymin,zmin, xmax,ymin,zmin, xmax,ymin,zmax}, 3));
				shell.add(geom.createLinearPolygon(new double[]{xmax,ymin,zmin, xmax,ymax,zmin, xmax,ymax,zmax, xmax,ymin,zmax}, 3));
				shell.add(geom.createLinearPolygon(new double[]{xmin,ymin,zmin, xmin,ymin,zmax, xmin,ymax,zmax, xmin,ymax,zmin}, 3));
				shell.add(geom.createLinearPolygon(new double[]{xmin,ymin,zmax, xmax,ymin,zmax, xmax,ymax,zmax, xmin,ymax,zmax}, 3));
				
				CompositeSurface exterior =new CompositeSurface(shell);
				Solid solid = new Solid();
				solid.setExterior(new SurfaceProperty(exterior));

				building.setLod1Solid(new SolidProperty(solid));
				
				writer.writeFeatureMember(building);
			}
		}
		
		reader.close();
		writer.close();
		
		System.out.println(df.format(new Date()) + "CityGML file LOD1_and_LOD2_Buildings_v100.gml written");
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}
