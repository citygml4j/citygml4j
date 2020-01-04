package org.citygml4j.model.building;

import org.citygml4j.model.construction.AbstractConstructionSurface;
import org.citygml4j.model.construction.ElevationProperty;
import org.citygml4j.model.core.AbstractLogicalSpace;
import org.citygml4j.model.core.AbstractSpaceBoundary;
import org.citygml4j.model.core.ClosureSurface;
import org.citygml4j.model.core.StandardObjectClassifier;
import org.citygml4j.model.generics.GenericThematicSurface;
import org.citygml4j.util.Envelopes;
import org.xmlobjects.gml.model.base.Reference;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractBuildingSubdivision extends AbstractLogicalSpace implements StandardObjectClassifier {
    private Code classifier;
    private List<Code> functions;
    private List<Code> usages;
    private List<ElevationProperty> elevations;
    private Double sortKey;
    private List<Reference> buildingConstructiveElements;
    private List<Reference> buildingFurniture;
    private List<Reference> buildingInstallations;
    private List<Reference> buildingRooms;
    private List<ADEPropertyOfAbstractBuildingSubdivision<?>> adeProperties;

    @Override
    public boolean isValidBoundary(AbstractSpaceBoundary boundary) {
        return boundary instanceof AbstractConstructionSurface
                || boundary instanceof ClosureSurface
                || boundary instanceof GenericThematicSurface;
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
    public void setUsages(List<Code> usages) {
        this.usages = asChild(usages);
    }

    public List<ElevationProperty> getElevations() {
        if (elevations == null)
            elevations = new ChildList<>(this);

        return elevations;
    }

    public void setElevations(List<ElevationProperty> elevations) {
        this.elevations = asChild(elevations);
    }

    public Double getSortKey() {
        return sortKey;
    }

    public void setSortKey(Double sortKey) {
        this.sortKey = sortKey;
    }

    public List<Reference> getBuildingConstructiveElements() {
        if (buildingConstructiveElements == null)
            buildingConstructiveElements = new ChildList<>(this);

        return buildingConstructiveElements;
    }

    public void setBuildingConstructiveElements(List<Reference> buildingConstructiveElements) {
        this.buildingConstructiveElements = asChild(buildingConstructiveElements);
    }

    public List<Reference> getBuildingFurniture() {
        if (buildingFurniture == null)
            buildingFurniture = new ChildList<>(this);

        return buildingFurniture;
    }

    public void setBuildingFurniture(List<Reference> buildingFurniture) {
        this.buildingFurniture = asChild(buildingFurniture);
    }

    public List<Reference> getBuildingInstallations() {
        if (buildingInstallations == null)
            buildingInstallations = new ChildList<>(this);

        return buildingInstallations;
    }

    public void setBuildingInstallations(List<Reference> buildingInstallations) {
        this.buildingInstallations = asChild(buildingInstallations);
    }

    public List<Reference> getBuildingRooms() {
        if (buildingRooms == null)
            buildingRooms = new ChildList<>(this);

        return buildingRooms;
    }

    public void setBuildingRooms(List<Reference> buildingRooms) {
        this.buildingRooms = asChild(buildingRooms);
    }

    public List<ADEPropertyOfAbstractBuildingSubdivision<?>> getADEPropertiesOfAbstractBuildingSubdivision() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfAbstractBuildingSubdivision(List<ADEPropertyOfAbstractBuildingSubdivision<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (adeProperties != null) {
            for (ADEPropertyOfAbstractBuildingSubdivision<?> property : adeProperties)
                Envelopes.updateEnvelope(property, envelope, options);
        }
    }
}
