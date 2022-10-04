![build](https://img.shields.io/github/workflow/status/citygml4j/citygml4j/Build%20citygml4j?logo=Gradle)
![release](https://img.shields.io/github/v/release/citygml4j/citygml4j?display_name=tag)
[![maven](https://maven-badges.herokuapp.com/maven-central/org.citygml4j/citygml4j-core/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.citygml4j/citygml4j-core)
[![license](https://img.shields.io/badge/license-Apache_2.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

# citygml4j - The Open Source Java API for CityGML
citygml4j is an open source Java library and API for [OGC CityGML](http://www.opengeospatial.org/standards/citygml).
citygml4j makes it easy to parse, process, and write CityGML datasets and to develop CityGML-aware software.

The library consists of a `citygml4j-core` module that provides Java classes for processing CityGML data based on
the [CityGML 3.0 Conceptual Model](https://docs.ogc.org/is/20-010/20-010.html), helper classes
for working with the model classes, and an extension API for implementing support for
[CityGML ADEs](https://docs.ogc.org/is/20-010/20-010.html#toc66).

Serialization modules on top of the core add support for parsing datasets with different file formats and encodings
into the model classes and writing them back out again.
- [`citygml4j-xml`](citygml4j-xml) provides the default GML/XML encoding and supports
  CityGML 3.0, 2.0, and 1.0.
- [`citygml4j-cityjson`](citygml4j-cityjson) adds [CityJSON](https://www.cityjson.org/) as encoding with
  support for CityJSON 1.1 and 1.0.

## License
citygml4j is licensed under the [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0).
See the `LICENSE` file for more details.

## Latest release
The latest release of citygml4j is 3.0.0-rc.5.

Download the latest citygml4j release binaries [here](https://github.com/citygml4j/citygml4j/releases/latest).
Previous releases are available from the [releases section](https://github.com/citygml4j/citygml4j/releases).

## Contributing
* To file bugs found in the software create a GitHub issue.
* To contribute code for fixing filed issues create a pull request with the issue id.
* To propose a new feature create a GitHub issue and open a discussion.

## Building
citygml4j requires Java 11 or higher. The project uses [Gradle](https://gradle.org/) as build system. To build the
library from source, clone the repository to your local machine and run the following command from the root of the
repository.

    > gradlew installDist

The script automatically downloads all required dependencies for building the modules. So make sure you are connected
to the internet.

The build process creates the output files in the folder `build/install/citygml4j` with the following subfolders:
* `javadoc` -- the Javadoc documentation
* `lib` -- the citygml4j module files and mandatory dependencies
* `license` -- license information
* `samples` -- a collection of citygml4j sample programs

Simply put the citygml4j module files and the mandatory dependencies from the `lib` folder on your
modulepath to start developing with citygml4j. Have fun :-)

## Maven artifacts
The citygml4j modules are also available as individual Maven artifacts from the
[Maven Central Repository](https://search.maven.org/search?q=g:org.citygml4j). Each serialization module has a
dependency on the `citygml-core` module, but you can also use the core module alone.

For example, to add `citygml4j-xml` to your project with Maven, add the following code to your `pom.xml`. You may
have to adapt the citygml4j version number.

```xml
<dependency>
  <groupId>org.citygml4j</groupId>
  <artifactId>citygml4j-xml</artifactId>
  <version>3.0.0-rc.5</version>
</dependency>
```

Here is how you use both `citygml4j-xml` and `citygml4j-cityjson` with your Gradle project. Make sure to use the
same citygml4j version for both modules to avoid conflicts.

```gradle
repositories {
  mavenCentral()
}

dependencies {
  implementation 'org.citygml4j:citygml4j-xml:3.0.0-rc.5'
  implementation 'org.citygml4j:citygml4j-cityjson:3.0.0-rc.5'
}
```

## Sample programs
citygml4j provides a number of sample programs to demonstrate the use of the library. Download and unzip a release
or build the library from source as described above. Afterwards, the sample programs are located in the `samples`
folder.

The source code of the sample programs is provided as Gradle project and organized into Java packages under
`src/main/java` in the `samples` folder. Each package addresses a different use case of citygml4j. Predefined Gradle 
tasks let you easily compile and run the sample programs.

To run a sample program, simply open a shell environment, change to the `samples` folder and invoke the Gradle wrapper
using the fully qualified name of the Java class as task name. For example, issue the following command to run the
`SimpleReader` program from the `reading_citygml` package:

    > gradlew reading_citygml.SimpleReader

Alternatively, you can load the citygml4j source into your preferred IDE and run the sample programs from there.
The source code of the sample programs is provided as separate `citygml4j-samples` module. The easiest way to execute
the programs is again to use the predefined Gradle tasks. If you prefer to directly run the classes instead,
note that the classes use relative paths to access test datasets and write output files. You might have to
adapt the working directory in the run configuration of your IDE so that the relative paths are resolved correctly.
For example, when using [IntelliJ](https://www.jetbrains.com/idea/), simply use `$MODULE_DIR$` as working directory.

## More information
[OGC CityGML](http://www.opengeospatial.org/standards/citygml) defines a common semantic information model for the
representation of virtual 3D city models. The information model can be implemented in a variety of technologies such
as GML/XML, JSON or as database schema to enable the storage, management, and exchange of 3D city models and to
facilitate the integration of urban geodata for a variety of applications for Smart Cities and Digital Urban Twins.

CityGML is an International Standard issued by the [Open Geospatial Consortium (OGC)](https://www.ogc.org/) and can be
used free of charge. The development of CityGML is open to everyone and takes place on the
[OGC GitHub repository](https://github.com/opengeospatial).
