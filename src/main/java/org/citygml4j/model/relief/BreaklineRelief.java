package org.citygml4j.model.relief;

import org.xmlobjects.gml.model.geometry.aggregates.MultiCurveProperty;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class BreaklineRelief extends AbstractReliefComponent {
    private MultiCurveProperty ridgeOrValleyLines;
    private MultiCurveProperty breaklines;
    private List<ADEPropertyOfBreaklineRelief<?>> adeProperties;

    public BreaklineRelief() {
    }

    public BreaklineRelief(int lod) {
        super(lod);
    }

    public static BreaklineRelief ofRidgeOrValleyLines(int lod, MultiCurveProperty ridgeOrValleyLines) {
        BreaklineRelief relief = new BreaklineRelief(lod);
        relief.setRidgeOrValleyLines(ridgeOrValleyLines);
        return relief;
    }

    public static BreaklineRelief ofBreaklines(int lod, MultiCurveProperty breaklines) {
        BreaklineRelief relief = new BreaklineRelief(lod);
        relief.setBreaklines(breaklines);
        return relief;
    }

    public MultiCurveProperty getRidgeOrValleyLines() {
        return ridgeOrValleyLines;
    }

    public void setRidgeOrValleyLines(MultiCurveProperty ridgeOrValleyLines) {
        this.ridgeOrValleyLines = asChild(ridgeOrValleyLines);
    }

    public MultiCurveProperty getBreaklines() {
        return breaklines;
    }

    public void setBreaklines(MultiCurveProperty breaklines) {
        this.breaklines = asChild(breaklines);
    }

    public List<ADEPropertyOfBreaklineRelief<?>> getADEPropertiesOfBreaklineRelief() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfBreaklineRelief(List<ADEPropertyOfBreaklineRelief<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
