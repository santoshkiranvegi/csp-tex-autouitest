package ca.teranet.polaris.steps;

import org.jbehave.core.annotations.When;

import ca.teranet.polaris.util.Utility;

public class ServiceSteps extends Utility {
	// Utility utility;

	@When("user copies column data from source and paste it in target $SOURCE1 and $TARGET1")
	public boolean Service_CopyColumn(String source, String target) {
		try {
			return CopyColumn(source, target);
		} catch (NullPointerException e) {

		}
		return false;
	}
}
