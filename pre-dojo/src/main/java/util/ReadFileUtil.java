package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author edneyroldao
 */
public class ReadFileUtil {

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
		
		try(BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {

			String line = null;
			
			while((line = br.readLine()) != null)
				if(!line.equals(""))
					list.add(line);
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	
}
