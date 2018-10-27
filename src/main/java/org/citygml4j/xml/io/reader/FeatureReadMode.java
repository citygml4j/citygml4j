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
package org.citygml4j.xml.io.reader;

import org.citygml4j.xml.io.CityGMLInputFactory;

public enum FeatureReadMode {
	NO_SPLIT(CityGMLInputFactory.FEATURE_READ_MODE + ".noSplit"),
	SPLIT_PER_COLLECTION_MEMBER(CityGMLInputFactory.FEATURE_READ_MODE + ".splitPerCollectionMember"),
	SPLIT_PER_FEATURE(CityGMLInputFactory.FEATURE_READ_MODE + ".splitPerFeature");

	private final String value;

	private FeatureReadMode(String value) {
		this.value = value;
	}

	public static FeatureReadMode fromValue(String value) {
		for (FeatureReadMode mode: FeatureReadMode.values()) {
			if (mode.value.equals(value)) {
				return mode;
			}
		}

		return null;
	}

	@Override
	public String toString() {
		return value;
	}
}
