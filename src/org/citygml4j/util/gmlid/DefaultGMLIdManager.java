/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2012
 * Institute for Geodesy and Geoinformation Science
 * Technische Universität Berlin, Germany
 * http://www.igg.tu-berlin.de/
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
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
