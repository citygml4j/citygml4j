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
package org.citygml4j.binding.cityjson.feature;

import org.citygml4j.binding.cityjson.geometry.GeometryTypeName;

public abstract class AbstractTransportationComplexType extends AbstractCityObjectType {

	public AbstractTransportationComplexType() {
	}

	public AbstractTransportationComplexType(String gmlId) {
		super(gmlId);
	}
	
	@Override
	public TransportationComplexAttributes newAttributes() {
		return super.newAttributes(new TransportationComplexAttributes());
	}

	@Override
	public TransportationComplexAttributes getAttributes() {
		return (TransportationComplexAttributes) super.getAttributes();
	}
	
	@Override
	public boolean isValidGeometryType(GeometryTypeName type) {
		return type == GeometryTypeName.MULTI_LINE_STRING
				|| type == GeometryTypeName.MULTI_SURFACE
				|| type == GeometryTypeName.COMPOSITE_SURFACE;
	}
}
