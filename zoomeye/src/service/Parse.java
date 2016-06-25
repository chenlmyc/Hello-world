package service;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parse {
/*
 * 解析查询字符串，返回关键字
 * */ 
	public HashMap<String, String> getToken(String searchText){
		HashMap<String, String> map = new HashMap<String,String>();
		Pattern p = Pattern.compile("(\\S*):(\\S*)\\s*");
		 
		Matcher m = p.matcher(searchText);

		while (m.find()){
			System.out.println("第二个token:"+m.group(2));
			map.put(m.group(1), m.group(2));
		}
		return map;
	}
}
