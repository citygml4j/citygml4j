import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.JAXBBuilder;
import org.citygml4j.factory.GMLFactory;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.geometry.Point;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.gml.AbstractFeature;
import org.citygml4j.model.gml.BoundingShape;
import org.citygml4j.model.gml.StringOrRef;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.reader.FeatureReadMode;
import org.citygml4j.xml.io.writer.CityModelInfo;
import org.citygml4j.xml.io.writer.CityModelWriter;

public class SimpleSpatialFilter {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and JAXB builder");
		CityGMLContext ctx = new CityGMLContext();
		JAXBBuilder builder = ctx.createJAXBBuilder();
		GMLFactory gml = new GMLFactory();
		
		System.out.println(df.format(new Date()) + "reading CityGML file LOD3_Ettenheim_v100.xml chunk-wise");
		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		in.setProperty(CityGMLInputFactory.FEATURE_READ_MODE, FeatureReadMode.SPLIT_PER_COLLECTION_MEMBER);

		CityGMLReader reader = in.createCityGMLReader(new File("../../datasets/LOD3_Ettenheim_v100.xml"));

		System.out.println(df.format(new Date()) + "creating CityGML 1.0.0 model writer");
		CityGMLOutputFactory out = builder.createCityGMLOutputFactory();
		out.setCityGMLVersion(CityGMLVersion.v1_0_0);

		CityModelWriter writer = out.createCityModelWriter(new File("LOD3_Ettenheim_cutout_v100.xml"));
		writer.setPrefixes(CityGMLVersion.v1_0_0);
		writer.setDefaultNamespace(CoreModule.v1_0_0);
		writer.setSchemaLocations(CityGMLVersion.v1_0_0);
		writer.setIndentString("  ");
		writer.setHeaderComment("written by citygml4j");

		System.out.println(df.format(new Date()) + "creating region filter as bounding box");
		BoundingBox regionFilter = new BoundingBox();
		regionFilter.setLowerCorner(new Point(3450376, 5430359, 0));
		regionFilter.setUpperCorner(new Point(3450434, 5430424, 0));

		CityModelInfo info = new CityModelInfo();
		StringOrRef description = gml.createStringOrRef();
		description.setValue("Cutout of original LOD3 Ettenheim scene to demonstrate simple spatial filtering.");
		info.setDescription(description);
		info.setBoundedBy(gml.createBoundingShape(regionFilter));
		
		writer.setCityModelInfo(info);
		writer.writeStartDocument();

		while (reader.hasNextFeature()) {
			CityGML chunk = reader.nextFeature();

			if (chunk instanceof AbstractFeature) {
				AbstractFeature feature = (AbstractFeature)chunk;

				System.out.println(df.format(new Date()) + "calculating bounding box of feature " + feature.getId());
				BoundingShape boundedBy = feature.calcBoundedBy(false);

				if (boundedBy != null) {
					BoundingBox bbox = boundedBy.getEnvelope().toBoundingBox();

					if (bbox.getLowerCorner().getX() >= regionFilter.getLowerCorner().getX() &&
							bbox.getLowerCorner().getY() >= regionFilter.getLowerCorner().getY() &&
							bbox.getUpperCorner().getX() <= regionFilter.getUpperCorner().getX() &&
							bbox.getUpperCorner().getY() <= regionFilter.getUpperCorner().getY()) {
						System.out.println(df.format(new Date()) + "feature is within region filter - keeping");
						feature.setBoundedBy(boundedBy);
						writer.writeFeatureMember(feature);
					}
				}
			}
		}

		writer.writeEndDocument();

		reader.close();
		writer.close();
		
		System.out.println(df.format(new Date()) + "CityGML file LOD3_Ettenheim_cutout_v100.xml written");
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}
