package org.citygml4j.model.core;

import org.citygml4j.util.Envelopes;
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
    private List<ADEPropertyOfCityModel<?>> adeProperties;

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

    public List<ADEPropertyOfCityModel<?>> getADEPropertiesOfCityModel() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfCityModel(List<ADEPropertyOfCityModel<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
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

        if (adeProperties != null) {
            for (ADEPropertyOfCityModel<?> property : adeProperties)
                Envelopes.updateEnvelope(property, envelope, options);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
