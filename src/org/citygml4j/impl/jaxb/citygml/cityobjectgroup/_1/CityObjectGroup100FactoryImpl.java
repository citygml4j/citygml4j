package org.citygml4j.impl.jaxb.citygml.cityobjectgroup._1;

import org.citygml4j.impl.jaxb.citygml.AbstractCityObjectGroupFactoryImpl;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroup;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupMember;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupParent;

public class CityObjectGroup100FactoryImpl extends AbstractCityObjectGroupFactoryImpl {

	@Override
	public CityObjectGroup createCityObjectGroup() {
		return new CityObjectGroupImpl();
	}

	@Override
	public CityObjectGroupMember createCityObjectGroupMember() {
		return new CityObjectGroupMemberImpl();
	}

	@Override
	public CityObjectGroupParent createCityObjectGroupParent() {
		return new CityObjectGroupParentImpl();
	}

}
