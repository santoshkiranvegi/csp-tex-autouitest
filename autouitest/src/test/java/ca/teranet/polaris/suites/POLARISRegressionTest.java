package ca.teranet.polaris.suites;

import org.jbehave.core.annotations.BeforeStories;

import net.serenitybdd.jbehave.SerenityStories;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class POLARISRegressionTest extends SerenityStories {

	@BeforeStories
	public void Setup() {
		System.out.println("Before Stories, LROAdmin Regression Test Suite");
	}

	public POLARISRegressionTest() {
		// This will only load the matched stories.
		EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
		String story_name = variables.getProperty("test.story.name");
		// String story_name = "login";
		findStoriesCalled("POLARIS_regression/" + story_name + ".story");
	}
}
