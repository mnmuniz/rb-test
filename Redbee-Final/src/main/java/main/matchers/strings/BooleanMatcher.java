package main.matchers.strings;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeMatcher;

/**
 * This class checks that the field being compared to is only true or false.
 * 
 * @author 
 * 
 */

public class BooleanMatcher extends TypeSafeMatcher<String> {

	public void describeTo(Description arg0) {

	}

	@Override
	protected boolean matchesSafely(String arg0) {
		try {
			if ( arg0.equalsIgnoreCase("true") || arg0.equalsIgnoreCase("false") || arg0.getClass().equals("Boolean") ) {
				String.valueOf(arg0);
				return true;
			} else { return false; }
			
		} catch (Exception e) {
			return false;
		}
	}

	@Factory
	public static BooleanMatcher isBoolean() {
		return new BooleanMatcher();
	}
	
}
