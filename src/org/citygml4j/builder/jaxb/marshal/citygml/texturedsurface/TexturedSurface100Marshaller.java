package org.citygml4j.builder.jaxb.marshal.citygml.texturedsurface;

import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.jaxb.citygml.tex._1.AbstractAppearanceType;
import org.citygml4j.jaxb.citygml.tex._1.AppearancePropertyType;
import org.citygml4j.jaxb.citygml.tex._1.MaterialType;
import org.citygml4j.jaxb.citygml.tex._1.ObjectFactory;
import org.citygml4j.jaxb.citygml.tex._1.SimpleTextureType;
import org.citygml4j.jaxb.citygml.tex._1.TextureTypeType;
import org.citygml4j.jaxb.citygml.tex._1.TexturedSurfaceType;
import org.citygml4j.model.citygml.texturedsurface.TexturedSurfaceModuleComponent;
import org.citygml4j.model.citygml.texturedsurface._AbstractAppearance;
import org.citygml4j.model.citygml.texturedsurface._AppearanceProperty;
import org.citygml4j.model.citygml.texturedsurface._Color;
import org.citygml4j.model.citygml.texturedsurface._Material;
import org.citygml4j.model.citygml.texturedsurface._SimpleTexture;
import org.citygml4j.model.citygml.texturedsurface._TextureType;
import org.citygml4j.model.citygml.texturedsurface._TexturedSurface;
import org.citygml4j.model.common.base.ModelObject;

public class TexturedSurface100Marshaller {
	private final ObjectFactory tex = new ObjectFactory();
	private final JAXBMarshaller jaxb;
	
	public TexturedSurface100Marshaller(CityGMLMarshaller citygml) {
		jaxb = citygml.getJAXBMarshaller();
	}

	public JAXBElement<?> marshalJAXBElement(Object src) {
		JAXBElement<?> dest = null;
		
		if (src instanceof TexturedSurfaceModuleComponent)
			src = marshal((TexturedSurfaceModuleComponent)src);
		
		if (src instanceof MaterialType)
			dest = tex.createMaterial((MaterialType)src);
		else if (src instanceof SimpleTextureType)
			dest = tex.createSimpleTexture((SimpleTextureType)src);
		else if (src instanceof TexturedSurfaceType)
			dest = tex.createTexturedSurface((TexturedSurfaceType)src);
		
		return dest;
	}
	
	public Object marshal(ModelObject src) {
		Object dest = null;
		
		if (src instanceof _AppearanceProperty)
			dest = marshalAppearanceProperty((_AppearanceProperty)src);
		else if (src instanceof _Color)
			dest = marshalColor((_Color)src);
		else if (src instanceof _Material)
			dest = marshalMaterial((_Material)src);
		else if (src instanceof _SimpleTexture)
			dest = marshalSimpleTexture((_SimpleTexture)src);
		else if (src instanceof _TexturedSurface)
			dest = marshalTexturedSurface((_TexturedSurface)src);
		else if (src instanceof _TextureType)
			dest = marshalTextureType((_TextureType)src);
		
		return dest;
	}
	
	public void marshalAppearance(_AbstractAppearance src, AbstractAppearanceType dest) {
		jaxb.getGMLMarshaller().marshalAbstractGML(src, dest);
	}
	
	@SuppressWarnings("unchecked")
	public AppearancePropertyType marshalAppearanceProperty(_AppearanceProperty src) {
		AppearancePropertyType dest = tex.createAppearancePropertyType();

		if (src.isSetOrientation())
			dest.setOrientation(src.getOrientation());
		
		if (src.isSetAppearance()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getAppearance());
			if (elem != null && elem.getValue() instanceof AbstractAppearanceType)
				dest.set_Appearance((JAXBElement<? extends AbstractAppearanceType>)elem);
		}
		
		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(src.getShow());

		if (src.isSetActuate())
			dest.setActuate(src.getActuate());

		return dest;
	}
	
	public List<Double> marshalColor(_Color src) {
		return src.toList();
	}
	
	public void marshalMaterial(_Material src, MaterialType dest) {
		marshalAppearance(src, dest);
		
		if (src.isSetShininess())
			dest.setShininess(src.getShininess());
		
		if (src.isSetTransparency())
			dest.setTransparency(src.getTransparency());
		
		if (src.isSetAmbientIntensity())
			dest.setAmbientIntensity(src.getAmbientIntensity());
		
		if (src.isSetSpecularColor())
			dest.setSpecularColor(marshalColor(src.getSpecularColor()));
		
		if (src.isSetDiffuseColor())
			dest.setDiffuseColor(marshalColor(src.getDiffuseColor()));
		
		if (src.isSetEmissiveColor())
			dest.setEmissiveColor(marshalColor(src.getEmissiveColor()));
	}
	
	public MaterialType marshalMaterial(_Material src) {
		MaterialType dest = tex.createMaterialType();
		marshalMaterial(src, dest);

		return dest;
	}
	
	public void marshalSimpleTexture(_SimpleTexture src, SimpleTextureType dest) {
		marshalAppearance(src, dest);
		
		if (src.isSetTextureMap())
			dest.setTextureMap(src.getTextureMap());
		
		if (src.isSetTextureCoordinates())
			dest.setTextureCoordinates(src.getTextureCoordinates());
		
		if (src.isSetTextureType())
			dest.setTextureType(marshalTextureType(src.getTextureType()));
		
		if (src.isSetRepeat())
			dest.setRepeat(src.getRepeat());
	}
	
	public SimpleTextureType marshalSimpleTexture(_SimpleTexture src) {
		SimpleTextureType dest = tex.createSimpleTextureType();
		marshalSimpleTexture(src, dest);

		return dest;
	}
	
	public void marshalTexturedSurface(_TexturedSurface src, TexturedSurfaceType dest) {
		jaxb.getGMLMarshaller().marshalOrientableSurface(src, dest);
		
		if (src.isSetAppearance()) {
			for (_AppearanceProperty appearanceProperty : src.getAppearance())
				dest.getAppearance().add(marshalAppearanceProperty(appearanceProperty));
		}
	}
	
	public TexturedSurfaceType marshalTexturedSurface(_TexturedSurface src) {
		TexturedSurfaceType dest = tex.createTexturedSurfaceType();
		marshalTexturedSurface(src, dest);

		return dest;
	}
	
	public TextureTypeType marshalTextureType(_TextureType src) {
		return TextureTypeType.fromValue(src.getValue());
	}
	
}
