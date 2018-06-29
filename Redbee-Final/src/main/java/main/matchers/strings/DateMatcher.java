package main.matchers.strings;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeMatcher;

/**
 * This class checks that the field being compared to is a valid date.
 * 
 * @author 
 * 
 */
public class DateMatcher extends TypeSafeMatcher<String> {

	public void describeTo(Description arg0) {

	}

	@Override
	protected boolean matchesSafely(String arg0) {
		SimpleDateFormat dateFormatS = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		SimpleDateFormat dateFormatC = new SimpleDateFormat("yyyy-MM-ddzhh:mm:ss");
		SimpleDateFormat dateFormatD = new SimpleDateFormat("yyyy-MM-dd");
		try {
			dateFormatS.parse(arg0);
			return true;
		} catch (ParseException s) {
			try {
				dateFormatC.parse(arg0);
				return true;
			} catch (ParseException c) {
				try{
					String value = String.valueOf(arg0);
					dateFormatD.parse(value);
					return true;
				} catch (ParseException d) {
					return false;
				}
			}
		}
	}

	@Factory
	public static DateMatcher isDate() {
		return new DateMatcher();
	}
	
}
