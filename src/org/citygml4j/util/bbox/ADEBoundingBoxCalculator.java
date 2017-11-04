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
package org.citygml4j.util.bbox;

import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.citygml.appearance.Appearance;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.util.child.ChildInfo;
import org.citygml4j.util.walker.FeatureWalker;

public class ADEBoundingBoxCalculator {
	private final AbstractFeature feature;
	private final BoundingBoxOptions options;
	private final ADEFeatureWalker walker;
	private final ChildInfo info;

	public ADEBoundingBoxCalculator(AbstractFeature feature, BoundingBoxOptions options) {
		this.feature = feature;
		this.options = options;
		
		walker = new ADEFeatureWalker();
		info = new ChildInfo();
	}

	public BoundingShape calcBoundedBy(ADEModelObject ade) {
		walker.boundedBy = new BoundingShape();
		walker.visit((ADEModelObject)ade);
		walker.reset();

		return walker.boundedBy;
	}

	private class ADEFeatureWalker extends FeatureWalker {
		private BoundingShape boundedBy;

		@Override
		public void visit(AbstractFeature nested) {
			// skip grandchild features
			if (info.getParentFeature(nested) != feature)
				return;

			boundedBy.updateEnvelope(nested.calcBoundedBy(options).getEnvelope());
		}

		@Override
		public void visit(Appearance appearance) {
			// skip appearances
		}
	}

}
