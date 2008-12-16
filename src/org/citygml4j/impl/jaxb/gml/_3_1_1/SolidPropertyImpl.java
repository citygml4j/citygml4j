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

	@Override
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

	@Override
	public String getActuate() {
		return solidPropertyType.getActuate();
	}

	@Override
	public String getArcrole() {
		return solidPropertyType.getArcrole();
	}

	@Override
	public String getHref() {
		return solidPropertyType.getHref();
	}

	@Override
	public String getRemoteSchema() {
		return solidPropertyType.getRemoteSchema();
	}

	@Override
	public String getRole() {
		return solidPropertyType.getRole();
	}

	@Override
	public String getShow() {
		return solidPropertyType.getShow();
	}

	@Override
	public String getTitle() {
		return solidPropertyType.getTitle();
	}

	@Override
	public String getType() {
		return solidPropertyType.getType();
	}

	@Override
	public void setActuate(String actuate) {
		solidPropertyType.setActuate(actuate);
	}

	@Override
	public void setArcrole(String arcrole) {
		solidPropertyType.setArcrole(arcrole);
	}

	@Override
	public void setHref(String href) {
		solidPropertyType.setHref(href);
	}

	@Override
	public void setRemoteSchema(String remoteSchema) {
		solidPropertyType.setRemoteSchema(remoteSchema);
	}

	@Override
	public void setRole(String role) {
		solidPropertyType.setRole(role);
	}

	@Override
	public void setShow(String show) {
		solidPropertyType.setShow(show);
	}

	@Override
	public void setTitle(String title) {
		solidPropertyType.setTitle(title);
	}

	@Override
	public void setType(String type) {
		solidPropertyType.setType(type);
	}

	@Override
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

	@Override
	public boolean isSetActuate() {
		return solidPropertyType.isSetActuate();
	}

	@Override
	public boolean isSetArcrole() {
		return solidPropertyType.isSetArcrole();
	}

	@Override
	public boolean isSetHref() {
		return solidPropertyType.isSetHref();
	}

	@Override
	public boolean isSetRemoteSchema() {
		return solidPropertyType.isSetRemoteSchema();
	}

	@Override
	public boolean isSetRole() {
		return solidPropertyType.isSetRole();
	}

	@Override
	public boolean isSetShow() {
		return solidPropertyType.isSetShow();
	}

	@Override
	public boolean isSetTitle() {
		return solidPropertyType.isSetTitle();
	}

	@Override
	public boolean isSetType() {
		return solidPropertyType.isSetType();
	}

	@Override
	public void unsetActuate() {
		solidPropertyType.setActuate(null);
	}

	@Override
	public void unsetArcrole() {
		solidPropertyType.setArcrole(null);
	}

	@Override
	public void unsetHref() {
		solidPropertyType.setHref(null);
	}

	@Override
	public void unsetRemoteSchema() {
		solidPropertyType.setRemoteSchema(null);
	}

	@Override
	public void unsetRole() {
		solidPropertyType.setRole(null);
	}

	@Override
	public void unsetShow() {
		solidPropertyType.setShow(null);
	}

	@Override
	public void unsetTitle() {
		solidPropertyType.setTitle(null);
	}

	@Override
	public void unsetType() {
		solidPropertyType.setType(null);
	}

	@Override
	public boolean isSetSolid() {
		return solidPropertyType.isSet_Solid();
	}

	@Override
	public void unsetSolid() {
		solidPropertyType.set_Solid(null);
	}
	
}
