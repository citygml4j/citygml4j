package org.citygml4j.impl.jaxb.citygml.appearance._1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.jaxb.citygml.app._1.TexCoordListType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.appearance.TexCoordList;
import org.citygml4j.model.citygml.appearance.TextureCoordinates;

public class TexCoordListImpl extends TextureParameterizationImpl implements TexCoordList {
	private TexCoordListType texCoordListType;

	public TexCoordListImpl() {
		this(new TexCoordListType());
	}

	public TexCoordListImpl(TexCoordListType texCoordListType) {
		super(texCoordListType);
		this.texCoordListType = texCoordListType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TEXCOORDLIST;
	}

	@Override
	public TexCoordListType getJAXBObject() {
		return texCoordListType;
	}

	@Override
	public void addTextureCoordinates(TextureCoordinates textureCoordinates) {
		texCoordListType.getTextureCoordinates().add(((TextureCoordinatesImpl)textureCoordinates).getJAXBObject());
	}

	@Override
	public List<TextureCoordinates> getTextureCoordinates() {
		List<TextureCoordinates> texCoordList = new ArrayList<TextureCoordinates>();

		for (TexCoordListType.TextureCoordinates texCoordType : texCoordListType.getTextureCoordinates())
			texCoordList.add(new TextureCoordinatesImpl(texCoordType));

		return texCoordList;
	}

	@Override
	public void setTextureCoordinates(List<TextureCoordinates> textureCoordinates) {
		List<TexCoordListType.TextureCoordinates> texCoordTypeList = new ArrayList<TexCoordListType.TextureCoordinates>();

		for (TextureCoordinates texCoord : textureCoordinates)
			texCoordTypeList.add(((TextureCoordinatesImpl)texCoord).getJAXBObject());

		texCoordListType.unsetTextureCoordinates();
		texCoordListType.getTextureCoordinates().addAll(texCoordTypeList);
	}

	@Override
	public void addGenericApplicationPropertyOfTexCoordList(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			texCoordListType.get_GenericApplicationPropertyOfTexCoordList().add(jaxbElem);
	}

	@Override
	public List<ADEComponent> getGenericApplicationPropertyOfTexCoordList() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();

		for (JAXBElement<?> elem : texCoordListType.get_GenericApplicationPropertyOfTexCoordList()) {
			if (elem.getValue() != null) {
				ADEComponent ade = ModelMapper.ADE.toADEComponent(elem.getValue(), elem.getName());
				if (ade != null)
					adeList.add(ade);
			}
		}

		return adeList;
	}

	@Override
	public void setGenericApplicationPropertyOfTexCoordList(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			texCoordListType.unset_GenericApplicationPropertyOfTexCoordList();
			texCoordListType.get_GenericApplicationPropertyOfTexCoordList().addAll(elemList);
		}
	}

	@Override
	public boolean isSetGenericApplicationPropertyOfTexCoordList() {
		return texCoordListType.isSet_GenericApplicationPropertyOfTexCoordList();
	}

	@Override
	public boolean isSetTextureCoordinates() {
		return texCoordListType.isSetTextureCoordinates();
	}

	@Override
	public void unsetGenericApplicationPropertyOfTexCoordList() {
		texCoordListType.unset_GenericApplicationPropertyOfTexCoordList();
	}

	@Override
	public void unsetTextureCoordinates() {
		texCoordListType.unsetTextureCoordinates();
	}
	
	@Override
	public boolean unsetGenericApplicationPropertyOfTexCoordList(ADEComponent adeObject) {
		if (texCoordListType.isSet_GenericApplicationPropertyOfTexCoordList()) {
			Iterator<JAXBElement<?>> iter = texCoordListType.get_GenericApplicationPropertyOfTexCoordList().iterator();
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

	@Override
	public boolean unsetTextureCoordinates(TextureCoordinates textureCoordinates) {
		if (texCoordListType.isSetTextureCoordinates())
			return texCoordListType.getTextureCoordinates().remove(((TextureCoordinatesImpl)textureCoordinates).getJAXBObject());
		
		return false;
	}
	
}
