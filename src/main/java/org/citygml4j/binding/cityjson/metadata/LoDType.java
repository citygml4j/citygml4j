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
package org.citygml4j.binding.cityjson.metadata;

import com.google.gson.annotations.SerializedName;

public enum LoDType {
	@SerializedName("0.0")
	LOD_0_0("0.0"),
	@SerializedName("0.1")
	LOD_0_1("0.1"),
	@SerializedName("0.2")
	LOD_0_2("0.2"),
	@SerializedName("0.3")
	LOD_0_3("0.3"),
	@SerializedName("1.0")
	LOD_1_0("1.0"),
	@SerializedName("1.1")
	LOD_1_1("1.1"),
	@SerializedName("1.2")
	LOD_1_2("1.2"),
	@SerializedName("1.3")
	LOD_1_3("1.3"),
	@SerializedName("2.0")
	LOD_2_0("2.0"),
	@SerializedName("2.1")
	LOD_2_1("2.1"),
	@SerializedName("2.2")
	LOD_2_2("2.2"),
	@SerializedName("2.3")
	LOD_2_3("2.3"),
	@SerializedName("3.0")
	LOD_3_0("3.0"),
	@SerializedName("3.1")
	LOD_3_1("3.1"),
	@SerializedName("3.2")
	LOD_3_2("3.2"),
	@SerializedName("3.3")
	LOD_3_3("3.3");

	private final String value;

	private LoDType(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	public static LoDType fromValue(String value) {
		for (LoDType type : LoDType.values()) {
			if (type.value.equals(value))
				return type;
		}
		
		return null;
	}

	public static LoDType fromLoD(Number lod) {
		double value = lod.doubleValue();

		if (value == 0)
			return LOD_0_0;
		else if (value == 0.1)
			return LOD_0_1;
		else if (value == 0.2)
			return LOD_0_2;
		else if (value == 0.3)
			return LOD_0_3;
		else if (value == 1)
			return LOD_1_0;
		else if (value == 1.1)
			return LOD_1_1;
		else if (value == 1.2)
			return LOD_1_2;
		else if (value == 1.3)
			return LOD_1_3;
		else if (value == 2)
			return LOD_2_0;
		else if (value == 2.1)
			return LOD_2_1;
		else if (value == 2.2)
			return LOD_2_2;
		else if (value == 2.3)
			return LOD_2_3;
		else if (value == 3)
			return LOD_3_0;
		else if (value == 3.1)
			return LOD_3_1;
		else if (value == 3.2)
			return LOD_3_2;
		else if (value == 3.3)
			return LOD_3_3;
		else
			return null;
	}
	
}
