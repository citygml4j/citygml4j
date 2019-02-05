package cityjson.handling_extensions.using_gson;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import org.citygml4j.binding.cityjson.CityJSON;
import org.citygml4j.binding.cityjson.CityJSONRegistry;
import org.citygml4j.binding.cityjson.feature.AbstractBuildingType;
import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.feature.BuildingAttributes;
import org.citygml4j.binding.cityjson.feature.BuildingType;
import org.citygml4j.binding.cityjson.geometry.SemanticsType;
import org.citygml4j.binding.cityjson.geometry.SolidSemanticsObject;
import org.citygml4j.binding.cityjson.geometry.SolidType;
import org.citygml4j.binding.cityjson.metadata.MetadataType;
import org.citygml4j.builder.cityjson.marshal.util.DefaultVerticesBuilder;
import org.citygml4j.builder.cityjson.marshal.util.VerticesBuilder;
import org.citygml4j.model.citygml.core.AbstractCityObject;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class CreateExtensions {

    public static void main(String[] args) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] ");

        // creating a Gson instance. Note that we have to define the
        // date format as specified by CityJSON
        System.out.println(df.format(new Date()) + "setting up Gson builder");
        Gson gson = new Gson();

        // we are using a helper class for building the CityJSON "vertices" array.
        // this helper class makes sure that there are no duplicate vertices
        DefaultVerticesBuilder verticesBuilder = new DefaultVerticesBuilder();

        /*
         * step 1: the CityJSONRegistry is the place where to register CityJSON extensions
         * such as injection attributes, additional properties or completely new
         * city objects. All extensions are simply Java classes.
         */
        CityJSONRegistry registry = CityJSONRegistry.getInstance();

        // register an extension attribute for the predefined city object "Building"
        registry.registerExtensionProperty("+parcel", ParcelType.class, BuildingType.class);

        // register a new city object "+NoiseBuilding"
        registry.registerCityObject("+NoiseBuilding", NoiseBuildingType.class);

        /*
         * step 2: create an LOD2 building using the Gson binding classes for CityJSON
         */
        System.out.println(df.format(new Date()) + "creating CityJSON \"Building\" with extension attribute \"+parcel\"");
        BuildingType building = new BuildingType("ID_building");

        // add some attributes
        BuildingAttributes attributes = building.getAttributes();
        attributes.setCreationDate(LocalDate.now());
        attributes.setClazz("predefined CityJSON building");

        // inject additional extension attribute "+parcel"
        ParcelType parcel = new ParcelType();
        parcel.id = "ID_parcel";
        parcel.area = 10.123;
        attributes.addExtensionAttribute("+parcel", parcel);

        // assign geometry
        addGeometry(building, verticesBuilder);

        /*
         * step 3: create an LOD2 noise building using our own NoiseBuildingType Gson class
         */
        System.out.println(df.format(new Date()) + "creating \"+NoiseBuilding\" extension object");
        NoiseBuildingType noiseBuilding = new NoiseBuildingType("ID_noise_building");

        // add some attributes
        NoiseBuildingAttributes noiseAttributes = noiseBuilding.newAttributes();
        noiseAttributes.setCreationDate(LocalDate.now());
        noiseAttributes.setClazz("noise building");
        noiseAttributes.noiseLevel = 5;

        // add additional reflection property (added outside the "attributes" array)
        BuildingReflection reflection = new BuildingReflection();
        reflection.type = "smooth building facade";
        reflection.correction = 4.123;
        reflection.uom = "dB";
        noiseBuilding.reflection = reflection;

        // for simplicity, we reuse the same geometry again...
        addGeometry(noiseBuilding, verticesBuilder);

        // create the CityJSON root element and
        // add both buildings and the vertices
        CityJSON cityJSON = new CityJSON();
        cityJSON.addCityObject(building);
        cityJSON.addCityObject(noiseBuilding);
        cityJSON.setVertices(verticesBuilder.build());

        // add some metadata
        MetadataType metadata = new MetadataType();
        metadata.setGeographicalExtent(cityJSON.calcBoundingBox());
        metadata.setPresentLoDs(cityJSON.calcPresentLoDs());
        metadata.setDatasetTitle("LOD2 building created with citygml4j");
        cityJSON.setMetadata(metadata);

        /*
         * step 4: write the CityJSON object to a file
         */
        System.out.println(df.format(new Date()) + "writing Gson object tree as CityJSON file");
        Files.createDirectories(Paths.get("output"));

        try (JsonWriter writer = new JsonWriter(new FileWriter(new File("output/CityJSON_Extensions.json")))) {
            writer.setIndent(" ");
            gson.toJson(cityJSON, CityJSON.class, writer);
            System.out.println(df.format(new Date()) + "CityJSON file CityJSON_Extensions.json written");
        }

        /*
         * step 5: read the CityJSON file with extension back into memory
         */
        System.out.println(df.format(new Date()) + "reading Gson object tree from CityJSON_Extensions.json");
        try (JsonReader reader = new JsonReader(new FileReader(new File("output/CityJSON_Extensions.json")))) {
            CityJSON tmp = gson.fromJson(reader, CityJSON.class);

            for (AbstractCityObjectType cityObject : tmp.getCityObjects()) {
                System.out.println(df.format(new Date()) + "found city object of \"type\": " + cityObject.getType());

                if (cityObject.getType().equals("Building")) {
                    boolean hasParcel = ((BuildingType) cityObject).getAttributes().getExtensionAttributes().containsKey("+parcel");
                    System.out.println(df.format(new Date()) + "-- has \"+parcel\" extension attribute: " + hasParcel);
                }

                else if (cityObject.getType().equals("+NoiseBuilding")) {
                    boolean hasNoiseLevel = ((NoiseBuildingType) cityObject).getAttributes().noiseLevel != 0;
                    System.out.println(df.format(new Date()) + "-- has \"noise-level\" attribute: " + hasNoiseLevel);

                    boolean hasReflection = ((NoiseBuildingType) cityObject).reflection != null;
                    System.out.println(df.format(new Date()) + "-- has \"reflection\" property: " + hasReflection);
                }

            }
        }

        System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
    }


    private static class NoiseBuildingType extends BuildingType {
        BuildingReflection reflection;

        NoiseBuildingType(String gmlId) {
            super(gmlId);
        }

        @Override
        public NoiseBuildingAttributes newAttributes() {
            return super.newAttributes(new NoiseBuildingAttributes());
        }

        @Override
        public NoiseBuildingAttributes getAttributes() {
            return (NoiseBuildingAttributes) super.getAttributes();
        }
    }

    private static class BuildingReflection {
        String type;
        double correction;
        String uom;
    }

    private static class ParcelType {
        String id;
        double area;
    }

    private static class NoiseBuildingAttributes extends BuildingAttributes {
        @SerializedName("noise-level")
        int noiseLevel;
    }

    private static void addGeometry(AbstractBuildingType building, VerticesBuilder verticesBuilder) {
        // create vertices lists for the outer surfaces of the building
        List<Double> ground = Arrays.asList(0.0, 0.0, 0.0, 0.0, 12.0, 0.0, 6.0, 12.0, 0.0, 6.0, 0.0, 0.0);
        List<Double> wall_1 = Arrays.asList(6.0, 0.0, 0.0, 6.0, 12.0, 0.0, 6.0, 12.0, 6.0, 6.0, 0.0, 6.0);
        List<Double> wall_2 = Arrays.asList(0.0, 0.0, 0.0, 0.0, 0.0, 6.0, 0.0, 12.0, 6.0, 0.0, 12.0, 0.0);
        List<Double> wall_3 = Arrays.asList(0.0, 0.0, 0.0, 6.0, 0.0, 0.0, 6.0, 0.0, 6.0, 3.0, 0.0, 9.0, 0.0, 0.0, 6.0);
        List<Double> wall_4 = Arrays.asList(6.0, 12.0, 0.0, 0.0, 12.0, 0.0, 0.0, 12.0, 6.0, 3.0, 12.0, 9.0, 6.0, 12.0, 6.0);
        List<Double> roof_1 = Arrays.asList(6.0, 0.0, 6.0, 6.0, 12.0, 6.0, 3.0, 12.0, 9.0, 3.0, 0.0, 9.0);
        List<Double> roof_2 = Arrays.asList(0.0, 0.0, 6.0, 3.0, 0.0, 9.0, 3.0, 12.0, 9.0, 0.0, 12.0, 6.0);

        // now let's build a Gson solid geometry from the double lists
        SolidType solid = new SolidType();
        List<List<List<Integer>>> shell = new ArrayList<>();

        // in CityJSON, a surface is a list of list to model the exterior and interior rings
        // for this reason, we have to wrap the above double lists by a singleton list
        // moreover, we use a SimpleVerticesBuilder to avoid duplicate vertices
        shell.add(Collections.singletonList(verticesBuilder.addVertices(ground)));
        shell.add(Collections.singletonList(verticesBuilder.addVertices(wall_1)));
        shell.add(Collections.singletonList(verticesBuilder.addVertices(wall_2)));
        shell.add(Collections.singletonList(verticesBuilder.addVertices(wall_3)));
        shell.add(Collections.singletonList(verticesBuilder.addVertices(wall_4)));
        shell.add(Collections.singletonList(verticesBuilder.addVertices(roof_1)));
        shell.add(Collections.singletonList(verticesBuilder.addVertices(roof_2)));

        solid.addShell(shell);
        solid.setLod(2);

        // now let's add semantics
        // first define the list of thematic boundary surfaces
        SolidSemanticsObject semantics = new SolidSemanticsObject();
        semantics.addSurface(new SemanticsType("GroundSurface"));
        semantics.addSurface(new SemanticsType("WallSurface"));
        semantics.addSurface(new SemanticsType("WallSurface"));
        semantics.addSurface(new SemanticsType("WallSurface"));
        semantics.addSurface(new SemanticsType("WallSurface"));
        semantics.addSurface(new SemanticsType("RoofSurface"));
        semantics.addSurface(new SemanticsType("RoofSurface"));

        // next, we define an index list which points into the list
        // of boundary surfaces for each surface geometry
        List<Integer> values = Arrays.asList(0, 1, 2, 3, 4, 5, 6);

        // since a solid can have multiple shells with multiple surfaces
        // we again have to wrap the index list by a singleton list
        semantics.setValues(Collections.singletonList(values));

        solid.setSemantics(semantics);

        // add the geometry to the building
        building.addGeometry(solid);
    }
}
