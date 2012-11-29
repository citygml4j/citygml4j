/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2012
 * Institute for Geodesy and Geoinformation Science
 * Technische Universität Berlin, Germany
 * http://www.igg.tu-berlin.de/
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 * 
 * $Id$
 */
package org.citygml4j.model.citygml.appearance;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.module.citygml.AppearanceModule;

public abstract class AbstractTexture extends AbstractSurfaceData {
	private String imageURI;
	private Code mimeType;
	private TextureType textureType;
	private WrapMode wrapMode;
	private ColorPlusOpacity borderColor;
	private List<ADEComponent> ade;
	
	public AbstractTexture() {
		
	}
	
	public AbstractTexture(AppearanceModule module) {
		super(module);
	}
	
	public void addGenericApplicationPropertyOfTexture(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public ColorPlusOpacity getBorderColor() {
		return borderColor;
	}

	public List<ADEComponent> getGenericApplicationPropertyOfTexture() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public String getImageURI() {
		return imageURI;
	}

	public Code getMimeType() {
		return mimeType;
	}

	public TextureType getTextureType() {
		return textureType;
	}

	public WrapMode getWrapMode() {
		return wrapMode;
	}

	public boolean isSetBorderColor() {
		return borderColor != null;
	}

	public boolean isSetGenericApplicationPropertyOfTexture() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetImageURI() {
		return imageURI != null;
	}

	public boolean isSetMimeType() {
		return mimeType != null;
	}

	public boolean isSetTextureType() {
		return textureType != null;
	}

	public boolean isSetWrapMode() {
		return wrapMode != null;
	}

	public void setBorderColor(ColorPlusOpacity borderColor) {
		if (borderColor != null)
			borderColor.setParent(this);
		
		this.borderColor = borderColor;
	}

	public void setGenericApplicationPropertyOfTexture(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void setImageURI(String imageURI) {
		this.imageURI = imageURI;
	}

	public void setMimeType(Code mimeType) {
		this.mimeType = mimeType;
	}

	public void setTextureType(TextureType textureType) {
		this.textureType = textureType;
	}

	public void setWrapMode(WrapMode wrapMode) {
		this.wrapMode = wrapMode;
	}

	public void unsetBorderColor() {
		if (isSetBorderColor())
			borderColor.unsetParent();
		
		borderColor = null;
	}

	public void unsetGenericApplicationPropertyOfTexture() {
		if (isSetGenericApplicationPropertyOfTexture())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfTexture(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfTexture() ? this.ade.remove(ade) : false;
	}

	public void unsetImageURI() {
		imageURI = null;
	}

	public void unsetMimeType() {
		mimeType = null;
	}

	public void unsetTextureType() {
		textureType = null;
	}

	public void unsetWrapMode() {
		wrapMode = null;
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
			throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		AbstractTexture copy = (AbstractTexture)target;		
		super.copyTo(copy, copyBuilder);
		
		if (isSetImageURI())
			copy.setImageURI(copyBuilder.copy(imageURI));
		
		if (isSetMimeType())
			copy.setMimeType((Code)copyBuilder.copy(mimeType));
		
		if (isSetTextureType())
			copy.setTextureType((TextureType)copyBuilder.copy(textureType));
		
		if (isSetWrapMode())
			copy.setWrapMode((WrapMode)copyBuilder.copy(wrapMode));
		
		if (isSetBorderColor()) {
			copy.setBorderColor((ColorPlusOpacity)copyBuilder.copy(borderColor));
			if (copy.getBorderColor() == borderColor)
				borderColor.setParent(this);
		}

		if (isSetGenericApplicationPropertyOfTexture()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfTexture(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		return copy;
	}

}
