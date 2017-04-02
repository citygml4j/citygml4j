/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright 2013-2017 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml4j.builder.jaxb.marshal.citygml.appearance;

import java.math.BigInteger;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.ade.generic.ADEGenericElement;
import org.citygml4j.model.citygml.appearance.AbstractSurfaceData;
import org.citygml4j.model.citygml.appearance.AbstractTexture;
import org.citygml4j.model.citygml.appearance.AbstractTextureParameterization;
import org.citygml4j.model.citygml.appearance.Appearance;
import org.citygml4j.model.citygml.appearance.AppearanceMember;
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
import org.w3._1999.xlink.ActuateType;
import org.w3._1999.xlink.ShowType;
import org.w3._1999.xlink.TypeType;
import org.w3c.dom.Element;

import net.opengis.citygml.appearance._2.AbstractSurfaceDataType;
import net.opengis.citygml.appearance._2.AbstractTextureParameterizationType;
import net.opengis.citygml.appearance._2.AbstractTextureType;
import net.opengis.citygml.appearance._2.AppearancePropertyElement;
import net.opengis.citygml.appearance._2.AppearancePropertyType;
import net.opengis.citygml.appearance._2.AppearanceType;
import net.opengis.citygml.appearance._2.GeoreferencedTextureType;
import net.opengis.citygml.appearance._2.ObjectFactory;
import net.opengis.citygml.appearance._2.ParameterizedTextureType;
import net.opengis.citygml.appearance._2.SurfaceDataPropertyType;
import net.opengis.citygml.appearance._2.TexCoordGenType;
import net.opengis.citygml.appearance._2.TexCoordListType;
import net.opengis.citygml.appearance._2.TextureAssociationType;
import net.opengis.citygml.appearance._2.TextureTypeType;
import net.opengis.citygml.appearance._2.WrapModeType;
import net.opengis.citygml.appearance._2.X3DMaterialType;
import net.opengis.gml.FeaturePropertyType;

public class Appearance200Marshaller {
	private final ObjectFactory app = new ObjectFactory();
	private final JAXBMarshaller jaxb;
	private final CityGMLMarshaller citygml;

	public Appearance200Marshaller(CityGMLMarshaller citygml) {
		this.citygml = citygml;
		jaxb = citygml.getJAXBMarshaller();
	}

	public JAXBElement<?> marshalJAXBElement(Object src) {
		JAXBElement<?> dest = null;
		AppearanceModuleComponent orig = null;

		if (src instanceof AppearanceModuleComponent) {
			orig = (AppearanceModuleComponent)src;
			src = marshal(orig);
		}

		if (src instanceof AppearanceType)
			dest = app.createAppearance((AppearanceType)src);
		else if (src instanceof FeaturePropertyType && orig instanceof AppearanceMember)
			dest = app.createAppearanceMember((FeaturePropertyType)src);
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
		else if (src instanceof AppearanceMember)
			dest = marshalAppearanceMember((AppearanceMember)src);
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
		else if (src instanceof TextureType)
			dest = marshalTextureType((TextureType)src);
		else if (src instanceof WorldToTexture)
			dest = marshalWorldToTexture((WorldToTexture)src);			
		else if (src instanceof WrapMode)
			dest = marshalWrapMode((WrapMode)src);
		else if (src instanceof X3DMaterial)
			dest = marshalX3DMaterial((X3DMaterial)src);			

		return dest;
	}

