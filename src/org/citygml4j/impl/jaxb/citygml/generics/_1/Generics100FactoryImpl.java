package org.citygml4j.impl.jaxb.citygml.generics._1;

import org.citygml4j.impl.jaxb.citygml.AbstractGenericsFactoryImpl;
import org.citygml4j.model.citygml.generics.GenericCityObject;
import org.citygml4j.model.citygml.generics.GenericDateAttribute;
import org.citygml4j.model.citygml.generics.GenericDoubleAttribute;
import org.citygml4j.model.citygml.generics.GenericIntAttribute;
import org.citygml4j.model.citygml.generics.GenericStringAttribute;
import org.citygml4j.model.citygml.generics.GenericUriAttribute;

public class Generics100FactoryImpl extends AbstractGenericsFactoryImpl {

	@Override
	public GenericCityObject createGenericCityObject() {
		return new GenericCityObjectImpl();
	}

	@Override
	public GenericDateAttribute createGenericDateAttribute() {
		return new GenericDateAttributeImpl();
	}

	@Override
	public GenericDoubleAttribute createGenericDoubleAttribute() {
		return new GenericDoubleAttributeImpl();
	}

	@Override
	public GenericIntAttribute createGenericIntAttribute() {
		return new GenericIntAttributeImpl();
	}

	@Override
	public GenericStringAttribute createGenericStringAttribute() {
		return new GenericStringAttributeImpl();
	}

	@Override
	public GenericUriAttribute createGenericUriAttribute() {
		return new GenericUriAttributeImpl();
	}

}
