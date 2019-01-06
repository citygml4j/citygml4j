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
package handling_ade.generic.unmarshalling_ade_using_jaxb;

import handling_ade.generic.unmarshalling_ade_using_jaxb.ade.sub.jaxb.AbstractBoundarySurfaceType;
import handling_ade.generic.unmarshalling_ade_using_jaxb.ade.sub.jaxb.BoundarySurfacePropertyType;
import handling_ade.generic.unmarshalling_ade_using_jaxb.ade.sub.jaxb.ClosureSurfaceType;
import handling_ade.generic.unmarshalling_ade_using_jaxb.ade.sub.jaxb.GroundSurfaceType;
import handling_ade.generic.unmarshalling_ade_using_jaxb.ade.sub.jaxb.ObjectFactory;
import handling_ade.generic.unmarshalling_ade_using_jaxb.ade.sub.jaxb.RelativeToTerrainType;
import handling_ade.generic.unmarshalling_ade_using_jaxb.ade.sub.jaxb.RoofSurfaceType;
import handling_ade.generic.unmarshalling_ade_using_jaxb.ade.sub.jaxb.TunnelType;
import handling_ade.generic.unmarshalling_ade_using_jaxb.ade.sub.jaxb.WallSurfaceType;
import net.opengis.gml.MultiSurfacePropertyType;
import net.opengis.gml.MultiSurfaceType;
import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.CityGMLBuilder;
import org.citygml4j.builder.jaxb.JAXBContextPath;
import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.ade.generic.ADEGenericElement;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.citygml.core.CityObjectMember;
import org.citygml4j.model.gml.base.StringOrRef;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurface;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.writer.CityModelWriter;
import org.w3c.dom.Element;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UsingJAXBUnmarshaller {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and JAXB builder");
		CityGMLContext ctx = CityGMLContext.getInstance();
		CityGMLBuilder builder = ctx.createCityGMLBuilder();

		System.out.println(df.format(new Date()) + "reading ADE-enriched CityGML file LOD2_SubsurfaceStructureADE_v100.gml");
		System.out.println(df.format(new Date()) + "ADE schema file is read from xsi:schemaLocation attribute on root XML element");
		CityGMLInputFactory in = builder.createCityGMLInputFactory();

		CityGMLReader reader = in.createCityGMLReader(new File("datasets/LOD2_SubsurfaceStructureADE_v100.gml"));
		CityModel cityModel = (CityModel)reader.nextFeature();
		reader.close();
		
		ADEComponent ade = cityModel.getCityObjectMember().get(3).getGenericADEElement();

		JAXBUnmarshaller unmarshaller = builder.createJAXBUnmarshaller();
		unmarshaller.setReleaseJAXBElementsFromMemory(false);
		
		JAXBMarshaller marshaller = builder.createJAXBMarshaller();
		
		System.out.println(df.format(new Date()) + "creating JAXBContext from ADE JAXB classes");
		ObjectFactory jaxbFactory = new ObjectFactory();
		String contextPath = JAXBContextPath.getContextPath("handling_ade.generic.unmarshalling_ade_using_jaxb.ade.sub.jaxb");
		JAXBContext jaxbCtx = JAXBContext.newInstance(contextPath);
		Unmarshaller jaxbUmarshaller = jaxbCtx.createUnmarshaller();
		
		System.out.println(df.format(new Date()) + "unmarshalling ADE content using JAXB Unmarshaller");
		JAXBElement<?> element = (JAXBElement<?>)jaxbUmarshaller.unmarshal(((ADEGenericElement)ade).getContent());
		System.out.println("Unmarshalled JAXBElement: " + element.getName());
	
		System.out.println(df.format(new Date()) + "processing ADE feature sub:Tunnel using JAXBUnmarshaller and JAXBMarshaller to modify ADE content");
		if (element.getValue() instanceof TunnelType) {
			TunnelType tunnel = (TunnelType)element.getValue();
			System.out.println("ADE feature: Tunnel, gml:id='" + tunnel.getId() + "'");
			
			XMLGregorianCalendar creationDate = tunnel.getCreationDate();
			System.out.print("creation date (from CityObject): ");
			System.out.println(creationDate.getYear() + "-" + creationDate.getMonth() + "-" + creationDate.getDay());
			
			for (JAXBElement<Object> genericProperty : tunnel.get_GenericApplicationPropertyOfCityObject()) {
				if (genericProperty.getValue() instanceof RelativeToTerrainType) {
					RelativeToTerrainType type = (RelativeToTerrainType)genericProperty.getValue();
					System.out.println("relativeToTerrain: " + type.value());
				}					
			}
			
			for (BoundarySurfacePropertyType boundedBy : tunnel.getBoundedBySurface()) {
				AbstractBoundarySurfaceType boundarySurface = (AbstractBoundarySurfaceType)boundedBy.get_Object().getValue();
				
				if (boundarySurface instanceof RoofSurfaceType) 
					System.out.println("ADE feature: RoofSurface");
				else if (boundarySurface instanceof ClosureSurfaceType) 
					System.out.println("ADE feature: ClosureSurface");
				else if (boundarySurface instanceof WallSurfaceType) 
					System.out.println("ADE feature: WallSurface");
				else if (boundarySurface instanceof GroundSurfaceType) 
					System.out.println("ADE feature: GroundSurface");
							
				MultiSurfacePropertyType multiSurfacePropertyType = boundarySurface.getLod2MultiSurface();
				System.out.println("  Processing geometry: " + multiSurfacePropertyType.getMultiSurface());

				MultiSurface multiSurface = (MultiSurface)unmarshaller.unmarshal(multiSurfacePropertyType.getMultiSurface());
				StringOrRef description = new StringOrRef();
				description.setValue("processed by citygml4j");
				multiSurface.setDescription(description);
				
				MultiSurfaceType multiSurfaceType = (MultiSurfaceType)marshaller.marshal(multiSurface);
				multiSurfacePropertyType.setMultiSurface(multiSurfaceType);
			}
					
			Element tunnelElement = marshaller.marshalDOMElement(jaxbFactory.createTunnel(tunnel), jaxbCtx);
			ADEGenericElement newADE = new ADEGenericElement(tunnelElement);
			cityModel.getCityObjectMember().get(3).setGenericADEElement(newADE);
		}
		
		System.out.println(df.format(new Date()) + "writing processed citygml4j object tree");
		CityGMLOutputFactory out = builder.createCityGMLOutputFactory(CityGMLVersion.v1_0_0);
		out.setSchemaHandler(in.getSchemaHandler());
		
		CityModelWriter writer = out.createCityModelWriter(new File("output/LOD2_SubsurfaceStructureADE_JAXBUnmarshaller_v100.gml"));
		
		writer.setPrefixes(CityGMLVersion.v1_0_0);
		writer.setPrefix("sub", "http://www.citygml.org/ade/sub/0.9.0");
		writer.setDefaultNamespace(CoreModule.v1_0_0);
		writer.setSchemaLocation("http://citygml.org/ade/sub/0.9.0", "../datasets/schemas/CityGML-SubsurfaceADE-0_9_0.xsd");
		writer.setIndentString("  ");
		
		writer.writeStartDocument();
		
		for (CityObjectMember member : cityModel.getCityObjectMember())
			if (member.isSetGenericADEElement())
				writer.writeFeatureMember(member.getGenericADEElement());
		
		writer.writeEndDocument();		
		writer.close();
		
		System.out.println(df.format(new Date()) + "ADE-enriched CityGML file LOD2_SubsurfaceStructureADE_JAXBUnmarshaller_v100.gml written");
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}

