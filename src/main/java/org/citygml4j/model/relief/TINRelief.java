package org.citygml4j.model.relief;

import org.xmlobjects.model.ChildList;

import java.util.List;

public class TINRelief extends AbstractReliefComponent {
    private TinProperty tin;
    private List<ADEPropertyOfTINRelief> adeProperties;

    public TINRelief() {
    }

    public TINRelief(int lod, TinProperty tin) {
        super(lod);
        setTin(tin);
    }

    public TinProperty getTin() {
        return tin;
    }

    public void setTin(TinProperty tin) {
        this.tin = asChild(tin);
    }

    public List<ADEPropertyOfTINRelief> getADEPropertiesOfTINRelief() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfTINRelief(List<ADEPropertyOfTINRelief> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
