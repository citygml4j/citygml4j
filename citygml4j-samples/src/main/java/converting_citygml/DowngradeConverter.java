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
package converting_citygml;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.CityGMLBuilder;
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

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DowngradeConverter {

	public static void main(String[] args) throws Exception {
		final SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and CityGML builder");
		CityGMLContext ctx = CityGMLContext.getInstance();
		CityGMLBuilder builder = ctx.createCityGMLBuilder();

		System.out.println(df.format(new Date()) + "reading CityGML 2.0.0 file LOD3_Railway_v200.gml chunk-wise");
		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		in.setProperty(CityGMLInputFactory.FEATURE_READ_MODE, FeatureReadMode.SPLIT_PER_COLLECTION_MEMBER);
		CityGMLReader reader = in.createCityGMLReader(new File("datasets/LOD3_Railway_v200.gml"));

		CityGMLVersion version = CityGMLVersion.v1_0_0;
		System.out.println(df.format(new Date()) + "writing citygml4j object tree as CityGML " + version + " document");
		CityGMLOutputFactory out = builder.createCityGMLOutputFactory();
		out.setCityGMLVersion(version);

		CityModelWriter writer = out.createCityModelWriter(new File("output/LOD3_Railway_v100.gml"));
		writer.setPrefixes(version);
		writer.setDefaultNamespace(CoreModule.v1_0_0);
		writer.setSchemaLocations(version);
		writer.setIndentString("  ");

		// we iterate through all <cityObjectMember>s of the <CityModel>
		while (reader.hasNext()) {
			AbstractFeature feature = (AbstractFeature)reader.nextFeature();

			// if we find a tunnel or a bridge we convert it to a generic city object as proxy
			if (feature instanceof AbstractTunnel || feature instanceof AbstractBridge) {
				final GenericCityObject proxy = new GenericCityObject();
				proxy.setLod3Geometry(new GeometryProperty<>(new MultiGeometry()));

				System.out.println(df.format(new Date()) + "converting " + ((AbstractCityObject)feature).getCityGMLClass() + " and nested features to " + proxy.getCityGMLClass());				

				// we use a feature walker to visit the tunnel/bridge and all its nested city objects
				FeatureWalker walker = new FeatureWalker() {
					public void visit(AbstractCityObject abstractCityObject) {
						// simply collect all LOD3 geometries and add them to the gml:MultiGeometry of the proxy
						System.out.println(df.format(new Date()) + "adding geometry of " + abstractCityObject.getCityGMLClass());				

						LodRepresentation lods = abstractCityObject.getLodRepresentation();
						if (lods.isSetGeometry(3)) {
							MultiGeometry multiGeometry = (MultiGeometry)proxy.getLod3Geometry().getGeometry();
							multiGeometry.getGeometryMember().addAll(lods.getGeometry(3));
						}
					}

					public void visit(AbstractBridge abstractBridge) {
						// copy attributes of the brigde
						proxy.setClazz(abstractBridge.getClazz());
						proxy.setFunction(abstractBridge.getFunction());
						proxy.setUsage(abstractBridge.getUsage());
						super.visit(abstractBridge);
					}

					public void visit(AbstractTunnel abstractTunnel) {
						// copy attributes of the tunnel
						proxy.setClazz(abstractTunnel.getClazz());
						proxy.setFunction(abstractTunnel.getFunction());
						proxy.setUsage(abstractTunnel.getUsage());
						super.visit(abstractTunnel);
					}

				};

				feature.accept(walker);
				
				// copy common attributes
				proxy.setId(feature.getId());
				proxy.setName(feature.getName());
				proxy.setRelativeToTerrain(((AbstractCityObject)feature).getRelativeToTerrain());
				proxy.setRelativeToWater(((AbstractCityObject)feature).getRelativeToWater());

				// let's swap the bridge/tunnel with the proxy object
				feature = proxy;
			}

			if (!(feature instanceof CityModel))
				writer.writeFeatureMember(feature);
		}

		reader.close();
		writer.close();

		System.out.println(df.format(new Date()) + "CityGML file LOD3_Railway_v100.gml written");
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}
}
