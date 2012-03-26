/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universitaet Berlin, Germany
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
 */
package org.citygml4j.factory;

import org.citygml4j.model.citygml.texturedsurface._AbstractAppearance;
import org.citygml4j.model.citygml.texturedsurface._AppearanceProperty;
import org.citygml4j.model.citygml.texturedsurface._AppearanceProperty;
import org.citygml4j.model.citygml.texturedsurface._Color;
import org.citygml4j.model.citygml.texturedsurface._Color;
import org.citygml4j.model.citygml.texturedsurface._Material;
import org.citygml4j.model.citygml.texturedsurface._Material;
import org.citygml4j.model.citygml.texturedsurface._SimpleTexture;
import org.citygml4j.model.citygml.texturedsurface._SimpleTexture;
import org.citygml4j.model.citygml.texturedsurface._TexturedSurface;
import org.citygml4j.model.citygml.texturedsurface._TexturedSurface;

public class TexturedSurfaceFactory {

	public TexturedSurfaceFactory() {
		
	}

	public _AppearanceProperty create_AppearanceProperty() {
		return new _AppearanceProperty();
	}
	
	public _AppearanceProperty create_AppearanceProperty(_AbstractAppearance appearance) {
		_AppearanceProperty appearanceProperty = new _AppearanceProperty();
		appearanceProperty.setAppearance(appearance);
		return appearanceProperty;
	}
	
	public _AppearanceProperty create_AppearanceProperty(String xlink) {
		_AppearanceProperty appearanceProperty = new _AppearanceProperty();
		appearanceProperty.setHref(xlink);
		return appearanceProperty;
	}

	public _Color create_Color() {
		return new _Color();
	}

	public _Color create_Color(Double red, Double green, Double blue) {
		return new _Color(red, green, blue);
	}

	public _Material create_Material() {
		return new _Material();
	}

	public _SimpleTexture create_SimpleTexture() {
		return new _SimpleTexture();
	}

	public _TexturedSurface create_TexturedSurface() {
		return new _TexturedSurface();
	}
	
}
