package interfaces;

import java.util.List;

public interface DisplayMatchResults {

	List<String> getMurdersRanking();
	List<String> getDeadRanking();
	String getBestWeaponFromWinner();
	List<String> getGreaterMurdersSequenceBeforeDeath();
	List<String> getAwardsEarnedByFiveMurders();
	List<String> getAwardsEarnedByMatchWithoutDeath();
	
}
