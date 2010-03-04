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
