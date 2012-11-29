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
 * $Id: AbstractTunnelType.java 542 2012-11-29 20:56:44Z nagel $
 */

package ade.sub.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import org.citygml4j.jaxb.citygml.core._1.AbstractSiteType;
import org.citygml4j.jaxb.gml._3_1_1.CodeType;
import org.citygml4j.jaxb.gml._3_1_1.MultiCurvePropertyType;
import org.citygml4j.jaxb.gml._3_1_1.MultiSurfacePropertyType;
import org.citygml4j.jaxb.gml._3_1_1.SolidPropertyType;


/**
 * <p>Java class for AbstractTunnelType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AbstractTunnelType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/citygml/1.0}AbstractSiteType">
 *       &lt;sequence>
 *         &lt;element name="class" type="{http://www.opengis.net/gml}CodeType" minOccurs="0"/>
 *         &lt;element name="function" type="{http://www.opengis.net/gml}CodeType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="usage" type="{http://www.opengis.net/gml}CodeType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="lod1Solid" type="{http://www.opengis.net/gml}SolidPropertyType" minOccurs="0"/>
 *         &lt;element name="lod1MultiSurface" type="{http://www.opengis.net/gml}MultiSurfacePropertyType" minOccurs="0"/>
 *         &lt;element name="lod1TerrainIntersection" type="{http://www.opengis.net/gml}MultiCurvePropertyType" minOccurs="0"/>
 *         &lt;element name="lod2Solid" type="{http://www.opengis.net/gml}SolidPropertyType" minOccurs="0"/>
 *         &lt;element name="lod2MultiSurface" type="{http://www.opengis.net/gml}MultiSurfacePropertyType" minOccurs="0"/>
 *         &lt;element name="lod2TerrainIntersection" type="{http://www.opengis.net/gml}MultiCurvePropertyType" minOccurs="0"/>
 *         &lt;element name="outerTunnelInstallation" type="{http://www.citygml.org/ade/sub/0.9.0}outerTunnelInstallationPropertyType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="boundedBy" type="{http://www.citygml.org/ade/sub/0.9.0}BoundarySurfacePropertyType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="lod3Solid" type="{http://www.opengis.net/gml}SolidPropertyType" minOccurs="0"/>
 *         &lt;element name="lod3MultiSurface" type="{http://www.opengis.net/gml}MultiSurfacePropertyType" minOccurs="0"/>
 *         &lt;element name="lod3TerrainIntersection" type="{http://www.opengis.net/gml}MultiCurvePropertyType" minOccurs="0"/>
 *         &lt;element name="lod4Solid" type="{http://www.opengis.net/gml}SolidPropertyType" minOccurs="0"/>
 *         &lt;element name="lod4MultiSurface" type="{http://www.opengis.net/gml}MultiSurfacePropertyType" minOccurs="0"/>
 *         &lt;element name="lod4TerrainIntersection" type="{http://www.opengis.net/gml}MultiCurvePropertyType" minOccurs="0"/>
 *         &lt;element name="interiorSpace" type="{http://www.citygml.org/ade/sub/0.9.0}InteriorRoomPropertyType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="consistsOfTunnelPart" type="{http://www.citygml.org/ade/sub/0.9.0}TunnelPartPropertyType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.citygml.org/ade/sub/0.9.0}_GenericApplicationPropertyOfAbstractTunnel" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractTunnelType", propOrder = {
    "clazz",
    "function",
    "usage",
    "lod1Solid",
    "lod1MultiSurface",
    "lod1TerrainIntersection",
    "lod2Solid",
    "lod2MultiSurface",
    "lod2TerrainIntersection",
    "outerTunnelInstallation",
    "boundedBySurface",
    "lod3Solid",
    "lod3MultiSurface",
    "lod3TerrainIntersection",
    "lod4Solid",
    "lod4MultiSurface",
    "lod4TerrainIntersection",
    "interiorSpace",
    "consistsOfTunnelPart",
    "genericApplicationPropertyOfAbstractTunnel"
})
@XmlSeeAlso({
    TunnelPartType.class,
    TunnelType.class
})
public class AbstractTunnelType
    extends AbstractSiteType
{

    @XmlElement(name = "class")
    protected CodeType clazz;
    protected List<CodeType> function;
    protected List<CodeType> usage;
    protected SolidPropertyType lod1Solid;
    protected MultiSurfacePropertyType lod1MultiSurface;
    protected MultiCurvePropertyType lod1TerrainIntersection;
    protected SolidPropertyType lod2Solid;
    protected MultiSurfacePropertyType lod2MultiSurface;
    protected MultiCurvePropertyType lod2TerrainIntersection;
    protected List<OuterTunnelInstallationPropertyType> outerTunnelInstallation;
    @XmlElement(name = "boundedBy")
    protected List<BoundarySurfacePropertyType> boundedBySurface;
    protected SolidPropertyType lod3Solid;
    protected MultiSurfacePropertyType lod3MultiSurface;
    protected MultiCurvePropertyType lod3TerrainIntersection;
    protected SolidPropertyType lod4Solid;
    protected MultiSurfacePropertyType lod4MultiSurface;
    protected MultiCurvePropertyType lod4TerrainIntersection;
    protected List<InteriorRoomPropertyType> interiorSpace;
    protected List<TunnelPartPropertyType> consistsOfTunnelPart;
    @XmlElement(name = "_GenericApplicationPropertyOfAbstractTunnel")
    protected List<Object> genericApplicationPropertyOfAbstractTunnel;

    /**
     * Gets the value of the clazz property.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getClazz() {
        return clazz;
    }

    /**
     * Sets the value of the clazz property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setClazz(CodeType value) {
        this.clazz = value;
    }

    public boolean isSetClazz() {
        return (this.clazz!= null);
    }

    /**
     * Gets the value of the function property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the function property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFunction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CodeType }
     * 
     * 
     */
    public List<CodeType> getFunction() {
        if (function == null) {
            function = new ArrayList<CodeType>();
        }
        return this.function;
    }

    public boolean isSetFunction() {
        return ((this.function!= null)&&(!this.function.isEmpty()));
    }

    public void unsetFunction() {
        this.function = null;
    }

    /**
     * Gets the value of the usage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the usage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUsage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CodeType }
     * 
     * 
     */
    public List<CodeType> getUsage() {
        if (usage == null) {
            usage = new ArrayList<CodeType>();
        }
        return this.usage;
    }

    public boolean isSetUsage() {
        return ((this.usage!= null)&&(!this.usage.isEmpty()));
    }

    public void unsetUsage() {
        this.usage = null;
    }

    /**
     * Gets the value of the lod1Solid property.
     * 
     * @return
     *     possible object is
     *     {@link SolidPropertyType }
     *     
     */
    public SolidPropertyType getLod1Solid() {
        return lod1Solid;
    }

    /**
     * Sets the value of the lod1Solid property.
     * 
     * @param value
     *     allowed object is
     *     {@link SolidPropertyType }
     *     
     */
    public void setLod1Solid(SolidPropertyType value) {
        this.lod1Solid = value;
    }

    public boolean isSetLod1Solid() {
        return (this.lod1Solid!= null);
    }

    /**
     * Gets the value of the lod1MultiSurface property.
     * 
     * @return
     *     possible object is
     *     {@link MultiSurfacePropertyType }
     *     
     */
    public MultiSurfacePropertyType getLod1MultiSurface() {
        return lod1MultiSurface;
    }

    /**
     * Sets the value of the lod1MultiSurface property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiSurfacePropertyType }
     *     
     */
    public void setLod1MultiSurface(MultiSurfacePropertyType value) {
        this.lod1MultiSurface = value;
    }

    public boolean isSetLod1MultiSurface() {
        return (this.lod1MultiSurface!= null);
    }

    /**
     * Gets the value of the lod1TerrainIntersection property.
     * 
     * @return
     *     possible object is
     *     {@link MultiCurvePropertyType }
     *     
     */
    public MultiCurvePropertyType getLod1TerrainIntersection() {
        return lod1TerrainIntersection;
    }

    /**
     * Sets the value of the lod1TerrainIntersection property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiCurvePropertyType }
     *     
     */
    public void setLod1TerrainIntersection(MultiCurvePropertyType value) {
        this.lod1TerrainIntersection = value;
    }

    public boolean isSetLod1TerrainIntersection() {
        return (this.lod1TerrainIntersection!= null);
    }

    /**
     * Gets the value of the lod2Solid property.
     * 
     * @return
     *     possible object is
     *     {@link SolidPropertyType }
     *     
     */
    public SolidPropertyType getLod2Solid() {
        return lod2Solid;
    }

    /**
     * Sets the value of the lod2Solid property.
     * 
     * @param value
     *     allowed object is
     *     {@link SolidPropertyType }
     *     
     */
    public void setLod2Solid(SolidPropertyType value) {
        this.lod2Solid = value;
    }

    public boolean isSetLod2Solid() {
        return (this.lod2Solid!= null);
    }

    /**
     * Gets the value of the lod2MultiSurface property.
     * 
     * @return
     *     possible object is
     *     {@link MultiSurfacePropertyType }
     *     
     */
    public MultiSurfacePropertyType getLod2MultiSurface() {
        return lod2MultiSurface;
    }

    /**
     * Sets the value of the lod2MultiSurface property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiSurfacePropertyType }
     *     
     */
    public void setLod2MultiSurface(MultiSurfacePropertyType value) {
        this.lod2MultiSurface = value;
    }

    public boolean isSetLod2MultiSurface() {
        return (this.lod2MultiSurface!= null);
    }

    /**
     * Gets the value of the lod2TerrainIntersection property.
     * 
     * @return
     *     possible object is
     *     {@link MultiCurvePropertyType }
     *     
     */
    public MultiCurvePropertyType getLod2TerrainIntersection() {
        return lod2TerrainIntersection;
    }

    /**
     * Sets the value of the lod2TerrainIntersection property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiCurvePropertyType }
     *     
     */
    public void setLod2TerrainIntersection(MultiCurvePropertyType value) {
        this.lod2TerrainIntersection = value;
    }

    public boolean isSetLod2TerrainIntersection() {
        return (this.lod2TerrainIntersection!= null);
    }

    /**
     * Gets the value of the outerTunnelInstallation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the outerTunnelInstallation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOuterTunnelInstallation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OuterTunnelInstallationPropertyType }
     * 
     * 
     */
    public List<OuterTunnelInstallationPropertyType> getOuterTunnelInstallation() {
        if (outerTunnelInstallation == null) {
            outerTunnelInstallation = new ArrayList<OuterTunnelInstallationPropertyType>();
        }
        return this.outerTunnelInstallation;
    }

    public boolean isSetOuterTunnelInstallation() {
        return ((this.outerTunnelInstallation!= null)&&(!this.outerTunnelInstallation.isEmpty()));
    }

    public void unsetOuterTunnelInstallation() {
        this.outerTunnelInstallation = null;
    }

    /**
     * Gets the value of the boundedBySurface property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the boundedBySurface property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBoundedBySurface().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BoundarySurfacePropertyType }
     * 
     * 
     */
    public List<BoundarySurfacePropertyType> getBoundedBySurface() {
        if (boundedBySurface == null) {
            boundedBySurface = new ArrayList<BoundarySurfacePropertyType>();
        }
        return this.boundedBySurface;
    }

    public boolean isSetBoundedBySurface() {
        return ((this.boundedBySurface!= null)&&(!this.boundedBySurface.isEmpty()));
    }

    public void unsetBoundedBySurface() {
        this.boundedBySurface = null;
    }

    /**
     * Gets the value of the lod3Solid property.
     * 
     * @return
     *     possible object is
     *     {@link SolidPropertyType }
     *     
     */
    public SolidPropertyType getLod3Solid() {
        return lod3Solid;
    }

    /**
     * Sets the value of the lod3Solid property.
     * 
     * @param value
     *     allowed object is
     *     {@link SolidPropertyType }
     *     
     */
    public void setLod3Solid(SolidPropertyType value) {
        this.lod3Solid = value;
    }

    public boolean isSetLod3Solid() {
        return (this.lod3Solid!= null);
    }

    /**
     * Gets the value of the lod3MultiSurface property.
     * 
     * @return
     *     possible object is
     *     {@link MultiSurfacePropertyType }
     *     
     */
    public MultiSurfacePropertyType getLod3MultiSurface() {
        return lod3MultiSurface;
    }

    /**
     * Sets the value of the lod3MultiSurface property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiSurfacePropertyType }
     *     
     */
    public void setLod3MultiSurface(MultiSurfacePropertyType value) {
        this.lod3MultiSurface = value;
    }

    public boolean isSetLod3MultiSurface() {
        return (this.lod3MultiSurface!= null);
    }

    /**
     * Gets the value of the lod3TerrainIntersection property.
     * 
     * @return
     *     possible object is
     *     {@link MultiCurvePropertyType }
     *     
     */
    public MultiCurvePropertyType getLod3TerrainIntersection() {
        return lod3TerrainIntersection;
    }

    /**
     * Sets the value of the lod3TerrainIntersection property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiCurvePropertyType }
     *     
     */
    public void setLod3TerrainIntersection(MultiCurvePropertyType value) {
        this.lod3TerrainIntersection = value;
    }

    public boolean isSetLod3TerrainIntersection() {
        return (this.lod3TerrainIntersection!= null);
    }

    /**
     * Gets the value of the lod4Solid property.
     * 
     * @return
     *     possible object is
     *     {@link SolidPropertyType }
     *     
     */
    public SolidPropertyType getLod4Solid() {
        return lod4Solid;
    }

    /**
     * Sets the value of the lod4Solid property.
     * 
     * @param value
     *     allowed object is
     *     {@link SolidPropertyType }
     *     
     */
    public void setLod4Solid(SolidPropertyType value) {
        this.lod4Solid = value;
    }

    public boolean isSetLod4Solid() {
        return (this.lod4Solid!= null);
    }

    /**
     * Gets the value of the lod4MultiSurface property.
     * 
     * @return
     *     possible object is
     *     {@link MultiSurfacePropertyType }
     *     
     */
    public MultiSurfacePropertyType getLod4MultiSurface() {
        return lod4MultiSurface;
    }

    /**
     * Sets the value of the lod4MultiSurface property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiSurfacePropertyType }
     *     
     */
    public void setLod4MultiSurface(MultiSurfacePropertyType value) {
        this.lod4MultiSurface = value;
    }

    public boolean isSetLod4MultiSurface() {
        return (this.lod4MultiSurface!= null);
    }

    /**
     * Gets the value of the lod4TerrainIntersection property.
     * 
     * @return
     *     possible object is
     *     {@link MultiCurvePropertyType }
     *     
     */
    public MultiCurvePropertyType getLod4TerrainIntersection() {
        return lod4TerrainIntersection;
    }

    /**
     * Sets the value of the lod4TerrainIntersection property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiCurvePropertyType }
     *     
     */
    public void setLod4TerrainIntersection(MultiCurvePropertyType value) {
        this.lod4TerrainIntersection = value;
    }

    public boolean isSetLod4TerrainIntersection() {
        return (this.lod4TerrainIntersection!= null);
    }

    /**
     * Gets the value of the interiorSpace property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the interiorSpace property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInteriorSpace().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InteriorRoomPropertyType }
     * 
     * 
     */
    public List<InteriorRoomPropertyType> getInteriorSpace() {
        if (interiorSpace == null) {
            interiorSpace = new ArrayList<InteriorRoomPropertyType>();
        }
        return this.interiorSpace;
    }

    public boolean isSetInteriorSpace() {
        return ((this.interiorSpace!= null)&&(!this.interiorSpace.isEmpty()));
    }

    public void unsetInteriorSpace() {
        this.interiorSpace = null;
    }

    /**
     * Gets the value of the consistsOfTunnelPart property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the consistsOfTunnelPart property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConsistsOfTunnelPart().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TunnelPartPropertyType }
     * 
     * 
     */
    public List<TunnelPartPropertyType> getConsistsOfTunnelPart() {
        if (consistsOfTunnelPart == null) {
            consistsOfTunnelPart = new ArrayList<TunnelPartPropertyType>();
        }
        return this.consistsOfTunnelPart;
    }

    public boolean isSetConsistsOfTunnelPart() {
        return ((this.consistsOfTunnelPart!= null)&&(!this.consistsOfTunnelPart.isEmpty()));
    }

    public void unsetConsistsOfTunnelPart() {
        this.consistsOfTunnelPart = null;
    }

    /**
     * Gets the value of the genericApplicationPropertyOfAbstractTunnel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfAbstractTunnel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfAbstractTunnel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> get_GenericApplicationPropertyOfAbstractTunnel() {
        if (genericApplicationPropertyOfAbstractTunnel == null) {
            genericApplicationPropertyOfAbstractTunnel = new ArrayList<Object>();
        }
        return this.genericApplicationPropertyOfAbstractTunnel;
    }

    public boolean isSet_GenericApplicationPropertyOfAbstractTunnel() {
        return ((this.genericApplicationPropertyOfAbstractTunnel!= null)&&(!this.genericApplicationPropertyOfAbstractTunnel.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfAbstractTunnel() {
        this.genericApplicationPropertyOfAbstractTunnel = null;
    }

}
