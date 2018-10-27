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

//
// Generated with ade-xjc - XML Schema binding compiler for CityGML ADEs, version 2.6.1
// ade-xjc is part of the citygml4j project, see https://github.com/citygml4j
// Any modifications to this file will be lost upon recompilation of the source
// Generated: Sun Jan 21 21:03:34 CET 2018
//


package handling_ade.generic.unmarshalling_ade_using_jaxb.ade.sub.jaxb;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für RelativeToWaterType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
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
