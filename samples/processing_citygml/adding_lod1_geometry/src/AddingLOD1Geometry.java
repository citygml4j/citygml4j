/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2012
 * Institute for Geodesy and Geoinformation Science
 * Technische Universität Berlin, Germany
 * http://www.igg.tu-berlin.de/
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.CityGMLBuilder;
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
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.reader.FeatureReadMode;
import org.citygml4j.xml.io.writer.CityModelWriter;


public class AddingLOD1Geometry {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and JAXB builder");
		CityGMLContext ctx = new CityGMLContext();
		CityGMLBuilder builder = ctx.createCityGMLBuilder();
	
		GMLGeometryFactory geom = new GMLGeometryFactory();
		
		System.out.println(df.format(new Date()) + "reading CityGML file LOD2_Buildings_v100.gml chunk-wise");
		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		in.setProperty(CityGMLInputFactory.FEATURE_READ_MODE, FeatureReadMode.SPLIT_PER_COLLECTION_MEMBER);
		in.setProperty(CityGMLInputFactory.KEEP_INLINE_APPEARANCE, false);
			
		CityGMLReader reader = in.createCityGMLReader(new File("../../datasets/LOD2_Buildings_v100.gml"));
		
		System.out.println(df.format(new Date()) + "opening CityGML writer");
		CityGMLOutputFactory out = builder.createCityGMLOutputFactory();
		out.setCityGMLVersion(CityGMLVersion.v1_0_0);

		CityModelWriter writer = out.createCityModelWriter(new File("LOD1_and_LOD2_Buildings_v100.gml"));
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
				
				BoundingShape boundingShape = building.calcBoundedBy(false);
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
				
				List<AbstractSurface> shell = new ArrayList<AbstractSurface>();
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
