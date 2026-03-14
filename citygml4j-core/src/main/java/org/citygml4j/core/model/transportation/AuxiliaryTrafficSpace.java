/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.transportation;

import org.citygml4j.core.model.ade.ADEObject;
import org.citygml4j.core.model.core.AbstractSpaceBoundary;
import org.citygml4j.core.model.core.AbstractUnoccupiedSpace;
import org.citygml4j.core.model.core.ClosureSurface;
import org.citygml4j.core.model.core.StandardObjectClassifier;
import org.citygml4j.core.model.generics.GenericThematicSurface;
import org.citygml4j.core.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class AuxiliaryTrafficSpace extends AbstractUnoccupiedSpace implements StandardObjectClassifier {
    private Code classifier;
    private List<Code> functions;
    private List<Code> usages;
    private GranularityValue granularity;

    public AuxiliaryTrafficSpace() {
    }

    public AuxiliaryTrafficSpace(GranularityValue granularity) {
        this.granularity = granularity;
    }

    @Override
    public boolean isValidBoundary(Class<? extends AbstractSpaceBoundary> type) {
        return AuxiliaryTrafficArea.class.isAssignableFrom(type)
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

    public GranularityValue getGranularity() {
        return granularity;
    }

    public void setGranularity(GranularityValue granularity) {
        this.granularity = granularity;
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
