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

	
	public static void writeLogFile(String filePath, String value) {
		
		Path path = Paths.get(filePath);
		
		try(BufferedWriter bw = Files.newBufferedWriter(path, UTF8)) {

			bw.write(value);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static List<String> readLogFile(String filePath) {

		List<String> list = new ArrayList<>();
		Path path = Paths.get(filePath);
		
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
