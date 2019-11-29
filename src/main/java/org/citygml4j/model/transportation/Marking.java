package org.citygml4j.model.transportation;

import org.citygml4j.model.core.AbstractThematicSurface;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class Marking extends AbstractThematicSurface {
    private Code classifier;
    private List<ADEPropertyOfMarking<?>> adeProperties;

    public Code getClassifier() {
        return classifier;
    }

    public void setClassifier(Code classifier) {
        this.classifier = asChild(classifier);
    }

    public List<ADEPropertyOfMarking<?>> getADEPropertiesOfMarking() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfMarking(List<ADEPropertyOfMarking<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
