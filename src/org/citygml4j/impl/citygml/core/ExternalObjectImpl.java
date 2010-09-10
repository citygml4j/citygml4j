package org.citygml4j.impl.citygml.core;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.core.ExternalObject;
import org.citygml4j.model.module.citygml.CoreModule;

public class ExternalObjectImpl implements ExternalObject {
	private String name;
	private String uri;
	private CoreModule module;
	private Object parent;
	
	public ExternalObjectImpl() {
		
	}
	
	public ExternalObjectImpl(CoreModule module) {
		this.module = module;
	}
	
	public String getName() {
		return name;
	}

	public String getUri() {
		return uri;
	}

	public boolean isSetName() {
		return name != null;
	}

	public boolean isSetUri() {
		return uri != null;
	}

	public void setName(String name) {
		this.name = name;
		unsetUri();
	}

	public void setUri(String uri) {
		this.uri = uri;
		unsetName();
	}

	public void unsetName() {
		name = null;
	}

	public void unsetUri() {
		uri = null;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.EXTERNAL_OBJECT;
	}

	public final CoreModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}
	
	public Object getParent() {
		return parent;
	}

	public void setParent(Object parent) {
		this.parent = parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void unsetParent() {
		parent = null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new ExternalObjectImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		ExternalObject copy = (target == null) ? new ExternalObjectImpl() : (ExternalObject)target;
		
		if (isSetName())
			copy.setName(copyBuilder.copy(name));
		
		if (isSetUri())
			copy.setUri(copyBuilder.copy(uri));
		
		copy.unsetParent();

		return copy;
	}

}
