package org.citygml4j.model.construction;

import org.xmlobjects.gml.model.common.ChildList;

import java.util.List;

public class Window extends AbstractFillingElement {
    private List<WindowSurfaceProperty> boundarySurfaces;
    private List<ADEPropertyOfWindow> adeProperties;

    @Override
    public List<WindowSurfaceProperty> getBoundarySurfaces() {
        if (boundarySurfaces == null)
            boundarySurfaces = new ChildList<>(this);

        return boundarySurfaces;
    }

    public void setBoundarySurfaces(List<WindowSurfaceProperty> boundarySurfaces) {
        this.boundarySurfaces = asChild(boundarySurfaces);
    }

    public List<ADEPropertyOfWindow> getADEPropertiesOfWindow() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfWindow(List<ADEPropertyOfWindow> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
