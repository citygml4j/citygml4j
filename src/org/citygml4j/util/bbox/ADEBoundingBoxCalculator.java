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
		walker.useADEContexts(options.getADEContexts());

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
