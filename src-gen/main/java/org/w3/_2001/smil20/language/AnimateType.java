//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package org.w3._2001.smil20.language;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;
import org.w3._2001.smil20.AnimatePrototype;
import org.w3._2001.smil20.FillDefaultType;
import org.w3._2001.smil20.FillTimingAttrsType;
import org.w3._2001.smil20.RestartDefaultType;
import org.w3._2001.smil20.RestartTimingType;
import org.w3._2001.smil20.SyncBehaviorDefaultType;
import org.w3._2001.smil20.SyncBehaviorType;
import org.w3c.dom.Element;


/**
 * <p>Java-Klasse für animateType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="animateType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.w3.org/2001/SMIL20/}animatePrototype"&gt;
 *       &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *         &lt;any processContents='lax' namespace='##other'/&gt;
 *       &lt;/choice&gt;
 *       &lt;attGroup ref="{http://www.w3.org/2001/SMIL20/Language}TimingAttrs"/&gt;
 *       &lt;attGroup ref="{http://www.w3.org/2001/SMIL20/Language}CoreAttrs"/&gt;
 *       &lt;attGroup ref="{http://www.w3.org/2001/SMIL20/}skipContentAttrs"/&gt;
 *       &lt;attGroup ref="{http://www.w3.org/2001/SMIL20/}animTargetAttrs"/&gt;
 *       &lt;attGroup ref="{http://www.w3.org/2001/SMIL20/}animModeAttrs"/&gt;
 *       &lt;anyAttribute/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "animateType", propOrder = {
    "any"
})
public class AnimateType
    extends AnimatePrototype
{

    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlAttribute(name = "fillDefault")
    protected FillDefaultType fillDefault;
    @XmlAttribute(name = "fill")
    protected FillTimingAttrsType fill;
    @XmlAttribute(name = "restartDefault")
    protected RestartDefaultType restartDefault;
    @XmlAttribute(name = "syncBehaviorDefault")
    protected SyncBehaviorDefaultType syncBehaviorDefault;
    @XmlAttribute(name = "syncToleranceDefault")
    protected String syncToleranceDefault;
    @XmlAttribute(name = "restart")
    protected RestartTimingType restart;
    @XmlAttribute(name = "dur")
    protected String dur;
    @XmlAttribute(name = "min")
    protected String min;
    @XmlAttribute(name = "max")
    protected String max;
    @XmlAttribute(name = "begin")
    protected String begin;
    @XmlAttribute(name = "end")
    protected String end;
    @XmlAttribute(name = "repeatDur")
    protected String repeatDur;
    @XmlAttribute(name = "repeatCount")
    protected BigDecimal repeatCount;
    @XmlAttribute(name = "repeat")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger repeat;
    @XmlAttribute(name = "syncBehavior")
    protected SyncBehaviorType syncBehavior;
    @XmlAttribute(name = "syncTolerance")
    protected String syncTolerance;
    @XmlAttribute(name = "alt")
    protected String alt;
    @XmlAttribute(name = "longdesc")
    @XmlSchemaType(name = "anyURI")
    protected String longdesc;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "class")
    protected String clazz;
    @XmlAttribute(name = "lang", namespace = "http://www.w3.org/XML/1998/namespace")
    protected String lang;
    @XmlAttribute(name = "skip-content")
    protected Boolean skipContent;
    @XmlAttribute(name = "targetElement")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object targetElement;
    @XmlAttribute(name = "calcMode")
    protected String calcMode;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the any property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the any property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAny().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Element }
     * {@link Object }
     * 
     * 
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }

    public boolean isSetAny() {
        return ((this.any!= null)&&(!this.any.isEmpty()));
    }

    public void unsetAny() {
        this.any = null;
    }

    /**
     * Ruft den Wert der fillDefault-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FillDefaultType }
     *     
     */
    public FillDefaultType getFillDefault() {
        if (fillDefault == null) {
            return FillDefaultType.INHERIT;
        } else {
            return fillDefault;
        }
    }

    /**
     * Legt den Wert der fillDefault-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FillDefaultType }
     *     
     */
    public void setFillDefault(FillDefaultType value) {
        this.fillDefault = value;
    }

    public boolean isSetFillDefault() {
        return (this.fillDefault!= null);
    }

    /**
     * Ruft den Wert der fill-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FillTimingAttrsType }
     *     
     */
    public FillTimingAttrsType getFill() {
        if (fill == null) {
            return FillTimingAttrsType.DEFAULT;
        } else {
            return fill;
        }
    }

    /**
     * Legt den Wert der fill-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FillTimingAttrsType }
     *     
     */
    public void setFill(FillTimingAttrsType value) {
        this.fill = value;
    }

    public boolean isSetFill() {
        return (this.fill!= null);
    }

    /**
     * Ruft den Wert der restartDefault-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RestartDefaultType }
     *     
     */
    public RestartDefaultType getRestartDefault() {
        if (restartDefault == null) {
            return RestartDefaultType.INHERIT;
        } else {
            return restartDefault;
        }
    }

    /**
     * Legt den Wert der restartDefault-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RestartDefaultType }
     *     
     */
    public void setRestartDefault(RestartDefaultType value) {
        this.restartDefault = value;
    }

    public boolean isSetRestartDefault() {
        return (this.restartDefault!= null);
    }

    /**
     * Ruft den Wert der syncBehaviorDefault-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SyncBehaviorDefaultType }
     *     
     */
    public SyncBehaviorDefaultType getSyncBehaviorDefault() {
        if (syncBehaviorDefault == null) {
            return SyncBehaviorDefaultType.INHERIT;
        } else {
            return syncBehaviorDefault;
        }
    }

    /**
     * Legt den Wert der syncBehaviorDefault-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SyncBehaviorDefaultType }
     *     
     */
    public void setSyncBehaviorDefault(SyncBehaviorDefaultType value) {
        this.syncBehaviorDefault = value;
    }

    public boolean isSetSyncBehaviorDefault() {
        return (this.syncBehaviorDefault!= null);
    }

    /**
     * Ruft den Wert der syncToleranceDefault-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSyncToleranceDefault() {
        if (syncToleranceDefault == null) {
            return "inherit";
        } else {
            return syncToleranceDefault;
        }
    }

    /**
     * Legt den Wert der syncToleranceDefault-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSyncToleranceDefault(String value) {
        this.syncToleranceDefault = value;
    }

    public boolean isSetSyncToleranceDefault() {
        return (this.syncToleranceDefault!= null);
    }

    /**
     * Ruft den Wert der restart-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RestartTimingType }
     *     
     */
    public RestartTimingType getRestart() {
        if (restart == null) {
            return RestartTimingType.DEFAULT;
        } else {
            return restart;
        }
    }

    /**
     * Legt den Wert der restart-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RestartTimingType }
     *     
     */
    public void setRestart(RestartTimingType value) {
        this.restart = value;
    }

    public boolean isSetRestart() {
        return (this.restart!= null);
    }

    /**
     * Ruft den Wert der dur-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDur() {
        return dur;
    }

    /**
     * Legt den Wert der dur-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDur(String value) {
        this.dur = value;
    }

    public boolean isSetDur() {
        return (this.dur!= null);
    }

    /**
     * Ruft den Wert der min-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMin() {
        return min;
    }

    /**
     * Legt den Wert der min-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMin(String value) {
        this.min = value;
    }

    public boolean isSetMin() {
        return (this.min!= null);
    }

    /**
     * Ruft den Wert der max-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMax() {
        return max;
    }

    /**
     * Legt den Wert der max-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMax(String value) {
        this.max = value;
    }

    public boolean isSetMax() {
        return (this.max!= null);
    }

    /**
     * Ruft den Wert der begin-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBegin() {
        return begin;
    }

    /**
     * Legt den Wert der begin-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBegin(String value) {
        this.begin = value;
    }

    public boolean isSetBegin() {
        return (this.begin!= null);
    }

    /**
     * Ruft den Wert der end-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnd() {
        return end;
    }

    /**
     * Legt den Wert der end-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnd(String value) {
        this.end = value;
    }

    public boolean isSetEnd() {
        return (this.end!= null);
    }

    /**
     * Ruft den Wert der repeatDur-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRepeatDur() {
        return repeatDur;
    }

    /**
     * Legt den Wert der repeatDur-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRepeatDur(String value) {
        this.repeatDur = value;
    }

    public boolean isSetRepeatDur() {
        return (this.repeatDur!= null);
    }

    /**
     * Ruft den Wert der repeatCount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRepeatCount() {
        return repeatCount;
    }

    /**
     * Legt den Wert der repeatCount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRepeatCount(BigDecimal value) {
        this.repeatCount = value;
    }

    public boolean isSetRepeatCount() {
        return (this.repeatCount!= null);
    }

    /**
     * Ruft den Wert der repeat-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRepeat() {
        return repeat;
    }

    /**
     * Legt den Wert der repeat-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRepeat(BigInteger value) {
        this.repeat = value;
    }

    public boolean isSetRepeat() {
        return (this.repeat!= null);
    }

    /**
     * Ruft den Wert der syncBehavior-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SyncBehaviorType }
     *     
     */
    public SyncBehaviorType getSyncBehavior() {
        if (syncBehavior == null) {
            return SyncBehaviorType.DEFAULT;
        } else {
            return syncBehavior;
        }
    }

    /**
     * Legt den Wert der syncBehavior-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SyncBehaviorType }
     *     
     */
    public void setSyncBehavior(SyncBehaviorType value) {
        this.syncBehavior = value;
    }

    public boolean isSetSyncBehavior() {
        return (this.syncBehavior!= null);
    }

    /**
     * Ruft den Wert der syncTolerance-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSyncTolerance() {
        return syncTolerance;
    }

    /**
     * Legt den Wert der syncTolerance-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSyncTolerance(String value) {
        this.syncTolerance = value;
    }

    public boolean isSetSyncTolerance() {
        return (this.syncTolerance!= null);
    }

    /**
     * Ruft den Wert der alt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlt() {
        return alt;
    }

    /**
     * Legt den Wert der alt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlt(String value) {
        this.alt = value;
    }

    public boolean isSetAlt() {
        return (this.alt!= null);
    }

    /**
     * Ruft den Wert der longdesc-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLongdesc() {
        return longdesc;
    }

    /**
     * Legt den Wert der longdesc-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLongdesc(String value) {
        this.longdesc = value;
    }

    public boolean isSetLongdesc() {
        return (this.longdesc!= null);
    }

    /**
     * Ruft den Wert der id-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Legt den Wert der id-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    public boolean isSetId() {
        return (this.id!= null);
    }

    /**
     * Ruft den Wert der clazz-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClazz() {
        return clazz;
    }

    /**
     * Legt den Wert der clazz-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClazz(String value) {
        this.clazz = value;
    }

    public boolean isSetClazz() {
        return (this.clazz!= null);
    }

    /**
     * Ruft den Wert der lang-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLang() {
        return lang;
    }

    /**
     * Legt den Wert der lang-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLang(String value) {
        this.lang = value;
    }

    public boolean isSetLang() {
        return (this.lang!= null);
    }

    /**
     * Ruft den Wert der skipContent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isSkipContent() {
        if (skipContent == null) {
            return true;
        } else {
            return skipContent;
        }
    }

    /**
     * Legt den Wert der skipContent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSkipContent(boolean value) {
        this.skipContent = value;
    }

    public boolean isSetSkipContent() {
        return (this.skipContent!= null);
    }

    public void unsetSkipContent() {
        this.skipContent = null;
    }

    /**
     * Ruft den Wert der targetElement-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getTargetElement() {
        return targetElement;
    }

    /**
     * Legt den Wert der targetElement-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setTargetElement(Object value) {
        this.targetElement = value;
    }

    public boolean isSetTargetElement() {
        return (this.targetElement!= null);
    }

    /**
     * Ruft den Wert der calcMode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCalcMode() {
        if (calcMode == null) {
            return "linear";
        } else {
            return calcMode;
        }
    }

    /**
     * Legt den Wert der calcMode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCalcMode(String value) {
        this.calcMode = value;
    }

    public boolean isSetCalcMode() {
        return (this.calcMode!= null);
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     * 
     * <p>
     * the map is keyed by the name of the attribute and 
     * the value is the string value of the attribute.
     * 
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     * 
     * 
     * @return
     *     always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

    public void setAny(List<Object> value) {
        this.any = value;
    }

}
