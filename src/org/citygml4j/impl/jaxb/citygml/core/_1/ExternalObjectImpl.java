package org.citygml4j.impl.jaxb.citygml.core._1;

import org.citygml4j.jaxb.citygml.core._1.ExternalObjectReferenceType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.core.CoreModule;
import org.citygml4j.model.citygml.core.ExternalObject;

public class ExternalObjectImpl extends CityGMLBaseImpl implements ExternalObject {
	protected ExternalObjectReferenceType externalObject;

	public ExternalObjectImpl() {
		externalObject = new ExternalObjectReferenceType();
	}

	public ExternalObjectImpl(ExternalObjectReferenceType externalObject) {
		this.externalObject = externalObject;
	}

	@Override
	public ExternalObjectReferenceType getJAXBObject() {
		return externalObject;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.EXTERNALOBJECT;
	}

	@Override
	public final CityGMLModule getCityGMLModule() {
		return CoreModule.v1_0_0;
	}
	
	@Override
	public String getName() {
		return externalObject.getName();
	}

	@Override
	public String getUri() {
		return externalObject.getUri();
	}

	@Override
	public void setName(String name) {
		externalObject.setName(name);
	}

	@Override
	public void setUri(String uri) {
		externalObject.setUri(uri);
	}
	
	@Override
	public boolean isSetName() {
		return externalObject.isSetName();
	}

	@Override
	public boolean isSetUri() {
		return externalObject.isSetUri();
	}

	@Override
	public void unsetName() {
		externalObject.setName(null);
	}

	@Override
	public void unsetUri() {
		externalObject.setUri(null);
	}
}
