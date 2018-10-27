/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citygml4j.builder.jaxb.unmarshal.citygml.appearance;

import net.opengis.citygml.appearance._1.AbstractSurfaceDataType;
import net.opengis.citygml.appearance._1.AbstractTextureParameterizationType;
import net.opengis.citygml.appearance._1.AbstractTextureType;
import net.opengis.citygml.appearance._1.AppearancePropertyType;
import net.opengis.citygml.appearance._1.AppearanceType;
import net.opengis.citygml.appearance._1.GeoreferencedTextureType;
import net.opengis.citygml.appearance._1.ParameterizedTextureType;
import net.opengis.citygml.appearance._1.SurfaceDataPropertyType;
import net.opengis.citygml.appearance._1.TexCoordGenType;
import net.opengis.citygml.appearance._1.TexCoordListType;
import net.opengis.citygml.appearance._1.TextureAssociationType;
import net.opengis.citygml.appearance._1.TextureTypeType;
import net.opengis.citygml.appearance._1.WrapModeType;
import net.opengis.citygml.appearance._1.X3DMaterialType;
import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.CityGMLUnmarshaller;
import org.citygml4j.geometry.Matrix;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.citygml.ade.generic.ADEGenericElement;
import org.citygml4j.model.citygml.appearance.AbstractSurfaceData;
import org.citygml4j.model.citygml.appearance.AbstractTexture;
import org.citygml4j.model.citygml.appearance.AbstractTextureParameterization;
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
import org.citygml4j.model.citygml.appearance.TextureType;
import org.citygml4j.model.citygml.appearance.WorldToTexture;
import org.citygml4j.model.citygml.appearance.WrapMode;
import org.citygml4j.model.citygml.appearance.X3DMaterial;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.xlink.XLinkActuate;
import org.citygml4j.model.gml.xlink.XLinkShow;
import org.citygml4j.model.gml.xlink.XLinkType;
import org.citygml4j.model.module.citygml.AppearanceModule;
import org.citygml4j.util.mapper.CheckedTypeMapper;
import org.citygml4j.xml.io.reader.MissingADESchemaException;
import org.w3c.dom.Element;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Appearance100Unmarshaller {
	private final ReentrantLock lock = new ReentrantLock();
	private final AppearanceModule module = AppearanceModule.v1_0_0;
	private final JAXBUnmarshaller jaxb;
	private final CityGMLUnmarshaller citygml;
	private CheckedTypeMapper<CityGML> typeMapper;

	public Appearance100Unmarshaller(CityGMLUnmarshaller citygml) {
		this.citygml = citygml;
		jaxb = citygml.getJAXBUnmarshaller();
	}

	private CheckedTypeMapper<CityGML> getTypeMapper() {
		if (typeMapper == null) {
			lock.lock();
			try {
				if (typeMapper == null) {
					typeMapper = CheckedTypeMapper.<CityGML>create()
							.with(AppearanceType.class, this::unmarshalAppearance)
							.with(AppearancePropertyType.class, this::unmarshalAppearanceProperty)
							.with(GeoreferencedTextureType.class, this::unmarshalGeoreferencedTexture)
							.with(ParameterizedTextureType.class, this::unmarshalParameterizedTexture)
							.with(SurfaceDataPropertyType.class, this::unmarshalSurfaceDataProperty)
							.with(TexCoordGenType.class, this::unmarshalTexCoordGen)
							.with(TexCoordListType.class, this::unmarshalTexCoordList)
							.with(TextureAssociationType.class, this::unmarshalTextureAssociation)
							.with(TexCoordListType.TextureCoordinates.class, this::unmarshalTextureCoordinates)
							.with(TextureTypeType.class, this::unmarshalTextureType)
							.with(TexCoordGenType.WorldToTexture.class, this::unmarshalWorldToTexture)
							.with(WrapModeType.class, this::unmarshalWrapMode)
							.with(X3DMaterialType.class, this::unmarshalX3DMaterial)
							.with(JAXBElement.class, this::unmarshal);
				}
			} finally {
				lock.unlock();
			}
		}

		return typeMapper;
	}

	public CityGML unmarshal(JAXBElement<?> src) throws MissingADESchemaException {
		return unmarshal(src.getValue());
	}

	public CityGML unmarshal(Object src) throws MissingADESchemaException {
		return getTypeMapper().apply(src);
	}

	public void unmarshalAbstractSurfaceData(AbstractSurfaceDataType src, AbstractSurfaceData dest) throws MissingADESchemaException {
		jaxb.getGMLUnmarshaller().unmarshalAbstractFeature(src, dest);

		if (src.isSetIsFront())
			dest.setIsFront(src.isIsFront());

		if (src.isSet_GenericApplicationPropertyOfSurfaceData()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfSurfaceData()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfSurfaceData(ade);
			}
		}
	}

	public void unmarshalAbstractTexture(AbstractTextureType src, AbstractTexture dest) throws MissingADESchemaException {
		unmarshalAbstractSurfaceData(src, dest);

		if (src.isSetImageURI())
			dest.setImageURI(src.getImageURI());

		if (src.isSetMimeType())
			dest.setMimeType(new Code(src.getMimeType()));

		if (src.isSetTextureType())
			dest.setTextureType(unmarshalTextureType(src.getTextureType()));

		if (src.isSetWrapMode())
			dest.setWrapMode(unmarshalWrapMode(src.getWrapMode()));

		if (src.isSetBorderColor())
			dest.setBorderColor(unmarshalColorPlusOpacity(src.getBorderColor()));

		if (src.isSet_GenericApplicationPropertyOfTexture()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfTexture()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfTexture(ade);
			}
		}
	}

	public void unmarshalAbstractTextureParameterization(AbstractTextureParameterizationType src, AbstractTextureParameterization dest) throws MissingADESchemaException {
		jaxb.getGMLUnmarshaller().unmarshalAbstractGML(src, dest);

		if (src.isSet_ADEComponent()) {
			for (Element dom : src.get_ADEComponent())
				dest.addGenericADEElement(jaxb.getADEUnmarshaller().unmarshal(dom));
		}

		if (src.isSet_GenericApplicationPropertyOfTextureParameterization()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfTextureParameterization()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfTextureParameterization(ade);
			}
		}
	}

	public void unmarshalAppearance(AppearanceType src, Appearance dest) throws MissingADESchemaException {
		jaxb.getGMLUnmarshaller().unmarshalAbstractFeature(src, dest);

		if (src.isSetTheme())
			dest.setTheme(src.getTheme());

		if (src.isSetSurfaceDataMember()) {
			for (SurfaceDataPropertyType surfaceDataMember : src.getSurfaceDataMember())
				dest.addSurfaceDataMember(unmarshalSurfaceDataProperty(surfaceDataMember));
		}

		if (src.isSet_GenericApplicationPropertyOfAppearance()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfAppearance()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfAppearance(ade);
			}
		}
	}

	public Appearance unmarshalAppearance(AppearanceType src) throws MissingADESchemaException {
		Appearance dest = new Appearance(module);
		unmarshalAppearance(src, dest);

		return dest;
	}

	public AppearanceMember unmarshalAppearanceMember(AppearancePropertyType src) throws MissingADESchemaException {
		AppearanceMember dest = new AppearanceMember(module);
		unmarshalAppearanceProperty(src, dest);

		return dest;
	}

	public void unmarshalAppearanceProperty(AppearancePropertyType src, AppearanceProperty dest) throws MissingADESchemaException {
		jaxb.getGMLUnmarshaller().unmarshalFeatureProperty(src, dest);

		if (src.isSetAppearance())
			dest.setAppearance(unmarshalAppearance(src.getAppearance()));

		if (src.isSet_Feature()) {
			ModelObject abstractFeature = jaxb.unmarshal(src.get_Feature());
			if (abstractFeature instanceof Appearance)
				dest.setFeature((Appearance)abstractFeature);
		}
	}

	public AppearanceProperty unmarshalAppearanceProperty(AppearancePropertyType src) throws MissingADESchemaException {
		AppearanceProperty dest = new AppearanceProperty(module);
		unmarshalAppearanceProperty(src, dest);

		return dest;
	}

	public Color unmarshalColor(List<Double> src) {
		Color dest = new Color(module);
		dest.setColor(src);

		return dest;
	}

	public ColorPlusOpacity unmarshalColorPlusOpacity(List<Double> src) {
		ColorPlusOpacity dest = new ColorPlusOpacity(module);
		dest.setColorPlusOpacity(src);

		return dest;
	}

	public void unmarshalGeoreferencedTexture(GeoreferencedTextureType src, GeoreferencedTexture dest) throws MissingADESchemaException {
		unmarshalAbstractTexture(src, dest);

		if (src.isSetPreferWorldFile())
			dest.setPreferWorldFile(src.isPreferWorldFile());

		if (src.isSetReferencePoint())
			dest.setReferencePoint(jaxb.getGMLUnmarshaller().unmarshalPointProperty(src.getReferencePoint()));

		if (src.isSetOrientation())
			dest.setOrientation(citygml.getCore100Unmarshaller().unmarshalTransformationMatrix2x2(src.getOrientation()));

		if (src.isSetTarget())
			dest.setTarget(src.getTarget());

		if (src.isSet_GenericApplicationPropertyOfGeoreferencedTexture()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfGeoreferencedTexture()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfGeoreferencedTexture(ade);
			}
		}
	}

	public GeoreferencedTexture unmarshalGeoreferencedTexture(GeoreferencedTextureType src) throws MissingADESchemaException {
		GeoreferencedTexture dest = new GeoreferencedTexture(module);
		unmarshalGeoreferencedTexture(src, dest);

		return dest;
	}

	public void unmarshalParameterizedTexture(ParameterizedTextureType src, ParameterizedTexture dest) throws MissingADESchemaException {
		unmarshalAbstractTexture(src, dest);

		if (src.isSetTarget()) {
			for (TextureAssociationType textureAssociation : src.getTarget()) 
				dest.addTarget(unmarshalTextureAssociation(textureAssociation));
		}

		if (src.isSet_GenericApplicationPropertyOfParameterizedTexture()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfParameterizedTexture()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfParameterizedTexture(ade);
			}
		}
	}

	public ParameterizedTexture unmarshalParameterizedTexture(ParameterizedTextureType src) throws MissingADESchemaException {
		ParameterizedTexture dest = new ParameterizedTexture(module);
		unmarshalParameterizedTexture(src, dest);

		return dest;
	}

	public SurfaceDataProperty unmarshalSurfaceDataProperty(SurfaceDataPropertyType src) throws MissingADESchemaException {
		SurfaceDataProperty dest = new SurfaceDataProperty(module);

		if (src.isSet_SurfaceData()) {
			ModelObject surfaceData = jaxb.unmarshal(src.get_SurfaceData());
			if (surfaceData instanceof AbstractSurfaceData)
				dest.setSurfaceData((AbstractSurfaceData)surfaceData);
		}

		if (src.isSet_ADEComponent())
			dest.setGenericADEElement(jaxb.getADEUnmarshaller().unmarshal(src.get_ADEComponent()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));

		return dest;
	}

	public void unmarshalTexCoordGen(TexCoordGenType src, TexCoordGen dest) throws MissingADESchemaException {
		unmarshalAbstractTextureParameterization(src, dest);

		if (src.isSetWorldToTexture())
			dest.setWorldToTexture(unmarshalWorldToTexture(src.getWorldToTexture()));

		if (src.isSet_GenericApplicationPropertyOfTexCoordGen()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfTexCoordGen()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfTexCoordGen(ade);
			}
		}
	}

	public TexCoordGen unmarshalTexCoordGen(TexCoordGenType src) throws MissingADESchemaException {
		TexCoordGen dest = new TexCoordGen(module);
		unmarshalTexCoordGen(src, dest);

		return dest;
	}

	public void unmarshalTexCoordList(TexCoordListType src, TexCoordList dest) throws MissingADESchemaException {
		unmarshalAbstractTextureParameterization(src, dest);

		if (src.isSetTextureCoordinates()) {
			for (TexCoordListType.TextureCoordinates textureCoordinates : src.getTextureCoordinates())
				dest.addTextureCoordinates(unmarshalTextureCoordinates(textureCoordinates));
		}

		if (src.isSet_GenericApplicationPropertyOfTexCoordList()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfTexCoordList()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfTexCoordList(ade);
			}
		}
	}	

	public TexCoordList unmarshalTexCoordList(TexCoordListType src) throws MissingADESchemaException {
		TexCoordList dest = new TexCoordList(module);
		unmarshalTexCoordList(src, dest);

		return dest;
	}

	public TextureAssociation unmarshalTextureAssociation(TextureAssociationType src) throws MissingADESchemaException {
		TextureAssociation dest = new TextureAssociation(module);

		if (src.isSet_TextureParameterization()) {
			ModelObject textureParameterization = jaxb.unmarshal(src.get_TextureParameterization());
			if (textureParameterization instanceof AbstractTextureParameterization)
				dest.setTextureParameterization((AbstractTextureParameterization)textureParameterization);
		}

		if (src.isSetUri())
			dest.setUri(src.getUri());

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));

		return dest;			
	}

	public void unmarshalTextureCoordinates(TexCoordListType.TextureCoordinates src, TextureCoordinates dest) {
		if (src.isSetRing())
			dest.setRing(src.getRing());

		if (src.isSetValue())
			dest.setValue(src.getValue());
	}

	public TextureCoordinates unmarshalTextureCoordinates(TexCoordListType.TextureCoordinates src) {
		TextureCoordinates dest = new TextureCoordinates(module);
		unmarshalTextureCoordinates(src, dest);

		return dest;
	}

	public TextureType unmarshalTextureType(TextureTypeType src) {
		return TextureType.fromValue(src.value());
	}

	public void unmarshalWorldToTexture(TexCoordGenType.WorldToTexture src, WorldToTexture dest) {
		if (src.isSetValue()) {
			try {
				Matrix matrix = new Matrix(3, 4);
				matrix.setMatrix(src.getValue());
				dest.setMatrix(matrix);
			} catch (IllegalArgumentException e) {
				//
			}
		}

		if (src.isSetSrsName())
			dest.setSrsName(src.getSrsName());

		if (src.isSetSrsDimension())
			dest.setSrsDimension(src.getSrsDimension().intValue());

		if (src.isSetAxisLabels())
			dest.setAxisLabels(src.getAxisLabels());

		if (src.isSetUomLabels())
			dest.setUomLabels(src.getUomLabels());
	}

	public WorldToTexture unmarshalWorldToTexture(TexCoordGenType.WorldToTexture src) {
		WorldToTexture dest = new WorldToTexture(module);
		unmarshalWorldToTexture(src, dest);

		return dest;
	}

	public WrapMode unmarshalWrapMode(WrapModeType src) {
		return WrapMode.fromValue(src.value());
	}

	public void unmarshalX3DMaterial(X3DMaterialType src, X3DMaterial dest) throws MissingADESchemaException {
		unmarshalAbstractSurfaceData(src, dest);

		if (src.isSetAmbientIntensity())
			dest.setAmbientIntensity(src.getAmbientIntensity());

		if (src.isSetDiffuseColor())
			dest.setDiffuseColor(unmarshalColor(src.getDiffuseColor()));

		if (src.isSetEmissiveColor())
			dest.setEmissiveColor(unmarshalColor(src.getEmissiveColor()));

		if (src.isSetSpecularColor())
			dest.setSpecularColor(unmarshalColor(src.getSpecularColor()));

		if (src.isSetShininess())
			dest.setShininess(src.getShininess());

		if (src.isSetTransparency())
			dest.setTransparency(src.getTransparency());

		if (src.isSetIsSmooth())
			dest.setIsSmooth(src.isIsSmooth());

		if (src.isSetTarget())
			dest.setTarget(src.getTarget());

		if (src.isSet_GenericApplicationPropertyOfX3DMaterial()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfX3DMaterial()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfX3DMaterial(ade);
			}
		}
	}

	public X3DMaterial unmarshalX3DMaterial(X3DMaterialType src) throws MissingADESchemaException {
		X3DMaterial dest = new X3DMaterial(module);
		unmarshalX3DMaterial(src, dest);

		return dest;
	}

	public boolean assignGenericProperty(ADEGenericElement genericProperty, QName substitutionGroup, CityGML dest) {
		String name = substitutionGroup.getLocalPart();
		boolean success = true;

		if (dest instanceof AbstractSurfaceData && name.equals("_GenericApplicationPropertyOfSurfaceData"))
			((AbstractSurfaceData)dest).addGenericApplicationPropertyOfSurfaceData(genericProperty);
		else if (dest instanceof AbstractTexture && name.equals("_GenericApplicationPropertyOfTexture"))
			((AbstractTexture)dest).addGenericApplicationPropertyOfTexture(genericProperty);
		else if (dest instanceof AbstractTextureParameterization && name.equals("_GenericApplicationPropertyOfTextureParameterization"))
			((AbstractTextureParameterization)dest).addGenericApplicationPropertyOfTextureParameterization(genericProperty);
		else if (dest instanceof Appearance && name.equals("_GenericApplicationPropertyOfAppearance"))
			((Appearance)dest).addGenericApplicationPropertyOfAppearance(genericProperty);
		else if (dest instanceof GeoreferencedTexture && name.equals("_GenericApplicationPropertyOfGeoreferencedTexture"))
			((GeoreferencedTexture)dest).addGenericApplicationPropertyOfGeoreferencedTexture(genericProperty);
		else if (dest instanceof ParameterizedTexture && name.equals("_GenericApplicationPropertyOfParameterizedTexture"))
			((ParameterizedTexture)dest).addGenericApplicationPropertyOfParameterizedTexture(genericProperty);
		else if (dest instanceof TexCoordGen && name.equals("_GenericApplicationPropertyOfTexCoordGen"))
			((TexCoordGen)dest).addGenericApplicationPropertyOfTexCoordGen(genericProperty);
		else if (dest instanceof TexCoordList && name.equals("_GenericApplicationPropertyOfTexCoordList"))
			((TexCoordList)dest).addGenericApplicationPropertyOfTexCoordList(genericProperty);
		else if (dest instanceof X3DMaterial && name.equals("_GenericApplicationPropertyOfX3DMaterial"))
			((X3DMaterial)dest).addGenericApplicationPropertyOfX3DMaterial(genericProperty);
		else
			success = false;

		return success;
	}

}
