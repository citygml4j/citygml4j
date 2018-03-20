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
package org.citygml4j.builder.cityjson.unmarshal.citygml.core;

import org.citygml4j.binding.cityjson.CityJSON;
import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.feature.AddressType;
import org.citygml4j.binding.cityjson.feature.Attributes;
import org.citygml4j.binding.cityjson.feature.MetadataType;
import org.citygml4j.builder.cityjson.unmarshal.CityJSONUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.citygml.CityGMLUnmarshaller;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.geometry.Point;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroup;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.Address;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.citygml.core.CityObjectMember;
import org.citygml4j.model.citygml.core.XalAddressProperty;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.gml.geometry.aggregates.MultiPointProperty;
import org.citygml4j.model.gml.geometry.primitives.Envelope;
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
import org.citygml4j.util.walker.FeatureWalker;

import java.util.GregorianCalendar;
import java.util.List;

public class CoreUnmarshaller {
	private final CityJSONUnmarshaller json;
	private final CityGMLUnmarshaller citygml;
	
	public CoreUnmarshaller(CityGMLUnmarshaller citygml) {
		this.citygml = citygml;
		json = citygml.getCityJSONUnmarshaller();
	}

	public void unmarshalAbstractCityObject(AbstractCityObjectType src, AbstractCityObject dest) {
		dest.setId(src.getGmlId());

		if (src.isSetBBox()) {
			List<Double> bbox = src.getBBox();

			Envelope envelope = new Envelope();
			envelope.setLowerCorner(new Point(bbox.get(0), bbox.get(1), bbox.get(2)));
			envelope.setUpperCorner(new Point(bbox.get(3), bbox.get(4), bbox.get(5)));
			envelope.setSrsDimension(3);

			dest.setBoundedBy(new BoundingShape(envelope));
		}
		
		if (src.isSetAttributes()) {
			Attributes attributes = src.getAttributes();
			
			if (attributes.isSetCreationDate()) {
				GregorianCalendar creationDate = new GregorianCalendar();
				creationDate.setTime(attributes.getCreationDate());
				dest.setCreationDate(creationDate);
			}
			
			if (attributes.isSetTerminationDate()) {
				GregorianCalendar terminationDate = new GregorianCalendar();
				terminationDate.setTime(attributes.getCreationDate());
				dest.setTerminationDate(terminationDate);
			}
			
			if (attributes.isSetGenericAttributes())
				citygml.getGenericsUnmarshaller().unmarshalGenericAttributes(attributes, dest);
		}
	}
	
	public void unmarshalCityModel(CityJSON src, CityModel dest) {
		boolean hasGroups = false;
		for (AbstractCityObjectType type : src.getCityObjects()) {	
			AbstractCityObject cityObject = citygml.unmarshal(type, src);
			if (cityObject != null) {
				dest.addCityObjectMember(new CityObjectMember(cityObject));

				if (cityObject instanceof CityObjectGroup)
					hasGroups = true;
			}
		}

		// postprocess group members
		if (hasGroups) {
			dest.accept(new FeatureWalker() {
				public void visit(CityObjectGroup cityObjectGroup) {
					citygml.getCiyCityObjectGroupUnmarshaller().postprocessGroupMembers(cityObjectGroup, dest);
				}
			});
		}
		
		if (src.isSetMetadata()) {
			MetadataType metadata = src.getMetadata();

			if (metadata.isSetBBox()) {
				List<Double> bbox = metadata.getBBox();
				if (bbox.size() > 5) {
					BoundingShape boundedBy = new BoundingShape(new BoundingBox(
							new Point(bbox.get(0), bbox.get(1), bbox.get(2)),
							new Point(bbox.get(3), bbox.get(4), bbox.get(5))));
					
					if (metadata.isSetCRS())
						boundedBy.getEnvelope().setSrsName("EPSG:" + metadata.getCRS().getEpsg());
					
					dest.setBoundedBy(boundedBy);
				}
			}
		}
	}
	
	public CityModel unmarshalCityModel(CityJSON src) {
		CityModel dest = new CityModel();
		unmarshalCityModel(src, dest);
		
		return dest;
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
	
}
