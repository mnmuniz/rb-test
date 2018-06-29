package main.matchers.strings;

import java.util.ArrayList;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeMatcher;
//import org.junit.Assert;

/**
 * This class checks for a entire array to be composed only by Strings.
 * 
 * @author 
 * 
 */

public class StringArrayMatcher extends TypeSafeMatcher<ArrayList<String>> {

	public void describeTo(Description arg0) {

	}

	protected boolean matchesSafely(ArrayList<String> arg0) {
		for (int i = 0; i < arg0.size(); i++) {
			try {
				String value = String.valueOf(arg0.get(i));
				String.valueOf(value);
				//Assert.assertFalse("".equals(value));
			} catch (NumberFormatException e) {
				return false;
			}
		}
		return true;
	}

	@Factory
	public static StringArrayMatcher isStringArray() {
		return new StringArrayMatcher();
	}
}
