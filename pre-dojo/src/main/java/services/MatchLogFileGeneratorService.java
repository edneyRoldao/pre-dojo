package services;

import business.MatchOutput;
import util.ReadAndWriteFileUtil;
import util.MockUtil;

/**
 * @author edneyroldao
 */
public class MatchLogFileGeneratorService {

	
	public void generate(String filePath, int battles) {
		System.out.println("file has been created !");
		
		MatchOutput outputMatch = getMatch();
		String logValue = outputMatch.matchGenerator(battles);
		ReadAndWriteFileUtil.writeLogFile(filePath, logValue);
		
		System.out.println("The match was written in log file successfully !");
	}
	
	/**
	 * @return One match with killer and weapon list predefined.
	 */
	private MatchOutput getMatch() {
		return new MatchOutput(MockUtil.getKillerList(), MockUtil.getWeaponList());
	}
	
}
