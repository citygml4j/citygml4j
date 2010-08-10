package org.citygml4j.builder.jaxb.xml.io.writer;

import java.util.HashSet;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.citygml4j.builder.jaxb.marshal.JAXBNamespacePrefixMapper;
import org.citygml4j.impl.citygml.appearance.AppearanceMemberImpl;
import org.citygml4j.impl.citygml.core.CityModelImpl;
import org.citygml4j.impl.citygml.core.CityObjectMemberImpl;
import org.citygml4j.impl.gml.feature.FeatureMemberImpl;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.appearance.Appearance;
import org.citygml4j.model.citygml.appearance.AppearanceMember;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.citygml.core.CityObjectMember;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.feature.FeatureMember;
import org.citygml4j.model.module.ModuleContext;
import org.citygml4j.model.module.gml.GMLCoreModule;
import org.citygml4j.xml.io.writer.CityGMLWriteException;
import org.citygml4j.xml.io.writer.CityGMLWriter;
import org.citygml4j.xml.io.writer.CityModelInfo;
import org.citygml4j.xml.io.writer.FeatureWriteMode;
import org.xml.sax.SAXException;

public class JAXBSimpleWriter extends AbstractJAXBWriter implements CityGMLWriter {

	public JAXBSimpleWriter(SAXWriter writer, JAXBOutputFactory factory, ModuleContext moduleContext) throws CityGMLWriteException {
		super(writer, factory, moduleContext);
	}

	public void write(AbstractFeature abstractFeature) throws CityGMLWriteException {
		if (featureWriteMode == FeatureWriteMode.SPLIT_PER_COLLECTION_MEMBER && featureSplitter != null)
			abstractFeature = split(abstractFeature);

		try {
			JAXBElement<?> jaxbElement = jaxbMarshaller.marshalJAXBElement(abstractFeature);
			if (jaxbElement != null) {
				Marshaller marshaller = jaxbContext.createMarshaller();
				
				// validate output
				if (useValidation) {
					marshaller.setSchema(validationSchemaHandler.getSchema());
					marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new JAXBNamespacePrefixMapper());
					if (validationEventHandler != null)
						marshaller.setEventHandler(validationEventHandler);
				}
				
				// marshal output
				marshaller.marshal(jaxbElement, writer);
				writer.flush();
			}
		} catch (JAXBException e) {
			throw new CityGMLWriteException("Caused by: ", e);
		} catch (SAXException e) {
			throw new CityGMLWriteException("Caused by: ", e);
		}
	}

	private AbstractFeature split(AbstractFeature input) {
		List<CityGML> results = featureSplitter.split(input);
		
		CityModel cityModel = null;
		CityModel origModel = null;
		HashSet<String> gmlIds = null;

		if (input instanceof CityModel) {
			cityModel = new CityModelInfo((CityModel)input).toCityModel();
			origModel = (CityModel)results.get(results.size() - 1);
			gmlIds = new HashSet<String>();
		} else
			cityModel = new CityModelImpl();
		
		for (CityGML result : results) {
			if (result instanceof AbstractFeature) {
				if (result == origModel)
					continue;
				
				AbstractFeature feature = (AbstractFeature)result;
				if (gmlIds != null && feature.isSetId())
					gmlIds.add('#' + feature.getId());

				if (feature instanceof AbstractCityObject) {
					CityObjectMember member = new CityObjectMemberImpl();
					member.setCityObject((AbstractCityObject)feature);
					cityModel.addCityObjectMember(member);
				} 

				else if (feature instanceof Appearance) {
					AppearanceMember member = new AppearanceMemberImpl();
					member.setAppearance((Appearance)feature);
					cityModel.addAppearanceMember(member);
				} 

				else {
					FeatureMember member = new FeatureMemberImpl();
					member.setFeature(feature);
					cityModel.addFeatureMember(member);
				}

			}

			// handle ADE feature
			else if (result instanceof ADEComponent){
				ADEComponent ade = (ADEComponent)result;

				if (gmlIds != null) {
					String gmlId = ade.getContent().getAttribute("id");
					if (gmlId.length() == 0)
						gmlId = ade.getContent().getAttributeNS(GMLCoreModule.v3_1_1.getNamespaceURI(), "id");
					
					gmlIds.add('#' + gmlId);
				}

				// add ADE feature to new CityModel
				if (isCityObject(ade)) {
					CityObjectMember member = new CityObjectMemberImpl();
					member.setGenericADEComponent(ade);
					cityModel.addCityObjectMember(member);
				} 

				else {
					FeatureMember member = new FeatureMemberImpl();
					member.setGenericADEComponent(ade);
					cityModel.addFeatureMember(member);
				}
			}
		}	

		if (origModel != null) {
			if (origModel.isSetCityObjectMember())
				for (CityObjectMember member : origModel.getCityObjectMember())
					if (!(member.isSetHref() && gmlIds.contains(member.getHref())))
						cityModel.addCityObjectMember(member);
					else
						gmlIds.remove(member.getHref());

			if (origModel.isSetAppearanceMember())
				for (AppearanceMember member : origModel.getAppearanceMember())
					if (!(member.isSetHref() && gmlIds.contains(member.getHref())))
						cityModel.addAppearanceMember(member);
					else
						gmlIds.remove(member.getHref());
			
			if (origModel.isSetFeatureMember())
				for (FeatureMember member : origModel.getFeatureMember())
					if (!(member.isSetHref() && gmlIds.contains(member.getHref())))
						cityModel.addFeatureMember(member);	
					else
						gmlIds.remove(member.getHref());
		}

		return cityModel;
	}

}
