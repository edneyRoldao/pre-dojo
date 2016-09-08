package business;

import java.util.ArrayList;
import java.util.List;

import models.Killer;
import models.Ninja;
import models.Soldier;
import parser.Data;
import parser.LogFileMatchParser;

/**
 * @author edneyroldao
 */
public class MatchInput extends Match {

	// Attributes    
	private final List<Data> dataList;
	private final LogFileMatchParser parser;
	private List<Killer> list = new ArrayList<>();
	
	// Constructor
	public MatchInput(String filePath) {
		parser = new LogFileMatchParser(filePath);
		dataList = parser.getDataList();
		setId(parser.retrieveMatchId());
	}

	public void addKiller() {
		
		for(Data d : dataList) {

			int indexK = getKiller(d.getKillerName());
			int indexD = getKiller(d.getDeadName());

			if(!d.getKillerName().equals("<WORLD>")) {
				if(indexK == -1) {
					Soldier s = new Soldier(d.getKillerName());
					s.setMurdersNumber(1);
					list.add(s);
				}else {
					list.get(indexK).setMurdersNumber(list.get(indexK).getMurdersNumber() + 1);
				}
			}
			
			if(indexD == -1) {
				Ninja n = new Ninja(d.getDeadName());
				n.setDeathsNumber(1);;
				list.add(n);
			}else {
				list.get(indexD).setDeathsNumber(list.get(indexD).getDeathsNumber() + 1);
			}
			
			
			
		}
		
	}
	
	private int getKiller(String killer) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getName().equals(killer))
				return i;
		}
		return -1;
	}
	
}
