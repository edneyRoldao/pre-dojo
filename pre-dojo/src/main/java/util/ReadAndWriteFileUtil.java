package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author edneyroldao
 */
public class ReadAndWriteFileUtil {

	private static final Charset UTF8 = StandardCharsets.UTF_8;

	
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
		
		try(BufferedWriter bw = Files.newBufferedWriter(path, UTF8)) {

			bw.write(value);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static List<String> readLogFile(String filePath, String fileName) {

		if(!Files.exists(Paths.get(filePath))) {
			try {
				Files.createDirectories(Paths.get(filePath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		String wholePath = filePath + "/" + fileName;
		
		List<String> list = new ArrayList<>();
		Path path = Paths.get(wholePath);
		
		try(BufferedReader br = Files.newBufferedReader(path, UTF8)) {

			String line = null;
			
			while((line = br.readLine()) != null)
				list.add(line);
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
}
