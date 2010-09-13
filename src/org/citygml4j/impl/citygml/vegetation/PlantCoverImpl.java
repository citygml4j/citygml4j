package org.citygml4j.impl.citygml.vegetation;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.feature.BoundingShapeImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.LodRepresentation;
import org.citygml4j.model.citygml.vegetation.PlantCover;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;
import org.citygml4j.model.gml.geometry.aggregates.MultiSolidProperty;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurfaceProperty;
import org.citygml4j.model.gml.measures.Length;
import org.citygml4j.model.module.citygml.VegetationModule;

public class PlantCoverImpl extends AbstractVegetationObjectImpl implements PlantCover {
	private String clazz;
	private List<String> function;
	private Length averageHeight;
	private MultiSurfaceProperty lod1MultiSurface;
	private MultiSurfaceProperty lod2MultiSurface;
	private MultiSurfaceProperty lod3MultiSurface;
	private MultiSurfaceProperty lod4MultiSurface;
	private MultiSolidProperty lod1MultiSolid;
	private MultiSolidProperty lod2MultiSolid;
	private MultiSolidProperty lod3MultiSolid;
	private List<ADEComponent> ade;

	public PlantCoverImpl() {

	}

	public PlantCoverImpl(VegetationModule module) {
		super(module);
	}

	public void addFunction(String function) {
		if (this.function == null)
			this.function = new ArrayList<String>();

		this.function.add(function);
	}

