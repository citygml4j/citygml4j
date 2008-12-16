package org.citygml4j.model.citygml.texturedsurface;

import org.citygml4j.model.citygml.core.CityGMLBase;

public interface _TextureType extends CityGMLBase {
	public static String SPECIFIC = "specific";
	public static String TYPICAL = "typical";
    public static String UNKNOWN = "unknown";
    
	public String getValue();
}
