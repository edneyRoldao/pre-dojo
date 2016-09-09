package tests;

import services.MatchLogFileGeneratorService;

/**
 * @author edneyroldao
 */
public class LogFileGeneratorTest {

	public static void main(String[] args) {
		
		String filePath = "/Users/edneyroldao/workspace/JAVA/projects/pre-dojo/logFiles/log.txt";
		int battles = 15;
		new MatchLogFileGeneratorService().generate(filePath, battles);
		
	}
	
}
