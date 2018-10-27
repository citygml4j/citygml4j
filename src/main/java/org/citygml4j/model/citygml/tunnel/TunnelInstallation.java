/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citygml4j.model.citygml.tunnel;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.ade.binding.ADEBoundingBoxHelper;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.ImplicitRepresentationProperty;
import org.citygml4j.model.citygml.core.LodRepresentation;
import org.citygml4j.model.citygml.core.StandardObjectClassifier;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;
import org.citygml4j.model.module.citygml.TunnelModule;
import org.citygml4j.util.bbox.BoundingBoxOptions;

import java.util.List;

public class TunnelInstallation extends AbstractCityObject implements TunnelModuleComponent, StandardObjectClassifier {
	private Code clazz;
	private List<Code> function;
	private List<Code> usage;
	private GeometryProperty<? extends AbstractGeometry> lod2Geometry;
	private GeometryProperty<? extends AbstractGeometry> lod3Geometry;
	private GeometryProperty<? extends AbstractGeometry> lod4Geometry;
	private ImplicitRepresentationProperty lod2ImplicitRepresentation;
	private ImplicitRepresentationProperty lod3ImplicitRepresentation;
	private ImplicitRepresentationProperty lod4ImplicitRepresentation;
	private List<BoundarySurfaceProperty> boundedBySurface;
	private List<ADEComponent> ade;
	private TunnelModule module;
	
	public TunnelInstallation() {
		
	}
	
	public TunnelInstallation(TunnelModule module) {
		this.module = module;
	}
	
	public ImplicitRepresentationProperty getLod2ImplicitRepresentation() {
		return lod2ImplicitRepresentation;
	}
	
	public ImplicitRepresentationProperty getLod3ImplicitRepresentation() {
		return lod3ImplicitRepresentation;
	}
	
	public ImplicitRepresentationProperty getLod4ImplicitRepresentation() {
		return lod4ImplicitRepresentation;
	}
	
	public boolean isSetLod2ImplicitRepresentation() {
		return lod2ImplicitRepresentation != null;
	}
	
	public boolean isSetLod3ImplicitRepresentation() {
		return lod3ImplicitRepresentation != null;
	}
	
	public boolean isSetLod4ImplicitRepresentation() {
		return lod4ImplicitRepresentation != null;
	}
	
	public void setLod2ImplicitRepresentation(ImplicitRepresentationProperty lod2ImplicitRepresentation) {
		if (lod2ImplicitRepresentation != null)
			lod2ImplicitRepresentation.setParent(this);

		this.lod2ImplicitRepresentation = lod2ImplicitRepresentation;
	}
	
	public void setLod3ImplicitRepresentation(ImplicitRepresentationProperty lod3ImplicitRepresentation) {
		if (lod3ImplicitRepresentation != null)
			lod3ImplicitRepresentation.setParent(this);

		this.lod3ImplicitRepresentation = lod3ImplicitRepresentation;
	}

	public void setLod4ImplicitRepresentation(ImplicitRepresentationProperty lod4ImplicitRepresentation) {
		if (lod4ImplicitRepresentation != null)
			lod4ImplicitRepresentation.setParent(this);

		this.lod4ImplicitRepresentation = lod4ImplicitRepresentation;
	}
	
	public void unsetLod2ImplicitRepresentation() {
		if (isSetLod2ImplicitRepresentation())
			lod2ImplicitRepresentation.unsetParent();

		lod2ImplicitRepresentation = null;
	}
	
	public void unsetLod3ImplicitRepresentation() {
		if (isSetLod3ImplicitRepresentation())
			lod3ImplicitRepresentation.unsetParent();

		lod3ImplicitRepresentation = null;
	}
	
	public void unsetLod4ImplicitRepresentation() {
		if (isSetLod4ImplicitRepresentation())
			lod4ImplicitRepresentation.unsetParent();

		lod4ImplicitRepresentation = null;
	}
	
