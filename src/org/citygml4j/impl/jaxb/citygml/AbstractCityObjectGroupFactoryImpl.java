package org.citygml4j.impl.jaxb.citygml;

import org.citygml4j.impl.jaxb.citygml.cityobjectgroup._0_4.CityObjectGroup040FactoryImpl;
import org.citygml4j.impl.jaxb.citygml.cityobjectgroup._1.CityObjectGroup100FactoryImpl;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroup;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupFactory;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupMember;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupModule;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupParent;

public abstract class AbstractCityObjectGroupFactoryImpl implements CityObjectGroupFactory {
	private static CityObjectGroup040FactoryImpl factory040 = new CityObjectGroup040FactoryImpl();
	private static CityObjectGroup100FactoryImpl factory100 = new CityObjectGroup100FactoryImpl();
	
	public static CityObjectGroupFactory getInstance(CityObjectGroupModule module) {
		switch (module) {
		case v0_4_0:
			return factory040;
		default:
			return factory100;
		}
	}
	
	@Override
	public abstract CityObjectGroup createCityObjectGroup();

	@Override
	public abstract CityObjectGroupMember createCityObjectGroupMember();

	@Override
	public abstract CityObjectGroupParent createCityObjectGroupParent();

}
