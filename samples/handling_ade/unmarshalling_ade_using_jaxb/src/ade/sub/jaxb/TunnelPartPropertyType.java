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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.citygml4j.jaxb.gml._3_1_1.AssociationType;


/**
 * Denotes the relation of an _AbstractTunnel to its parts. The gml:AssociationType attribute group for enabling the use of refs is not repeated in the
 * 				restriction and thus omitted. The building part has to be given inline, i.e. explicitely in this property. The reason for this inline definition is that no
 * 				BuildingPart is used by more than one building, thus the use or references to building parts defined elsewhere is prohibited. 
 * 
 * <p>Java class for TunnelPartPropertyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TunnelPartPropertyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.opengis.net/gml}AssociationType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.citygml.org/ade/sub/0.9.0}TunnelPart"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TunnelPartPropertyType")
public class TunnelPartPropertyType
    extends AssociationType
{


}
