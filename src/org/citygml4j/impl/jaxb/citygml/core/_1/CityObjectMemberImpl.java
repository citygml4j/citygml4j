package org.citygml4j.impl.jaxb.citygml.core._1;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.gml._3_1_1.FeaturePropertyImpl;
import org.citygml4j.jaxb.gml._3_1_1.AbstractFeatureType;
import org.citygml4j.jaxb.gml._3_1_1.FeaturePropertyType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.core.CityObject;
import org.citygml4j.model.citygml.core.CityObjectMember;
import org.citygml4j.model.citygml.core.CoreModule;
import org.citygml4j.model.gml.AbstractFeature;

public class CityObjectMemberImpl extends FeaturePropertyImpl implements CityObjectMember {
	private FeaturePropertyType cityObjectMember;

	public CityObjectMemberImpl() {
		this(new FeaturePropertyType());
	}

	public CityObjectMemberImpl(FeaturePropertyType cityObjectMember) {
		super(cityObjectMember);
		this.cityObjectMember = cityObjectMember;
	}

	@Override
	public AbstractFeature getFeature() {
		return getCityObject();
	}

	@Override
	public void setFeature(AbstractFeature abstractFeature) {
		// we only allow city objects here...
		if (abstractFeature instanceof CityObject)
			setCityObject((CityObject)abstractFeature);
	}

	public CityObject getCityObject() {
		CityObject cityObject = null;
		
		if (cityObjectMember.isSet_Feature()) {
			JAXBElement<? extends AbstractFeatureType> abstractFeature = cityObjectMember.get_Feature();
			
			cityObject = ModelMapper.CITYOBJECT_1.toCityGML(abstractFeature);
			if (cityObject == null)
				cityObject = ModelMapper.CITYOBJECT_0_4.toCityGML(abstractFeature);
		}
		
		return cityObject;
	}

	public void setCityObject(CityObject cityObject) {
		JAXBElement<? extends AbstractFeatureType> cityObjectElem = null;
		
		cityObjectElem = ModelMapper.CITYOBJECT_1.toJAXB(cityObject);
		if (cityObjectElem == null)
			cityObjectElem = ModelMapper.CITYOBJECT_0_4.toJAXB(cityObject);
		
		if (cityObjectElem != null)
			cityObjectMember.set_Feature(cityObjectElem);		
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.CITYOBJECTMEMBER;
	}

	public final CityGMLModule getCityGMLModule() {
		return CoreModule.v1_0_0;
	}

	@Override
	public FeaturePropertyType getJAXBObject() {
		return cityObjectMember;
	}
	
	public boolean isSetCityObject() {
		return cityObjectMember.isSet_Feature();
	}

	public void unsetCityObject() {
		cityObjectMember.set_Feature(null);
	}
}
