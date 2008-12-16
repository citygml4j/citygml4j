package org.citygml4j.model.citygml.generics;

public interface GenericsFactory {
	public GenericCityObject createGenericCityObject();
	public GenericDateAttribute createGenericDateAttribute();
	public GenericDoubleAttribute createGenericDoubleAttribute();
	public GenericIntAttribute createGenericIntAttribute();
	public GenericStringAttribute createGenericStringAttribute();
	public GenericUriAttribute createGenericUriAttribute();
}
