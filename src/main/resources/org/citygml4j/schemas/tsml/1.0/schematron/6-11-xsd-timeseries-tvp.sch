<?xml version="1.0" encoding="UTF-8"?>
<schema fpi="http://schemas.opengis.net/tsml/1.0/xsd-timeseries-tvp.sch" see="http://www.opengis.net/spec/timeseriesml/1.0/req/xsd-timeseries-tvp" xmlns="http://purl.oclc.org/dsdl/schematron" queryBinding="xslt2" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<!-- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
       This document is under construction and has not yet been tested.
       !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
	<!--
    This Schematron schema checks that the timeseries type adheres to the requirements class
    http://www.opengis.net/spec/timeseriesml/1.0/req/xsd-timeseries-tvp. This is the time-value
    pair representation of timeseries. 
    
    OGC TimeseriesML 1.0 is an OGC Standard.
    Copyright (c) 2015 Open Geospatial Consortium.
    To obtain additional rights of use, visit http://www.opengeospatial.org/legal/ .
    
    version="1.0.0"
  -->
	<title>OGC TimeseriesML 1.0 timeseries Time Value Pair validation</title>
	<p>Verifies that the Timeseries type follows the requirements specified by 
    http://www.opengis.net/spec/timeseriesml/1.0/req/xsd-timeseries-tvp</p>
	<ns prefix="tsml" uri="http://www.opengis.net/tsml/1.0"/>
	<ns prefix="om" uri="http://www.opengis.net/om/2.0"/>
	<ns prefix="gml" uri="http://www.opengis.net/gml/3.2"/>
	<ns prefix="xsi" uri="http://www.w3.org/2001/XMLSchema-instance"/>
	<ns prefix="xlink" uri="http://www.w3.org/1999/xlink"/>
	<pattern id="equidistant-encoding">
		<title>Tests /req/xsd-timeseries-tvp/equidistant-encoding and /req/xsd-timeseries-tvp/time-mandatory</title>
		<rule context="tsml:TimeseriesMetadata">
			<assert test="(tsml:spacing and tsml:baseTime) or (not(tsml:spacing) and not(tsml:baseTime))">
        Both spacing and baseTime need to be specifed if equidistant series, otherwise neither should be used. </assert>
		</rule>
		<!-- Checks that time is present if equidistant points are not being used. If baseTime and spacing are 
      used then time should not be present (might want to make this a warning - should it be possible to specify a time 
      to override the equidistant calculation? -->
		<rule context="tsml:MeasurementTVP | tsml:CategoricalTVP">
			<assert test="(tsml:time and not(../../tsml:metadata/tsml:TimeseriesMetadata/tsml:spacing) or (not(tsml:time) and (../../tsml:metadata/tsml:TimeseriesMetadata/tsml:spacing)))">
        The time for each point in the series must be specified if equidistant spacing isn't being used (i.e. you must
        specify the baseTime and spacing elements). If baseTime and spacing are specified then time is not required. 
      </assert>
		</rule>
	</pattern>
	<!-- All null values must provide a nilReason or a censoredReason -->
	<pattern id="null-point-reason">
		<title>Tests /req/xsd-timeseries-tvp/null-point-reason</title>
		<rule context="tsml:MeasurementTVP/tsml:value[@xsi:nil]">
			<assert test="../tsml:metadata/tsml:PointMetadata/tsml:nilReason or ../tsml:metadata/tsml:PointMetadata/tsml:censoredReason">
        All null points must provide a nilReason or a censoredReason.</assert>
		</rule>
	</pattern>
</schema>
