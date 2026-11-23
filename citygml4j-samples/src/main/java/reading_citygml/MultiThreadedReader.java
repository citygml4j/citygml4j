/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package reading_citygml;

import helpers.Logger;
import helpers.Util;
import org.citygml4j.core.model.core.AbstractFeature;
import org.citygml4j.xml.CityGMLContext;
import org.citygml4j.xml.reader.ChunkOptions;
import org.citygml4j.xml.reader.CityGMLChunk;
import org.citygml4j.xml.reader.CityGMLInputFactory;
import org.citygml4j.xml.reader.CityGMLReader;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiThreadedReader {

    public static void main(String[] args) throws Exception {
        Logger log = Logger.start(MultiThreadedReader.class);

        CityGMLContext context = CityGMLContext.newInstance();

        CityGMLInputFactory in = context.createCityGMLInputFactory()
                .withChunking(ChunkOptions.defaults());

        Path file = Util.SAMPLE_DATA_DIR.resolve("lod3_railway_v3.gml");
        log.print("Reading city model members from the file " + file + " in a multi-threaded way");

        int threads = Runtime.getRuntime().availableProcessors();
        log.print("Starting thread pool with " + threads + " threads");
        List<Future<AbstractFeature>> features = new ArrayList<>();

        // closing the executor service waits until all submitted tasks have completed
        try (ExecutorService service = Executors.newFixedThreadPool(threads);
             CityGMLReader reader = in.createCityGMLReader(file)) {
            while (reader.hasNext()) {
                // reading chunks is sequential, but building objects from chunks
                // is the expensive part and can run in parallel
                CityGMLChunk chunk = reader.nextChunk();

                features.add(service.submit(() -> {
                    AbstractFeature feature = chunk.build();
                    log.print("[" + Thread.currentThread().getName() + "]" +
                            " Created " + feature.getClass().getSimpleName() + " object from chunk");
                    return feature;
                }));
            }
        }

        // get() rethrows any exception that occurred while building an object
        for (Future<AbstractFeature> feature : features) {
            feature.get();
        }

        log.print("Created " + features.size() + " objects");
        log.finish();
    }
}
