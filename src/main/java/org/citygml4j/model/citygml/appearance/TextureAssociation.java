/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml4j.model.citygml.appearance;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.gml.base.AssociationByRepOrRef;
import org.citygml4j.model.module.citygml.AppearanceModule;

public class TextureAssociation extends AssociationByRepOrRef<AbstractTextureParameterization> implements AppearanceModuleComponent {
	private String uri;
	private AppearanceModule module;
	
	public TextureAssociation() {
		
	}
	
	public TextureAssociation(AbstractTextureParameterization abstractTextureParameterization) {
		super(abstractTextureParameterization);
	}
	
	public TextureAssociation(String href) {
		super(href);
	}
	
	public TextureAssociation(AppearanceModule module) {
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

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TEXTURE_ASSOCIATION;
	}

	public final AppearanceModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	public Class<AbstractTextureParameterization> getAssociableClass() {
		return AbstractTextureParameterization.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new TextureAssociation(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		TextureAssociation copy = (target == null) ? new TextureAssociation() : (TextureAssociation)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetUri())
			copy.setUri(copyBuilder.copy(uri));
		
		return copy;
	}

}
