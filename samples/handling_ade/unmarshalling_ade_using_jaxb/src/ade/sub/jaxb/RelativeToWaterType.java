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
 * <p>Java class for RelativeToWaterType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RelativeToWaterType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="entirelyAboveWaterSurface"/>
 *     &lt;enumeration value="substantiallyAboveWaterSurface"/>
 *     &lt;enumeration value="substantiallyAboveAndBelowWaterSurface"/>
 *     &lt;enumeration value="substantiallyBelowWaterSurface"/>
 *     &lt;enumeration value="entirelyBelowWaterSurface"/>
 *     &lt;enumeration value="temporarilyAboveAndBelowWaterSurface"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RelativeToWaterType")
@XmlEnum
public enum RelativeToWaterType {

    @XmlEnumValue("entirelyAboveWaterSurface")
    ENTIRELY_ABOVE_WATER_SURFACE("entirelyAboveWaterSurface"),
    @XmlEnumValue("substantiallyAboveWaterSurface")
    SUBSTANTIALLY_ABOVE_WATER_SURFACE("substantiallyAboveWaterSurface"),
    @XmlEnumValue("substantiallyAboveAndBelowWaterSurface")
    SUBSTANTIALLY_ABOVE_AND_BELOW_WATER_SURFACE("substantiallyAboveAndBelowWaterSurface"),
    @XmlEnumValue("substantiallyBelowWaterSurface")
    SUBSTANTIALLY_BELOW_WATER_SURFACE("substantiallyBelowWaterSurface"),
    @XmlEnumValue("entirelyBelowWaterSurface")
    ENTIRELY_BELOW_WATER_SURFACE("entirelyBelowWaterSurface"),
    @XmlEnumValue("temporarilyAboveAndBelowWaterSurface")
    TEMPORARILY_ABOVE_AND_BELOW_WATER_SURFACE("temporarilyAboveAndBelowWaterSurface");
    private final String value;

    RelativeToWaterType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RelativeToWaterType fromValue(String v) {
        for (RelativeToWaterType c: RelativeToWaterType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
