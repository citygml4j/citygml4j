package org.citygml4j.util.bbox;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.model.citygml.ade.binding.ADEContext;

public class BoundingBoxOptions {
	private boolean assignResultToFeatures;
	private boolean useExistingEnvelopes;
	private List<ADEContext> adeContexts = new ArrayList<>();
	
	private BoundingBoxOptions() {
		// just to thwart instantiation
	}
	
	public static synchronized BoundingBoxOptions defaults() {
		return new BoundingBoxOptions();
	}

	public boolean isAssignResultToFeatures() {
		return assignResultToFeatures;
	}

	public BoundingBoxOptions assignResultToFeatures(boolean assignResultToFeatures) {
		this.assignResultToFeatures = assignResultToFeatures;
		return this;
	}
	
	public boolean isUseExistingEnvelopes() {
		return useExistingEnvelopes;
	}

	public BoundingBoxOptions useExistingEnvelopes(boolean useExistingEnvelopes) {
		this.useExistingEnvelopes = useExistingEnvelopes;
		return this;
	}

	public BoundingBoxOptions useADEContext(ADEContext context) {
		adeContexts.add(context);
		return this;
	}

	public BoundingBoxOptions useADEContexts(List<ADEContext> contexts) {
		adeContexts.addAll(contexts);
		return this;
	}
	
	public List<ADEContext> getADEContexts() {
		return adeContexts;
	}
	
	public boolean hasADEContexts() {
		return !adeContexts.isEmpty();
	}
	
}
