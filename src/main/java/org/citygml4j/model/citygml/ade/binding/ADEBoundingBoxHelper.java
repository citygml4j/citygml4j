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
package org.citygml4j.model.citygml.ade.binding;

import org.citygml4j.model.citygml.appearance.Appearance;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.util.bbox.BoundingBoxOptions;
import org.citygml4j.util.child.ChildInfo;
import org.citygml4j.util.walker.FeatureWalker;

public class ADEBoundingBoxHelper {
	
	public static BoundingShape calcBoundedBy(ADEModelObject ade, AbstractFeature parent, BoundingBoxOptions options) {
		ChildInfo info = new ChildInfo();
		BoundingShape boundedBy = new BoundingShape();
		
		FeatureWalker walker = new FeatureWalker() {
			
			@Override
			public void visit(AbstractFeature nested) {
				// skip grandchildren
				if (info.getParentFeature(nested) != parent)
					return;

				boundedBy.updateEnvelope(nested.calcBoundedBy(options).getEnvelope());
			}

			@Override
			public void visit(Appearance appearance) {
				// skip appearances
			}
		};
		
		walker.visit((ADEModelObject)ade);
		
		return boundedBy;
	}

}
