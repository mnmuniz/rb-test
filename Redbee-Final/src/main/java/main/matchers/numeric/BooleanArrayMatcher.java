package main.matchers.numeric;

import java.util.ArrayList;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeMatcher;

/**
 * This class checks that the compared item is either 1 or 0.
 * 
 * @author 
 * 
 */

public class BooleanArrayMatcher extends TypeSafeMatcher<ArrayList<Integer>> {

	public void describeTo(Description arg0) {

	}

	@Override
	protected boolean matchesSafely(ArrayList<Integer> arg0) {
		for (int i = 0; i < arg0.size(); i++) {
			try {
				String value = String.valueOf(arg0.get(i));
				if (Integer.valueOf(value).equals("0")
						|| Integer.valueOf(value).equals("1"));
			} catch (NumberFormatException e) {
				return false;
			}
		}
		return true;
	}

	@Factory
	public static BooleanArrayMatcher isNumericBooleanArray() {
		return new BooleanArrayMatcher();
	}
}
