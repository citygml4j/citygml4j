package org.citygml4j.xml.io.reader;

import org.citygml4j.xml.io.CityGMLInputFactory;

public enum FeatureReadMode {
	NO_SPLIT(CityGMLInputFactory.FEATURE_READ_MODE + ".noSplit"),
	SPLIT_PER_COLLECTION_MEMBER(CityGMLInputFactory.FEATURE_READ_MODE + ".splitPerCollectionMember"),
	SPLIT_PER_FEATURE(CityGMLInputFactory.FEATURE_READ_MODE + ".splitPerFeature");

	private final String value;

	private FeatureReadMode(String value) {
		this.value = value;
	}

	public static FeatureReadMode fromValue(String value) {
		for (FeatureReadMode mode: FeatureReadMode.values()) {
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
