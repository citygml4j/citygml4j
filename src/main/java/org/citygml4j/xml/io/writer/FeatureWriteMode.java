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
package org.citygml4j.xml.io.writer;

import org.citygml4j.xml.io.CityGMLOutputFactory;

public enum FeatureWriteMode {
	NO_SPLIT(CityGMLOutputFactory.FEATURE_WRITE_MODE + ".noSplit"),
	SPLIT_PER_COLLECTION_MEMBER(CityGMLOutputFactory.FEATURE_WRITE_MODE + ".splitPerCollectionMember");
	
	private final String value;

	private FeatureWriteMode(String value) {
		this.value = value;
	}

	public static FeatureWriteMode fromValue(String value) {
		for (FeatureWriteMode mode: FeatureWriteMode.values()) {
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