	public void addBoundedBySurface(BoundarySurfaceProperty boundedBySurface) {
		if (this.boundedBySurface == null)
			this.boundedBySurface = new ChildList<BoundarySurfaceProperty>(this);

		this.boundedBySurface.add(boundedBySurface);
	}
	
	public List<BoundarySurfaceProperty> getBoundedBySurface() {
		if (boundedBySurface == null)
			boundedBySurface = new ChildList<BoundarySurfaceProperty>(this);

		return boundedBySurface;
	}
	
	public boolean isSetBoundedBySurface() {
		return boundedBySurface != null && !boundedBySurface.isEmpty();
	}
	
	public void setBoundedBySurface(List<BoundarySurfaceProperty> boundedBySurface) {
		this.boundedBySurface = new ChildList<BoundarySurfaceProperty>(this, boundedBySurface);
	}
	
	public void unsetBoundedBySurface() {
		if (isSetBoundedBySurface())
			boundedBySurface.clear();

		boundedBySurface = null;
	}

	public boolean unsetBoundedBySurface(BoundarySurfaceProperty boundedBySurface) {
		return isSetBoundedBySurface() ? this.boundedBySurface.remove(boundedBySurface) : false;
	}
	
	public void addFunction(Code function) {
		if (this.function == null)
			this.function = new ChildList<Code>(this);

		this.function.add(function);
	}
	
	public void addUsage(Code function) {
		if (this.usage == null)
			this.usage = new ChildList<Code>(this);

		this.usage.add(function);
	}

