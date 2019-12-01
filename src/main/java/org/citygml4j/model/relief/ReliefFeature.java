package org.citygml4j.model.relief;

import org.citygml4j.model.core.AbstractSpaceBoundary;
import org.citygml4j.visitor.FeatureVisitor;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class ReliefFeature extends AbstractSpaceBoundary {
    private int lod;
    private List<AbstractReliefComponentProperty> reliefComponents;
    private List<ADEPropertyOfReliefFeature<?>> adeProperties;

    public ReliefFeature() {
    }

    public ReliefFeature(int lod, List<AbstractReliefComponentProperty> reliefComponents) {
        setLod(lod);
        setReliefComponents(reliefComponents);
    }

    public int getLod() {
        return lod;
    }

    public void setLod(int lod) {
        if (lod >= 0)
            this.lod = lod;
    }

    public List<AbstractReliefComponentProperty> getReliefComponents() {
        if (reliefComponents == null)
            reliefComponents = new ChildList<>(this);

        return reliefComponents;
    }

    public void setReliefComponents(List<AbstractReliefComponentProperty> reliefComponents) {
        this.reliefComponents = asChild(reliefComponents);
    }

    public List<ADEPropertyOfReliefFeature<?>> getADEPropertiesOfReliefFeature() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfReliefFeature(List<ADEPropertyOfReliefFeature<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void accept(FeatureVisitor visitor) {
        visitor.visit(this);
    }
}
