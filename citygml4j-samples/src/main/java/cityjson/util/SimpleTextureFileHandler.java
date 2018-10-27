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
package cityjson.util;

import org.citygml4j.builder.cityjson.util.TextureFileHandler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SimpleTextureFileHandler implements TextureFileHandler {
	private Path baseDir;
	private Path targetDir;

	public SimpleTextureFileHandler(Path baseDir, Path targetDir) throws IOException {
		this.baseDir = baseDir;
		this.targetDir = targetDir;
	}

	@Override
	public String getImageURI(String imageURI) {
		/*
		  This is a very simple implementation of the TextureFileHandler interface.
		  We simply copy the incoming texture image to the target directory. A real
		  implementation should consider the following:

		  Firstly, the same texture image might be reused several times in the input
		  file. So we should make sure not to copy the same image file multiple times.

		  Secondly, an imageURI may be any URI reference and not just a pointer into the
		  local file system. For instance, the imageURI might also reference an HTTP resource.
		  So we should parse the imageURI more carefully.

		  Finally, copying the texture images could be done in multiple threads to
		  speed up the process.
		 */

		if (imageURI != null) {
			try {
				imageURI = imageURI.replace('\\', '/');
				Path imagePath = Paths.get(imageURI);

				// simply return imageURI in case it is an absolute path
				if (imagePath.isAbsolute())
					return imageURI;

				Path source = baseDir.resolve(imagePath).normalize().toAbsolutePath();
				Path target = targetDir.resolve(imagePath).normalize().toAbsolutePath();

				if (!Files.exists(target.getParent()))
					Files.createDirectories(target.getParent());

				copy(source, target);
				return imagePath.toString().replace('\\', '/');
			} catch (Exception e) {
				// 
			}
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
