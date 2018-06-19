package com.PFM.Actual.HRM.Intemediate;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.PFM.Actual.HRM.Base.BaseTest;

public class PIMPage extends BaseTest {

	@FindBy(id="menu_pim_Configuration")
	WebElement configurationDropdown;
		
	@FindBy(id="menu_pim_configurePim")
	WebElement optionalFields;
	
	@FindBy(id="menu_pim_listCustomFields")
	WebElement customFields;
	
	@FindBy(id="menu_admin_pimCsvImport")
	WebElement dataImport;
	
	@FindBy(id="menu_pim_viewReportingMethods")
	WebElement reportingMethods;
	
	@FindBy(id="menu_pim_viewTerminationReasons")
	WebElement terminationReasons;
}
