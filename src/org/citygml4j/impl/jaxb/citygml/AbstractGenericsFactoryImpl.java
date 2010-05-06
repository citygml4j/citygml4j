package org.citygml4j.impl.jaxb.citygml;

import org.citygml4j.impl.jaxb.citygml.generics._0_4.Generics040FactoryImpl;
import org.citygml4j.impl.jaxb.citygml.generics._1.Generics100FactoryImpl;
import org.citygml4j.model.citygml.generics.GenericCityObject;
import org.citygml4j.model.citygml.generics.GenericDateAttribute;
import org.citygml4j.model.citygml.generics.GenericDoubleAttribute;
import org.citygml4j.model.citygml.generics.GenericIntAttribute;
import org.citygml4j.model.citygml.generics.GenericStringAttribute;
import org.citygml4j.model.citygml.generics.GenericUriAttribute;
import org.citygml4j.model.citygml.generics.GenericsFactory;
import org.citygml4j.model.citygml.generics.GenericsModule;

public abstract class AbstractGenericsFactoryImpl implements GenericsFactory {
	private static Generics040FactoryImpl factory040 = new Generics040FactoryImpl();
	private static Generics100FactoryImpl factory100 = new Generics100FactoryImpl();
	
	public static GenericsFactory getInstance(GenericsModule module) {
		switch (module) {
		case v0_4_0:
			return factory040;
		default:
			return factory100;
		}
	}
	
	public abstract GenericCityObject createGenericCityObject();

	public abstract GenericDateAttribute createGenericDateAttribute();

	public abstract GenericDoubleAttribute createGenericDoubleAttribute();

	public abstract GenericIntAttribute createGenericIntAttribute();

	public abstract GenericStringAttribute createGenericStringAttribute();

	public abstract GenericUriAttribute createGenericUriAttribute();

}
