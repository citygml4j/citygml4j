package org.citygml4j.impl.citygml.texturedsurface;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.base.AssociationByRepOrRefImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.texturedsurface._AbstractAppearance;
import org.citygml4j.model.citygml.texturedsurface._AppearanceProperty;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.module.citygml.TexturedSurfaceModule;

public class _AppearancePropertyImpl extends AssociationByRepOrRefImpl<_AbstractAppearance> implements _AppearanceProperty {
	private String orientation;
	private TexturedSurfaceModule module;
	
	public _AppearancePropertyImpl() {
		
	}
	
	public _AppearancePropertyImpl(TexturedSurfaceModule module) {
		this.module = module;
	}
	
	public _AbstractAppearance getAppearance() {
		return super.getObject();
	}

	public String getOrientation() {
		return orientation;
	}

	public boolean isSetAppearance() {
		return super.isSetObject();
	}

	public boolean isSetOrientation() {
		return orientation != null;
	}

	public void setAppearance(_AbstractAppearance _appearance) {
		super.setObject(_appearance);
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public void unsetAppearance() {
		super.unsetObject();
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass._APPEARANCE_PROPERTY;
	}

	public final TexturedSurfaceModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	public GMLClass getGMLClass() {
		return GMLClass.CITYGML_CLASS;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new _AppearancePropertyImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		_AppearanceProperty copy = (target == null) ? new _AppearancePropertyImpl() : (_AppearanceProperty)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetOrientation())
			copy.setOrientation(copyBuilder.copy(orientation));
		
        return copy;
	}

}
