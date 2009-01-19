package org.citygml4j;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.citygml4j.builder.convert.citygml.CityGMLConvertBuilder;
import org.citygml4j.builder.convert.citygml.CityGMLConvertContext;
import org.citygml4j.factory.CityGMLFactory;
import org.citygml4j.factory.GMLFactory;
import org.citygml4j.factory.XALFactory;
import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.model.citygml.CityGMLModuleVersion;
import org.citygml4j.model.citygml.ade.ADE;
import org.citygml4j.model.citygml.ade.ADEModelMapper;
import org.citygml4j.util.JAXBNamespacePrefixMapper;

public class CityGMLContext {
	private HashSet<String> contextSet;
	private HashMap<String, ADE> adeMap;
	
	public CityGMLContext() {
		contextSet = new HashSet<String>();
		adeMap = new HashMap<String, ADE>();
		
		contextSet.add("org.citygml4j.jaxb.citygml.app._1");
		contextSet.add("org.citygml4j.jaxb.citygml.bldg._1");
		contextSet.add("org.citygml4j.jaxb.citygml.frn._1");
		contextSet.add("org.citygml4j.jaxb.citygml.grp._1");
		contextSet.add("org.citygml4j.jaxb.citygml.core._1");
		contextSet.add("org.citygml4j.jaxb.citygml.gen._1");
		contextSet.add("org.citygml4j.jaxb.citygml.luse._1");
		contextSet.add("org.citygml4j.jaxb.citygml.dem._1");
		contextSet.add("org.citygml4j.jaxb.citygml.tex._1");
		contextSet.add("org.citygml4j.jaxb.citygml.tran._1");
		contextSet.add("org.citygml4j.jaxb.citygml.veg._1");
		contextSet.add("org.citygml4j.jaxb.citygml.wtr._1");
		contextSet.add("org.citygml4j.jaxb.citygml._0_4");
		contextSet.add("org.citygml4j.jaxb.gml._3_1_1");
		contextSet.add("org.citygml4j.jaxb.xal");
	}

	public void registerADE(ADE ade) {
		// check preconditions
		if (ade == null)
			throw new IllegalArgumentException("ADE instance may not be null");
		
		if (ade.getNamespaceURI() == null || ade.getNamespaceURI().length() == 0)
			throw new IllegalArgumentException("Invalid ADE namespace");

		if (ade.getJAXBPackages() == null)
			throw new IllegalArgumentException("No JAXB packages provided");
		
		List<ADEModelMapper> mapperList = ade.getADEModelMapper();
		if (mapperList == null || mapperList.isEmpty())
			throw new IllegalArgumentException("No ADEModelMapper provided");

		// register ADE
		adeMap.put(ade.getNamespaceURI(), ade);
		
		for (Package packageName : ade.getJAXBPackages())
			contextSet.add(packageName.getName());
		
		for (ADEModelMapper mapper : mapperList)
			ModelMapper.ADE.registerADEModelMapper(ade.getNamespaceURI(), mapper);
	}
		
	public void registerPackageName(String packageName) {
		contextSet.add(packageName);
	}
	
	public void unregisterADE(String namespaceURI) {
		ADE ade = adeMap.get(namespaceURI);
		if (ade != null) {
			contextSet.remove(namespaceURI);
			ModelMapper.ADE.unregisterADE(namespaceURI);
			adeMap.remove(namespaceURI);
		}
	}
	
	public void unregisterPackageName(String packageName) {
		contextSet.remove(packageName);
	}
	
	public ADE getADE(String namespaceURI) {
		return adeMap.get(namespaceURI);
	}
	
	public Collection<ADE> getADEs() {
		return adeMap.values();
	}
	
	public CityGMLFactory createCityGMLFactory() {
		return new CityGMLFactory();
	}
	
	public CityGMLFactory createCityGMLFactory(CityGMLModuleVersion version) {
		return new CityGMLFactory(version);
	}
	
	public GMLFactory createGMLFactory() {
		return new GMLFactory();
	}
	
	public XALFactory createXALFactory() {
		return new XALFactory();
	}
	
	public CityGMLConvertBuilder createCityGMLConvertBuilder() {
		return new CityGMLConvertBuilder(this);
	}
	
	public CityGMLConvertBuilder createCityGMLConvertBuilder(CityGMLConvertContext convertContext) {
		return new CityGMLConvertBuilder(this, convertContext);
	}
	
	public CityGMLConvertBuilder createCityGMLConvertBuilder(CityGMLModuleVersion version) {
		return new CityGMLConvertBuilder(this, version);
	}
	
	public JAXBNamespacePrefixMapper createNamespacePrefixMapper() {
		return new JAXBNamespacePrefixMapper();
	}
	
	public JAXBContext createJAXBContext() throws JAXBException {
		StringBuilder context = new StringBuilder();
		
		int i = 0;
		for (String packageName : contextSet) {
			context.append(packageName);			
			if (++i != contextSet.size())
				context.append(":");
		}
				
		return JAXBContext.newInstance(context.toString(), Thread.currentThread().getContextClassLoader());
	}
}
