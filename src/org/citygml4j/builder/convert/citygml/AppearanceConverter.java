package org.citygml4j.builder.convert.citygml;

import org.citygml4j.factory.CityGMLFactory;
import org.citygml4j.geometry.Matrix4;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.appearance.AbstractSurfaceData;
import org.citygml4j.model.citygml.appearance.AbstractTexture;
import org.citygml4j.model.citygml.appearance.Appearance;
import org.citygml4j.model.citygml.appearance.AppearanceMember;
import org.citygml4j.model.citygml.appearance.AppearanceProperty;
import org.citygml4j.model.citygml.appearance.Color;
import org.citygml4j.model.citygml.appearance.ColorPlusOpacity;
import org.citygml4j.model.citygml.appearance.GeoreferencedTexture;
import org.citygml4j.model.citygml.appearance.ParameterizedTexture;
import org.citygml4j.model.citygml.appearance.SurfaceDataProperty;
import org.citygml4j.model.citygml.appearance.TexCoordGen;
import org.citygml4j.model.citygml.appearance.TexCoordList;
import org.citygml4j.model.citygml.appearance.TextureAssociation;
import org.citygml4j.model.citygml.appearance.TextureCoordinates;
import org.citygml4j.model.citygml.appearance.TextureParameterization;
import org.citygml4j.model.citygml.appearance.TextureType;
import org.citygml4j.model.citygml.appearance.WorldToTexture;
import org.citygml4j.model.citygml.appearance.WrapMode;
import org.citygml4j.model.citygml.appearance.X3DMaterial;
import org.citygml4j.model.citygml.core.TransformationMatrix2x2;

public class AppearanceConverter {
	private CityGMLConvertBuilder builder;
	private CityGMLFactory citygml;

	protected AppearanceConverter(CityGMLConvertBuilder builder) {
		this.builder = builder;
		citygml = new CityGMLFactory();
	}

	protected Appearance convertAppearance(Appearance src) {
		Appearance dest = null;

		if (src instanceof ADEComponent) {
			ADEComponent tmp = builder.convertADEComponent((ADEComponent)src);
			if (tmp != null && tmp instanceof Appearance)
				dest = (Appearance)tmp;
		} else {
			dest = citygml.createAppearance(builder.convertContext.appModule);
			if (dest != null) 
				convertAppearance(src, dest);
		}

		return dest;
	}

	protected AppearanceMember convertAppearanceMember(AppearanceMember src) {
		AppearanceMember dest = citygml.createAppearanceMember(builder.convertContext.appModule);
		if (dest != null) {
			builder.gml.convertFeatureProperty(src, dest);

			if (src.isSetAppearance()) {
				Appearance tmp = convertAppearance(src.getAppearance());
				if (tmp != null)
					dest.setAppearance(tmp);
			}
		}

		return dest;
	}

	protected AppearanceProperty convertAppearanceProperty(AppearanceProperty src) {
		AppearanceProperty dest = citygml.createAppearanceProperty(builder.convertContext.appModule);
		if (dest != null) {
			builder.gml.convertFeatureProperty(src, dest);

			if (src.isSetAppearance()) {
				Appearance tmp = convertAppearance(src.getAppearance());
				if (tmp != null)
					dest.setAppearance(tmp);
			}
		}

		return dest;
	}

	protected Color convertColor(Color src) {
		Color dest = citygml.createColor(builder.convertContext.appModule);
		if (dest != null)
			dest.setColor(src.toList());

		return dest;
	}

	protected ColorPlusOpacity convertColorPlusOpacity(ColorPlusOpacity src) {
		ColorPlusOpacity dest = citygml.createColorPlusOpacity(builder.convertContext.appModule);
		if (dest != null)
			dest.setColorPlusOpacity(src.toList());

		return dest;
	}

