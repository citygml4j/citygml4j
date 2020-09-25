/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2020 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml4j.builder.cityjson.unmarshal.citygml.core;

import org.citygml4j.builder.cityjson.unmarshal.CityJSONUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.CityObjectProcessor;
import org.citygml4j.builder.cityjson.unmarshal.citygml.CityGMLUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.gml.GMLUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.util.AffineTransform;
import org.citygml4j.cityjson.CityJSON;
import org.citygml4j.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.cityjson.feature.AddressType;
import org.citygml4j.cityjson.feature.Attributes;
import org.citygml4j.cityjson.feature.CityObjectTypeAdapter;
import org.citygml4j.cityjson.geometry.AbstractGeometryObjectType;
import org.citygml4j.cityjson.geometry.GeometryInstanceType;
import org.citygml4j.cityjson.geometry.GeometryTemplatesType;
import org.citygml4j.cityjson.geometry.MultiPointType;
import org.citygml4j.cityjson.geometry.SemanticsType;
import org.citygml4j.cityjson.metadata.MetadataType;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.geometry.Matrix;
import org.citygml4j.geometry.Point;
import org.citygml4j.model.citygml.appearance.Appearance;
import org.citygml4j.model.citygml.appearance.AppearanceProperty;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroup;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.Address;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.citygml.core.CityObjectMember;
import org.citygml4j.model.citygml.core.ImplicitGeometry;
import org.citygml4j.model.citygml.core.TransformationMatrix4x4;
import org.citygml4j.model.citygml.core.XalAddressProperty;
import org.citygml4j.model.citygml.generics.GenericCityObject;
import org.citygml4j.model.citygml.generics.StringAttribute;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.base.StringOrRef;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.gml.feature.FeatureMember;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;
import org.citygml4j.model.gml.geometry.aggregates.MultiPoint;
import org.citygml4j.model.gml.geometry.aggregates.MultiPointProperty;
import org.citygml4j.model.gml.geometry.primitives.AbstractCurveSegment;
import org.citygml4j.model.gml.geometry.primitives.Curve;
import org.citygml4j.model.gml.geometry.primitives.CurveSegmentArrayProperty;
import org.citygml4j.model.gml.geometry.primitives.Envelope;
import org.citygml4j.model.gml.geometry.primitives.LineString;
import org.citygml4j.model.gml.geometry.primitives.LineStringSegment;
import org.citygml4j.model.gml.geometry.primitives.LinearRing;
import org.citygml4j.model.module.Module;
import org.citygml4j.model.module.Modules;
import org.citygml4j.model.module.ade.ADEModule;
import org.citygml4j.model.module.citygml.AppearanceModule;
import org.citygml4j.model.module.citygml.CityGMLModule;
import org.citygml4j.model.xal.AddressDetails;
import org.citygml4j.model.xal.Country;
import org.citygml4j.model.xal.CountryName;
import org.citygml4j.model.xal.Locality;
import org.citygml4j.model.xal.LocalityName;
import org.citygml4j.model.xal.PostalCode;
import org.citygml4j.model.xal.PostalCodeNumber;
import org.citygml4j.model.xal.Thoroughfare;
import org.citygml4j.model.xal.ThoroughfareName;
import org.citygml4j.model.xal.ThoroughfareNumber;
import org.citygml4j.util.gmlid.DefaultGMLIdManager;
import org.citygml4j.util.gmlid.GMLIdManager;
import org.citygml4j.util.walker.FeatureWalker;
import org.citygml4j.util.walker.GeometryWalker;