	public void addGenericApplicationPropertyOfTunnelInstallation(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public Code getClazz() {
		return clazz;
	}

	public List<Code> getFunction() {
		if (function == null)
			function = new ChildList<Code>(this);

		return function;
	}
	
	public List<Code> getUsage() {
		if (usage == null)
			usage = new ChildList<Code>(this);

		return usage;
	}
	
	public List<ADEComponent> getGenericApplicationPropertyOfTunnelInstallation() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public GeometryProperty<? extends AbstractGeometry> getLod2Geometry() {
		return lod2Geometry;
	}

	public GeometryProperty<? extends AbstractGeometry> getLod3Geometry() {
		return lod3Geometry;
	}

	public GeometryProperty<? extends AbstractGeometry> getLod4Geometry() {
		return lod4Geometry;
	}

	public boolean isSetClazz() {
		return clazz != null;
	}

	public boolean isSetFunction() {
		return function != null && !function.isEmpty();
	}
	
	public boolean isSetUsage() {
		return usage != null && !usage.isEmpty();
	}

	public boolean isSetGenericApplicationPropertyOfTunnelInstallation() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetLod2Geometry() {
		return lod2Geometry != null;
	}

	public boolean isSetLod3Geometry() {
		return lod3Geometry != null;
	}

	public boolean isSetLod4Geometry() {
		return lod4Geometry != null;
	}

	public void setClazz(Code clazz) {
		this.clazz = clazz;
	}

	public void setFunction(List<Code> function) {
		this.function = new ChildList<Code>(this, function);
	}
	
	public void setUsage(List<Code> usage) {
		this.usage = new ChildList<Code>(this, usage);
	}

	public void setGenericApplicationPropertyOfTunnelInstallation(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void setLod2Geometry(GeometryProperty<? extends AbstractGeometry> lod2Geometry) {
		if (lod2Geometry != null)
			lod2Geometry.setParent(this);
		
		this.lod2Geometry = lod2Geometry;
	}

	public void setLod3Geometry(GeometryProperty<? extends AbstractGeometry> lod3Geometry) {
		if (lod3Geometry != null)
			lod3Geometry.setParent(this);
		
		this.lod3Geometry = lod3Geometry;
	}

	public void setLod4Geometry(GeometryProperty<? extends AbstractGeometry> lod4Geometry) {
		if (lod4Geometry != null)
			lod4Geometry.setParent(this);
		
		this.lod4Geometry = lod4Geometry;
	}

	public void unsetClazz() {
		clazz = null;
	}

	public void unsetFunction() {
		function = null;
	}

	public boolean unsetFunction(Code function) {
		return isSetFunction() ? this.function.remove(function) : false;
	}
	
	public void unsetUsage() {
		usage = null;
	}

	public boolean unsetUsage(Code usage) {
		return isSetUsage() ? this.usage.remove(usage) : false;
	}

	public void unsetGenericApplicationPropertyOfTunnelInstallation() {
		if (isSetGenericApplicationPropertyOfTunnelInstallation())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfTunnelInstallation(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfTunnelInstallation() ? this.ade.remove(ade) : false;
	}

	public void unsetLod2Geometry() {
		if (isSetLod2Geometry())
			lod2Geometry.unsetParent();
		
		lod2Geometry = null;
	}

	public void unsetLod3Geometry() {
		if (isSetLod3Geometry())
			lod3Geometry.unsetParent();
		
		lod3Geometry = null;
	}

	public void unsetLod4Geometry() {
		if (isSetLod4Geometry())
			lod4Geometry.unsetParent();
		
		lod4Geometry = null;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TUNNEL_INSTALLATION;
	}

	public final TunnelModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public BoundingShape calcBoundedBy(BoundingBoxOptions options) {
		BoundingShape boundedBy = super.calcBoundedBy(options);
		if (options.isUseExistingEnvelopes() && !boundedBy.isEmpty())
			return boundedBy;
		
		GeometryProperty<? extends AbstractGeometry> geometryProperty = null;
		for (int lod = 2; lod < 5; lod++) {
			switch (lod) {
			case 2:
				geometryProperty = lod2Geometry;
				break;
			case 3:
				geometryProperty = lod3Geometry;
				break;
			case 4:
				geometryProperty = lod4Geometry;
				break;
			}
			
			if (geometryProperty != null) {
				if (geometryProperty.isSetGeometry()) {
					boundedBy.updateEnvelope(geometryProperty.getGeometry().calcBoundingBox());
				} else {
					// xlink
				}
			}
		}
		
		ImplicitRepresentationProperty implicitRepresentation = null;
		for (int lod = 2; lod < 5; lod++) {
			switch (lod) {
			case 2:
				implicitRepresentation = lod2ImplicitRepresentation;
				break;
			case 3:
				implicitRepresentation = lod3ImplicitRepresentation;
				break;
			case 4:
				implicitRepresentation = lod4ImplicitRepresentation;
				break;
			}

			if (implicitRepresentation != null && implicitRepresentation.isSetImplicitGeometry())
				boundedBy.updateEnvelope(implicitRepresentation.getImplicitGeometry().calcBoundingBox(options));
		}
		
		if (isSetBoundedBySurface()) {
			for (BoundarySurfaceProperty boundarySurfaceProperty : getBoundedBySurface()) {
				if (boundarySurfaceProperty.isSetObject()) {
					boundedBy.updateEnvelope(boundarySurfaceProperty.getObject().calcBoundedBy(options).getEnvelope());
				} else {
					// xlink?
				}
			}
		}
		
		if (isSetGenericApplicationPropertyOfTunnelInstallation()) {
			for (ADEComponent ade : getGenericApplicationPropertyOfTunnelInstallation()) {
				if (ade.getADEClass() == ADEClass.MODEL_OBJECT)
					boundedBy.updateEnvelope(ADEBoundingBoxHelper.calcBoundedBy((ADEModelObject)ade, this, options).getEnvelope());
			}
		}
		
		if (options.isAssignResultToFeatures())
			setBoundedBy(boundedBy);
		
		return boundedBy;
	}

	@Override
	public LodRepresentation getLodRepresentation() {
		LodRepresentation lodRepresentation = new LodRepresentation();
		
		GeometryProperty<? extends AbstractGeometry> property = null;		
		for (int lod = 2; lod < 5; lod++) {
			switch (lod) {
			case 2:
				property = lod2Geometry;
				break;
			case 3:
				property = lod3Geometry;
				break;
			case 4:
				property = lod4Geometry;
				break;
			}
			
			if (property != null)
				lodRepresentation.addRepresentation(lod, property);
		}
		
		ImplicitRepresentationProperty implicitRepresentation = null;
		for (int lod = 2; lod < 5; lod++) {
			switch (lod) {
			case 2:
				implicitRepresentation = lod2ImplicitRepresentation;
				break;
			case 3:
				implicitRepresentation = lod3ImplicitRepresentation;
				break;
			case 4:
				implicitRepresentation = lod4ImplicitRepresentation;
				break;
			}

			if (implicitRepresentation != null)
				lodRepresentation.addRepresentation(lod, implicitRepresentation);
		}
		
		return lodRepresentation;
	}
	
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new TunnelInstallation(), copyBuilder);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		TunnelInstallation copy = (target == null) ? new TunnelInstallation() : (TunnelInstallation)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetClazz())
			copy.setClazz((Code)copyBuilder.copy(clazz));

		if (isSetFunction()) {
			for (Code part : function) {
				Code copyPart = (Code)copyBuilder.copy(part);
				copy.addFunction(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetUsage()) {
			for (Code part : usage) {
				Code copyPart = (Code)copyBuilder.copy(part);
				copy.addUsage(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetLod2Geometry()) {
			copy.setLod2Geometry((GeometryProperty<? extends AbstractGeometry>)copyBuilder.copy(lod2Geometry));
			if (copy.getLod2Geometry() == lod2Geometry)
				lod2Geometry.setParent(this);
		}
		
		if (isSetLod3Geometry()) {
			copy.setLod3Geometry((GeometryProperty<? extends AbstractGeometry>)copyBuilder.copy(lod3Geometry));
			if (copy.getLod3Geometry() == lod3Geometry)
				lod3Geometry.setParent(this);
		}
		
		if (isSetLod4Geometry()) {
			copy.setLod4Geometry((GeometryProperty<? extends AbstractGeometry>)copyBuilder.copy(lod4Geometry));
			if (copy.getLod4Geometry() == lod4Geometry)
				lod4Geometry.setParent(this);
		}
		
		if (isSetLod2ImplicitRepresentation()) {
			copy.setLod2ImplicitRepresentation((ImplicitRepresentationProperty)copyBuilder.copy(lod2ImplicitRepresentation));
			if (copy.getLod2ImplicitRepresentation() == lod2ImplicitRepresentation)
				lod2ImplicitRepresentation.setParent(this);
		}

		if (isSetLod3ImplicitRepresentation()) {
			copy.setLod3ImplicitRepresentation((ImplicitRepresentationProperty)copyBuilder.copy(lod3ImplicitRepresentation));
			if (copy.getLod3ImplicitRepresentation() == lod3ImplicitRepresentation)
				lod3ImplicitRepresentation.setParent(this);
		}

		if (isSetLod4ImplicitRepresentation()) {
			copy.setLod4ImplicitRepresentation((ImplicitRepresentationProperty)copyBuilder.copy(lod4ImplicitRepresentation));
			if (copy.getLod4ImplicitRepresentation() == lod4ImplicitRepresentation)
				lod4ImplicitRepresentation.setParent(this);
		}
		
		if (isSetBoundedBySurface()) {
			for (BoundarySurfaceProperty part : boundedBySurface) {
				BoundarySurfaceProperty copyPart = (BoundarySurfaceProperty)copyBuilder.copy(part);
				copy.addBoundedBySurface(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetGenericApplicationPropertyOfTunnelInstallation()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfTunnelInstallation(copyPart);

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
