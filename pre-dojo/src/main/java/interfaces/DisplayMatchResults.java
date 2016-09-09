package interfaces;

import java.util.List;

public interface DisplayMatchResults {

	List<String> getMurdersRanking();
	List<String> getDeadRanking();
	String getBestWeaponFromWinner();
	String getGreaterMurdersSequenceBeforeDeath();
	List<String> getAwardsEarnedRanking();
	
}
