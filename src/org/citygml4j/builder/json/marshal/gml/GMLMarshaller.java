package org.citygml4j.builder.json.marshal.gml;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.citygml4j.builder.json.marshal.CityJSONMarshaller;
import org.citygml4j.builder.json.marshal.util.AffineTransform;
import org.citygml4j.builder.json.marshal.util.SemanticsBuilder;
import org.citygml4j.builder.json.objects.appearance.AbstractMaterialObject;
import org.citygml4j.builder.json.objects.appearance.AbstractTextureObject;
import org.citygml4j.builder.json.objects.appearance.SolidCollectionMaterialObject;
import org.citygml4j.builder.json.objects.appearance.SolidCollectionTextureObject;
import org.citygml4j.builder.json.objects.appearance.SolidMaterialObject;
import org.citygml4j.builder.json.objects.appearance.SolidTextureObject;
import org.citygml4j.builder.json.objects.appearance.SurfaceCollectionMaterialObject;
import org.citygml4j.builder.json.objects.appearance.SurfaceCollectionTextureObject;
import org.citygml4j.builder.json.objects.geometry.AbstractGeometryType;
import org.citygml4j.builder.json.objects.geometry.AbstractSemanticsObject;
import org.citygml4j.builder.json.objects.geometry.AbstractSolidCollectionType;
import org.citygml4j.builder.json.objects.geometry.AbstractSurfaceCollectionType;
import org.citygml4j.builder.json.objects.geometry.CompositeSolidType;
import org.citygml4j.builder.json.objects.geometry.CompositeSurfaceType;
import org.citygml4j.builder.json.objects.geometry.GeometryWithAppearance;
import org.citygml4j.builder.json.objects.geometry.GeometryWithSemantics;
import org.citygml4j.builder.json.objects.geometry.MultiLineStringType;
import org.citygml4j.builder.json.objects.geometry.MultiPointType;
import org.citygml4j.builder.json.objects.geometry.MultiSolidType;
import org.citygml4j.builder.json.objects.geometry.MultiSurfaceType;
import org.citygml4j.builder.json.objects.geometry.SolidCollectionSemanticsObject;
import org.citygml4j.builder.json.objects.geometry.SolidSemanticsObject;
import org.citygml4j.builder.json.objects.geometry.SolidType;
import org.citygml4j.builder.json.objects.geometry.SurfaceCollectionSemanticsObject;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;
import org.citygml4j.model.gml.geometry.aggregates.MultiCurve;
import org.citygml4j.model.gml.geometry.aggregates.MultiPoint;
import org.citygml4j.model.gml.geometry.aggregates.MultiSolid;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurface;
import org.citygml4j.model.gml.geometry.complexes.CompositeSolid;
import org.citygml4j.model.gml.geometry.complexes.CompositeSurface;
import org.citygml4j.model.gml.geometry.primitives.AbstractCurveSegment;
import org.citygml4j.model.gml.geometry.primitives.AbstractRing;
import org.citygml4j.model.gml.geometry.primitives.AbstractRingProperty;
import org.citygml4j.model.gml.geometry.primitives.Curve;
import org.citygml4j.model.gml.geometry.primitives.CurveSegmentArrayProperty;
import org.citygml4j.model.gml.geometry.primitives.LineString;
import org.citygml4j.model.gml.geometry.primitives.LineStringSegment;
import org.citygml4j.model.gml.geometry.primitives.LinearRing;
import org.citygml4j.model.gml.geometry.primitives.OrientableCurve;
import org.citygml4j.model.gml.geometry.primitives.OrientableSurface;
import org.citygml4j.model.gml.geometry.primitives.Point;
import org.citygml4j.model.gml.geometry.primitives.PointArrayProperty;
import org.citygml4j.model.gml.geometry.primitives.PointProperty;
import org.citygml4j.model.gml.geometry.primitives.Polygon;
import org.citygml4j.model.gml.geometry.primitives.Sign;
import org.citygml4j.model.gml.geometry.primitives.Solid;
import org.citygml4j.model.gml.geometry.primitives.Surface;
import org.citygml4j.model.gml.geometry.primitives.SurfaceProperty;
import org.citygml4j.model.gml.geometry.primitives.Tin;
import org.citygml4j.model.gml.geometry.primitives.TriangulatedSurface;
import org.citygml4j.util.child.ChildInfo;
import org.citygml4j.util.mapper.BiFunctionTypeMapper;
import org.citygml4j.util.walker.GeometryWalker;

