import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.JAXBBuilder;
import org.citygml4j.factory.GMLFactory;
import org.citygml4j.factory.geometry.GMLGeometryFactory;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.geometry.Point;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.building.Building;
import org.citygml4j.model.gml.AbstractSurface;
import org.citygml4j.model.gml.BoundingShape;
import org.citygml4j.model.gml.CompositeSurface;
import org.citygml4j.model.gml.Solid;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.reader.FeatureReadMode;
import org.citygml4j.xml.io.writer.CityModelWriter;


public class AddingLOD1Geometry {

	public static void main(String[] args) throws Exception {
		CityGMLContext ctx = new CityGMLContext();
		JAXBBuilder builder = ctx.createJAXBBuilder();
	
		GMLFactory gml = new GMLFactory();
		GMLGeometryFactory geom = new GMLGeometryFactory();
		
		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		in.setProperty(CityGMLInputFactory.FEATURE_READ_MODE, FeatureReadMode.SPLIT_PER_COLLECTION_MEMBER);
		in.setProperty(CityGMLInputFactory.KEEP_INLINE_APPEARANCE, false);
			
		CityGMLReader reader = in.createCityGMLReader(new File("../../datasets/LOD2_Buildings_v100.xml"));
		
		CityGMLOutputFactory out = builder.createCityGMLOutputFactory();
		out.setCityGMLVersion(CityGMLVersion.v0_4_0);

		CityModelWriter writer = out.createCityModelWriter(new File("LOD1_and_LOD2_Buildings_v040.xml"));
		writer.setPrefixes(CityGMLVersion.v0_4_0);
		writer.setDefaultNamespace(CoreModule.v0_4_0);
		writer.setSchemaLocations(CityGMLVersion.v0_4_0);
		writer.setIndentString("  ");

		writer.writeStartDocument();
		
		while (reader.hasNextFeature()) {
			CityGML feature = reader.nextFeature();
			
			if (feature.getCityGMLClass() == CityGMLClass.BUILDING) {
				Building building = (Building)feature;
				
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
				
				CompositeSurface exterior = gml.createCompositeSurface(shell);
				Solid solid = gml.createSolid();
				solid.setExterior(gml.createSurfaceProperty(exterior));

				building.setLod1Solid(gml.createSolidProperty(solid));
				
				writer.writeFeatureMember(building);
			}
		}
		
		reader.close();
		writer.close();
	}

}
