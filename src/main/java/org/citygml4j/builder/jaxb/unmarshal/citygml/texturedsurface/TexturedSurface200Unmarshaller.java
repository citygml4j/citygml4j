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
package org.citygml4j.builder.jaxb.unmarshal.citygml.texturedsurface;

import net.opengis.citygml.texturedsurface._2.AbstractAppearanceType;
import net.opengis.citygml.texturedsurface._2.AppearancePropertyType;
import net.opengis.citygml.texturedsurface._2.MaterialType;
import net.opengis.citygml.texturedsurface._2.SimpleTextureType;
import net.opengis.citygml.texturedsurface._2.TextureTypeType;
import net.opengis.citygml.texturedsurface._2.TexturedSurfaceType;
import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.CityGMLUnmarshaller;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.texturedsurface._AbstractAppearance;
import org.citygml4j.model.citygml.texturedsurface._AppearanceProperty;
import org.citygml4j.model.citygml.texturedsurface._Color;
import org.citygml4j.model.citygml.texturedsurface._Material;
import org.citygml4j.model.citygml.texturedsurface._SimpleTexture;
import org.citygml4j.model.citygml.texturedsurface._TextureType;
import org.citygml4j.model.citygml.texturedsurface._TexturedSurface;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.geometry.primitives.Sign;
import org.citygml4j.model.gml.xlink.XLinkActuate;
import org.citygml4j.model.gml.xlink.XLinkShow;
import org.citygml4j.model.gml.xlink.XLinkType;
import org.citygml4j.model.module.citygml.TexturedSurfaceModule;
import org.citygml4j.util.mapper.CheckedTypeMapper;
import org.citygml4j.xml.io.reader.MissingADESchemaException;

import javax.xml.bind.JAXBElement;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class TexturedSurface200Unmarshaller {
	private final ReentrantLock lock = new ReentrantLock();
	private final TexturedSurfaceModule module = TexturedSurfaceModule.v2_0_0;
	private final JAXBUnmarshaller jaxb;
	private CheckedTypeMapper<CityGML> typeMapper;

	public TexturedSurface200Unmarshaller(CityGMLUnmarshaller citygml) {
		jaxb = citygml.getJAXBUnmarshaller();
	}

	private CheckedTypeMapper<CityGML> getTypeMapper() {
		if (typeMapper == null) {
			lock.lock();
			try {
				if (typeMapper == null) {
					typeMapper = CheckedTypeMapper.<CityGML>create()
							.with(AppearancePropertyType.class, this::unmarshalAppearanceProperty)
							.with(MaterialType.class, this::unmarshalMaterial)
							.with(SimpleTextureType.class, this::unmarshalSimpleTexture)
							.with(TexturedSurfaceType.class, this::unmarshalTexturedSurface)
							.with(TextureTypeType.class, this::unmarshalTextureType)
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

	public void unmarshalAbstractAppearance(AbstractAppearanceType src, _AbstractAppearance dest) {
		jaxb.getGMLUnmarshaller().unmarshalAbstractGML(src, dest);
	}

	public _AppearanceProperty unmarshalAppearanceProperty(AppearancePropertyType src) {
		_AppearanceProperty dest =  new _AppearanceProperty(module);

		if (src.isSetOrientation())
			dest.setOrientation(Sign.fromValue(src.getOrientation()));

		if (src.isSet_Appearance()) {
			try {
				ModelObject appearance = jaxb.unmarshal(src.get_Appearance());
				if (appearance instanceof _AbstractAppearance)
					dest.setAppearance((_AbstractAppearance)appearance);
			} catch (MissingADESchemaException e) {
				//
			}
		}

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

	public _Color unmarshalColor(List<Double> src) {
		_Color  dest = new _Color(module);
		dest.setColor(src);

		return dest;
	}

	public void unmarshalMaterial(MaterialType src, _Material dest) {
		unmarshalAbstractAppearance(src, dest);

		if (src.isSetShininess())
			dest.setShininess(src.getShininess());

		if (src.isSetTransparency())
			dest.setTransparency(src.getTransparency());

		if (src.isSetAmbientIntensity())
			dest.setAmbientIntensity(src.getAmbientIntensity());

		if (src.isSetSpecularColor())
			dest.setSpecularColor(unmarshalColor(src.getSpecularColor()));

		if (src.isSetDiffuseColor())
			dest.setDiffuseColor(unmarshalColor(src.getDiffuseColor()));

		if (src.isSetEmissiveColor())
			dest.setEmissiveColor(unmarshalColor(src.getEmissiveColor()));
	}

	public _Material unmarshalMaterial(MaterialType src) {
		_Material dest = new _Material(module);
		unmarshalMaterial(src, dest);

		return dest;
	}

	public void unmarshalSimpleTexture(SimpleTextureType src, _SimpleTexture dest) {
		unmarshalAbstractAppearance(src, dest);

		if (src.isSetTextureMap())
			dest.setTextureMap(src.getTextureMap());

		if (src.isSetTextureCoordinates())
			dest.setTextureCoordinates(src.getTextureCoordinates());

		if (src.isSetTextureType())
			dest.setTextureType(unmarshalTextureType(src.getTextureType()));

		if (src.isSetRepeat())
			dest.setRepeat(src.isRepeat());
	}

	public _SimpleTexture unmarshalSimpleTexture(SimpleTextureType src) {
		_SimpleTexture dest = new _SimpleTexture(module);
		unmarshalSimpleTexture(src, dest);

		return dest;
	}

	public void unmarshalTexturedSurface(TexturedSurfaceType src, _TexturedSurface dest) {
		jaxb.getGMLUnmarshaller().unmarshalOrientableSurface(src, dest);

		if (src.isSetAppearance()) {
			for (AppearancePropertyType appearanceProperty : src.getAppearance())
				dest.addAppearance(unmarshalAppearanceProperty(appearanceProperty));
		}
	}

	public _TexturedSurface unmarshalTexturedSurface(TexturedSurfaceType src) {
		_TexturedSurface dest = new _TexturedSurface(module);
		unmarshalTexturedSurface(src, dest);

		return dest;
	}

	public _TextureType unmarshalTextureType(TextureTypeType src) {
		return _TextureType.fromValue(src.value());
	}

}
