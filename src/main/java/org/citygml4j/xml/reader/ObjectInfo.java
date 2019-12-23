package org.citygml4j.xml.reader;

import org.citygml4j.model.core.AbstractAppearanceProperty;
import org.citygml4j.model.core.AbstractCityObject;
import org.citygml4j.model.core.CityModel;
import org.citygml4j.model.core.EngineeringCRSProperty;
import org.xmlobjects.gml.model.base.AbstractGML;
import org.xmlobjects.gml.model.base.Reference;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.basictypes.CodeWithAuthority;
import org.xmlobjects.gml.model.deprecated.MetaDataProperty;
import org.xmlobjects.gml.model.deprecated.StringOrRef;
import org.xmlobjects.gml.model.feature.AbstractFeature;
import org.xmlobjects.gml.model.feature.BoundingShape;

import javax.xml.namespace.QName;
import java.util.Collections;
import java.util.List;

public class ObjectInfo {
    private final QName name;
    private final AbstractGML object;
    private final CityGMLChunk parent;

    ObjectInfo(QName name, AbstractGML object, CityGMLChunk parent) {
        this.name = name;
        this.object = object;
        this.parent = parent;
    }

    public QName getObjectName() {
        return name;
    }

    public Class<? extends AbstractGML> getObjectType() {
        return object.getClass();
    }

    public boolean hasParentInfo() {
        try {
            return getParentInfo() != null;
        } catch (CityGMLReadException e) {
            return false;
        }
    }

    public ObjectInfo getParentInfo() throws CityGMLReadException {
        return parent != null ? parent.getObjectInfo() : null;
    }

    public String getId() {
        return object.getId();
    }

    public List<MetaDataProperty<?>> getMetaDataProperties() {
       return object.getMetaDataProperties();
    }

    public StringOrRef getDescription() {
        return object.getDescription();
    }

    public Reference getDescriptionReference() {
        return object.getDescriptionReference();
    }

    public CodeWithAuthority getIdentifier() {
        return object.getIdentifier();
    }

    public List<Code> getNames() {
        return object.getNames();
    }

    public BoundingShape getBoundedBy() {
        return object instanceof AbstractFeature ? ((AbstractFeature) object).getBoundedBy() : null;
    }

    public EngineeringCRSProperty getEngineeringCRS() {
        return object instanceof CityModel ? ((CityModel) object).getEngineeringCRS() : null;
    }

    public List<AbstractAppearanceProperty> getAppearances() {
        if (object instanceof AbstractCityObject)
            return ((AbstractCityObject) object).getAppearances();
        else if (object instanceof CityModel)
            return ((CityModel) object).getAppearanceMembers();
        else
            return Collections.emptyList();
    }
}
