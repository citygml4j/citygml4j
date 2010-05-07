package org.citygml4j.impl.jaxb.gml._3_1_1;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ObjectFactory;
import org.citygml4j.jaxb.gml._3_1_1.AbstractSolidType;
import org.citygml4j.jaxb.gml._3_1_1.CompositeSolidType;
import org.citygml4j.jaxb.gml._3_1_1.SolidPropertyType;
import org.citygml4j.jaxb.gml._3_1_1.SolidType;
import org.citygml4j.model.gml.AbstractSolid;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.SolidProperty;

public class SolidPropertyImpl extends GMLBaseImpl implements SolidProperty {
	private SolidPropertyType solidPropertyType;

	public SolidPropertyImpl() {
		solidPropertyType = new SolidPropertyType();
	}

	public SolidPropertyImpl(SolidPropertyType solidPropertyType) {
		this.solidPropertyType = solidPropertyType;
	}

	@Override
	public SolidPropertyType getJAXBObject() {
		return solidPropertyType;
	}

	public AbstractSolid getSolid() {
		if (solidPropertyType.isSet_Solid()) {
			JAXBElement<? extends AbstractSolidType> abstractSolidTypeElem = solidPropertyType.get_Solid();
			if (abstractSolidTypeElem.getValue() != null) {
				if (abstractSolidTypeElem.getValue() instanceof SolidType)
					return new SolidImpl((SolidType)abstractSolidTypeElem.getValue());
				else if (abstractSolidTypeElem.getValue() instanceof CompositeSolidType)
					return new CompositeSolidImpl((CompositeSolidType)abstractSolidTypeElem.getValue());
			}
		}

		return null;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.SOLIDPROPERTY;
	}

	public String getActuate() {
		return solidPropertyType.getActuate();
	}

	public String getArcrole() {
		return solidPropertyType.getArcrole();
	}

	public String getHref() {
		return solidPropertyType.getHref();
	}

	public String getRemoteSchema() {
		return solidPropertyType.getRemoteSchema();
	}

	public String getRole() {
		return solidPropertyType.getRole();
	}

	public String getShow() {
		return solidPropertyType.getShow();
	}

	public String getTitle() {
		return solidPropertyType.getTitle();
	}

	public String getType() {
		return solidPropertyType.getType();
	}

	public void setActuate(String actuate) {
		solidPropertyType.setActuate(actuate);
	}

	public void setArcrole(String arcrole) {
		solidPropertyType.setArcrole(arcrole);
	}

	public void setHref(String href) {
		solidPropertyType.setHref(href);
	}

	public void setRemoteSchema(String remoteSchema) {
		solidPropertyType.setRemoteSchema(remoteSchema);
	}

	public void setRole(String role) {
		solidPropertyType.setRole(role);
	}

	public void setShow(String show) {
		solidPropertyType.setShow(show);
	}

	public void setTitle(String title) {
		solidPropertyType.setTitle(title);
	}

	public void setType(String type) {
		solidPropertyType.setType(type);
	}

	public void setSolid(AbstractSolid abstractSolid) {
		JAXBElement<? extends AbstractSolidType> jaxbElem = null;

		switch (abstractSolid.getGMLClass()) {
		case SOLID:
			jaxbElem = ObjectFactory.GML.createSolid(((SolidImpl)abstractSolid).getJAXBObject());
			break;
		case COMPOSITESOLID:
			jaxbElem = ObjectFactory.GML.createCompositeSolid(((CompositeSolidImpl)abstractSolid).getJAXBObject());
			break;
		}

		if (jaxbElem != null)
			solidPropertyType.set_Solid(jaxbElem);
	}

	public boolean isSetActuate() {
		return solidPropertyType.isSetActuate();
	}

	public boolean isSetArcrole() {
		return solidPropertyType.isSetArcrole();
	}

	public boolean isSetHref() {
		return solidPropertyType.isSetHref();
	}

	public boolean isSetRemoteSchema() {
		return solidPropertyType.isSetRemoteSchema();
	}

	public boolean isSetRole() {
		return solidPropertyType.isSetRole();
	}

	public boolean isSetShow() {
		return solidPropertyType.isSetShow();
	}

	public boolean isSetTitle() {
		return solidPropertyType.isSetTitle();
	}

	public boolean isSetType() {
		return solidPropertyType.isSetType();
	}

	public void unsetActuate() {
		solidPropertyType.setActuate(null);
	}

	public void unsetArcrole() {
		solidPropertyType.setArcrole(null);
	}

	public void unsetHref() {
		solidPropertyType.setHref(null);
	}

	public void unsetRemoteSchema() {
		solidPropertyType.setRemoteSchema(null);
	}

	public void unsetRole() {
		solidPropertyType.setRole(null);
	}

	public void unsetShow() {
		solidPropertyType.setShow(null);
	}

	public void unsetTitle() {
		solidPropertyType.setTitle(null);
	}

	public void unsetType() {
		solidPropertyType.setType(null);
	}

	public boolean isSetSolid() {
		return solidPropertyType.isSet_Solid();
	}

	public void unsetSolid() {
		solidPropertyType.set_Solid(null);
	}
	
}
