Feature: 6thStreet.com -  Header, Footer Validation

	@Footer
	Scenario Outline: TS_FooterLinkValidation_01 - Verify the whether footer links lead to respective pages
		When User clicks on footer link "<FooterLink>"
		Then User should be landed into "<PageName>" web page	
		
		Examples:
		|FooterLink    |PageName|
		|ConsumerRights|ConsumerRights|
		|About6thStreet|About6thStreet|
		|Disclaimer    |Disclaimer    |
		|PrivacyPolicy |PrivacyPolicy |
		|ShippingInfo  |ShippingPolicy|
		|ReturnInfo    |ReturnInfo    |
		|OrderTrack    |OrderTracking |
		|FAQs          |FAQs          |
		|Feedback      |Feedback      |