package applicationTest;

import services.MatchLogFileGeneratorService;

/**
 * This class shows via console log file creation and original log file values.
 * @author edneyroldao
 */
public class LogFileGenerateSimulator {

	 
	private static final String  FILE_PATH = "C:/javaIO/log"; // Insert you file location here even if it doesn't exist.
	private static final String  FILE_NAME = "log.txt"; // Insert a file name
	private static final MatchLogFileGeneratorService matchService = new MatchLogFileGeneratorService(); // Service
	
	
	public static void main(String[] args) {
		
		int battles = 5; // This value defines the log file size.
		int timeAction = 3;// This variable defines a random time seconds for each action
		
		createMatch(battles, timeAction);
		displayLogFromOriginalFile();
	}

	
	private static void createMatch(int logFileSize, int actionsInterval) {
		matchService.matchGenerator(FILE_PATH, FILE_NAME, logFileSize, actionsInterval);
	}
	
	private static void displayLogFromOriginalFile() {
		System.out.println();
		System.out.println();
		System.out.println("#####################################################################");
		System.out.println("#################### ORIGINAL LOG FILE GENERATED ####################");
		System.out.println("#####################################################################");
		System.out.println();
		matchService.getOrinalMatchLog(FILE_PATH, FILE_NAME).forEach(s -> System.out.println(s));
	}
	
}