	protected GeoreferencedTexture convertGeoreferencedTexture(GeoreferencedTexture src) {
		GeoreferencedTexture dest = null;

		if (src instanceof ADEComponent) {
			ADEComponent tmp = builder.convertADEComponent((ADEComponent)src);
			if (tmp != null && tmp instanceof GeoreferencedTexture)
				dest = (GeoreferencedTexture)tmp;
		} else {
			dest = citygml.createGeoreferencedTexture(builder.convertContext.appModule);
			if (dest != null) 
				convertGeoreferencedTexture(src, dest);
		}

		return dest;
	}

	protected ParameterizedTexture convertParameterizedTexture(ParameterizedTexture src) {
		ParameterizedTexture dest = null;

		if (src instanceof ADEComponent) {
			ADEComponent tmp = builder.convertADEComponent((ADEComponent)src);
			if (tmp != null && tmp instanceof ParameterizedTexture)
				dest = (ParameterizedTexture)tmp;
		} else {
			dest = citygml.createParameterizedTexture(builder.convertContext.appModule);
			if (dest != null)
				convertParameterizedTexture(src, dest);
		}

		return dest;
	}

	protected SurfaceDataProperty convertSurfaceDataProperty(SurfaceDataProperty src) {
		SurfaceDataProperty dest = citygml.createSurfaceDataProperty(builder.convertContext.appModule);
		if (dest != null) {
			builder.gml.convertAssociationAttributeGroup(src, dest);

			if (src.isSetSurfaceData()) {
				AbstractSurfaceData tmp = null;
				AbstractSurfaceData surfaceData = src.getSurfaceData();

				if (surfaceData instanceof ADEComponent) {
					ADEComponent ade = builder.convertADEComponent((ADEComponent)surfaceData);
					if (ade != null && ade instanceof AbstractSurfaceData)
						tmp = (AbstractSurfaceData)ade;
				} else {
					switch (surfaceData.getCityGMLClass()) {
					case GEOREFERENCEDTEXTURE:
						tmp = convertGeoreferencedTexture((GeoreferencedTexture)surfaceData);
						break;
					case PARAMETERIZEDTEXTURE:
						tmp = convertParameterizedTexture((ParameterizedTexture)surfaceData);
						break;
					case X3DMATERIAL:
						tmp = convertX3DMaterial((X3DMaterial)surfaceData);
						break;
					}
				}

				if (tmp != null)
					dest.setSurfaceData(tmp);
			}
		}

		return dest;
	}

	protected TexCoordGen convertTexCoordGen(TexCoordGen src) {
		TexCoordGen dest = citygml.createTexCoordGen(builder.convertContext.appModule);
		if (dest != null) {
			convertTextureParameterization(src, dest);

			if (src.isSetWorldToTexture()) {
				WorldToTexture tmp = convertWorldToTexture(src.getWorldToTexture());
				if (tmp != null)
					dest.setWorldToTexture(tmp);
			}

			if (src.isSetGenericApplicationPropertyOfTexCoordGen()) {
				for (ADEComponent ade : src.getGenericApplicationPropertyOfTexCoordGen()) {
					ADEComponent tmp = builder.ade.convertADEComponent(ade);
					if (tmp != null)
						dest.addGenericApplicationPropertyOfTexCoordGen(tmp);
				}
			}
		}

		return dest;
	}

	protected TexCoordList convertTexCoordList(TexCoordList src) {
		TexCoordList dest = citygml.createTexCoordList(builder.convertContext.appModule);
		if (dest != null) {
			convertTextureParameterization(src, dest);

			if (src.isSetTextureCoordinates()) {
				for (TextureCoordinates textureCoordinates : src.getTextureCoordinates()) {
					TextureCoordinates tmp = convertTextureCoordinates(textureCoordinates);
					if (tmp != null)
						dest.addTextureCoordinates(tmp);
				}
			}

			if (src.isSetGenericApplicationPropertyOfTexCoordList()) {
				for (ADEComponent ade : src.getGenericApplicationPropertyOfTexCoordList()) {
					ADEComponent tmp = builder.ade.convertADEComponent(ade);
					if (tmp != null)
						dest.addGenericApplicationPropertyOfTexCoordList(tmp);
				}
			}
		}

		return dest;
	}

