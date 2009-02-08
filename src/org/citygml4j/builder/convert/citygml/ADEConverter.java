package org.citygml4j.builder.convert.citygml;

import java.util.HashMap;
import java.util.LinkedList;

import org.citygml4j.model.citygml.ade.ADEContext;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.ade.ADEConvertBuilder;

public class ADEConverter {
	private CityGMLConvertBuilder builder;
	private HashMap<String, LinkedList<ADEConvertBuilder>> adeConvertBuilderMap;

	protected ADEConverter(CityGMLConvertBuilder builder) {	
		this.builder = builder;
		adeConvertBuilderMap = new HashMap<String, LinkedList<ADEConvertBuilder>>();

		for (ADEContext ade : builder.cityGMLContext.getADEContexts()) {
			if (ade.getADEConvertBuilder() != null)
				for (ADEConvertBuilder adeConvertBuilder : ade.getADEConvertBuilder())
					registerADEConvertBuilder(ade.getNamespaceURI(), adeConvertBuilder);
		}
	}

	protected void registerADEConvertBuilder(String namespaceURI, ADEConvertBuilder adeConvertBuilder) {
		LinkedList<ADEConvertBuilder> adeBuilderList = adeConvertBuilderMap.get(namespaceURI);
		if (adeBuilderList == null) {
			adeBuilderList = new LinkedList<ADEConvertBuilder>();
			adeConvertBuilderMap.put(namespaceURI, adeBuilderList);
		}

		if (!adeBuilderList.contains(adeConvertBuilder))
			adeBuilderList.addLast(adeConvertBuilder);
	}

	protected void unregisterADEConvertBuilder(String namespaceURI) {
		adeConvertBuilderMap.remove(namespaceURI);
	}
	
	protected ADEComponent convertADEComponent(ADEComponent src) {
		ADEComponent tmp = null;
		
		LinkedList<ADEConvertBuilder> adeBuilderList = adeConvertBuilderMap.get(src.getADENamespaceURI());
		if (adeBuilderList != null) {
			CityGMLConvertContext convertCtx = new CityGMLConvertContext(builder.convertContext);
			for (ADEConvertBuilder adeBuilder : adeBuilderList) {
				tmp = adeBuilder.convert(src, convertCtx);
				if (tmp != null)
					break;
			}
		}

		return tmp;
	}
}
