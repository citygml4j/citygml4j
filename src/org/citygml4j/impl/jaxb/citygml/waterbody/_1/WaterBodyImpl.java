package org.citygml4j.impl.jaxb.citygml.waterbody._1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.gml._3_1_1.MultiCurvePropertyImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.MultiSurfacePropertyImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.SolidPropertyImpl;
import org.citygml4j.jaxb.citygml.wtr._1.BoundedByWaterSurfacePropertyType;
import org.citygml4j.jaxb.citygml.wtr._1.WaterBodyType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.waterbody.BoundedByWaterSurfaceProperty;
import org.citygml4j.model.citygml.waterbody.WaterBody;
import org.citygml4j.model.gml.AbstractSolid;
import org.citygml4j.model.gml.MultiCurve;
import org.citygml4j.model.gml.MultiCurveProperty;
import org.citygml4j.model.gml.MultiSurface;
import org.citygml4j.model.gml.MultiSurfaceProperty;
import org.citygml4j.model.gml.SolidProperty;

public class WaterBodyImpl extends WaterObjectImpl implements WaterBody {
	private WaterBodyType waterBodyType;

	public WaterBodyImpl() {
		this(new WaterBodyType());
	}

	public WaterBodyImpl(WaterBodyType waterBodyType) {
		super(waterBodyType);
		this.waterBodyType = waterBodyType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.WATERBODY;
	}

	@Override
	public WaterBodyType getJAXBObject() {
		return waterBodyType;
	}

	@Override
	public void addBoundedBySurface(BoundedByWaterSurfaceProperty boundedBySurface) {
		waterBodyType.getBoundedBySurfaces().add(((BoundedByWaterSurfacePropertyImpl)boundedBySurface).getJAXBObject());
	}

	@Override
	public void addFunction(String function) {
		waterBodyType.getFunction().add(function);
	}

	@Override
	public void addUsage(String usage) {
		waterBodyType.getUsage().add(usage);
	}

	@Override
	public List<BoundedByWaterSurfaceProperty> getBoundedBySurfaces() {
		List<BoundedByWaterSurfaceProperty> waterSurfacePropertyList = new ArrayList<BoundedByWaterSurfaceProperty>();

		for (BoundedByWaterSurfacePropertyType waterSurfacePropertyType : waterBodyType.getBoundedBySurfaces())
			waterSurfacePropertyList.add(new BoundedByWaterSurfacePropertyImpl(waterSurfacePropertyType));

		return waterSurfacePropertyList;
	}

	@Override
	public String getClazz() {
		return waterBodyType.getClazz();
	}

	@Override
	public List<String> getFunction() {
		return waterBodyType.getFunction();
	}

	@Override
	public MultiCurveProperty getLod0MultiCurve() {
		if (waterBodyType.isSetLod0MultiCurve())
			return new MultiCurvePropertyImpl(waterBodyType.getLod0MultiCurve());

		return null;
	}

	@Override
	public MultiSurfaceProperty getLod0MultiSurface() {
		if (waterBodyType.isSetLod0MultiSurface())
			return new MultiSurfacePropertyImpl(waterBodyType.getLod0MultiSurface());

		return null;
	}

	@Override
	public MultiCurveProperty getLod1MultiCurve() {
		if (waterBodyType.isSetLod1MultiCurve())
			return new MultiCurvePropertyImpl(waterBodyType.getLod1MultiCurve());

		return null;
	}

	@Override
	public MultiSurfaceProperty getLod1MultiSurface() {
		if (waterBodyType.isSetLod1MultiSurface())
			return new MultiSurfacePropertyImpl(waterBodyType.getLod1MultiSurface());

		return null;
	}

	@Override
	public SolidProperty getLod1Solid() {
		if (waterBodyType.isSetLod1Solid())
			return new SolidPropertyImpl(waterBodyType.getLod1Solid());

		return null;
	}

	@Override
	public SolidProperty getLod2Solid() {
		if (waterBodyType.isSetLod2Solid())
			return new SolidPropertyImpl(waterBodyType.getLod2Solid());

		return null;
	}

	@Override
	public SolidProperty getLod3Solid() {
		if (waterBodyType.isSetLod3Solid())
			return new SolidPropertyImpl(waterBodyType.getLod3Solid());

		return null;
	}

	@Override
	public SolidProperty getLod4Solid() {
		if (waterBodyType.isSetLod4Solid())
			return new SolidPropertyImpl(waterBodyType.getLod4Solid());

		return null;
	}

	@Override
	public List<String> getUsage() {
		return waterBodyType.getUsage();
	}

