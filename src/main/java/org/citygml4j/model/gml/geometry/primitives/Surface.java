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
package org.citygml4j.model.gml.geometry.primitives;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.common.visitor.GeometryFunctor;
import org.citygml4j.model.common.visitor.GeometryVisitor;
import org.citygml4j.model.gml.GMLClass;

public class Surface extends AbstractSurface {
	private SurfacePatchArrayProperty patches;
	
	public SurfacePatchArrayProperty getPatches() {
		return patches;
	}

	public boolean isSetPatches() {
		return patches != null;
	}

	public void setPatches(SurfacePatchArrayProperty patches) {
		if (patches != null)
			patches.setParent(this);
		
		this.patches = patches;
	}

	public void unsetPatches() {
		if (isSetPatches())
			patches.unsetParent();
		
		patches = null;
	}

	public BoundingBox calcBoundingBox() {
		BoundingBox bbox = new BoundingBox();
		
		if (getPatches() != null) {
			SurfacePatchArrayProperty arrayProperty = getPatches();
			
			if (arrayProperty.isSetSurfacePatch())
				for (AbstractSurfacePatch surfacePatch : arrayProperty.getSurfacePatch())
					bbox.update(surfacePatch.calcBoundingBox());
		}
		
		return bbox;
	}

	public GMLClass getGMLClass() {
		return GMLClass.SURFACE;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new Surface(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Surface copy = (target == null) ? new Surface() : (Surface)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetPatches()) {
			copy.setPatches((SurfacePatchArrayProperty)copyBuilder.copy(patches));
			if (copy.getPatches() == patches)
				patches.setParent(this);
		}
		
		return copy;
	}
	
	public void accept(GeometryVisitor visitor) {
		visitor.visit(this);
	}

	public <T> T accept(GeometryFunctor<T> visitor) {
		return visitor.apply(this);
	}
	
	public void accept(GMLVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T accept(GMLFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
