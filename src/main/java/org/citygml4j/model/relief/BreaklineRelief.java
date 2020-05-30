package org.citygml4j.model.relief;

import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.model.geometry.aggregates.MultiCurveProperty;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class BreaklineRelief extends AbstractReliefComponent {
    private MultiCurveProperty ridgeOrValleyLines;
    private MultiCurveProperty breaklines;
    private List<ADEOfBreaklineRelief> adeOfBreaklineRelief;

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

    public List<ADEOfBreaklineRelief> getADEOfBreaklineRelief() {
        if (adeOfBreaklineRelief == null)
            adeOfBreaklineRelief = new ChildList<>(this);

        return adeOfBreaklineRelief;
    }

    public void setADEOfBreaklineRelief(List<ADEOfBreaklineRelief> adeOfBreaklineRelief) {
        this.adeOfBreaklineRelief = asChild(adeOfBreaklineRelief);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (ridgeOrValleyLines != null && ridgeOrValleyLines.getObject() != null)
            envelope.include(ridgeOrValleyLines.getObject().computeEnvelope());

        if (breaklines != null && breaklines.getObject() != null)
            envelope.include(breaklines.getObject().computeEnvelope());

        if (adeOfBreaklineRelief != null) {
            for (ADEOfBreaklineRelief container : adeOfBreaklineRelief)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        geometryInfo.addGeometry(getLod(), ridgeOrValleyLines);
        geometryInfo.addGeometry(getLod(), breaklines);

        if (adeProperties != null) {
            for (ADEOfBreaklineRelief<?> property : adeProperties)
                updateGeometryInfo(property, geometryInfo);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