	@Override
	public void setBoundedBySurfaces(List<BoundedByWaterSurfaceProperty> boundedBySurfaces) {
		List<BoundedByWaterSurfacePropertyType> waterSurfacePropertyTypeList = new ArrayList<BoundedByWaterSurfacePropertyType>();

		for (BoundedByWaterSurfaceProperty waterSurfaceProperty : boundedBySurfaces)
			waterSurfacePropertyTypeList.add(((BoundedByWaterSurfacePropertyImpl)waterSurfaceProperty).getJAXBObject());

		waterBodyType.unsetBoundedBySurfaces();
		waterBodyType.getBoundedBySurfaces().addAll(waterSurfacePropertyTypeList);
	}

	@Override
	public void setClazz(String clazz) {
		waterBodyType.setClazz(clazz);
	}

	@Override
	public void setFunction(List<String> function) {
		waterBodyType.unsetFunction();
		waterBodyType.getFunction().addAll(function);
	}

	@Override
	public void setLod0MultiCurve(MultiCurveProperty lod0MultiCurve) {
		waterBodyType.setLod0MultiCurve(((MultiCurvePropertyImpl)lod0MultiCurve).getJAXBObject());
	}

	@Override
	public void setLod0MultiSurface(MultiSurfaceProperty lod0MultiSurface) {
		waterBodyType.setLod0MultiSurface(((MultiSurfacePropertyImpl)lod0MultiSurface).getJAXBObject());
	}

	@Override
	public void setLod1MultiCurve(MultiCurveProperty lod1MultiCurve) {
		waterBodyType.setLod1MultiCurve(((MultiCurvePropertyImpl)lod1MultiCurve).getJAXBObject());
	}

	@Override
	public void setLod1MultiSurface(MultiSurfaceProperty lod1MultiSurface) {
		waterBodyType.setLod1MultiSurface(((MultiSurfacePropertyImpl)lod1MultiSurface).getJAXBObject());
	}

	@Override
	public void setLod1Solid(SolidProperty lod1Solid) {
		waterBodyType.setLod1Solid(((SolidPropertyImpl)lod1Solid).getJAXBObject());
	}

	@Override
	public void setLod2Solid(SolidProperty lod2Solid) {
		waterBodyType.setLod2Solid(((SolidPropertyImpl)lod2Solid).getJAXBObject());
	}

	@Override
	public void setLod3Solid(SolidProperty lod3Solid) {
		waterBodyType.setLod3Solid(((SolidPropertyImpl)lod3Solid).getJAXBObject());
	}

	@Override
	public void setLod4Solid(SolidProperty lod4Solid) {
		waterBodyType.setLod4Solid(((SolidPropertyImpl)lod4Solid).getJAXBObject());
	}

	@Override
	public void setUsage(List<String> usage) {
		waterBodyType.unsetUsage();
		waterBodyType.getUsage().addAll(usage);
	}

	@Override
	public void calcBoundedBy() {
		SolidProperty solidProperty = null;
		for (int lod = 1; lod < 5; lod++) {
			switch (lod) {
			case 1:
				solidProperty = getLod1Solid();
				break;
			case 2:
				solidProperty = getLod2Solid();
				break;
			case 3:
				solidProperty = getLod3Solid();
				break;
			case 4:
				solidProperty = getLod4Solid();
				break;
			}

			if (solidProperty != null) {
				AbstractSolid abstractSolid = solidProperty.getSolid();
				if (abstractSolid != null) {
					calcBoundedBy(abstractSolid);
				} else {
					// xlink?
				}
			}
		}

		MultiSurfaceProperty multiSurfaceProperty = null;
		for (int lod = 0; lod < 2; lod++) {
			switch (lod) {
			case 0:
				multiSurfaceProperty = getLod0MultiSurface();
				break;
			case 1:
				multiSurfaceProperty = getLod1MultiSurface();
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

		MultiCurveProperty multiCurveProperty = null;
		for (int lod = 0; lod < 2; lod++) {
			switch (lod) {
			case 0:
				multiCurveProperty = getLod0MultiCurve();
				break;
			case 1:
				multiCurveProperty = getLod1MultiCurve();
				break;
			}

			if (multiCurveProperty != null) {
				MultiCurve multiCurve = multiCurveProperty.getMultiCurve();
				if (multiCurve != null) {
					calcBoundedBy(multiCurve);
				} else {
					// xlink?
				}
			}
		}

		if (isSetBoundedBySurfaces()) {
			for (BoundedByWaterSurfaceProperty boundarySurfaceProperty : getBoundedBySurfaces()) {
				if (boundarySurfaceProperty.isSetObject()) {
					calcBoundedBy(boundarySurfaceProperty.getObject());
				} else {
					// xlink?
				}
			}
		}
	}

	@Override
	public void addGenericApplicationPropertyOfWaterBody(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			waterBodyType.get_GenericApplicationPropertyOfWaterBody().add(jaxbElem);
	}

	@Override
	public List<ADEComponent> getGenericApplicationPropertyOfWaterBody() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();

		for (JAXBElement<?> elem : waterBodyType.get_GenericApplicationPropertyOfWaterBody()) {
			if (elem.getValue() != null) {
				ADEComponent ade = ModelMapper.ADE.toADEComponent(elem.getValue(), elem.getName());
				if (ade != null)
					adeList.add(ade);
			}
		}

		return adeList;
	}

	@Override
	public void setGenericApplicationPropertyOfWaterBody(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			waterBodyType.unset_GenericApplicationPropertyOfWaterBody();
			waterBodyType.get_GenericApplicationPropertyOfWaterBody().addAll(elemList);
		}
	}

