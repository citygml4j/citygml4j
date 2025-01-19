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

package org.citygml4j.cityjson.model.metadata;

import org.xmlobjects.gml.model.geometry.Envelope;

import java.time.LocalDate;
import java.util.List;

public class Metadata {
    private String identifier;
    private PointOfContact pointOfContact;
    private LocalDate referenceDate;
    private String title;
    private List<Double> geographicalExtent;
    private ReferenceSystem referenceSystem;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public PointOfContact getPointOfContact() {
        return pointOfContact;
    }

    public void setPointOfContact(PointOfContact pointOfContact) {
        this.pointOfContact = pointOfContact;
    }

    public LocalDate getReferenceDate() {
        return referenceDate;
    }

    public void setReferenceDate(LocalDate referenceDate) {
        this.referenceDate = referenceDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isSetGeographicalExtent() {
        return geographicalExtent != null;
    }

    public List<Double> getGeographicalExtent() {
        return geographicalExtent != null ? List.copyOf(geographicalExtent) : null;
    }

    public void setGeographicalExtent(List<Double> geographicalExtent) {
        this.geographicalExtent = geographicalExtent != null && geographicalExtent.size() > 5 ?
                geographicalExtent.subList(0, 6) :
                null;
    }

    public void setGeographicalExtent(Envelope envelope) {
        setGeographicalExtent(envelope != null ? envelope.toCoordinateList3D() : null);
    }

    public ReferenceSystem getReferenceSystem() {
        return referenceSystem;
    }

    public void setReferenceSystem(ReferenceSystem referenceSystem) {
        this.referenceSystem = referenceSystem;
    }

    public void setReferenceSystem(int code) {
        setReferenceSystem(new ReferenceSystem(code));
    }
}
