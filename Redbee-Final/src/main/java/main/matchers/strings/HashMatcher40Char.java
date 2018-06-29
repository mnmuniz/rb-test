package main.matchers.strings;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeMatcher;

/**
 * This class checks that the field being compared to is a Hash type of 40 characters
 * 
 * @author 
 * 
 */
public class HashMatcher40Char extends TypeSafeMatcher<String> {
	
	public void describeTo(Description arg0) {

	}

	@Override
	protected boolean matchesSafely(String arg0) {
		
		try {
			if ((arg0.length() == 40)) {
				String.valueOf(arg0);
				return true;
			} else { return false; }
			
		} catch (Exception e) {
			return false;
		}
	}

	@Factory
	public static HashMatcher40Char isHash40Chr() {
		return new HashMatcher40Char();
	}
	
}
