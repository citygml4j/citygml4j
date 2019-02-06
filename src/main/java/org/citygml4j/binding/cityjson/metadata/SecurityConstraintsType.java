/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2019 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml4j.binding.cityjson.metadata;

import com.google.gson.annotations.SerializedName;

public enum SecurityConstraintsType {
	@SerializedName("unclassified")
	UNCLASSIFIED("unclassified"),
	@SerializedName("restricted")
	RESTRICTED("restricted"),
	@SerializedName("confidential")
	CONFIDENTIAL("confidential"),
	@SerializedName("secret")
	SECRET("secret"),
	@SerializedName("topSecret")
	TOP_SECRET("topSecret"),
	@SerializedName("sensitiveButUnclassified")
	SENSITIVE_BUT_UNCLASSIFIED("sensitiveButUnclassified"),
	@SerializedName("forOfficialUseOnly")
	FOR_OFFICIAL_USE_ONLY("forOfficialUseOnly"),
	@SerializedName("protected")
	PROTECTED("protected"),
	@SerializedName("limitedDistribution")
	LIMITED_DISTRIBUTION("limitedDistribution");

	private final String value;

	private SecurityConstraintsType(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	public static SecurityConstraintsType fromValue(String value) {
		for (SecurityConstraintsType type : SecurityConstraintsType.values()) {
			if (type.value.equals(value))
				return type;
		}
		
		return null;
	}
	
}
