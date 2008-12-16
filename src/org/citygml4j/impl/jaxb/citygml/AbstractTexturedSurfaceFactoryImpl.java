package org.citygml4j.impl.jaxb.citygml;

import org.citygml4j.impl.jaxb.citygml.texturedsurface._0_4.TexturedSurface040FactoryImpl;
import org.citygml4j.impl.jaxb.citygml.texturedsurface._1.TexturedSurface100FactoryImpl;
import org.citygml4j.model.citygml.texturedsurface.TexturedSurfaceFactory;
import org.citygml4j.model.citygml.texturedsurface.TexturedSurfaceModule;
import org.citygml4j.model.citygml.texturedsurface._AppearanceProperty;
import org.citygml4j.model.citygml.texturedsurface._Color;
import org.citygml4j.model.citygml.texturedsurface._Material;
import org.citygml4j.model.citygml.texturedsurface._SimpleTexture;
import org.citygml4j.model.citygml.texturedsurface._TextureType;
import org.citygml4j.model.citygml.texturedsurface._TexturedSurface;

public abstract class AbstractTexturedSurfaceFactoryImpl implements TexturedSurfaceFactory {
	private static TexturedSurface040FactoryImpl factory040 = new TexturedSurface040FactoryImpl();
	private static TexturedSurface100FactoryImpl factory100 = new TexturedSurface100FactoryImpl();
	
	public static TexturedSurfaceFactory getInstance(TexturedSurfaceModule module) {
		switch (module) {
		case v0_4_0:
			return factory040;
		default:
			return factory100;
		}
	}
	
	@Override
	public abstract _AppearanceProperty create_AppearanceProperty();

	@Override
	public abstract _Color create_Color();

	@Override
	public abstract _Color create_Color(Double red, Double green, Double blue);

	@Override
	public abstract _Material create_Material();

	@Override
	public abstract _SimpleTexture create_SimpleTexture();

	@Override
	public abstract _TextureType create_TextureType(String _textureType);

	@Override
	public abstract _TexturedSurface create_TexturedSurface();

}
