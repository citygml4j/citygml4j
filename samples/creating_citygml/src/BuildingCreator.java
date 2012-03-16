/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universitaet Berlin, Germany
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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
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
import org.citygml4j.factory.BuildingFactory;
import org.citygml4j.factory.CoreFactory;
import org.citygml4j.factory.GMLFactory;
import org.citygml4j.factory.geometry.GMLGeometryFactory;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.building.AbstractBoundarySurface;
import org.citygml4j.model.citygml.building.BoundarySurfaceProperty;
import org.citygml4j.model.citygml.building.Building;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.gml.geometry.complexes.CompositeSurface;
import org.citygml4j.model.gml.geometry.primitives.Polygon;
import org.citygml4j.model.gml.geometry.primitives.Solid;
import org.citygml4j.model.gml.geometry.primitives.SurfaceProperty;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.util.gmlid.DefaultGMLIdManager;
import org.citygml4j.util.gmlid.GMLIdManager;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.writer.CityGMLWriter;


public class BuildingCreator {
	private CoreFactory core;
	private BuildingFactory bldg;
	private GMLFactory gml;

	public static void main(String[] args) throws Exception {
		new BuildingCreator().doMain();
	}

	public void doMain() throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and JAXB builder");
		CityGMLContext ctx = new CityGMLContext();
		CityGMLBuilder builder = ctx.createCityGMLBuilder();

		System.out.println(df.format(new Date()) + "creating LOD2 building as citygml4j in-memory object tree");
		GMLGeometryFactory geom = new GMLGeometryFactory();
		core = new CoreFactory();
		bldg = new BuildingFactory();
		gml = new GMLFactory();

		GMLIdManager gmlIdManager = DefaultGMLIdManager.getInstance();

		Building building = bldg.createBuilding();

		Polygon ground = geom.createLinearPolygon(new double[] {0,0,0, 0,12,0, 6,12,0, 6,0,0, 0,0,0}, 3);
		Polygon wall_1 = geom.createLinearPolygon(new double[] {6,0,0, 6,12,0, 6,12,6, 6,0,6, 6,0,0}, 3);
		Polygon wall_2 = geom.createLinearPolygon(new double[] {0,0,0, 0,0,6, 0,12,6, 0,12,0, 0,0,0}, 3);
		Polygon wall_3 = geom.createLinearPolygon(new double[] {0,0,0, 6,0,0, 6,0,6, 3,0,9, 0,0,6, 0,0,0}, 3);
		Polygon wall_4 = geom.createLinearPolygon(new double[] {6,12,0, 0,12,0, 0,12,6, 3,12,9, 6,12,6, 6,12,0}, 3);
		Polygon roof_1 = geom.createLinearPolygon(new double[] {6,0,6, 6,12,6, 3,12,9, 3,0,9, 6,0,6}, 3);
		Polygon roof_2 = geom.createLinearPolygon(new double[] {0,0,6, 3,0,9, 3,12,9, 0,12,6, 0,0,6}, 3);

		ground.setId(gmlIdManager.generateUUID());
		wall_1.setId(gmlIdManager.generateUUID());
		wall_2.setId(gmlIdManager.generateUUID());
		wall_3.setId(gmlIdManager.generateUUID());
		wall_4.setId(gmlIdManager.generateUUID());
		roof_1.setId(gmlIdManager.generateUUID());
		roof_2.setId(gmlIdManager.generateUUID());

		// lod2 solid
		List<SurfaceProperty> surfaceMember = new ArrayList<SurfaceProperty>();
		surfaceMember.add(gml.createSurfaceProperty('#' + ground.getId()));
		surfaceMember.add(gml.createSurfaceProperty('#' + wall_1.getId()));
		surfaceMember.add(gml.createSurfaceProperty('#' + wall_2.getId()));
		surfaceMember.add(gml.createSurfaceProperty('#' + wall_3.getId()));
		surfaceMember.add(gml.createSurfaceProperty('#' + wall_4.getId()));
		surfaceMember.add(gml.createSurfaceProperty('#' + roof_1.getId()));
		surfaceMember.add(gml.createSurfaceProperty('#' + roof_2.getId()));

		CompositeSurface compositeSurface = gml.createCompositeSurface();
		compositeSurface.setSurfaceMember(surfaceMember);		
		Solid solid = gml.createSolid();
		solid.setExterior(gml.createSurfaceProperty(compositeSurface));

		building.setLod2Solid(gml.createSolidProperty(solid));

		// thematic boundary surfaces
		List<BoundarySurfaceProperty> boundedBy = new ArrayList<BoundarySurfaceProperty>();
		boundedBy.add(createBoundarySurface(CityGMLClass.GROUND_SURFACE, ground));
		boundedBy.add(createBoundarySurface(CityGMLClass.WALL_SURFACE, wall_1));
		boundedBy.add(createBoundarySurface(CityGMLClass.WALL_SURFACE, wall_2));
		boundedBy.add(createBoundarySurface(CityGMLClass.WALL_SURFACE, wall_3));
		boundedBy.add(createBoundarySurface(CityGMLClass.WALL_SURFACE, wall_4));
		boundedBy.add(createBoundarySurface(CityGMLClass.ROOF_SURFACE, roof_1));
		boundedBy.add(createBoundarySurface(CityGMLClass.ROOF_SURFACE, roof_2));		
		building.setBoundedBySurface(boundedBy);

		CityModel cityModel = core.createCityModel();
		cityModel.setBoundedBy(building.calcBoundedBy(false));
		cityModel.addCityObjectMember(core.createCityObjectMember(building));

		System.out.println(df.format(new Date()) + "writing citygml4j object tree");
		CityGMLOutputFactory out = builder.createCityGMLOutputFactory(CityGMLVersion.v1_0_0);
		CityGMLWriter writer = out.createCityGMLWriter(new File("LOD2_Building_v100.xml"));

		writer.setPrefixes(CityGMLVersion.v1_0_0);
		writer.setSchemaLocations(CityGMLVersion.v1_0_0);
		writer.setIndentString("  ");
		writer.write(cityModel);
		writer.close();	
		
		System.out.println(df.format(new Date()) + "CityGML file LOD2_Building_v100.xml written");
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

	private BoundarySurfaceProperty createBoundarySurface(CityGMLClass type, Polygon geometry) {
		AbstractBoundarySurface boundarySurface = null;

		switch (type) {
		case WALL_SURFACE:
			boundarySurface = bldg.createWallSurface();
			break;
		case ROOF_SURFACE:
			boundarySurface = bldg.createRoofSurface();
			break;
		case GROUND_SURFACE:
			boundarySurface = bldg.createGroundSurface();
			break;
		}

		if (boundarySurface != null) {
			boundarySurface.setLod2MultiSurface(gml.createMultiSurfaceProperty(gml.createMultiSurface(geometry)));
			return bldg.createBoundarySurfaceProperty(boundarySurface);
		}

		return null;
	}

}
