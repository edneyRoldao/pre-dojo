package parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import util.ReadAndWriteFileUtil;

/**
 * @author edneyroldao
 */
public class LogFileMatchParser {

	// Attributes
	private final String filePath;
	private List<String> formattedResultList;
	
	// Constructor
	public LogFileMatchParser(String filePath) {
		this.filePath = filePath;
		formattedResultList = listFormatter();
	}
	
	public List<Data> getDataList() {
		List<Data> list = new ArrayList<>();
		
		for(String s : formattedResultList) {
			if(! isStrifeLine(s)) {
				Data data = new Data();
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
		
		for(String s : formattedResultList) {
			matcher = Pattern.compile("\\d").matcher(s);
			
			while(matcher.find())
				sb.append(matcher.group());
			
			return Integer.parseInt(sb.toString());
		}
		
		return 0;
	}
	
	private List<String> listFormatter() {
		List<String> resultList = ReadAndWriteFileUtil.readLogFile(filePath);
		
		List<String> list = new ArrayList<>();
		
		for(String s : resultList) {
			String[] token = s.split("-");
			list.add(token[1].trim());
		}
		
		return list;
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
		int index = line.indexOf("killed");
		return line.substring(0, index).trim();
	}
	
	private boolean isStrifeLine(String line) {
		Matcher m = Pattern.compile("(?i)match").matcher(line);
		return m.find();
	}
	
}
