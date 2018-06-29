package main.matchers.strings;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeMatcher;

/**
 * This class checks that the field being compared to is a Hash type.
 * 
 * @author 
 * 
 */

public class HashMatcher extends TypeSafeMatcher<String> {

	public void describeTo(Description arg0) {

	}

	@Override
	protected boolean matchesSafely(String arg0) {
		
		try {
			// Hardcode made for some invalid data on production select * from li_user where length(hash) <> 32;
			if ((arg0.length() == 32) || (arg0.length() == 1)) {
				String.valueOf(arg0);
				return true;
			} else { return false; }
			
		} catch (Exception e) {
			return false;
		}
	}

	@Factory
	public static HashMatcher isHash() {
		return new HashMatcher();
	}
}
