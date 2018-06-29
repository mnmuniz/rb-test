package main.matchers.strings;

import java.util.ArrayList;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeMatcher;

/**
 * This class checks for a entire array to be composed only by true or false values.
 * 
 * @author 
 * 
 */

public class BooleanArrayMatcher extends TypeSafeMatcher<ArrayList<String>> {

	public void describeTo(Description arg0) {

	}

	protected boolean matchesSafely(ArrayList<String> arg0) {
		for (int i = 0; i < arg0.size(); i++) {
			try {
				String value = String.valueOf(arg0.get(i));
				if ( value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false") || "null".equalsIgnoreCase(value) ) {
				} else { return false; }
			} catch (NumberFormatException e) {
				return false;
			}
		}
		return true;
	}

	@Factory
	public static BooleanArrayMatcher isBooleanArray() {
		return new BooleanArrayMatcher();
	}
	
}
