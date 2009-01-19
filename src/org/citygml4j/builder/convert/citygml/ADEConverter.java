package org.citygml4j.builder.convert.citygml;

import java.util.HashMap;
import java.util.LinkedList;

import org.citygml4j.model.citygml.ade.ADE;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.ade.ADEConvertBuilder;

public class ADEConverter {
	private HashMap<String, LinkedList<ADEConvertBuilder>> adeConvertBuilderMap;

	protected ADEConverter(CityGMLConvertBuilder builder) {		
		adeConvertBuilderMap = new HashMap<String, LinkedList<ADEConvertBuilder>>();

		for (ADE ade : builder.cityGMLcontext.getADEs()) {
			if (ade.getADEConvertBuilder() != null) {
				String namespaceURI = ade.getNamespaceUri();
				LinkedList<ADEConvertBuilder> adeBuilderList = adeConvertBuilderMap.get(namespaceURI);
				if (adeBuilderList == null) {
					adeBuilderList = new LinkedList<ADEConvertBuilder>();
					adeConvertBuilderMap.put(namespaceURI, adeBuilderList);
				}

				for (ADEConvertBuilder adeBuilder : ade.getADEConvertBuilder())
					adeBuilderList.add(adeBuilder);
			}
		}
	}

	protected ADEComponent convertADEComponent(ADEComponent src) {
		ADEComponent tmp = null;		

		LinkedList<ADEConvertBuilder> builderList = adeConvertBuilderMap.get(src.getADENamespaceURI());
		if (builderList != null) {
			for (ADEConvertBuilder builder : builderList) {
				tmp = builder.convert(src);
				if (tmp != null)
					break;
			}
		}

		return tmp;
	}
}
