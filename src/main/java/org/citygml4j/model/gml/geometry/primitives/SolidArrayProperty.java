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
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.GeometryArrayProperty;

import java.util.List;

public class SolidArrayProperty extends GeometryArrayProperty<AbstractSolid> {

	public SolidArrayProperty() {

	}

	public SolidArrayProperty(AbstractSolid abstractSolid) {
		super(abstractSolid);
	}

	public SolidArrayProperty(List<AbstractSolid> abstractSolid) {
		super(abstractSolid);
	}
	
	public SolidArrayProperty(AbstractSolid... abstractSolid) {
		super(abstractSolid);
	}
	
	public void addSolid(AbstractSolid abstractSolid) {
		super.addGeometry(abstractSolid);
	}

	public List<? extends AbstractSolid> getSolid() {
		return super.getGeometry();
	}

	public boolean isSetSolid() {
		return super.isSetGeometry();
	}

	@SuppressWarnings("unchecked")
	public void setSolid(List<? extends AbstractSolid> abstractSolid) {
		super.setGeometry((List<AbstractSolid>)abstractSolid);
	}

	public void unsetSolid() {
		super.unsetGeometry();
	}

	public boolean unsetSolid(AbstractSolid abstractSolid) {
		return super.unsetGeometry(abstractSolid);
	}

	public GMLClass getGMLClass() {
		return GMLClass.SOLID_ARRAY_PROPERTY;
	}

	public Class<AbstractSolid> getAssociableClass() {
		return AbstractSolid.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new SolidArrayProperty(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		SolidArrayProperty copy = (target == null) ? new SolidArrayProperty() : (SolidArrayProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
