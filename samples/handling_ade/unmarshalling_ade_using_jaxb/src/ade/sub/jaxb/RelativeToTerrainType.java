/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2012
 * Institute for Geodesy and Geoinformation Science
 * Technische Universität Berlin, Germany
 * http://www.igg.tu-berlin.de/
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 * 
 * $Id$
 */

package ade.sub.jaxb;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RelativeToTerrainType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RelativeToTerrainType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="entirelyAboveTerrain"/>
 *     &lt;enumeration value="substantiallyAboveTerrain"/>
 *     &lt;enumeration value="substantiallyAboveAndBelowTerrain"/>
 *     &lt;enumeration value="substantiallyBelowTerrain"/>
 *     &lt;enumeration value="entirelyBelowTerrain"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RelativeToTerrainType")
@XmlEnum
public enum RelativeToTerrainType {

    @XmlEnumValue("entirelyAboveTerrain")
    ENTIRELY_ABOVE_TERRAIN("entirelyAboveTerrain"),
    @XmlEnumValue("substantiallyAboveTerrain")
    SUBSTANTIALLY_ABOVE_TERRAIN("substantiallyAboveTerrain"),
    @XmlEnumValue("substantiallyAboveAndBelowTerrain")
    SUBSTANTIALLY_ABOVE_AND_BELOW_TERRAIN("substantiallyAboveAndBelowTerrain"),
    @XmlEnumValue("substantiallyBelowTerrain")
    SUBSTANTIALLY_BELOW_TERRAIN("substantiallyBelowTerrain"),
    @XmlEnumValue("entirelyBelowTerrain")
    ENTIRELY_BELOW_TERRAIN("entirelyBelowTerrain");
    private final String value;

    RelativeToTerrainType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RelativeToTerrainType fromValue(String v) {
        for (RelativeToTerrainType c: RelativeToTerrainType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
