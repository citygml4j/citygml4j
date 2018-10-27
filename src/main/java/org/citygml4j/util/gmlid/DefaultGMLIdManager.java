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
package org.citygml4j.util.gmlid;

import java.util.UUID;

public class DefaultGMLIdManager implements GMLIdManager {
	private static DefaultGMLIdManager instance = new DefaultGMLIdManager();
	private String defaultPrefix = "UUID_";
	private String prefix = defaultPrefix;

	private DefaultGMLIdManager() {
		// just to thwart instantiation
	}

	public static DefaultGMLIdManager getInstance() {
		return instance;
	}
	
	public String getDefaultPrefix() {
		return defaultPrefix;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String generateUUID(String prefix) {
		return new StringBuilder(prefix).append(UUID.randomUUID().toString()).toString();
	}
	
	public String generateUUID() {
		return generateUUID(prefix);
	}
	
}
