/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright 2013-2017 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citygml4j.model.citygml.texturedsurface;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.module.citygml.TexturedSurfaceModule;

import java.util.ArrayList;
import java.util.List;

public class _SimpleTexture extends _AbstractAppearance {
	private String textureMap;
	private List<Double> textureCoordinates;
	private _TextureType _textureType;
	private Boolean repeat;
	
	public _SimpleTexture() {
		
	}
	
	public _SimpleTexture(TexturedSurfaceModule module) {
		super(module);
	}
	
	public Boolean getRepeat() {
		return repeat;
	}

	public List<Double> getTextureCoordinates() {
		if (textureCoordinates == null)
			textureCoordinates = new ArrayList<Double>();
		
		return textureCoordinates;
	}

	public String getTextureMap() {
		return textureMap;
	}

	public _TextureType getTextureType() {
		return _textureType;
	}

	public boolean isSetRepeat() {
		return repeat != null;
	}

	public boolean isSetTextureCoordinates() {
		return textureCoordinates != null && !textureCoordinates.isEmpty();
	}

	public boolean isSetTextureMap() {
		return textureMap != null;
	}

	public boolean isSetTextureType() {
		return _textureType != null;
	}

	public void setRepeat(Boolean repeat) {
		this.repeat = repeat;
	}

	public void setTextureCoordinates(List<Double> textureCoordinates) {
		this.textureCoordinates = textureCoordinates;
	}

	public void setTextureMap(String textureMap) {
		this.textureMap = textureMap;
	}

	public void setTextureType(_TextureType _textureType) {
		this._textureType = _textureType;
	}

	public void unsetRepeat() {
		repeat = null;
	}

	public void unsetTextureType() {
		_textureType = null;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass._SIMPLE_TEXTURE;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new _SimpleTexture(), copyBuilder);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		_SimpleTexture copy = (target == null) ? new _SimpleTexture() : (_SimpleTexture)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetTextureMap())
			copy.setTextureMap(copyBuilder.copy(textureMap));
		
		if (isSetTextureCoordinates())
			copy.setTextureCoordinates((List<Double>)copyBuilder.copy(textureCoordinates));
		
		if (isSetTextureType())
			copy.setTextureType((_TextureType)copyBuilder.copy(_textureType));
		
		if (isSetRepeat())
			copy.setRepeat(copyBuilder.copy(repeat));
		
		return copy;
	}
	
	public void accept(GMLVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T accept(GMLFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
