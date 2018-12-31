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
package org.citygml4j.binding.cityjson.metadata;

import com.google.gson.annotations.SerializedName;

public enum LegalConstraintsType {
	@SerializedName("copyright")
	COPYRIGHT("copyright"),
	@SerializedName("patent")
	PATENT("patent"),
	@SerializedName("patentPending")
	PATENT_PENDING("patentPending"),
	@SerializedName("trademark")
	TRADEMARK("trademark"),
	@SerializedName("licence")
	LICENSE("licence"),
	@SerializedName("intellectualPropertyRights")
	INTELLECTUAL_PROPERTY_RIGHTS("intellectualPropertyRights"),
	@SerializedName("restricted")
	RESTRICTED("restricted"),
	@SerializedName("otherRestrictions")
	OTHER_RESTRICTIONS("otherRestrictions"),
	@SerializedName("unrestricted")
	UNRESTRICTED("unrestricted"),
	@SerializedName("licenseUnrestricted")
	LICENSE_UNRESTRICTED("licenseUnrestricted"),
	@SerializedName("licenseEndUser")
	LICENSE_END_USER("licenseEndUser"),
	@SerializedName("licenseDistributor")
	LICENSE_DISTRIBUTOR("licenseDistributor"),
	@SerializedName("private")
	PRIVATE("private"),
	@SerializedName("statutory")
	STATUTORY("statutory"),
	@SerializedName("confidential")
	CONFIDENTIAL("confidential"),
	@SerializedName("sensitiveButUnclassified")
	SENSITIVE_BUT_UNCLASSIFIED("sensitiveButUnclassified"),
	@SerializedName("in-confidence")
	IN_CONFIDENCE("in-confidence");

	private final String value;

	private LegalConstraintsType(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	public static LegalConstraintsType fromValue(String value) {
		for (LegalConstraintsType type : LegalConstraintsType.values()) {
			if (type.value.equals(value))
				return type;
		}
		
		return null;
	}
	
}
