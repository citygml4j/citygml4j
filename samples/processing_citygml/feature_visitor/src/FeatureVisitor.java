import java.io.File;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.JAXBBuilder;
import org.citygml4j.commons.gmlid.DefaultGMLIdManager;
import org.citygml4j.commons.gmlid.GMLIdManager;
import org.citygml4j.factory.CityGMLFactory;
import org.citygml4j.model.citygml.appearance.Appearance;
import org.citygml4j.model.citygml.appearance.X3DMaterial;
import org.citygml4j.model.citygml.building.BoundarySurface;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.gml.MultiSurface;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.visitor.walker.FeatureWalker;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.writer.CityGMLWriter;

public class FeatureVisitor {

	public static void main(String[] args) throws Exception {
		CityGMLContext ctx = new CityGMLContext();
		JAXBBuilder builder = ctx.createJAXBBuilder();

		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		CityGMLReader reader = in.createCityGMLReader(new File("../../datasets/LOD2_Building_v100.xml"));
		CityModel cityModel = (CityModel)reader.nextFeature();
		reader.close();

		final GMLIdManager gmlIdManager = DefaultGMLIdManager.getInstance();
		final CityGMLFactory citygml = new CityGMLFactory();

		FeatureWalker walker = new FeatureWalker() {

			@Override
			public void accept(BoundarySurface boundarySurface) {
				MultiSurface multiSurface = boundarySurface.getLod2MultiSurface().getMultiSurface();
				String id = multiSurface.getId();
				if (id == null || id.length() == 0) {
					id = gmlIdManager.generateGmlId();
					multiSurface.setId(id);
				}

				Double red, green, blue;
				switch (boundarySurface.getCityGMLClass()) {
				case ROOFSURFACE:
					red = 1.0; green = 0.0; blue = 0.0;
					break;
				case WALLSURFACE:
					red = 0.5; green = 0.5; blue = 0.5;
					break;
				default:
					red = 0.3; green = 0.3; blue = 0.3;
				}

				X3DMaterial material = citygml.createX3DMaterial();
				material.setDiffuseColor(citygml.createColor(red, green, blue));
				material.addTarget('#' + id);

				Appearance appearance = citygml.createAppearance();
				appearance.setTheme("rgbColor");
				appearance.addSurfaceDataMember(citygml.createSurfaceDataProperty(material));

				boundarySurface.addAppearance(citygml.createAppearanceProperty(appearance));
				super.accept(boundarySurface);
			}

		};

		cityModel.visit(walker);

		CityGMLOutputFactory out = builder.createCityGMLOutputFactory(CityGMLVersion.v1_0_0);

		CityGMLWriter writer = out.createCityGMLWriter(new File("LOD2_Building_colorized_v100.xml"));
		writer.setPrefixes(CityGMLVersion.v1_0_0);
		writer.setDefaultNamespace(CoreModule.v1_0_0);
		writer.setSchemaLocations(CityGMLVersion.v1_0_0);
		writer.setIndentString("  ");

		writer.write(cityModel);

		writer.close();
	}

}
