/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2023 Claus Nagel <claus.nagel@gmail.com>
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

public class BoundingBoxOptions {
	private boolean assignResultToFeatures;
	private boolean useExistingEnvelopes;
	private boolean useReferencePoint;
	
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
	
	public boolean isUseReferencePointForImplicitGeometries() {
		return useReferencePoint;
	}
	
	public BoundingBoxOptions useReferencePointForImplicitGeometries(boolean useReferencePoint) {
		this.useReferencePoint = useReferencePoint;
		return this;
	}
	
}
