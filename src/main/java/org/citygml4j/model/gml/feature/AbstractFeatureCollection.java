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
package org.citygml4j.model.gml.feature;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.gml.GMLClass;

import java.util.List;

public abstract class AbstractFeatureCollection extends AbstractFeature {
	private List<FeatureMember> featureMember;
	private FeatureArrayProperty featureMembers;
	
	public void addFeatureMember(FeatureMember featureMember) {
		if (this.featureMember == null)
			this.featureMember = new ChildList<FeatureMember>(this);
		
		this.featureMember.add(featureMember);
	}

	public List<FeatureMember> getFeatureMember() {
		if (featureMember == null)
			featureMember = new ChildList<FeatureMember>(this);
		
		return featureMember;
	}

	public FeatureArrayProperty getFeatureMembers() {
		return featureMembers;
	}
	
	public boolean isSetFeatureMember() {
		return featureMember != null && !featureMember.isEmpty();
	}

	public boolean isSetFeatureMembers() {
		return featureMembers != null;
	}

	public void setFeatureMember(List<FeatureMember> featureMember) {
		this.featureMember = new ChildList<FeatureMember>(this, featureMember);
	}

	public void setFeatureMembers(FeatureArrayProperty featureMembers) {
		if (featureMembers != null)
			featureMembers.setParent(this);
		
		this.featureMembers = featureMembers;
	}

	public void unsetFeatureMember() {
		if (isSetFeatureMember())
			featureMember.clear();
		
		featureMember = null;
	}

	public boolean unsetFeatureMember(FeatureMember featureMember) {
		return isSetFeatureMember() ? this.featureMember.remove(featureMember) : false;
	}

	public void unsetFeatureMembers() {
		if (isSetFeatureMembers())
			featureMembers.unsetParent();
		
		featureMembers = null;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.ABSTRACT_FEATURE_COLLECTION;
	}
	
	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
			throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		AbstractFeatureCollection copy = (AbstractFeatureCollection)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetFeatureMember()) {
			for (FeatureMember part : featureMember) {
				FeatureMember copyPart = (FeatureMember)copyBuilder.copy(part);
				copy.addFeatureMember(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetFeatureMembers()) {
			copy.setFeatureMembers((FeatureArrayProperty)copyBuilder.copy(featureMembers));
			if (copy.getFeatureMembers() == featureMembers)
				featureMembers.setParent(this);
		}
		
		return copy;
	}

}
