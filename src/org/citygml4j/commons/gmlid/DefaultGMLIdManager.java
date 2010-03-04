package org.citygml4j.commons.gmlid;

import java.util.UUID;

public class DefaultGMLIdManager implements GMLIdManager {
	private static DefaultGMLIdManager instance = null;

	private DefaultGMLIdManager() {
		// just to thwart instantiation
	}

	public static synchronized DefaultGMLIdManager getInstance() {
		if (instance == null)
			instance = new DefaultGMLIdManager();

		return instance;
	}

	public String generateGmlId() {
		return new StringBuilder("UUID_").append(UUID.randomUUID().toString()).toString();
	}
	
}
