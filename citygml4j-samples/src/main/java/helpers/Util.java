/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package helpers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Util {
    public final static Path SAMPLE_DATA_DIR = Paths.get("input", "datasets");
    public final static Path STYLESHEETS_DIR = Paths.get("input", "stylesheets");
    public final static Path SCHEMAS_DIR = Paths.get("input", "schemas");
    public final static Path OUTPUT_DIR = Paths.get("output");

    public static Path getOutputFile(String fileName) throws IOException {
        Files.createDirectories(OUTPUT_DIR);
        return OUTPUT_DIR.resolve(fileName);
    }

    public static Path getGMLOutputFile() throws IOException {
        return getOutputFile("out.gml");
    }

    public static Path getJSONOutputFile() throws IOException {
        return getOutputFile("out.json");
    }

    public static Path getJSONLOutputFile() throws IOException {
        return getOutputFile("out.jsonl");
    }
}
