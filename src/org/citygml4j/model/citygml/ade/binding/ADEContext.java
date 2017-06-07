package org.citygml4j.model.citygml.ade.binding;

import java.util.List;

import org.citygml4j.model.module.ade.ADEModule;
import org.citygml4j.util.walker.FeatureFunctionWalker;
import org.citygml4j.util.walker.FeatureWalker;
import org.citygml4j.util.walker.GMLFunctionWalker;
import org.citygml4j.util.walker.GMLWalker;

public interface ADEContext {
	public List<ADEModule> getADEModules();
	public List<String> getModelPackageNames();	
	public List<String> getJAXBPackageNames();	
	public ADEMarshaller getADEMarshaller();
	public ADEUnmarshaller getADEUnmarshaller();

	default ADEWalker<FeatureWalker> getDefaultFeatureWalker() {
		return null;
	}
	
	default ADEWalker<GMLWalker> getDefaultGMLWalker() {
		return null;
	}
	
	default <T> ADEWalker<FeatureFunctionWalker<T>> getDefaultFeatureFunctionWalker() {
		return null;
	}
	
	default <T> ADEWalker<GMLFunctionWalker<T>> getDefaultGMLFunctionWalker() {
		return null;
	}
}