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
package org.citygml4j.model.citygml.appearance;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.module.citygml.AppearanceModule;

import java.util.List;

public class TexCoordGen extends AbstractTextureParameterization {
	private WorldToTexture worldToTexture;
	private List<ADEComponent> ade;
	
	public TexCoordGen() {
		
	}
	
	public TexCoordGen(AppearanceModule module) {
		super(module);
	}
	
	public void addGenericApplicationPropertyOfTexCoordGen(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfTexCoordGen() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public WorldToTexture getWorldToTexture() {
		return worldToTexture;
	}

	public boolean isSetGenericApplicationPropertyOfTexCoordGen() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetWorldToTexture() {
		return worldToTexture != null;
	}

	public void setGenericApplicationPropertyOfTexCoordGen(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void setWorldToTexture(WorldToTexture worldToTexture) {
		if (worldToTexture != null)
			worldToTexture.setParent(this);
		
		this.worldToTexture = worldToTexture;
	}

	public void unsetGenericApplicationPropertyOfTexCoordGen() {
		if (isSetGenericApplicationPropertyOfTexCoordGen())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfTexCoordGen(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfTexCoordGen() ? this.ade.remove(ade) : false;
	}

	public void unsetWorldToTexture() {
		if (isSetWorldToTexture())
			worldToTexture.unsetParent();
		
		worldToTexture = null;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TEX_COORD_GEN;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new TexCoordGen(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		TexCoordGen copy = (target == null) ? new TexCoordGen() : (TexCoordGen)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetWorldToTexture()) {
			copy.setWorldToTexture((WorldToTexture)copyBuilder.copy(worldToTexture));
			if (copy.getWorldToTexture() == worldToTexture)
				worldToTexture.setParent(this);
		}

		if (isSetGenericApplicationPropertyOfTexCoordGen()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfTexCoordGen(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		return copy;
	}
	
	public void accept(GMLVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T accept(GMLFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
