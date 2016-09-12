package utils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriteFileUtil {

	public static void writeLogFile(String filePath, String fileName, String value) {
		
		if(!Files.exists(Paths.get(filePath))) {
			try {
				Files.createDirectories(Paths.get(filePath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		String wholePath = filePath + "/" + fileName;
		Path path = Paths.get(wholePath);
		
		try(BufferedWriter bw = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {

			bw.write(value);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	
}
