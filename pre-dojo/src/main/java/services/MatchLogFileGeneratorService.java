package services;

import java.util.List;

import business.MatchOutput;
import models.Killer;
import models.Weapon;
import util.ReadAndWriteFileUtil;
import util.MockUtil;

/**
 * @author edneyroldao
 */
public class MatchLogFileGeneratorService {

	
	/**
	 * This method simulate one match e generate its log file. 
	 * @param filePath location where the file will be created.
	 * @param battles this value defines the log size.
	 */
	public void matchGenerator(String filePath, String fileName, int battles, int timeActionInterval) {
		System.out.println("file has been created !");
		
		MatchOutput outputMatch = getMatch(timeActionInterval);
		String logValue = outputMatch.matchGenerator(battles);
		ReadAndWriteFileUtil.writeLogFile(filePath, fileName, logValue);
		
		System.out.println("The match was written in log file successfully !");
	}
	
	// Method support ( matchGenerator() )
	private MatchOutput getMatch(int timeActionInterval) {
		return new MatchOutput(MockUtil.getKillerList(), MockUtil.getWeaponList(), timeActionInterval);
	}
	
	/**
	 * @return killers in the match
	 */
	public List<Killer> getKillersList() {
		return MockUtil.getKillerList();
	}
	
	/**
	 * @return weapons that will be used in the match.
	 */
	public List<Weapon> getWeaponsList() {
		return MockUtil.getWeaponList();
	}
	
	/**
	 * @param filePath
	 * @param fileName
	 * @return original file log.
	 */
	public List<String> getOrinalMatchLog(String filePath, String fileName) {
		return ReadAndWriteFileUtil.readLogFile(filePath, fileName);
	}
	
}
