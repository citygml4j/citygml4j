package org.citygml4j.model.citygml.texturedsurface;

public interface TexturedSurfaceFactory {
	public _AppearanceProperty create_AppearanceProperty();
	public _Material create_Material();
	public _SimpleTexture create_SimpleTexture();
	public _TexturedSurface create_TexturedSurface();
	public _Color create_Color();
	public _Color create_Color(Double red, Double green, Double blue);
	public _TextureType create_TextureType(String _textureType);
}
