package main.matchers.strings;

import java.util.ArrayList;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeMatcher;

/**
 * This class checks for a entire array to be composed only by following Strings:
 *  ¬ Active
 * 	¬ Inactive
 *  ¬ Pending
 *  
 * @author 
 * 
 */

public class StatusArrayMatcher extends TypeSafeMatcher<ArrayList<String>> {

	public void describeTo(Description arg0) {

	}

	protected boolean matchesSafely(ArrayList<String> arg0) {
		for (int i = 0; i < arg0.size(); i++) {
			try {
				String value = String.valueOf(arg0.get(i));
				if (	String.valueOf(value).equals("active")
						|| String.valueOf(value).equals("inactive")
						|| String.valueOf(value).equals("pending")
						|| String.valueOf(value).equals("expired")
						|| String.valueOf(value).equals("incomplete")
						|| String.valueOf(value).equals("start")
						|| String.valueOf(value).equals("in progress")
						|| String.valueOf(value).equals("in review")
						|| String.valueOf(value).equals("paused")
						|| String.valueOf(value).equals("cancelled")
						|| String.valueOf(value).equals("failed")
						|| String.valueOf(value).equals("completed")
						|| String.valueOf(value).equals("timeout")
						|| String.valueOf(value).equals("rejected")
						|| String.valueOf(value).equals("created")
						|| String.valueOf(value).equals("claimed")
						|| String.valueOf(value).equals("locked")) {
				} else { return false; }
			} catch (NumberFormatException e) {
				return false;
			}
		}
		return true;
	}

	@Factory
	public static StatusArrayMatcher isStatusArray() {
		return new StatusArrayMatcher();
	}
	
}
