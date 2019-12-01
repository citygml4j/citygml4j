package org.citygml4j.model.appearance;

import org.citygml4j.model.core.AbstractAppearance;
import org.citygml4j.visitor.FeatureVisitor;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.model.ChildList;

import java.util.ArrayList;
import java.util.List;

public class Appearance extends AbstractAppearance {
    private String theme;
    private List<AbstractSurfaceDataProperty> surfaceData;
    private List<ADEPropertyOfAppearance<?>> adeProperties;

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public List<AbstractSurfaceDataProperty> getSurfaceData() {
        if (surfaceData == null)
            surfaceData = new ArrayList<>();

        return surfaceData;
    }

    public void setSurfaceData(List<AbstractSurfaceDataProperty> surfaceData) {
        this.surfaceData = asChild(surfaceData);
    }

    public List<ADEPropertyOfAppearance<?>> getADEPropertiesOfAppearance() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfAppearance(List<ADEPropertyOfAppearance<?>> adeProperties) {
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
