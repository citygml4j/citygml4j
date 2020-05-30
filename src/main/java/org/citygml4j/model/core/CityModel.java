package org.citygml4j.model.core;

import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class CityModel extends AbstractFeatureWithLifespan {
    private EngineeringCRSProperty engineeringCRS;
    private List<AbstractCityObjectProperty> cityObjectMembers;
    private List<AbstractAppearanceProperty> appearanceMembers;
    private List<AbstractFeatureProperty> featureMembers;
    private List<AbstractVersionProperty> versionMembers;
    private List<AbstractVersionTransitionProperty> versionTransitionMembers;
    private List<ADEOfCityModel> adeOfCityModel;

    public EngineeringCRSProperty getEngineeringCRS() {
        return engineeringCRS;
    }

    public void setEngineeringCRS(EngineeringCRSProperty engineeringCRS) {
        this.engineeringCRS = asChild(engineeringCRS);
    }

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

    public List<AbstractFeatureProperty> getFeatureMembers() {
        if (featureMembers == null)
            featureMembers = new ChildList<>(this);

        return featureMembers;
    }

    public void setFeatureMembers(List<AbstractFeatureProperty> featureMembers) {
        this.featureMembers = asChild(featureMembers);
    }

    public List<AbstractVersionProperty> getVersionMembers() {
        if (versionMembers == null)
            versionMembers = new ChildList<>(this);

        return versionMembers;
    }

    public void setVersionMembers(List<AbstractVersionProperty> versionMembers) {
        this.versionMembers = asChild(versionMembers);
    }

    public List<AbstractVersionTransitionProperty> getVersionTransitionMembers() {
        if (versionTransitionMembers == null)
            versionTransitionMembers = new ChildList<>(this);

        return versionTransitionMembers;
    }

    public void setVersionTransitionMembers(List<AbstractVersionTransitionProperty> versionTransitionMembers) {
        this.versionTransitionMembers = asChild(versionTransitionMembers);
    }

    public List<ADEOfCityModel> getADEOfCityModel() {
        if (adeOfCityModel == null)
            adeOfCityModel = new ChildList<>(this);

        return adeOfCityModel;
    }

    public void setADEOfCityModel(List<ADEOfCityModel> adeOfCityModel) {
        this.adeOfCityModel = asChild(adeOfCityModel);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (cityObjectMembers != null) {
            for (AbstractCityObjectProperty property : cityObjectMembers) {
                if (property.getObject() != null)
                    envelope.include(property.getObject().computeEnvelope(options));
            }
        }

        if (featureMembers != null) {
            for (AbstractFeatureProperty property : featureMembers) {
                if (property.getObject() != null)
                    envelope.include(property.getObject().computeEnvelope(options));
            }
        }

        if (adeOfCityModel != null) {
            for (ADEOfCityModel container : adeOfCityModel)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
