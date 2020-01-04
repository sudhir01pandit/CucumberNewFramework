package stepDefinations;

import com.qa.util.Testbase;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends Testbase {
	
	@Before
    public void setup() {
		
		Testbase.initializeDriver();
	}

	@After
	public void tearDown() {
		
		driver.quit();
	}
}
