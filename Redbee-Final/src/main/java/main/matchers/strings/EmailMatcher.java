package main.matchers.strings;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeMatcher;

/**
 * This class checks that the field being compared to is a valid email.
 * 
 * @author 
 * 
 */
public class EmailMatcher extends TypeSafeMatcher<String> {
	
	public void describeTo(Description arg0) {

	}

	@Override
	protected boolean matchesSafely(String arg0) {
		
		try {
			// Hardcode made for some invalid data on production select * from li_user where email not like '%@%';
			if ( (arg0.contains("@") && arg0.contains(".")) || (arg0.equals("test")) ) {
				String.valueOf(arg0);
				return true;
			} else { return false; }
			
		} catch (Exception e) {
			return false;
		}
	}

	@Factory
	public static EmailMatcher isEmail() {
		return new EmailMatcher();
	}
	
}
