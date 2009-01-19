package org.citygml4j.impl.jaxb.citygml.appearance._1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.jaxb.citygml.app._1.ParameterizedTextureType;
import org.citygml4j.jaxb.citygml.app._1.TextureAssociationType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.appearance.ParameterizedTexture;
import org.citygml4j.model.citygml.appearance.TextureAssociation;

public class ParameterizedTextureImpl extends AbstractTextureImpl implements ParameterizedTexture {
	private ParameterizedTextureType parameterizedTextureType;

	public ParameterizedTextureImpl() {
		this(new ParameterizedTextureType());
	}

	public ParameterizedTextureImpl(ParameterizedTextureType parameterizedTextureType) {
		super(parameterizedTextureType);
		this.parameterizedTextureType = parameterizedTextureType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.PARAMETERIZEDTEXTURE;
	}

	@Override
	public ParameterizedTextureType getJAXBObject() {
		return parameterizedTextureType;
	}

	@Override
	public void addTarget(TextureAssociation target) {
		parameterizedTextureType.getTarget().add(((TextureAssociationImpl)target).getJAXBObject());
	}

	@Override
	public List<TextureAssociation> getTarget() {
		List<TextureAssociation> texAssList = new ArrayList<TextureAssociation>();

		for (TextureAssociationType texAssType : parameterizedTextureType.getTarget())
			texAssList.add(new TextureAssociationImpl(texAssType));

		return texAssList;
	}

	@Override
	public void setTarget(List<TextureAssociation> target) {
		List<TextureAssociationType> texAssTypeList = new ArrayList<TextureAssociationType>();

		for (TextureAssociation texAss : target)
			texAssTypeList.add(((TextureAssociationImpl)texAss).getJAXBObject());

		parameterizedTextureType.unsetTarget();
		parameterizedTextureType.getTarget().addAll(texAssTypeList);
	}

	@Override
	public void addGenericApplicationPropertyOfParameterizedTexture(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			parameterizedTextureType.get_GenericApplicationPropertyOfParameterizedTexture().add(jaxbElem);
	}

	@Override
	public List<ADEComponent> getGenericApplicationPropertyOfParameterizedTexture() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();

		for (JAXBElement<?> elem : parameterizedTextureType.get_GenericApplicationPropertyOfParameterizedTexture()) {
			if (elem.getValue() != null) {
				ADEComponent ade = ModelMapper.ADE.toADEComponent(elem.getValue(), elem.getName());
				if (ade != null)
					adeList.add(ade);
			}
		}

		return adeList;
	}

	@Override
	public void setGenericApplicationPropertyOfParameterizedTexture(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			parameterizedTextureType.unset_GenericApplicationPropertyOfParameterizedTexture();
			parameterizedTextureType.get_GenericApplicationPropertyOfParameterizedTexture().addAll(elemList);
		}
	}

	@Override
	public boolean isSetGenericApplicationPropertyOfParameterizedTexture() {
		return parameterizedTextureType.isSet_GenericApplicationPropertyOfParameterizedTexture();
	}

	@Override
	public boolean isSetTarget() {
		return parameterizedTextureType.isSetTarget();
	}

	@Override
	public void unsetGenericApplicationPropertyOfParameterizedTexture() {
		parameterizedTextureType.unset_GenericApplicationPropertyOfParameterizedTexture();
	}

	@Override
	public void unsetTarget() {
		parameterizedTextureType.unsetTarget();
	}
	
	@Override
	public boolean unsetGenericApplicationPropertyOfParameterizedTexture(ADEComponent adeObject) {
		if (parameterizedTextureType.isSet_GenericApplicationPropertyOfParameterizedTexture()) {
			Iterator<JAXBElement<?>> iter = parameterizedTextureType.get_GenericApplicationPropertyOfParameterizedTexture().iterator();
			while (iter.hasNext()) {
				JAXBElement<?> elem = iter.next();
				if (elem.getValue() != null && elem.getValue().equals(adeObject.getJAXBObject())) {
					iter.remove();
					return true;
				}
			}				
		}
		
		return false;
	}

	@Override
	public boolean unsetTarget(TextureAssociation target) {
		if (parameterizedTextureType.isSetTarget())
			return parameterizedTextureType.getTarget().remove(((TextureAssociationImpl)target).getJAXBObject());
		
		return false;
	}
		
}
