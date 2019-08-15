<?xml version="1.0" encoding="UTF-8"?>
<schema xmlns="http://purl.oclc.org/dsdl/schematron" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" fpi="http://schemas.opengis.net/tsml/1.0/xsd-timeseries-domain-range-observation.sch" see="http://www.opengis.net/spec/timeseriesml/1.0/req/xsd-timeseries-domain-range-observation" queryBinding="xslt2">
  <!--
        This Schematron schema checks that the type of the observation result is correct. 
        
        OGC TimeseriesML 1.0 is an OGC Standard.
        Copyright (c) 2015 Open Geospatial Consortium.
        To obtain additional rights of use, visit http://www.opengeospatial.org/legal/ .
        
        version="1.0.0"
    -->
  <title>OGC TimeseriesML 1.0  domain range timeseries observation</title>
  <p>Verifies that the OM_Observation result type is valid according to the TimeseriesML 1.0 domain range timeseries  observation. Tests requirements from http://www.opengis.net/spec/timeseriesml/1.0/req/xsd-timeseries-domain-range-observation</p>
  <ns prefix="tsml" uri="http://www.opengis.net/tsml/1.0"/>
  <ns prefix="om" uri="http://www.opengis.net/om/2.0"/>
  <ns prefix="gml" uri="http://www.opengis.net/gml/3.2"/>
  <ns prefix="xlink" uri="http://www.w3.org/1999/xlink"/>
  <pattern id="result">
    <title>Test requirement: /req/xsd-timeseries-domain-range-observation/result </title>
    <rule context="om:result">
	<!-- this is non-schema aware and only finds an exact match, derived types will need new assert statements -->
    <assert test="tsml:TimeseriesDomainRange">result must contain an element in the substitution group headed by tsml:TimeseriesDomainRange</assert>
   	</rule>
  </pattern>
  
</schema>
