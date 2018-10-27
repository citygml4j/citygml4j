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
package org.citygml4j.builder.cityjson.unmarshal.gml;

import org.citygml4j.binding.cityjson.appearance.AbstractMaterialObject;
import org.citygml4j.binding.cityjson.appearance.AbstractTextureObject;
import org.citygml4j.binding.cityjson.geometry.AbstractGeometryObjectType;
import org.citygml4j.binding.cityjson.geometry.AbstractSemanticsObject;
import org.citygml4j.binding.cityjson.geometry.AbstractSolidCollectionType;
import org.citygml4j.binding.cityjson.geometry.AbstractSurfaceCollectionType;
import org.citygml4j.binding.cityjson.geometry.CompositeSolidType;
import org.citygml4j.binding.cityjson.geometry.CompositeSurfaceType;
import org.citygml4j.binding.cityjson.geometry.MultiLineStringType;
import org.citygml4j.binding.cityjson.geometry.MultiPointType;
import org.citygml4j.binding.cityjson.geometry.MultiSolidType;
import org.citygml4j.binding.cityjson.geometry.MultiSurfaceType;
import org.citygml4j.binding.cityjson.geometry.SolidType;
import org.citygml4j.binding.cityjson.geometry.TransformType;
import org.citygml4j.builder.cityjson.unmarshal.CityJSONUnmarshaller;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.aggregates.MultiCurve;
import org.citygml4j.model.gml.geometry.aggregates.MultiPoint;
import org.citygml4j.model.gml.geometry.aggregates.MultiSolid;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurface;
import org.citygml4j.model.gml.geometry.complexes.CompositeSolid;
import org.citygml4j.model.gml.geometry.complexes.CompositeSurface;
import org.citygml4j.model.gml.geometry.primitives.AbstractSurface;
import org.citygml4j.model.gml.geometry.primitives.CurveProperty;
import org.citygml4j.model.gml.geometry.primitives.DirectPosition;
import org.citygml4j.model.gml.geometry.primitives.DirectPositionList;
import org.citygml4j.model.gml.geometry.primitives.Exterior;
import org.citygml4j.model.gml.geometry.primitives.Interior;
import org.citygml4j.model.gml.geometry.primitives.LineString;
import org.citygml4j.model.gml.geometry.primitives.LinearRing;
import org.citygml4j.model.gml.geometry.primitives.Point;
import org.citygml4j.model.gml.geometry.primitives.PointProperty;
import org.citygml4j.model.gml.geometry.primitives.Polygon;
import org.citygml4j.model.gml.geometry.primitives.Solid;
import org.citygml4j.model.gml.geometry.primitives.SolidProperty;
import org.citygml4j.model.gml.geometry.primitives.SurfaceProperty;
import org.citygml4j.model.gml.geometry.primitives.Triangle;
import org.citygml4j.model.gml.geometry.primitives.TrianglePatchArrayProperty;
import org.citygml4j.model.gml.geometry.primitives.TriangulatedSurface;
import org.citygml4j.util.child.ChildInfo;
import org.citygml4j.util.gmlid.DefaultGMLIdManager;
import org.citygml4j.util.mapper.BiFunctionTypeMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GMLUnmarshaller {
	private final CityJSONUnmarshaller json;
	private final ChildInfo info;
	private final BiFunctionTypeMapper<AbstractCityObject, AbstractGeometry> typeMapper;

	private int numVertices;
	private List<List<Double>> vertices;

	public GMLUnmarshaller(CityJSONUnmarshaller json) {
		this.json = json;

		info = new ChildInfo();
		typeMapper = BiFunctionTypeMapper.<AbstractCityObject, AbstractGeometry>create()
				.with(MultiPointType.class, this::unmarshalMultiPoint)
				.with(MultiLineStringType.class, this::unmarshalMultiLineString)
				.with(MultiSurfaceType.class, this::unmarshalMultiSurface)
				.with(CompositeSurfaceType.class, this::unmarshalCompositeSurface)
				.with(SolidType.class, this::unmarshalSolid)
				.with(MultiSolidType.class, this::unmarshalMultiSolid)
				.with(CompositeSolidType.class, this::unmarshalCompositeSolid);
	}

	public AbstractGeometry unmarshal(AbstractGeometryObjectType geometry, AbstractCityObject cityObject) {
		return typeMapper.apply(geometry, cityObject);
	}

	public AbstractGeometry unmarshal(AbstractGeometryObjectType geometry) {
		return typeMapper.apply(geometry, null);
	}

	public void setVertices(List<List<Double>> vertices) {
		this.vertices = vertices;
		numVertices = vertices != null ? vertices.size() : 0;
	}

	public void applyTransformation(TransformType transform) {
		if (transform.isSetScale() && transform.isSetTranslate() && numVertices > 0) {
			for (List<Double> vertex : vertices) {
				for (int i = 0; i < vertex.size(); i++)
					vertex.set(i, vertex.get(i) * transform.getScale().get(i) + transform.getTranslate().get(i));
			}
		}
	}

	public void unmarshalMultiPoint(MultiPointType src, MultiPoint dest) {
		List<Double> points = getVertices(src.getPoints());
		for (int i = 0; i < points.size(); i += 3) {
			Point point = new Point();
			DirectPosition pos = new DirectPosition();
			pos.setValue(points.subList(i, i + 3));
			pos.setSrsDimension(3);
			point.setPos(pos);

			dest.addPointMember(new PointProperty(point));
		}
	}

	public MultiPoint unmarshalMultiPoint(MultiPointType src) {
		MultiPoint dest = new MultiPoint();
		unmarshalMultiPoint(src, dest);

		return dest;
	}

	public MultiPoint unmarshalMultiPoint(MultiPointType src, AbstractCityObject cityObject) {
		return unmarshalMultiPoint(src);
	}

	public void unmarshalMultiLineString(MultiLineStringType src, MultiCurve dest) {
		for (List<Integer> lineString : src.getLineStrings()) {
			List<Double> value = getVertices(lineString);
			if (value.isEmpty())
				continue;

			LineString curve = new LineString();
			DirectPositionList posList = new DirectPositionList();
			posList.setValue(value);
			posList.setSrsDimension(3);
			curve.setPosList(posList);

			dest.addCurveMember(new CurveProperty(curve));
		}
	}

	public MultiCurve unmarshalMultiLineString(MultiLineStringType src) {
		MultiCurve dest = new MultiCurve();
		unmarshalMultiLineString(src, dest);

		return dest;
	}

	public MultiCurve unmarshalMultiLineString(MultiLineStringType src, AbstractCityObject cityObject) {
		return unmarshalMultiLineString(src);
	}

	public List<SurfaceProperty> unmarshalSurfaceCollection(AbstractSurfaceCollectionType src, AbstractCityObject cityObject, boolean useXLinks) {
		List<SurfaceProperty> dest = new ArrayList<>();

		List<AbstractSurface> surfaces = new ArrayList<>();
		for (List<List<Integer>> surface : src.getSurfaces()) {
			Polygon polygon = unmarshalPolygon(surface);
			if (polygon != null)
				surfaces.add(polygon);	
		}

		if (src.isSetSemantics())
			unmarshalSemantics(src.getSemantics(), surfaces, src.getLod(), cityObject);

		for (AbstractSurface surface : surfaces) {
			if (!surface.isSetId())
				dest.add(new SurfaceProperty(surface));
			else if (useXLinks)
				dest.add(new SurfaceProperty(new StringBuilder("#").append(surface.getId()).toString()));
		}

		if (src.isSetMaterial())
			unmarshalMaterial(src.getMaterial(), surfaces, cityObject);

		if (src.isSetTexture())
			unmarshalTexture(src.getTexture(), surfaces, cityObject);

		return dest;
	}

	public MultiSurface unmarshalMultiSurface(AbstractSurfaceCollectionType src, AbstractCityObject cityObject) {
		MultiSurface dest = new MultiSurface();
		for (SurfaceProperty property : unmarshalSurfaceCollection(src, cityObject, false))
			dest.addSurfaceMember(property);

		return dest.isSetSurfaceMember() ? dest : null;
	}

	public CompositeSurface unmarshalCompositeSurface(CompositeSurfaceType src, AbstractCityObject cityObject) {
		CompositeSurface dest = new CompositeSurface();
		for (SurfaceProperty property : unmarshalSurfaceCollection(src, cityObject, true))
			dest.addSurfaceMember(property);

		return dest;
	}

	public void unmarshalTriangulatedSurface(CompositeSurfaceType src, TriangulatedSurface dest, AbstractCityObject cityObject) {
		TrianglePatchArrayProperty trianglePatches = new TrianglePatchArrayProperty();
		for (List<List<Integer>> surface : src.getSurfaces()) {
			Triangle triangle = unmarshalTriangle(surface);
			if (triangle != null)
				trianglePatches.addTriangle(triangle);
		}

		if (trianglePatches.isSetTriangle()) {
			dest.setTrianglePatches(trianglePatches);

			if (src.isSetMaterial())
				unmarshalMaterial(src.getMaterial(), Collections.singletonList(dest), cityObject);

			if (src.isSetTexture())
				unmarshalTexture(src.getTexture(), dest, cityObject);
		}
	}

	public TriangulatedSurface unmarshalTriangulatedSurface(CompositeSurfaceType src, AbstractCityObject cityObject) {
		TriangulatedSurface dest = new TriangulatedSurface();
		unmarshalTriangulatedSurface(src, dest, cityObject);

		return dest;
	}

	public void unmarshalSolid(SolidType src, Solid dest, AbstractCityObject cityObject) {
		List<Integer> shells = new ArrayList<>();
		List<AbstractSurface> surfaces = new ArrayList<>();

		int index = 0;
		for (List<List<List<Integer>>> shell : src.getShells()) {
			shells.add(index);
			for (List<List<Integer>> surface : shell) {
				Polygon polygon = unmarshalPolygon(surface);
				if (polygon != null) {
					surfaces.add(polygon);
					index++;
				}
			}			
		}

		shells.add(index);

		if (src.isSetSemantics())
			unmarshalSemantics(src.getSemantics(), surfaces, src.getLod(), cityObject);

		for (int i = 0; i < shells.size() - 1; i++) {
			CompositeSurface shell = new CompositeSurface();
			if (i == 0)
				dest.setExterior(new SurfaceProperty(shell));
			else
				dest.addInterior(new SurfaceProperty(shell));

			for (int j = shells.get(i); j < shells.get(i + 1); j++) {
				AbstractSurface surface = surfaces.get(j);
				if (surface.isSetId())
					shell.addSurfaceMember(new SurfaceProperty(new StringBuilder("#").append(surface.getId()).toString()));
				else
					shell.addSurfaceMember(new SurfaceProperty(surface));
			}
		}

		if (src.isSetMaterial())
			unmarshalMaterial(src.getMaterial(), surfaces, cityObject);

		if (src.isSetTexture())
			unmarshalTexture(src.getTexture(), surfaces, cityObject);
	}

	public Solid unmarshalSolid(SolidType src, AbstractCityObject cityObject) {
		Solid dest = new Solid();
		unmarshalSolid(src, dest, cityObject);

		return dest;
	}

	public List<Solid> unmarshalSolidCollection(AbstractSolidCollectionType src, AbstractCityObject cityObject) {
		List<Solid> dest = new ArrayList<>();

		List<List<Integer>> solids = new ArrayList<>();
		List<AbstractSurface> surfaces = new ArrayList<>();

		int index = 0;
		for (List<List<List<List<Integer>>>> solid : src.getSolids()) {
			List<Integer> shells = new ArrayList<>();
			for (List<List<List<Integer>>> shell : solid) {
				shells.add(index);
				for (List<List<Integer>> surface : shell) {
					Polygon polygon = unmarshalPolygon(surface);
					if (polygon != null) {
						surfaces.add(polygon);
						index++;
					}
				}			
			}

			shells.add(index);
			solids.add(shells);
		}

		if (src.isSetSemantics())
			unmarshalSemantics(src.getSemantics(), surfaces, src.getLod(), cityObject);

		for (int i = 0; i < solids.size(); i++) {
			Solid solid = new Solid();
			List<Integer> shells = solids.get(i);

			for (int j = 0; j < shells.size() - 1; j++) {
				CompositeSurface shell = new CompositeSurface();
				if (j == 0)
					solid.setExterior(new SurfaceProperty(shell));
				else
					solid.addInterior(new SurfaceProperty(shell));

				for (int k = shells.get(j); k < shells.get(j + 1); k++) {
					AbstractSurface surface = surfaces.get(k);
					if (surface.isSetId())
						shell.addSurfaceMember(new SurfaceProperty(new StringBuilder("#").append(surface.getId()).toString()));
					else
						shell.addSurfaceMember(new SurfaceProperty(surface));
				}
			}

			dest.add(solid);
		}

		if (src.isSetMaterial())
			unmarshalMaterial(src.getMaterial(), surfaces, cityObject);

		if (src.isSetTexture())
			unmarshalTexture(src.getTexture(), surfaces, cityObject);

		return dest;
	}

	public CompositeSolid unmarshalCompositeSolid(CompositeSolidType src, AbstractCityObject cityObject) {
		CompositeSolid dest = new CompositeSolid();		
		for (Solid solid : unmarshalSolidCollection(src, cityObject))
			dest.addSolidMember(new SolidProperty(solid));

		return dest;
	}

	public MultiSolid unmarshalMultiSolid(MultiSolidType src, AbstractCityObject cityObject) {
		MultiSolid dest = new MultiSolid();		
		for (Solid solid : unmarshalSolidCollection(src, cityObject))
			dest.addSolidMember(new SolidProperty(solid));

		return dest;
	}

	private Polygon unmarshalPolygon(List<List<Integer>> indexes) {
		Polygon dest = new Polygon();

		if (indexes != null && !indexes.isEmpty()) {
			List<Double> vertices = getVertices(indexes.get(0));
			if (vertices.isEmpty())
				return null;

			// add first vertex to close ring
			vertices.addAll(vertices.subList(0, 3));

			// set exterior ring
			LinearRing exterior = new LinearRing();
			DirectPositionList posList = new DirectPositionList();
			posList.setValue(vertices);
			posList.setSrsDimension(3);
			exterior.setPosList(posList);
			dest.setExterior(new Exterior(exterior));

			if (indexes.size() > 1) {
				for (int i = 1; i < indexes.size(); i++) {
					vertices = getVertices(indexes.get(i));
					if (vertices.isEmpty())
						continue;

					// add first vertex to close ring
					vertices.addAll(vertices.subList(0, 3));

					// add interior ring
					LinearRing interior = new LinearRing();
					posList = new DirectPositionList();
					posList.setValue(vertices);
					posList.setSrsDimension(3);
					interior.setPosList(posList);
					dest.addInterior(new Interior(interior));
				}
			}
		}

		return dest.isSetExterior() ? dest : null;
	}

	private Triangle unmarshalTriangle(List<List<Integer>> indexes) {
		Triangle dest = new Triangle();

		if (indexes != null && !indexes.isEmpty()) {
			List<Double> vertices = getVertices(indexes.get(0));
			if (vertices.isEmpty() || vertices.size() != 9)
				return null;

			// add first vertex to close ring
			vertices.addAll(vertices.subList(0, 3));

			// set exterior ring
			LinearRing exterior = new LinearRing();
			DirectPositionList posList = new DirectPositionList();
			posList.setValue(vertices);
			posList.setSrsDimension(3);
			exterior.setPosList(posList);
			dest.setExterior(new Exterior(exterior));
		}

		return dest.isSetExterior() ? dest : null;
	}

	private void unmarshalSemantics(AbstractSemanticsObject semanticsObject, List<AbstractSurface> surfaces, Number lod, AbstractCityObject cityObject) {
		Map<Integer, List<AbstractSurface>> semantics = collectSurfaces(semanticsObject.flatValues(), surfaces);

		// create semantic city objects
		json.getCityGMLUnmarshaller().unmarshalSemantics(semanticsObject, semantics, lod, cityObject);

		// add gml:ids to surfaces that have a parent city object
		for (AbstractSurface surface : surfaces) {
			if (surface != null && info.getParentCityObject(surface) != null)
				surface.setId(DefaultGMLIdManager.getInstance().generateUUID());
		}
	}

	private void unmarshalMaterial(Collection<? extends AbstractMaterialObject> materialObjects, List<AbstractSurface> surfaces, AbstractCityObject cityObject) {
		for (AbstractMaterialObject materialObject : materialObjects) {
			Map<Integer, List<AbstractSurface>> materials = null;

			if (materialObject.isSetValues()) 
				materials = collectSurfaces(materialObject.flatValues(), surfaces);
			else if (materialObject.isSetValue()) {
				materials = new HashMap<>();
				materials.put(materialObject.getValue(), surfaces);
			} else
				continue;

			// create X3D material
			json.getCityGMLUnmarshaller().getAppearanceUnmarshaller().unmarshalMaterial(materialObject, materials, cityObject);
		}
	}

	public void unmarshalTexture(Collection<? extends AbstractTextureObject> textureObjects, List<AbstractSurface> surfaces, AbstractCityObject cityObject) {
		for (AbstractTextureObject textureObject : textureObjects) {
			Map<Integer, List<AbstractSurface>> textures = new HashMap<>();
			List<List<List<Integer>>> values = textureObject.flatValues();

			for (int i = 0; i < values.size(); i++) {
				List<List<Integer>> value = values.get(i);
				if (value == null)
					continue;

				List<Integer> exterior = value.get(0);
				if (exterior == null)
					continue;

				// we assume that exterior and interior rings
				// receive the same texture, so we only check
				// the texture index of the exterior ring
				Integer textureIndex = exterior.get(0);
				if (textureIndex == null)
					continue;

				if (i < surfaces.size()) {
					AbstractSurface surface = surfaces.get(i);
					if (surface == null)
						continue;

					List<AbstractSurface> tmp = textures.get(textureIndex);
					if (tmp == null) {
						tmp = new ArrayList<>();
						textures.put(textureIndex, tmp);
					}

					surface.setLocalProperty(CityJSONUnmarshaller.TEXTURE_COORDINATES, value);
					tmp.add(surface);
				} else
					break;
			}

			// create parameterized texture
			json.getCityGMLUnmarshaller().getAppearanceUnmarshaller().unmarshalParameterizedTexture(textureObject, textures, cityObject);
		}
	}
	
	public void unmarshalTexture(Collection<? extends AbstractTextureObject> textureObjects, TriangulatedSurface surface, AbstractCityObject cityObject) {
		for (AbstractTextureObject textureObject : textureObjects) {
			List<List<List<Integer>>> values = textureObject.flatValues();
			
			// we can only assign a single texture to a triangulated surface
			Integer texture = null;
			List<List<Integer>> textureCoordinates = new ArrayList<>();

			for (int i = 0; i < values.size(); i++) {
				List<List<Integer>> value = values.get(i);
				if (value == null)
					continue;

				List<Integer> exterior = value.get(0);
				if (exterior == null)
					continue;

				Integer textureIndex = exterior.get(0);
				if (textureIndex == null)
					continue;

				if (texture == null)
					texture = textureIndex;
				else if (texture != textureIndex) {
					texture = null;
					break;
				}

				if (i < surface.getTrianglePatches().getTriangle().size())
					textureCoordinates.add(exterior);
				else
					break;
			}

			// we could not find one texture for all rings
			if (texture == null || textureCoordinates.isEmpty())
				continue;
			
			Map<Integer, List<AbstractSurface>> textures = new HashMap<>();
			textures.put(texture, Collections.singletonList(surface));
			surface.setLocalProperty(CityJSONUnmarshaller.TEXTURE_COORDINATES, textureCoordinates);

			// create parameterized texture
			json.getCityGMLUnmarshaller().getAppearanceUnmarshaller().unmarshalParameterizedTexture(textureObject, textures, cityObject);
		}
	}

	private Map<Integer, List<AbstractSurface>> collectSurfaces(List<Integer> values, List<AbstractSurface> surfaces) {
		Map<Integer, List<AbstractSurface>> result = new HashMap<>();

		// collect polygons per value
		for (int i = 0; i < values.size(); i++) {
			Integer value = values.get(i);
			if (value == null)
				continue;

			if (i < surfaces.size()) {
				AbstractSurface surface = surfaces.get(i);
				if (surface == null)
					continue;

				List<AbstractSurface> tmp = result.get(value);
				if (tmp == null) {
					tmp = new ArrayList<>();
					result.put(value, tmp);
				}

				tmp.add(surface);
			} else
				break;
		}

		return result;
	}

	private List<Double> getVertices(List<Integer> indexes) {
		List<Double> vertices = new ArrayList<>();		
		for (Integer index : indexes) {
			if (index != null && index < numVertices) {
				List<Double> vertex = this.vertices.get(index);
				if (vertex != null && vertex.size() == 3)
					vertices.addAll(vertex);
			}
		}

		return vertices;
	}

}
