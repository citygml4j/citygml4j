package org.citygml4j.model.common;

import org.citygml4j.visitor.FeatureVisitor;

public interface VisitableFeature extends VisitableObject {
    void accept(FeatureVisitor visitor);
}
