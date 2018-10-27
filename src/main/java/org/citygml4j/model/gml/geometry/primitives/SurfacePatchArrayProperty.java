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
package org.citygml4j.model.gml.geometry.primitives;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.base.ArrayAssociation;

import java.util.List;

public class SurfacePatchArrayProperty extends ArrayAssociation<AbstractSurfacePatch> {
	
	public SurfacePatchArrayProperty() {

	}

	public SurfacePatchArrayProperty(AbstractSurfacePatch abstractSurfacePatch) {
		super(abstractSurfacePatch);
	}

	@SuppressWarnings("unchecked")
	public SurfacePatchArrayProperty(List<? extends AbstractSurfacePatch> abstractSurfacePatch) {
		super((List<AbstractSurfacePatch>)abstractSurfacePatch);
	}
	
	public SurfacePatchArrayProperty(AbstractSurfacePatch... abstractSurfacePatch) {
		super(abstractSurfacePatch);
	}
	
	public void addSurfacePatch(AbstractSurfacePatch surfacePatch) {
		super.addObject(surfacePatch);
	}

	public List<? extends AbstractSurfacePatch> getSurfacePatch() {
		return super.getObject();
	}

	public boolean isSetSurfacePatch() {
		return super.isSetObject();
	}

	@SuppressWarnings("unchecked")
	public void setSurfacePatch(List<? extends AbstractSurfacePatch> surfacePatch) {
		super.setObject((List<AbstractSurfacePatch>)surfacePatch);
	}

	public void unsetSurfacePatch() {
		super.unsetObject();
	}

	public boolean unsetSurfacePatch(AbstractSurfacePatch surfacePatch) {
		return super.unsetObject(surfacePatch);
	}

	public GMLClass getGMLClass() {
		return GMLClass.SURFACE_ARRAY_PROPERTY;
	}

	public Class<AbstractSurfacePatch> getAssociableClass() {
		return AbstractSurfacePatch.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new SurfacePatchArrayProperty(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		SurfacePatchArrayProperty copy = (target == null) ? new SurfacePatchArrayProperty() : (SurfacePatchArrayProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