	protected TextureAssociation convertTextureAssociation(TextureAssociation src) {
		TextureAssociation dest = citygml.createTextureAssociation(builder.convertContext.appModule);
		if (dest != null) {
			builder.gml.convertAssociationAttributeGroup(src, dest);

			if (src.isSetUri())
				dest.setUri(src.getUri());

			if (src.isSetTextureParameterization()) {
				TextureParameterization tmp = null;
				TextureParameterization textureParam = src.getTextureParameterization();

				switch (textureParam.getCityGMLClass()) {
				case TEXCOORDGEN:
					tmp = convertTexCoordGen((TexCoordGen)textureParam);
					break;
				case TEXCOORDLIST:
					tmp = convertTexCoordList((TexCoordList)textureParam);
					break;
				}

				if (tmp != null)
					dest.setTextureParameterization(tmp);
			}
		}

		return dest;
	}

	protected TextureCoordinates convertTextureCoordinates(TextureCoordinates src) {
		TextureCoordinates dest = citygml.createTextureCoordinates(builder.convertContext.appModule);
		if (dest != null) {
			if (src.isSetValue())
				dest.setValue(src.getValue());

			if (src.isSetRing())
				dest.setRing(src.getRing());
		}

		return dest;
	}

	protected TextureType convertTextureType(TextureType src) {
		return citygml.createTextureType(src.toString(), builder.convertContext.appModule);
	}

	protected WorldToTexture convertWorldToTexture(WorldToTexture src) {
		WorldToTexture dest = citygml.createWorldToTexture(builder.convertContext.appModule);
		if (dest != null) {
			builder.gml.convertSRSReferenceGroup(src, dest);

			Matrix4 matrix = src.getTransformationMatrix3x4();
			if (matrix != null)
				dest.setTransformationMatrix3x4(matrix);			
		}

		return dest;
	}

	protected WrapMode convertWrapMode(WrapMode src) {
		return citygml.createWrapMode(src.toString(), builder.convertContext.appModule);
	}

	protected X3DMaterial convertX3DMaterial(X3DMaterial src) {
		X3DMaterial dest = null;

		if (src instanceof ADEComponent) {
			ADEComponent tmp = builder.convertADEComponent((ADEComponent)src);
			if (tmp != null && tmp instanceof X3DMaterial)
				dest = (X3DMaterial)tmp;
		} else {
			dest = citygml.createX3DMaterial(builder.convertContext.appModule);
			if (dest != null) 
				convertX3DMaterial(src, dest);
		}

		return dest;
	}

