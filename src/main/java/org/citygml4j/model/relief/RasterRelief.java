package org.citygml4j.model.relief;

import org.citygml4j.util.Envelopes;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class RasterRelief extends AbstractReliefComponent {
    private GridProperty grid;
    private List<ADEPropertyOfRasterRelief<?>> adeProperties;

    public RasterRelief() {
    }

    public RasterRelief(int lod, GridProperty grid) {
        super(lod);
        setGrid(grid);
    }

    public GridProperty getGrid() {
        return grid;
    }

    public void setGrid(GridProperty grid) {
        this.grid = asChild(grid);
    }

    public List<ADEPropertyOfRasterRelief<?>> getADEPropertiesOfRasterRelief() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfRasterRelief(List<ADEPropertyOfRasterRelief<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (grid != null && grid.getObject() != null)
            envelope.include(grid.getObject().computeEnvelope(options));

        if (adeProperties != null) {
            for (ADEPropertyOfRasterRelief<?> property : adeProperties)
                Envelopes.updateEnvelope(property, envelope, options);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}