package main.utils;

import java.util.Random;

public class NamingConventions {
	
	public String nameTimestamp = new DateGetters().getDate(0, "yyyy-MM-dd'T'HH:mm:ss:SS");
	Random rand = new Random();
	
	public String convName(String entityAbbr){
		return entityAbbr+"@"+nameTimestamp+rand.nextInt(999);
	}
	
	public String updateName(String oldName){
		return oldName.substring(0,oldName.indexOf('@')-1) + "mod" + oldName.substring(oldName.indexOf('@')+1,oldName.length());
	}
	
}
