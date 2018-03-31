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
package org.citygml4j.binding.cityjson.feature;

import com.google.gson.annotations.JsonAdapter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class MetadataType {
	private CRSType crs;
	private List<Double> bbox;
	private List<String> keywords;
	private String datasetTitle;
	@JsonAdapter(DateTimeAdapter.class)
	private ZonedDateTime datasetReferenceDate;
	private String geographicLocation;
	private String datasetLanguage;
	private String datasetTopicCategory;
	private String datasetAbstract;
	@JsonAdapter(DateTimeAdapter.class)
	private ZonedDateTime metadataDateStamp;
	private String pointOfContact;
	private String copyright;
	private List<Number> presentLoDs;

	public boolean isSetCRS() {
		return crs != null;
	}

	public CRSType getCRS() {
		return crs;
	}

	public void setCRS(CRSType crs) {
		this.crs = crs;
	}

	public void unsetCRS() {
		crs = null;
	}

	public boolean isSetBBox() {
		return bbox != null && bbox.size() >= 6;
	}

	public List<Double> getBBox() {
		return isSetBBox() ? bbox.subList(0, 6) : null;
	}

	public void setBBox(List<Double> bbox) {
		if (bbox == null)
			this.bbox = null;
		else if (bbox.size() >= 6)
			this.bbox = bbox.subList(0, 6);
	}

	public void unsetBBox() {
		bbox = null;
	}

	public boolean isSetKeywords() {
		return keywords != null;
	}

	public List<String> getKeywords() {
		return keywords;
	}

	public void addKeyWord(String keyword) {
		if (keywords == null)
			keywords = new ArrayList<>();

		keywords.add(keyword);
	}

	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

	public void removeKeyword(String keyword) {
		if (keywords != null)
			keywords.remove(keyword);
	}

	public void unsetsetKeywords() {
		keywords = null;
	}

	public boolean isSetDatasetTitle() {
		return datasetTitle != null;
	}

	public String getDatasetTitle() {
		return datasetTitle;
	}

	public void setDatasetTitle(String datasetTitle) {
		this.datasetTitle = datasetTitle;
	}

	public void unsetDatasetTitle() {
		datasetTitle = null;
	}

	public boolean isSetDatasetReferenceDate() {
		return datasetReferenceDate != null;
	}

	public ZonedDateTime getDatasetReferenceDate() {
		return datasetReferenceDate;
	}

	public void setDatasetReferenceDate(ZonedDateTime datasetReferenceDate) {
		this.datasetReferenceDate = datasetReferenceDate;
	}

	public void setDatasetReferenceDate(LocalDate datasetReferenceDate) {
		this.datasetReferenceDate = datasetReferenceDate.atStartOfDay(ZoneId.systemDefault());
	}

	public void setDatasetReferenceDate(LocalDateTime datasetReferenceDate) {
		this.datasetReferenceDate = datasetReferenceDate.atZone(ZoneId.systemDefault());
	}

	public void unsetDatasetReferenceDate() {
		datasetReferenceDate = null;
	}

	public boolean isSetGeographicLocation() {
		return geographicLocation != null;
	}

	public String getGeographicLocation() {
		return geographicLocation;
	}

	public void setGeographicLocation(String geographicLocation) {
		this.geographicLocation = geographicLocation;
	}

	public void unsetGeographicLocation() {
		geographicLocation = null;
	}

	public boolean isSetDatasetLanguage() {
		return datasetLanguage != null;
	}

	public String getDatasetLanguage() {
		return datasetLanguage;
	}

	public void setDatasetLanguage(String datasetLanguage) {
		this.datasetLanguage = datasetLanguage;
	}

	public void unsetDatasetLanguage() {
		datasetLanguage = null;
	}

	public boolean isSetDatasetTopicCategory() {
		return datasetTopicCategory != null;
	}

	public String getDatasetTopicCategory() {
		return datasetTopicCategory;
	}

	public void setDatasetTopicCategory(String datasetTopicCategory) {
		this.datasetTopicCategory = datasetTopicCategory;
	}

	public void unsetDatasetTopicCategory() {
		datasetTopicCategory = null;
	}

	public boolean isSetDatasetAbstract() {
		return datasetAbstract != null;
	}

	public String getDatasetAbstract() {
		return datasetAbstract;
	}

	public void setDatasetAbstract(String datasetAbstract) {
		this.datasetAbstract = datasetAbstract;
	}

	public void unsetDatasetAbstract() {
		datasetAbstract = null;
	}

	public boolean isSetMetadataDateStamp() {
		return metadataDateStamp != null;
	}

	public ZonedDateTime getMetadataDateStamp() {
		return metadataDateStamp;
	}

	public void setMetadataDateStamp(ZonedDateTime metadataDateStamp) {
		this.metadataDateStamp = metadataDateStamp;
	}

	public void setMetadataDateStamp(LocalDate metadataDateStamp) {
		this.metadataDateStamp = metadataDateStamp.atStartOfDay(ZoneId.systemDefault());
	}

	public void setMetadataDateStamp(LocalDateTime metadataDateStamp) {
		this.metadataDateStamp = metadataDateStamp.atZone(ZoneId.systemDefault());
	}

	public void unsetMetadataDateStamp() {
		metadataDateStamp = null;
	}

	public boolean isSetPointOfContact() {
		return pointOfContact != null;
	}

	public String getPointOfContact() {
		return pointOfContact;
	}

	public void setPointOfContact(String pointOfContact) {
		this.pointOfContact = pointOfContact;
	}

	public void unsetPointOfContact() {
		pointOfContact = null;
	}

	public boolean isSetCopyright() {
		return copyright != null;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public void unsetCopyright() {
		copyright = null;
	}

	public boolean isSetPresentLoDs() {
		return presentLoDs != null;
	}

	public void addPresentLoD(Number lod) {
		if (lod != null && (lod.doubleValue() < 0.0 || lod.doubleValue() >= 4.0)) {
			if (presentLoDs == null)
				presentLoDs = new ArrayList<>();

			presentLoDs.add(lod);
		}
	}

	public List<Number> getPresentLoDs() {
		return presentLoDs;
	}

	public void setPresentLoDs(List<Number> presentLoDs) {
		if (presentLoDs != null) {
			presentLoDs = new ArrayList<>(presentLoDs);
			presentLoDs.removeIf(lod -> lod.doubleValue() < 0.0 || lod.doubleValue() >= 4.0);
		}

		this.presentLoDs = presentLoDs;
	}
	
	public void unsetPresentLoDs() {
		presentLoDs = null;
	}

}
