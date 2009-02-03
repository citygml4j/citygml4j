package org.citygml4j.model.citygml.ade;

import org.citygml4j.builder.convert.citygml.CityGMLConvertContext;

public interface ADEConvertBuilder {
	public ADEComponent convert(ADEComponent adeComponent, CityGMLConvertContext cityGMLConvertContext);
}
