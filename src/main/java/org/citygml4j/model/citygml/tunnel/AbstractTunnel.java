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
import org.citygml4j.model.citygml.ade.ADEClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.ade.binding.ADEBoundingBoxHelper;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.citygml.core.AbstractSite;
import org.citygml4j.model.citygml.core.LodRepresentation;
import org.citygml4j.model.citygml.core.StandardObjectClassifier;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;
import org.citygml4j.model.gml.geometry.aggregates.MultiCurveProperty;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurfaceProperty;
import org.citygml4j.model.gml.geometry.primitives.SolidProperty;
import org.citygml4j.model.module.citygml.TunnelModule;
import org.citygml4j.util.bbox.BoundingBoxOptions;

import java.time.LocalDate;
import java.util.List;

public abstract class AbstractTunnel extends AbstractSite implements TunnelModuleComponent, StandardObjectClassifier {
	private Code clazz;
	private List<Code> function;
	private List<Code> usage;
	private LocalDate yearOfConstruction;
	private LocalDate yearOfDemolition;
	private SolidProperty lod1Solid;
	private SolidProperty lod2Solid;
	private SolidProperty lod3Solid;
	private SolidProperty lod4Solid;
	private MultiCurveProperty lod1TerrainIntersection;
	private MultiCurveProperty lod2TerrainIntersection;
	private MultiCurveProperty lod3TerrainIntersection;
	private MultiCurveProperty lod4TerrainIntersection;
	private MultiCurveProperty lod2MultiCurve;
	private MultiCurveProperty lod3MultiCurve;
	private MultiCurveProperty lod4MultiCurve;
	private MultiSurfaceProperty lod1MultiSurface;
	private MultiSurfaceProperty lod2MultiSurface;
	private MultiSurfaceProperty lod3MultiSurface;
	private MultiSurfaceProperty lod4MultiSurface;
	private List<TunnelInstallationProperty> outerTunnelInstallation;
	private List<IntTunnelInstallationProperty> interiorTunnelInstallation;
	private List<BoundarySurfaceProperty> boundedBySurface;
	private List<TunnelPartProperty> tunnelPart;
	private List<InteriorHollowSpaceProperty> interiorHollowSpace;
	private List<ADEComponent> ade;
	private TunnelModule module;	
	
	public AbstractTunnel() {
		
	}
	
	public AbstractTunnel(TunnelModule module) {
		this.module = module;
	}
	
	public void addBoundedBySurface(BoundarySurfaceProperty boundedBySurface) {
		if (this.boundedBySurface == null)
			this.boundedBySurface = new ChildList<BoundarySurfaceProperty>(this);

		this.boundedBySurface.add(boundedBySurface);
	}

