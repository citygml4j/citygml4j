package org.citygml4j.builder.cityjson.unmarshal.util;

public class SimpleTextureFileHandler implements TextureFileHandler {

	@Override
	public String getImageURI(String imageFileName) {
		return new StringBuilder("appearances").append("/").append(imageFileName).toString();
	}

}
