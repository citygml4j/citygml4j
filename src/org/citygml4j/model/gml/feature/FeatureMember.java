/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright (C) 2013 - 2015,
 * Claus Nagel <claus.nagel@gmail.com>
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 */
package org.citygml4j.model.gml.feature;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;

public class FeatureMember extends FeatureProperty<AbstractFeature> {

	public FeatureMember() {
		
	}
	
	public FeatureMember(AbstractFeature abstractFeature) {
		super(abstractFeature);
	}
	
	public FeatureMember(String href) {
		super(href);
	}
	
	@Override
	public GMLClass getGMLClass() {
		return GMLClass.FEATURE_MEMBER;
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		FeatureMember copy = (target == null) ? new FeatureMember() : (FeatureMember)target;
		return super.copyTo(copy, copyBuilder);
	}

	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new FeatureMember(), copyBuilder);
	}

}
