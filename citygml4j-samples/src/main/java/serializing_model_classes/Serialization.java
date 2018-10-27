package serializing_model_classes;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.CityGMLBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.reader.CityGMLReadException;
import org.citygml4j.xml.io.reader.CityGMLReader;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EnumMap;

public class Serialization {

    public static void main(String[] args) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] ");

        System.out.println(df.format(new Date()) + "setting up citygml4j context and CityGML builder");
        CityGMLContext ctx = CityGMLContext.getInstance();
        CityGMLBuilder builder = ctx.createCityGMLBuilder();

        System.out.println(df.format(new Date()) + "reading CityGML file LOD3_Railway_v200.gml into main memory");
        CityGMLInputFactory in = builder.createCityGMLInputFactory();

        CityModel cityModel;
        try (CityGMLReader reader = in.createCityGMLReader(new File("datasets/LOD3_Railway_v200.gml"))) {
            cityModel = (CityModel) reader.nextFeature();
        }

        // serialize the object tree
        System.out.println(df.format(new Date()) + "serializing in-memory citygml4j object tree to file out.ser");
        Files.createDirectories(Paths.get("output"));

        // create an ObjectOutputStream to serialize the CityModel
        // make sure to use a BufferedOutputStream for performance reasons
        // to keep the file size small, consider using a GZIPOutputStream in addition
        try (ObjectOutputStream stream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("output/out.ser")))) {
            stream.writeObject(cityModel);
        }

        System.out.println(df.format(new Date()) + "citygml4j object tree successfully serialized");

        // let's read the serialized object tree back into main memory
        System.out.println(df.format(new Date()) + "deserializing out.ser back into main memory");

        // create an ObjectInputStream to deserialize the CityModel
        // again, make sure to use a BufferedInputStream for performance reasons
        try (ObjectInputStream stream = new ObjectInputStream(new BufferedInputStream(new FileInputStream("output/out.ser")))) {
            Object o = stream.readObject();

            if (o instanceof CityModel) {
                System.out.println(df.format(new Date()) + "successfully read citygml4j object tree from file out.ser");
                cityModel = (CityModel) o;

                System.out.println(df.format(new Date()) + "Found the following cityObjectMembers in out.ser:");
                EnumMap<CityGMLClass, Integer> features = new EnumMap<>(CityGMLClass.class);
                cityModel.getCityObjectMember().forEach(m -> features.merge(m.getCityObject().getCityGMLClass(), 1, Integer::sum));
                features.forEach((key, value) -> System.out.println(key + ": " + value));
            } else
                throw new CityGMLReadException("Failed to deserialize the file out.ser");
        }

        System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
    }

}