	public void marshalAbstractSurfaceData(AbstractSurfaceData src, AbstractSurfaceDataType dest) {
		jaxb.getGMLMarshaller().marshalAbstractFeature(src, dest);

		if (src.isSetIsFront())
			dest.setIsFront(src.getIsFront());

		if (src.isSetGenericApplicationPropertyOfSurfaceData()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfSurfaceData()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfSurfaceData().add(jaxbElement);
			}
		}
	}

	public void marshalAbstractTexture(AbstractTexture src, AbstractTextureType dest) {
		marshalAbstractSurfaceData(src, dest);

		if (src.isSetImageURI())
			dest.setImageURI(src.getImageURI());

		if (src.isSetMimeType())
			dest.setMimeType(jaxb.getGMLMarshaller().marshalCode(src.getMimeType()));

		if (src.isSetTextureType())
			dest.setTextureType(marshalTextureType(src.getTextureType()));

		if (src.isSetWrapMode())
			dest.setWrapMode(marshalWrapMode(src.getWrapMode()));

		if (src.isSetBorderColor())
			dest.setBorderColor(marshalColorPlusOpacity(src.getBorderColor()));

		if (src.isSetGenericApplicationPropertyOfTexture()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfTexture()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfTexture().add(jaxbElement);
			}
		}
	}

	public void marshalAbstractTextureParameterization(AbstractTextureParameterization src, AbstractTextureParameterizationType dest) {
		jaxb.getGMLMarshaller().marshalAbstractGML(src, dest);

		if (src.isSetGenericApplicationPropertyOfTextureParameterization()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfTextureParameterization()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfTextureParameterization().add(jaxbElement);
			}
		}

		if (src.isSetGenericADEComponent()) {
			for (ADEGenericElement genericADEElement : src.getGenericADEElement()) {
				Element element = jaxb.getADEMarshaller().marshalDOMElement(genericADEElement);
				if (element != null)
					dest.get_ADEComponent().add(element);
			}
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
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfAppearance()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfAppearance().add(jaxbElement);
			}
		}
	}

	public AppearanceType marshalAppearance(Appearance src) {
		AppearanceType dest = app.createAppearanceType();
		marshalAppearance(src, dest);

		return dest;
	}

	@SuppressWarnings("unchecked")
	public void marshalAppearanceProperty(AppearanceProperty src, AppearancePropertyType dest) {
		if (src.isSetAppearance()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getAppearance());
			if (elem != null && elem.getValue() instanceof AppearanceType)
				dest.set_Feature((JAXBElement<? extends AppearanceType>)elem);
		}
		
		if (src.isSetGenericADEElement()) {
			Element element = jaxb.getADEMarshaller().marshalDOMElement(src.getGenericADEElement());
			if (element != null)
				dest.set_ADEComponent(element);
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
	}

	public AppearancePropertyType marshalAppearanceProperty(AppearanceProperty src) {
		AppearancePropertyType dest = app.createAppearancePropertyType();
		marshalAppearanceProperty(src, dest);

		return dest;
	}
	
	public FeaturePropertyType marshalAppearanceMember(AppearanceMember src) {
		return jaxb.getGMLMarshaller().marshalFeatureProperty(src);
	}
	
	public AppearancePropertyElement marshalAppearancePropertyElement(AppearanceProperty src) {
		AppearancePropertyType dest = app.createAppearancePropertyType();
		marshalAppearanceProperty(src, dest);

		return new AppearancePropertyElement(dest);
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
			dest.setOrientation(citygml.getCore200Marshaller().marshalTransformationMatrix2x2(src.getOrientation()));

		if (src.isSetTarget())
			dest.setTarget(src.getTarget());

		if (src.isSetGenericApplicationPropertyOfGeoreferencedTexture()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfGeoreferencedTexture()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfGeoreferencedTexture().add(jaxbElement);
			}
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
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfParameterizedTexture()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfParameterizedTexture().add(jaxbElement);
			}
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

		if (src.isSetGenericADEElement()) {
			Element element = jaxb.getADEMarshaller().marshalDOMElement(src.getGenericADEElement());
			if (element != null)
				dest.set_ADEComponent(element);
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
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfTexCoordGen()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfTexCoordGen().add(jaxbElement);
			}
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
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfTexCoordList()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfTexCoordList().add(jaxbElement);
			}
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
			dest.setValue(citygml.getCore200Marshaller().marshalTransformationMatrix3x4(src));

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
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfX3DMaterial()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfX3DMaterial().add(jaxbElement);
			}
		}
	}

	public X3DMaterialType marshalX3DMaterial(X3DMaterial src) {
		X3DMaterialType dest = app.createX3DMaterialType();
		marshalX3DMaterial(src, dest);

		return dest;
	}

}
