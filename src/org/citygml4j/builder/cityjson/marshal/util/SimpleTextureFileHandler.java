package org.citygml4j.builder.cityjson.marshal.util;

import java.nio.file.Path;

public class SimpleTextureFileHandler implements TextureFileHandler {

	@Override
	public String getImageFileName(Path source) {
		Path fileName = source.getFileName();
		return fileName != null ? fileName.toString() : null;		
	}

}
