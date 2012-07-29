/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universitaet Berlin, Germany
 * http://www.igg.tu-berlin.de/
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package org.citygml4j.builder.jaxb.marshal.citygml.appearance;

import java.math.BigInteger;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.jaxb.citygml.app._1.AbstractSurfaceDataType;
import org.citygml4j.jaxb.citygml.app._1.AbstractTextureParameterizationType;
import org.citygml4j.jaxb.citygml.app._1.AbstractTextureType;
import org.citygml4j.jaxb.citygml.app._1.AppearancePropertyType;
import org.citygml4j.jaxb.citygml.app._1.AppearanceType;
import org.citygml4j.jaxb.citygml.app._1.GeoreferencedTextureType;
import org.citygml4j.jaxb.citygml.app._1.ObjectFactory;
import org.citygml4j.jaxb.citygml.app._1.ParameterizedTextureType;
import org.citygml4j.jaxb.citygml.app._1.SurfaceDataPropertyType;
import org.citygml4j.jaxb.citygml.app._1.TexCoordGenType;
import org.citygml4j.jaxb.citygml.app._1.TexCoordListType;
import org.citygml4j.jaxb.citygml.app._1.TextureAssociationType;
import org.citygml4j.jaxb.citygml.app._1.TextureTypeType;
import org.citygml4j.jaxb.citygml.app._1.WrapModeType;
import org.citygml4j.jaxb.citygml.app._1.X3DMaterialType;
import org.citygml4j.jaxb.xlink.ActuateType;
import org.citygml4j.jaxb.xlink.ShowType;
import org.citygml4j.jaxb.xlink.TypeType;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.appearance.AbstractSurfaceData;
import org.citygml4j.model.citygml.appearance.AbstractTexture;
import org.citygml4j.model.citygml.appearance.AbstractTextureParameterization;
import org.citygml4j.model.citygml.appearance.Appearance;
import org.citygml4j.model.citygml.appearance.AppearanceModuleComponent;
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
import org.citygml4j.model.citygml.appearance.TextureType;
import org.citygml4j.model.citygml.appearance.WorldToTexture;
import org.citygml4j.model.citygml.appearance.WrapMode;
import org.citygml4j.model.citygml.appearance.X3DMaterial;
import org.citygml4j.model.common.base.ModelObject;

public class Appearance100Marshaller {
	private final ObjectFactory app = new ObjectFactory();
	private final JAXBMarshaller jaxb;
	private final CityGMLMarshaller citygml;

	public Appearance100Marshaller(CityGMLMarshaller citygml) {
		this.citygml = citygml;
		jaxb = citygml.getJAXBMarshaller();
	}

	public JAXBElement<?> marshalJAXBElement(Object src) {
		JAXBElement<?> dest = null;

		if (src instanceof AppearanceModuleComponent)
			src = marshal((AppearanceModuleComponent)src);

		if (src instanceof AppearancePropertyType)
			dest = app.createAppearanceMember((AppearancePropertyType)src);
		else if (src instanceof GeoreferencedTextureType)
			dest = app.createGeoreferencedTexture((GeoreferencedTextureType)src);
		else if (src instanceof ParameterizedTextureType)
			dest = app.createParameterizedTexture((ParameterizedTextureType)src);
		else if (src instanceof TexCoordGenType)
			dest = app.createTexCoordGen((TexCoordGenType)src);		
		else if (src instanceof TexCoordListType)
			dest = app.createTexCoordList((TexCoordListType)src);
		else if (src instanceof X3DMaterialType)
			dest = app.createX3DMaterial((X3DMaterialType)src);	

		return dest;
	}

