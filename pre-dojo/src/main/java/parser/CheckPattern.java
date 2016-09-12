package parser;

import java.util.List;

public class CheckPattern {

	public static boolean checkPatternLogFile(List<String> list) {
		String firstLineRegex = "\\d{2}/\\d{2}/\\d{4} \\d{2}:\\d{2}:\\d{2} - (?i)new (?i)match \\d+ has (?i)started\\s*";
		String lastLineRegex = "\\d{2}/\\d{2}/\\d{4} \\d{2}:\\d{2}:\\d{2} - (?i)match \\d+ has (?i)ended\\s*";
		String matchLinesRegex = "\\d{2}/\\d{2}/\\d{4} \\d{2}:\\d{2}:\\d{2} - .+ (?i)killed .+ (?i)using .+";
		
		if(!list.get(0).matches(firstLineRegex))
			return false;

		if(!list.get(list.size() - 1).matches(lastLineRegex))
			return false;
		
		for(int i = 1; i < list.size() - 1; i++) {
			if(!list.get(i).matches(matchLinesRegex))
				return false;
		}
		
		return true;
	}

	
}