	protected void convertAbstractSurfaceData(AbstractSurfaceData src, AbstractSurfaceData dest) {
		builder.gml.convertAbstractFeature(src, dest);

		if (src.isSetIsFront())
			dest.setIsFront(src.getIsFront());

		if (src.isSetGenericApplicationPropertyOfSurfaceData()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfSurfaceData()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfSurfaceData(tmp);
			}
		}
	}

	protected void convertAbstractTexture(AbstractTexture src, AbstractTexture dest) {
		convertAbstractSurfaceData(src, dest);

		if (src.isSetImageUri())
			dest.setImageURI(src.getImageURI());

		if (src.isSetMimeType())
			dest.setMimeType(src.getMimeType());

		if (src.isSetTextureType()) {
			TextureType tmp = convertTextureType(src.getTextureType());
			if (tmp != null)
				dest.setTextureType(tmp);
		}

		if (src.isSetWrapMode()) {
			WrapMode tmp = convertWrapMode(src.getWrapMode());
			if (tmp != null)
				dest.setWrapMode(tmp);
		}

		if (src.isSetBorderColor()) {
			ColorPlusOpacity tmp = convertColorPlusOpacity(src.getBorderColor());
			if (tmp != null)
				dest.setBorderColor(tmp);
		}

		if (src.isSetGenericApplicationPropertyOfTexture()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfTexture()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfTexture(tmp);
			}
		}
	}

	protected void convertAppearance(Appearance src, Appearance dest) {
		builder.gml.convertAbstractFeature(src, dest);

		if (src.isSetTheme())
			dest.setTheme(src.getTheme());

		if (src.isSetSurfaceDataMember()) {
			for (SurfaceDataProperty surfaceDataProperty : src.getSurfaceDataMember()) {
				SurfaceDataProperty tmp = convertSurfaceDataProperty(surfaceDataProperty);
				if (tmp != null)
					dest.addSurfaceDataMember(tmp);
			}
		}

		if (src.isSetGenericApplicationPropertyOfAppearance()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfAppearance()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfAppearance(tmp);
			}
		}
	}

	protected void convertGeoreferencedTexture(GeoreferencedTexture src, GeoreferencedTexture dest) {
		convertAbstractTexture(src, dest);

		if (src.isSetPreferWorldFile())
			dest.setPreferWorldFile(src.getPreferWorldFile());

		if (src.isSetReferencePoint())
			dest.setReferencePoint(src.getReferencePoint());

		if (src.isSetOrientation()) {
			TransformationMatrix2x2 tmp = builder.core.convertTransformationMatrix2x2(src.getOrientation());
			if (tmp != null)
				dest.setOrientation(tmp);
		}

		if (src.isSetTarget())
			dest.setTarget(src.getTarget());

		if (src.isSetGenericApplicationPropertyOfGeoreferencedTexture()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfGeoreferencedTexture()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfGeoreferencedTexture(tmp);
			}
		}
	}

	protected void convertParameterizedTexture(ParameterizedTexture src, ParameterizedTexture dest) {
		convertAbstractTexture(src, dest);

		if (src.isSetTarget()) {
			for (TextureAssociation textureAssociation : src.getTarget()) {
				TextureAssociation tmp = convertTextureAssociation(textureAssociation);
				if (tmp != null)
					dest.addTarget(tmp);
			}
		}

		if (src.isSetGenericApplicationPropertyOfParameterizedTexture()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfParameterizedTexture()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfParameterizedTexture(tmp);
			}
		}
	}

	protected void convertTextureParameterization(TextureParameterization src, TextureParameterization dest) {
		builder.gml.convertAbstractGML(src, dest);
		
		if (src.isSetGenericApplicationPropertyOfTextureParameterization()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfTextureParameterization()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfTextureParameterization(tmp);
			}
		}
	}

	protected void convertX3DMaterial(X3DMaterial src, X3DMaterial dest) {
		convertAbstractSurfaceData(src, dest);

		if (src.isSetAmbientIntensity())
			dest.setAmbientIntensity(src.getAmbientIntensity());

		if (src.isSetDiffuseColor()) {
			Color tmp = convertColor(src.getDiffuseColor());
			if (tmp != null)
				dest.setDiffuseColor(tmp);
		}

		if (src.isSetEmissiveColor()) {
			Color tmp = convertColor(src.getEmissiveColor());
			if (tmp != null)
				dest.setEmissiveColor(tmp);
		}

		if (src.isSetEmissiveColor()) {
			Color tmp = convertColor(src.getEmissiveColor());
			if (tmp != null)
				dest.setEmissiveColor(tmp);
		}

		if (src.isSetSpecularColor()) {
			Color tmp = convertColor(src.getSpecularColor());
			if (tmp != null)
				dest.setSpecularColor(tmp);
		}

		if (src.isSetShininess())
			dest.setShininess(src.getShininess());

		if (src.isSetTransparency())
			dest.setTransparency(src.getTransparency());

		if (src.isSetIsSmooth())
			dest.setIsSmooth(src.getIsSmooth());

		if (src.isSetTarget())
			dest.setTarget(src.getTarget());
		
		if (src.isSetGenericApplicationPropertyOfX3DMaterial()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfX3DMaterial()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfX3DMaterial(tmp);
			}
		}
	}
}
