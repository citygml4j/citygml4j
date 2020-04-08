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

package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Util {
    public final static Path SAMPLE_DATA_DIR = Paths.get("input", "datasets");
    public final static Path STYLESHEETS_DIR = Paths.get("input", "stylesheets");
    public final static Path OUTPUT_FILE = Paths.get("output", "out.gml");

    public static Path getOutputFile() throws IOException {
        Files.createDirectories(OUTPUT_FILE.getParent());
        return OUTPUT_FILE;
    }
}
