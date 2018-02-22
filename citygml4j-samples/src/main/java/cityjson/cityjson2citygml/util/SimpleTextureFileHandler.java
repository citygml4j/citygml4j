/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright 2013-2017 Claus Nagel <claus.nagel@gmail.com>
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
package cityjson.cityjson2citygml.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;

import org.citygml4j.builder.cityjson.unmarshal.util.TextureFileHandler;

public class SimpleTextureFileHandler implements TextureFileHandler {
	private Path baseDir;
	private Path targetDir;
	private Path textureDir;

	public SimpleTextureFileHandler(Path baseDir, Path targetDir, Path textureDir) throws IOException {
		this.baseDir = baseDir;
		this.targetDir = targetDir;
		this.textureDir = textureDir;
		
		if (!Files.exists(targetDir))
			Files.createDirectories(targetDir);
	}

	@Override
	public String getImageURI(String imageFileName) {
		/** 
		 * This is a very simple implementation of the TextureFileHandler interface.
		 * We simply copy the incoming texture image to the target directory. 
		 * Copying the texture images could be done in multiple threads to
		 * speed up the process.
		 */
		
		try {
			Path source = baseDir.resolve(imageFileName);
			Path fileName = source.getFileName();
			if (fileName != null) {
				Path imagePath = textureDir.resolve(fileName);
				Path target = imagePath.isAbsolute() ? imagePath : targetDir.resolve(imagePath);
				if (!Files.exists(target.getParent()))
					Files.createDirectories(target.getParent());

				copy(source, target);
				String imageURI = imagePath.toString().replace('\\', '/');
				return imagePath.isAbsolute() ? "file://" + imageURI : imageURI;
			}
		} catch (IOException e) {
			//
		}

		// return null if we cannot handle the texture image
		return null;
	}

	private void copy(Path source, Path target) throws IOException {
		FileInputStream fromStream = new FileInputStream(source.toFile());
		FileChannel fromChannel = fromStream.getChannel();

		FileOutputStream toStream = new FileOutputStream(target.toFile());
		FileChannel toChannel = toStream.getChannel();

		fromChannel.transferTo(0, fromChannel.size(), toChannel);

		fromChannel.close();
		toChannel.close();

		fromStream.close();
		toStream.close();
	}

}
