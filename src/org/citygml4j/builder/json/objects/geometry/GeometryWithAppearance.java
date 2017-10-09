package org.citygml4j.builder.json.objects.geometry;

import java.util.Map;

import org.citygml4j.builder.json.objects.appearance.AbstractMaterialObject;
import org.citygml4j.builder.json.objects.appearance.AbstractTextureObject;

public interface GeometryWithAppearance<M extends AbstractMaterialObject, T extends AbstractTextureObject> {
	public boolean isSetMaterial();
	public Map<String, M> getMaterial();
	public boolean isSetTexture();
	public Map<String, T> getTexture();
}
