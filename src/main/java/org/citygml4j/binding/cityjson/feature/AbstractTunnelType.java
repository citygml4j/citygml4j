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

public abstract class AbstractTunnelType extends AbstractCityObjectType {

	public AbstractTunnelType() {
	}
	
	public AbstractTunnelType(String gmlId) {
		super(gmlId);
	}
	
	@Override
	public TunnelAttributes newAttributes() {
		return super.newAttributes(new TunnelAttributes());
	}

	@Override
	public TunnelAttributes getAttributes() {
		return (TunnelAttributes) attributes;
	}

	@Override
	public boolean isValidGeometryType(GeometryTypeName type) {
		return type == GeometryTypeName.MULTI_SURFACE
				|| type == GeometryTypeName.SOLID
				|| type == GeometryTypeName.COMPOSITE_SOLID;
	}
}
