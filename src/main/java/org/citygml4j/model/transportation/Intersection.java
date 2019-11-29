package org.citygml4j.model.transportation;

import org.citygml4j.model.core.AbstractSpaceBoundary;
import org.citygml4j.model.core.ClosureSurface;
import org.citygml4j.model.generics.GenericThematicSurface;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class Intersection extends AbstractTransportationSpace {
    private Code classifier;
    private List<ADEPropertyOfIntersection<?>> adeProperties;

    @Override
    public boolean isValidBoundary(AbstractSpaceBoundary boundary) {
        return boundary instanceof HoleSurface
                || boundary instanceof ClosureSurface
                || boundary instanceof GenericThematicSurface;
    }

    public Code getClassifier() {
        return classifier;
    }

    public void setClassifier(Code classifier) {
        this.classifier = asChild(classifier);
    }

    public List<ADEPropertyOfIntersection<?>> getADEPropertiesOfIntersection() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfIntersection(List<ADEPropertyOfIntersection<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
