<?xml version="1.0" encoding="UTF-8"?>
<schema fpi="http://schemas.opengis.net/tsml/1.0/xsd-monitoring-feature-feature-of-interest.sch" see="http://www.opengis.net/spec/timeseriesml/1.0/req/xsd-monitoring-feature-feature-of-interest"
  xmlns="http://purl.oclc.org/dsdl/schematron" queryBinding="xslt2" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  
  <!-- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
       This document is under construction and has not yet been tested.
       !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
  
  <!--
        This Schematron schema checks that the type of the observation result is correct. 
        
        OGC TimeseriesML 1.0 is an OGC Standard.
        Copyright (c) 2015 Open Geospatial Consortium.
        To obtain additional rights of use, visit http://www.opengeospatial.org/legal/ .
    
        version="1.0.0" 
    -->

  <title>OGC TimeseriesML 1.0 observation validation</title>
  <p>Verifies that the om:featureOfInterest element contains a OGC TimeseriesML 1.0 monitoring point type.</p>
  <ns prefix="tsml" uri="http://www.opengis.net/tsml/1.0"/>
  <ns prefix="om" uri="http://www.opengis.net/om/2.0"/>
  <ns prefix="gml" uri="http://www.opengis.net/gml/3.2"/>
  <ns prefix="xlink" uri="http://www.w3.org/1999/xlink"/>


  <pattern id="featureOfInterest">
    <title>Test requirement: /req/xsd-monitoring-feature-feature-of-interest/featureOfInterest</title>
    <rule context="om:OM_Observation/om:featureOfInterest">
      <assert test="tsml:MonitoringFeature | @xlink:href">The xml element om:featureOfInterest shall contain a subelement of tsml:MonitoringFeature, a
        member of its substitution group or a reference to a representation of the monitoring point using xlink.</assert>
                <!-- note, this schematron is not schema-aware, therefore this assertion may need to be extended to check for known members of substitution groups in particular implementations, this can be done by extending the test attribute with "| yourclassname"-->

    </rule>
  </pattern>
</schema>
