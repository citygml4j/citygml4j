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

public enum RoleType {
	@SerializedName("resourceProvider")
	RESOURCE_PROVIDER("resourceProvider"),
	@SerializedName("custodian")
	CUSTODIAN("custodian"),
	@SerializedName("owner")
	OWNER("owner"),
	@SerializedName("user")
	USER("user"),
	@SerializedName("distributor")
	DISTRIBUTOR("distributor"),
	@SerializedName("originator")
	ORIGINATOR("originator"),
	@SerializedName("pointOfContact")
	POINT_OF_CONTACT("pointOfContact"),
	@SerializedName("principalInvestigator")
	PRINCIPAL_INVESTIGATOR("principalInvestigator"),
	@SerializedName("processor")
	PROCESSOR("processor"),
	@SerializedName("publisher")
	PUBLISHER("publisher"),
	@SerializedName("author")
	AUTHOR("author"),
	@SerializedName("sponsor")
	SPONSOR("sponsor"),
	@SerializedName("co-author")
	CO_AUTHOR("co-author"),
	@SerializedName("collaborator")
	COLLABORATOR("collaborator"),
	@SerializedName("editor")
	EDITOR("editor"),
	@SerializedName("mediator")
	MEDIATOR("mediator"),
	@SerializedName("rightsHolder")
	RIGHTS_HOLDER("rightsHolder"),
	@SerializedName("contributor")
	CONTRIBUTOR("contributor"),
	@SerializedName("funder")
	FUNDER("funder"),
	@SerializedName("stakeholder")
	STAKEHOLDER("stakeholder");

	private final String value;

	private RoleType(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	public static RoleType fromValue(String value) {
		for (RoleType type : RoleType.values()) {
			if (type.value.equals(value))
				return type;
		}
		
		return null;
	}
	
}