	public void addGenericApplicationPropertyOfPlantCover(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public Length getAverageHeight() {
		return averageHeight;
	}

	public String getClazz() {
		return clazz;
	}

	public List<String> getFunction() {
		if (function == null)
			function = new ArrayList<String>();

		return function;
	}

	public List<ADEComponent> getGenericApplicationPropertyOfPlantCover() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public MultiSolidProperty getLod1MultiSolid() {
		return lod1MultiSolid;
	}

	public MultiSurfaceProperty getLod1MultiSurface() {
		return lod1MultiSurface;
	}

	public MultiSolidProperty getLod2MultiSolid() {
		return lod2MultiSolid;
	}

	public MultiSurfaceProperty getLod2MultiSurface() {
		return lod2MultiSurface;
	}

	public MultiSolidProperty getLod3MultiSolid() {
		return lod3MultiSolid;
	}

	public MultiSurfaceProperty getLod3MultiSurface() {
		return lod3MultiSurface;
	}

	public MultiSurfaceProperty getLod4MultiSurface() {
		return lod4MultiSurface;
	}

	public boolean isSetAverageHeight() {
		return averageHeight != null;
	}

	public boolean isSetClazz() {
		return clazz != null;
	}

	public boolean isSetFunction() {
		return function != null && !function.isEmpty();
	}

	public boolean isSetGenericApplicationPropertyOfPlantCover() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetLod1MultiSolid() {
		return lod1MultiSolid != null;
	}

	public boolean isSetLod1MultiSurface() {
		return lod1MultiSurface != null;
	}

	public boolean isSetLod2MultiSolid() {
		return lod2MultiSolid != null;
	}

	public boolean isSetLod2MultiSurface() {
		return lod2MultiSurface != null;
	}

	public boolean isSetLod3MultiSolid() {
		return lod3MultiSolid != null;
	}

	public boolean isSetLod3MultiSurface() {
		return lod3MultiSurface != null;
	}

	public boolean isSetLod4MultiSurface() {
		return lod4MultiSurface != null;
	}

	public void setAverageHeight(Length averageHeight) {
		if (averageHeight != null)
			averageHeight.setParent(this);

		this.averageHeight = averageHeight;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public void setFunction(List<String> function) {
		this.function = function;
	}

	public void setGenericApplicationPropertyOfPlantCover(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void setLod1MultiSolid(MultiSolidProperty lod1MultiSolid) {
		if (lod1MultiSolid != null)
			lod1MultiSolid.setParent(this);

		this.lod1MultiSolid = lod1MultiSolid;
	}

	public void setLod1MultiSurface(MultiSurfaceProperty lod1MultiSurface) {
		if (lod1MultiSurface != null)
			lod1MultiSurface.setParent(this);

		this.lod1MultiSurface = lod1MultiSurface;
	}

	public void setLod2MultiSolid(MultiSolidProperty lod2MultiSolid) {
		if (lod2MultiSolid != null)
			lod2MultiSolid.setParent(this);

		this.lod2MultiSolid = lod2MultiSolid;
	}

	public void setLod2MultiSurface(MultiSurfaceProperty lod2MultiSurface) {
		if (lod2MultiSurface != null)
			lod2MultiSurface.setParent(this);

		this.lod2MultiSurface = lod2MultiSurface;
	}

	public void setLod3MultiSolid(MultiSolidProperty lod3MultiSolid) {
		if (lod3MultiSolid != null)
			lod3MultiSolid.setParent(this);

		this.lod3MultiSolid = lod3MultiSolid;
	}

	public void setLod3MultiSurface(MultiSurfaceProperty lod3MultiSurface) {
		if (lod3MultiSurface != null)
			lod3MultiSurface.setParent(this);

		this.lod3MultiSurface = lod3MultiSurface;
	}

	public void setLod4MultiSurface(MultiSurfaceProperty lod4MultiSurface) {
		if (lod4MultiSurface != null)
			lod4MultiSurface.setParent(this);

		this.lod4MultiSurface = lod4MultiSurface;
	}

	public void unsetAverageHeight() {
		if (isSetAverageHeight())
			averageHeight.unsetParent();

		averageHeight = null;
	}

	public void unsetClazz() {
		clazz = null;
	}

	public void unsetFunction() {
		function = null;
	}

	public boolean unsetFunction(String function) {
		return isSetFunction() ? this.function.remove(function) : false;
	}

	public void unsetGenericApplicationPropertyOfPlantCover() {
		if (isSetGenericApplicationPropertyOfPlantCover())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfPlantCover(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfPlantCover() ? this.ade.remove(ade) : false;
	}

	public void unsetLod1MultiSolid() {
		if (isSetLod1MultiSolid())
			lod1MultiSolid.unsetParent();

		lod1MultiSolid = null;
	}

	public void unsetLod1MultiSurface() {
		if (isSetLod1MultiSurface())
			lod1MultiSurface.unsetParent();

		lod1MultiSurface = null;
	}

	public void unsetLod2MultiSolid() {
		if (isSetLod2MultiSolid())
			lod2MultiSolid.unsetParent();

		lod2MultiSolid = null;
	}

	public void unsetLod2MultiSurface() {
		if (isSetLod2MultiSurface())
			lod2MultiSurface.unsetParent();

		lod2MultiSurface = null;
	}

	public void unsetLod3MultiSolid() {
		if (isSetLod3MultiSolid())
			lod3MultiSolid.unsetParent();

		lod3MultiSolid = null;
	}

	public void unsetLod3MultiSurface() {
		if (isSetLod3MultiSurface())
			lod3MultiSurface.unsetParent();

		lod3MultiSurface = null;
	}

	public void unsetLod4MultiSurface() {
		if (isSetLod4MultiSurface())
			lod4MultiSurface.unsetParent();

		lod4MultiSurface = null;
	}

	@Override
	public BoundingShape calcBoundedBy(boolean setBoundedBy) {
		BoundingShape boundedBy = new BoundingShapeImpl();

		MultiSolidProperty multiSolidProperty = null;
		for (int lod = 1; lod < 4; lod++) {
			switch (lod) {
			case 1:
				multiSolidProperty = lod1MultiSolid;
				break;
			case 2:
				multiSolidProperty = lod2MultiSolid;
				break;
			case 3:
				multiSolidProperty = lod3MultiSolid;
				break;
			}

			if (multiSolidProperty != null) {
				if (multiSolidProperty.isSetMultiSolid()) {
					calcBoundedBy(boundedBy, multiSolidProperty.getMultiSolid());
				} else {
					// xlink
				}
			}
		}

		MultiSurfaceProperty multiSurfaceProperty = null;
		for (int lod = 1; lod < 5; lod++) {
			switch (lod) {
			case 1:
				multiSurfaceProperty = lod1MultiSurface;
				break;
			case 2:
				multiSurfaceProperty = lod2MultiSurface;
				break;
			case 3:
				multiSurfaceProperty = lod3MultiSurface;
				break;
			case 4:
				multiSurfaceProperty = lod4MultiSurface;
				break;
			}

			if (multiSurfaceProperty != null) {
				if (multiSurfaceProperty.isSetMultiSurface()) {
					calcBoundedBy(boundedBy, multiSurfaceProperty.getMultiSurface());
				} else {
					// xlink
				}
			}
		}

		if (boundedBy.isSetEnvelope()) {
			if (setBoundedBy)
				setBoundedBy(boundedBy);

			return boundedBy;
		} else
			return null;
	}
	
	@Override
	public LodRepresentation getLodRepresentation() {
		LodRepresentation lodRepresentation = new LodRepresentation();
		
		GeometryProperty<? extends AbstractGeometry> property = null;		
		for (int lod = 1; lod < 4; lod++) {
			switch (lod) {
			case 1:
				property = lod1MultiSolid;
				break;
			case 2:
				property = lod2MultiSolid;
				break;
			case 3:
				property = lod3MultiSolid;
				break;
			}
			
			if (property != null)
				lodRepresentation.getLodGeometry(lod).add(property);
		}
		
		property = null;
		for (int lod = 1; lod < 5; lod++) {
			switch (lod) {
			case 1:
				property = lod1MultiSurface;
				break;
			case 2:
				property = lod2MultiSurface;
				break;
			case 3:
				property = lod3MultiSurface;
				break;
			case 4:
				property = lod4MultiSurface;
				break;
			}
			
			if (property != null)
				lodRepresentation.getLodGeometry(lod).add(property);
		}
		
		return lodRepresentation;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.PLANT_COVER;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new PlantCoverImpl(), copyBuilder);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		PlantCover copy = (target == null) ? new PlantCoverImpl() : (PlantCover)target;
		super.copyTo(copy, copyBuilder);

		if (isSetClazz())
			copy.setClazz(copyBuilder.copy(clazz));

		if (isSetFunction())
			copy.setFunction((List<String>)copyBuilder.copy(function));

		if (isSetAverageHeight()) {
			copy.setAverageHeight((Length)copyBuilder.copy(averageHeight));
			if (copy.getAverageHeight() == averageHeight)
				averageHeight.setParent(this);
		}

		if (isSetLod1MultiSurface()) {
			copy.setLod1MultiSurface((MultiSurfaceProperty)copyBuilder.copy(lod1MultiSurface));
			if (copy.getLod1MultiSurface() == lod1MultiSurface)
				lod1MultiSurface.setParent(this);
		}

		if (isSetLod2MultiSurface()) {
			copy.setLod2MultiSurface((MultiSurfaceProperty)copyBuilder.copy(lod2MultiSurface));
			if (copy.getLod2MultiSurface() == lod2MultiSurface)
				lod2MultiSurface.setParent(this);
		}

		if (isSetLod3MultiSurface()) {
			copy.setLod3MultiSurface((MultiSurfaceProperty)copyBuilder.copy(lod3MultiSurface));
			if (copy.getLod3MultiSurface() == lod3MultiSurface)
				lod3MultiSurface.setParent(this);
		}

		if (isSetLod4MultiSurface()) {
			copy.setLod4MultiSurface((MultiSurfaceProperty)copyBuilder.copy(lod4MultiSurface));
			if (copy.getLod4MultiSurface() == lod4MultiSurface)
				lod4MultiSurface.setParent(this);
		}

		if (isSetLod1MultiSolid()) {
			copy.setLod1MultiSolid((MultiSolidProperty)copyBuilder.copy(lod1MultiSolid));
			if (copy.getLod1MultiSolid() == lod1MultiSolid)
				lod1MultiSolid.setParent(this);
		}

		if (isSetLod2MultiSolid()) {
			copy.setLod2MultiSolid((MultiSolidProperty)copyBuilder.copy(lod2MultiSolid));
			if (copy.getLod2MultiSolid() == lod2MultiSolid)
				lod2MultiSolid.setParent(this);
		}

		if (isSetLod3MultiSolid()) {
			copy.setLod3MultiSolid((MultiSolidProperty)copyBuilder.copy(lod3MultiSolid));
			if (copy.getLod3MultiSolid() == lod3MultiSolid)
				lod3MultiSolid.setParent(this);
		}

		if (isSetGenericApplicationPropertyOfPlantCover()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfPlantCover(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		return copy;
	}
	
	public void accept(FeatureVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T accept(FeatureFunctor<T> visitor) {
		return visitor.apply(this);
	}
	
	public void accept(GMLVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T accept(GMLFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
