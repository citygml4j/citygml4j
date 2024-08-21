/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2023 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml4j.builder.cityjson.unmarshal.citygml.tunnel;

import org.citygml4j.builder.cityjson.unmarshal.CityJSONUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.citygml.CityGMLUnmarshaller;
import org.citygml4j.cityjson.CityJSON;
import org.citygml4j.cityjson.feature.*;
import org.citygml4j.cityjson.geometry.AbstractGeometryObjectType;
import org.citygml4j.cityjson.geometry.AbstractGeometryType;
import org.citygml4j.cityjson.geometry.GeometryInstanceType;
import org.citygml4j.cityjson.geometry.SemanticsType;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.ImplicitGeometry;
import org.citygml4j.model.citygml.core.ImplicitRepresentationProperty;
import org.citygml4j.model.citygml.tunnel.*;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurface;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurfaceProperty;
import org.citygml4j.model.gml.geometry.primitives.AbstractSolid;
import org.citygml4j.model.gml.geometry.primitives.AbstractSurface;
import org.citygml4j.model.gml.geometry.primitives.SolidProperty;
import org.citygml4j.model.gml.geometry.primitives.SurfaceProperty;
import org.citygml4j.util.mapper.BiFunctionTypeMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class TunnelUnmarshaller {
	private final ReentrantLock lock = new ReentrantLock();
	private final CityJSONUnmarshaller json;
	private final CityGMLUnmarshaller citygml;
	private BiFunctionTypeMapper<CityJSON, AbstractCityObject> typeMapper;

	public TunnelUnmarshaller(CityGMLUnmarshaller citygml) {
		this.citygml = citygml;
		json = citygml.getCityJSONUnmarshaller();
	}

	private BiFunctionTypeMapper<CityJSON, AbstractCityObject> getTypeMapper() {
		if (typeMapper == null) {
			lock.lock();
			try {
				if (typeMapper == null) {
					typeMapper = BiFunctionTypeMapper.<CityJSON, AbstractCityObject>create()
							.with(TunnelType.class, this::unmarshalTunnel)
							.with(TunnelPartType.class, this::unmarshalTunnelPart)
							.with(TunnelInstallationType.class, this::unmarshalTunnelInstallation);
				}
			} finally {
				lock.unlock();
			}
		}

		return typeMapper;
	}

	public AbstractCityObject unmarshal(AbstractCityObjectType src, CityJSON cityJSON) {
		return getTypeMapper().apply(src, cityJSON);
	}

	public AbstractCityObject unmarshalSemanticSurface(SemanticsType semanticsType, List<AbstractSurface> surfaces, Number lod, AbstractCityObject parent, CityJSON cityJSON) {
		AbstractCityObject cityObject = null;
		switch (semanticsType.getType()) {
			case "RoofSurface":
				cityObject = unmarshalRoofSurface(semanticsType, surfaces, lod, cityJSON);
				break;
			case "GroundSurface":
				cityObject = unmarshalGroundSurface(semanticsType, surfaces, lod, cityJSON);
				break;
			case "WallSurface":
				cityObject = unmarshalWallSurface(semanticsType, surfaces, lod, cityJSON);
				break;
			case "ClosureSurface":
				cityObject = unmarshalClosureSurface(semanticsType, surfaces, lod, cityJSON);
				break;
			case "OuterCeilingSurface":
				cityObject = unmarshalOuterCeilingSurface(semanticsType, surfaces, lod, cityJSON);
				break;
			case "OuterFloorSurface":
				cityObject = unmarshalOuterFloorSurface(semanticsType, surfaces, lod, cityJSON);
				break;
			case "Window":
				cityObject = unmarshalWindow(semanticsType, surfaces, lod, cityJSON);
				break;
			case "Door":
				cityObject = unmarshalDoor(semanticsType, surfaces, lod, cityJSON);
				break;
			default:
				return null;
		}

		if (parent instanceof ADEModelObject) {
			boolean success = json.getADEUnmarshaller().assignSemanticSurface(cityObject, lod, parent);
			if (success)
				return cityObject;
		}

		if (cityObject instanceof AbstractBoundarySurface) {
			AbstractBoundarySurface boundarySurface = (AbstractBoundarySurface) cityObject;
			if (parent instanceof AbstractTunnel)
				((AbstractTunnel) parent).addBoundedBySurface(new BoundarySurfaceProperty(boundarySurface));
			else if (parent instanceof TunnelInstallation)
				((TunnelInstallation) parent).addBoundedBySurface(new BoundarySurfaceProperty(boundarySurface));
		}

		else if (cityObject != null) {
			AbstractOpening opening = (AbstractOpening) cityObject;

			if (parent instanceof AbstractBoundarySurface)
				((AbstractBoundarySurface) parent).addOpening(new OpeningProperty(opening));
			else {
				// if the parent is not a boundary surface, then we try
				// and add the opening to the last boundary surface of the parent
				List<BoundarySurfaceProperty> boundedBy = null;
				if (parent instanceof AbstractTunnel)
					boundedBy = ((AbstractTunnel) parent).getBoundedBySurface();
				else if (parent instanceof TunnelInstallation)
					boundedBy = ((TunnelInstallation) parent).getBoundedBySurface();

				if (boundedBy != null && !boundedBy.isEmpty()) {
					AbstractBoundarySurface boundarySurface = boundedBy.get(boundedBy.size() - 1).getBoundarySurface();
					boundarySurface.addOpening(new OpeningProperty(opening));
				}
			}
		}

		return cityObject;
	}

	public void unmarshalAbstractTunnel(AbstractTunnelType src, AbstractTunnel dest, CityJSON cityJSON) {
		citygml.getCoreUnmarshaller().unmarshalAbstractCityObject(src, dest, cityJSON);

		if (src.isSetAttributes()) {
			TunnelAttributes attributes = src.getAttributes();

			if (attributes.isSetClazz())
				dest.setClazz(new Code(attributes.getClazz()));

			if (attributes.isSetFunction())
				dest.addFunction(new Code(attributes.getFunction()));

			if (attributes.isSetUsage())
				dest.addUsage(new Code(attributes.getUsage()));

			if (attributes.isSetYearOfConstruction())
				dest.setYearOfConstruction(LocalDate.of(attributes.getYearOfConstruction(), 1, 1));

			if (attributes.isSetYearOfDemolition())
				dest.setYearOfConstruction(LocalDate.of(attributes.getYearOfDemolition(), 1, 1));
		}

		for (AbstractGeometryType geometryType : src.getGeometry()) {
			AbstractGeometry geometry = null;
			int lod = 0;

			if (geometryType instanceof AbstractGeometryObjectType) {
				AbstractGeometryObjectType geometryObject = (AbstractGeometryObjectType) geometryType;
				geometry = json.getGMLUnmarshaller().unmarshal(geometryObject, dest, cityJSON);
				lod = geometryObject.getLod().intValue();
			} else if (geometryType instanceof GeometryInstanceType) {
				GeometryInstanceType geometryInstance = (GeometryInstanceType) geometryType;
				geometry = citygml.getCoreUnmarshaller().unmarshalAndTransformGeometryInstance(geometryInstance, dest, cityJSON);
				lod = (int) geometry.getLocalProperty(CityJSONUnmarshaller.GEOMETRY_INSTANCE_LOD);
			}

			if (geometry != null) {
				if (geometry instanceof MultiSurface) {
					MultiSurface multiSurface = (MultiSurface) geometry;
					switch (lod) {
						case 1:
							dest.setLod1MultiSurface(new MultiSurfaceProperty(multiSurface));
							break;
						case 2:
							dest.setLod2MultiSurface(new MultiSurfaceProperty(multiSurface));
							break;
						case 3:
							dest.setLod3MultiSurface(new MultiSurfaceProperty(multiSurface));
							break;
					}
				} else if (geometry instanceof AbstractSolid) {
					AbstractSolid solid = (AbstractSolid) geometry;
					switch (lod) {
						case 1:
							dest.setLod1Solid(new SolidProperty(solid));
							break;
						case 2:
							dest.setLod2Solid(new SolidProperty(solid));
							break;
						case 3:
							dest.setLod3Solid(new SolidProperty(solid));
							break;
					}
				}
			}
		}

		if (src.isSetChildren()) {
			for (String gmlId : src.getChildren()) {
				AbstractCityObjectType cityObject = cityJSON.getCityObject(gmlId);
				if (cityObject == null || !json.getCityJSONRegistry().isCoreCityObject(cityObject.getType()))
					continue;

				if (cityObject instanceof TunnelInstallationType) {
					TunnelInstallation installation = unmarshalTunnelInstallation((TunnelInstallationType) cityObject, cityJSON);
					dest.addOuterTunnelInstallation(new TunnelInstallationProperty(installation));
				} else if (cityObject instanceof TunnelPartType && src instanceof TunnelType) {
					TunnelPart part = unmarshalTunnelPart((TunnelPartType) cityObject, cityJSON);
					dest.addConsistsOfTunnelPart(new TunnelPartProperty(part));
				}
			}
		}
	}

	public void unmarshalTunnel(TunnelType src, Tunnel dest, CityJSON cityJSON) {
		unmarshalAbstractTunnel(src, dest, cityJSON);
	}

	public Tunnel unmarshalTunnel(TunnelType src, CityJSON cityJSON) {
		Tunnel dest = new Tunnel();
		unmarshalTunnel(src, dest, cityJSON);

		return dest;
	}

	public void unmarshalTunnelPart(TunnelPartType src, TunnelPart dest, CityJSON cityJSON) {
		unmarshalAbstractTunnel(src, dest, cityJSON);
	}
	
	public TunnelPart unmarshalTunnelPart(TunnelPartType src, CityJSON cityJSON) {
		TunnelPart dest = new TunnelPart();
		unmarshalTunnelPart(src, dest, cityJSON);

		return dest;
	}

	public void unmarshalTunnelInstallation(TunnelInstallationType src, TunnelInstallation dest, CityJSON cityJSON) {
		citygml.getCoreUnmarshaller().unmarshalAbstractCityObject(src, dest, cityJSON);

		if (src.isSetAttributes()) {
			Attributes attributes = src.getAttributes();
			if (attributes.isSetClazz())
				dest.setClazz(new Code(attributes.getClazz()));

			if (attributes.isSetFunction())
				dest.addFunction(new Code(attributes.getFunction()));

			if (attributes.isSetUsage())
				dest.addUsage(new Code(attributes.getUsage()));
		}

		for (AbstractGeometryType geometryType : src.getGeometry()) {
			if (geometryType instanceof AbstractGeometryObjectType) {
				AbstractGeometryObjectType geometryObject = (AbstractGeometryObjectType) geometryType;
				AbstractGeometry geometry = json.getGMLUnmarshaller().unmarshal(geometryObject, dest, cityJSON);

				if (geometry != null) {
					int lod = geometryObject.getLod().intValue();
					switch (lod) {
						case 2:
							dest.setLod2Geometry(new GeometryProperty<>(geometry));
							break;
						case 3:
							dest.setLod3Geometry(new GeometryProperty<>(geometry));
							break;
					}
				}
			} else if (geometryType instanceof GeometryInstanceType) {
				GeometryInstanceType geometryInstance = (GeometryInstanceType)geometryType;
				ImplicitGeometry geometry = citygml.getCoreUnmarshaller().unmarshalGeometryInstance(geometryInstance, cityJSON);

				if (geometry != null) {
					switch ((int) geometry.getLocalProperty(CityJSONUnmarshaller.GEOMETRY_INSTANCE_LOD)) {
						case 2:
							dest.setLod2ImplicitRepresentation(new ImplicitRepresentationProperty(geometry));
							break;
						case 3:
							dest.setLod3ImplicitRepresentation(new ImplicitRepresentationProperty(geometry));
							break;
					}
				}
			}
		}
	}

	public TunnelInstallation unmarshalTunnelInstallation(TunnelInstallationType src, CityJSON cityJSON) {
		TunnelInstallation dest = new TunnelInstallation();
		unmarshalTunnelInstallation(src, dest, cityJSON);

		return dest;
	}

	public void unmarshalAbstractBoundarySurface(SemanticsType src, AbstractBoundarySurface dest, List<AbstractSurface> surfaces, Number lod, CityJSON cityJSON) {
		citygml.getCoreUnmarshaller().marshalSemanticSurface(src, dest, cityJSON);

		MultiSurface multiSurface = new MultiSurface();
		for (AbstractSurface surface : surfaces)
			multiSurface.addSurfaceMember(new SurfaceProperty(surface));

		switch (lod.intValue()) {
		case 2:
			dest.setLod2MultiSurface(new MultiSurfaceProperty(multiSurface));
			break;
		case 3:
			dest.setLod3MultiSurface(new MultiSurfaceProperty(multiSurface));
			break;
		}
	}

	public RoofSurface unmarshalRoofSurface(SemanticsType src, List<AbstractSurface> surfaces, Number lod, CityJSON cityJSON) {
		RoofSurface dest = new RoofSurface();
		unmarshalAbstractBoundarySurface(src, dest, surfaces, lod, cityJSON);

		return dest;
	}

	public GroundSurface unmarshalGroundSurface(SemanticsType src, List<AbstractSurface> surfaces, Number lod, CityJSON cityJSON) {
		GroundSurface dest = new GroundSurface();
		unmarshalAbstractBoundarySurface(src, dest, surfaces, lod, cityJSON);

		return dest;
	}

	public WallSurface unmarshalWallSurface(SemanticsType src, List<AbstractSurface> surfaces, Number lod, CityJSON cityJSON) {
		WallSurface dest = new WallSurface();
		unmarshalAbstractBoundarySurface(src, dest, surfaces, lod, cityJSON);

		return dest;
	}

	public ClosureSurface unmarshalClosureSurface(SemanticsType src, List<AbstractSurface> surfaces, Number lod, CityJSON cityJSON) {
		ClosureSurface dest = new ClosureSurface();
		unmarshalAbstractBoundarySurface(src, dest, surfaces, lod, cityJSON);

		return dest;
	}

	public OuterCeilingSurface unmarshalOuterCeilingSurface(SemanticsType src, List<AbstractSurface> surfaces, Number lod, CityJSON cityJSON) {
		OuterCeilingSurface dest = new OuterCeilingSurface();
		unmarshalAbstractBoundarySurface(src, dest, surfaces, lod, cityJSON);

		return dest;
	}

	public OuterFloorSurface unmarshalOuterFloorSurface(SemanticsType src, List<AbstractSurface> surfaces, Number lod, CityJSON cityJSON) {
		OuterFloorSurface dest = new OuterFloorSurface();
		unmarshalAbstractBoundarySurface(src, dest, surfaces, lod, cityJSON);

		return dest;
	}

	public void unmarshalAbstractOpening(SemanticsType src, AbstractOpening dest, List<AbstractSurface> surfaces, Number lod, CityJSON cityJSON) {
		citygml.getCoreUnmarshaller().marshalSemanticSurface(src, dest, cityJSON);

		if (lod.intValue() == 3) {
			MultiSurface multiSurface = new MultiSurface();
			for (AbstractSurface surface : surfaces)
				multiSurface.addSurfaceMember(new SurfaceProperty(surface));

			dest.setLod3MultiSurface(new MultiSurfaceProperty(multiSurface));
		}
	}

	public Door unmarshalDoor(SemanticsType src, List<AbstractSurface> surfaces, Number lod, CityJSON cityJSON) {
		Door dest = new Door();
		unmarshalAbstractOpening(src, dest, surfaces, lod, cityJSON);

		return dest;
	}

	public Window unmarshalWindow(SemanticsType src, List<AbstractSurface> surfaces, Number lod, CityJSON cityJSON) {
		Window dest = new Window();
		unmarshalAbstractOpening(src, dest, surfaces, lod, cityJSON);

		return dest;
	}

}
