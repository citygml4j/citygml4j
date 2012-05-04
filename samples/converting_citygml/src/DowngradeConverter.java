import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.CityGMLBuilder;
import org.citygml4j.model.citygml.bridge.AbstractBridge;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.citygml.core.LodRepresentation;
import org.citygml4j.model.citygml.generics.GenericCityObject;
import org.citygml4j.model.citygml.tunnel.AbstractTunnel;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.geometry.GeometryProperty;
import org.citygml4j.model.gml.geometry.aggregates.MultiGeometry;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.util.walker.FeatureWalker;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.reader.FeatureReadMode;
import org.citygml4j.xml.io.writer.CityModelWriter;

public class DowngradeConverter {

	public static void main(String[] args) throws Exception {
		final SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and JAXB builder");
		CityGMLContext ctx = new CityGMLContext();
		CityGMLBuilder builder = ctx.createCityGMLBuilder();

		System.out.println(df.format(new Date()) + "reading CityGML 2.0.0 file LOD3-Railway_v200.gml chunk-wise");
		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		in.setProperty(CityGMLInputFactory.FEATURE_READ_MODE, FeatureReadMode.SPLIT_PER_COLLECTION_MEMBER);
		CityGMLReader reader = in.createCityGMLReader(new File("../datasets/LOD3-Railway_v200.gml"));

		CityGMLVersion version = CityGMLVersion.v1_0_0;
		System.out.println(df.format(new Date()) + "writing citygml4j object tree as CityGML " + version + " document");
		CityGMLOutputFactory out = builder.createCityGMLOutputFactory();
		out.setCityGMLVersion(version);

		CityModelWriter writer = out.createCityModelWriter(new File("LOD3-Railway_v100.gml"));
		writer.setPrefixes(version);
		writer.setDefaultNamespace(CoreModule.v1_0_0);
		writer.setSchemaLocations(version);
		writer.setIndentString("  ");

		while (reader.hasNext()) {
			AbstractFeature feature = (AbstractFeature)reader.nextFeature();

			if (feature instanceof AbstractTunnel || feature instanceof AbstractBridge) {
				final GenericCityObject proxy = new GenericCityObject();
				proxy.setLod3Geometry(new GeometryProperty<MultiGeometry>(new MultiGeometry()));

				System.out.println(df.format(new Date()) + "converting " + ((AbstractCityObject)feature).getCityGMLClass() + " and nested features to " + proxy.getCityGMLClass());				

				FeatureWalker walker = new FeatureWalker() {
					public void visit(AbstractCityObject abstractCityObject) {
						System.out.println(df.format(new Date()) + "addind geometry of " + abstractCityObject.getCityGMLClass());				

						LodRepresentation lods = abstractCityObject.getLodRepresentation();
						if (lods.isSetLod3Geometry()) {
							MultiGeometry multiGeometry = (MultiGeometry)proxy.getLod3Geometry().getGeometry();
							multiGeometry.getGeometryMember().addAll(lods.getLodGeometry(3));	
						}
					}

					public void visit(AbstractBridge abstractBridge) {
						proxy.setId(abstractBridge.getId());
						proxy.setName(abstractBridge.getName());
						proxy.setClazz(abstractBridge.getClazz());
						proxy.setFunction(abstractBridge.getFunction());
						proxy.setUsage(abstractBridge.getUsage());
						proxy.setRelativeToTerrain(abstractBridge.getRelativeToTerrain());
						proxy.setRelativeToWater(abstractBridge.getRelativeToWater());
						super.visit(abstractBridge);
					}

					public void visit(AbstractTunnel abstractTunnel) {
						proxy.setId(abstractTunnel.getId());
						proxy.setName(abstractTunnel.getName());
						proxy.setClazz(abstractTunnel.getClazz());
						proxy.setFunction(abstractTunnel.getFunction());
						proxy.setUsage(abstractTunnel.getUsage());
						proxy.setRelativeToTerrain(abstractTunnel.getRelativeToTerrain());
						proxy.setRelativeToWater(abstractTunnel.getRelativeToWater());
						super.visit(abstractTunnel);
					}

				};

				feature.accept(walker);
				feature = proxy;
			}

			if (!(feature instanceof CityModel))
				writer.writeFeatureMember(feature);
		}

		reader.close();
		writer.close();

		System.out.println(df.format(new Date()) + "CityGML file LOD3-Railway_v100.gml written");
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}
}
