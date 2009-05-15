package org.citygml4j.impl.jaxb.citygml.relief._0_4;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ObjectFactory;
import org.citygml4j.impl.jaxb.gml._3_1_1.AssociationImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.TinImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.TriangulatedSurfaceImpl;
import org.citygml4j.jaxb.citygml._0_4.TinPropertyType;
import org.citygml4j.jaxb.gml._3_1_1.TinType;
import org.citygml4j.jaxb.gml._3_1_1.TriangulatedSurfaceType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.relief.ReliefModule;
import org.citygml4j.model.citygml.relief.TinProperty;
import org.citygml4j.model.gml.TriangulatedSurface;

public class TinPropertyImpl extends AssociationImpl<TriangulatedSurface> implements TinProperty {
	TinPropertyType tinPropertyType;
	
	public TinPropertyImpl() {
		this(new TinPropertyType());
	}
	
	public TinPropertyImpl(TinPropertyType tinPropertyType) {
		super(tinPropertyType);
		this.tinPropertyType = tinPropertyType;
	}
	
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TINPROPERTY;
	}
	
	public final CityGMLModule getCityGMLModule() {
		return ReliefModule.v0_4_0;
	}

	@Override
	public TinPropertyType getJAXBObject() {
		return tinPropertyType;
	}

	public TriangulatedSurface getObject() {
		if (tinPropertyType.isSet_Object()) {
			JAXBElement<?> elem = tinPropertyType.get_Object();
			if (elem.getValue() != null) {
				if (elem.getValue() instanceof TinType)
					return new TinImpl((TinType)elem.getValue());
				else if (elem.getValue() instanceof TriangulatedSurfaceType)
					return new TriangulatedSurfaceImpl((TriangulatedSurfaceType)elem.getValue());
			}				
		}
		
		return null;
	}

	public void setObject(TriangulatedSurface object) {
		JAXBElement<?> jaxbElem = null;
		
		switch (object.getGMLClass()) {
		case TIN:
			jaxbElem = ObjectFactory.GML.createTin(((TinImpl)object).getJAXBObject());
			break;
		case TRIANGULATEDSURFACE:
			jaxbElem = ObjectFactory.GML.createTriangulatedSurface(((TriangulatedSurfaceImpl)object).getJAXBObject());
			break;
		}
		
		if (jaxbElem != null)
			tinPropertyType.set_Object(jaxbElem);
	}

}
