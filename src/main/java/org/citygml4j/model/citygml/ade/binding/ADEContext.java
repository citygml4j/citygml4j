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
package org.citygml4j.model.citygml.ade.binding;

import org.citygml4j.model.module.ade.ADEModule;
import org.citygml4j.util.walker.FeatureFunctionWalker;
import org.citygml4j.util.walker.FeatureWalker;
import org.citygml4j.util.walker.GMLFunctionWalker;
import org.citygml4j.util.walker.GMLWalker;

import java.util.List;

public interface ADEContext {
	public List<ADEModule> getADEModules();
	public List<String> getModelPackageNames();	
	public List<String> getJAXBPackageNames();	
	public ADEMarshaller getADEMarshaller();
	public ADEUnmarshaller getADEUnmarshaller();

	default ADEWalker<FeatureWalker> createDefaultFeatureWalker() {
		return null;
	}
	
	default ADEWalker<GMLWalker> createDefaultGMLWalker() {
		return null;
	}
	
	default <T> ADEWalker<FeatureFunctionWalker<T>> createDefaultFeatureFunctionWalker() {
		return null;
	}
	
	default <T> ADEWalker<GMLFunctionWalker<T>> createDefaultGMLFunctionWalker() {
		return null;
	}
}