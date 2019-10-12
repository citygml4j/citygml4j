package org.citygml4j.model.core;

import org.citygml4j.model.versioning.VersionProperty;
import org.citygml4j.model.versioning.VersionTransitionProperty;
import org.xmlobjects.gml.model.common.ChildList;
import org.xmlobjects.gml.model.feature.FeatureProperty;

import java.util.List;

public class CityModel extends AbstractFeatureWithLifespan {
    private List<AbstractCityObjectProperty> cityObjectMembers;
    private List<AbstractAppearanceProperty> appearanceMembers;
    private List<FeatureProperty> featureMembers;
    private List<VersionProperty> versionMembers;
    private List<VersionTransitionProperty> versionTransitionMembers;
    private List<ADEPropertyOfCityModel> adeProperties;

    public List<AbstractCityObjectProperty> getCityObjectMembers() {
        if (cityObjectMembers == null)
            cityObjectMembers = new ChildList<>(this);

        return cityObjectMembers;
    }

    public void setCityObjectMembers(List<AbstractCityObjectProperty> cityObjectMembers) {
        this.cityObjectMembers = asChild(cityObjectMembers);
    }

    public List<AbstractAppearanceProperty> getAppearanceMembers() {
        if (appearanceMembers == null)
            appearanceMembers = new ChildList<>(this);

        return appearanceMembers;
    }

    public void setAppearanceMembers(List<AbstractAppearanceProperty> appearanceMembers) {
        this.appearanceMembers = asChild(appearanceMembers);
    }

    public List<FeatureProperty> getFeatureMembers() {
        if (featureMembers == null)
            featureMembers = new ChildList<>(this);

        return featureMembers;
    }

    public void setFeatureMembers(List<FeatureProperty> featureMembers) {
        this.featureMembers = asChild(featureMembers);
    }

    public List<VersionProperty> getVersionMembers() {
        if (versionMembers == null)
            versionMembers = new ChildList<>(this);

        return versionMembers;
    }

    public void setVersionMembers(List<VersionProperty> versionMembers) {
        this.versionMembers = asChild(versionMembers);
    }

    public List<VersionTransitionProperty> getVersionTransitionMembers() {
        if (versionTransitionMembers == null)
            versionTransitionMembers = new ChildList<>(this);

        return versionTransitionMembers;
    }

    public void setVersionTransitionMembers(List<VersionTransitionProperty> versionTransitionMembers) {
        this.versionTransitionMembers = asChild(versionTransitionMembers);
    }

    public List<ADEPropertyOfCityModel> getADEPropertiesOfCityModel() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfCityModel(List<ADEPropertyOfCityModel> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
