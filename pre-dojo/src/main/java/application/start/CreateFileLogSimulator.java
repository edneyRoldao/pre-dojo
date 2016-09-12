package application.start;

import services.LogFileGeneratorService;

/**
 * This class shows via console log file creation and original log file values.
 * 
 * To make this simulator working better, we need to define the variable values below:
 *  Killers list: from class KillersConfig
 *  Weapons list: from class WeaponsConfig
 *  Interval among each murder: from AppConfig ( INTERVAL_ACTIONS_IN_SECONDS )
 *  The quantity lines of murders and deaths: from AppConfig ( WRESTLE_NUMBER ) 
 * 
 * @author edneyroldao
 */
public class CreateFileLogSimulator {

	// Service
	private static final LogFileGeneratorService service = new LogFileGeneratorService();
	
	
	public static void main(String[] args) {
		
		service.matchGenerator();
		displayLogFromOriginalFile();
		
	}
	
	private static void displayLogFromOriginalFile() {
		System.out.println();
		System.out.println();
		System.out.println("#####################################################################");
		System.out.println("#################### ORIGINAL LOG FILE GENERATED ####################");
		System.out.println("#####################################################################");
		System.out.println();
		service.getOrinalMatchLog().forEach(s -> System.out.println(s));
	}
	
}
