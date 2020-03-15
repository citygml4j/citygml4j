/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2020 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package reading_citygml.simple_reader;

import org.citygml4j.CityGMLContext;
import org.citygml4j.model.CityGMLObject;
import org.citygml4j.model.core.AbstractCityObjectProperty;
import org.citygml4j.model.core.CityModel;
import org.citygml4j.xml.module.citygml.CityGMLModules;
import org.citygml4j.xml.reader.CityGMLInputFactory;
import org.citygml4j.xml.reader.CityGMLReader;
import util.Util;

import java.io.File;

public class SimpleReader {

    public static void main(String[] args) throws Exception {
        Util.log("start");
        CityGMLContext context = CityGMLContext.newInstance();

        CityGMLInputFactory in = context.createCityGMLInputFactory();

        Util.log("read");
        try (CityGMLReader reader = in.createCityGMLReader(new File("datasets", "lod2_buildings_v3.gml"))) {
            CityGMLObject object = reader.next();

            CityGMLModules.getCityGMLModule(reader.getName().getNamespaceURI());

            if (object instanceof CityModel) {
                CityModel cityModel = (CityModel) object;

                for (AbstractCityObjectProperty cityObjectMember : cityModel.getCityObjectMembers()) {
                    System.out.println(cityObjectMember.getObject());
                }
            }
        }
        
        Util.log("finish");
    }
}
