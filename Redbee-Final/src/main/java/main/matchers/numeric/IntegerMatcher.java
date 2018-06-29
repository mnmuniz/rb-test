package main.matchers.numeric;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeMatcher;

/**
 * This class checks that the field being compared to is an Integer.
 * 
 * @author 
 * 
 */

public class IntegerMatcher extends TypeSafeMatcher<Integer> {

	public void describeTo(Description arg0) {
	}

	@Override
	protected boolean matchesSafely(Integer arg0) {
		try {
			Integer.valueOf(arg0);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	@Factory
	public static IntegerMatcher isInteger() {
		return new IntegerMatcher();
	}
}
