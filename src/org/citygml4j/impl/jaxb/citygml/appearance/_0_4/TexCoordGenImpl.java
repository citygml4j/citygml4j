package org.citygml4j.impl.jaxb.citygml.appearance._0_4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.jaxb.citygml._0_4.TexCoordGenType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.appearance.TexCoordGen;
import org.citygml4j.model.citygml.appearance.WorldToTexture;

public class TexCoordGenImpl extends TextureParameterizationImpl implements TexCoordGen {
	private TexCoordGenType texCoordGenType;

	public TexCoordGenImpl() {
		this(new TexCoordGenType());
	}

	public TexCoordGenImpl(TexCoordGenType texCoordGenType) {
		super(texCoordGenType);
		this.texCoordGenType = texCoordGenType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TEXCOORDGEN;
	}

	@Override
	public TexCoordGenType getJAXBObject() {
		return texCoordGenType;
	}

	public WorldToTexture getWorldToTexture() {
		if (texCoordGenType.isSetWorldToTexture())
			return new WorldToTextureImpl(texCoordGenType.getWorldToTexture());

		return null;
	}

	public void setWorldToTexture(WorldToTexture worldToTexture) {
		texCoordGenType.setWorldToTexture(((WorldToTextureImpl)worldToTexture).getJAXBObject());
	}

	public void addGenericApplicationPropertyOfTexCoordGen(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			texCoordGenType.get_GenericApplicationPropertyOfTexCoordGen().add(jaxbElem);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfTexCoordGen() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();

		for (JAXBElement<?> elem : texCoordGenType.get_GenericApplicationPropertyOfTexCoordGen()) {
			if (elem.getValue() != null) {
				ADEComponent ade = ModelMapper.ADE.toADEComponent(elem.getValue(), elem.getName());
				if (ade != null)
					adeList.add(ade);
			}
		}

		return adeList;
	}

	public void setGenericApplicationPropertyOfTexCoordGen(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			texCoordGenType.unset_GenericApplicationPropertyOfTexCoordGen();
			texCoordGenType.get_GenericApplicationPropertyOfTexCoordGen().addAll(elemList);
		}
	}

	public boolean isSetGenericApplicationPropertyOfTexCoordGen() {
		return texCoordGenType.isSet_GenericApplicationPropertyOfTexCoordGen();
	}

	public boolean isSetWorldToTexture() {
		return texCoordGenType.isSetWorldToTexture();
	}

	public void unsetGenericApplicationPropertyOfTexCoordGen() {
		texCoordGenType.unset_GenericApplicationPropertyOfTexCoordGen();
	}

	public void unsetWorldToTexture() {
		texCoordGenType.setWorldToTexture(null);
	}

	public boolean unsetGenericApplicationPropertyOfTexCoordGen(ADEComponent adeObject) {
		if (texCoordGenType.isSet_GenericApplicationPropertyOfTexCoordGen()) {
			Iterator<JAXBElement<?>> iter = texCoordGenType.get_GenericApplicationPropertyOfTexCoordGen().iterator();
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
