package org.citygml4j.impl.jaxb.citygml.core._0_4;

import org.citygml4j.impl.jaxb.gml._3_1_1.GMLBaseImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.core.CityGMLBase;
import org.citygml4j.model.gml.GMLClass;

public abstract class CityGMLBaseImpl extends GMLBaseImpl implements CityGMLBase {

	@Override
	public abstract CityGMLClass getCityGMLClass();

	@Override
	public abstract CityGMLModule getCityGMLModule();

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.CITYGMLCLASS;
	}
}
