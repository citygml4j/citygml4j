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
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.XMLGregorianCalendar;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.JAXBBuilder;
import org.citygml4j.builder.jaxb.JAXBContextPath;
import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
import org.citygml4j.jaxb.gml._3_1_1.MultiSurfacePropertyType;
import org.citygml4j.jaxb.gml._3_1_1.MultiSurfaceType;
import org.citygml4j.model.citygml.ade.ADEComponent;
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

import ade.sub.jaxb.AbstractBoundarySurfaceType;
import ade.sub.jaxb.BoundarySurfacePropertyType;
import ade.sub.jaxb.ClosureSurfaceType;
import ade.sub.jaxb.GroundSurfaceType;
import ade.sub.jaxb.ObjectFactory;
import ade.sub.jaxb.RelativeToTerrainType;
import ade.sub.jaxb.RoofSurfaceType;
import ade.sub.jaxb.TunnelType;
import ade.sub.jaxb.WallSurfaceType;


public class UsingJAXBUnmarshaller {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and JAXB builder");
		CityGMLContext ctx = new CityGMLContext();
		JAXBBuilder builder = ctx.createJAXBBuilder();

		System.out.println(df.format(new Date()) + "reading ADE-enriched CityGML file LOD2_SubsurfaceStructureADE_v100.xml");
		System.out.println(df.format(new Date()) + "ADE schema file is read from xsi:schemaLocation attribute on root XML element");
		CityGMLInputFactory in = builder.createCityGMLInputFactory();

		CityGMLReader reader = in.createCityGMLReader(new File("../../datasets/LOD2_SubsurfaceStructureADE_v100.xml"));
		CityModel cityModel = (CityModel)reader.nextFeature();
		reader.close();
		
		ADEComponent ade = cityModel.getCityObjectMember().get(3).getGenericADEComponent();

		JAXBUnmarshaller unmarshaller = builder.createJAXBUnmarshaller();
		unmarshaller.setReleaseJAXBElementsFromMemory(false);
		
		JAXBMarshaller marshaller = builder.createJAXBMarshaller();
		
		System.out.println(df.format(new Date()) + "creating JAXBContext from ADE JAXB classes");
		ObjectFactory jaxbFactory = new ObjectFactory();
		String contextPath = JAXBContextPath.getContextPath(CityGMLVersion.v1_0_0, "ade.sub.jaxb");
		JAXBContext jaxbCtx = JAXBContext.newInstance(contextPath);
		Unmarshaller jaxbUmarshaller = jaxbCtx.createUnmarshaller();
		
		System.out.println(df.format(new Date()) + "unmarshalling ADE content using JAXB Unmarshaller");
		JAXBElement<?> element = (JAXBElement<?>)jaxbUmarshaller.unmarshal(ade.getContent());
		System.out.println("Unmarshalled JAXBElement: " + element.getName());
	
		System.out.println(df.format(new Date()) + "processing ADE feature sub:Tunnel by using JAXBUnmarshaller and JAXBMarshaller to modify ADE content");
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
			ADEComponent newADE = new ADEComponent(tunnelElement);
			cityModel.getCityObjectMember().get(3).setGenericADEComponent(newADE);
		}
		
		System.out.println(df.format(new Date()) + "writing processed citygml4j object tree");
		CityGMLOutputFactory out = builder.createCityGMLOutputFactory(CityGMLVersion.v1_0_0);
		
		CityModelWriter writer = out.createCityModelWriter(new File("LOD2_SubsurfaceStructureADE_JAXBUnmarshaller_v100.xml"));
		writer.setPrefixes(CityGMLVersion.v1_0_0);
		writer.setPrefix("sub", "http://www.citygml.org/ade/sub/0.9.0");
		writer.setDefaultNamespace(CoreModule.v1_0_0);
		writer.setSchemaLocation("http://citygml.org/ade/sub/0.9.0", "../../datasets/schemas/CityGML-SubsurfaceADE-0_9_0.xsd");
		writer.setIndentString("  ");

		writer.writeStartDocument();
		
		for (CityObjectMember member : cityModel.getCityObjectMember())
			if (member.isSetGenericADEComponent())
				writer.writeFeatureMember(member.getGenericADEComponent());
		
		writer.writeEndDocument();		
		writer.close();
		
		System.out.println(df.format(new Date()) + "ADE-enriched CityGML file LOD2_SubsurfaceStructureADE_JAXBUnmarshaller_v100.xml written");
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}

