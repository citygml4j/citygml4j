package org.citygml4j.impl.jaxb.citygml.core._1;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ObjectFactory;
import org.citygml4j.impl.jaxb.gml._3_1_1.AssociationImpl;
import org.citygml4j.jaxb.citygml.core._1.ImplicitGeometryType;
import org.citygml4j.jaxb.citygml.core._1.ImplicitRepresentationPropertyType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.core.CoreModule;
import org.citygml4j.model.citygml.core.ImplicitGeometry;
import org.citygml4j.model.citygml.core.ImplicitRepresentationProperty;

public class ImplicitRepresentationPropertyImpl extends AssociationImpl<ImplicitGeometry> implements ImplicitRepresentationProperty {
	private ImplicitRepresentationPropertyType implicitPropertyType;

	public ImplicitRepresentationPropertyImpl() {
		this(new ImplicitRepresentationPropertyType());
	}

	public ImplicitRepresentationPropertyImpl(ImplicitRepresentationPropertyType implicitPropertyType) {
		super(implicitPropertyType);
		this.implicitPropertyType = implicitPropertyType;
	}

	@Override
	public ImplicitRepresentationPropertyType getJAXBObject() {
		return implicitPropertyType;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.IMPLICITREPRESENTATIONPROPERTY;
	}
	
	public final CityGMLModule getCityGMLModule() {
		return CoreModule.v1_0_0;
	}

	public ImplicitGeometry getObject() {
		if (implicitPropertyType.isSet_Object()) {
			JAXBElement<?> elem = implicitPropertyType.get_Object();
			if (elem.getValue() != null) {
				if (elem.getValue() instanceof ImplicitGeometryType)
					return new ImplicitGeometryImpl((ImplicitGeometryType)elem.getValue());
			}
		}

		return null;
	}

	public void setObject(ImplicitGeometry object) {
		JAXBElement<?> jaxbElem = ObjectFactory.CORE_1.createImplicitGeometry(((ImplicitGeometryImpl)object).getJAXBObject());
		implicitPropertyType.set_Object(jaxbElem);
	}

}
