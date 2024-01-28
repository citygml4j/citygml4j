/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2024 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.core.util.geometry;

import org.xmlobjects.gml.model.geometry.AbstractGeometry;
import org.xmlobjects.gml.model.geometry.DirectPosition;
import org.xmlobjects.gml.model.geometry.DirectPositionList;
import org.xmlobjects.gml.model.geometry.aggregates.MultiCurve;
import org.xmlobjects.gml.model.geometry.aggregates.MultiPoint;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurface;
import org.xmlobjects.gml.model.geometry.primitives.*;
import org.xmlobjects.gml.util.id.IdCreator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GeometryFactory {
    private boolean setSrsDimension = true;
    private boolean setCount;
    private IdCreator idCreator;

    private GeometryFactory() {
    }

    public static GeometryFactory newInstance() {
        return new GeometryFactory();
    }

    public boolean isSetSrsDimension() {
        return setSrsDimension;
    }

    public GeometryFactory setSrsDimension(boolean setSrsDimension) {
        this.setSrsDimension = setSrsDimension;
        return this;
    }

    public boolean isSetCount() {
        return setCount;
    }

    public GeometryFactory setCount(boolean setCount) {
        this.setCount = setCount;
        return this;
    }

    public IdCreator getIdCreator() {
        return idCreator;
    }

    public GeometryFactory withIdCreator(IdCreator idCreator) {
        this.idCreator = idCreator;
        return this;
    }

    public Point createPoint(List<Double> coordinates, int dimension) {
        return postprocess(new Point(createDirectPosition(coordinates, dimension)));
    }

    public Point createPoint(double[] coordinates, int dimension) {
        return createPoint(Arrays.stream(coordinates).boxed().collect(Collectors.toList()), dimension);
    }

    public MultiPoint createMultiPoint(List<Point> points) {
        return postprocess(new MultiPoint(points.stream().map(PointProperty::new).collect(Collectors.toList())));
    }

    public MultiPoint createMultiPoint(Point... points) {
        return postprocess(new MultiPoint(Arrays.stream(points).map(PointProperty::new).collect(Collectors.toList())));
    }

    public MultiPoint createMultiPoint(List<List<Double>> coordinates, int dimension) {
        return createMultiPoint(coordinates.stream().map(v -> createPoint(v, dimension)).collect(Collectors.toList()));
    }

    public MultiPoint createMultiPoint(double[][] coordinates, int dimension) {
        return createMultiPoint(Arrays.stream(coordinates).map(v -> createPoint(v, dimension)).collect(Collectors.toList()));
    }

    public LineString createLineString(List<Double> coordinates, int dimension) {
        return postprocess(new LineString(createDirectPositionList(coordinates, dimension)));
    }

    public LineString createLineString(double[] coordinates, int dimension) {
        return createLineString(Arrays.stream(coordinates).boxed().collect(Collectors.toList()), dimension);
    }

    public MultiCurve createMultiCurve(List<LineString> lineStrings) {
        return postprocess(new MultiCurve(lineStrings.stream().map(CurveProperty::new).collect(Collectors.toList())));
    }

    public MultiCurve createMultiCurve(LineString... lineStrings) {
        return postprocess(new MultiCurve(Arrays.stream(lineStrings).map(CurveProperty::new).collect(Collectors.toList())));
    }

    public MultiCurve createMultiCurve(List<List<Double>> coordinates, int dimension) {
        return createMultiCurve(coordinates.stream().map(v -> createLineString(v, dimension)).collect(Collectors.toList()));
    }

    public MultiCurve createMultiCurve(double[][] coordinates, int dimension) {
        return createMultiCurve(Arrays.stream(coordinates).map(v -> createLineString(v, dimension)).collect(Collectors.toList()));
    }

    public Polygon createPolygon(LinearRing linearRing) {
        return postprocess(new Polygon(linearRing));
    }

    public Polygon createPolygon(List<Double> coordinates, int dimension) {
        return createPolygon(createLinearRing(coordinates, dimension));
    }

    public Polygon createPolygon(double[] coordinates, int dimension) {
        return createPolygon(Arrays.stream(coordinates).boxed().collect(Collectors.toList()), dimension);
    }

    public Polygon createPolygon(LinearRing exterior, List<LinearRing> interiors) {
        Polygon polygon = new Polygon(exterior);
        interiors.stream().map(AbstractRingProperty::new).forEach(polygon.getInterior()::add);
        return postprocess(polygon);
    }

    public Polygon createPolygon(LinearRing exterior, LinearRing... interiors) {
        return createPolygon(exterior, Arrays.asList(interiors));
    }

    public Polygon createPolygon(List<Double> exterior, List<List<Double>> interiors, int dimension) {
        return createPolygon(createLinearRing(exterior, dimension),
                interiors.stream().map(v -> createLinearRing(v, dimension)).collect(Collectors.toList()));
    }

    public Polygon createPolygon(double[] exterior, double[][] interiors, int dimension) {
        return createPolygon(createLinearRing(exterior, dimension),
                Arrays.stream(interiors).map(v -> createLinearRing(v, dimension)).collect(Collectors.toList()));
    }

    public MultiSurface createMultiSurface(List<Polygon> polygons) {
        return postprocess(new MultiSurface(polygons.stream().map(SurfaceProperty::new).collect(Collectors.toList())));
    }

    public MultiSurface createMultiSurface(Polygon... polygons) {
        return postprocess(new MultiSurface(Arrays.stream(polygons).map(SurfaceProperty::new).collect(Collectors.toList())));
    }

    public MultiSurface createMultiSurface(List<List<Double>> coordinates, int dimension) {
        return createMultiSurface(coordinates.stream().map(v -> createPolygon(v, dimension)).collect(Collectors.toList()));
    }

    public MultiSurface createMultiSurface(double[][] coordinates, int dimension) {
        return createMultiSurface(Arrays.stream(coordinates).map(v -> createPolygon(v, dimension)).collect(Collectors.toList()));
    }

    public Solid createSolid(Shell shell) {
        return postprocess(new Solid(shell));
    }

    public Solid createSolid(Shell exterior, List<Shell> interiors) {
        Solid solid = new Solid(exterior);
        interiors.stream().map(ShellProperty::new).forEach(solid.getInterior()::add);
        return postprocess(solid);
    }

    public Solid createSolid(List<Polygon> polygons) {
        return postprocess(new Solid(createShell(polygons)));
    }

    public Solid createSolid(Polygon... polygons) {
        return postprocess(new Solid(createShell(polygons)));
    }

    public Solid createSolid(List<List<Double>> coordinates, int dimension) {
        return postprocess(new Solid(createShell(coordinates, dimension)));
    }

    public Solid createSolid(double[][] coordinates, int dimension) {
        return postprocess(new Solid(createShell(coordinates, dimension)));
    }

    public Shell createShell(List<Polygon> polygons) {
        return postprocess(new Shell(polygons.stream().map(SurfaceProperty::new).collect(Collectors.toList())));
    }

    public Shell createShell(Polygon... polygons) {
        return postprocess(new Shell(Arrays.stream(polygons).map(SurfaceProperty::new).collect(Collectors.toList())));
    }

    public Shell createShell(List<List<Double>> coordinates, int dimension) {
        return createShell(coordinates.stream().map(v -> createPolygon(v, dimension)).collect(Collectors.toList()));
    }

    public Shell createShell(double[][] coordinates, int dimension) {
        return createShell(Arrays.stream(coordinates).map(v -> createPolygon(v, dimension)).collect(Collectors.toList()));
    }

    public LinearRing createLinearRing(List<Double> coordinates, int dimension) {
        if (coordinates.size() < 3 * dimension)
            throw new GeometryException("A linear ring requires at least three control points.");

        boolean closeRing = false;
        for (int i = 0; i < dimension; i++) {
            if (!coordinates.get(i).equals(coordinates.get(coordinates.size() - dimension + i))) {
                closeRing = true;
                break;
            }
        }

        if (closeRing) {
            for (int i = 0; i < dimension; i++)
                coordinates.add(coordinates.get(i));
        }

        return postprocess(new LinearRing(createDirectPositionList(coordinates, dimension)));
    }

    public LinearRing createLinearRing(double[] coordinates, int dimension) {
        return createLinearRing(Arrays.stream(coordinates).boxed().collect(Collectors.toList()), dimension);
    }

    public DirectPositionList createDirectPositionList(List<Double> coordinates, int dimension) {
        if (coordinates.size() % dimension != 0)
            throw new GeometryException("Dimension mismatch.");

        DirectPositionList posList = new DirectPositionList(coordinates);

        if (setSrsDimension)
            posList.setSrsDimension(dimension);

        if (setCount)
            posList.setCount(coordinates.size() / dimension);

        return posList;
    }

    public DirectPositionList createDirectPositionList(double[] coordinates, int dimension) {
        return createDirectPositionList(Arrays.stream(coordinates).boxed().collect(Collectors.toList()), dimension);
    }

    public DirectPosition createDirectPosition(List<Double> coordinates, int dimension) {
        if (coordinates.size() != dimension)
            throw new GeometryException("Dimension mismatch.");

        DirectPosition posList = new DirectPosition(coordinates);

        if (setSrsDimension)
            posList.setSrsDimension(dimension);

        return posList;
    }

    public DirectPosition createDirectPosition(double[] coordinates, int dimension) {
        return createDirectPosition(Arrays.stream(coordinates).boxed().collect(Collectors.toList()), dimension);
    }

    private <T extends AbstractGeometry> T postprocess(T object) {
        if (idCreator != null)
            object.setId(idCreator.createId());

        return object;
    }
}
