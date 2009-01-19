package org.citygml4j.impl.jaxb.citygml.transportation._1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.gml._3_1_1.MultiSurfacePropertyImpl;
import org.citygml4j.jaxb.citygml.tran._1.TrafficAreaType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.transportation.TrafficArea;
import org.citygml4j.model.gml.MultiSurface;
import org.citygml4j.model.gml.MultiSurfaceProperty;

public class TrafficAreaImpl extends TransportationObjectImpl implements TrafficArea {
	private TrafficAreaType trafficAreaType;

	public TrafficAreaImpl() {
		this(new TrafficAreaType());
	}

	public TrafficAreaImpl(TrafficAreaType trafficAreaType) {
		super(trafficAreaType);
		this.trafficAreaType = trafficAreaType;
	}

	@Override
	public TrafficAreaType getJAXBObject() {
		return trafficAreaType;
	}

	@Override
	public void addFunction(String function) {
		trafficAreaType.getFunction().add(function);
	}

	@Override
	public void addUsage(String usage) {
		trafficAreaType.getUsage().add(usage);
	}

	@Override
	public List<String> getFunction() {
		return trafficAreaType.getFunction();
	}

	@Override
	public MultiSurfaceProperty getLod2MultiSurface() {
		if (trafficAreaType.isSetLod2MultiSurface())
			return new MultiSurfacePropertyImpl(trafficAreaType.getLod2MultiSurface());

		return null;
	}

	@Override
	public MultiSurfaceProperty getLod3MultiSurface() {
		if (trafficAreaType.isSetLod3MultiSurface())
			return new MultiSurfacePropertyImpl(trafficAreaType.getLod3MultiSurface());

		return null;
	}

	@Override
	public MultiSurfaceProperty getLod4MultiSurface() {
		if (trafficAreaType.isSetLod4MultiSurface())
			return new MultiSurfacePropertyImpl(trafficAreaType.getLod4MultiSurface());

		return null;
	}

	@Override
	public String getSurfaceMaterial() {
		return trafficAreaType.getSurfaceMaterial();
	}

	@Override
	public List<String> getUsage() {
		return trafficAreaType.getUsage();
	}

	@Override
	public void setFunction(List<String> function) {
		trafficAreaType.unsetFunction();
		trafficAreaType.getFunction().addAll(function);
	}

	@Override
	public void setLod2MultiSurface(MultiSurfaceProperty lod2MultiSurface) {
		trafficAreaType.setLod2MultiSurface(((MultiSurfacePropertyImpl)lod2MultiSurface).getJAXBObject());
	}

	@Override
	public void setLod3MultiSurface(MultiSurfaceProperty lod3MultiSurface) {
		trafficAreaType.setLod3MultiSurface(((MultiSurfacePropertyImpl)lod3MultiSurface).getJAXBObject());
	}

	@Override
	public void setLod4MultiSurface(MultiSurfaceProperty lod4MultiSurface) {
		trafficAreaType.setLod4MultiSurface(((MultiSurfacePropertyImpl)lod4MultiSurface).getJAXBObject());
	}

	@Override
	public void setSurfaceMaterial(String surfaceMaterial) {
		trafficAreaType.setSurfaceMaterial(surfaceMaterial);
	}

	@Override
	public void setUsage(List<String> usage) {
		trafficAreaType.unsetUsage();
		trafficAreaType.getUsage().addAll(usage);
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
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TRAFFICAREA;
	}

	@Override
	public void addGenericApplicationPropertyOfTrafficArea(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			trafficAreaType.get_GenericApplicationPropertyOfTrafficArea().add(jaxbElem);
	}

	@Override
	public List<ADEComponent> getGenericApplicationPropertyOfTrafficArea() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();

		for (JAXBElement<?> elem : trafficAreaType.get_GenericApplicationPropertyOfTrafficArea()) {
			if (elem.getValue() != null) {
				ADEComponent ade = ModelMapper.ADE.toADEComponent(elem.getValue(), elem.getName());
				if (ade != null)
					adeList.add(ade);
			}
		}

		return adeList;
	}

	@Override
	public void setGenericApplicationPropertyOfTrafficArea(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			trafficAreaType.unset_GenericApplicationPropertyOfTrafficArea();
			trafficAreaType.get_GenericApplicationPropertyOfTrafficArea().addAll(elemList);
		}
	}

	@Override
	public boolean isSetFunction() {
		return trafficAreaType.isSetFunction();
	}

	@Override
	public boolean isSetGenericApplicationPropertyOfTrafficArea() {
		return trafficAreaType.isSet_GenericApplicationPropertyOfTrafficArea();
	}

	@Override
	public boolean isSetLod2MultiSurface() {
		return trafficAreaType.isSetLod2MultiSurface();
	}

	@Override
	public boolean isSetLod3MultiSurface() {
		return trafficAreaType.isSetLod3MultiSurface();
	}

	@Override
	public boolean isSetLod4MultiSurface() {
		return trafficAreaType.isSetLod4MultiSurface();
	}

	@Override
	public boolean isSetSurfaceMaterial() {
		return trafficAreaType.isSetSurfaceMaterial();
	}

	@Override
	public boolean isSetUsage() {
		return trafficAreaType.isSetUsage();
	}

	@Override
	public void unsetFuntion() {
		trafficAreaType.unsetFunction();
	}

	@Override
	public void unsetGenericApplicationPropertyOfTrafficArea() {
		trafficAreaType.unset_GenericApplicationPropertyOfTrafficArea();
	}

	@Override
	public void unsetLod2MultiSurface() {
		trafficAreaType.setLod2MultiSurface(null);
	}

	@Override
	public void unsetLod3MultiSurface() {
		trafficAreaType.setLod3MultiSurface(null);
	}

	@Override
	public void unsetLod4MultiSurface() {
		trafficAreaType.setLod4MultiSurface(null);
	}

	@Override
	public void unsetSurfaceMaterial() {
		trafficAreaType.setSurfaceMaterial(null);
	}

	@Override
	public void unsetUsage() {
		trafficAreaType.unsetUsage();
	}
	
	@Override
	public boolean unsetFuntion(String function) {
		if (trafficAreaType.isSetFunction())
			return trafficAreaType.getFunction().remove(function);
		
		return false;
	}

	@Override
	public boolean unsetGenericApplicationPropertyOfTrafficArea(ADEComponent adeObject) {
		if (trafficAreaType.isSet_GenericApplicationPropertyOfTrafficArea()) {
			Iterator<JAXBElement<?>> iter = trafficAreaType.get_GenericApplicationPropertyOfTrafficArea().iterator();
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

	@Override
	public boolean unsetUsage(String usage) {
		if (trafficAreaType.isSetUsage())
			return trafficAreaType.getUsage().remove(usage);
		
		return false;
	}
	
}
