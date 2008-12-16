package org.citygml4j.model.citygml.appearance;

public interface AppearanceFactory {
	public Appearance createAppearance();
	public AppearanceMember createAppearanceMember();
	public AppearanceProperty createAppearanceProperty();
	public Color createColor();
	public Color createColor(Double red, Double green, Double blue);
	public ColorPlusOpacity createColorPlusOpacity();	
	public ColorPlusOpacity createColorPlusOpacity(Color color, Double opacity);
	public ColorPlusOpacity createColorPlusOpacity(Double defaultColorValue, Double opacity);
	public ColorPlusOpacity createColorPlusOpacity(Double defaultColorValue);
	public ColorPlusOpacity createColorPlusOpacity(Double red, Double green, Double blue, Double opacity);
	public ColorPlusOpacity createColorPlusOpacity(Double red, Double green, Double blue);
	public GeoreferencedTexture createGeoreferencedTexture();
	public ParameterizedTexture createParameterizedTexture();
	public SurfaceDataProperty createSurfaceDataProperty();
	public TexCoordGen createTexCoordGen();
	public TexCoordList createTexCoordList();
	public TextureAssociation createTextureAssociation();
	public TextureCoordinates createTextureCoordinates();
	public TextureType createTextureType(String textureType);
	public WorldToTexture createWorldToTexture();
	public WrapMode createWrapMode(String wrapMode);
	public X3DMaterial createX3DMaterial();

}
