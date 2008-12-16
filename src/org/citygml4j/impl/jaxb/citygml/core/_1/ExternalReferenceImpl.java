package org.citygml4j.impl.jaxb.citygml.core._1;

import org.citygml4j.jaxb.citygml.core._1.ExternalReferenceType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.core.CoreModule;
import org.citygml4j.model.citygml.core.ExternalObject;
import org.citygml4j.model.citygml.core.ExternalReference;

public class ExternalReferenceImpl extends CityGMLBaseImpl implements ExternalReference {
	private ExternalReferenceType externalReference;

	public ExternalReferenceImpl() {
		externalReference = new ExternalReferenceType();
	}

	public ExternalReferenceImpl(ExternalReferenceType externalReference) {
		this.externalReference = externalReference;
	}

	@Override
	public ExternalReferenceType getJAXBObject() {
		return externalReference;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.EXTERNALREFERENCE;
	}
	
	@Override
	public final CityGMLModule getCityGMLModule() {
		return CoreModule.v1_0_0;
	}

	@Override
	public String getInformationSystem() {
		return externalReference.getInformationSystem();
	}

	@Override
	public ExternalObjectImpl getExternalObject() {
		if (externalReference.isSetExternalObject())
			return new ExternalObjectImpl(externalReference.getExternalObject());

		return null;
	}

	@Override
	public void setExternalObject(ExternalObject externalObject) {
		externalReference.setExternalObject(((ExternalObjectImpl)externalObject).getJAXBObject());
	}

	@Override
	public void setInformationSystem(String informationSystem) {
		externalReference.setInformationSystem(informationSystem);
	}

	@Override
	public boolean isSetExternalObject() {
		return externalReference.isSetExternalObject();
	}

	@Override
	public boolean isSetInformationSystem() {
		return externalReference.isSetInformationSystem();
	}

	@Override
	public void unsetInformationSystem() {
		externalReference.setInformationSystem(null);
	}

	@Override
	public void unsetExternalObject() {
		externalReference.setExternalObject(null);
	}
}
