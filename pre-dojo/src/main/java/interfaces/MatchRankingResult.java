package interfaces;

import java.util.List;

import models.Killer;

public interface MatchRankingResult {

	void init();
	int getMatchId();
	List<String> getMurdersRanking();
	List<String> getDeadRanking();
	Killer getChampionKiller();
	List<String> getBestWeaponFromWinner(Killer k);
	List<String> getGreaterMurdersSequenceBeforeDie();
	List<String> getAwardsEarnedByFiveMurdersIntoOneMinute();
	List<String> getKillersThatHasNotDied();
	
}
