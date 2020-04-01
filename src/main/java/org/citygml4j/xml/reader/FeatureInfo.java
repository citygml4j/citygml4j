package org.citygml4j.xml.reader;

import org.citygml4j.model.core.AbstractAppearanceProperty;
import org.citygml4j.model.core.AbstractCityObject;
import org.citygml4j.model.core.AbstractFeature;
import org.citygml4j.model.core.CityModel;
import org.citygml4j.model.core.EngineeringCRSProperty;
import org.xmlobjects.gml.model.base.Reference;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.basictypes.CodeWithAuthority;
import org.xmlobjects.gml.model.deprecated.MetaDataProperty;
import org.xmlobjects.gml.model.deprecated.StringOrRef;
import org.xmlobjects.gml.model.feature.BoundingShape;

import javax.xml.namespace.QName;
import java.util.Collections;
import java.util.List;

public class FeatureInfo {
    private final QName name;
    private final AbstractFeature feature;
    private final CityGMLChunk parent;

    FeatureInfo(QName name, AbstractFeature feature, CityGMLChunk parent) {
        this.name = name;
        this.feature = feature;
        this.parent = parent;
    }

    public QName getTypeName() {
        return name;
    }

    public Class<? extends AbstractFeature> getType() {
        return feature.getClass();
    }

    public boolean hasParentInfo() {
        try {
            return getParentInfo() != null;
        } catch (CityGMLReadException e) {
            return false;
        }
    }

    public FeatureInfo getParentInfo() throws CityGMLReadException {
        return parent != null ? parent.getFeatureInfo() : null;
    }

    public String getId() {
        return feature.getId();
    }

    public List<MetaDataProperty<?>> getMetaDataProperties() {
       return feature.getMetaDataProperties();
    }

    public StringOrRef getDescription() {
        return feature.getDescription();
    }

    public Reference getDescriptionReference() {
        return feature.getDescriptionReference();
    }

    public CodeWithAuthority getIdentifier() {
        return feature.getIdentifier();
    }

    public List<Code> getNames() {
        return feature.getNames();
    }

    public BoundingShape getBoundedBy() {
        return feature.getBoundedBy();
    }

    public EngineeringCRSProperty getEngineeringCRS() {
        return feature instanceof CityModel ? ((CityModel) feature).getEngineeringCRS() : null;
    }

    public List<AbstractAppearanceProperty> getAppearances() {
        if (feature instanceof AbstractCityObject)
            return ((AbstractCityObject) feature).getAppearances();
        else if (feature instanceof CityModel)
            return ((CityModel) feature).getAppearanceMembers();
        else
            return Collections.emptyList();
    }
}
