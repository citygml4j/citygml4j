package org.citygml4j.impl.jaxb.citygml.core._0_4;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.gml._3_1_1.AssociationImpl;
import org.citygml4j.jaxb.citygml._0_4.GeneralizationRelationType;
import org.citygml4j.jaxb.citygml._0_4._CityObjectType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.core.CityObject;
import org.citygml4j.model.citygml.core.CoreModule;
import org.citygml4j.model.citygml.core.GeneralizationRelation;

public class GeneralizationRelationImpl extends AssociationImpl<CityObject> implements GeneralizationRelation {
	private GeneralizationRelationType generalizationRelationType;

	public GeneralizationRelationImpl() {
		this(new GeneralizationRelationType());
	}

	public GeneralizationRelationImpl(GeneralizationRelationType generalizationRelationType) {
		super(generalizationRelationType);
		this.generalizationRelationType = generalizationRelationType;
	}

	@Override
	public GeneralizationRelationType getJAXBObject() {
		return generalizationRelationType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.GENERALIZATIONRELATION;
	}

	@Override
	public final CityGMLModule getCityGMLModule() {
		return CoreModule.v0_4_0;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public CityObject getObject() {
		CityObject cityObject = null;
		
		if (generalizationRelationType.isSet_Object()) {
			JAXBElement<?> jaxbElem = generalizationRelationType.get_Object();
			
			// we only allow a relation pointing to a _CityObject
			if (jaxbElem.getValue() != null && jaxbElem.getValue() instanceof _CityObjectType)
				cityObject = ModelMapper.CITYOBJECT_0_4.toCityGML((JAXBElement<? extends _CityObjectType>)jaxbElem);
		}

		return cityObject;
	}
	
	@Override
	public void setObject(CityObject object) {
		JAXBElement<?> cityObjectElem = ModelMapper.CITYOBJECT_0_4.toJAXB(object);		
		if (cityObjectElem != null)
			generalizationRelationType.set_Object(cityObjectElem);
	}

}
