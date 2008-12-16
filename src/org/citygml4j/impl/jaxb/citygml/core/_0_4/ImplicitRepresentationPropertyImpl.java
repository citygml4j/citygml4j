package org.citygml4j.impl.jaxb.citygml.core._0_4;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ObjectFactory;
import org.citygml4j.impl.jaxb.gml._3_1_1.AssociationImpl;
import org.citygml4j.jaxb.citygml._0_4.ImplicitGeometryType;
import org.citygml4j.jaxb.citygml._0_4.ImplicitRepresentationPropertyType;
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

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.IMPLICITREPRESENTATIONPROPERTY;
	}
	
	@Override
	public final CityGMLModule getCityGMLModule() {
		return CoreModule.v0_4_0;
	}

	@Override
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

	@Override
	public void setObject(ImplicitGeometry object) {
		JAXBElement<?> jaxbElem = ObjectFactory.CITYGML_0_4.createImplicitGeometry(((ImplicitGeometryImpl)object).getJAXBObject());
		implicitPropertyType.set_Object(jaxbElem);
	}

}
