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
		return new Appearance();
	}

	public AppearanceMember createAppearanceMember() {
		return new AppearanceMember();
	}
	
	public AppearanceMember createAppearanceMember(Appearance appearance) {
		AppearanceMember appearanceMember = new AppearanceMember();
		appearanceMember.setAppearance(appearance);
		return appearanceMember;
	}
	
	public AppearanceMember createAppearanceMember(String xlink) {
		AppearanceMember appearanceMember = new AppearanceMember();
		appearanceMember.setHref(xlink);
		return appearanceMember;
	}

	public AppearanceProperty createAppearanceProperty() {
		return new AppearanceProperty();
	}
	
	public AppearanceProperty createAppearanceProperty(Appearance appearance) {
		AppearanceProperty appearanceProperty = new AppearanceProperty();
		appearanceProperty.setAppearance(appearance);
		return appearanceProperty;
	}
	
	public AppearanceProperty createAppearanceProperty(String xlink) {
		AppearanceProperty appearanceProperty = new AppearanceProperty();
		appearanceProperty.setHref(xlink);
		return appearanceProperty;
	}

	public Color createColor() {
		return new Color();
	}

	public Color createColor(Double red, Double green, Double blue) {
		return new Color(red, green, blue);
	}

	public ColorPlusOpacity createColorPlusOpacity() {
		return new ColorPlusOpacity();
	}

	public ColorPlusOpacity createColorPlusOpacity(Color color, Double opacity) {
		return new ColorPlusOpacity(color, opacity);
	}

	public ColorPlusOpacity createColorPlusOpacity(Double red, Double green, Double blue, Double opacity) {
		return new ColorPlusOpacity(red, green, blue, opacity);
	}

	public ColorPlusOpacity createColorPlusOpacity(Double red, Double green, Double blue) {
		return new ColorPlusOpacity(red, green, blue);
	}

	public ColorPlusOpacity createColorPlusOpacity(Double defaultColorValue, Double opacity) {
		return new ColorPlusOpacity(defaultColorValue, opacity);
	}

	public ColorPlusOpacity createColorPlusOpacity(Double defaultColorValue) {
		return new ColorPlusOpacity(defaultColorValue);
	}

	public GeoreferencedTexture createGeoreferencedTexture() {
		return new GeoreferencedTexture();
	}

	public ParameterizedTexture createParameterizedTexture() {
		return new ParameterizedTexture();
	}

	public SurfaceDataProperty createSurfaceDataProperty() {
		return new SurfaceDataProperty();
	}
	
	public SurfaceDataProperty createSurfaceDataProperty(AbstractSurfaceData abstractSurfaceData) {
		SurfaceDataProperty surfaceDataProperty = new SurfaceDataProperty();
		surfaceDataProperty.setSurfaceData(abstractSurfaceData);
		return surfaceDataProperty;
	}
	
	public SurfaceDataProperty createSurfaceDataProperty(String xlink) {
		SurfaceDataProperty surfaceDataProperty = new SurfaceDataProperty();
		surfaceDataProperty.setHref(xlink);
		return surfaceDataProperty;
	}

	public TexCoordGen createTexCoordGen() {
		return new TexCoordGen();
	}

	public TexCoordList createTexCoordList() {
		return new TexCoordList();
	}

	public TextureAssociation createTextureAssociation() {
		return new TextureAssociation();
	}
	
	public TextureAssociation createTextureAssociation(AbstractTextureParameterization textureParameterization) {
		TextureAssociation textureAssociation = new TextureAssociation();
		textureAssociation.setTextureParameterization(textureParameterization);
		return textureAssociation;
	}
	
	public TextureAssociation createTextureAssociation(String xlink) {
		TextureAssociation textureAssociation = new TextureAssociation();
		textureAssociation.setHref(xlink);
		return textureAssociation;
	}

	public TextureCoordinates createTextureCoordinates() {
		return new TextureCoordinates();
	}
	
	public TextureType createTextureType(String textureType) {
		return TextureType.fromValue(textureType);
	}

	public WorldToTexture createWorldToTexture() {
		return new WorldToTexture();
	}
	
	public WrapMode createWrapMode(String wrapMode) {
		return WrapMode.fromValue(wrapMode);
	}

	public X3DMaterial createX3DMaterial() {
		return new X3DMaterial();
	}
	
}
