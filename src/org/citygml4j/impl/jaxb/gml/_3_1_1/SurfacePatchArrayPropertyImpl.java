package org.citygml4j.impl.jaxb.gml._3_1_1;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ObjectFactory;
import org.citygml4j.jaxb.gml._3_1_1.AbstractSurfacePatchType;
import org.citygml4j.jaxb.gml._3_1_1.RectangleType;
import org.citygml4j.jaxb.gml._3_1_1.SurfacePatchArrayPropertyType;
import org.citygml4j.jaxb.gml._3_1_1.TriangleType;
import org.citygml4j.model.gml.AbstractSurfacePatch;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.SurfacePatchArrayProperty;


public class SurfacePatchArrayPropertyImpl extends GMLBaseImpl implements SurfacePatchArrayProperty {
	private SurfacePatchArrayPropertyType surfacePatchArrayPropertyType;

	public SurfacePatchArrayPropertyImpl() {
		surfacePatchArrayPropertyType = new SurfacePatchArrayPropertyType();
	}

	public SurfacePatchArrayPropertyImpl(SurfacePatchArrayPropertyType surfacePatchArrayPropertyType) {
		this.surfacePatchArrayPropertyType = surfacePatchArrayPropertyType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.SURFACEPATCHARRAYPROPERTY;
	}

	@Override
	public SurfacePatchArrayPropertyType getJAXBObject() {
		return surfacePatchArrayPropertyType;
	}

	@Override
	public void addSurfacePatch(AbstractSurfacePatch surfacePatch) {
		JAXBElement<? extends AbstractSurfacePatchType> jaxbElem = null;

		switch (surfacePatch.getGMLClass()) {
		case RECTANGLE:
			jaxbElem = ObjectFactory.GML.createRectangle(((RectangleImpl)surfacePatch).getJAXBObject());
			break;
		case TRIANGLE:
			jaxbElem = ObjectFactory.GML.createTriangle(((TriangleImpl)surfacePatch).getJAXBObject());
			break;
		}

		if (jaxbElem != null)
			surfacePatchArrayPropertyType.get_SurfacePatch().add(jaxbElem);
	}

	@Override
	public List<? extends AbstractSurfacePatch> getSurfacePatch() {
		List<AbstractSurfacePatch> patchList = new ArrayList<AbstractSurfacePatch>();
		List<JAXBElement<? extends AbstractSurfacePatchType>> patchElemList = surfacePatchArrayPropertyType.get_SurfacePatch();

		for (JAXBElement<? extends AbstractSurfacePatchType> patchElem : patchElemList) {
			// according to CityGML v0.4.0 and v1.0 we just support
			// Rectangles and Triangles so far
			if (patchElem.getValue() != null) {
				if (patchElem.getValue() instanceof RectangleType)
					patchList.add(new RectangleImpl((RectangleType)patchElem.getValue()));
				else if (patchElem.getValue() instanceof TriangleType)
					patchList.add(new TriangleImpl((TriangleType)patchElem.getValue()));
			}
		}

		return patchList;
	}

	@Override
	public void setSurfacePatch(List<? extends AbstractSurfacePatch> surfacePatch) {
		List<JAXBElement<? extends AbstractSurfacePatchType>> jaxbElemList = new ArrayList<JAXBElement<? extends AbstractSurfacePatchType>>();

		for (AbstractSurfacePatch patch : surfacePatch) {
			JAXBElement<? extends AbstractSurfacePatchType> jaxbElem = null;

			switch (patch.getGMLClass()) {
			case RECTANGLE:
				jaxbElem = ObjectFactory.GML.createRectangle(((RectangleImpl)surfacePatch).getJAXBObject());
				break;
			case TRIANGLE:
				jaxbElem = ObjectFactory.GML.createTriangle(((TriangleImpl)surfacePatch).getJAXBObject());
				break;
			}	

			if (jaxbElem != null)
				jaxbElemList.add(jaxbElem);
		}

		if (!jaxbElemList.isEmpty()) {
			surfacePatchArrayPropertyType.unset_SurfacePatch();
			surfacePatchArrayPropertyType.get_SurfacePatch().addAll(jaxbElemList);
		}
	}

	@Override
	public boolean isSetSurfacePatch() {
		return surfacePatchArrayPropertyType.isSet_SurfacePatch();
	}

	@Override
	public void unsetSurfacePatch() {
		surfacePatchArrayPropertyType.unset_SurfacePatch();
	}

	@Override
	public boolean unsetSurfacePatch(AbstractSurfacePatch surfacePatch) {
		if (surfacePatchArrayPropertyType.isSet_SurfacePatch())
			return surfacePatchArrayPropertyType.get_SurfacePatch().remove(((AbstractSurfacePatchImpl)surfacePatch).getJAXBObject());
		
		return false;
	}

}