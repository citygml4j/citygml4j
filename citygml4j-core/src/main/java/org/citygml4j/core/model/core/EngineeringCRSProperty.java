/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.core;

import org.xmlobjects.gml.model.base.AbstractMetadataProperty;
import org.xmlobjects.gml.model.base.AssociationAttributes;
import org.xmlobjects.gml.model.basictypes.NilReason;
import org.xmlobjects.gml.model.common.GenericElement;
import org.xmlobjects.gml.model.xlink.ActuateType;
import org.xmlobjects.gml.model.xlink.ShowType;

public class EngineeringCRSProperty extends AbstractMetadataProperty<GenericElement> implements AssociationAttributes {
    private String href;
    private String role;
    private String arcRole;
    private String title;
    private ShowType show;
    private ActuateType actuate;
    private NilReason nilReason;
    private String remoteSchema;

    public EngineeringCRSProperty() {
    }

    public EngineeringCRSProperty(GenericElement element) {
        setGenericElement(element);
    }

    public EngineeringCRSProperty(String href) {
        this.href = href;
    }

    @Override
    public GenericElement getGenericElement() {
        return super.getObject();
    }

    @Override
    public boolean isSetGenericElement() {
        return super.isSetObject();
    }

    @Override
    public void setGenericElement(GenericElement genericElement) {
        super.setObject(genericElement);
    }

    @Override
    public Class<GenericElement> getTargetType() {
        return GenericElement.class;
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
