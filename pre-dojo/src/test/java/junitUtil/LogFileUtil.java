package junitUtil;

/**
 * @author edneyroldao
 */
public class LogFileUtil {

	public static String getFileLog() {
		StringBuilder sb = new StringBuilder();
		sb.append("08/09/2016 11:15:01 - New match 52347104 has started\n");
		sb.append("08/09/2016 11:15:00 - Kevin Owens killed Roman Reigns using C4\n");		
		sb.append("08/09/2016 11:15:05 - Roman Reigns killed The Undertaker using C4\n");
		sb.append("08/09/2016 11:15:10 - Kevin Owens killed Seth Rollins using AK 47\n");
		sb.append("08/09/2016 11:15:15 - Kevin Owens killed Roman Reigns using C4 \n");
		sb.append("08/09/2016 11:15:20 - Seth Rollins killed Roman Reigns using AK 47\n");
		sb.append("08/09/2016 11:15:25 - Kevin Owens killed Seth Rollins using AK 47\n");
		sb.append("08/09/2016 11:15:40 - <WORLD> killed Dean Ambrose using AK 47 \n");
		sb.append("08/09/2016 11:15:59 - Kevin Owens killed The Undertaker using AK 47\n");
		sb.append("08/09/2016 11:16:17 - <WORLD> killed Roman Reigns using AK 47 \n");		
		sb.append("08/09/2016 11:16:24 - Seth Rollins killed The Undertaker using C4\n");
		sb.append("08/09/2016 11:16:17 - <WORLD> killed Dean Ambrose using AK 47\n");
		sb.append("08/09/2016 11:17:17 - Dean Ambrose killed <WORLD> using AK 47\n");
		sb.append("08/09/2016 11:19:01 - Match 52347104 has ended");
		
		return sb.toString();
	}
	
}