	@Override
	public boolean isSetBoundedBySurfaces() {
		return waterBodyType.isSetBoundedBySurfaces();
	}

	@Override
	public boolean isSetClazz() {
		return waterBodyType.isSetClazz();
	}

	@Override
	public boolean isSetFunction() {
		return waterBodyType.isSetFunction();
	}

	@Override
	public boolean isSetGenericApplicationPropertyOfWaterBody() {
		return waterBodyType.isSet_GenericApplicationPropertyOfWaterBody();
	}

	@Override
	public boolean isSetLod0MultiCurve() {
		return waterBodyType.isSetLod0MultiCurve();
	}

	@Override
	public boolean isSetLod0MultiSurface() {
		return waterBodyType.isSetLod0MultiSurface();
	}

	@Override
	public boolean isSetLod1MultiCurve() {
		return waterBodyType.isSetLod1MultiCurve();
	}

	@Override
	public boolean isSetLod1MultiSurface() {
		return waterBodyType.isSetLod1MultiSurface();
	}

	@Override
	public boolean isSetLod1Solid() {
		return waterBodyType.isSetLod1Solid();
	}

	@Override
	public boolean isSetLod2Solid() {
		return waterBodyType.isSetLod2Solid();
	}

	@Override
	public boolean isSetLod3Solid() {
		return waterBodyType.isSetLod3Solid();
	}

	@Override
	public boolean isSetLod4Solid() {
		return waterBodyType.isSetLod4Solid();
	}

	@Override
	public boolean isSetUsage() {
		return waterBodyType.isSetUsage();
	}

	@Override
	public void unsetBoundedBySurfaces() {
		waterBodyType.unsetBoundedBySurfaces();
	}

	@Override
	public void unsetClazz() {
		waterBodyType.setClazz(null);
	}

	@Override
	public void unsetFunction() {
		waterBodyType.unsetFunction();
	}

	@Override
	public void unsetGenericApplicationPropertyOfWaterBody() {
		waterBodyType.unset_GenericApplicationPropertyOfWaterBody();
	}

	@Override
	public void unsetLod0MultiCurve() {
		waterBodyType.setLod0MultiCurve(null);
	}

	@Override
	public void unsetLod0MultiSurface() {
		waterBodyType.setLod0MultiSurface(null);
	}

	@Override
	public void unsetLod1MultiCurve() {
		waterBodyType.setLod1MultiCurve(null);
	}

	@Override
	public void unsetLod1MultiSurface() {
		waterBodyType.setLod1MultiSurface(null);
	}

	@Override
	public void unsetLod1Solid() {
		waterBodyType.setLod1Solid(null);
	}

	@Override
	public void unsetLod2Solid() {
		waterBodyType.setLod2Solid(null);
	}

	@Override
	public void unsetLod3Solid() {
		waterBodyType.setLod3Solid(null);
	}

	@Override
	public void unsetLod4Solid() {
		waterBodyType.setLod4Solid(null);
	}

	@Override
	public void unsetUsage() {
		waterBodyType.unsetUsage();
	}
	
	@Override
	public boolean unsetBoundedBySurfaces(BoundedByWaterSurfaceProperty boundedBySurface) {
		if (waterBodyType.isSetBoundedBySurfaces())
			return waterBodyType.getBoundedBySurfaces().remove(((BoundedByWaterSurfacePropertyImpl)boundedBySurface).getJAXBObject());
		
		return false;
	}

	@Override
	public boolean unsetFunction(String function) {
		if (waterBodyType.isSetFunction())
			return waterBodyType.getFunction().remove(function);
		
		return false;
	}

	@Override
	public boolean unsetGenericApplicationPropertyOfWaterBody(ADEComponent adeObject) {
		if (waterBodyType.isSet_GenericApplicationPropertyOfWaterBody()) {
			Iterator<JAXBElement<?>> iter = waterBodyType.get_GenericApplicationPropertyOfWaterBody().iterator();
			while (iter.hasNext()) {
				JAXBElement<?> elem = iter.next();
				if (elem.getValue() != null && elem.getValue() != null) {
					JAXBElement<?> ade = ModelMapper.ADE.toJAXB(adeObject);
					if (ade != null && ade.getValue() != null && elem.getValue().equals(ade.getValue())) {
						iter.remove();
						return true;
					}
				}
			}				
		}

		return false;
	}

	@Override
	public boolean unsetUsage(String usage) {
		if (waterBodyType.isSetUsage())
			return waterBodyType.getUsage().remove(usage);
		
		return false;
	}
	
}
