<?xml version="1.0" encoding="UTF-8"?>
<schema fpi="http://schemas.opengis.net/tsml/1.0/xsd-timeseries-tvp.sch" see="http://www.opengis.net/spec/timeseriesml/1.0/req/xsd-collection"
  xmlns="http://purl.oclc.org/dsdl/schematron" queryBinding="xslt2" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">


  <!--
    This Schematron schema checks that the timeseries type adheres to the requirements class
    http://www.opengis.net/spec/timeseriesml/1.0/req/xsd-timeseries-tvp. This is the time-value
    pair representation of timeseries. 
    
    OGC TimeseriesML 1.0 is an OGC Standard.
    Copyright (c) 2015 Open Geospatial Consortium.
    To obtain additional rights of use, visit http://www.opengeospatial.org/legal/ .
    
    version="1.0.0"
  -->
  
  <title>OGC TimeseriesML 1.0 timeseries validation - collection</title>
  <p>Verifies that the Timeseries type follows the requirements specified by 
    http://www.opengis.net/spec/timeseriesml/1.0/req/xsd-collection</p>
  <ns prefix="tsml" uri="http://www.opengis.net/tsml/1.0"/>
  <ns prefix="om" uri="http://www.opengis.net/om/2.0"/>
  <ns prefix="gml" uri="http://www.opengis.net/gml/3.2"/>
  <ns prefix="xsi" uri="http://www.w3.org/2001/XMLSchema-instance"/>
  <ns prefix="xlink" uri="http://www.w3.org/1999/xlink"/>
  
  
  <pattern id="/req/xsd-collection/sampling-feature-single /req/xsd-collection/sampling-feature-group">
    <title>Tests /req/xsd-collection/sampling-feature-single /req/xsd-collection/sampling-feature-group</title>
    <rule context="tsml:Collection/tsml:samplingFeatureMember">
      <assert test="tsml:MonitoringFeature |SF_SpatialSamplingFeature|SF_SamplingFeatureCollection">
        Check that the sampling feature members are either SF_SpatialSamplingFeatures (including tsml:MonitoringFeature) or SF_SamplingFeatureCollection </assert>
    </rule>
    <!-- not that this schematron is not schema-aware so if other members of the substitution group are used then the schematron must be extended-->
  </pattern>
  
</schema>
