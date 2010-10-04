package org.citygml4j.impl.citygml.core;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.core.ExternalObject;
import org.citygml4j.model.citygml.core.ExternalReference;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.module.citygml.CoreModule;

public class ExternalReferenceImpl implements ExternalReference {
	private String informationSystem;
	private ExternalObject externalObject;
	private CoreModule module;
	private ModelObject parent;

	public ExternalReferenceImpl() {
		
	}
	
	public ExternalReferenceImpl(CoreModule module) {
		this.module = module;
	}
	
	public ExternalObject getExternalObject() {
		return externalObject;
	}

	public String getInformationSystem() {
		return informationSystem;
	}

	public boolean isSetExternalObject() {
		return externalObject != null;
	}

	public boolean isSetInformationSystem() {
		return informationSystem != null;
	}

	public void setExternalObject(ExternalObject externalObject) {
		if (externalObject != null)
			externalObject.setParent(this);
		
		this.externalObject = externalObject;
	}

	public void setInformationSystem(String informationSystem) {
		this.informationSystem = informationSystem;
	}

	public void unsetExternalObject() {
		if (isSetExternalObject())
			externalObject.unsetParent();
		
		externalObject = null;
	}

	public void unsetInformationSystem() {
		informationSystem = null;
	}

	public ModelType getModelType() {
		return ModelType.CITYGML;
	}
	
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.EXTERNAL_REFERENCE;
	}

	public final CoreModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}
	
	public ModelObject getParent() {
		return parent;
	}

	public void setParent(ModelObject parent) {
		this.parent = parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void unsetParent() {
		parent = null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new ExternalReferenceImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		ExternalReference copy = (target == null) ? new ExternalReferenceImpl() : (ExternalReference)target;
		
		if (isSetInformationSystem())
			copy.setInformationSystem(copyBuilder.copy(informationSystem));
		
		if (isSetExternalObject()) {
			copy.setExternalObject((ExternalObject)copyBuilder.copy(externalObject));
			if (copy.getExternalObject() == externalObject)
				externalObject.setParent(this);
		}
		
		copy.unsetParent();

		return copy;
	}

}
