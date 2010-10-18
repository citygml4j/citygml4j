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
package org.citygml4j.impl.citygml.appearance;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.base.AssociationByRepOrRefImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.appearance.AbstractTextureParameterization;
import org.citygml4j.model.citygml.appearance.TextureAssociation;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.module.citygml.AppearanceModule;

public class TextureAssociationImpl extends AssociationByRepOrRefImpl<AbstractTextureParameterization> implements TextureAssociation {
	private String uri;
	private AppearanceModule module;
	
	public TextureAssociationImpl() {
		
	}
	
	public TextureAssociationImpl(AppearanceModule module) {
		this.module = module;
	}
	
	public AbstractTextureParameterization getTextureParameterization() {
		return super.getObject();
	}

	public String getUri() {
		return uri;
	}

	public boolean isSetTextureParameterization() {
		return super.isSetObject();
	}

	public boolean isSetUri() {
		return uri != null;
	}

	public void setTextureParameterization(AbstractTextureParameterization textureParameterization) {
		super.setObject(textureParameterization);
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public void unsetTextureParameterization() {
		super.unsetObject();
	}

	public void unsetUri() {
		uri = null;
	}

	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TEXTURE_ASSOCIATION;
	}

	public final AppearanceModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new TextureAssociationImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		TextureAssociation copy = (target == null) ? new TextureAssociationImpl() : (TextureAssociation)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetUri())
			copy.setUri(copyBuilder.copy(uri));
		
		return copy;
	}

}
