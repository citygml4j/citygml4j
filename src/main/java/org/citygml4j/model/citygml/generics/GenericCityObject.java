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
package org.citygml4j.model.citygml.generics;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
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
import org.citygml4j.model.gml.geometry.aggregates.MultiCurveProperty;
import org.citygml4j.model.module.citygml.GenericsModule;
import org.citygml4j.util.bbox.BoundingBoxOptions;

import java.util.List;

public class GenericCityObject extends AbstractCityObject implements GenericsModuleComponent, StandardObjectClassifier {
	private Code clazz;
	private List<Code> function;
	private List<Code> usage;
	private GeometryProperty<? extends AbstractGeometry> lod0Geometry;
	private GeometryProperty<? extends AbstractGeometry> lod1Geometry;
	private GeometryProperty<? extends AbstractGeometry> lod2Geometry;
	private GeometryProperty<? extends AbstractGeometry> lod3Geometry;
	private GeometryProperty<? extends AbstractGeometry> lod4Geometry;
	private MultiCurveProperty lod0TerrainIntersection;
	private MultiCurveProperty lod1TerrainIntersection;
	private MultiCurveProperty lod2TerrainIntersection;
	private MultiCurveProperty lod3TerrainIntersection;
	private MultiCurveProperty lod4TerrainIntersection;
	private ImplicitRepresentationProperty lod0ImplicitRepresentation;
	private ImplicitRepresentationProperty lod1ImplicitRepresentation;
	private ImplicitRepresentationProperty lod2ImplicitRepresentation;
	private ImplicitRepresentationProperty lod3ImplicitRepresentation;
	private ImplicitRepresentationProperty lod4ImplicitRepresentation;
	private GenericsModule module;

	public GenericCityObject() {

	}