public class GMLMarshaller {
	private final CityJSONMarshaller json;
	private final ChildInfo childInfo;
	private final BiFunctionTypeMapper<AffineTransform, AbstractGeometryType> typeMapper;

	public GMLMarshaller(CityJSONMarshaller json) {
		this.json = json;
		childInfo = new ChildInfo();

		typeMapper = BiFunctionTypeMapper.<AffineTransform, AbstractGeometryType>create()
				.with(MultiPoint.class, this::marshalMultiPoint)
				.with(MultiCurve.class, this::marshalMultiLineString)
				.with(Surface.class, this::marshalSurface)
				.with(TriangulatedSurface.class, this::marshalTriangulatedSurface)
				.with(Tin.class, this::marshalTin)
				.with(MultiSurface.class, this::marshalMultiSurface)
				.with(CompositeSurface.class, this::marshalCompositeSurface)
				.with(Solid.class, this::marshalSolid)
				.with(CompositeSolid.class, this::marshalCompositeSolid)
				.with(MultiSolid.class, this::marshalMultiSolid);
	}

	public AbstractGeometryType marshal(ModelObject src, AffineTransform transformer) {
		return typeMapper.apply(src, transformer);
	}

	public AbstractGeometryType marshal(ModelObject src) {
		return typeMapper.apply(src, null);
	}

	public void marshalMultiPoint(MultiPoint src, MultiPointType dest, AffineTransform transformer) {
		if (src.isSetPointMember()) {
			for (PointProperty pointProperty : src.getPointMember())
				if (pointProperty.isSetPoint()) {
					List<Double> vertex = pointProperty.getPoint().toList3d();
					if (!vertex.isEmpty()) {
						if (transformer != null)
							transformer.transform(vertex);

						dest.addPoints(json.getVerticesBuilder().addVertices(vertex));
					}
				}

		} else if (src.isSetPointMembers()) {
			PointArrayProperty pointArrayProperty = src.getPointMembers();
			for (Point point : pointArrayProperty.getPoint()) {
				List<Double> vertex = point.toList3d();
				if (!vertex.isEmpty()) {
					if (transformer != null)
						transformer.transform(vertex);

					dest.addPoints(json.getVerticesBuilder().addVertices(vertex));
				}
			}
		}
	}

	public MultiPointType marshalMultiPoint(MultiPoint src, AffineTransform transformer) {
		MultiPointType dest = new MultiPointType();
		marshalMultiPoint(src, dest, transformer);

		return dest;
	}

	public void marshalMultiLineString(MultiCurve src, MultiLineStringType dest, AffineTransform transformer) {
		MultiLineStringBuilder builder = new MultiLineStringBuilder();
		builder.process(src, dest, transformer);
	}

	public MultiLineStringType marshalMultiLineString(MultiCurve src, AffineTransform transformer) {
		MultiLineStringType dest = new MultiLineStringType();
		marshalMultiLineString(src, dest, transformer);

		return dest;
	}

	public void marshalSurface(Surface src, CompositeSurfaceType dest, AffineTransform transformer) {
		SurfaceCollectionBuilder surfaceBuilder = new SurfaceCollectionBuilder();
		SemanticsBuilder semanticsBuilder = new SemanticsBuilder(json.getCityGMLMarshaller());
		surfaceBuilder.process(src, dest, semanticsBuilder, transformer);

		if (dest.isSetSemantics())
			dest.getSemantics().setSurfaces(semanticsBuilder.getSurfaces());
	}

	public CompositeSurfaceType marshalSurface(Surface src, AffineTransform transformer) {
		CompositeSurfaceType dest = new CompositeSurfaceType();
		marshalSurface(src, dest, transformer);

		return dest;
	}

	public CompositeSurfaceType marshalTriangulatedSurface(TriangulatedSurface src, AffineTransform transformer) {
		return marshalSurface(src, transformer);
	}

	public CompositeSurfaceType marshalTin(Tin src, AffineTransform transformer) {
		return marshalTriangulatedSurface(src, transformer);
	}

