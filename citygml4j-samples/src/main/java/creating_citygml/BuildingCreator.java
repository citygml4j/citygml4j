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
package creating_citygml;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.CityGMLBuilder;
import org.citygml4j.factory.GMLGeometryFactory;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.building.AbstractBoundarySurface;
import org.citygml4j.model.citygml.building.BoundarySurfaceProperty;
import org.citygml4j.model.citygml.building.Building;
import org.citygml4j.model.citygml.building.GroundSurface;
import org.citygml4j.model.citygml.building.RoofSurface;
import org.citygml4j.model.citygml.building.WallSurface;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.citygml.core.CityObjectMember;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurface;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurfaceProperty;
import org.citygml4j.model.gml.geometry.complexes.CompositeSurface;
import org.citygml4j.model.gml.geometry.primitives.Polygon;
import org.citygml4j.model.gml.geometry.primitives.Solid;
import org.citygml4j.model.gml.geometry.primitives.SolidProperty;
import org.citygml4j.model.gml.geometry.primitives.SurfaceProperty;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.util.bbox.BoundingBoxOptions;
import org.citygml4j.util.gmlid.DefaultGMLIdManager;
import org.citygml4j.util.gmlid.GMLIdManager;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.writer.CityGMLWriter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BuildingCreator {

	public static void main(String[] args) throws Exception {
		new BuildingCreator().doMain();
	}

	private void doMain() throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] ");

		System.out.println(df.format(new Date()) + "setting up citygml4j context and CityGML builder");
		CityGMLContext ctx = CityGMLContext.getInstance();
		CityGMLBuilder builder = ctx.createCityGMLBuilder();

		System.out.println(df.format(new Date()) + "creating LOD2 building as citygml4j in-memory object tree");
		GMLGeometryFactory geom = new GMLGeometryFactory();

		GMLIdManager gmlIdManager = DefaultGMLIdManager.getInstance();

		Building building = new Building();

		Polygon ground = geom.createLinearPolygon(new double[] {0,0,0, 0,12,0, 6,12,0, 6,0,0}, 3);
		Polygon wall_1 = geom.createLinearPolygon(new double[] {6,0,0, 6,12,0, 6,12,6, 6,0,6}, 3);
		Polygon wall_2 = geom.createLinearPolygon(new double[] {0,0,0, 0,0,6, 0,12,6, 0,12,0}, 3);
		Polygon wall_3 = geom.createLinearPolygon(new double[] {0,0,0, 6,0,0, 6,0,6, 3,0,9, 0,0,6}, 3);
		Polygon wall_4 = geom.createLinearPolygon(new double[] {6,12,0, 0,12,0, 0,12,6, 3,12,9, 6,12,6}, 3);
		Polygon roof_1 = geom.createLinearPolygon(new double[] {6,0,6, 6,12,6, 3,12,9, 3,0,9}, 3);
		Polygon roof_2 = geom.createLinearPolygon(new double[] {0,0,6, 3,0,9, 3,12,9, 0,12,6}, 3);

		ground.setId(gmlIdManager.generateUUID());
		wall_1.setId(gmlIdManager.generateUUID());
		wall_2.setId(gmlIdManager.generateUUID());
		wall_3.setId(gmlIdManager.generateUUID());
		wall_4.setId(gmlIdManager.generateUUID());
		roof_1.setId(gmlIdManager.generateUUID());
		roof_2.setId(gmlIdManager.generateUUID());

		// lod2 solid
		List<SurfaceProperty> surfaceMember = new ArrayList<>();
		surfaceMember.add(new SurfaceProperty('#' + ground.getId()));
		surfaceMember.add(new SurfaceProperty('#' + wall_1.getId()));
		surfaceMember.add(new SurfaceProperty('#' + wall_2.getId()));
		surfaceMember.add(new SurfaceProperty('#' + wall_3.getId()));
		surfaceMember.add(new SurfaceProperty('#' + wall_4.getId()));
		surfaceMember.add(new SurfaceProperty('#' + roof_1.getId()));
		surfaceMember.add(new SurfaceProperty('#' + roof_2.getId()));

		CompositeSurface compositeSurface = new CompositeSurface();
		compositeSurface.setSurfaceMember(surfaceMember);		
		Solid solid = new Solid();
		solid.setExterior(new SurfaceProperty(compositeSurface));

		building.setLod2Solid(new SolidProperty(solid));

		// thematic boundary surfaces
		List<BoundarySurfaceProperty> boundedBy = new ArrayList<>();
		boundedBy.add(createBoundarySurface(CityGMLClass.BUILDING_GROUND_SURFACE, ground));
		boundedBy.add(createBoundarySurface(CityGMLClass.BUILDING_WALL_SURFACE, wall_1));
		boundedBy.add(createBoundarySurface(CityGMLClass.BUILDING_WALL_SURFACE, wall_2));
		boundedBy.add(createBoundarySurface(CityGMLClass.BUILDING_WALL_SURFACE, wall_3));
		boundedBy.add(createBoundarySurface(CityGMLClass.BUILDING_WALL_SURFACE, wall_4));
		boundedBy.add(createBoundarySurface(CityGMLClass.BUILDING_ROOF_SURFACE, roof_1));
		boundedBy.add(createBoundarySurface(CityGMLClass.BUILDING_ROOF_SURFACE, roof_2));		
		building.setBoundedBySurface(boundedBy);

		CityModel cityModel = new CityModel();
		cityModel.setBoundedBy(building.calcBoundedBy(BoundingBoxOptions.defaults()));
		cityModel.addCityObjectMember(new CityObjectMember(building));

		System.out.println(df.format(new Date()) + "writing citygml4j object tree");
		CityGMLOutputFactory out = builder.createCityGMLOutputFactory(CityGMLVersion.DEFAULT);
		CityGMLWriter writer = out.createCityGMLWriter(new File("output/LOD2_Building_v200.gml"), "UTF-8");

		writer.setPrefixes(CityGMLVersion.DEFAULT);
		writer.setSchemaLocations(CityGMLVersion.DEFAULT);
		writer.setIndentString("  ");
		writer.write(cityModel);
		writer.close();	
		
		System.out.println(df.format(new Date()) + "CityGML file LOD2_Building_v200.gml written");
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

	private BoundarySurfaceProperty createBoundarySurface(CityGMLClass type, Polygon geometry) {
		AbstractBoundarySurface boundarySurface = null;

		switch (type) {
		case BUILDING_WALL_SURFACE:
			boundarySurface = new WallSurface();
			break;
		case BUILDING_ROOF_SURFACE:
			boundarySurface = new RoofSurface();
			break;
		case BUILDING_GROUND_SURFACE:
			boundarySurface = new GroundSurface();
			break;
		default:
			break;
		}

		if (boundarySurface != null) {
			boundarySurface.setLod2MultiSurface(new MultiSurfaceProperty(new MultiSurface(geometry)));
			return new BoundarySurfaceProperty(boundarySurface);
		}

		return null;
	}

}
