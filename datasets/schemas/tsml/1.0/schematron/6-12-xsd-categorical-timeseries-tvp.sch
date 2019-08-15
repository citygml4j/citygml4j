<?xml version="1.0" encoding="UTF-8"?>
<schema fpi="http://schemas.opengis.net/tsml/1.0/xsd-categorical-timeseries-tvp.sch" see="http://www.opengis.net/spec/timeseriesml/1.0/req/xsd-categorical-timeseries-tvp" xmlns="http://purl.oclc.org/dsdl/schematron" queryBinding="xslt2" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <!--
        This Schematron schema checks the type of the value of the time series is a category 
        
        OGC TimeseriesML 1.0 is an OGC Standard.
        Copyright (c) 2015 Open Geospatial Consortium.
        To obtain additional rights of use, visit http://www.opengeospatial.org/legal/ .   
        version="1.0.0"
    -->
  <title>OGC TimeseriesML 1.0 category time series validation</title>
  <p>Verifies the value type of the time series is a category (string with a codespace). This is a test of 
    the requirement: http://www.opengis.net/spec/timeseriesml/1.0/req/xsd-categorical-timeseries-tvp/value</p>
  <ns prefix="tsml" uri="http://www.opengis.net/tsml/1.0"/>
  <ns prefix="om" uri="http://www.opengis.net/om/2.0"/>
  <ns prefix="gml" uri="http://www.opengis.net/gml/3.2"/>
  <ns prefix="xsi" uri="http://www.w3.org/2001/XMLSchema-instance"/>
  <ns prefix="xlink" uri="http://www.w3.org/1999/xlink"/>
  <ns prefix="swe" uri="http://www.opengis.net/swe/2.0"/>
  <pattern id="point-type">
    <title>Test requirement: /req/xsd-categorical-timeseries-tvp/value-category</title>
    <rule context="tsml:TimeseriesTVP/tsml:point/tsml:CategoricalTVP/tsml:value"> 
      <assert test="swe:Category or @xsi:nil">The time series points must be of type Category (except where an xsi:nil attribute is provided).</assert>    
    </rule>
  </pattern>
</schema>
