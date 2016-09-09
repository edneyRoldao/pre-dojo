package parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author edneyroldao
 */
public class LogFileMatchParser {

	// Attribute
	private final List<String> logResultList;
	
	// Constructor
	public LogFileMatchParser(List<String> logResultList) {
		this.logResultList = logResultList;
	}
	
	
	public List<LogLineData> getParsedList() {
		List<LogLineData> list = new ArrayList<>();
		
		for(String s : logResultList) {
			if(! isNotStrifeLine(s)) {
				LogLineData data = new LogLineData();
				data.setActionTime(retrieveActionTime(s));
				data.setKillerName(retrieveKillerName(s));
				data.setDeadName(retrieveDeadName(s));
				data.setWeaponName(retrieveWeaponName(s));
				list.add(data);
			}
		}
		
		return list;
	}

	public int retrieveMatchId() {
		Matcher matcher = null;
		StringBuilder sb = new StringBuilder();
		
		for(String s : logResultList) {
			String[] token = s.split("-");
			matcher = Pattern.compile("\\d").matcher(token[1]);
			
			while(matcher.find())
				sb.append(matcher.group());
			
			return Integer.parseInt(sb.toString());
		}
		
		return 0;
	}
	
	private String retrieveActionTime(String line) {
		String[] token = line.split("-");
		return token[0].trim();
	}
	
	private String retrieveWeaponName(String line) {
		return line.substring(line.lastIndexOf("using") + 5).trim();
	}
	
	private String retrieveDeadName(String line) {
		int init = line.lastIndexOf("killed") + 6;
		int end = line.indexOf("using");
		return line.substring(init, end).trim();
	}
	
	private String retrieveKillerName(String line) {
		String[] token = line.split("-");
		int index = token[1].indexOf("killed");
		return token[1].substring(0, index).trim();
	}
	
	private boolean isNotStrifeLine(String line) {
		Matcher m = Pattern.compile("(?i)match").matcher(line);
		return m.find();
	}
	
}
