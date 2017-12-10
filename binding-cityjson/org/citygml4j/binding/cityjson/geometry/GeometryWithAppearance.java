package org.citygml4j.binding.cityjson.geometry;

import java.util.Collection;

import org.citygml4j.binding.cityjson.appearance.AbstractMaterialObject;
import org.citygml4j.binding.cityjson.appearance.AbstractTextureObject;

public interface GeometryWithAppearance<M extends AbstractMaterialObject, T extends AbstractTextureObject> {
	public boolean isSetMaterial();
	public Collection<M> getMaterial();
	public M getMaterial(String theme);
	public void removeMaterial(M materialObject);
	public void removeMaterial(String theme);
	public void unsetMaterial();
	public boolean isSetTexture();
	public Collection<T> getTexture();
	public T getTexture(String theme);
	public void removeTexture(T textureObject);
	public void removeTexture(String theme);	
	public void unsetTexture();
	public void unsetAppearance();
}
