/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universitaet Berlin, Germany
 * http://www.igg.tu-berlin.de/
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package org.citygml4j.model.gml.feature;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.gml.GMLClass;

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
