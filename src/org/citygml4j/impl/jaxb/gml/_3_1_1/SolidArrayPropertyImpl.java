package org.citygml4j.impl.jaxb.gml._3_1_1;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ObjectFactory;
import org.citygml4j.jaxb.gml._3_1_1.AbstractSolidType;
import org.citygml4j.jaxb.gml._3_1_1.CompositeSolidType;
import org.citygml4j.jaxb.gml._3_1_1.SolidArrayPropertyType;
import org.citygml4j.jaxb.gml._3_1_1.SolidType;
import org.citygml4j.model.gml.AbstractSolid;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.SolidArrayProperty;

public class SolidArrayPropertyImpl extends GMLBaseImpl implements SolidArrayProperty {
	private SolidArrayPropertyType solidArrayPropertyType;

	public SolidArrayPropertyImpl() {
		solidArrayPropertyType = new SolidArrayPropertyType();
	}

	public SolidArrayPropertyImpl(SolidArrayPropertyType solidArrayPropertyType) {
		this.solidArrayPropertyType = solidArrayPropertyType;
	}

	@Override
	public SolidArrayPropertyType getJAXBObject() {
		return solidArrayPropertyType;
	}

	@Override
	public List<AbstractSolid> getSolid() {
		List<AbstractSolid> abstractSolidList = new ArrayList<AbstractSolid>();

		for (JAXBElement<? extends AbstractSolidType> abstractSolidType : solidArrayPropertyType.get_Solid()) {
			if (abstractSolidType.getValue() != null) {
				if (abstractSolidType.getValue() instanceof SolidType)
					abstractSolidList.add(new SolidImpl((SolidType)abstractSolidType.getValue()));
				else if (abstractSolidType.getValue() instanceof CompositeSolidType)
					abstractSolidList.add(new CompositeSolidImpl((CompositeSolidType)abstractSolidType.getValue()));
			}
		}

		return abstractSolidList;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.SOLIDARRAYPROPERTY;
	}

	@Override
	public void addSolid(AbstractSolid abstractSolid) {
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
			solidArrayPropertyType.get_Solid().add(jaxbElem);
	}

	@Override
	public void setSolid(List<AbstractSolid> abstractSolid) {
		List<JAXBElement<? extends AbstractSolidType>> jaxbElemList = new ArrayList<JAXBElement<? extends AbstractSolidType>>();

		for (AbstractSolid solid : abstractSolid) {
			switch (solid.getGMLClass()) {
			case SOLID:
				jaxbElemList.add(ObjectFactory.GML.createSolid(((SolidImpl)solid).getJAXBObject()));
				break;
			case COMPOSITESOLID:
				jaxbElemList.add(ObjectFactory.GML.createCompositeSolid(((CompositeSolidImpl)solid).getJAXBObject()));
				break;
			}
		}

		solidArrayPropertyType.unset_Solid();
		solidArrayPropertyType.get_Solid().addAll(jaxbElemList);
	}

	@Override
	public boolean isSetSolid() {
		return solidArrayPropertyType.isSet_Solid();
	}

	@Override
	public void unsetSolid() {
		solidArrayPropertyType.unset_Solid();
	}

	@Override
	public boolean unsetSolid(AbstractSolid abstractSolid) {
		if (solidArrayPropertyType.isSet_Solid())
			return solidArrayPropertyType.get_Solid().remove(((AbstractSolidImpl)abstractSolid).getJAXBObject());
		
		return false;
	}

}
