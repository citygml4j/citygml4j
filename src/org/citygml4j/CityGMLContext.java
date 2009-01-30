package org.citygml4j;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.citygml4j.builder.convert.citygml.CityGMLConvertBuilder;
import org.citygml4j.builder.convert.citygml.CityGMLConvertContext;
import org.citygml4j.factory.CityGMLFactory;
import org.citygml4j.factory.GMLFactory;
import org.citygml4j.factory.XALFactory;
import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.model.citygml.CityGMLModuleVersion;
import org.citygml4j.model.citygml.ade.ADEContext;
import org.citygml4j.model.citygml.ade.ADEModelMapper;
import org.citygml4j.util.JAXBNamespacePrefixMapper;

public class CityGMLContext {
	private HashSet<String> contextSet;
	private HashMap<String, ADEContext> adeContextMap;
	
	public CityGMLContext() {
		contextSet = new HashSet<String>();
		adeContextMap = new HashMap<String, ADEContext>();
		
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

	public void registerADEContext(ADEContext adeContext) {
		// check preconditions
		if (adeContext == null)
			throw new IllegalArgumentException("ADE instance may not be null");
		
		if (adeContext.getNamespaceURI() == null || adeContext.getNamespaceURI().length() == 0)
			throw new IllegalArgumentException("Invalid ADE namespace");

		if (adeContext.getJAXBPackages() == null || adeContext.getJAXBPackages().isEmpty())
			throw new IllegalArgumentException("No JAXB packages provided");
		
		if (adeContext.getADEModelMapper() == null || adeContext.getADEModelMapper().isEmpty())
			throw new IllegalArgumentException("No ADEModelMapper provided");

		// register ADE
		adeContextMap.put(adeContext.getNamespaceURI(), adeContext);
		
		for (Package packageName : adeContext.getJAXBPackages())
			contextSet.add(packageName.getName());
		
		for (ADEModelMapper mapper : adeContext.getADEModelMapper())
			ModelMapper.ADE.registerADEModelMapper(adeContext.getNamespaceURI(), mapper);
	}
		
	public void registerPackageName(String packageName) {
		contextSet.add(packageName);
	}
	
	public boolean unregisterADEContext(String namespaceURI) {
		ADEContext adeContext = adeContextMap.get(namespaceURI);
		if (adeContext != null) {
			contextSet.remove(namespaceURI);
			ModelMapper.ADE.unregisterADEModelMapper(namespaceURI);
			adeContextMap.remove(namespaceURI);
		}
		
		return adeContextMap.containsKey(namespaceURI);
	}
	
	public boolean unregisterADEContext(ADEContext adeContext) {
		return unregisterADEContext(adeContext.getNamespaceURI());
	}
	
	public boolean unregisterPackageName(String packageName) {
		return contextSet.remove(packageName);
	}
	
	public ADEContext getADEContext(String namespaceURI) {
		return adeContextMap.get(namespaceURI);
	}
	
	public Collection<ADEContext> getADEContexts() {
		return adeContextMap.values();
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
		
	public JAXBContext createJAXBContext(ClassLoader classLoader) throws JAXBException {
		StringBuilder context = new StringBuilder();
		
		int i = 0;
		for (String packageName : contextSet) {
			context.append(packageName);			
			if (++i != contextSet.size())
				context.append(":");
		}
				
		return JAXBContext.newInstance(context.toString(), classLoader);
	}
	
	public JAXBContext createJAXBContext() throws JAXBException {
		return createJAXBContext(Thread.currentThread().getContextClassLoader());
	}
}
