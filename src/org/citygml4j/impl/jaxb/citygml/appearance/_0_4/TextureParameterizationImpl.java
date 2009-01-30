package org.citygml4j.impl.jaxb.citygml.appearance._0_4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.gml._3_1_1.AbstractGMLImpl;
import org.citygml4j.jaxb.citygml._0_4.TextureParameterizationType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.appearance.AppearanceModule;
import org.citygml4j.model.citygml.appearance.TextureParameterization;

public abstract class TextureParameterizationImpl extends AbstractGMLImpl implements TextureParameterization {
	private TextureParameterizationType textureParameterizationType;

	public TextureParameterizationImpl(TextureParameterizationType textureParameterizationType) {
		super(textureParameterizationType);
		this.textureParameterizationType = textureParameterizationType;
	}

	@Override
	public TextureParameterizationType getJAXBObject() {
		return textureParameterizationType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TEXTUREPARAMETERIZATION;
	}

	@Override
	public final CityGMLModule getCityGMLModule() {
		return AppearanceModule.v0_4_0;
	}

	@Override
	public void addGenericApplicationPropertyOfTextureParameterization(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			textureParameterizationType.get_GenericApplicationPropertyOfTextureParameterization().add(jaxbElem);
	}

	@Override
	public List<ADEComponent> getGenericApplicationPropertyOfTextureParameterization() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();

		for (JAXBElement<?> elem : textureParameterizationType.get_GenericApplicationPropertyOfTextureParameterization()) {
			if (elem.getValue() != null) {
				ADEComponent ade = ModelMapper.ADE.toADEComponent(elem.getValue(), elem.getName());
				if (ade != null)
					adeList.add(ade);
			}
		}

		return adeList;
	}

	@Override
	public void setGenericApplicationPropertyOfTextureParameterization(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			textureParameterizationType.unset_GenericApplicationPropertyOfTextureParameterization();
			textureParameterizationType.get_GenericApplicationPropertyOfTextureParameterization().addAll(elemList);
		}
	}

	@Override
	public boolean isSetGenericApplicationPropertyOfTextureParameterization() {
		return textureParameterizationType.isSet_GenericApplicationPropertyOfTextureParameterization();
	}

	@Override
	public void unsetGenericApplicationPropertyOfTextureParameterization() {
		textureParameterizationType.unset_GenericApplicationPropertyOfTextureParameterization();
	}

	@Override
	public boolean unsetGenericApplicationPropertyOfTextureParameterization(ADEComponent adeObject) {
		if (textureParameterizationType.isSet_GenericApplicationPropertyOfTextureParameterization()) {
			Iterator<JAXBElement<?>> iter = textureParameterizationType.get_GenericApplicationPropertyOfTextureParameterization().iterator();
			while (iter.hasNext()) {
				JAXBElement<?> elem = iter.next();
				if (elem.getValue() != null && elem.getValue() != null) {
					JAXBElement<?> ade = ModelMapper.ADE.toJAXB(adeObject);
					if (ade != null && ade.getValue() != null && elem.getValue().equals(ade.getValue())) {
						iter.remove();
						return true;
					}
				}
			}				
		}
		
		return false;
	}

}
