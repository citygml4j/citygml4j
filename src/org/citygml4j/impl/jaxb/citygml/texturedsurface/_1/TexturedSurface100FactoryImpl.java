package org.citygml4j.impl.jaxb.citygml.texturedsurface._1;

import org.citygml4j.impl.jaxb.citygml.AbstractTexturedSurfaceFactoryImpl;
import org.citygml4j.model.citygml.texturedsurface._AppearanceProperty;
import org.citygml4j.model.citygml.texturedsurface._Color;
import org.citygml4j.model.citygml.texturedsurface._Material;
import org.citygml4j.model.citygml.texturedsurface._SimpleTexture;
import org.citygml4j.model.citygml.texturedsurface._TextureType;
import org.citygml4j.model.citygml.texturedsurface._TexturedSurface;

public class TexturedSurface100FactoryImpl extends AbstractTexturedSurfaceFactoryImpl {

	@Override
	public _AppearanceProperty create_AppearanceProperty() {
		return new _AppearancePropertyImpl();
	}

	@Override
	public _Material create_Material() {
		return new _MaterialImpl();
	}

	@Override
	public _SimpleTexture create_SimpleTexture() {
		return new _SimpleTextureImpl();
	}

	@Override
	public _TexturedSurface create_TexturedSurface() {
		return new _TexturedSurfaceImpl();
	}

	@Override
	public _Color create_Color() {
		return new _ColorImpl();
	}

	@Override
	public _Color create_Color(Double red, Double green, Double blue) {
		return new _ColorImpl(red, green, blue);
	}

	@Override
	public _TextureType create_TextureType(String _textureType) {
		return _TextureTypeImpl.fromValue(_textureType);
	}

}
