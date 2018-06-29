package main.matchers.numeric;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeMatcher;

/**
 * This class checks that the field being compared to is a float number.
 * 
 * @author 
 * 
 */
public class FloatMatcher extends TypeSafeMatcher<Float> {

	public void describeTo(Description arg0) {
	}

	@Override
	protected boolean matchesSafely(Float arg0) {
		try {
			Float.valueOf(arg0);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	@Factory
	public static FloatMatcher isFloat() {
		return new FloatMatcher();
	}
	
}