	public Object marshal(ModelObject src) {
		Object dest = null;

		if (src instanceof Appearance)
			dest = marshalAppearance((Appearance)src);			
		else if (src instanceof AppearanceProperty)
			dest = marshalAppearanceProperty((AppearanceProperty)src);
		else if (src instanceof GeoreferencedTexture)
			dest = marshalGeoreferencedTexture((GeoreferencedTexture)src);
		else if (src instanceof ParameterizedTexture)
			dest = marshalParameterizedTexture((ParameterizedTexture)src);
		else if (src instanceof SurfaceDataProperty)
			dest = marshalSurfaceDataProperty((SurfaceDataProperty)src);
		else if (src instanceof TexCoordGen)
			dest = marshalTexCoordGen((TexCoordGen)src);
		else if (src instanceof TexCoordList)
			dest = marshalTexCoordList((TexCoordList)src);
		else if (src instanceof TextureAssociation)
			dest = marshalTextureAssociation((TextureAssociation)src);
		else if (src instanceof TextureCoordinates)
			dest = marshalTextureCoordinates((TextureCoordinates)src);			
		else if (src instanceof WorldToTexture)
			dest = marshalWorldToTexture((WorldToTexture)src);			
		else if (src instanceof X3DMaterial)
			dest = marshalX3DMaterial((X3DMaterial)src);
		else if (src instanceof TextureType)
			dest = marshalTextureType((TextureType)src);
		else if (src instanceof WrapMode)
			dest = marshalWrapMode((WrapMode)src);

		return dest;
	}

