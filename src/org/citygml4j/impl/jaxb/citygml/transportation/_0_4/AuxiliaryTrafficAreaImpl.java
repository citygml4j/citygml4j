package org.citygml4j.impl.jaxb.citygml.transportation._0_4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.gml._3_1_1.MultiSurfacePropertyImpl;
import org.citygml4j.jaxb.citygml._0_4.AuxiliaryTrafficAreaType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.transportation.AuxiliaryTrafficArea;
import org.citygml4j.model.gml.MultiSurface;
import org.citygml4j.model.gml.MultiSurfaceProperty;

public class AuxiliaryTrafficAreaImpl extends TransportationObjectImpl implements AuxiliaryTrafficArea {
	private AuxiliaryTrafficAreaType auxiliaryTrafficAreaType;

	public AuxiliaryTrafficAreaImpl() {
		this(new AuxiliaryTrafficAreaType());
	}

	public AuxiliaryTrafficAreaImpl(AuxiliaryTrafficAreaType auxiliaryTrafficAreaType) {
		super(auxiliaryTrafficAreaType);
		this.auxiliaryTrafficAreaType = auxiliaryTrafficAreaType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.AUXILIARYTRAFFICAREA;
	}

	@Override
	public AuxiliaryTrafficAreaType getJAXBObject() {
		return auxiliaryTrafficAreaType;
	}

	@Override
	public void addFunction(String function) {
		auxiliaryTrafficAreaType.getFunction().add(function);
	}

	@Override
	public List<String> getFunction() {
		return auxiliaryTrafficAreaType.getFunction();
	}

	@Override
	public MultiSurfaceProperty getLod2MultiSurface() {
		if (auxiliaryTrafficAreaType.isSetLod2MultiSurface())
			return new MultiSurfacePropertyImpl(auxiliaryTrafficAreaType.getLod2MultiSurface());

		return null;
	}

	@Override
	public MultiSurfaceProperty getLod3MultiSurface() {
		if (auxiliaryTrafficAreaType.isSetLod3MultiSurface())
			return new MultiSurfacePropertyImpl(auxiliaryTrafficAreaType.getLod3MultiSurface());

		return null;
	}

	@Override
	public MultiSurfaceProperty getLod4MultiSurface() {
		if (auxiliaryTrafficAreaType.isSetLod4MultiSurface())
			return new MultiSurfacePropertyImpl(auxiliaryTrafficAreaType.getLod4MultiSurface());

		return null;
	}

	@Override
	public String getSurfaceMaterial() {
		return auxiliaryTrafficAreaType.getSurfaceMaterial();
	}

	@Override
	public void setFunction(List<String> function) {
		auxiliaryTrafficAreaType.unsetFunction();
		auxiliaryTrafficAreaType.getFunction().addAll(function);
	}

	@Override
	public void setLod2MultiSurface(MultiSurfaceProperty lod2MultiSurface) {
		auxiliaryTrafficAreaType.setLod2MultiSurface(((MultiSurfacePropertyImpl)lod2MultiSurface).getJAXBObject());
	}

	@Override
	public void setLod3MultiSurface(MultiSurfaceProperty lod3MultiSurface) {
		auxiliaryTrafficAreaType.setLod3MultiSurface(((MultiSurfacePropertyImpl)lod3MultiSurface).getJAXBObject());
	}

	@Override
	public void setLod4MultiSurface(MultiSurfaceProperty lod4MultiSurface) {
		auxiliaryTrafficAreaType.setLod4MultiSurface(((MultiSurfacePropertyImpl)lod4MultiSurface).getJAXBObject());
	}

	@Override
	public void setSurfaceMaterial(String surfaceMaterial) {
		auxiliaryTrafficAreaType.setSurfaceMaterial(surfaceMaterial);
	}

	@Override
	public void calcBoundedBy() {
		MultiSurfaceProperty multiSurfaceProperty = null;

		for (int lod = 2; lod < 5; lod++) {
			switch (lod) {
			case 2:
				multiSurfaceProperty = getLod2MultiSurface();
				break;
			case 3:
				multiSurfaceProperty = getLod3MultiSurface();
				break;
			case 4:
				multiSurfaceProperty = getLod4MultiSurface();
				break;
			}

			if (multiSurfaceProperty != null) {
				MultiSurface multiSurface = multiSurfaceProperty.getMultiSurface();
				if (multiSurface != null) {
					calcBoundedBy(multiSurface);
				} else {
					// xlink?
				}
			}
		}
	}

