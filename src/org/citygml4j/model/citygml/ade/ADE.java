package org.citygml4j.model.citygml.ade;

import java.util.List;

import org.citygml4j.impl.jaxb.ModelMapper;

public class ADE {
	private ADEContext adeContext;
	private Class<?> jaxbObjectFactory;
	private List<ADEModelMapper> adeModelMapperList;
		
	public ADE(ADEContext adeContext, Class<?> jaxbObjectFactory, List<ADEModelMapper> adeModelMapper) {
		this.adeContext = adeContext;
		this.jaxbObjectFactory = jaxbObjectFactory;
		this.adeModelMapperList = adeModelMapper;
	}
	
	public ADEContext getADEContext() {
		return adeContext;
	}
	
	public Class<?> getJAXBObjectFactory() {
		return jaxbObjectFactory;
	}
	
	public List<ADEModelMapper> getADEModelMapper() {
		return adeModelMapperList;
	}
		
	public void enableADEModelMapper(ADEModelMapper adeModelMapper) {
		if (!ModelMapper.ADE.containsADEModelMapper(adeContext.getNamespaceURI(), adeModelMapper))
			ModelMapper.ADE.registerADEModelMapper(adeContext.getNamespaceURI(), adeModelMapper);
	}
	
	public void disableADEModelMapper(ADEModelMapper adeModelMapper) {
		ModelMapper.ADE.unregisterADEModelMapper(adeContext.getNamespaceURI(), adeModelMapper);
	}
}
