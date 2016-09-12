package business;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import application.config.AppConfig;
import models.Killer;
import models.Ninja;
import models.Soldier;
import parser.LogLineData;
import utils.DateUtil;
import utils.ReadFileUtil;
import parser.LogFileMatchParser;

/**
 * List of the main things that this class does:
 * 
 * Retrieving results from a log file.
 * Instantiating parser object.
 * Getting a data list parsed from a file log.
 * Calling methods lead with Killers and Weapons objects (population)  
 * 
 * @author edneyroldao
 */
public class MatchCompiler {

	// Attributes
	private int matchId;
	private final List<LogLineData> dataList;
	private final LogFileMatchParser matchParser;
	private List<Killer> killers = new ArrayList<>();

	// Constructor
	public MatchCompiler() {
		List<String> logFileResults = new ArrayList<>();
		
		// Retrieving results from a log file  
		logFileResults = ReadFileUtil.readLogFile(AppConfig.PATH, AppConfig.FILE_NAME);
		
		// Instantiating parser object
		matchParser = new LogFileMatchParser(logFileResults);
		
		// Getting a data list parsed from a file log
		dataList = matchParser.getParsedList();
		
		// Calling methods lead with Killers and Weapons objects (population)
		posConstruct();
	}

	private void posConstruct() {
		matchId = matchParser.retrieveMatchId();
		countMurdersAndWeapons();
		countDeaths();
		addAwardKillerNotDead();
		setGreatMurderSequence();
		addAwardFiveMurdersInOneMinute();
		addPreferedWeapon();
	}

	/**
	 * This method does the murders count and the weapon used.
	 */
	public void countMurdersAndWeapons() {
		for (LogLineData d : dataList) {
			int killerIdex = getKillerIndex(d.getKillerName());
			if (!d.getKillerName().equals("<WORLD>")) {
				if (killerIdex == -1) {
					Soldier s = new Soldier(d.getKillerName());
					s.getWeapons().put(d.getWeaponName(), 1);
					s.setMurdersNumber(1);
					killers.add(s);
				} else {
					int murder = killers.get(killerIdex).getMurdersNumber();
					killers.get(killerIdex).setMurdersNumber(murder + 1);

					if (killers.get(killerIdex).getWeapons().containsKey(d.getWeaponName())) {
						int value = killers.get(killerIdex).getWeapons().get(d.getWeaponName());
						killers.get(killerIdex).getWeapons().put(d.getWeaponName(), value + 1);
					} else {
						killers.get(killerIdex).getWeapons().put(d.getWeaponName(), 1);
					}

				}
			}
		}
	}

	/**
	 * This method does the deaths count.
	 */
	public void countDeaths() {
		for (LogLineData d : dataList) {

			if (!d.getDeadName().equals("<WORLD>")) {
				int deadIndex = getKillerIndex(d.getDeadName());

				if (deadIndex == -1) {
					Ninja n = new Ninja(d.getDeadName());
					n.setDeathsNumber(1);
					killers.add(n);
				} else {
					int death = killers.get(deadIndex).getDeathsNumber();
					killers.get(deadIndex).setDeathsNumber(death + 1);
				}
			}
		}
	}

	// Support method ( countDeaths() and countMurdersAndWeapons() )
	private int getKillerIndex(String killer) {
		for (int i = 0; i < killers.size(); i++) {
			if (killers.get(i).getName().equals(killer))
				return i;
		}
		return -1;
	}

	/**
	 * This method add an award when the killer wasn't dead in a whole match.
	 */
	public void addAwardKillerNotDead() {
		for (int i = 0; i < killers.size(); i++) {
			if (killerHasNotDeath(killers.get(i).getName())) {
				int awards = killers.get(i).getAwardMatchWithoutDeath();
				killers.get(i).setAwardMatchWithoutDeath(awards + 1);
			}

		}
	}

	// Support method ( addAwardKillerNotDead() )
	private boolean killerHasNotDeath(String killer) {
		for (LogLineData d : dataList) {
			if (d.getDeadName().equals(killer)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * add greater murders sequence without death.
	 */
	public void setGreatMurderSequence() {
		for (int i = 0; i < killers.size(); i++) {
			int sequence = getMurderSequence(killers.get(i).getName());
			killers.get(i).setMurderSequence(sequence);
		}
	}

	// Support method ( setGreatMurderSequence() )
	private int getMurderSequence(String killer) {
		List<Integer> murders = new ArrayList<>();
		int sequence = 0;

		for (LogLineData d : dataList) {
			
			if (killer.equals(d.getKillerName())) {
				sequence += 1;
			} else if(killer.equals(d.getDeadName())) {
				murders.add(sequence);
				sequence = 0;
			}
			murders.add(sequence);
		}

		Collections.sort(murders);

		return murders.get(murders.size() - 1);
	}

	/**
	 * Add awards when the killer has five murders in a minute.
	 */
	public void addAwardFiveMurdersInOneMinute() {
		for (int i = 0; i < killers.size(); i++) {
			int awards = getAwardsFiveMurdersOneMinute(killers.get(i).getName());
			killers.get(i).setAwardFiveMurdersOneMinute(awards);
		}
	}

	// Support method ( addAwardFiveMurders() )
	private int getAwardsFiveMurdersOneMinute(String killer) {
		List<LogLineData> dataSubList = dataList;
		int awards = 0;

		while (!dataSubList.isEmpty()) {
			
			Calendar calendar = DateUtil.stringToCalendar(dataSubList.get(0).getActionTime());
			calendar.add(Calendar.MINUTE, 1);
			List<LogLineData> subList = new ArrayList<>();
			List<LogLineData> smallList = new ArrayList<>();
			int countMurder = 0;

			for (LogLineData d : dataSubList) {
				Calendar c = DateUtil.stringToCalendar(d.getActionTime());
				if (c.compareTo(calendar) <= 0) {
					subList.add(d);
				}else {
					smallList.add(d);
				}
			}

			for (LogLineData d : subList) {
				if (d.getKillerName().equals(killer))
					countMurder += 1;
			}

			if (countMurder >= 5)
				awards += 1;

			if(smallList.size() == 1) {
				dataSubList.remove(smallList.get(0));
			}else {
				dataSubList = smallList;
			}
		}

		return awards;
	}

	/**
	 * This keep only prefered weapon. 
	 * @param killer
	 */
	public void addPreferedWeapon() {
		for(int i = 0; i < killers.size(); i++) {
			
			List<String> list = new ArrayList<>();
			
			for(String key : killers.get(i).getWeapons().keySet()) {
				list.add(killers.get(i).getWeapons().get(key) + ";" + key);
			}
			
			Comparator<String> comp = (s1, s2) -> {
				return s1.compareTo(s2);
			};
			
			Collections.sort(list, Collections.reverseOrder(comp));
			List<String> list2 = new ArrayList<>();
			
			if(!list.isEmpty()) {
				int control = extractNumberFromText(list.get(0));
				
				list.forEach(s -> {
					if(extractNumberFromText(s) == control)
						list2.add(s);
				});
			}
			
			
			killers.get(i).setWeaponMoreUsed(list2);
		}
	}

	// Support method ( addPreferedWeapon() )
	private int extractNumberFromText(String value) {
		if(!value.isEmpty()) {
			String[] token = value.split(";");
			String number = token[0].trim();
			return Integer.valueOf(number);
		}
		return 0;
	}
	
	public int getMatchId() {
		return matchId;
	}
	
	public List<Killer> getKillers() {
		return killers;
	}
	
}
