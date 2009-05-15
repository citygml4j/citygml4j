package org.citygml4j.impl.jaxb.citygml.appearance._1;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.impl.jaxb.ObjectFactory;
import org.citygml4j.impl.jaxb.citygml.AbstractCityGMLModelMapperImpl;
import org.citygml4j.jaxb.citygml.app._1.AbstractSurfaceDataType;
import org.citygml4j.jaxb.citygml.app._1.AbstractTextureType;
import org.citygml4j.jaxb.citygml.app._1.AppearanceType;
import org.citygml4j.jaxb.citygml.app._1.GeoreferencedTextureType;
import org.citygml4j.jaxb.citygml.app._1.ParameterizedTextureType;
import org.citygml4j.jaxb.citygml.app._1.X3DMaterialType;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.appearance.AbstractSurfaceData;
import org.citygml4j.model.citygml.appearance.AbstractTexture;
import org.citygml4j.model.citygml.appearance.Appearance;
import org.citygml4j.model.citygml.appearance.GeoreferencedTexture;
import org.citygml4j.model.citygml.appearance.ParameterizedTexture;
import org.citygml4j.model.citygml.appearance.X3DMaterial;
import org.citygml4j.model.citygml.core.CityGMLBase;

public class Appearance100ModelMapperImpl extends AbstractCityGMLModelMapperImpl {

	public Appearance toCityGML(AppearanceType appearance, QName name) {		
		if (appearance.getClass().equals(AppearanceType.class))
			return new AppearanceImpl(appearance);
		else
			return (Appearance)jaxb2ade(appearance, name, Appearance.class);
	}
	
	public GeoreferencedTexture toCityGML(GeoreferencedTextureType georeferencedTexture, QName name) {		
		if (georeferencedTexture.getClass().equals(GeoreferencedTextureType.class))
			return new GeoreferencedTextureImpl(georeferencedTexture);
		else
			return (GeoreferencedTexture)jaxb2ade(georeferencedTexture, name, GeoreferencedTexture.class);
	}
	
	public ParameterizedTexture toCityGML(ParameterizedTextureType parameterizedTexture, QName name) {		
		if (parameterizedTexture.getClass().equals(ParameterizedTextureType.class))
			return new ParameterizedTextureImpl(parameterizedTexture);
		else
			return (ParameterizedTexture)jaxb2ade(parameterizedTexture, name, ParameterizedTexture.class);
	}
	
	public X3DMaterial toCityGML(X3DMaterialType x3DMaterial, QName name) {		
		if (x3DMaterial.getClass().equals(X3DMaterialType.class))
			return new X3DMaterialImpl(x3DMaterial);
		else
			return (X3DMaterial)jaxb2ade(x3DMaterial, name, X3DMaterial.class);
	}
	
	public AbstractSurfaceData toCityGML(AbstractSurfaceDataType abstractSurfaceData, QName name) {		
		// we are just checking ADEs
		return (AbstractSurfaceData)jaxb2ade(abstractSurfaceData, name, AbstractSurfaceData.class);
	}
	
	public AbstractTexture toCityGML(AbstractTextureType abstractTexture, QName name) {		
		// we are just checking ADEs
		return (AbstractTexture)jaxb2ade(abstractTexture, name, AbstractTexture.class);
	}
	
	public JAXBElement<? extends GeoreferencedTextureType> toJAXB(GeoreferencedTexture georeferencedTexture) {
		if (!(georeferencedTexture instanceof ADEComponent))
			return ObjectFactory.APP_1.createGeoreferencedTexture(((GeoreferencedTextureImpl)georeferencedTexture).getJAXBObject());
		else
			return ade2jaxb((ADEComponent)georeferencedTexture, GeoreferencedTextureType.class);
	}
	
	public JAXBElement<? extends ParameterizedTextureType> toJAXB(ParameterizedTexture parameterizedTexture) {
		if (!(parameterizedTexture instanceof ADEComponent))
			return ObjectFactory.APP_1.createParameterizedTexture(((ParameterizedTextureImpl)parameterizedTexture).getJAXBObject());
		else
			return ade2jaxb((ADEComponent)parameterizedTexture, ParameterizedTextureType.class);
	}
	
	public JAXBElement<? extends X3DMaterialType> toJAXB(X3DMaterial x3DMaterial) {
		if (!(x3DMaterial instanceof ADEComponent))
			return ObjectFactory.APP_1.createX3DMaterial(((X3DMaterialImpl)x3DMaterial).getJAXBObject());
		else
			return ade2jaxb((ADEComponent)x3DMaterial, X3DMaterialType.class);
	}
	
	public JAXBElement<? extends AbstractSurfaceDataType> toJAXB(AbstractSurfaceData abstractSurfaceData) {
		// we are just checking ADEs
		if (abstractSurfaceData instanceof ADEComponent)
			return ade2jaxb((ADEComponent)abstractSurfaceData, AbstractSurfaceDataType.class);
		
		return null;
	}
	
	public JAXBElement<? extends AbstractTextureType> toJAXB(AbstractTexture abstractTexture) {
		// we are just checking ADEs
		if (abstractTexture instanceof ADEComponent)
			return ade2jaxb((ADEComponent)abstractTexture, AbstractTextureType.class);
		
		return null;
	}
	
	public CityGMLBase toCityGML(JAXBElement<?> jaxbElem) {
		CityGMLBase cityGMLBase = null;
		
		if (jaxbElem.getValue() != null) {
			Object value = jaxbElem.getValue();
			QName name = jaxbElem.getName();

			if (value instanceof AppearanceType)
				cityGMLBase = toCityGML((AppearanceType)value, name);
			else if (value instanceof GeoreferencedTextureType)
				cityGMLBase = toCityGML((GeoreferencedTextureType)value, name);
			else if (value instanceof ParameterizedTextureType)
				cityGMLBase = toCityGML((ParameterizedTextureType)value, name);
			else if (value instanceof X3DMaterialType)
				cityGMLBase = toCityGML((X3DMaterialType)value, name);
			else if (value instanceof AbstractTextureType)
				cityGMLBase = toCityGML((AbstractTextureType)value, name);
			else if (value instanceof AbstractSurfaceDataType)
				cityGMLBase = toCityGML((AbstractSurfaceDataType)value, name);
		}

		return cityGMLBase;
	}

	public JAXBElement<?> toJAXB(CityGMLBase cityGML) {
		JAXBElement<?> jaxbElem = null;
		
		if (cityGML instanceof GeoreferencedTexture)
			jaxbElem = toJAXB((GeoreferencedTexture)cityGML);
		else if (cityGML instanceof ParameterizedTexture)
			jaxbElem = toJAXB((ParameterizedTexture)cityGML);	
		else if (cityGML instanceof X3DMaterial)
			jaxbElem = toJAXB((X3DMaterial)cityGML);
		else if (cityGML instanceof AbstractTexture)
			jaxbElem = toJAXB((AbstractTexture)cityGML);
		else if (cityGML instanceof AbstractSurfaceData)
			jaxbElem = toJAXB((AbstractSurfaceData)cityGML);
		
		return jaxbElem;
	}

}
