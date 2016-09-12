package junit.service.matchInput;

import static org.junit.Assert.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.BeforeClass;
import org.junit.Test;

import application.config.AppConfig;
import business.MatchResultObject;
import junitUtil.LogFileUtil;
import services.FillMatchResultObjectService;
import utils.WriteFileUtil;

/**
 * 	 There are tests that might return more than one result, like the test where I'm checking 
 * the greater murders sequence from a Killer before his death, so in these cases I preferred 
 * retrieve the first result from a list (index 0) instead the others.
 * 
 * @author edneyroldao
 */
public class MatchResultServiceTest {
	
	public static FillMatchResultObjectService matchResultService = new FillMatchResultObjectService();
	
	private static final MatchResultObject resultObj = matchResultService.getMatchResultObject();

	
	@BeforeClass
	public static void init() {
		String fileLogMock = LogFileUtil.getFileLog();
		WriteFileUtil.writeLogFile(AppConfig.PATH, AppConfig.FILE_NAME, fileLogMock);
	}
	
	@Test
	public void testGetMatchId() {
		int expectedId = 52347104;
		
		// Testing this service
		int actualId = resultObj.getId();
		
		assertEquals(expectedId, actualId);
	}
	
	@Test
	public void testGetGraterMurdersRanking() {
		String expectedValue = "Killer Name: Kevin Owens  -  Murders number: 5";
		
		// Testing this service
		String actualValue = resultObj.getMurdersRanking().get(0);
		
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	public void testGetShorterMurdersRanking() {
		String expectedValue = "Killer Name: The Undertaker  -  Murders number: 0";
		int lastIndex = resultObj.getMurdersRanking().size() - 1;
		
		// Testing this service
		String actualValue = resultObj.getMurdersRanking().get(lastIndex);
		
		
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	public void testGetGraterDeathsRanking() {
		String expectedValue = "Dead Name: Roman Reigns  -  Deaths number: 4";
		
		// Testing this service
		String actualValue = resultObj.getDeathsRanking().get(0);
		
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	public void testGetShorterDeathsRanking() {
		String expectedValue = "Dead Name: Kevin Owens  -  Deaths number: 0";
		int lastIndex = resultObj.getDeathsRanking().size() - 1;
		
		// Testing this service
		String actualValue = resultObj.getDeathsRanking().get(lastIndex);
		
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	public void testWeaponMoreUsedByTheWinner() {
		String expectedWeapon = "AK 47";
		String actualWeapon = "";
		
		// Testing this service
		List<String> weapons = resultObj.getWeaponsMoreUsed();
		StringBuilder extractValue = new StringBuilder();
		
		weapons.forEach(s -> extractValue.append(s));
		
		Matcher matcher = Pattern.compile(expectedWeapon).matcher(extractValue.toString());
		while(matcher.find())
			actualWeapon = matcher.group();
		
		assertEquals(expectedWeapon, actualWeapon);
	}

	@Test
	public void testGreaterMurdersSequenceBeforeDie() {
		String expectedSequence = "killer name: Kevin Owens - greater sequence: ( 5 )";
		
		// Testing this service
		String actualValue = resultObj.getGreaterSequenceMurders().get(0);
		
		assertEquals(expectedSequence, actualValue);
	}
	
	@Test
	public void testKillerThatHasNotDie() {
		String expectedKiller = "Killer name: (Kevin Owens)  won an award by not die into a match";

		// Testing this service
		String actualKiller = resultObj.getKillersHasNotDie().get(0);
		
		assertEquals(expectedKiller, actualKiller);
	}
	
	@Test
	public void testAwardsEarnedByFiveMurdersIntoOneMinute() {
		String expectedValue = "Killer name: Kevin Owens   - awards earned by five murders in a minute ( 1 )";
		
		// Testing this service
		String actualValue = resultObj.getAwardsFiveMurdersMinute().get(0);
		
		assertEquals(expectedValue, actualValue);
	}
	
}
