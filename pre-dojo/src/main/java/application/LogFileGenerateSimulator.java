package application;

import services.MatchLogFileGeneratorService;

/**
 * @author edneyroldao
 */
public class LogFileGenerateSimulator {

	public static void main(String[] args) {
		
		MatchLogFileGeneratorService matchService = new MatchLogFileGeneratorService();
		String filePath = "C:/javaIO/log";
		String fileName = "logFile.txt";
		int battles = 5;
		int timeAction = 3;
		
		matchService.matchGenerator(filePath, fileName, battles, timeAction);
		
		System.out.println();
		System.out.println();
		System.out.println("#####################################################################");
		System.out.println("#####################################################################");
		System.out.println("######################### ORIGINAL LOG FILE #########################");
		System.out.println("#####################################################################");
		System.out.println("#####################################################################");
		matchService.getOrinalMatchLog(filePath, fileName).forEach(s -> System.out.println(s));
		
	}
	
}
