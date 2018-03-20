package org.citygml4j.binding.cityjson.feature;

import com.google.gson.annotations.JsonAdapter;
import org.citygml4j.binding.cityjson.geometry.AbstractGeometryType;
import org.citygml4j.binding.cityjson.geometry.GeometryTypeName;

import java.util.ArrayList;
import java.util.List;

public class CityObjectGroupType extends AbstractCityObjectType {
    private final CityObjectTypeName type = CityObjectTypeName.CITY_OBJECT_GROUP;
    @JsonAdapter(AttributesAdapter.class)
    private Attributes attributes;
    private List<String> members = new ArrayList<>();

    CityObjectGroupType() {
    }

    public CityObjectGroupType(String gmlId) {
        super(gmlId);
    }

    @Override
    public void addGeometry(AbstractGeometryType geometry) {
        // only a single geometry representation is allowed
        if (geometry != null && isValidGeometryType(geometry.getType())) {
            unsetGeometry();
            super.addGeometry(geometry);
        }
    }

    @Override
    public void setGeometry(List<AbstractGeometryType> geometry) {
        // only a single geometry representation is allowed
        if (geometry != null)
            geometry.stream().filter(g -> isValidGeometryType(g.getType())).findFirst().ifPresent(this::addGeometry);
    }

    @Override
    public CityObjectTypeName getType() {
        return type;
    }

    @Override
    public Attributes newAttributes() {
        attributes = new Attributes();
        return attributes;
    }

    @Override
    public boolean isSetAttributes() {
        return attributes != null;
    }

    @Override
    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    @Override
    public void unsetAttributes() {
        attributes = null;
    }

    public boolean isSetMembers() {
        return !members.isEmpty();
    }

    public void addMember(String member) {
        members.add(member);
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        if (members != null)
            this.members = members;
    }

    public void unsetMembers() {
        members.clear();
    }

    @Override
    public boolean isValidGeometryType(GeometryTypeName type) {
        return true;
    }

}