	public void marshalAbstractSurfaceData(AbstractSurfaceData src, AbstractSurfaceDataType dest) {
		jaxb.getGMLMarshaller().marshalAbstractFeature(src, dest);

		if (src.isSetIsFront())
			dest.setIsFront(src.getIsFront());

		if (src.isSetGenericApplicationPropertyOfSurfaceData()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfSurfaceData())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfSurfaceData().add(citygml.ade2jaxbElement(adeComponent));
		}
	}

	public void marshalAbstractTexture(AbstractTexture src, AbstractTextureType dest) {
		marshalAbstractSurfaceData(src, dest);

		if (src.isSetImageURI())
			dest.setImageURI(src.getImageURI());

		if (src.isSetMimeType())
			dest.setMimeType(src.getMimeType().getValue());

		if (src.isSetTextureType())
			dest.setTextureType(marshalTextureType(src.getTextureType()));

		if (src.isSetWrapMode())
			dest.setWrapMode(marshalWrapMode(src.getWrapMode()));

		if (src.isSetBorderColor())
			dest.setBorderColor(marshalColorPlusOpacity(src.getBorderColor()));

		if (src.isSetGenericApplicationPropertyOfTexture()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfTexture())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfTexture().add(citygml.ade2jaxbElement(adeComponent));
		}
	}

	public void marshalAbstractTextureParameterization(AbstractTextureParameterization src, AbstractTextureParameterizationType dest) {
		jaxb.getGMLMarshaller().marshalAbstractGML(src, dest);

		if (src.isSetGenericApplicationPropertyOfTextureParameterization()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfTextureParameterization())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfTextureParameterization().add(citygml.ade2jaxbElement(adeComponent));
		}

		if (src.isSetGenericADEComponent()) {
			for (ADEComponent adeComponent : src.getGenericADEComponent())
				if (adeComponent.isSetContent())
					dest.get_ADEComponent().add(adeComponent.getContent());
		}
	}

	public void marshalAppearance(Appearance src, AppearanceType dest) {
		jaxb.getGMLMarshaller().marshalAbstractFeature(src, dest);

		if (src.isSetTheme())
			dest.setTheme(src.getTheme());

		if (src.isSetSurfaceDataMember()) {
			for (SurfaceDataProperty surfaceDataMember : src.getSurfaceDataMember())
				dest.getSurfaceDataMember().add(marshalSurfaceDataProperty(surfaceDataMember));
		}

		if (src.isSetGenericApplicationPropertyOfAppearance()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfAppearance())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfAppearance().add(citygml.ade2jaxbElement(adeComponent));
		}
	}

	public AppearanceType marshalAppearance(Appearance src) {
		AppearanceType dest = app.createAppearanceType();
		marshalAppearance(src, dest);

		return dest;
	}

	public AppearancePropertyType marshalAppearanceProperty(AppearanceProperty src) {
		AppearancePropertyType dest = app.createAppearancePropertyType();
		jaxb.getGMLMarshaller().marshalFeatureProperty(src, dest);

		if (src.isSetAppearance())
			dest.setAppearance(marshalAppearance(src.getAppearance()));
		
		return dest;
	}

	public List<Double> marshalColor(Color src) {
		return src.toList();
	}

	public List<Double> marshalColorPlusOpacity(ColorPlusOpacity src) {
		return src.toList();
	}

	public void marshalGeoreferencedTexture(GeoreferencedTexture src, GeoreferencedTextureType dest) {
		marshalAbstractTexture(src, dest);

		if (src.isSetPreferWorldFile())
			dest.setPreferWorldFile(src.getPreferWorldFile());

		if (src.isSetReferencePoint())
			dest.setReferencePoint(jaxb.getGMLMarshaller().marshalPointProperty(src.getReferencePoint()));

		if (src.isSetOrientation())
			dest.setOrientation(citygml.getCore100Marshaller().marshalTransformationMatrix2x2(src.getOrientation()));

		if (src.isSetTarget())
			dest.setTarget(src.getTarget());

		if (src.isSetGenericApplicationPropertyOfGeoreferencedTexture()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfGeoreferencedTexture())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfGeoreferencedTexture().add(citygml.ade2jaxbElement(adeComponent));
		}
	}

	public GeoreferencedTextureType marshalGeoreferencedTexture(GeoreferencedTexture src) {
		GeoreferencedTextureType dest = app.createGeoreferencedTextureType();
		marshalGeoreferencedTexture(src, dest);

		return dest;
	}

	public void marshalParameterizedTexture(ParameterizedTexture src, ParameterizedTextureType dest) {
		marshalAbstractTexture(src, dest);

		if (src.isSetTarget()) {
			for (TextureAssociation textureAssociation : src.getTarget()) 
				dest.getTarget().add(marshalTextureAssociation(textureAssociation));
		}

		if (src.isSetGenericApplicationPropertyOfParameterizedTexture()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfParameterizedTexture())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfParameterizedTexture().add(citygml.ade2jaxbElement(adeComponent));
		}
	}

	public ParameterizedTextureType marshalParameterizedTexture(ParameterizedTexture src) {
		ParameterizedTextureType dest = app.createParameterizedTextureType();
		marshalParameterizedTexture(src, dest);

		return dest;
	}	

	@SuppressWarnings("unchecked")
	public SurfaceDataPropertyType marshalSurfaceDataProperty(SurfaceDataProperty src) {
		SurfaceDataPropertyType dest = app.createSurfaceDataPropertyType();

		if (src.isSetSurfaceData()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getSurfaceData());
			if (elem != null && elem.getValue() instanceof AbstractSurfaceDataType)
				dest.set_SurfaceData((JAXBElement<? extends AbstractSurfaceDataType>)elem);
		}

		if (src.isSetGenericADEComponent()) {
			ADEComponent adeComponent = src.getGenericADEComponent();
			if (adeComponent.isSetContent())
				dest.set_ADEComponent(adeComponent.getContent());
		}

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

		return dest;
	}

	public void marshalTexCoordGen(TexCoordGen src, TexCoordGenType dest) {
		marshalAbstractTextureParameterization(src, dest);

		if (src.isSetWorldToTexture())
			dest.setWorldToTexture(marshalWorldToTexture(src.getWorldToTexture()));

		if (src.isSetGenericApplicationPropertyOfTexCoordGen()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfTexCoordGen())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfTexCoordGen().add(citygml.ade2jaxbElement(adeComponent));
		}
	}

	public TexCoordGenType marshalTexCoordGen(TexCoordGen src) {
		TexCoordGenType dest = app.createTexCoordGenType();
		marshalTexCoordGen(src, dest);

		return dest;
	}

	public void marshalTexCoordList(TexCoordList src, TexCoordListType dest) {
		marshalAbstractTextureParameterization(src, dest);

		if (src.isSetTextureCoordinates()) {
			for (TextureCoordinates textureCoordinates : src.getTextureCoordinates())
				dest.getTextureCoordinates().add(marshalTextureCoordinates(textureCoordinates));
		}

		if (src.isSetGenericApplicationPropertyOfTexCoordList()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfTexCoordList())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfTexCoordList().add(citygml.ade2jaxbElement(adeComponent));
		}
	}	

	public TexCoordListType marshalTexCoordList(TexCoordList src) {
		TexCoordListType dest = app.createTexCoordListType();
		marshalTexCoordList(src, dest);

		return dest;
	}

	@SuppressWarnings("unchecked")
	public TextureAssociationType marshalTextureAssociation(TextureAssociation src) {
		TextureAssociationType dest = app.createTextureAssociationType();

		if (src.isSetTextureParameterization()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getTextureParameterization());
			if (elem != null && elem.getValue() instanceof AbstractTextureParameterizationType)
				dest.set_TextureParameterization((JAXBElement<? extends AbstractTextureParameterizationType>)elem);
		}

		if (src.isSetUri())
			dest.setUri(src.getUri());

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

		return dest;			
	}

	public void marshalTextureCoordinates(TextureCoordinates src, TexCoordListType.TextureCoordinates dest) {
		if (src.isSetRing())
			dest.setRing(src.getRing());

		if (src.isSetValue())
			dest.setValue(src.getValue());
	}

	public TexCoordListType.TextureCoordinates marshalTextureCoordinates(TextureCoordinates src) {
		TexCoordListType.TextureCoordinates dest = app.createTexCoordListTypeTextureCoordinates();
		marshalTextureCoordinates(src, dest);

		return dest;
	}

	public TextureTypeType marshalTextureType(TextureType src) {
		return TextureTypeType.fromValue(src.getValue());
	}

	public void marshalWorldToTexture(WorldToTexture src, TexCoordGenType.WorldToTexture dest) {
		if (src.isSetMatrix())
			dest.setValue(citygml.getCore100Marshaller().marshalTransformationMatrix3x4(src));

		if (src.isSetSrsName())
			dest.setSrsName(src.getSrsName());

		if (src.isSetSrsDimension())
			dest.setSrsDimension(BigInteger.valueOf(src.getSrsDimension()));

		if (src.isSetAxisLabels())
			dest.setAxisLabels(src.getAxisLabels());

		if (src.isSetUomLabels())
			dest.setUomLabels(src.getUomLabels());
	}

	public TexCoordGenType.WorldToTexture marshalWorldToTexture(WorldToTexture src) {
		TexCoordGenType.WorldToTexture dest = app.createTexCoordGenTypeWorldToTexture();
		marshalWorldToTexture(src, dest);

		return dest;
	}

	public WrapModeType marshalWrapMode(WrapMode src) {
		return WrapModeType.fromValue(src.getValue());
	}

	public void marshalX3DMaterial(X3DMaterial src, X3DMaterialType dest) {
		marshalAbstractSurfaceData(src, dest);

		if (src.isSetAmbientIntensity())
			dest.setAmbientIntensity(src.getAmbientIntensity());

		if (src.isSetDiffuseColor())
			dest.setDiffuseColor(marshalColor(src.getDiffuseColor()));

		if (src.isSetEmissiveColor())
			dest.setEmissiveColor(marshalColor(src.getEmissiveColor()));

		if (src.isSetSpecularColor())
			dest.setSpecularColor(marshalColor(src.getSpecularColor()));

		if (src.isSetShininess())
			dest.setShininess(src.getShininess());

		if (src.isSetTransparency())
			dest.setTransparency(src.getTransparency());

		if (src.isSetIsSmooth())
			dest.setIsSmooth(src.getIsSmooth());

		if (src.isSetTarget())
			dest.setTarget(src.getTarget());

		if (src.isSetGenericApplicationPropertyOfX3DMaterial()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfX3DMaterial())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfX3DMaterial().add(citygml.ade2jaxbElement(adeComponent));
		}
	}

	public X3DMaterialType marshalX3DMaterial(X3DMaterial src) {
		X3DMaterialType dest = app.createX3DMaterialType();
		marshalX3DMaterial(src, dest);

		return dest;
	}

}
