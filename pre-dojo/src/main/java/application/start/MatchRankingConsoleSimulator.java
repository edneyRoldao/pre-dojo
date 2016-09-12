package application.start;


import java.util.List;

import business.MatchResultObject;
import services.FillMatchResultObjectService;

/**
 * This class shows via console a ranking result.
 * @author Edney Roldao
 */
public class MatchRankingConsoleSimulator {
	
	private static final FillMatchResultObjectService service = new FillMatchResultObjectService();
	
	private static final MatchResultObject resultObj = service.getMatchResultObject();
	
	public static void main(String[] args) {
		
		System.out.println("###############################################################################");
		System.out.println("#############################  MATCH RANKING  #################################");
		System.out.println("###############################################################################");
		System.out.println();
		
		printMatchId();
		printMurdersRank();
		printDeathsRank();
		printBestWeapon();
		printGreaterSequenceMurdersWithoutDeath();
		printKillersListThatEarnedAwardByWinMatchWithoutDeath();
		printKillersListThatEarnedAwardByFiveMurdersInOneMinute();
		
	}
	
	private static void printMatchId() {
		System.out.println("###############################################################################");
		System.out.println("######  MATCH ID  #############################################################");
		System.out.println("###############################################################################");
		System.out.println(resultObj.getId());
		System.out.println();
	}
	
	private static void printMurdersRank() {
		System.out.println("###############################################################################");
		System.out.println("######  MURDERS RANKING  ######################################################");
		System.out.println("###############################################################################");
		resultObj.getMurdersRanking().forEach(s -> System.out.println(s));
		System.out.println();
	}
	
	private static void printDeathsRank() {
		List<String> list = resultObj.getDeathsRanking();
		System.out.println("###############################################################################");
		System.out.println("######  DEATHS RANKING  #######################################################");
		System.out.println("###############################################################################");
		list.forEach(s -> System.out.println(s));
		System.out.println();
	}
	
	private static void printBestWeapon() {
		System.out.println("###############################################################################");
		System.out.println("######  BEST WEAPON USED BY WINNER  ###########################################");
		System.out.println("###############################################################################");
		System.out.println(resultObj.getChampionKiller());
		resultObj.getWeaponsMoreUsed().forEach(s -> System.out.println(s));
		System.out.println();
	}
	
	private static void printGreaterSequenceMurdersWithoutDeath() {
		System.out.println("###############################################################################");
		System.out.println("######  GREATER MURDERS SEQUENCE  #############################################");
		System.out.println("###############################################################################");
		resultObj.getGreaterSequenceMurders().forEach(s -> System.out.println(s));
		System.out.println();
	}
	
	private static void printKillersListThatEarnedAwardByWinMatchWithoutDeath() {
		System.out.println("###############################################################################");
		System.out.println("######  KILLERS LIST - WIN A MATCH WITHOUT DIE  ###############################");
		System.out.println("###############################################################################");
		resultObj.getKillersHasNotDie().forEach(s -> System.out.println(s));
		System.out.println();
	}
	
	private static void printKillersListThatEarnedAwardByFiveMurdersInOneMinute() {
		System.out.println("###############################################################################");
		System.out.println("######  KILLERS LIST - FIVE MURDERS INTO A MINUTE  ############################");
		System.out.println("###############################################################################");
		resultObj.getAwardsFiveMurdersMinute().forEach(s -> System.out.println(s));
		System.out.println();
	}
	
}
