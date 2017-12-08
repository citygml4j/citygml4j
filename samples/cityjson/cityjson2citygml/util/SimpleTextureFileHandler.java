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

	public SimpleTextureFileHandler(Path baseDir, Path targetDir) throws IOException {
		this.baseDir = baseDir;
		this.targetDir = targetDir;
		
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
				Path target = targetDir.resolve(fileName);
				copy(source, target);
				return target.toString().replace('\\', '/');
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
