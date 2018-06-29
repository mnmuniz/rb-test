package main.matchers.numeric;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeMatcher;

/**
 * This class checks that the compared item is either 1 or 0.
 * 
 * @author 
 * 
 */

public class BooleanMatcher extends TypeSafeMatcher<Integer> {

	public void describeTo(Description arg0) {

	}

	@Override
	protected boolean matchesSafely(Integer arg0) {
		try {
			if (Integer.valueOf(arg0).equals("1") || Integer.valueOf(arg0).equals("1"));
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	@Factory
	public static BooleanMatcher isNumericBoolean() {
		return new BooleanMatcher();
	}
}
