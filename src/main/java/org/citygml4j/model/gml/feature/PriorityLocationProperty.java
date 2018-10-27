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
package org.citygml4j.model.gml.feature;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.AbstractGeometry;

public class PriorityLocationProperty extends LocationProperty {
	private String priority;
	
	public PriorityLocationProperty() {

	}

	public PriorityLocationProperty(AbstractGeometry abstractGeometry) {
		super(abstractGeometry);
	}

	public PriorityLocationProperty(String href) {
		super(href);
	}
	
	public String getPriority() {
		return priority;
	}

	public boolean isSetPriority() {
		return priority != null;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public void unsetPriority() {
		priority = null;
	}

	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new PriorityLocationProperty(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		PriorityLocationProperty copy = (target == null) ? new PriorityLocationProperty() : (PriorityLocationProperty)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetPriority())
			copy.setPriority(copyBuilder.copy(priority));
		
		return copy;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.PRIORITY_LOCATION_PROPERTY;
	}

}
