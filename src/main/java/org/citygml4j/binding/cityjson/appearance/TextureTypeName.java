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
package org.citygml4j.binding.cityjson.appearance;

import com.google.gson.annotations.SerializedName;

public enum TextureTypeName {
	@SerializedName("PNG")
	PNG("PNG", "image/png"),
	@SerializedName("JPG")
	JPG("JPG", "image/jpeg");
	
	private final String value;
	private final String mimeType;
	
	private TextureTypeName(String value, String mimeType) {
		this.value = value;
		this.mimeType = mimeType;
	}
	
	public String getValue() {
		return value;
	}
	
	public String getMimeType() {
		return mimeType;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	public static TextureTypeName fromValue(String value) {
		for (TextureTypeName type : TextureTypeName.values()) {
			if (type.value.equals(value))
				return type;
		}
		
		return null;
	}
	
	public static TextureTypeName fromFileName(String fileName) {
		String tmp = fileName.toLowerCase();
		if (tmp.endsWith(".png"))
			return PNG;
		else if (tmp.endsWith(".jpg")
				|| tmp.endsWith(".jpeg")
				|| tmp.endsWith(".jpe")
				|| tmp.endsWith(".jfif")
				|| tmp.endsWith(".jif"))
			return JPG;
				
		return null;
	}
	
}
