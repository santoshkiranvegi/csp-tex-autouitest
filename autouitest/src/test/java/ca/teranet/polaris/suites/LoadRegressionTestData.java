package ca.teranet.polaris.suites;

import net.serenitybdd.jbehave.SerenityStories;

public class LoadRegressionTestData extends SerenityStories {

	public LoadRegressionTestData() {
		// This will only load the matched stories.
		findStoriesCalled("LoadTestData/LoadTestData.story");

	}
}
