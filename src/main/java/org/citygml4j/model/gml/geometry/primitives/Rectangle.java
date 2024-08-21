/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2024 Claus Nagel <claus.nagel@gmail.com>
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
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelObjects;
import org.citygml4j.model.gml.GMLClass;

public class Rectangle extends AbstractSurfacePatch {
	private AbstractRingProperty exterior;
	private ModelObject parent;
	
	public AbstractRingProperty getExterior() {
		return exterior;
	}

	public SurfaceInterpolation getInterpolation() {
		return SurfaceInterpolation.PLANAR;
	}

	public boolean isSetExterior() {
		return exterior != null;
	}

	public void setExterior(AbstractRingProperty exterior) {
		this.exterior = ModelObjects.setParent(exterior, this);
	}

	public void unsetExterior() {
		exterior = ModelObjects.setNull(exterior);
	}

	public BoundingBox calcBoundingBox() {
		BoundingBox bbox = new BoundingBox();
		
		if (isSetExterior() && exterior.isSetRing()) 
			bbox.update(exterior.getRing().calcBoundingBox());
		
		return bbox;
	}

	public GMLClass getGMLClass() {
		return GMLClass.RECTANGLE;
	}

	public ModelObject getParent() {
		return parent;
	}

	public void setParent(ModelObject parent) {
		this.parent = parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void unsetParent() {
		parent = null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new Rectangle(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Rectangle copy = (target == null) ? new Rectangle() : (Rectangle)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetExterior()) {
			copy.setExterior((AbstractRingProperty)copyBuilder.copy(exterior));
			if (copy.getExterior() == exterior)
				exterior.setParent(this);
		}
		
		return copy;
	}

}
