/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2022 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml4j.builder.cityjson.marshal.citygml.core;

import org.citygml4j.builder.cityjson.marshal.CityJSONMarshaller;
import org.citygml4j.builder.cityjson.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.builder.cityjson.marshal.gml.GMLMarshaller;
import org.citygml4j.cityjson.CityJSON;
import org.citygml4j.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.cityjson.feature.AddressType;
import org.citygml4j.cityjson.feature.Attributes;
import org.citygml4j.cityjson.feature.CityObjectGroupType;
import org.citygml4j.cityjson.geometry.AbstractGeometryObjectType;
import org.citygml4j.cityjson.geometry.GeometryInstanceType;
import org.citygml4j.cityjson.geometry.GeometryTypeName;
import org.citygml4j.cityjson.geometry.MultiPointType;
import org.citygml4j.cityjson.geometry.SemanticsType;
import org.citygml4j.geometry.Matrix;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.AbstractSite;
import org.citygml4j.model.citygml.core.Address;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.citygml.core.CityObjectMember;
import org.citygml4j.model.citygml.core.ImplicitGeometry;
import org.citygml4j.model.citygml.core.ImplicitRepresentationProperty;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.feature.FeatureArrayProperty;
import org.citygml4j.model.gml.feature.FeatureProperty;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;
import org.citygml4j.model.gml.geometry.primitives.DirectPosition;
import org.citygml4j.model.gml.geometry.primitives.Point;
import org.citygml4j.model.xal.CountryName;
import org.citygml4j.model.xal.LocalityName;
import org.citygml4j.model.xal.PostalCodeNumber;
import org.citygml4j.model.xal.ThoroughfareName;
import org.citygml4j.model.xal.ThoroughfareNumber;
import org.citygml4j.util.gmlid.DefaultGMLIdManager;
import org.citygml4j.util.gmlid.GMLIdManager;
import org.citygml4j.util.walker.XALWalker;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class CoreMarshaller {
	private final CityJSONMarshaller json;
	private final CityGMLMarshaller citygml;
	private final GMLMarshaller implicit;

	private final AtomicInteger templatesIndex = new AtomicInteger(0);
	private final ConcurrentHashMap<String, Integer> templateIds = new ConcurrentHashMap<>();
	private final ConcurrentHashMap<Integer, AbstractGeometryObjectType> templates = new ConcurrentHashMap<>();
	private final GMLIdManager gmlIdManager = DefaultGMLIdManager.getInstance();

	public CoreMarshaller(CityGMLMarshaller citygml) {
		this.citygml = citygml;
		json = citygml.getCityJSONMarshaller();
		implicit = new GMLMarshaller(json, json::getTemplatesVerticesBuilder);
	}

	public AbstractCityObjectType marshal(ModelObject src, CityJSON cityJSON) {
		if (src instanceof CityModel)
			return marshalCityModel((CityModel) src, cityJSON);
		
		return null;
	}

	public void marshalAbstractCityObject(AbstractCityObject src, AbstractCityObjectType dest, CityJSON cityJSON) {
		dest.setGmlId(src.isSetId() && !src.getId().isEmpty() ? src.getId() : DefaultGMLIdManager.getInstance().generateUUID());

		if (src.isSetBoundedBy() && src.getBoundedBy().isSetEnvelope())
			dest.setGeographicalExtent(src.getBoundedBy().getEnvelope().toBoundingBox().toList());

		Attributes attributes = dest.getAttributes();
		if (src.isSetDescription() && src.getDescription().isSetValue())
			attributes.setDescription(src.getDescription().getValue());

		if (src.isSetName()) {
			for (Code name : src.getName()) {
				if (name.isSetValue()) {
					attributes.setName(name.getValue());
					break;
				}
			}
		}

		if (src.isSetCreationDate())
			attributes.setCreationDate(src.getCreationDate());

		if (src.isSetTerminationDate())
			attributes.setTerminationDate(src.getTerminationDate());

		if (src.isSetGenericAttribute())
			citygml.getGenericsMarshaller().marshalGenericAttributes(src, attributes);

		if (src.isSetGenericApplicationPropertyOfCityObject())
			json.getADEMarshaller().marshal(src.getGenericApplicationPropertyOfCityObject(), dest, cityJSON);
	}

	public void marshalAbstractSite(AbstractSite src, AbstractCityObjectType dest, CityJSON cityJSON) {
		marshalAbstractCityObject(src, dest, cityJSON);

		if (src.isSetGenericApplicationPropertyOfSite())
			json.getADEMarshaller().marshal(src.getGenericApplicationPropertyOfSite(), dest, cityJSON);
	}

	private AbstractCityObjectType marshalCityModel(CityModel src, CityJSON cityJSON) {
		if (src.isSetCityObjectMember()) {
			for (CityObjectMember property : src.getCityObjectMember()) {
				AbstractCityObjectType cityObject = json.getGMLMarshaller().marshalFeatureProperty(property, cityJSON);
				if (cityObject != null)
					cityJSON.addCityObject(cityObject);
			}
		}

		if (src.isSetFeatureMember()) {
			for (FeatureProperty<?> property : src.getFeatureMember()) {
				if (property.getFeature() instanceof CityModel)
					marshalCityModel((CityModel) property.getFeature(), cityJSON);
				else {
					AbstractCityObjectType cityObject = json.getGMLMarshaller().marshalFeatureProperty(property, cityJSON);
					if (cityObject != null)
						cityJSON.addCityObject(cityObject);
				}
			}
		}

		if (src.isSetFeatureMembers()) {
			FeatureArrayProperty property = src.getFeatureMembers();
			for (AbstractFeature feature : property.getFeature()) {
				if (feature instanceof CityModel)
					marshalCityModel((CityModel) feature, cityJSON);
				else {
					AbstractCityObjectType cityObject = citygml.marshal(feature, cityJSON);
					if (cityObject != null)
						cityJSON.addCityObject(cityObject);
				}
			}
		}

		if (src.isSetGenericApplicationPropertyOfCityModel())
			json.getADEMarshaller().marshal(src.getGenericApplicationPropertyOfCityModel(), cityJSON, cityJSON);

		// postprocess group members
		if (cityJSON.getCityObjects().stream().anyMatch(CityObjectGroupType.class::isInstance))
			citygml.getCityObjectGroupMarshaller().postprocessGroupMembers(src, cityJSON);

		return null;
	}

	public GeometryInstanceType marshalImplicitGeometry(ImplicitGeometry src, int lod) {
		// get relative geometry
		AbstractGeometry relativeGeometry = null;

		GeometryProperty<?> property = src.getRelativeGMLGeometry();
		if (property != null) {
			if (property.isSetGeometry()) {
				relativeGeometry = property.getGeometry();
			} else if (property.hasLocalProperty(CityJSONMarshaller.GEOMETRY_XLINK)) {
				relativeGeometry = (AbstractGeometry) property.getLocalProperty(CityJSONMarshaller.GEOMETRY_XLINK);
			}
		}

		if (relativeGeometry == null) {
			return null;
		}

		String templateId = relativeGeometry.isSetId() ? relativeGeometry.getId() : gmlIdManager.generateUUID();
		Integer sequenceNumber = templateIds.get(templateId);
		if (sequenceNumber == null) {
			int tmp = templatesIndex.getAndIncrement();
			sequenceNumber = templateIds.putIfAbsent(templateId, tmp);
			if (sequenceNumber == null) {
				sequenceNumber = tmp;

				// marshal template geometry
				AbstractGeometryObjectType template = implicit.marshalGeometryProperty(property);
				template.setLod(lod);
				templates.put(sequenceNumber, template);
			}
		}

		// get transformation matrix and reference point
		Matrix matrix = src.isSetTransformationMatrix() ? src.getTransformationMatrix().getMatrix().copy() : null;
		Point referencePoint = src.isSetReferencePoint() && src.getReferencePoint().isSetPoint() ?
				src.getReferencePoint().getPoint() : null;

		if (matrix == null || referencePoint == null)
			return null;

		// move translation part of transformation matrix to reference point
		List<Double> vertex = referencePoint.toList3d();
		vertex.set(0, vertex.get(0) + matrix.get(0, 3));
		vertex.set(1, vertex.get(1) + matrix.get(1, 3));
		vertex.set(2, vertex.get(2) + matrix.get(2, 3));
		matrix.set(0, 3, 0);
		matrix.set(1, 3, 0);
		matrix.set(2, 3, 0);

		// create new reference point
		referencePoint = new Point();
		DirectPosition pos = new DirectPosition();
		pos.setValue(vertex);
		referencePoint.setPos(pos);

		MultiPointType boundary = json.getGMLMarshaller().marshalPoint(referencePoint);
		if (boundary == null)
			return null;

		GeometryInstanceType dest = new GeometryInstanceType();
		dest.setTemplate(sequenceNumber);
		dest.setTransformationMatrix(matrix.toRowPackedList());
		dest.setReferencePoint(boundary.getPoints().get(0));

		return dest;
	}

	public GeometryInstanceType marshalImplicitRepresentationProperty(ImplicitRepresentationProperty src, int lod) {
		return src.isSetImplicitGeometry() ? marshalImplicitGeometry(src.getImplicitGeometry(), lod) : null;
	}
	
	public void marshalAddress(Address src, AddressType dest) {
		if (src.isSetXalAddress() && src.getXalAddress().isSetAddressDetails()) {
			src.getXalAddress().getAddressDetails().accept(new XALWalker() {
				
				@Override
				public void visit(CountryName countryName) {
					if (!dest.isSetCountryName())
						dest.setCountryName(countryName.getContent());

					super.visit(countryName);
				}

				@Override
				public void visit(LocalityName localityName) {
					if (!dest.isSetLocalityName())
						dest.setLocalityName(localityName.getContent());

					super.visit(localityName);
				}

				@Override
				public void visit(PostalCodeNumber postalCodeNumber) {
					if (!dest.isSetPostalCode())
						dest.setPostalCode(postalCodeNumber.getContent());

					super.visit(postalCodeNumber);
				}

				@Override
				public void visit(ThoroughfareName thoroughfareName) {
					if (!dest.isSetThoroughfareName())
						dest.setThoroughfareName(thoroughfareName.getContent());

					super.visit(thoroughfareName);
				}

				@Override
				public void visit(ThoroughfareNumber thoroughfareNumber) {
					if (!dest.isSetThoroughfareNumber())
						dest.setThoroughfareNumber(thoroughfareNumber.getContent());

					super.visit(thoroughfareNumber);
				}
			});
		}
		
		if (src.isSetMultiPoint()) {
			AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getMultiPoint());
			if (geometry != null && geometry.getType() == GeometryTypeName.MULTI_POINT)
				dest.setLocation((MultiPointType)geometry);
		}
	}
	
	public AddressType marshalAddress(Address src) {
		AddressType dest = new AddressType();
		marshalAddress(src, dest);
		
		return dest;
	}

	public void marshalSemanticSurfaceAttributes(AbstractCityObject src, SemanticsType dest) {
		if (src.isSetId())
			dest.setId(src.getId());

		if (src.isSetDescription() && src.getDescription().isSetValue())
			dest.setDescription(src.getDescription().getValue());

		if (src.isSetName()) {
			for (Code name : src.getName()) {
				if (name.isSetValue()) {
					dest.setName(name.getValue());
					break;
				}
			}
		}

		if (src.isSetCreationDate())
			dest.setCreationDate(src.getCreationDate());

		if (src.isSetTerminationDate())
			dest.setTerminationDate(src.getTerminationDate());

		citygml.getGenericsMarshaller().marshalGenericAttributes(src, dest);
	}

	public boolean hasGeometryTemplates() {
		return !templates.isEmpty();
	}

	public List<AbstractGeometryObjectType> getGeometryTemplates() {
		List<AbstractGeometryObjectType> result = templates.entrySet().stream()
				.sorted(Map.Entry.comparingByKey())
				.map(Map.Entry::getValue).collect(Collectors.toList());

		templates.clear();
		templateIds.clear();
		templatesIndex.set(0);
		return result;
	}

}
