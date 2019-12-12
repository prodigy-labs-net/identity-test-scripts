package stepDefinations;

import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import IdentityTestFramework.ObjectRepository;
import handlers.VerificationHandler;

public class DACUI {
	
String sName = null;
	
	private IDENTITYBaseTest identitybasetest;
	
	public DACUI(IDENTITYBaseTest identitybasetest) {  
		
		this.identitybasetest=identitybasetest;
	}
	
	//@Before()
	public void setup(Scenario scenario) throws Exception {		
		System.out.println("Executing Before of Step Defination");
		sName=scenario.getName();
	}
	
	 @After()
	public void tearDown() throws Exception {		
		System.out.println("Executing After of Step Defination");
        //Reporter.addScreenCaptureFromPath(identitybasetest.screenshot.captureScreenShot(sName));  
		identitybasetest.driver.quit();
	}
	
	@Given("^User launches the application \"([^\"]*)\"$")
	public void user_launches_the_application(String url) throws Throwable {
		identitybasetest.driver.get(url);
	    //Reporter.addScreenCaptureFromPath(identitybasetest.screenshot.captureScreenShot(sName));  
	}

	@Then("^User enters text \"([^\"]*)\" in textbox \"([^\"]*)\"$")
	public void user_enters_text_in_textbox(String arg1, String arg2) throws Throwable {
		identitybasetest.webelementHandler.enterText(ObjectRepository.getobjectLocator(arg2), arg1);
		//Reporter.addScreenCaptureFromPath(identitybasetest.screenshot.captureScreenShot(sName));
	}

	@Given("^User clicks on button \"([^\"]*)\"$")
	public void user_clicks_on_button(String arg1) throws Throwable {
		//if (arg1.equals("Printed_Signed")) {
		//	System.out.println(identitybasetest.webelementHandler.getText("//tr[contains(@id,'documentSigning-table-rows')]"));}
		identitybasetest.webelementHandler.clickButton(ObjectRepository.getobjectLocator(arg1));
       // Reporter.addScreenCaptureFromPath(identitybasetest.screenshot.captureScreenShot(sName));  
	}
	
	@Given("^user validates \"([^\"]*)\" with expected value \"([^\"]*)\"$")
	public void user_validates_with_expected_value(String arg1, String arg2) throws Throwable {
		System.err.println(identitybasetest.webelementHandler.getText(ObjectRepository.getobjectLocator(arg1)));
		VerificationHandler.verifyTrue(identitybasetest.webelementHandler.getText(ObjectRepository.getobjectLocator(arg1)).contains(arg2));
		//Reporter.addScreenCaptureFromPath(identitybasetest.screenshot.captureScreenShot(sName));  
	}
	
	@Then("^validates that \"([^\"]*)\" is displayed$")
	public void user_validates_that_is_displayed(String element) throws Throwable {
		Thread.sleep(2000);
		VerificationHandler.verifyTrue(identitybasetest.webelementHandler.isDisplayed(ObjectRepository.getString(element)));
		//Reporter.addScreenCaptureFromPath(identitybasetest.screenshot.captureScreenShot(sName)); 
	}
		
	
	@Given("^user waits for page to load$")
	public void user_waits_for_page_to_load() throws Throwable {
		identitybasetest.webelementHandler.waitforinvisibilityofAllElements(ObjectRepository.getobjectLocator("Spinner"));
		identitybasetest.webelementHandler.waitforinvisibilityofAllElements(ObjectRepository.getobjectLocator("Spinner1"));
		Reporter.addScreenCaptureFromPath(identitybasetest.screenshot.captureScreenShot(sName)); 
		}
	
	
    @Given("^user waits for \"(.*?)\" seconds$")
    public void user_waits_for_seconds(long arg1) throws Throwable 
    {
       arg1 = arg1*1000;
    	Thread.sleep(arg1);
		//Reporter.addScreenCaptureFromPath(identitybasetest.screenshot.captureScreenShot(sName));  
    } 
    
	
	
}
