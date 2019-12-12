#Author: arpitha.joshi@prodigylabs.net
#Keywords Summary : Identity Automation 
#Feature: QRCode
#Scenario: #NA
Feature: Loading of QR Code on DAC UI

Scenario Outline: Verify that the QR code loads on launching DAC UI
    Given User launches the application "<url>"
    And user waits for "2" seconds
    And User enters text "<Email>" in textbox "Email"
    And User clicks on button "Send_Email"
    Then validates that "QR_Code" is displayed
    
   Examples:
		| url | Phone_number | Email |
		| https://id.prodigylabs.net/ | (647) 818-8492 | arpitha.joshi@prodigylabs.net |
