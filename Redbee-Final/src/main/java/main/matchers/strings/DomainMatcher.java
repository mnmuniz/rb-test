package main.matchers.strings;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeMatcher;

/**
 * This class checks that the field being compared to is a valid domain.
 * 
 * @author 
 * 
 */

public class DomainMatcher extends TypeSafeMatcher<String> {

	public void describeTo(Description arg0) {

	}

	@Override
	protected boolean matchesSafely(String arg0) {
		
		try {
			if ( arg0.contains(".") || "null".equalsIgnoreCase(arg0) ) {
				String.valueOf(arg0);
				return true;
			} else { return false; }
			
		} catch (Exception e) {
			return false;
		}
	}

	@Factory
	public static DomainMatcher isDomain() {
		return new DomainMatcher();
	}
	
}
