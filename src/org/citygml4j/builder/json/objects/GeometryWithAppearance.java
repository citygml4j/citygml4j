package org.citygml4j.builder.json.objects;

import java.util.Map;

public interface GeometryWithAppearance<M extends AbstractMaterialObject, T extends AbstractTextureObject> {
	public boolean isSetMaterial();
	public Map<String, M> getMaterial();
	public boolean isSetTexture();
	public Map<String, T> getTexture();
}
