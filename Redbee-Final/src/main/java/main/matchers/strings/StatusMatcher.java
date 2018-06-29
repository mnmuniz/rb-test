package main.matchers.strings;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeMatcher;

/**
 * This class checks if the answer is eihter one of the following statuses:
 *  ¬ Active
 * 	¬ Inactive
 *  ¬ Pending
 *  
 * @author 
 * 
 */

public class StatusMatcher extends TypeSafeMatcher<String> {

	public void describeTo(Description arg0) {

	}

	@Override
	protected boolean matchesSafely(String arg0) {
		try {
			if (	String.valueOf(arg0).equals("active")
					|| String.valueOf(arg0).equals("inactive")
					|| String.valueOf(arg0).equals("pending")
					|| String.valueOf(arg0).equals("deleted")
					|| String.valueOf(arg0).equals("expired")
					|| String.valueOf(arg0).equals("incomplete")
					|| String.valueOf(arg0).equals("start")
					|| String.valueOf(arg0).equals("in progress")
					|| String.valueOf(arg0).equals("in review")
					|| String.valueOf(arg0).equals("paused")
					|| String.valueOf(arg0).equals("cancelled")
					|| String.valueOf(arg0).equals("failed")
					|| String.valueOf(arg0).equals("completed")
					|| String.valueOf(arg0).equals("timeout")
					|| String.valueOf(arg0).equals("rejected")
					|| String.valueOf(arg0).equals("created")
					|| String.valueOf(arg0).equals("claimed")
					|| String.valueOf(arg0).equals("locked")) {
				return true;
			} else { return false; }
			
		} catch (Exception e) {
			return false;
		}
	}

	@Factory
	public static StatusMatcher isStatus() {
		return new StatusMatcher();
	}
}
