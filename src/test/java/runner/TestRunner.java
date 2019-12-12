package runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import IdentityTestFramework.ObjectRepository;

import com.cucumber.listener.Reporter;

@RunWith(Cucumber.class)
@CucumberOptions(		
 features = {"src/test/java/features/QRCode.feature"},
 glue= "stepDefinations",
 plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/IdentityTestAutomation.html"},
 monochrome = true,
 dryRun = false)

public class TestRunner {
	
	@BeforeClass
	public static void setup() {		
		System.out.println("Executing Before of TestRunner");
	}
			
	@AfterClass
	public static void tearDown() {
		System.out.println("Executing After of TestRunner");
		Reporter.loadXMLConfig(new File("src/main/resources/extent-config.xml"));
	     Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
	     Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	     Reporter.setSystemInfo("Machine", ObjectRepository.getString("global.browser.capability.platform"));
	     Reporter.setSystemInfo("Machine", ObjectRepository.getString("global.browser.name"));
	     Reporter.setSystemInfo("Machine", ObjectRepository.getString("global.environment.name"));
	}

}
