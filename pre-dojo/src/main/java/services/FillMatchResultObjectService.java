package services;

import business.MatchRankingResultImpl;
import business.MatchResultObject;
import interfaces.MatchRankingResult;

/**
 * @author Edney Roldao
 */
public class FillMatchResultObjectService {

	private MatchRankingResult rankingObj;
	private MatchResultObject resultObj;
	
	
	public FillMatchResultObjectService() {
		init();
	}
	
	public void init() {
		
		rankingObj = new MatchRankingResultImpl();
		rankingObj.init();
		
		resultObj = new MatchResultObject();
		resultObj.setId(rankingObj.getMatchId());
		resultObj.setMurdersRanking(rankingObj.getMurdersRanking());
		resultObj.setDeathsRanking(rankingObj.getDeadRanking());
		resultObj.setChampionKiller(rankingObj.getChampionKiller().getName());
		resultObj.setWeaponsMoreUsed(rankingObj.getBestWeaponFromWinner(rankingObj.getChampionKiller()));
		resultObj.setGreaterSequenceMurders(rankingObj.getGreaterMurdersSequenceBeforeDie());
		resultObj.setKillersHasNotDie(rankingObj.getKillersThatHasNotDied());
		resultObj.setAwardsFiveMurdersMinute(rankingObj.getAwardsEarnedByFiveMurdersIntoOneMinute());
	}
	
	
	public MatchResultObject getMatchResultObject() {
		return resultObj;
	}
	
}
