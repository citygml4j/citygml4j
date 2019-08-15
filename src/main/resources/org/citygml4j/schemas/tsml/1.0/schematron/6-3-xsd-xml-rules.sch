<?xml version="1.0" encoding="UTF-8"?>
<schema xmlns="http://purl.oclc.org/dsdl/schematron" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" fpi="http://schemas.opengis.net/tsml/1.0/xsd-xml-rules.sch" see="http://www.opengis.net/spec/timeseriesml/1.0/req/xsd-xml-rules" queryBinding="xslt2">
  <!--
        This schematron schema checks the XML encoding requirements of OGC TimeseriesML 1.0, as specified
        in the requirements class: http://www.opengis.net/spec/timeseriesml/1.0/req/xsd-xml-rules
        
        OGC TimeseriesML 1.0 is an OGC Standard.
        Copyright (c) 2015 Open Geospatial Consortium.
        To obtain additional rights of use, visit http://www.opengeospatial.org/legal/ .
    
        version="1.0.0"
    -->
  <title>OGC TimeseriesML 1.0 XML Rules</title>
  <ns prefix="tsml" uri="http://www.opengis.net/tsml/1.0"/>
  <ns prefix="om" uri="http://www.opengis.net/om/2.0"/>
  <ns prefix="gml" uri="http://www.opengis.net/gml/3.2"/>
  <ns prefix="xlink" uri="http://www.w3.org/1999/xlink"/>
  <ns prefix="swe" uri="http://www.opengis.net/swe/2.0"/>
  <p>This schematron schema checks aspects of the XML encoding requirements of OGC TimeseriesML 1.0, as specified in the requirements class: http://www.opengis.net/spec/timeseriesml/1.0/req/xsd-xml-rules</p>
  <pattern id="time-zone">
    <title>Test recommendation: /req/xsd-xml-rules/time-zone</title>
    <rule context="tsml:time">
      <!--Test rule is defined by the regular expression: (Z|[+-]HH:MM)-->
      <assert test="matches(.,'.*Z|[+-]\d{2}:\d{2}$')">The value of each tsml:time element shall include a time zone definition
         using a signed 4 digit character or a ‘Z’ to represent Zulu or Greenwich Mean Time (GMT).
       </assert>
    </rule>
    <rule context="gml:beginPosition">
      <!--Test rule is defined by the regular expression: (Z|[+-]HH:MM)-->
      <assert test="matches(.,'.*Z|[+-]\d{2}:\d{2}$')">The value of each gml:beginPosition element shall include a time zone definition
         using a signed 4 digit character or a ‘Z’ to represent Zulu or Greenwich Mean Time (GMT).
       </assert>
    </rule>
    <rule context="gml:endPosition">
      <!--Test rule is defined by the regular expression: (Z|[+-]HH:MM)-->
      <assert test="matches(.,'.*Z|[+-]\d{2}:\d{2}$')">The value of each gml:endPosition element shall include a time zone definition
         using a signed 4 digit character or a ‘Z’ to represent Zulu or Greenwich Mean Time (GMT).
       </assert>
    </rule>
  </pattern>
  <pattern id="swe-types">
    <title>Test requirement: /req/xsd-xml-rules/swe-types</title>
    <rule context="swe:Category">
      <assert test="not(swe:quality) and not(swe:nilValues) and not(swe:constraint)">When using the SWE Common types, the following elements shall not be used: 
        swe:quality (AbstractSimpleComponentType), swe:nilValues (AbstractSimpleComponentType), swe:constraint.</assert>
    </rule>
    <rule context="swe:QuantityType">
      <assert test="not(swe:quality) and not(swe:nilValues) and not(swe:constraint)">When using the SWE Common types, the following elements shall not be used: 
        swe:quality (AbstractSimpleComponentType), swe:nilValues (AbstractSimpleComponentType), swe:constraint.
       </assert>
    </rule>
    <rule context="swe:Quantity">
      <assert test="not(swe:quality) and not(swe:nilValues) and not(swe:constraint)">When using the SWE Common types, the following elements shall not be used: 
        swe:quality (AbstractSimpleComponentType), swe:nilValues (AbstractSimpleComponentType), swe:constraint.
       </assert>
    </rule>
    <!-- Add check for non-existence of attributes optional and updatable -->
  </pattern>
  <!-- the logic for sch:report is opposite to assert; you report if the statement is true -->
  <pattern id="xlink-title">
    <title>Test recommendation: /req/xsd-xml-rules/xlink-title</title>
    <rule context="*[@xlink:href]">
      <report test="not(starts-with(@xlink:href, '#') ) and not(@xlink:title)">If an xlink:href is used to reference a controlled vocabulary item, the element should encode the
        xlink:title attribute with a text description of the referenced item.</report>
    </rule>
  </pattern>
  <pattern id="xlink-valid-local-reference">
    <title>Test recommendation: /req/xsd-xml-rules/xlink-valid-local-reference</title>
    <rule context="*[@xlink:href]">
      <!-- removed namespace just use local  namespace-uri()='http://www.opengis.net/gml/3.2' and   -->
      <report test="starts-with(@xlink:href, '#') and not(//@*[local-name()='id' ]=substring(@xlink:href, 2))">If an xlink:href is a local reference
        the reference element must exist. </report>
    </rule>
  </pattern>
  <!-- timeseries.sch  includes an xlink title for observed property and feature of interest -->
</schema>
