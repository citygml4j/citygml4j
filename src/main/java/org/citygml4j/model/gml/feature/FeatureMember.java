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
