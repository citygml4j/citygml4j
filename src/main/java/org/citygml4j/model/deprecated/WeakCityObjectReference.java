package org.citygml4j.model.deprecated;

import org.citygml4j.model.core.AbstractCityObject;
import org.xmlobjects.gml.model.base.AbstractAssociation;
import org.xmlobjects.gml.model.base.AssociationAttributes;
import org.xmlobjects.gml.model.basictypes.NilReason;
import org.xmlobjects.gml.model.xlink.ActuateType;
import org.xmlobjects.gml.model.xlink.ShowType;

public class WeakCityObjectReference extends AbstractAssociation<AbstractCityObject> implements AssociationAttributes {
    private AbstractCityObject object;
    private String href;
    private String role;
    private String arcRole;
    private String title;
    private ShowType show;
    private ActuateType actuate;
    private NilReason nilReason;
    private String remoteSchema;

    public WeakCityObjectReference() {
    }

    public WeakCityObjectReference(String href) {
        this.href = href;
    }

    public WeakCityObjectReference(AbstractCityObject object) {
        setObject(object);
    }

    public WeakCityObjectReference(AssociationAttributes reference) {
        setReference(reference);
    }

    public AbstractCityObject getObject() {
        return object;
    }

    public void setObject(AbstractCityObject object) {
        this.object = asChild(object);
        if (object != null && object.getId() != null)
            setHref("#" + object.getId());
    }

    public void setReference(AssociationAttributes reference) {
        href = reference.getHref();
        role = reference.getRole();
        arcRole = reference.getArcRole();
        title = reference.getTitle();
        show = reference.getShow();
        actuate = reference.getActuate();
        nilReason = reference.getNilReason();
        remoteSchema = reference.getRemoteSchema();
    }

    @Override
    public Class<AbstractCityObject> getTargetType() {
        return AbstractCityObject.class;
    }

    @Override
    public final String getType() {
        return "simple";
    }

    @Override
    public String getHref() {
        return href;
    }

    @Override
    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public String getRole() {
        return role;
    }

    @Override
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String getArcRole() {
        return arcRole;
    }

    @Override
    public void setArcRole(String arcRole) {
        this.arcRole = arcRole;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public ShowType getShow() {
        return show;
    }

    @Override
    public void setShow(ShowType show) {
        this.show = show;
    }

    @Override
    public ActuateType getActuate() {
        return actuate;
    }

    @Override
    public void setActuate(ActuateType actuate) {
        this.actuate = actuate;
    }

    @Override
    public NilReason getNilReason() {
        return nilReason;
    }

    @Override
    public void setNilReason(NilReason nilReason) {
        this.nilReason = asChild(nilReason);
    }

    @Override
    public String getRemoteSchema() {
        return remoteSchema;
    }

    @Override
    public void setRemoteSchema(String remoteSchema) {
        this.remoteSchema = remoteSchema;
    }
}
