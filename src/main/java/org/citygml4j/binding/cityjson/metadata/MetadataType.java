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
package org.citygml4j.binding.cityjson.metadata;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import org.citygml4j.binding.cityjson.feature.DateAdapter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MetadataType {
	private String datasetTitle;
	@JsonAdapter(DateAdapter.class)
	private LocalDate datasetReferenceDate;
	private String geographicLocation;
	private String datasetLanguage;
	private String datasetTopicCategory;
	private String referenceSystem;
	@JsonAdapter(DateAdapter.class)
	private LocalDate metadataDateStamp;
	private List<Double> geographicalExtent;
	@SerializedName("abstract")
	private String datasetAbstract;
	private List<String> keywords;
	private Map<LoDType, Integer> presentLoDs;

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

	public LocalDate getDatasetReferenceDate() {
		return datasetReferenceDate;
	}

	public void setDatasetReferenceDate(ZonedDateTime datasetReferenceDate) {
		this.datasetReferenceDate = datasetReferenceDate.toLocalDate();
	}

	public void setDatasetReferenceDate(LocalDateTime datasetReferenceDate) {
		this.datasetReferenceDate = datasetReferenceDate.toLocalDate();
	}

	public void setDatasetReferenceDate(LocalDate datasetReferenceDate) {
		this.datasetReferenceDate = datasetReferenceDate;
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

	public boolean isSetReferenceSystem() {
		return referenceSystem != null;
	}

	public String getReferenceSystem() {
		return referenceSystem;
	}

	public void setReferenceSystem(int epsg) {
		if (epsg > 999 && epsg < 100000)
			referenceSystem = "urn:ogc:def:crs:EPSG::" + epsg;
	}

	public void unsetReferenceSystem() {
		referenceSystem = null;
	}

	public boolean isSetMetadataDateStamp() {
		return metadataDateStamp != null;
	}

	public LocalDate getMetadataDateStamp() {
		return metadataDateStamp;
	}

	public void setMetadataDateStamp(ZonedDateTime metadataDateStamp) {
		this.metadataDateStamp = metadataDateStamp.toLocalDate();
	}

	public void setMetadataDateStamp(LocalDateTime metadataDateStamp) {
		this.metadataDateStamp = metadataDateStamp.toLocalDate();
	}

	public void setMetadataDateStamp(LocalDate metadataDateStamp) {
		this.metadataDateStamp = metadataDateStamp;
	}

	public void unsetMetadataDateStamp() {
		metadataDateStamp = null;
	}

	public boolean isSetGeographicalExtent() {
		return geographicalExtent != null && geographicalExtent.size() >= 6;
	}

	public List<Double> getGeographicalExtent() {
		return isSetGeographicalExtent() ? geographicalExtent.subList(0, 6) : null;
	}

	public void setGeographicalExtent(List<Double> geographicalExtent) {
		if (geographicalExtent == null)
			this.geographicalExtent = null;
		else if (geographicalExtent.size() >= 6)
			this.geographicalExtent = geographicalExtent.subList(0, 6);
	}

	public void unsetGeographicalExtent() {
		geographicalExtent = null;
	}

	public boolean isSetAbstract() {
		return datasetAbstract != null;
	}

	public String getAbstract() {
		return datasetAbstract;
	}

	public void setAbstract(String datasetAbstract) {
		this.datasetAbstract = datasetAbstract;
	}

	public void unsetAbstract() {
		datasetAbstract = null;
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

	public boolean isSetPresentLoDs() {
		return presentLoDs != null;
	}

	public void addPresentLoD(LoDType lod) {
		if (presentLoDs == null)
			presentLoDs = new HashMap<>();

		presentLoDs.merge(lod, 1, Integer::sum);
	}

	public Map<LoDType, Integer> getPresentLoDs() {
		return presentLoDs;
	}

	public void setPresentLoDs(Map<LoDType, Integer> presentLoDs) {
		if (presentLoDs != null && !presentLoDs.isEmpty())
			this.presentLoDs = presentLoDs;
	}
	
	public void unsetPresentLoDs() {
		presentLoDs = null;
	}

}