	@Override
	public void addGenericApplicationPropertyOfAuxiliaryTrafficArea(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			auxiliaryTrafficAreaType.get_GenericApplicationPropertyOfAuxiliaryTrafficArea().add(jaxbElem);
	}

	@Override
	public List<ADEComponent> getGenericApplicationPropertyOfAuxiliaryTrafficArea() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();
		List<JAXBElement<?>> elemList = auxiliaryTrafficAreaType.get_GenericApplicationPropertyOfAuxiliaryTrafficArea();

		for (JAXBElement<?> elem : elemList) {
			if (elem.getValue() != null) {
				ADEComponent ade = ModelMapper.ADE.toADEComponent(elem.getValue(), elem.getName());
				if (ade != null)
					adeList.add(ade);
			}
		}

		return adeList;
	}

	@Override
	public void setGenericApplicationPropertyOfAuxiliaryTrafficArea(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			auxiliaryTrafficAreaType.unset_GenericApplicationPropertyOfAuxiliaryTrafficArea();
			auxiliaryTrafficAreaType.get_GenericApplicationPropertyOfAuxiliaryTrafficArea().addAll(elemList);
		}
	}

	@Override
	public boolean isSetFunction() {
		return auxiliaryTrafficAreaType.isSetFunction();
	}

	@Override
	public boolean isSetGenericApplicationPropertyOfAuxiliaryTrafficArea() {
		return auxiliaryTrafficAreaType.isSet_GenericApplicationPropertyOfAuxiliaryTrafficArea();
	}

	@Override
	public boolean isSetLod2MultiSurface() {
		return auxiliaryTrafficAreaType.isSetLod2MultiSurface();
	}

	@Override
	public boolean isSetLod3MultiSurface() {
		return auxiliaryTrafficAreaType.isSetLod3MultiSurface();
	}

	@Override
	public boolean isSetLod4MultiSurface() {
		return auxiliaryTrafficAreaType.isSetLod4MultiSurface();
	}

	@Override
	public boolean isSetSurfaceMaterial() {
		return auxiliaryTrafficAreaType.isSetSurfaceMaterial();
	}

	@Override
	public void unsetFunction() {
		auxiliaryTrafficAreaType.unsetFunction();
	}

	@Override
	public void unsetGenericApplicationPropertyOfAuxiliaryTrafficArea() {
		auxiliaryTrafficAreaType.unset_GenericApplicationPropertyOfAuxiliaryTrafficArea();
	}

	@Override
	public void unsetLod2MultiSurface() {
		auxiliaryTrafficAreaType.setLod2MultiSurface(null);
	}

	@Override
	public void unsetLod3MultiSurface() {
		auxiliaryTrafficAreaType.setLod3MultiSurface(null);
	}

	@Override
	public void unsetLod4MultiSurface() {
		auxiliaryTrafficAreaType.setLod4MultiSurface(null);
	}

	@Override
	public void unsetSurfaceMaterial() {
		auxiliaryTrafficAreaType.setSurfaceMaterial(null);
	}

	@Override
	public boolean unsetFunction(String function) {
		if (auxiliaryTrafficAreaType.isSetFunction())
			return auxiliaryTrafficAreaType.getFunction().remove(function);
		
		return false;
	}

	@Override
	public boolean unsetGenericApplicationPropertyOfAuxiliaryTrafficArea(ADEComponent adeObject) {
		if (auxiliaryTrafficAreaType.isSet_GenericApplicationPropertyOfAuxiliaryTrafficArea()) {
			Iterator<JAXBElement<?>> iter = auxiliaryTrafficAreaType.get_GenericApplicationPropertyOfAuxiliaryTrafficArea().iterator();
			while (iter.hasNext()) {
				JAXBElement<?> elem = iter.next();
				if (elem.getValue() != null && elem.getValue().equals(adeObject.getJAXBObject())) {
					iter.remove();
					return true;
				}
			}				
		}

		return false;
	}

}
