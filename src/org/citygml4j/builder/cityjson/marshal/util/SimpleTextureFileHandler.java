package org.citygml4j.builder.cityjson.marshal.util;

import java.nio.file.Path;
import java.nio.file.Paths;

public class SimpleTextureFileHandler implements TextureFileHandler {

	@Override
	public String getImageFileName(String imageURI) {
		Path fileName = Paths.get(imageURI).getFileName();
		return fileName != null ? fileName.toString() : null;		
	}

}
