package org.citygml4j.util.bbox;

import org.citygml4j.model.citygml.appearance.Appearance;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.util.child.ChildInfo;
import org.citygml4j.util.walker.GMLWalker;

public class SimpleBoundingBoxCalculator {

	public static BoundingShape calcBoundedBy(AbstractFeature feature, BoundingBoxOptions options) {
		if (options.isUseExistingEnvelopes() && feature.isSetBoundedBy() && !feature.getBoundedBy().isEmpty())
			return feature.getBoundedBy();
		
		ChildInfo info = new ChildInfo();
		BoundingShape boundedBy = new BoundingShape();
		
		feature.accept(new GMLWalker() {

			@Override
			public void visit(AbstractGeometry geometry) {
				if (!options.isAssignResultToFeatures() || info.getParentFeature(geometry) == feature)
					boundedBy.updateEnvelope(geometry.calcBoundingBox());
			}

			@Override
			public void visit(AbstractFeature nested) {
				if (nested != feature && options.isAssignResultToFeatures()) {
					BoundingShape tmp = SimpleBoundingBoxCalculator.calcBoundedBy(nested, options);
					boundedBy.updateEnvelope(tmp.getEnvelope());
					nested.setBoundedBy(tmp);
				}
			}

			@Override
			public void visit(Appearance appearance) {
				// skip appearance
			}
			
		});
		
		if (options.isAssignResultToFeatures())
			feature.setBoundedBy(boundedBy);
		
		return boundedBy;
	}
	
}