	public void marshalSurfaceCollection(AbstractGeometry src, AbstractSurfaceCollectionType dest, AffineTransform transformer) {
		SurfaceCollectionBuilder surfaceBuilder = new SurfaceCollectionBuilder();
		SemanticsBuilder semanticsBuilder = new SemanticsBuilder(json.getCityGMLMarshaller());
		surfaceBuilder.process(src, dest, semanticsBuilder, transformer);
		
		if (dest.isSetSemantics())
			dest.getSemantics().setSurfaces(semanticsBuilder.getSurfaces());
	}

	public MultiSurfaceType marshalMultiSurface(MultiSurface src, AffineTransform transformer) {
		MultiSurfaceType dest = new MultiSurfaceType();
		marshalSurfaceCollection(src, dest, transformer);

		return dest;
	}

	public CompositeSurfaceType marshalCompositeSurface(CompositeSurface src, AffineTransform transformer) {
		CompositeSurfaceType dest = new CompositeSurfaceType();
		marshalSurfaceCollection(src, dest, transformer);
		
		return dest;
	}

	public void marshalSolid(Solid src, SolidType dest, SemanticsBuilder semanticsBuilder, AffineTransform transformer) {
		SurfaceCollectionBuilder surfaceBuilder = new SurfaceCollectionBuilder();
		int index = 0;

		if (src.isSetExterior() && src.getExterior().getSurface() instanceof CompositeSurface) {
			List<CompositeSurface> shells = new ArrayList<>();
			shells.add((CompositeSurface)src.getExterior().getSurface());

			if (src.isSetInterior()) {
				for (SurfaceProperty property : src.getInterior()) {
					if (property.getSurface() instanceof CompositeSurface)
						shells.add((CompositeSurface)property.getSurface());
				}
			}

			for (CompositeSurface shell : shells) {
				CompositeSurfaceType shellType = new CompositeSurfaceType();
				surfaceBuilder.process(shell, shellType, semanticsBuilder, transformer);

				if (!shellType.getSurfaces().isEmpty()) {
					dest.addShell(shellType.getSurfaces());

					if (shellType.isSetSemantics()) {
						SolidSemanticsObject semantics = dest.getSemantics();
						if (semantics == null) {
							semantics = new SolidSemanticsObject();
							dest.setSemantics(semantics);
						}

						// add null values for non-semantic surfaces
						appendNulls(semantics, index);
						semantics.addValues(shellType.getSemantics().getValues());
					}

					if (shellType.isSetMaterial()) {
						for (SurfaceCollectionMaterialObject object : shellType.getMaterial()) {
							SolidMaterialObject material = dest.getMaterial(object.getTheme());
							if (material == null) {
								material = new SolidMaterialObject(object.getTheme());
								dest.addMaterial(material);
							}

							// add null values for non-colored surfaces
							appendNulls(material, index);
							material.addValue(object.getValues());
						}
					}

					if (shellType.isSetTexture()) {
						for (SurfaceCollectionTextureObject object : shellType.getTexture()) {
							SolidTextureObject texture = dest.getTexture(object.getTheme());
							if (texture == null) {
								texture = new SolidTextureObject(object.getTheme());
								dest.addTexture(texture);
							}

							// add null values for non-textured surfaces
							appendNulls(texture, index);
							texture.addValue(object.getValues());
						}
					}

					index++;
				} else if (index == 0)
					break;
			}

			postprocess(dest, index);
		}
	}

	public SolidType marshalSolid(Solid src, AffineTransform transformer) {
		SolidType dest = new SolidType();
		SemanticsBuilder semanticsBuilder = new SemanticsBuilder(json.getCityGMLMarshaller());
		marshalSolid(src, dest, semanticsBuilder, transformer);
		
		if (dest.isSetSemantics())
			dest.getSemantics().setSurfaces(semanticsBuilder.getSurfaces());
		
		return dest;
	}

	public void marshalSolidCollection(AbstractGeometry src, AbstractSolidCollectionType dest, AffineTransform transformer) {
		SolidCollectionBuilder builder = new SolidCollectionBuilder();
		SemanticsBuilder semanticsBuilder = new SemanticsBuilder(json.getCityGMLMarshaller());
		builder.process(src, dest, semanticsBuilder, transformer);
		
		if (dest.isSetSemantics())
			dest.getSemantics().setSurfaces(semanticsBuilder.getSurfaces());
	}

