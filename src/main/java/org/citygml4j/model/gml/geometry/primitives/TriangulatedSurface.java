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
import org.citygml4j.model.common.visitor.GeometryFunctor;
import org.citygml4j.model.common.visitor.GeometryVisitor;
import org.citygml4j.model.gml.GMLClass;

public class TriangulatedSurface extends Surface {

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.TRIANGULATED_SURFACE;
	}

	public TrianglePatchArrayProperty getTrianglePatches() {
		return getPatches();
	}

	public boolean isSetTrianglePatches() {
		return super.isSetPatches();
	}

	public void setTrianglePatches(TrianglePatchArrayProperty trianglePatches) {
		super.setPatches(trianglePatches);
	}

	public void unsetTrianglePatches() {
		super.unsetPatches();
	}
	
	@Override
	public TrianglePatchArrayProperty getPatches() {
		return (TrianglePatchArrayProperty)super.getPatches();
	}

	@Override
	public void setPatches(SurfacePatchArrayProperty patches) {
		if (patches instanceof TrianglePatchArrayProperty)
			super.setPatches(patches);
	}

	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new TriangulatedSurface(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		TriangulatedSurface copy = (target == null) ? new TriangulatedSurface() : (TriangulatedSurface)target;
		return super.copyTo(copy, copyBuilder);
	}
	
	public void accept(GeometryVisitor visitor) {
		visitor.visit(this);
	}

	public <T> T accept(GeometryFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
