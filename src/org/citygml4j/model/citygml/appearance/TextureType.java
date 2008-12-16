package org.citygml4j.model.citygml.appearance;

import org.citygml4j.model.citygml.core.CityGMLBase;

public interface TextureType extends CityGMLBase {
	public static String SPECIFIC = "specific";
	public static String TYPICAL = "typical";
    public static String UNKNOWN = "unknown";
	
	public String getValue();
}
