package business;

import java.io.Serializable;
import java.util.List;

public class MatchResultObject implements Serializable {

	private static final long serialVersionUID = 1L;

	// Attributes
	private int id;
	private String championKiller;
	private List<String> weaponsMoreUsed;
	private List<String> murdersRanking;
	private List<String> deathsRanking;
	private List<String> greaterSequenceMurders;
	private List<String> awardsFiveMurdersMinute;
	private List<String> killersHasNotDie;

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getChampionKiller() {
		return championKiller;
	}

	public void setChampionKiller(String championKiller) {
		this.championKiller = championKiller;
	}

	public List<String> getWeaponsMoreUsed() {
		return weaponsMoreUsed;
	}

	public void setWeaponsMoreUsed(List<String> weaponsMoreUsed) {
		this.weaponsMoreUsed = weaponsMoreUsed;
	}

	public List<String> getMurdersRanking() {
		return murdersRanking;
	}

	public void setMurdersRanking(List<String> murdersRanking) {
		this.murdersRanking = murdersRanking;
	}

	public List<String> getDeathsRanking() {
		return deathsRanking;
	}

	public void setDeathsRanking(List<String> deathsRanking) {
		this.deathsRanking = deathsRanking;
	}

	public List<String> getGreaterSequenceMurders() {
		return greaterSequenceMurders;
	}

	public void setGreaterSequenceMurders(List<String> greaterSequenceMurders) {
		this.greaterSequenceMurders = greaterSequenceMurders;
	}

	public List<String> getAwardsFiveMurdersMinute() {
		return awardsFiveMurdersMinute;
	}

	public void setAwardsFiveMurdersMinute(List<String> awardsFiveMurdersMinute) {
		this.awardsFiveMurdersMinute = awardsFiveMurdersMinute;
	}

	public List<String> getKillersHasNotDie() {
		return killersHasNotDie;
	}

	public void setKillersHasNotDie(List<String> killersHasNotDie) {
		this.killersHasNotDie = killersHasNotDie;
	}

}
