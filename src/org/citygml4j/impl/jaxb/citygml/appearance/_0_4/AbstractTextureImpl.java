package org.citygml4j.impl.jaxb.citygml.appearance._0_4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.jaxb.citygml._0_4.AbstractTextureType;
import org.citygml4j.jaxb.citygml._0_4.TextureTypeType;
import org.citygml4j.jaxb.citygml._0_4.WrapModeType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.appearance.AbstractTexture;
import org.citygml4j.model.citygml.appearance.ColorPlusOpacity;
import org.citygml4j.model.citygml.appearance.TextureType;
import org.citygml4j.model.citygml.appearance.WrapMode;

public abstract class AbstractTextureImpl extends AbstractSurfaceDataImpl implements AbstractTexture {
	private AbstractTextureType abstractTextureType;

	public AbstractTextureImpl(AbstractTextureType abstractTextureType) {
		super(abstractTextureType);
		this.abstractTextureType = abstractTextureType;
	}

	@Override
	public AbstractTextureType getJAXBObject() {
		return abstractTextureType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.ABSTRACTTEXTURE;
	}

	@Override
	public ColorPlusOpacity getBorderColor() {
		if (abstractTextureType.isSetBorderColor()) {
			ColorPlusOpacity colorPlusOpacity = new ColorPlusOpacityImpl();
			List<Double> borderColor = abstractTextureType.getBorderColor();

			if (borderColor.size() >= 3) {
				colorPlusOpacity.setRed(borderColor.get(0));
				colorPlusOpacity.setGreen(borderColor.get(1));
				colorPlusOpacity.setBlue(borderColor.get(2));

				if (borderColor.size() >= 4)
					colorPlusOpacity.setOpacity(borderColor.get(3));
			}

			return colorPlusOpacity;
		}

		return null;
	}

	@Override
	public String getImageURI() {
		return abstractTextureType.getImageURI();
	}

	@Override
	public String getMimeType() {
		return abstractTextureType.getMimeType();
	}

	@Override
	public TextureType getTextureType() {
		if (abstractTextureType.isSetTextureType()) {
			TextureType textureType = null;

			try {
				textureType = TextureTypeImpl.fromValue(abstractTextureType.getTextureType().value());
			} catch (IllegalArgumentException e) {
				//
			}

			return textureType;
		}

		return null;
	}

	@Override
	public WrapMode getWrapMode() {
		if (abstractTextureType.isSetWrapMode()) {
			WrapMode wrapMode = null;

			try {
				wrapMode = WrapModeImpl.fromValue(abstractTextureType.getWrapMode().value());
			} catch (IllegalArgumentException e) {
				//
			}

			return wrapMode;
		}

		return null;
	}

	@Override
	public void setImageURI(String imageURI) {
		abstractTextureType.setImageURI(imageURI);
	}

	@Override
	public void setMimeType(String mimeType) {
		abstractTextureType.setMimeType(mimeType);
	}

	@Override
	public void setTextureType(TextureType textureType) {
		TextureTypeType textureTypeType = null;

		try {
			textureTypeType = TextureTypeType.fromValue(((TextureTypeImpl)textureType).getValue());
		} catch (IllegalArgumentException e) {
			//
		}

		if (textureTypeType != null)
			abstractTextureType.setTextureType(textureTypeType);
	}

	@Override
	public void setBorderColor(ColorPlusOpacity borderColor) {
		abstractTextureType.unsetBorderColor();
		abstractTextureType.getBorderColor().addAll(borderColor.toList());
	}

	@Override
	public void setWrapMode(WrapMode wrapMode) {
		WrapModeType wrapModeType = null;

		try {
			wrapModeType = WrapModeType.fromValue(((WrapModeImpl)wrapMode).getValue());
		} catch (IllegalArgumentException e) {
			//
		}

		if (wrapModeType != null)
			abstractTextureType.setWrapMode(wrapModeType);
	}

	@Override
	public void addGenericApplicationPropertyOfTexture(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			abstractTextureType.get_GenericApplicationPropertyOfAbstractTexture().add(jaxbElem);
	}

	@Override
	public List<ADEComponent> getGenericApplicationPropertyOfTexture() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();

		for (JAXBElement<?> elem : abstractTextureType.get_GenericApplicationPropertyOfAbstractTexture()) {
			if (elem.getValue() != null) {
				ADEComponent ade = ModelMapper.ADE.toADEComponent(elem.getValue(), elem.getName());
				if (ade != null)
					adeList.add(ade);
			}
		}

		return adeList;
	}

	@Override
	public void setGenericApplicationPropertyOfTexture(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			abstractTextureType.unset_GenericApplicationPropertyOfAbstractTexture();
			abstractTextureType.get_GenericApplicationPropertyOfAbstractTexture().addAll(elemList);
		}
	}

	@Override
	public boolean isSetBorderColor() {
		return abstractTextureType.isSetBorderColor();
	}

	@Override
	public boolean isSetGenericApplicationPropertyOfTexture() {
		return abstractTextureType.isSet_GenericApplicationPropertyOfAbstractTexture();
	}

	@Override
	public boolean isSetImageUri() {
		return abstractTextureType.isSetImageURI();
	}

	@Override
	public boolean isSetMimeType() {
		return abstractTextureType.isSetMimeType();
	}

	@Override
	public boolean isSetTextureType() {
		return abstractTextureType.isSetTextureType();
	}

	@Override
	public boolean isSetWrapMode() {
		return abstractTextureType.isSetWrapMode();
	}

	@Override
	public void unsetBorderColor() {
		abstractTextureType.unsetBorderColor();
	}

	@Override
	public void unsetGenericApplicationPropertyOfTexture() {
		abstractTextureType.unset_GenericApplicationPropertyOfAbstractTexture();
	}

	@Override
	public void unsetMimeType() {
		abstractTextureType.setMimeType(null);
	}

	@Override
	public void unsetTextureType() {
		abstractTextureType.setTextureType(null);
	}

	@Override
	public void unsetWrapMode() {
		abstractTextureType.setWrapMode(null);
	}

	@Override
	public void unsetImageUri() {
		abstractTextureType.setImageURI(null);
	}

	@Override
	public boolean unsetGenericApplicationPropertyOfTexture(ADEComponent adeObject) {
		if (abstractTextureType.isSet_GenericApplicationPropertyOfAbstractTexture()) {
			Iterator<JAXBElement<?>> iter = abstractTextureType.get_GenericApplicationPropertyOfAbstractTexture().iterator();
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

}
