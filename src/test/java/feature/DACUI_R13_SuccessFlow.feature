#Author: arpitha.joshi@prodigylabs.net
#Keywords Summary : Identity Automation 
#Feature: QRCode
#Scenario: #NA
Feature: DACUI R13 flow

@Smoke @Regression @TC007
Scenario Outline: Verify that a user with existing lockbox with R13 web is able to share the data
    Given User launches the application "<url>"
    And User clicks on button "VerifiedMeLink"
    And User clicks on button "MyBankLink"
    And User enters text "<Username>" in textbox "MyBank_Username"
    And User enters text "<Password>" in textbox "MyBank_password"
    And User clicks on button "MyBank_SignIn"
    And User clicks on button "Verification_Ok"
    And User clicks on button "IdentityProfile_Ok"
    And user waits for "2" seconds
    And User clicks on button "LicenseButton_Agree"
    And validates that "Success_Message" is displayed
    And User clicks on button "Exit_Link"
    Then validates that "VerifiedMelink" is displayed
    
    
    
   Examples:
		| url | Username | Password |
		| https://dev.id.prodigylabs.net/ | arpitha.joshi@prodigylabs.net | password |
