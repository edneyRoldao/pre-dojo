package applicationTest;


import java.util.List;

import services.MatchResultRankingService;

/**
 * This class shows via console a ranking result.
 * @author Edney Roldao
 */
public class MatchInputSimulator {

	private static final String  FILE_PATH = "C:/javaIO/log";
	private static final String  FILE_NAME = "log.txt";
	private static final MatchResultRankingService matchResultService = new MatchResultRankingService();
	
	public static void main(String[] args) {
		
		System.out.println("###############################################################################");
		System.out.println("######  RANKING MATCH  ########################################################");
		System.out.println("###############################################################################");
		System.out.println();
		System.out.println();
		System.out.println();
		
		matchResultService.init(FILE_PATH, FILE_NAME);
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
		System.out.println(matchResultService.getMatchId());
		System.out.println();
	}
	
	private static void printMurdersRank() {
		System.out.println("###############################################################################");
		System.out.println("######  MURDERS RANK  #########################################################");
		System.out.println("###############################################################################");
		matchResultService.getMurdersRanking().forEach(s -> System.out.println(s));
		System.out.println();
	}
	
	private static void printDeathsRank() {
		List<String> list = matchResultService.getDeadRanking();
		System.out.println("###############################################################################");
		System.out.println("######  DEATHS RANK  ##########################################################");
		System.out.println("###############################################################################");
		list.forEach(s -> System.out.println(s));
		System.out.println();
	}
	
	private static void printBestWeapon() {
		System.out.println("###############################################################################");
		System.out.println("######  BEST WEAPON USED BY WINNER  ###########################################");
		System.out.println("###############################################################################");
		System.out.println(matchResultService.getBestWeaponFromWinner());
		System.out.println();
	}
	
	private static void printGreaterSequenceMurdersWithoutDeath() {
		System.out.println("###############################################################################");
		System.out.println("######  GREATER SEQUENCE MURDERS  #############################################");
		System.out.println("###############################################################################");
		matchResultService.getGreaterMurdersSequenceBeforeDeath().forEach(s -> System.out.println(s));
		System.out.println();
	}
	
	private static void printKillersListThatEarnedAwardByWinMatchWithoutDeath() {
		System.out.println("###############################################################################");
		System.out.println("######  KILLER LIST - WIN A MATCH WITHOUT DEATH  ##############################");
		System.out.println("###############################################################################");
		matchResultService.getAwardsEarnedByMatchWithoutDeath().forEach(s -> System.out.println(s));
		System.out.println();
	}
	
	private static void printKillersListThatEarnedAwardByFiveMurdersInOneMinute() {
		System.out.println("###############################################################################");
		System.out.println("######  KILLERS LIST - FIVE MURDERS IN ONE MINUTE  ############################");
		System.out.println("###############################################################################");
		matchResultService.getAwardsEarnedByFiveMurders().forEach(s -> System.out.println(s));
		System.out.println();
	}
	
}
