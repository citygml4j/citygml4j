package org.citygml4j.model.citygml.appearance;

import org.citygml4j.model.citygml.core.CityGMLBase;

public interface WrapMode extends CityGMLBase {
	public static String NONE = "none";
	public static String WRAP ="wrap";
	public static String MIRROR = "mirror";
	public static String CLAMP = "clamp";
	public static String BORDER = "border";
	
	public String getValue();
}
