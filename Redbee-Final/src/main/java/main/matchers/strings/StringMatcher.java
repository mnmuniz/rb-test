package main.matchers.strings;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeMatcher;
//import org.junit.Assert;

/**
 * This class checks that the field being compared to is a String
 * 
 * @author 
 * 
 */

public class StringMatcher extends TypeSafeMatcher<String> {

	public void describeTo(Description arg0) {
		
	}

	@Override
	protected boolean matchesSafely(String arg0) {
		try {
			if ("null".equalsIgnoreCase(arg0)){return true;}
			String.valueOf(arg0);
			//Assert.assertFalse("".equals(arg0));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Factory
	public static StringMatcher isString() {
		return new StringMatcher();
	}
}
