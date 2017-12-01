package calendar;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CalendarTest {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(1409472984000L);
		System.out.println(String.format("%02d", c.get(Calendar.MONTH)));
		
		long startMills = new Date(2014-1900, 1, 1).getTime();
		long endMills = new Date(2015-1900, 11, 1).getTime();
		String[] indicies = new String[] {"aa-*"};
		
		List<String> indexList = new ArrayList<>();
		Calendar temp = Calendar.getInstance();
		temp.setTimeInMillis(startMills);
		int startYear = temp.get(Calendar.YEAR);
		int startMonth = temp.get(Calendar.MONTH) + 1;
		temp.setTimeInMillis(endMills);
		int endYear = temp.get(Calendar.YEAR);
		int endMonth = temp.get(Calendar.MONTH) + 1;
		int intevalYear = endYear - startYear;
		for(String idx : indicies) {
			if(intevalYear == 0){
				if(startMonth == 1 && endMonth == 12) {
					indexList.add(idx.replace("*", startYear + ".*"));
				}else {
					for(int month = startMonth; month <= endMonth; month++) {
						indexList.add(idx.replace("*", startYear + "." + String.format("%02d", month)));
					}
				}
			}else if(intevalYear >= 1) {
				//处理起始年月
				if(startMonth == 1) {
					indexList.add(idx.replace("*", startYear + ".*"));
				}else {
					for(int month = startMonth; month <= 12; month++) {
						indexList.add(idx.replace("*", startYear + "." + String.format("%02d", month)));
					}
				}
				//处理中间年
				for(int year = startYear + 1; year < endYear; year ++) {
					indexList.add(idx.replace("*", year + ".*"));
				}
				//处理结束年月
				if(endMonth == 12) {
					indexList.add(idx.replace("*", endYear + ".*"));
				}else {
					for(int month = 1; month <= endMonth; month++) {
						indexList.add(idx.replace("*", endYear + "." + String.format("%02d", month)));
					}
				}
			}
		}
		if(indexList.size() > 0) {
			System.out.println(String.join(",", indexList));
		}
	}

}
