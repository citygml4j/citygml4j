/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2022 Claus Nagel <claus.nagel@gmail.com>
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
import org.citygml4j.model.gml.GMLClass;

import java.util.List;

public class PolygonPatchArrayProperty extends SurfacePatchArrayProperty {

	public PolygonPatchArrayProperty() {

	}

	public PolygonPatchArrayProperty(PolygonPatch polygonPatch) {
		super(polygonPatch);
	}

	public PolygonPatchArrayProperty(List<PolygonPatch> polygonPatch) {
		super(polygonPatch);
	}

	public PolygonPatchArrayProperty(PolygonPatch... polygonPatch) {
		super(polygonPatch);
	}
	
	@Override
	public GMLClass getGMLClass() {
		return GMLClass.POLYGON_PATCH_ARRAY_PROPERTY;
	}

	@Override
	public void addSurfacePatch(AbstractSurfacePatch surfacePatch) {
		if (surfacePatch instanceof PolygonPatch)
			super.addSurfacePatch(surfacePatch);
	}

	public void addPolygonPatch(PolygonPatch polygonPatch) {
		super.addSurfacePatch(polygonPatch);
	}

	@SuppressWarnings("unchecked")
	public List<PolygonPatch> getPolygonPatch() {
		return (List<PolygonPatch>)super.getSurfacePatch();
	}

	public boolean isSetPolygonPatch() {
		return super.isSetSurfacePatch();
	}

	public void setPolygonPatch(List<PolygonPatch> polygonPatch) {
		super.setSurfacePatch(polygonPatch);
	}

	public void unsetPolygonPatch() {
		super.unsetSurfacePatch();
	}

	public boolean unsetPolygonPatch(PolygonPatch polygonPatch) {
		return super.unsetSurfacePatch(polygonPatch);
	}
	
	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		PolygonPatchArrayProperty copy = (target == null) ? new PolygonPatchArrayProperty() : (PolygonPatchArrayProperty)target;
		return super.copyTo(copy, copyBuilder);
	}
	
	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new PolygonPatchArrayProperty(), copyBuilder);
	}

}
