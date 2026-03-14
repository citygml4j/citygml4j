/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.construction;

import org.citygml4j.core.model.ade.ADEObject;
import org.citygml4j.core.model.core.AbstractSpaceBoundary;
import org.citygml4j.core.model.core.AddressProperty;
import org.citygml4j.core.model.core.ClosureSurface;
import org.citygml4j.core.model.core.StandardObjectClassifier;
import org.citygml4j.core.model.generics.GenericThematicSurface;
import org.citygml4j.core.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class Door extends AbstractFillingElement implements StandardObjectClassifier {
    private Code classifier;
    private List<Code> functions;
    private List<Code> usages;
    private List<AddressProperty> addresses;

    @Override
    public boolean isValidBoundary(Class<? extends AbstractSpaceBoundary> type) {
        return DoorSurface.class.isAssignableFrom(type)
                || ClosureSurface.class.isAssignableFrom(type)
                || GenericThematicSurface.class.isAssignableFrom(type)
                || ADEObject.class.isAssignableFrom(type);
    }

    @Override
    public Code getClassifier() {
        return classifier;
    }

    @Override
    public void setClassifier(Code classifier) {
        this.classifier = asChild(classifier);
    }

    @Override
    public List<Code> getFunctions() {
        if (functions == null)
            functions = new ChildList<>(this);

        return functions;
    }

    @Override
    public boolean isSetFunctions() {
        return functions != null && !functions.isEmpty();
    }

    @Override
    public void setFunctions(List<Code> functions) {
        this.functions = asChild(functions);
    }

    @Override
    public List<Code> getUsages() {
        if (usages == null)
            usages = new ChildList<>(this);

        return usages;
    }

    @Override
    public boolean isSetUsages() {
        return usages != null && !usages.isEmpty();
    }

    @Override
    public void setUsages(List<Code> usages) {
        this.usages = asChild(usages);
    }

    public List<AddressProperty> getAddresses() {
        if (addresses == null)
            addresses = new ChildList<>(this);

        return addresses;
    }

    public boolean isSetAddresses() {
        return addresses != null && !addresses.isEmpty();
    }

    public void setAddresses(List<AddressProperty> addresses) {
        this.addresses = asChild(addresses);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
