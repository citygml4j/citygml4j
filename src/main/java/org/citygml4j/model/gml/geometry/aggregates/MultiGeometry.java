/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2025 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml4j.model.gml.geometry.aggregates;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.model.common.base.ModelObjects;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.common.visitor.GeometryFunctor;
import org.citygml4j.model.common.visitor.GeometryVisitor;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryArrayProperty;
import org.citygml4j.model.gml.geometry.GeometryProperty;

import java.util.Arrays;
import java.util.List;

public class MultiGeometry extends AbstractGeometricAggregate {
    private List<GeometryProperty<? extends AbstractGeometry>> geometryMember;
    private GeometryArrayProperty<? extends AbstractGeometry> geometryMembers;

    public MultiGeometry() {

    }

    public MultiGeometry(List<? extends AbstractGeometry> abstractGeometries) {
        for (AbstractGeometry abstractGeometry : abstractGeometries)
            addGeometryMember(new GeometryProperty<>(abstractGeometry));
    }

    public MultiGeometry(AbstractGeometry... abstractGeometries) {
        this(Arrays.asList(abstractGeometries));
    }

    public void addGeometryMember(GeometryProperty<? extends AbstractGeometry> geometryMember) {
        getGeometryMember().add(geometryMember);
    }

    public List<GeometryProperty<? extends AbstractGeometry>> getGeometryMember() {
        if (geometryMember == null)
            geometryMember = new ChildList<>(this);

        return geometryMember;
    }

    public GeometryArrayProperty<? extends AbstractGeometry> getGeometryMembers() {
        return geometryMembers;
    }

    public boolean isSetGeometryMember() {
        return geometryMember != null && !geometryMember.isEmpty();
    }

    public boolean isSetGeometryMembers() {
        return geometryMembers != null;
    }

    public void setGeometryMember(List<GeometryProperty<? extends AbstractGeometry>> geometryMember) {
        this.geometryMember = new ChildList<>(this, geometryMember);
    }

    public void setGeometryMembers(GeometryArrayProperty<? extends AbstractGeometry> geometryMembers) {
        this.geometryMembers = ModelObjects.setParent(geometryMembers, this);
    }

    public void unsetGeometryMember() {
        geometryMember = ModelObjects.setNull(geometryMember);
    }

    public boolean unsetGeometryMember(GeometryProperty<? extends AbstractGeometry> geometryMember) {
        return isSetGeometryMember() && this.geometryMember.remove(geometryMember);
    }

    public void unsetGeometryMembers() {
        geometryMembers = ModelObjects.setNull(geometryMembers);
    }

    public BoundingBox calcBoundingBox() {
        BoundingBox bbox = new BoundingBox();

        if (isSetGeometryMember()) {
            for (GeometryProperty<? extends AbstractGeometry> geometryProperty : getGeometryMember())
                if (geometryProperty.isSetGeometry())
                    bbox.update(geometryProperty.getGeometry().calcBoundingBox());
        }

        if (isSetGeometryMembers()) {
            GeometryArrayProperty<? extends AbstractGeometry> geometryArrayProperty = getGeometryMembers();

            if (geometryArrayProperty.isSetGeometry())
                for (AbstractGeometry abstractGeometry : geometryArrayProperty.getGeometry())
                    bbox.update(abstractGeometry.calcBoundingBox());
        }

        return bbox;
    }

    public GMLClass getGMLClass() {
        return GMLClass.MULTI_GEOMETRY;
    }

    public Object copy(CopyBuilder copyBuilder) {
        return copyTo(new MultiGeometry(), copyBuilder);
    }

    @Override
    public Object copyTo(Object target, CopyBuilder copyBuilder) {
        MultiGeometry copy = (target == null) ? new MultiGeometry() : (MultiGeometry) target;
        super.copyTo(copy, copyBuilder);

        if (isSetGeometryMember()) {
            for (GeometryProperty<? extends AbstractGeometry> part : geometryMember) {
                GeometryProperty<? extends AbstractGeometry> copyPart = (GeometryProperty<? extends AbstractGeometry>) copyBuilder.copy(part);
                copy.addGeometryMember(copyPart);

                if (part != null && copyPart == part)
                    part.setParent(this);
            }
        }

        if (isSetGeometryMembers()) {
            copy.setGeometryMembers((GeometryArrayProperty<? extends AbstractGeometry>) copyBuilder.copy(geometryMembers));
            if (copy.getGeometryMembers() == geometryMembers)
                geometryMembers.setParent(this);
        }

        return copy;
    }

    public void accept(GeometryVisitor visitor) {
        visitor.visit(this);
    }

    public <T> T accept(GeometryFunctor<T> visitor) {
        return visitor.apply(this);
    }

    public void accept(GMLVisitor visitor) {
        visitor.visit(this);
    }

    public <T> T accept(GMLFunctor<T> visitor) {
        return visitor.apply(this);
    }

}
