package main.matchers.strings;

import java.util.ArrayList;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeMatcher;

/**
 * This class checks for a entire array to be composed only by valid mails.
 * 
 * @author 
 * 
 */
public class EmailArrayMatcher extends TypeSafeMatcher<ArrayList<String>> {
	
	public void describeTo(Description arg0) {

	}

	protected boolean matchesSafely(ArrayList<String> arg0) {
		for (int i = 0; i < arg0.size(); i++) {
			try {
				String value = String.valueOf(arg0.get(i));
				// Hardcode made for some invalid data on production select * from li_user where email not like '%@%';
				if ( (value.contains("@") && value.contains(".")) || (value.equals("test")) ) {
				} else { return false; }
			} catch (NumberFormatException e) {
				return false;
			}
		}
		return true;
	}

	@Factory
	public static EmailArrayMatcher isEmailArray() {
		return new EmailArrayMatcher();
	}

}