import javax.xml.namespace.QName;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CoreUnmarshaller {
	private final CityJSONUnmarshaller json;
	private final CityGMLUnmarshaller citygml;
	private final GMLUnmarshaller implicit;

	private List<AbstractGeometryObjectType> templates;
	private Map<Integer, SimpleEntry<String, Integer>> templateInfos;
	private Queue<Appearance> appearances;
	private GMLIdManager gmlIdManager;

	private final String UNMARSHAL_AS_GLOBAL_FEATURE = "org.citygml4j.unmarshal.asGlobalFeature";
	private final String GLOBAL_FEATURES = "org.citygml4j.unmarshal.globalFeature";

	public CoreUnmarshaller(CityGMLUnmarshaller citygml) {
		this.citygml = citygml;
		json = citygml.getCityJSONUnmarshaller();
		implicit = new GMLUnmarshaller(json);
	}

	public void setGeometryTemplatesInfo(GeometryTemplatesType geometryTemplates) {
		templates = geometryTemplates.getTemplates();
		implicit.setVertices(geometryTemplates.getTemplatesVertices());

		templateInfos = new ConcurrentHashMap<>();
		appearances = new ConcurrentLinkedQueue<>();
		gmlIdManager = DefaultGMLIdManager.getInstance();
	}

	@SuppressWarnings("unchecked")
	public void unmarshalAbstractCityObject(AbstractCityObjectType src, AbstractCityObject dest, CityJSON cityJSON) {
		dest.setId(src.getGmlId());

		if (src.isSetGeographicalExtent()) {
			List<Double> bbox = src.getGeographicalExtent();

			Envelope envelope = new Envelope();
			envelope.setLowerCorner(new Point(bbox.get(0), bbox.get(1), bbox.get(2)));
			envelope.setUpperCorner(new Point(bbox.get(3), bbox.get(4), bbox.get(5)));
			envelope.setSrsDimension(3);

			dest.setBoundedBy(new BoundingShape(envelope));
		}

		if (src.isSetExtensionProperties()) {
			for (Map.Entry<String, Object> entry : src.getExtensionProperties().entrySet()) {
				if (json.getCityJSONRegistry().hasExtensionProperty(entry.getKey(), src))
					json.getADEUnmarshaller().unmarshalExtensionProperty(entry.getKey(), entry.getValue(), src, cityJSON, dest);
				else
					citygml.getGenericsUnmarshaller().unmarshalGenericAttribute(entry.getKey(), entry.getValue(),dest);
			}
		}
		
		if (src.isSetAttributes()) {
			Attributes attributes = src.getAttributes();

			if (attributes.isSetDescription())
				dest.setDescription(new StringOrRef(attributes.getDescription()));

			if (attributes.isSetName())
				dest.addName(new Code(attributes.getName()));
			
			if (attributes.isSetCreationDate())
				dest.setCreationDate(attributes.getCreationDate());

			if (attributes.isSetTerminationDate())
				dest.setTerminationDate(attributes.getTerminationDate());

			if (attributes.isSetExtensionAttributes()) {
				for (Map.Entry<String, Object> entry : attributes.getExtensionAttributes().entrySet()) {
					if (json.getCityJSONRegistry().hasExtensionProperty(entry.getKey(), src))
						json.getADEUnmarshaller().unmarshalExtensionProperty(entry.getKey(), entry.getValue(), src, cityJSON, dest);
					else
						citygml.getGenericsUnmarshaller().unmarshalGenericAttribute(entry.getKey(), entry.getValue(), dest);
				}
			}
		}

		if (src.isSetChildren()) {
			for (String child : src.getChildren()) {
				AbstractCityObjectType cityObject = cityJSON.getCityObject(child);
				if (cityObject != null && !json.getCityJSONRegistry().isCoreCityObject(cityObject.getType())) {
					AbstractFeature feature = json.getADEUnmarshaller().unmarshalCityObject(cityObject, cityJSON, dest);

					if (feature != null) {
						if (feature.hasLocalProperty(UNMARSHAL_AS_GLOBAL_FEATURE)) {
							List<AbstractFeature> features = (List<AbstractFeature>) dest.getLocalProperty(GLOBAL_FEATURES);
							if (features == null) {
								features = new ArrayList<>();
								dest.setLocalProperty(GLOBAL_FEATURES, features);
							}

							features.add(feature);
						}

						if (feature.hasLocalProperty(CityObjectTypeAdapter.UNKNOWN_EXTENSION)) {
							String type = cityObject.getType();
							if (type.startsWith("+"))
								type = type.substring(1);

							dest.addGenericAttribute(new StringAttribute(type, feature.getId()));
						}
					}
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void unmarshalCityModel(CityJSON src, CityModel dest, CityObjectProcessor processor) throws Exception {
		// handle global extension properties
		if (src.isSetExtensionProperties()) {
			for (Map.Entry<String, Object> entry : src.getExtensionProperties().entrySet()) {
				if (json.getCityJSONRegistry().hasExtensionProperty(entry.getKey(), src))
					json.getADEUnmarshaller().unmarshalExtensionProperty(entry.getKey(), entry.getValue(), src, src, dest);
			}
		}

		// add metadata
		if (src.isSetMetadata()) {
			MetadataType metadata = src.getMetadata();

			if (metadata.isSetGeographicalExtent()) {
				List<Double> bbox = metadata.getGeographicalExtent();
				if (bbox.size() > 5) {
					BoundingShape boundedBy = new BoundingShape(new BoundingBox(
							new Point(bbox.get(0), bbox.get(1), bbox.get(2)),
							new Point(bbox.get(3), bbox.get(4), bbox.get(5))));

					if (metadata.isSetReferenceSystem())
						boundedBy.getEnvelope().setSrsName(metadata.getReferenceSystem());

					dest.setBoundedBy(boundedBy);
				}
			}
		}

		// collect top-level objects
		Set<AbstractCityObjectType> topLevel = Collections.newSetFromMap(new IdentityHashMap<>());
		for (AbstractCityObjectType type : src.getCityObjects()) {
			if (!type.isSetParents())
				topLevel.add(type);
		}

		for (Iterator<AbstractCityObjectType> iter = topLevel.iterator(); iter.hasNext(); ) {
			AbstractCityObjectType type = iter.next();

			AbstractFeature cityObject;
			if (!json.getCityJSONRegistry().isCoreCityObject(type.getType())) {
				cityObject = json.getADEUnmarshaller().unmarshalCityObject(type, src, dest);
				if (cityObject == null || !cityObject.hasLocalProperty(UNMARSHAL_AS_GLOBAL_FEATURE))
					continue;
			} else
				cityObject = citygml.unmarshal(type, src);

			if (!json.isSetCityGMLNameFilter() ||satisfiesCityGMLNameFilter(cityObject))
				processor.process(cityObject);

			// add additional global features
			if (cityObject.hasLocalProperty(GLOBAL_FEATURES)) {
				for (AbstractFeature feature : (List<AbstractFeature>) cityObject.getLocalProperty(GLOBAL_FEATURES)) {
					if (!json.isSetCityGMLNameFilter() || satisfiesCityGMLNameFilter(feature))
						processor.process(feature);
				}

				cityObject.unsetLocalProperty(GLOBAL_FEATURES);
			}

			// release CityJSON content from main memory
			if (json.isReleaseCityJSONContent()) {
				releaseObjectHierarchy(type, src);
				src.removeCityObject(type.getGmlId());
			}

			iter.remove();
		}
	}
	
	public CityModel unmarshalCityModel(CityJSON src) {
		CityModel dest = new CityModel();

		try {
			unmarshalCityModel(src, dest, feature -> {
				if (feature instanceof AbstractCityObject)
					dest.addCityObjectMember(new CityObjectMember((AbstractCityObject) feature));
				else
					dest.addFeatureMember(new FeatureMember(feature));
			});

			// postprocess group members
			dest.accept(new FeatureWalker() {
				public void visit(CityObjectGroup group) {
					citygml.getCiyCityObjectGroupUnmarshaller().postprocessGroupMembers(group, dest);
				}
			});

			// postprocess metadata
			if (!dest.isSetCityObjectMember() && !dest.isSetFeatureMember())
				dest.unsetBoundedBy();
		} catch (Exception e) {
			//
		}

		return dest;
	}

	public void unmarshalAsGlobalFeature(AbstractFeature feature) {
		feature.setLocalProperty(UNMARSHAL_AS_GLOBAL_FEATURE, true);
	}

	public void unmarshalGeometryInstance(GeometryInstanceType src, ImplicitGeometry dest) {
		// get relative geometry
		SimpleEntry<String, Integer> templateInfo = templateInfos.get(src.getTemplate());
		GeometryProperty<AbstractGeometry> property = new GeometryProperty<>();

		if (templateInfo == null) {
			if (templates != null && templates.size() > src.getTemplate()) {
				AbstractGeometryObjectType template = templates.get(src.getTemplate());
				AbstractCityObject dummyParent = new GenericCityObject();
				AbstractGeometry geometry = implicit.unmarshal(template, dummyParent);

				if (geometry != null) {
					geometry.setId(gmlIdManager.generateUUID());
					property.setGeometry(geometry);
					dest.setLocalProperty(CityJSONUnmarshaller.GEOMETRY_INSTANCE_LOD, template.getLod().intValue());
					templateInfos.putIfAbsent(src.getTemplate(), new SimpleEntry<>(geometry.getId(), template.getLod().intValue()));
				}

				if (dummyParent.isSetAppearance()) {
					dummyParent.getAppearance().stream()
							.map(AppearanceProperty::getAppearance)
							.forEach(appearances::add);
				}
			}
		} else {
			property.setHref("#" + templateInfo.getKey());
			dest.setLocalProperty(CityJSONUnmarshaller.GEOMETRY_INSTANCE_LOD, templateInfo.getValue());
		}

		dest.setRelativeGeometry(property);

		// get transformation matrix
		List<Double> transformationMatrix = src.getTransformationMatrix();
		if (transformationMatrix != null && transformationMatrix.size() > 15) {
			Matrix matrix = new Matrix(transformationMatrix.subList(0, 16), 4);
			dest.setTransformationMatrix(new TransformationMatrix4x4(matrix));
		}

		// get reference point
		MultiPointType referencePoint = new MultiPointType();
		referencePoint.addPoint(src.getReferencePoint());
		MultiPoint multiPoint = json.getGMLUnmarshaller().unmarshalMultiPoint(referencePoint);
		if (multiPoint != null)
			dest.setReferencePoint(multiPoint.getPointMember().get(0));
	}

	public ImplicitGeometry unmarshalGeometryInstance(GeometryInstanceType src) {
		ImplicitGeometry dest = new ImplicitGeometry();
		unmarshalGeometryInstance(src, dest);

		return dest;
	}

	public AbstractGeometry unmarshalAndTransformGeometryInstance(GeometryInstanceType src, AbstractCityObject parent) {
		if (templates == null || templates.size() <= src.getTemplate())
			return null;

		// get template geometry
		AbstractGeometryObjectType template = templates.get(src.getTemplate());
		AbstractGeometry geometry = implicit.unmarshal(template, parent);
		if (geometry == null)
			return null;

		// get transformation matrix and reference point
		List<Double> transformationMatrix = src.getTransformationMatrix();
		MultiPointType referencePoint = new MultiPointType();
		referencePoint.addPoint(src.getReferencePoint());
		MultiPoint multiPoint = json.getGMLUnmarshaller().unmarshalMultiPoint(referencePoint);
		if (transformationMatrix == null || transformationMatrix.size() < 16 || multiPoint == null)
			return null;

		Matrix matrix = new Matrix(transformationMatrix.subList(0, 16), 4);
		List<Double> point = multiPoint.getPointMember().get(0).getPoint().toList3d();
		matrix.set(0, 3, matrix.get(0, 3) + point.get(0));
		matrix.set(1, 3, matrix.get(1, 3) + point.get(1));
		matrix.set(2, 3, matrix.get(2, 3) + point.get(2));

		// transform geometry
		AffineTransform transformer = new AffineTransform(matrix);
		geometry.accept(new GeometryWalker() {
			public void visit(org.citygml4j.model.gml.geometry.primitives.Point point) {
				List<Double> vertex = point.toList3d();
				if (!vertex.isEmpty()) {
					transformer.transform(vertex);
					point.getPos().setValue(vertex);
				}
			}

			public void visit(LineString lineString) {
				List<Double> vertices = lineString.toList3d();
				if (!vertices.isEmpty()) {
					transformer.transform(vertices);
					lineString.getPosList().setValue(vertices);
				}
			}

			public void visit(Curve curve) {
				if (curve.isSetSegments()) {
					CurveSegmentArrayProperty arrayProperty = curve.getSegments();
					if (arrayProperty.isSetCurveSegment()) {
						for (AbstractCurveSegment abstractCurveSegment : arrayProperty.getCurveSegment()) {
							if (abstractCurveSegment.getGMLClass() == GMLClass.LINE_STRING_SEGMENT) {
								List<Double> vertices = abstractCurveSegment.toList3d();
								if (!vertices.isEmpty()) {
									transformer.transform(vertices);
									((LineStringSegment)abstractCurveSegment).getPosList().setValue(vertices);
								}
							}
						}
					}
				}
			}

			public void visit(LinearRing linearRing) {
				List<Double> vertices = linearRing.toList3d();
				if (!vertices.isEmpty()) {
					transformer.transform(vertices);
					linearRing.getPosList().setValue(vertices);
				}
			}
		});
		
		geometry.setLocalProperty(CityJSONUnmarshaller.GEOMETRY_INSTANCE_LOD, template.getLod().intValue());
		return geometry;
	}

	public void unmarshalAddress(AddressType src, Address dest) {		
		AddressDetails addressDetails = new AddressDetails();		
		Country country = new Country();
		
		if (src.isSetCountryName())
			country.addCountryName(new CountryName(src.getCountryName()));
		
		Locality locality = new Locality();
		locality.setType("City");
		
		if (src.isSetLocalityName())
			locality.addLocalityName(new LocalityName(src.getLocalityName()));
		
		if (src.isSetThoroughfareName() || src.isSetThoroughfareNumber()) {
			Thoroughfare thoroughfare = new Thoroughfare();
			thoroughfare.setType("Street");
			locality.setThoroughfare(thoroughfare);

			if (src.isSetThoroughfareName())
				thoroughfare.addThoroughfareName(new ThoroughfareName(src.getThoroughfareName()));
			
			if (src.isSetThoroughfareNumber())
				thoroughfare.addThoroughfareNumber(new ThoroughfareNumber(src.getThoroughfareNumber()));			
		}
		
		if (src.isSetPostalCode()) {
			PostalCode postalCode = new PostalCode();
			postalCode.addPostalCodeNumber(new PostalCodeNumber(src.getPostalCode()));
			locality.setPostalCode(postalCode);			
		}
		
		if (locality.isSetLocalityName()
				|| locality.isSetThoroughfare()
				|| locality.isSetPostalCode())
			country.setLocality(locality);
		
		if (country.isSetCountryName()
				|| country.isSetLocality())
			addressDetails.setCountry(country);
		
		if (src.isSetLocation())
			dest.setMultiPoint(new MultiPointProperty(json.getGMLUnmarshaller().unmarshalMultiPoint(src.getLocation())));

		dest.setXalAddress(new XalAddressProperty(addressDetails));
	}
	
	public Address unmarshalAddress(AddressType src) {
		Address dest = new Address();
		unmarshalAddress(src, dest);
		
		return dest;
	}

	public void unmarshalSemanticsAttributes(SemanticsType src, AbstractCityObject dest) {
		dest.setId(src.isSetId() ? src.getId() : DefaultGMLIdManager.getInstance().generateUUID());

		if (src.isSetDescription())
			dest.setDescription(new StringOrRef(src.getDescription()));

		if (src.isSetName())
			dest.addName(new Code(src.getName()));

		if (src.isSetCreationDate())
			dest.setCreationDate(src.getCreationDate());

		if (src.isSetTerminationDate())
			dest.setTerminationDate(src.getTerminationDate());

		if (src.isSetAttributes())
			citygml.getGenericsUnmarshaller().unmarshalGenericAttributes(src.getAttributes(), dest);
	}

	public boolean hasGlobalAppearances() {
		return appearances != null && !appearances.isEmpty()
				&& (!json.isSetCityGMLNameFilter()
				|| json.getCityGMLNameFilter().accept(new QName(AppearanceModule.v2_0_0.getNamespaceURI(), "Appearance"))
				|| json.getCityGMLNameFilter().accept(new QName(AppearanceModule.v1_0_0.getNamespaceURI(), "Appearance")));
	}

	public Collection<Appearance> getGlobalAppearances() {
		Collection<Appearance> result;

		if (hasGlobalAppearances()) {
			result = appearances;
			templates = null;
			templateInfos = null;
			appearances = null;
		} else
			result = Collections.emptyList();

		return result;
	}

	private void releaseObjectHierarchy(AbstractCityObjectType parent, CityJSON src) {
		if (parent.isSetChildren()) {
			for (String gmlId : parent.getChildren()) {
				AbstractCityObjectType child = src.getCityObject(gmlId);
				if (child.isSetParents() && child.getParents().size() == 1) {
					releaseObjectHierarchy(child, src);
					src.removeCityObject(gmlId);
				}
			}
		}
	}

	private boolean satisfiesCityGMLNameFilter(AbstractFeature cityObject) {
		boolean accept = false;

		for (Module module : Modules.getModules()) {
			if (!(module instanceof CityGMLModule) && !(module instanceof ADEModule))
				continue;

			QName name = module.getFeatureName(cityObject.getClass());
			if (name != null && json.getCityGMLNameFilter().accept(name)) {
				accept = true;
				break;
			}
		}

		return accept;
	}
}
