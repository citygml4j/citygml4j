package org.citygml4j.impl.citygml.texturedsurface;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.impl.gml.geometry.primitives.OrientableSurfaceImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.texturedsurface._AppearanceProperty;
import org.citygml4j.model.citygml.texturedsurface._TexturedSurface;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.module.citygml.TexturedSurfaceModule;
import org.citygml4j.visitor.GMLFunction;
import org.citygml4j.visitor.GMLVisitor;
import org.citygml4j.visitor.GeometryFunction;
import org.citygml4j.visitor.GeometryVisitor;

public class _TexturedSurfaceImpl extends OrientableSurfaceImpl implements _TexturedSurface {
	private List<_AppearanceProperty> appearance;
	private TexturedSurfaceModule module;
	
	public _TexturedSurfaceImpl() {
		
	}
	
	public _TexturedSurfaceImpl(TexturedSurfaceModule module) {
		this.module = module;
	}
	
	public void addAppearance(_AppearanceProperty appearance) {
		if (this.appearance == null)
			this.appearance = new ChildList<_AppearanceProperty>(this);

		this.appearance.add(appearance);
	}

	public List<_AppearanceProperty> getAppearance() {
		if (appearance == null)
			appearance = new ChildList<_AppearanceProperty>(this);

		return appearance;
	}

	public boolean isSetAppearance() {
		return appearance != null && !appearance.isEmpty();
	}

	public void setAppearance(List<_AppearanceProperty> appearance) {
		this.appearance = new ChildList<_AppearanceProperty>(this, appearance);
	}

	public void unsetAppearance() {
		if (isSetAppearance())
			appearance.clear();

		appearance = null;
	}

	public boolean unsetAppearance(_AppearanceProperty appearance) {
		return isSetAppearance() ? this.appearance.remove(appearance) : false;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass._TEXTURED_SURFACE;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass._TEXTURED_SURFACE;
	}

	public final TexturedSurfaceModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new _TexturedSurfaceImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		_TexturedSurface copy = (target == null) ? new _TexturedSurfaceImpl() : (_TexturedSurface)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetAppearance()) {
			for (_AppearanceProperty part : appearance) {
				_AppearanceProperty copyPart = (_AppearanceProperty)copyBuilder.copy(part);
				copy.addAppearance(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		return copy;
	}

	@Override
	public <T> T apply(GeometryFunction<T> visitor) {
		return visitor.accept(this);
	}

	@Override
	public <T> T apply(GMLFunction<T> visitor) {
		return visitor.accept(this);
	}

	@Override
	public void visit(GeometryVisitor visitor) {
		visitor.accept(this);
	}

	@Override
	public void visit(GMLVisitor visitor) {
		visitor.accept(this);
	}	

}