	public GenericCityObject(GenericsModule module) {
		this.module = module;
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

	public GeometryProperty<? extends AbstractGeometry> getLod0Geometry() {
		return lod0Geometry;
	}

	public ImplicitRepresentationProperty getLod0ImplicitRepresentation() {
		return lod0ImplicitRepresentation;
	}

	public MultiCurveProperty getLod0TerrainIntersection() {
		return lod0TerrainIntersection;
	}

	public GeometryProperty<? extends AbstractGeometry> getLod1Geometry() {
		return lod1Geometry;
	}

	public ImplicitRepresentationProperty getLod1ImplicitRepresentation() {
		return lod1ImplicitRepresentation;
	}

	public MultiCurveProperty getLod1TerrainIntersection() {
		return lod1TerrainIntersection;
	}

	public GeometryProperty<? extends AbstractGeometry> getLod2Geometry() {
		return lod2Geometry;
	}

	public ImplicitRepresentationProperty getLod2ImplicitRepresentation() {
		return lod2ImplicitRepresentation;
	}

	public MultiCurveProperty getLod2TerrainIntersection() {
		return lod2TerrainIntersection;
	}

	public GeometryProperty<? extends AbstractGeometry> getLod3Geometry() {
		return lod3Geometry;
	}

	public ImplicitRepresentationProperty getLod3ImplicitRepresentation() {
		return lod3ImplicitRepresentation;
	}

	public MultiCurveProperty getLod3TerrainIntersection() {
		return lod3TerrainIntersection;
	}

	public GeometryProperty<? extends AbstractGeometry> getLod4Geometry() {
		return lod4Geometry;
	}

	public ImplicitRepresentationProperty getLod4ImplicitRepresentation() {
		return lod4ImplicitRepresentation;
	}

	public MultiCurveProperty getLod4TerrainIntersection() {
		return lod4TerrainIntersection;
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

	public boolean isSetLod0Geometry() {
		return lod0Geometry != null;
	}

	public boolean isSetLod0ImplicitRepresentation() {
		return lod0ImplicitRepresentation != null;
	}

	public boolean isSetLod0TerrainIntersection() {
		return lod0TerrainIntersection != null;
	}

	public boolean isSetLod1Geometry() {
		return lod1Geometry != null;
	}

	public boolean isSetLod1ImplicitRepresentation() {
		return lod1ImplicitRepresentation != null;
	}

	public boolean isSetLod1TerrainIntersection() {
		return lod1TerrainIntersection != null;
	}

	public boolean isSetLod2Geometry() {
		return lod2Geometry != null;
	}

	public boolean isSetLod2ImplicitRepresentation() {
		return lod2ImplicitRepresentation != null;
	}

	public boolean isSetLod2TerrainIntersection() {
		return lod2TerrainIntersection != null;
	}

	public boolean isSetLod3Geometry() {
		return lod3Geometry != null;
	}

	public boolean isSetLod3ImplicitRepresentation() {
		return lod3ImplicitRepresentation != null;
	}

	public boolean isSetLod3TerrainIntersection() {
		return lod3TerrainIntersection != null;
	}

	public boolean isSetLod4Geometry() {
		return lod4Geometry != null;
	}

	public boolean isSetLod4ImplicitRepresentation() {
		return lod4ImplicitRepresentation != null;
	}

	public boolean isSetLod4TerrainIntersection() {
		return lod4TerrainIntersection != null;
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

	public void setLod0Geometry(GeometryProperty<? extends AbstractGeometry> lod0Geometry) {
		if (lod0Geometry != null)
			lod0Geometry.setParent(this);

		this.lod0Geometry = lod0Geometry;

	}

	public void setLod0ImplicitRepresentation(ImplicitRepresentationProperty lod0ImplicitRepresentation) {
		if (lod0ImplicitRepresentation != null)
			lod0ImplicitRepresentation.setParent(this);

		this.lod0ImplicitRepresentation = lod0ImplicitRepresentation;
	}

	public void setLod0TerrainIntersection(MultiCurveProperty lod0TerrainIntersection) {
		if (lod0TerrainIntersection != null)
			lod0TerrainIntersection.setParent(this);

		this.lod0TerrainIntersection = lod0TerrainIntersection;
	}

	public void setLod1Geometry(GeometryProperty<? extends AbstractGeometry> lod1Geometry) {
		if (lod1Geometry != null)
			lod1Geometry.setParent(this);

		this.lod1Geometry = lod1Geometry;
	}

	public void setLod1ImplicitRepresentation(ImplicitRepresentationProperty lod1ImplicitRepresentation) {
		if (lod1ImplicitRepresentation != null)
			lod1ImplicitRepresentation.setParent(this);

		this.lod1ImplicitRepresentation = lod1ImplicitRepresentation;
	}

	public void setLod1TerrainIntersection(MultiCurveProperty lod1TerrainIntersection) {
		if (lod1TerrainIntersection != null)
			lod1TerrainIntersection.setParent(this);

		this.lod1TerrainIntersection = lod1TerrainIntersection;
	}

	public void setLod2Geometry(GeometryProperty<? extends AbstractGeometry> lod2Geometry) {
		if (lod2Geometry != null)
			lod2Geometry.setParent(this);

		this.lod2Geometry = lod2Geometry;
	}

	public void setLod2ImplicitRepresentation(ImplicitRepresentationProperty lod2ImplicitRepresentation) {
		if (lod2ImplicitRepresentation != null)
			lod2ImplicitRepresentation.setParent(this);

		this.lod2ImplicitRepresentation = lod2ImplicitRepresentation;
	}

	public void setLod2TerrainIntersection(MultiCurveProperty lod2TerrainIntersection) {
		if (lod2TerrainIntersection != null)
			lod2TerrainIntersection.setParent(this);

		this.lod2TerrainIntersection = lod2TerrainIntersection;
	}

	public void setLod3Geometry(GeometryProperty<? extends AbstractGeometry> lod3Geometry) {
		if (lod3Geometry != null)
			lod3Geometry.setParent(this);

		this.lod3Geometry = lod3Geometry;
	}

	public void setLod3ImplicitRepresentation(ImplicitRepresentationProperty lod3ImplicitRepresentation) {
		if (lod3ImplicitRepresentation != null)
			lod3ImplicitRepresentation.setParent(this);

		this.lod3ImplicitRepresentation = lod3ImplicitRepresentation;
	}

	public void setLod3TerrainIntersection(MultiCurveProperty lod3TerrainIntersection) {
		if (lod3TerrainIntersection != null)
			lod3TerrainIntersection.setParent(this);

		this.lod3TerrainIntersection = lod3TerrainIntersection;
	}

	public void setLod4Geometry(GeometryProperty<? extends AbstractGeometry> lod4Geometry) {
		if (lod4Geometry != null)
			lod4Geometry.setParent(this);

		this.lod4Geometry = lod4Geometry;
	}

	public void setLod4ImplicitRepresentation(ImplicitRepresentationProperty lod4ImplicitRepresentation) {
		if (lod4ImplicitRepresentation != null)
			lod4ImplicitRepresentation.setParent(this);

		this.lod4ImplicitRepresentation = lod4ImplicitRepresentation;
	}

	public void setLod4TerrainIntersection(MultiCurveProperty lod4TerrainIntersection) {
		if (lod4TerrainIntersection != null)
			lod4TerrainIntersection.setParent(this);

		this.lod4TerrainIntersection = lod4TerrainIntersection;
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

	public void unsetLod0Geometry() {
		if (isSetLod0Geometry())
			lod0Geometry.unsetParent();

		lod0Geometry = null;
	}

	public void unsetLod0ImplicitRepresentation() {
		if (isSetLod0ImplicitRepresentation())
			lod0ImplicitRepresentation.unsetParent();

		lod0ImplicitRepresentation = null;
	}

	public void unsetLod0TerrainIntersection() {
		if (isSetLod0TerrainIntersection())
			lod0TerrainIntersection.unsetParent();

		lod0TerrainIntersection = null;
	}

	public void unsetLod1Geometry() {
		if (isSetLod1Geometry())
			lod1Geometry.unsetParent();

		lod1Geometry = null;
	}

	public void unsetLod1ImplicitRepresentation() {
		if (isSetLod1ImplicitRepresentation())
			lod1ImplicitRepresentation.unsetParent();

		lod1ImplicitRepresentation = null;
	}

	public void unsetLod1TerrainIntersection() {
		if (isSetLod1TerrainIntersection())
			lod1TerrainIntersection.unsetParent();

		lod1TerrainIntersection = null;
	}

	public void unsetLod2Geometry() {
		if (isSetLod2Geometry())
			lod2Geometry.unsetParent();

		lod2Geometry = null;
	}

	public void unsetLod2ImplicitRepresentation() {
		if (isSetLod2ImplicitRepresentation())
			lod2ImplicitRepresentation.unsetParent();

		lod2ImplicitRepresentation = null;
	}

	public void unsetLod2TerrainIntersection() {
		if (isSetLod2TerrainIntersection())
			lod2TerrainIntersection.unsetParent();

		lod2TerrainIntersection = null;
	}

	public void unsetLod3Geometry() {
		if (isSetLod3Geometry())
			lod3Geometry.unsetParent();

		lod3Geometry = null;
	}

	public void unsetLod3ImplicitRepresentation() {
		if (isSetLod3ImplicitRepresentation())
			lod3ImplicitRepresentation.unsetParent();

		lod3ImplicitRepresentation = null;
	}

	public void unsetLod3TerrainIntersection() {
		if (isSetLod3TerrainIntersection())
			lod3TerrainIntersection.unsetParent();

		lod3TerrainIntersection = null;
	}

	public void unsetLod4Geometry() {
		if (isSetLod4Geometry())
			lod4Geometry.unsetParent();

		lod4Geometry = null;
	}

	public void unsetLod4ImplicitRepresentation() {
		if (isSetLod4ImplicitRepresentation())
			lod4ImplicitRepresentation.unsetParent();

		lod4ImplicitRepresentation = null;
	}

	public void unsetLod4TerrainIntersection() {
		if (isSetLod4TerrainIntersection())
			lod4TerrainIntersection.unsetParent();

		lod4TerrainIntersection = null;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.GENERIC_CITY_OBJECT;
	}

	public final GenericsModule getCityGMLModule() {
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
		for (int lod = 0; lod < 5; lod++) {
			switch (lod) {
			case 0:
				geometryProperty = lod0Geometry;
				break;
			case 1:
				geometryProperty = lod1Geometry;
				break;
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
		for (int lod = 0; lod < 5; lod++) {
			switch (lod) {
			case 0:
				implicitRepresentation = lod0ImplicitRepresentation;
				break;
			case 1:
				implicitRepresentation = lod1ImplicitRepresentation;
				break;
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
			case 0:
				property = lod0Geometry;
				break;
			case 1:
				property = lod1Geometry;
				break;
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
		for (int lod = 0; lod < 5; lod++) {
			switch (lod) {
			case 0:
				implicitRepresentation = lod0ImplicitRepresentation;
				break;
			case 1:
				implicitRepresentation = lod1ImplicitRepresentation;
				break;
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
		return copyTo(new GenericCityObject(), copyBuilder);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		GenericCityObject copy = (target == null) ? new GenericCityObject() : (GenericCityObject)target;
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

		if (isSetLod0Geometry()) {
			copy.setLod0Geometry((GeometryProperty<? extends AbstractGeometry>)copyBuilder.copy(lod0Geometry));
			if (copy.getLod0Geometry() == lod0Geometry)
				lod0Geometry.setParent(this);
		}

		if (isSetLod1Geometry()) {
			copy.setLod1Geometry((GeometryProperty<? extends AbstractGeometry>)copyBuilder.copy(lod1Geometry));
			if (copy.getLod1Geometry() == lod1Geometry)
				lod1Geometry.setParent(this);
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

		if (isSetLod0ImplicitRepresentation()) {
			copy.setLod0ImplicitRepresentation((ImplicitRepresentationProperty)copyBuilder.copy(lod0ImplicitRepresentation));
			if (copy.getLod0ImplicitRepresentation() == lod0ImplicitRepresentation)
				lod0ImplicitRepresentation.setParent(this);
		}

		if (isSetLod1ImplicitRepresentation()) {
			copy.setLod1ImplicitRepresentation((ImplicitRepresentationProperty)copyBuilder.copy(lod1ImplicitRepresentation));
			if (copy.getLod1ImplicitRepresentation() == lod1ImplicitRepresentation)
				lod1ImplicitRepresentation.setParent(this);
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

		if (isSetLod0TerrainIntersection()) {
			copy.setLod0TerrainIntersection((MultiCurveProperty)copyBuilder.copy(lod0TerrainIntersection));
			if (copy.getLod0TerrainIntersection() == lod0TerrainIntersection)
				lod0TerrainIntersection.setParent(this);
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
