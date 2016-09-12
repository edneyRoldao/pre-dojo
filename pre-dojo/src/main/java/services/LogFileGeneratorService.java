package services;

import java.util.List;

import org.springframework.stereotype.Service;

import application.config.AppConfig;
import application.config.KillersConfig;
import application.config.WeaponsConfig;
import business.MatchGenerator;
import models.Killer;
import models.Weapon;
import utils.ReadFileUtil;
import utils.WriteFileUtil;

/**
 * This is a service that will create a log file with randomly results.
 * 
 * Advice: 
 * 		  - Don't forget to define an interval between murders from AppConfing. (INTERVAL_ACTIONS_IN_SECONDS) 
 * 		  - Don't forget to define how much lines of murders and deaths from AppConfig (WRESTLE_NUMBER)
 * 
 * What features this service provide us:
 * - matchGenerator
 * - get killers list from a log file defined before
 * - get weapons list from a log file defined before
 * - get original log file created before from a list with each line 
 * 
 * @author edneyroldao
 */
@Service
public class LogFileGeneratorService {
	
	/**
	 * This method simulate one match e generate its log file. 
	 * @param filePath location where the file will be created.
	 * @param battles this value defines the log size.
	 */
	public void matchGenerator() {
		System.out.println("file has been created !");
		
		// Getting killers and weapons mock
		List<Killer> killers = KillersConfig.getKillerList();
		List<Weapon> weapons = WeaponsConfig.getWeaponList();
		
		// Retrieving log file from simulator
		String logValue = new MatchGenerator(killers, weapons).matchGenerator();
		
		// Writing and Reading the file generated above.
		WriteFileUtil.writeLogFile(AppConfig.PATH, AppConfig.FILE_NAME, logValue);
		ReadFileUtil.readLogFile(AppConfig.PATH, AppConfig.FILE_NAME);
		
		System.out.println("The match was written in log file successfully !");
	}
	
	/**
	 * @return killers in the match
	 */
	public List<Killer> getKillersList() {
		return KillersConfig.getKillerList();
	}
	
	/**
	 * @return weapons that will be used in the match.
	 */
	public List<Weapon> getWeaponsList() {
		return WeaponsConfig.getWeaponList();
	}
	
	/**
	 * @param filePath
	 * @param fileName
	 * @return original file log.
	 */
	public List<String> getOrinalMatchLog() {
		return ReadFileUtil.readLogFile(AppConfig.PATH, AppConfig.FILE_NAME);
	}
	
}
