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

import org.citygml4j.impl.citygml.appearance.AppearanceImpl;
import org.citygml4j.impl.citygml.appearance.AppearanceMemberImpl;
import org.citygml4j.impl.citygml.appearance.AppearancePropertyImpl;
import org.citygml4j.impl.citygml.appearance.ColorImpl;
import org.citygml4j.impl.citygml.appearance.ColorPlusOpacityImpl;
import org.citygml4j.impl.citygml.appearance.GeoreferencedTextureImpl;
import org.citygml4j.impl.citygml.appearance.ParameterizedTextureImpl;
import org.citygml4j.impl.citygml.appearance.SurfaceDataPropertyImpl;
import org.citygml4j.impl.citygml.appearance.TexCoordGenImpl;
import org.citygml4j.impl.citygml.appearance.TexCoordListImpl;
import org.citygml4j.impl.citygml.appearance.TextureAssociationImpl;
import org.citygml4j.impl.citygml.appearance.TextureCoordinatesImpl;
import org.citygml4j.impl.citygml.appearance.WorldToTextureImpl;
import org.citygml4j.impl.citygml.appearance.X3DMaterialImpl;
import org.citygml4j.model.citygml.appearance.AbstractSurfaceData;
import org.citygml4j.model.citygml.appearance.AbstractTextureParameterization;
import org.citygml4j.model.citygml.appearance.Appearance;
import org.citygml4j.model.citygml.appearance.AppearanceMember;
import org.citygml4j.model.citygml.appearance.AppearanceProperty;
import org.citygml4j.model.citygml.appearance.Color;
import org.citygml4j.model.citygml.appearance.ColorPlusOpacity;
import org.citygml4j.model.citygml.appearance.GeoreferencedTexture;
import org.citygml4j.model.citygml.appearance.ParameterizedTexture;
import org.citygml4j.model.citygml.appearance.SurfaceDataProperty;
import org.citygml4j.model.citygml.appearance.TexCoordGen;
import org.citygml4j.model.citygml.appearance.TexCoordList;
import org.citygml4j.model.citygml.appearance.TextureAssociation;
import org.citygml4j.model.citygml.appearance.TextureCoordinates;
import org.citygml4j.model.citygml.appearance.TextureType;
import org.citygml4j.model.citygml.appearance.WorldToTexture;
import org.citygml4j.model.citygml.appearance.WrapMode;
import org.citygml4j.model.citygml.appearance.X3DMaterial;

public class AppearanceFactory {

	public AppearanceFactory() {
		
	}

	public Appearance createAppearance() {
		return new AppearanceImpl();
	}

	public AppearanceMember createAppearanceMember() {
		return new AppearanceMemberImpl();
	}
	
	public AppearanceMember createAppearanceMember(Appearance appearance) {
		AppearanceMember appearanceMember = new AppearanceMemberImpl();
		appearanceMember.setAppearance(appearance);
		return appearanceMember;
	}
	
	public AppearanceMember createAppearanceMember(String xlink) {
		AppearanceMember appearanceMember = new AppearanceMemberImpl();
		appearanceMember.setHref(xlink);
		return appearanceMember;
	}

	public AppearanceProperty createAppearanceProperty() {
		return new AppearancePropertyImpl();
	}
	
	public AppearanceProperty createAppearanceProperty(Appearance appearance) {
		AppearanceProperty appearanceProperty = new AppearancePropertyImpl();
		appearanceProperty.setAppearance(appearance);
		return appearanceProperty;
	}
	
	public AppearanceProperty createAppearanceProperty(String xlink) {
		AppearanceProperty appearanceProperty = new AppearancePropertyImpl();
		appearanceProperty.setHref(xlink);
		return appearanceProperty;
	}

	public Color createColor() {
		return new ColorImpl();
	}

	public Color createColor(Double red, Double green, Double blue) {
		return new ColorImpl(red, green, blue);
	}

	public ColorPlusOpacity createColorPlusOpacity() {
		return new ColorPlusOpacityImpl();
	}

	public ColorPlusOpacity createColorPlusOpacity(Color color, Double opacity) {
		return new ColorPlusOpacityImpl(color, opacity);
	}

	public ColorPlusOpacity createColorPlusOpacity(Double red, Double green, Double blue, Double opacity) {
		return new ColorPlusOpacityImpl(red, green, blue, opacity);
	}

	public ColorPlusOpacity createColorPlusOpacity(Double red, Double green, Double blue) {
		return new ColorPlusOpacityImpl(red, green, blue);
	}

	public ColorPlusOpacity createColorPlusOpacity(Double defaultColorValue, Double opacity) {
		return new ColorPlusOpacityImpl(defaultColorValue, opacity);
	}

	public ColorPlusOpacity createColorPlusOpacity(Double defaultColorValue) {
		return new ColorPlusOpacityImpl(defaultColorValue);
	}

	public GeoreferencedTexture createGeoreferencedTexture() {
		return new GeoreferencedTextureImpl();
	}

	public ParameterizedTexture createParameterizedTexture() {
		return new ParameterizedTextureImpl();
	}

	public SurfaceDataProperty createSurfaceDataProperty() {
		return new SurfaceDataPropertyImpl();
	}
	
	public SurfaceDataProperty createSurfaceDataProperty(AbstractSurfaceData abstractSurfaceData) {
		SurfaceDataProperty surfaceDataProperty = new SurfaceDataPropertyImpl();
		surfaceDataProperty.setSurfaceData(abstractSurfaceData);
		return surfaceDataProperty;
	}
	
	public SurfaceDataProperty createSurfaceDataProperty(String xlink) {
		SurfaceDataProperty surfaceDataProperty = new SurfaceDataPropertyImpl();
		surfaceDataProperty.setHref(xlink);
		return surfaceDataProperty;
	}

	public TexCoordGen createTexCoordGen() {
		return new TexCoordGenImpl();
	}

	public TexCoordList createTexCoordList() {
		return new TexCoordListImpl();
	}

	public TextureAssociation createTextureAssociation() {
		return new TextureAssociationImpl();
	}
	
	public TextureAssociation createTextureAssociation(AbstractTextureParameterization textureParameterization) {
		TextureAssociation textureAssociation = new TextureAssociationImpl();
		textureAssociation.setTextureParameterization(textureParameterization);
		return textureAssociation;
	}
	
	public TextureAssociation createTextureAssociation(String xlink) {
		TextureAssociation textureAssociation = new TextureAssociationImpl();
		textureAssociation.setHref(xlink);
		return textureAssociation;
	}

	public TextureCoordinates createTextureCoordinates() {
		return new TextureCoordinatesImpl();
	}
	
	public TextureType createTextureType(String textureType) {
		return TextureType.fromValue(textureType);
	}

	public WorldToTexture createWorldToTexture() {
		return new WorldToTextureImpl();
	}
	
	public WrapMode createWrapMode(String wrapMode) {
		return WrapMode.fromValue(wrapMode);
	}

	public X3DMaterial createX3DMaterial() {
		return new X3DMaterialImpl();
	}
	
}