	public CompositeSolidType marshalCompositeSolid(CompositeSolid src, AffineTransform transformer) {
		CompositeSolidType dest = new CompositeSolidType();
		marshalSolidCollection(src, dest, transformer);		

		return dest;
	}

	public MultiSolidType marshalMultiSolid(MultiSolid src, AffineTransform transformer) {
		MultiSolidType dest = new MultiSolidType();
		marshalSolidCollection(src, dest, transformer);
		
		return dest;
	}

	public AbstractGeometryType marshalGeometryProperty(GeometryProperty<?> src, AffineTransform transformer) {
		Object dest = null;
		if (src.isSetGeometry())
			dest = marshal(src.getGeometry(), transformer);
		else if (src.hasLocalProperty(CityJSONMarshaller.GEOMETRY_XLINK))
			dest = marshal((AbstractGeometry)src.getLocalProperty(CityJSONMarshaller.GEOMETRY_XLINK), transformer);

		return dest instanceof AbstractGeometryType ? (AbstractGeometryType)dest : null;
	}

	public AbstractGeometryType marshalGeometryProperty(GeometryProperty<?> src) {
		return marshalGeometryProperty(src, null);
	}

	private List<List<Integer>> marshalPolygon(Polygon polygon, AffineTransform transformer, boolean reverse) {
		List<List<Integer>> vertices = null;

		if (polygon.isSetExterior()) {
			AbstractRing exterior = polygon.getExterior().getRing();
			if (exterior instanceof LinearRing) {
				List<Integer> indexes = marshalLinearRing((LinearRing)exterior, transformer, reverse);
				if (indexes != null) {
					vertices = new ArrayList<>();
					vertices.add(indexes);

					if (polygon.isSetInterior()) {
						for (AbstractRingProperty property : polygon.getInterior()) {
							AbstractRing interior = property.getRing();
							if (interior instanceof LinearRing) {
								indexes = marshalLinearRing((LinearRing)interior, transformer, reverse);
								if (indexes != null)
									vertices.add(indexes);
							}
						}
					}
				}
			}
		}

		return vertices;
	}

	private List<Integer> marshalLinearRing(LinearRing linearRing, AffineTransform transformer, boolean reverse) {
		List<Integer> vertices = null;

		List<Double> values = linearRing.toList3d(reverse);
		if (values.size() > 11) {
			if (transformer != null)
				transformer.transform(values);

			vertices = json.getVerticesBuilder().addVertices(values.subList(0, values.size() - 3));
		}

		return vertices;
	}

	private final class MultiLineStringBuilder extends GeometryWalker {
		private MultiLineStringType dest;
		private AffineTransform transformer;
		private boolean reverse = false;

		@Override
		public void visit(LineString lineString) {
			List<Double> vertices = lineString.toList3d(reverse);
			if (!vertices.isEmpty()) {
				if (transformer != null)
					transformer.transform(vertices);

				dest.addLineString(json.getVerticesBuilder().addVertices(vertices));
			}
		}

		@Override
		public void visit(Curve curve) {
			if (curve.isSetSegments()) {
				CurveSegmentArrayProperty arrayProperty = curve.getSegments();
				if (arrayProperty.isSetCurveSegment()) {
					List<Double> vertices = new ArrayList<Double>();
					for (AbstractCurveSegment abstractCurveSegment : arrayProperty.getCurveSegment()) {
						if (abstractCurveSegment.getGMLClass() == GMLClass.LINE_STRING_SEGMENT) {
							List<Double> values = ((LineStringSegment)abstractCurveSegment).toList3d();
							if (!values.isEmpty()) {
								if (transformer != null)
									transformer.transform(values);

								vertices.addAll(values);
							}
						}
					}

					if (!vertices.isEmpty()) {
						if (!reverse)
							dest.addLineString(json.getVerticesBuilder().addVertices(vertices));
						else {
							for (int i = vertices.size() - 3; i >= 0; i -= 3)
								dest.addLineString(json.getVerticesBuilder().addVertices(vertices.subList(i, i + 3)));
						}
					}
				}
			}
		}

		@Override
		public void visit(OrientableCurve orientableCurve) {
			if (orientableCurve.getOrientation() == Sign.MINUS) {
				reverse = !reverse;
				super.visit(orientableCurve);
				reverse = !reverse;
			} else
				super.visit(orientableCurve);
		}

