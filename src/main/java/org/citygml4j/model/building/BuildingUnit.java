package org.citygml4j.model.building;

import org.citygml4j.model.core.AddressProperty;
import org.citygml4j.util.Envelopes;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.base.Reference;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class BuildingUnit extends AbstractBuildingSubdivision {
    private List<Reference> storeys;
    private List<AddressProperty> addresses;
    private List<ADEPropertyOfBuildingUnit<?>> adeProperties;

    public List<Reference> getStoreys() {
        if (storeys == null)
            storeys = new ChildList<>(this);

        return storeys;
    }

    public void setStoreys(List<Reference> storeys) {
        this.storeys = asChild(storeys);
    }

    public List<AddressProperty> getAddresses() {
        if (addresses == null)
            addresses = new ChildList<>(this);

        return addresses;
    }

    public void setAddresses(List<AddressProperty> addresses) {
        this.addresses = asChild(addresses);
    }

    public List<ADEPropertyOfBuildingUnit<?>> getADEPropertiesOfBuildingUnit() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfBuildingUnit(List<ADEPropertyOfBuildingUnit<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }

    @Override
    public void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (adeProperties != null) {
            for (ADEPropertyOfBuildingUnit<?> property : adeProperties)
                Envelopes.updateEnvelope(property, envelope, options);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
