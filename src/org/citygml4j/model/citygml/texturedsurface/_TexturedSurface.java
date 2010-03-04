package org.citygml4j.model.citygml.texturedsurface;

import java.util.List;

import org.citygml4j.model.gml.OrientableSurface;

public interface _TexturedSurface extends TexturedSurfaceModuleComponent, OrientableSurface {
	public List<_AppearanceProperty> getAppearance();
	public boolean isSetAppearance();

	public void setAppearance(List<_AppearanceProperty> appearance);
	public void addAppearance(_AppearanceProperty appearance);
	public void unsetAppearance();
	public boolean unsetAppearance(_AppearanceProperty appearance);
}
