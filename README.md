citygml4j
=========

citygml4j is an open source Java class library and API for facilitating work with the [OGC City Geography Markup Language (CityGML)](http://www.opengeospatial.org/standards/citygml). citygml4j makes it easy to read, process and write CityGML datasets, and to develop CityGML-aware software applications.

Starting from version 2.6.0, citygml4j supports parsing and writing [CityJSON](http://www.cityjson.org/), a format for encoding a subset of the CityGML data model using JSON instead of GML. 

License
-------
citygml4j is licensed under the [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0). See the `LICENSE` file for more details.

Note that releases of the software before version 2.3.0 continue to be licensed under GNU LGPL 3.0. To request a previous release of citygml4j under Apache License 2.0 create a GitHub issue.

Latest release
--------------
The latest stable release of citygml4j is 2.8.1.

Download the citygml4j 2.8.1 release binaries [here](https://github.com/citygml4j/citygml4j/releases/download/v2.8.1/citygml4j-2.8.1.zip). Previous releases are available from the [releases section](https://github.com/citygml4j/citygml4j/releases).

Contributing
------------
* To file bugs found in the software create a GitHub issue.
* To contribute code for fixing filed issues create a pull request with the issue id.
* To propose a new feature create a GitHub issue and open a discussion.

Building
--------
citygml4j requires Java 8 or higher. The project uses [Gradle](https://gradle.org/) as build system. To build the library from source, run the following command from the root of the repository. 

    > gradlew installDist

This will create a folder `build/install/citygml4j` with the following subfolders:
* `javadoc` -- the Javadoc documentation
* `lib` -- the citygml4j library and its mandatory dependencies
* `license` -- license information
* `samples` -- a collection of citygml4j sample programs

Simply put the `citygml4j-<version>.jar` library file and its mandatory dependencies from the `lib` folder on your classpath to start developing with citygml4j. Have fun :-)

Maven artifact
--------------
citygml4j is also available as [Maven](http://maven.apache.org/) artifact from the [Maven Central Repository](http://search.maven.org/#search%7Cga%7C1%7Ca%3A%22citygml4j%22) and from [JCenter](https://bintray.com/bintray/jcenter). To add citygml4j  to your project with Maven, add the following code to your `pom.xml`. You may need to adapt the citygml4j version number.

```xml
<dependency>
  <groupId>org.citygml4j</groupId>
  <artifactId>citygml4j</artifactId>
  <version>2.8.1</version>
</dependency>
```

Here is how you use citygml4j with your Gradle project:

```gradle
repositories {
  mavenCentral()
}

dependencies {
  compile 'org.citygml4j:citygml4j:2.8.1'
}
```

Sample programs
---------------
citygml4j provides a number of sample programs that demonstrate the use of the library. Download the library or build it from source with [Gradle](https://gradle.org/) as described above. This will deploy the sample programs in the `build/install/citygml4j/samples` folder.

The sample programs are organized into subfolders, each addressing a different use case of citygml4j. Gradle tasks are provided to easily compile and run the sample programs.

To run a sample program, simply open a shell environment, change to the `samples` folder and invoke the Gradle wrapper using the fully qualified name of the Java class as task name. The package name follows the folder structure. For example, issue the following command to run the `SimpleReader.java` program from the subfolder `reading_citygml/simple_citygml_reader`: 

    > gradlew reading_citygml.simple_citygml_reader.SimpleReader

Alternatively, you can load the citygml4j source into your preferred IDE and run the sample programs from there. Please note that the sample programs use relative paths to access the test datasets in the folder `samples/datasets` and to write their output to `samples/output`. You might have to adapt the working directory in the run configuration of your IDE so that the relative paths are correctly resolved. For [Eclipse](https://www.eclipse.org/), everything should work just fine without having to change any settings. When using [IntelliJ](https://www.jetbrains.com/idea/), simply use `$MODULE_DIR$` as working directory.

More information
----------------
[OGC CityGML](http://www.opengeospatial.org/standards/citygml) is an open data model and XML-based format for the storage and exchange of semantic 3D city models. It is an application schema for the [Geography Markup Language version 3.1.1 (GML3)](http://www.opengeospatial.org/standards/gml), the extendible international standard for spatial data exchange issued by the Open Geospatial Consortium (OGC) and the ISO TC211. The aim of the development of CityGML is to reach a common definition of the basic entities, attributes, and relations of a 3D city model.

CityGML is an international OGC standard and can be used free of charge.

The [CityJSON specification](https://github.com/tudelft3d/cityjson) is developed and maintained on GitHub by the [3D geoinformation group at TU Delft](https://3d.bk.tudelft.nl/). 