		@Override
		public <T extends AbstractGeometry> void visit(GeometryProperty<T> property) {
			if (property.hasLocalProperty(CityJSONMarshaller.GEOMETRY_XLINK))
				((AbstractGeometry)property.getLocalProperty(CityJSONMarshaller.GEOMETRY_XLINK)).accept(this);
			else
				super.visit(property);
		}

		public void process(MultiCurve src, MultiLineStringType dest, AffineTransform transformer) {
			this.dest = dest;
			this.transformer = transformer;
			src.accept(this);
		}
	}

	private final class SurfaceCollectionBuilder extends GeometryWalker {
		private AbstractSurfaceCollectionType dest;
		private SemanticsBuilder semanticsBuilder;
		private AffineTransform transformer;
		private boolean reverse = false;
		private int index = 0;

		@Override
		public void visit(Polygon polygon) {			
			List<List<Integer>> surface = marshalPolygon(polygon, transformer, reverse);
			if (surface != null) {
				Integer semanticsIndex = semanticsBuilder.addSemanticSurface(childInfo.getParentCityObject(polygon));
				Map<String, Integer> materials = json.getCityGMLMarshaller().getAppearanceMarshaller().getMaterials(polygon, reverse);
				Map<String, List<List<Integer>>> textures = json.getCityGMLMarshaller().getAppearanceMarshaller().getTextures(polygon, reverse);

				addSurface(surface, semanticsIndex, materials, textures);
			}
		}

		@Override
		public void visit(LinearRing linearRing) {
			// required for gml:Rectangle and gml:Triangle
			List<Integer> vertices = marshalLinearRing(linearRing, transformer, reverse);
			if (vertices != null) {
				Integer semanticsIndex = semanticsBuilder.addSemanticSurface(childInfo.getParentCityObject(linearRing));
				Map<String, Integer> materials = json.getCityGMLMarshaller().getAppearanceMarshaller().getMaterials(linearRing, reverse);
				Map<String, List<List<Integer>>> textures = json.getCityGMLMarshaller().getAppearanceMarshaller().getTextures(linearRing, reverse);

				addSurface(Collections.singletonList(vertices), semanticsIndex, materials, textures);				
			}
		}

		@Override
		public void visit(OrientableSurface orientableSurface) {
			if (orientableSurface.getOrientation() == Sign.MINUS) {
				reverse = !reverse;
				super.visit(orientableSurface);
				reverse = !reverse;
			} else
				super.visit(orientableSurface);
		}

		@Override
		public <T extends AbstractGeometry> void visit(GeometryProperty<T> property) {
			if (property.hasLocalProperty(CityJSONMarshaller.GEOMETRY_XLINK))
				((AbstractGeometry)property.getLocalProperty(CityJSONMarshaller.GEOMETRY_XLINK)).accept(this);
			else
				super.visit(property);
		}

		private void addSurface(List<List<Integer>> surface, Integer semanticsIndex, Map<String, Integer> materials, Map<String, List<List<Integer>>> textures) {
			dest.addSurface(surface);
			
			if (semanticsIndex != null) {
				SurfaceCollectionSemanticsObject semantics = dest.getSemantics();
				if (semantics == null) {
					semantics = new SurfaceCollectionSemanticsObject();
					dest.setSemantics(semantics);
				}
				
				appendNulls(dest.getSemantics(), index);
				dest.getSemantics().addValue(semanticsIndex);
			}

			if (materials != null) {
				for (Entry<String, Integer> entry : materials.entrySet()) {
					SurfaceCollectionMaterialObject material = dest.getMaterial(entry.getKey());
					if (material == null) {
						material = new SurfaceCollectionMaterialObject(entry.getKey());
						dest.addMaterial(material);
					}

					// add null values for non-colored surfaces
					appendNulls(material, index);
					material.addValue(entry.getValue());
				}
			}

			if (textures != null) {
				for (Entry<String, List<List<Integer>>> entry : textures.entrySet()) {
					SurfaceCollectionTextureObject texture = dest.getTexture(entry.getKey());
					if (texture == null) {
						texture = new SurfaceCollectionTextureObject(entry.getKey());
						dest.addTexture(texture);
					}

					// add null values for non-textured surfaces
					appendNulls(texture, index);
					texture.addValue(entry.getValue());
				}
			}

			index++;
		}

