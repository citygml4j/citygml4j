!citygml4j.name! - !citygml4j.description!

  This library is free software and is distributed in the hope
  that it will be useful, but WITHOUT ANY WARRANTY; without even
  the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
  PURPOSE. See the LICENSE.txt file for more details.
  

0. Index
--------

1. License
2. Copyright
3. About
4. System requirements
5. How to use it
6. Developers
7. Contact
8. Websites


1. License
----------

The !citygml4j.name! library is free software under the 
GNU Lesser General Public License Version 3.0. See the LICENSE.txt file for more 
details. For a copy of the GNU Lesser General Public License see the files
COPYING.txt and COPYING.LESSER.txt or visit http://www.gnu.org/licenses/.


2. Copyright
------------

(C) !copyright.year!,
!copyright.owner! <!copyright.owner.email!>


3. About
--------

!citygml4j.name! is a Java class library and API for facilitating work with the
City Geography Markup Language (CityGML). It makes it easy to read, process, and
write CityGML datasets, and to develop CityGML-aware software applications.

Feature list:
* Full support for CityGML version 2.0.0 and 1.0.0
  (read-only support for CityGML 0.4.0)
* Support for CityGML specific subset of GML 3.1.1
* Support for the eXtensible Address Language (xAL)
* Support for user-defined CityGML Application Domain Extensions (ADE)

CityGML is an open data model and XML-based format for the storage and exchange
of semantic 3D city models. It is an application schema for the Geography Markup
Language version 3.1.1 (GML3), the extendible international standard for spatial
data exchange issued by the Open Geospatial Consortium (OGC) and the ISO TC211.
The aim of the development of CityGML is to reach a common definition of the
basic entities, attributes, and relations of a 3D city model.

CityGML is an international OGC standard and can be used free of charge.


4. System requirements
----------------------

* Java JRE or JDK >= 1.7


5. How to use it
----------------

Simply modify your Java classpath to include the provided 
Java library files in the subfolder "lib". This folder contains the
!citygml4j.name! library file as well as all its mandatory dependencies.

!citygml4j.name! is also available as Maven artifact: 

  <dependency>
    <groupId>org.!citygml4j.name!</groupId>
    <artifactId>!citygml4j.name!</artifactId>
    <version>!citygml4j.version!</version>
  </dependency>

A collection of sample programs demonstrating the use of !citygml4j.name!
is provided in the subfolder "samples". Each subfolder contains an Ant
build.xml script to easily run the programs. Note that the build.xml file
may contain more than one target.

   
6. Developers
-------------

!developer.main.name! <!developer.main.email!>


7. Contact
----------

!developer.main.email!


8. Websites
-----------

Official !citygml4j.name! websites: 
!citygml4j.homepage!
!citygml4j.git!

Related websites:
http://www.citygml.org/
http://www.citygmlwiki.org/
http://www.opengeospatial.org/standards/citygml