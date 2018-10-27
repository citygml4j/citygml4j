/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
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
package reading_citygml.multithreaded_reader;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.CityGMLBuilder;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.reader.FeatureReadMode;
import org.citygml4j.xml.io.reader.MissingADESchemaException;
import org.citygml4j.xml.io.reader.UnmarshalException;
import org.citygml4j.xml.io.reader.XMLChunk;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultithreadedReader {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and CityGML builder");
		CityGMLContext ctx = CityGMLContext.getInstance();
		CityGMLBuilder builder = ctx.createCityGMLBuilder();
		
		// create a fixed thread pool
		int nThreads = Runtime.getRuntime().availableProcessors() * 2;
		System.out.println(df.format(new Date()) + "setting up thread pool with " + nThreads + " threads");
		ExecutorService service = Executors.newFixedThreadPool(nThreads);
		
		System.out.println(df.format(new Date()) + "reading LOD3_Railway_v200.gml in a multithreaded fashion");
		
		// create a validating reader that chunks the input file on a per feature level
		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		in.setProperty(CityGMLInputFactory.FEATURE_READ_MODE, FeatureReadMode.SPLIT_PER_FEATURE);
		in.setProperty(CityGMLInputFactory.USE_VALIDATION, true);
		
		CityGMLReader reader = in.createCityGMLReader(new File("datasets/LOD3_Railway_v200.gml"));
		
		while (reader.hasNext()) {
			// whereas the nextFeature() method of a CityGML reader completely unmarshals the 
			// XML chunk to an instance of the citygml4j object model and optionally validates
			// it before returning, the nextChunk() method returns faster but only provides a
			// set of SAX events.		
			final XMLChunk chunk = reader.nextChunk();
			
			// we forward every XML chunk to a separate thread of the thread pool
			// for unmarshalling and validation
			service.execute(() -> {
                try {
                    chunk.unmarshal();
                } catch (UnmarshalException | MissingADESchemaException e) {
                    //
                }

                // invoking the hasPassedXMLValidation() method prior to unmarshal()
                // or when using a non-validating CityGML reader will always yield false.
                boolean isValid = chunk.hasPassedXMLValidation();

                System.out.println("Thread '" + Thread.currentThread().getName() + "' unmarshalled " + chunk.getCityGMLClass() + "; valid: " + isValid);
            });
		}
		
		System.out.println(df.format(new Date()) + "shutting down threadpool");
		service.shutdown();
		service.awaitTermination(120, TimeUnit.SECONDS);
		
		reader.close();
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}