		public void process(AbstractGeometry src, AbstractSurfaceCollectionType dest, SemanticsBuilder semanticsBuilder, AffineTransform transformer) {
			this.dest = dest;
			this.semanticsBuilder = semanticsBuilder;
			this.transformer = transformer;
			
			src.accept(this);
			postprocess(dest, index);
		}
	}

	private final class SolidCollectionBuilder extends GeometryWalker {
		private AbstractSolidCollectionType dest;
		private SemanticsBuilder semanticsBuilder;
		private AffineTransform transformer;
		private int index = 0;

		@Override
		public void visit(Solid solid) {
			SolidType solidType = new SolidType();
			marshalSolid(solid, solidType, semanticsBuilder, transformer);

			if (!solidType.getShells().isEmpty()) {
				dest.addSolid(solidType.getShells());

				if (solidType.isSetSemantics()) {
					SolidCollectionSemanticsObject semantics = dest.getSemantics();
					if (semantics == null) {
						semantics = new SolidCollectionSemanticsObject();
						dest.setSemantics(semantics);
					}

					// add null values for non-semantic surfaces
					appendNulls(semantics, index);
					semantics.addValues(solidType.getSemantics().getValues());
				}

				if (solidType.isSetMaterial()) {
					for (SolidMaterialObject object : solidType.getMaterial()) {
						SolidCollectionMaterialObject material = dest.getMaterial(object.getTheme());
						if (material == null) {
							material = new SolidCollectionMaterialObject(object.getTheme());
							dest.addMaterial(material);
						}

						// add null values for non-colored surfaces
						appendNulls(material, index);
						material.addValue(object.getValues());
					}
				}

				if (solidType.isSetTexture()) {
					for (SolidTextureObject object : solidType.getTexture()) {
						SolidCollectionTextureObject texture = dest.getTexture(object.getTheme());
						if (texture == null) {
							texture = new SolidCollectionTextureObject(object.getTheme());
							dest.addTexture(texture);
						}

						// add null values for non-textured surfaces
						appendNulls(texture, index);
						texture.addValue(object.getValues());
					}
				}

				index++;
			}
		}

		@Override
		public <T extends AbstractGeometry> void visit(GeometryProperty<T> property) {
			if (property.hasLocalProperty(CityJSONMarshaller.GEOMETRY_XLINK))
				((AbstractGeometry)property.getLocalProperty(CityJSONMarshaller.GEOMETRY_XLINK)).accept(this);
			else
				super.visit(property);
		}

		public void process(AbstractGeometry src, AbstractSolidCollectionType dest, SemanticsBuilder semanticsBuilder, AffineTransform transformer) {
			this.dest = dest;
			this.transformer = transformer;
			this.semanticsBuilder = semanticsBuilder;
			
			src.accept(this);
			postprocess(dest, index);
		}
	}

	private void appendNulls(AbstractSemanticsObject semantics, int index) {
		while (semantics.getNumValues() < index)
			semantics.addNullValue();
	}

	private void appendNulls(AbstractMaterialObject material, int index) {
		while (material.getNumValues() < index)
			material.addNullValue();
	}

	private void appendNulls(AbstractTextureObject texture, int index) {
		while (texture.getNumValues() < index)
			texture.addNullValue();
	}

	private void postprocess(AbstractGeometryType dest, int index) {
		if (dest instanceof GeometryWithSemantics) {
			GeometryWithSemantics geometry = (GeometryWithSemantics)dest;
			if (geometry.isSetSemantics())
				appendNulls(geometry.getSemantics(), index);
		}
		
		if (dest instanceof GeometryWithAppearance<?, ?>) {
			GeometryWithAppearance<?, ?> geometry = (GeometryWithAppearance<?, ?>)dest;			
			if (geometry.isSetMaterial()) {			
				for (AbstractMaterialObject material : geometry.getMaterial()) {
					if (!material.collapseValues())
						appendNulls(material, index);
				}
			}

			if (geometry.isSetTexture()) {
				for (AbstractTextureObject texture : geometry.getTexture())
					appendNulls(texture, index);
			}
		}
	}

}
