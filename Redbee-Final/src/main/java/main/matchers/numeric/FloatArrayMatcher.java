package main.matchers.numeric;

import java.util.ArrayList;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeMatcher;

/**
 * This class checks for a entire array to be composed only by Float values.
 * 
 * @author 
 * 
 */
public class FloatArrayMatcher extends TypeSafeMatcher<ArrayList<String>> {

	public void describeTo(Description arg0) {

	}

	protected boolean matchesSafely(ArrayList<String> arg0) {
		for (int i = 0; i < arg0.size(); i++) {
			try {
				String value = String.valueOf(arg0.get(i));
				Float.valueOf(value);
			} catch (NumberFormatException e) {
				return false;
			}
		}
		return true;
	}

	@Factory
	public static FloatArrayMatcher isFloatArray() {
		return new FloatArrayMatcher();
	}
	
}
