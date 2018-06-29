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

public class DoubleMatcher extends TypeSafeMatcher<Double> {

	public void describeTo(Description arg0) {

	}

	@Override
	protected boolean matchesSafely(Double arg0) {
		try {
			Double.valueOf(arg0);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	@Factory
	public static DoubleMatcher isDouble() {
		return new DoubleMatcher();
	}
}
