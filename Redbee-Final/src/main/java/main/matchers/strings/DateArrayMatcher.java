package main.matchers.strings;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeMatcher;

/**
 * This class checks for a entire array to be composed only by valid dates.
 * 
 * @author 
 * 
 */
public class DateArrayMatcher extends TypeSafeMatcher<ArrayList<String>> {

	public void describeTo(Description arg0) {

	}

	protected boolean matchesSafely(ArrayList<String> arg0) {
		SimpleDateFormat dateFormatS = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		SimpleDateFormat dateFormatC = new SimpleDateFormat("yyyy-MM-ddzhh:mm:ss");
		SimpleDateFormat dateFormatD = new SimpleDateFormat("yyyy-MM-dd");
		
		for (int i=0; i < arg0.size(); i++) {
			String value = String.valueOf(arg0.get(i));
			try {
				dateFormatS.parse(value);
			} catch (ParseException s) {
				try{
					dateFormatC.parse(value);
				} catch (ParseException c) {
					try{
						dateFormatD.parse(value);
					} catch (ParseException d) {
						return false;
					}
				}
			}
		}
		return true;
	}

	@Factory
	public static DateArrayMatcher isDateArray() {
		return new DateArrayMatcher();
	}
	
}
