package org.citygml4j.builder.json.objects.geometry;

import java.util.Collection;

import org.citygml4j.builder.json.objects.appearance.AbstractMaterialObject;
import org.citygml4j.builder.json.objects.appearance.AbstractTextureObject;

public interface GeometryWithAppearance<M extends AbstractMaterialObject, T extends AbstractTextureObject> {
	public boolean isSetMaterial();
	public Collection<M> getMaterial();
	public boolean isSetTexture();
	public Collection<T> getTexture();
}
