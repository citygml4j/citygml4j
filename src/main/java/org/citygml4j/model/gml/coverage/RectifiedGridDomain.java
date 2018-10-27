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
import org.citygml4j.model.gml.grids.RectifiedGrid;

public class RectifiedGridDomain extends DomainSet<RectifiedGrid> {

	public RectifiedGridDomain() {

	}

	public RectifiedGridDomain(RectifiedGrid rectifiedGrid) {
		super(rectifiedGrid);
	}

	public RectifiedGridDomain(String href) {
		super(href);
	}
	
	public RectifiedGrid getRectifiedGrid() {
		return super.getGeometry();
	}

	public boolean isSetRectifiedGrid() {
		return super.isSetGeometry();
	}

	public void setRectifiedGrid(RectifiedGrid rectifiedGrid) {
		setObject(rectifiedGrid);
	}

	public void unsetRectifiedGrid() {
		super.unsetGeometry();
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.RECTIFIED_GRID_DOMAIN;
	}

	@Override
	public Class<RectifiedGrid> getAssociableClass() {
		return RectifiedGrid.class;
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		RectifiedGridDomain copy = (target == null) ? new RectifiedGridDomain() : (RectifiedGridDomain)target;
		return super.copyTo(copy, copyBuilder);
	}

	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new RectifiedGridDomain(), copyBuilder);
	}

}