	public void addConsistsOfTunnelPart(TunnelPartProperty tunnelPart) {
		if (this.tunnelPart == null)
			this.tunnelPart = new ChildList<TunnelPartProperty>(this);

		this.tunnelPart.add(tunnelPart);
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

	public void addGenericApplicationPropertyOfAbstractTunnel(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public void addInteriorTunnelInstallation(IntTunnelInstallationProperty interiorTunnelInstallation) {
		if (this.interiorTunnelInstallation == null)
			this.interiorTunnelInstallation = new ChildList<IntTunnelInstallationProperty>(this);

		this.interiorTunnelInstallation.add(interiorTunnelInstallation);
	}

	public void addInteriorHollowSpace(InteriorHollowSpaceProperty interiorHollowSpace) {
		if (this.interiorHollowSpace == null)
			this.interiorHollowSpace = new ChildList<InteriorHollowSpaceProperty>(this);

		this.interiorHollowSpace.add(interiorHollowSpace);
	}

	public void addOuterTunnelInstallation(TunnelInstallationProperty outerTunnelInstallation) {
		if (this.outerTunnelInstallation == null)
			this.outerTunnelInstallation = new ChildList<TunnelInstallationProperty>(this);

		this.outerTunnelInstallation.add(outerTunnelInstallation);
	}

	public List<BoundarySurfaceProperty> getBoundedBySurface() {
		if (boundedBySurface == null)
			boundedBySurface = new ChildList<BoundarySurfaceProperty>(this);

		return boundedBySurface;
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

	public List<TunnelPartProperty> getConsistsOfTunnelPart() {
		if (tunnelPart == null)
			tunnelPart = new ChildList<TunnelPartProperty>(this);

		return tunnelPart;
	}

	public List<ADEComponent> getGenericApplicationPropertyOfAbstractTunnel() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public List<IntTunnelInstallationProperty> getInteriorTunnelInstallation() {
		if (interiorTunnelInstallation == null)
			interiorTunnelInstallation = new ChildList<IntTunnelInstallationProperty>(this);

		return interiorTunnelInstallation;
	}

	public List<InteriorHollowSpaceProperty> getInteriorHollowSpace() {
		if (interiorHollowSpace == null)
			interiorHollowSpace = new ChildList<InteriorHollowSpaceProperty>(this);

		return interiorHollowSpace;
	}

	public MultiSurfaceProperty getLod1MultiSurface() {
		return lod1MultiSurface;
	}

	public SolidProperty getLod1Solid() {
		return lod1Solid;
	}

	public MultiCurveProperty getLod1TerrainIntersection() {
		return lod1TerrainIntersection;
	}

	public MultiCurveProperty getLod2MultiCurve() {
		return lod2MultiCurve;
	}

	public MultiSurfaceProperty getLod2MultiSurface() {
		return lod2MultiSurface;
	}

	public SolidProperty getLod2Solid() {
		return lod2Solid;
	}

	public MultiCurveProperty getLod2TerrainIntersection() {
		return lod2TerrainIntersection;
	}

	public MultiCurveProperty getLod3MultiCurve() {
		return lod3MultiCurve;
	}

	public MultiSurfaceProperty getLod3MultiSurface() {
		return lod3MultiSurface;
	}

	public SolidProperty getLod3Solid() {
		return lod3Solid;
	}

	public MultiCurveProperty getLod3TerrainIntersection() {
		return lod3TerrainIntersection;
	}

	public MultiCurveProperty getLod4MultiCurve() {
		return lod4MultiCurve;
	}

	public MultiSurfaceProperty getLod4MultiSurface() {
		return lod4MultiSurface;
	}

	public SolidProperty getLod4Solid() {
		return lod4Solid;
	}

	public MultiCurveProperty getLod4TerrainIntersection() {
		return lod4TerrainIntersection;
	}

	public List<TunnelInstallationProperty> getOuterTunnelInstallation() {
		if (outerTunnelInstallation == null)
			outerTunnelInstallation = new ChildList<TunnelInstallationProperty>(this);

		return outerTunnelInstallation;
	}

	public LocalDate getYearOfConstruction() {
		return yearOfConstruction;
	}

	public LocalDate getYearOfDemolition() {
		return yearOfDemolition;
	}

	public boolean isSetBoundedBySurface() {
		return boundedBySurface != null && !boundedBySurface.isEmpty();
	}

	public boolean isSetClazz() {
		return clazz != null;
	}

	public boolean isSetConsistsOfTunnelPart() {
		return tunnelPart != null && !tunnelPart.isEmpty();
	}

	public boolean isSetFunction() {
		return function != null && !function.isEmpty();
	}

	public boolean isSetGenericApplicationPropertyOfAbstractTunnel() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetInteriorTunnelInstallation() {
		return interiorTunnelInstallation != null && !interiorTunnelInstallation.isEmpty();
	}

	public boolean isSetInteriorHollowSpace() {
		return interiorHollowSpace != null && !interiorHollowSpace.isEmpty();
	}

	public boolean isSetLod1MultiSurface() {
		return lod1MultiSurface != null;
	}

	public boolean isSetLod1Solid() {
		return lod1Solid != null;
	}

	public boolean isSetLod1TerrainIntersection() {
		return lod1TerrainIntersection != null;
	}

	public boolean isSetLod2MultiCurve() {
		return lod2MultiCurve != null;
	}

	public boolean isSetLod2MultiSurface() {
		return lod2MultiSurface != null;
	}

	public boolean isSetLod2Solid() {
		return lod2Solid != null;
	}

	public boolean isSetLod2TerrainIntersection() {
		return lod2TerrainIntersection != null;
	}

	public boolean isSetLod3MultiCurve() {
		return lod3MultiCurve != null;
	}

	public boolean isSetLod3MultiSurface() {
		return lod3MultiSurface != null;
	}

	public boolean isSetLod3Solid() {
		return lod3Solid != null;
	}

	public boolean isSetLod3TerrainIntersection() {
		return lod3TerrainIntersection != null;
	}

	public boolean isSetLod4MultiCurve() {
		return lod4MultiCurve != null;
	}

	public boolean isSetLod4MultiSurface() {
		return lod4MultiSurface != null;
	}

	public boolean isSetLod4Solid() {
		return lod4Solid != null;
	}

	public boolean isSetLod4TerrainIntersection() {
		return lod4TerrainIntersection != null;
	}

	public boolean isSetOuterTunnelInstallation() {
		return outerTunnelInstallation != null && !outerTunnelInstallation.isEmpty();
	}

	public boolean isSetUsage() {
		return usage != null && !usage.isEmpty();
	}

	public boolean isSetYearOfConstruction() {
		return yearOfConstruction != null;
	}

	public boolean isSetYearOfDemolition() {
		return yearOfDemolition != null;
	}

	public void setBoundedBySurface(List<BoundarySurfaceProperty> boundedBySurface) {
		this.boundedBySurface = new ChildList<BoundarySurfaceProperty>(this, boundedBySurface);
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

	public void setConsistsOfTunnelPart(List<TunnelPartProperty> tunnelPart) {
		this.tunnelPart = new ChildList<TunnelPartProperty>(this, tunnelPart);
	}

	public void setGenericApplicationPropertyOfAbstractTunnel(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void setInteriorTunnelInstallation(List<IntTunnelInstallationProperty> interiorTunnelInstallation) {
		this.interiorTunnelInstallation = new ChildList<IntTunnelInstallationProperty>(this, interiorTunnelInstallation);
	}

	public void setInteriorHollowSpace(List<InteriorHollowSpaceProperty> interiorHollowSpace) {
		this.interiorHollowSpace = new ChildList<InteriorHollowSpaceProperty>(this, interiorHollowSpace);
	}

	public void setLod1MultiSurface(MultiSurfaceProperty lod1MultiSurface) {
		if (lod1MultiSurface != null)
			lod1MultiSurface.setParent(this);
		
		this.lod1MultiSurface = lod1MultiSurface;
	}

	public void setLod1Solid(SolidProperty lod1Solid) {
		if (lod1Solid != null)
			lod1Solid.setParent(this);
		
		this.lod1Solid = lod1Solid;
	}

	public void setLod1TerrainIntersection(MultiCurveProperty lod1TerrainIntersection) {
		if (lod1TerrainIntersection != null)
			lod1TerrainIntersection.setParent(this);
		
		this.lod1TerrainIntersection = lod1TerrainIntersection;
	}

	public void setLod2MultiCurve(MultiCurveProperty lod2MultiCurve) {
		if (lod2MultiCurve != null)
			lod2MultiCurve.setParent(this);
		
		this.lod2MultiCurve = lod2MultiCurve;
	}

	public void setLod2MultiSurface(MultiSurfaceProperty lod2MultiSurface) {
		if (lod2MultiSurface != null)
			lod2MultiSurface.setParent(this);
		
		this.lod2MultiSurface = lod2MultiSurface;
	}

	public void setLod2Solid(SolidProperty lod2Solid) {
		if (lod2Solid != null)
			lod2Solid.setParent(this);
		
		this.lod2Solid = lod2Solid;
	}

	public void setLod2TerrainIntersection(MultiCurveProperty lod2TerrainIntersection) {
		if (lod2TerrainIntersection != null)
			lod2TerrainIntersection.setParent(this);
		
		this.lod2TerrainIntersection = lod2TerrainIntersection;
	}

	public void setLod3MultiCurve(MultiCurveProperty lod3MultiCurve) {
		if (lod3MultiCurve != null)
			lod3MultiCurve.setParent(this);
		
		this.lod3MultiCurve = lod3MultiCurve;
	}

	public void setLod3MultiSurface(MultiSurfaceProperty lod3MultiSurface) {
		if (lod3MultiSurface != null)
			lod3MultiSurface.setParent(this);
		
		this.lod3MultiSurface = lod3MultiSurface;
	}

	public void setLod3Solid(SolidProperty lod3Solid) {
		if (lod3Solid != null)
			lod3Solid.setParent(this);
		
		this.lod3Solid = lod3Solid;
	}

	public void setLod3TerrainIntersection(MultiCurveProperty lod3TerrainIntersection) {
		if (lod3TerrainIntersection != null)
			lod3TerrainIntersection.setParent(this);
		
		this.lod3TerrainIntersection = lod3TerrainIntersection;
	}

	public void setLod4MultiCurve(MultiCurveProperty lod4MultiCurve) {
		if (lod4MultiCurve != null)
			lod4MultiCurve.setParent(this);
		
		this.lod4MultiCurve = lod4MultiCurve;
	}

	public void setLod4MultiSurface(MultiSurfaceProperty lod4MultiSurface) {
		if (lod4MultiSurface != null)
			lod4MultiSurface.setParent(this);
		
		this.lod4MultiSurface = lod4MultiSurface;
	}

	public void setLod4Solid(SolidProperty lod4Solid) {
		if (lod4Solid != null)
			lod4Solid.setParent(this);
		
		this.lod4Solid = lod4Solid;
	}

	public void setLod4TerrainIntersection(MultiCurveProperty lod4TerrainIntersection) {
		if (lod4TerrainIntersection != null)
			lod4TerrainIntersection.setParent(this);
		
		this.lod4TerrainIntersection = lod4TerrainIntersection;
	}

	public void setOuterTunnelInstallation(List<TunnelInstallationProperty> outerTunnelInstallation) {
		this.outerTunnelInstallation = new ChildList<TunnelInstallationProperty>(this, outerTunnelInstallation);
	}

	public void setYearOfConstruction(LocalDate yearOfConstruction) {
		this.yearOfConstruction = yearOfConstruction;
	}
	
	public void setYearOfConstruction(int yearOfConstruction) {
		this.yearOfConstruction = LocalDate.of(yearOfConstruction, 1, 1);
	}

	public void setYearOfDemolition(LocalDate yearOfDemolition) {
		this.yearOfDemolition = yearOfDemolition;
	}
	
	public void setYearOfDemolition(int yearOfDemolition) {
		this.yearOfDemolition = LocalDate.of(yearOfDemolition, 1, 1);
	}

	public void unsetBoundedBySurface() {
		if (isSetBoundedBySurface())
			boundedBySurface.clear();

		boundedBySurface = null;
	}

	public boolean unsetBoundedBySurface(BoundarySurfaceProperty boundedBySurface) {
		return isSetBoundedBySurface() ? this.boundedBySurface.remove(boundedBySurface) : false;
	}

	public void unsetClazz() {
		clazz = null;
	}

	public void unsetConsistsOfTunnelPart() {
		if (isSetConsistsOfTunnelPart())
			tunnelPart.clear();

		tunnelPart = null;
	}

	public boolean unsetConsistsOfTunnelPart(TunnelPartProperty tunnelPart) {
		return isSetConsistsOfTunnelPart() ? this.tunnelPart.remove(tunnelPart) : false;
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

	public void unsetGenericApplicationPropertyOfAbstractTunnel() {
		if (isSetGenericApplicationPropertyOfAbstractTunnel())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfAbstractTunnel(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfAbstractTunnel() ? this.ade.remove(ade) : false;	}

	public void unsetInteriorTunnelInstallation() {
		if (isSetInteriorTunnelInstallation())
			interiorTunnelInstallation.clear();

		interiorTunnelInstallation = null;
	}

	public boolean unsetInteriorTunnelInstallation(IntTunnelInstallationProperty interiorTunnelInstallation) {
		return isSetInteriorTunnelInstallation() ? this.interiorTunnelInstallation.remove(interiorTunnelInstallation) : false;
	}

	public void unsetInteriorHollowSpace() {
		if (isSetInteriorHollowSpace())
			interiorHollowSpace.clear();

		interiorHollowSpace = null;
	}

	public boolean unsetInteriorHollowSpace(InteriorHollowSpaceProperty interiorHollowSpace) {
		return isSetInteriorHollowSpace() ? this.interiorHollowSpace.remove(interiorHollowSpace) : false;
	}

	public void unsetLod1MultiSurface() {
		if (isSetLod1MultiSurface())
			lod1MultiSurface.unsetParent();
		
		lod1MultiSurface = null;
	}

	public void unsetLod1Solid() {
		if (isSetLod1Solid())
			lod1Solid.unsetParent();
		
		lod1Solid = null;
	}

	public void unsetLod1TerrainIntersection() {
		if (isSetLod1TerrainIntersection())
			lod1TerrainIntersection.unsetParent();
		
		lod1TerrainIntersection = null;
	}

	public void unsetLod2MultiCurve() {
		if (isSetLod2MultiCurve())
			lod2MultiCurve.unsetParent();
		
		lod2MultiCurve = null;
	}

	public void unsetLod2MultiSurface() {
		if (isSetLod2MultiSurface())
			lod2MultiSurface.unsetParent();
		
		lod2MultiSurface = null;
	}

	public void unsetLod2Solid() {
		if (isSetLod2Solid())
			lod2Solid.unsetParent();
		
		lod2Solid = null;
	}

	public void unsetLod2TerrainIntersection() {
		if (isSetLod2TerrainIntersection())
			lod2TerrainIntersection.unsetParent();
		
		lod2TerrainIntersection = null;
	}

	public void unsetLod3MultiCurve() {
		if (isSetLod3MultiCurve())
			lod3MultiCurve.unsetParent();
		
		lod3MultiCurve = null;
	}

	public void unsetLod3MultiSurface() {
		if (isSetLod3MultiSurface())
			lod3MultiSurface.unsetParent();
		
		lod3MultiSurface = null;
	}

	public void unsetLod3Solid() {
		if (isSetLod3Solid())
			lod3Solid.unsetParent();
		
		lod3Solid = null;
	}

	public void unsetLod3TerrainIntersection() {
		if (isSetLod3TerrainIntersection())
			lod3TerrainIntersection.unsetParent();
		
		lod3TerrainIntersection = null;
	}

	public void unsetLod4MultiCurve() {
		if (isSetLod4MultiCurve())
			lod4MultiCurve.unsetParent();
		
		lod4MultiCurve = null;
	}

	public void unsetLod4MultiSurface() {
		if (isSetLod4MultiSurface())
			lod4MultiSurface.unsetParent();
		
		lod4MultiSurface = null;
	}

	public void unsetLod4Solid() {
		if (isSetLod4Solid())
			lod4Solid.unsetParent();
		
		lod4Solid = null;
	}

	public void unsetLod4TerrainIntersection() {
		if (isSetLod4TerrainIntersection())
			lod4TerrainIntersection.unsetParent();
		
		lod4TerrainIntersection = null;
	}

	public void unsetOuterTunnelInstallation() {
		if (isSetOuterTunnelInstallation())
			outerTunnelInstallation.clear();

		outerTunnelInstallation = null;
	}

	public boolean unsetOuterTunnelInstallation(TunnelInstallationProperty outerTunnelInstallation) {
		return isSetOuterTunnelInstallation() ? this.outerTunnelInstallation.remove(outerTunnelInstallation) : false;
	}

	public void unsetYearOfConstruction() {
		yearOfConstruction = null;
	}

	public void unsetYearOfDemolition() {
		yearOfDemolition = null;
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
		
		SolidProperty solidProperty = null;
		for (int lod = 1; lod < 5; lod++) {
			switch (lod) {
			case 1:
				solidProperty = lod1Solid;
				break;
			case 2:
				solidProperty = lod2Solid;
				break;
			case 3:
				solidProperty = lod3Solid;
				break;
			case 4:
				solidProperty = lod4Solid;
				break;
			}
			
			if (solidProperty != null) {
				if (solidProperty.isSetSolid()) {
					boundedBy.updateEnvelope(solidProperty.getSolid().calcBoundingBox());
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
					boundedBy.updateEnvelope(multiSurfaceProperty.getMultiSurface().calcBoundingBox());
				} else {
					// xlink
				}
			}
		}
		
		MultiCurveProperty multiCurveProperty = null;
		for (int lod = 2; lod < 5; lod++) {
			switch (lod) {
			case 2:
				multiCurveProperty = lod2MultiCurve;
				break;
			case 3:
				multiCurveProperty = lod3MultiCurve;
				break;
			case 4:
				multiCurveProperty = lod4MultiCurve;
				break;
			}
			
			if (multiCurveProperty != null) {
				if (multiCurveProperty.isSetMultiCurve()) {
					boundedBy.updateEnvelope(multiCurveProperty.getMultiCurve().calcBoundingBox());
				} else {
					// xlink
				}
			}
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
		
		if (isSetOuterTunnelInstallation()) {
			for (TunnelInstallationProperty tunnelInstallationProperty : getOuterTunnelInstallation()) {
				if (tunnelInstallationProperty.isSetObject()) {
					boundedBy.updateEnvelope(tunnelInstallationProperty.getObject().calcBoundedBy(options).getEnvelope());
				} else {
					// xlink?
				}
			}
		}

		if (isSetConsistsOfTunnelPart()) {
			for (TunnelPartProperty tunnelPartProperty : getConsistsOfTunnelPart()) {
				if (tunnelPartProperty.isSetObject()) {
					boundedBy.updateEnvelope(tunnelPartProperty.getObject().calcBoundedBy(options).getEnvelope());
				} else {
					// xlink?
				}
			}
		}
		
		if (isSetGenericApplicationPropertyOfAbstractTunnel()) {
			for (ADEComponent ade : getGenericApplicationPropertyOfAbstractTunnel()) {
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
		for (int lod = 1; lod < 5; lod++) {
			switch (lod) {
			case 1:
				property = lod1Solid;
				break;
			case 2:
				property = lod2Solid;
				break;
			case 3:
				property = lod3Solid;
				break;
			case 4:
				property = lod4Solid;
				break;
			}
			
			if (property != null)
				lodRepresentation.addRepresentation(lod, property);
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
				lodRepresentation.addRepresentation(lod, property);
		}
		
		property = null;
		for (int lod = 2; lod < 5; lod++) {
			switch (lod) {
			case 2:
				property = lod2MultiCurve;
				break;
			case 3:
				property = lod3MultiCurve;
				break;
			case 4:
				property = lod4MultiCurve;
				break;
			}
			
			if (property != null)
				lodRepresentation.addRepresentation(lod, property);
		}
		
		return lodRepresentation;
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
			throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		AbstractTunnel copy = (AbstractTunnel)target;		
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
		
		if (isSetYearOfConstruction())
			copy.setYearOfConstruction((LocalDate)copyBuilder.copy(yearOfConstruction));
		
		if (isSetYearOfDemolition())
			copy.setYearOfDemolition((LocalDate)copyBuilder.copy(yearOfDemolition));
				
		if (isSetLod1Solid()) {
			copy.setLod1Solid((SolidProperty)copyBuilder.copy(lod1Solid));
			if (copy.getLod1Solid() == lod1Solid)
				lod1Solid.setParent(this);
		}
		
		if (isSetLod2Solid()) {
			copy.setLod2Solid((SolidProperty)copyBuilder.copy(lod2Solid));
			if (copy.getLod2Solid() == lod2Solid)
				lod2Solid.setParent(this);
		}
		
		if (isSetLod3Solid()) {
			copy.setLod3Solid((SolidProperty)copyBuilder.copy(lod3Solid));
			if (copy.getLod3Solid() == lod3Solid)
				lod3Solid.setParent(this);
		}
		
		if (isSetLod4Solid()) {
			copy.setLod4Solid((SolidProperty)copyBuilder.copy(lod4Solid));
			if (copy.getLod4Solid() == lod4Solid)
				lod4Solid.setParent(this);
		}
		
		if (isSetLod1TerrainIntersection()) {
			copy.setLod1TerrainIntersection((MultiCurveProperty)copyBuilder.copy(lod1TerrainIntersection));
			if (copy.getLod1TerrainIntersection() == lod1TerrainIntersection)
				lod1TerrainIntersection.setParent(this);
		}
		
		if (isSetLod2TerrainIntersection()) {
			copy.setLod2TerrainIntersection((MultiCurveProperty)copyBuilder.copy(lod2TerrainIntersection));
			if (copy.getLod2TerrainIntersection() == lod2TerrainIntersection)
				lod2TerrainIntersection.setParent(this);
		}
		
		if (isSetLod3TerrainIntersection()) {
			copy.setLod3TerrainIntersection((MultiCurveProperty)copyBuilder.copy(lod3TerrainIntersection));
			if (copy.getLod3TerrainIntersection() == lod3TerrainIntersection)
				lod3TerrainIntersection.setParent(this);
		}
		
		if (isSetLod4TerrainIntersection()) {
			copy.setLod4TerrainIntersection((MultiCurveProperty)copyBuilder.copy(lod4TerrainIntersection));
			if (copy.getLod4TerrainIntersection() == lod4TerrainIntersection)
				lod4TerrainIntersection.setParent(this);
		}
		
		if (isSetLod2MultiCurve()) {
			copy.setLod2MultiCurve((MultiCurveProperty)copyBuilder.copy(lod2MultiCurve));
			if (copy.getLod2MultiCurve() == lod2MultiCurve)
				lod2MultiCurve.setParent(this);
		}
		
		if (isSetLod3MultiCurve()) {
			copy.setLod3MultiCurve((MultiCurveProperty)copyBuilder.copy(lod3MultiCurve));
			if (copy.getLod3MultiCurve() == lod3MultiCurve)
				lod3MultiCurve.setParent(this);
		}
		
		if (isSetLod4MultiCurve()) {
			copy.setLod4MultiCurve((MultiCurveProperty)copyBuilder.copy(lod4MultiCurve));
			if (copy.getLod4MultiCurve() == lod4MultiCurve)
				lod4MultiCurve.setParent(this);
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

		if (isSetBoundedBySurface()) {
			for (BoundarySurfaceProperty part : boundedBySurface) {
				BoundarySurfaceProperty copyPart = (BoundarySurfaceProperty)copyBuilder.copy(part);
				copy.addBoundedBySurface(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetOuterTunnelInstallation()) {
			for (TunnelInstallationProperty part : outerTunnelInstallation) {
				TunnelInstallationProperty copyPart = (TunnelInstallationProperty)copyBuilder.copy(part);
				copy.addOuterTunnelInstallation(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetInteriorTunnelInstallation()) {
			for (IntTunnelInstallationProperty part : interiorTunnelInstallation) {
				IntTunnelInstallationProperty copyPart = (IntTunnelInstallationProperty)copyBuilder.copy(part);
				copy.addInteriorTunnelInstallation(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetConsistsOfTunnelPart()) {
			for (TunnelPartProperty part : tunnelPart) {
				TunnelPartProperty copyPart = (TunnelPartProperty)copyBuilder.copy(part);
				copy.addConsistsOfTunnelPart(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetInteriorHollowSpace()) {
			for (InteriorHollowSpaceProperty part : interiorHollowSpace) {
				InteriorHollowSpaceProperty copyPart = (InteriorHollowSpaceProperty)copyBuilder.copy(part);
				copy.addInteriorHollowSpace(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetGenericApplicationPropertyOfAbstractTunnel()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfAbstractTunnel(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
				
		return copy;
	}

}
