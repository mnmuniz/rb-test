package main.matchers.numeric;

import java.util.ArrayList;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeMatcher;

/**
 * This class checks that the field being compared to is an Integer.
 * 
 * @author 
 * 
 */

public class DoubleArrayMatcher extends TypeSafeMatcher<ArrayList<Double>> {

	public void describeTo(Description arg0) {

	}

	@Override
	protected boolean matchesSafely(ArrayList<Double> arg0) {
		for (int i = 0; i < arg0.size(); i++) {
			try {
				String value = String.valueOf(arg0.get(i));
				Integer.valueOf(value);
			} catch (NumberFormatException e) {
				return false;
			}
		}
		return true;
	}

	@Factory
	public static DoubleArrayMatcher isDoubleArray() {
		return new DoubleArrayMatcher();
	}
}
