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
package org.citygml4j.model.gml.coverage;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.base.AssociationByRepOrRef;
import org.citygml4j.model.gml.valueObjects.ValueObject;

public class RangeParameters extends AssociationByRepOrRef<ValueObject> {
	
	public RangeParameters() {
		
	}
	
	public RangeParameters(ValueObject valueObject) {
		super(valueObject);
	}
	
	public RangeParameters(String href) {
		super(href);
	}
	
	public ValueObject getValueObject() {
		return super.getObject();
	}

	public boolean isSetValueObject() {
		return super.isSetObject();
	}

	public void setValueObject(ValueObject valueObject) {
		super.setObject(valueObject);
	}

	public void unsetValueObject() {
		super.unsetObject();
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.RANGE_PARAMETERS;
	}

	public Class<ValueObject> getAssociableClass() {
		return ValueObject.class;
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		RangeParameters copy = (target == null) ? new RangeParameters() : (RangeParameters)target;
		return super.copyTo(copy, copyBuilder);
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new RangeParameters(), copyBuilder);
	}

}
