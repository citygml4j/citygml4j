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
package org.citygml4j.binding.cityjson.metadata;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import org.citygml4j.binding.cityjson.feature.DateAdapter;
import org.citygml4j.binding.cityjson.metadata.feature.AbstractFeatureDataType;
import org.citygml4j.binding.cityjson.metadata.feature.FeatureDataAdapter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MetadataType {
	private String citymodelIdentifier;
	private String datasetTitle;
	@JsonAdapter(DateAdapter.class)
	private LocalDate datasetReferenceDate;
	private String geographicLocation;
	private String datasetLanguage;
	private String datasetCharacterSet;
	private DatasetTopicCategoryType datasetTopicCategory;
	private String distributionFormatVersion;
	private SpatialRepresentationType spatialRepresentationType;
	private String referenceSystem;
	private String onlineResource;
	private String fileIdentifier;
	private ContactDetailsType datasetPointOfContact;
	private String metadataStandard;
	private String metadataStandardVersion;
	private String metadataLanguage;
	private String metadataCharacterSet;
	@JsonAdapter(DateAdapter.class)
	private LocalDate metadataDateStamp;
	private ContactDetailsType metadataPointOfContact;
	@SerializedName("lineage")
	private List<LineageType> lineages;
	private List<Double> geographicalExtent;
	private TemporalExtentType temporalExtent;
	@SerializedName("abstract")
	private String datasetAbstract;
	private String specificUsage;
	private List<String> keywords;
	private ConstraintsType constraints;
	private List<ThematicModelType> thematicModels;
	private PresenceType textures;
	private PresenceType materials;
	private Map<LoDType, Integer> presentLoDs;
	@JsonAdapter(FeatureDataAdapter.class)
	private Map<ThematicModelType, AbstractFeatureDataType> cityfeatureMetadata;

	public boolean isSetCitymodelIdentifier() {
		return citymodelIdentifier != null;
	}

	public String getCitymodelIdentifier() {
		return citymodelIdentifier;
	}

	public void setCitymodelIdentifier(String citymodelIdentifier) {
		if (citymodelIdentifier != null && citymodelIdentifier.matches("^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$"))
			this.citymodelIdentifier = citymodelIdentifier;
	}

	public void unsetCitymodelIdentifier() {
		citymodelIdentifier = null;
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

	public boolean isSetDatasetCharacterSet() {
		return datasetCharacterSet != null;
	}

	public String getDatasetCharacterSet() {
		return datasetCharacterSet;
	}

	public void setDatasetCharacterSet(String datasetCharacterSet) {
		this.datasetCharacterSet = datasetCharacterSet;
	}

	public void unsetDatasetCharacterSet() {
		datasetCharacterSet = null;
	}

	public boolean isSetDatasetTopicCategory() {
		return datasetTopicCategory != null;
	}

	public DatasetTopicCategoryType getDatasetTopicCategory() {
		return datasetTopicCategory;
	}

	public void setDatasetTopicCategory(DatasetTopicCategoryType datasetTopicCategory) {
		this.datasetTopicCategory = datasetTopicCategory;
	}

	public void unsetDatasetTopicCategory() {
		datasetTopicCategory = null;
	}

	public boolean isSetDistributionFormatVersion() {
		return distributionFormatVersion != null;
	}

	public String getDistributionFormatVersion() {
		return distributionFormatVersion;
	}

	public void setDistributionFormatVersion(String distributionFormatVersion) {
		if (distributionFormatVersion != null && distributionFormatVersion.matches("\\d\\.\\d"))
			this.distributionFormatVersion = distributionFormatVersion;
	}

	public void unsetDistributionFormatVersion() {
		distributionFormatVersion = null;
	}

	public boolean isSetSpatialRepresentationType() {
		return spatialRepresentationType != null;
	}

	public SpatialRepresentationType getSpatialRepresentationType() {
		return spatialRepresentationType;
	}

	public void setSpatialRepresentationType(SpatialRepresentationType spatialRepresentationType) {
		this.spatialRepresentationType = spatialRepresentationType;
	}

	public void unsetSpatialRepresentationType() {
		spatialRepresentationType = null;
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

	public boolean isSetOnlineResource() {
		return onlineResource != null;
	}

	public String getOnlineResource() {
		return onlineResource;
	}

	public void setOnlineResource(String onlineResource) {
		if (onlineResource != null && onlineResource.matches("^(https?|ftp)://.*"))
			this.onlineResource = onlineResource;
	}

	public void unsetOnlineResource() {
		onlineResource = null;
	}

	public boolean isSetFileIdentifier() {
		return fileIdentifier != null;
	}

	public String getFileIdentifier() {
		return fileIdentifier;
	}

	public void setFileIdentifier(String fileIdentifier) {
		this.fileIdentifier = fileIdentifier;
	}

	public void unsetFileIdentifier() {
		fileIdentifier = null;
	}

	public boolean isSetDatasetPointOfContact() {
		return datasetPointOfContact != null;
	}

	public ContactDetailsType getDatasetPointOfContact() {
		return datasetPointOfContact;
	}

	public void setDatasetPointOfContact(ContactDetailsType datasetPointOfContact) {
		this.datasetPointOfContact = datasetPointOfContact;
	}

	public void unsetDatasetPointOfContact() {
		datasetPointOfContact = null;
	}

	public boolean isSetMetadataStandard() {
		return metadataStandard != null;
	}

	public String getMetadataStandard() {
		return metadataStandard;
	}

	public void setMetadataStandard(String metadataStandard) {
		this.metadataStandard = metadataStandard;
	}

	public void unsetMetadataStandard() {
		metadataStandard = null;
	}

	public boolean isSetMetadataStandardVersion() {
		return metadataStandardVersion != null;
	}

	public String getMetadataStandardVersion() {
		return metadataStandardVersion;
	}

	public void setMetadataStandardVersion(String metadataStandardVersion) {
		if (metadataStandardVersion != null && metadataStandardVersion.matches("\\d\\.\\d"))
			this.metadataStandardVersion = metadataStandardVersion;
	}

	public void unsetMetadataStandardVersion() {
		metadataStandardVersion = null;
	}

	public boolean isSetMetadataLanguage() {
		return metadataLanguage != null;
	}

	public String getMetadataLanguage() {
		return metadataLanguage;
	}

	public void setMetadataLanguage(String metadataLanguage) {
		this.metadataLanguage = metadataLanguage;
	}

	public void unsetMetadataLanguage() {
		metadataLanguage = null;
	}

	public boolean isSetMetadataCharacterSet() {
		return metadataCharacterSet != null;
	}

	public String getMetadataCharacterSet() {
		return metadataCharacterSet;
	}

	public void setMetadataCharacterSet(String metadataCharacterSet) {
		this.metadataCharacterSet = metadataCharacterSet;
	}

	public void unsetMetadataCharacterSet() {
		metadataCharacterSet = null;
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

	public boolean isSetMetadataPointOfContact() {
		return metadataPointOfContact != null;
	}

	public ContactDetailsType getMetadataPointOfContact() {
		return metadataPointOfContact;
	}

	public void setMetadataPointOfContact(ContactDetailsType metadataPointOfContact) {
		this.metadataPointOfContact = metadataPointOfContact;
	}

	public void unsetMetadataPointOfContact() {
		metadataPointOfContact = null;
	}

	public boolean isSetLineages() {
		return lineages != null && !lineages.isEmpty();
	}

	public List<LineageType> getLineages() {
		return lineages;
	}

	public void addLineage(LineageType lineage) {
		if (lineages == null)
			lineages = new ArrayList<>();

		lineages.add(lineage);
	}

	public void setLineages(List<LineageType> lineages) {
		this.lineages = lineages;
	}

	public void unsetLineages() {
		lineages = null;
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

	public boolean isSetTemporalExtent() {
		return temporalExtent != null;
	}

	public TemporalExtentType getTemporalExtent() {
		return temporalExtent;
	}

	public void setTemporalExtent(TemporalExtentType temporalExtent) {
		this.temporalExtent = temporalExtent;
	}

	public void unsetTemporalExtent() {
		temporalExtent = null;
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

	public boolean isSetSpecificUsage() {
		return specificUsage != null;
	}

	public String getSpecificUsage() {
		return specificUsage;
	}

	public void setSpecificUsage(String specificUsage) {
		this.specificUsage = specificUsage;
	}

	public void unsetSpecificUsage() {
		specificUsage = null;
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

	public boolean isSetConstraints() {
		return constraints != null;
	}

	public ConstraintsType getConstraints() {
		return constraints;
	}

	public void setConstraints(ConstraintsType constraints) {
		this.constraints = constraints;
	}

	public void unsetConstraints() {
		constraints = null;
	}

	public boolean isSetThematicModels() {
		return thematicModels != null;
	}

	public List<ThematicModelType> getThematicModels() {
		return thematicModels;
	}

	public void addThematicModel(ThematicModelType thematicModel) {
		if (thematicModels == null)
			thematicModels = new ArrayList<>();

		thematicModels.add(thematicModel);
	}

	public void setThematicModels(List<ThematicModelType> thematicModels) {
		this.thematicModels = thematicModels;
	}

	public void unsetThematicModels() {
		thematicModels = null;
	}

	public boolean isSetTextures() {
		return textures != null;
	}

	public PresenceType getTextures() {
		return textures;
	}

	public void setTextures(PresenceType textures) {
		this.textures = textures;
	}

	public void unsetTextures() {
		textures = null;
	}

	public boolean isSetMaterials() {
		return materials != null;
	}

	public PresenceType getMaterials() {
		return materials;
	}

	public void setMaterials(PresenceType materials) {
		this.materials = materials;
	}

	public void unsetMaterials() {
		materials = null;
	}

	public boolean isSetPresentLoDs() {
		return presentLoDs != null && !presentLoDs.isEmpty();
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
		this.presentLoDs = presentLoDs;
	}
	
	public void unsetPresentLoDs() {
		presentLoDs = null;
	}

	public boolean isSetCityFeatureMetadata() {
		return cityfeatureMetadata != null && !cityfeatureMetadata.isEmpty();
	}

	public void addCityFeatureMetadata(AbstractFeatureDataType featureMetadata) {
		if (cityfeatureMetadata == null)
			cityfeatureMetadata = new HashMap<>();

		cityfeatureMetadata.put(featureMetadata.getType(), featureMetadata);
	}

	public Map<ThematicModelType, AbstractFeatureDataType> getCityFeatureMetadata() {
		return cityfeatureMetadata;
	}

	public void setCityFeatureMetadata(Map<ThematicModelType, AbstractFeatureDataType> cityfeatureMetadata) {
		this.cityfeatureMetadata = cityfeatureMetadata;
	}

	public void unsetCityFeatureMetadata() {
		cityfeatureMetadata = null;
	}
}
