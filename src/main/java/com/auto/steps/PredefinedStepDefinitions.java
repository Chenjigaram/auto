package com.auto.steps;

import java.io.IOException;
import java.lang.invoke.MethodHandles;

import com.auto.methods.BaseTest;
import com.auto.methods.SavingElementsMethods;
import com.auto.methods.TestCaseFailed;
import com.auto.utilities.*;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;

public class PredefinedStepDefinitions implements BaseTest, WebDriverFactoryConstants {
	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	protected WebDriver driver = DriverUtil.getDefaultDriver();
	private static boolean cookiesAccepted = false;
	// Navigation Steps
	public Scenario scenario;

	// Step to navigate to specified URL
	@Before
	public void beforeTest(Scenario scenario) {
		System.out.println("In Before scenario " + scenario.getName());
		this.scenario = scenario;
	}

	@After
	public void afterTest(Scenario scenario) {
		System.out.println("In after scenario " + scenario.getName());
		if (scenario.isFailed()) {
			screenshotObj.addScreenshotTestreport(scenario);
		}
	}

	@When("^I navigate to \"([^\"]*)\"$")
	public void navigate_to(String link) {
		System.out.println("Navigating to link " + URLProperties.get(link));
		navigationObj.navigateTo(URLProperties.get(link));
	}


	@When("^call \"([^\"]*)\"$")
	public void call_feature(String file) throws Exception{
		executeFeatureFile.execute(file,scenario);
	}


	// Step to navigate forward
	@When("^I navigate forward")
	public void navigate_forward() {
		System.out.println("Navigating to forward ");
		navigationObj.navigate("forward");
	}

	// Step to navigate backward
	@When("^I navigate back")
	public void navigate_back() {
		System.out.println("Navigating to back ");
		navigationObj.navigate("back");
	}

	// steps to refresh page
	@When("^I refresh page$")
	public void refresh_page() {
		System.out.println("Refresh page");
		driver.navigate().refresh();
	}

	// Switch between windows

	// Switch to new window
	@When("^I switch to new window$")
	public void switch_to_new_window() {
		System.out.println("switch to new window");
		navigationObj.switchToNewWindow();
	}

	// Switch to old window
	@When("^I switch to previous window$")
	public void switch_to_old_window() {
		System.out.println("switch to previous window");
		navigationObj.switchToOldWindow();
	}

	// Switch to new window by window title
	@When("^I switch to window having title \"(.*?)\"$")
	public void switch_to_window_by_title(String windowTitle) throws Exception {
		System.out.println("witch to window having title " + windowTitle);
		navigationObj.switchToWindowByTitle(windowTitle);
	}

	// Close new window
	@When("^I close new window$")
	public void close_new_window() {
		System.out.println("close new window");
		navigationObj.closeNewWindow();
	}

	// Switch between frame

	// Step to switch to frame by web element
	@When("^I switch to frame having (.+) \"(.*?)\"$")
	public void switch_frame_by_element(String method, String value) {
		System.out.println("switch to frame having " + method + " value :" + value);
		navigationObj.switchFrame(method, value);
	}

	// step to switch to main content
	@When("^I switch to main content$")
	public void switch_to_default_content() {
		System.out.println("switch to main content");
		navigationObj.switchToDefaultContent();
	}

	// To interact with browser

	// step to resize browser
	@When("^I resize browser window size to width (\\d+) and height (\\d+)$")
	public void resize_browser(int width, int heigth) {
		System.out.println(" resize browser window size to width " + width + " and height " + heigth);
		navigationObj.resizeBrowser(width, heigth);
	}

	// step to maximize browser
	@When("^I maximize browser window$")
	public void maximize_browser() {
		System.out.println(" maximize browser window");
		navigationObj.maximizeBrowser();
	}

	// Step to close the browser
	@When("^I close browser$")
	public void close_browser() {
		System.out.println("close browser");
		navigationObj.closeDriver();
	}

	// zoom in/out page

	// steps to zoom in page
	@When("^I zoom in page$")
	public void zoom_in() {
		System.out.println("zoom in page");
		navigationObj.zoomInOut("ADD");
	}

	// steps to zoom out page
	@When("^I zoom out page$")
	public void zoom_out() {
		System.out.println("zoom out page");
		navigationObj.zoomInOut("SUBTRACT");
	}

	@When("^I am on the \"(.*?)\" page$")
	public void navigate_to_url(String url) {
		System.out.println(url);
		navigationObj.navigateTo(URLProperties.get(url));
	}
	// zoom out webpage till necessary element displays

	// steps to zoom out till element displays
	@When("^I zoom out page till I see element having \"(.*?)\"$")
	public void zoom_till_element_display(String accessName) throws Exception {
		String[] keyAccess = miscmethodObj.splitAndGet(accessName);
		System.out.println("zoom out page till I see element having " + keyAccess[0] + " value :" + keyAccess[1]);
		miscmethodObj.validateLocator(keyAccess[0]);
		navigationObj.zoomInOutTillElementDisplay(keyAccess[0], "substract", keyAccess[1]);
	}

	// reset webpage view use

	@When("^I reset page view$")
	public void reset_page_zoom() {
		System.out.println("reset page view");
		navigationObj.zoomInOut("reset");
	}

	// scroll webpage

	@When("^I scroll to (top|end) of page$")
	public void scroll_page(String to) throws Exception {
		System.out.println("scroll to " + to + " of page");
		navigationObj.scrollPage(to);
	}

	// scroll webpage to specific element

	@When("^I scroll to element having \"(.*?)\"$")
	public void scroll_to_element(String accessName) throws Exception {
		String[] keyAccess = miscmethodObj.splitAndGet(accessName);
		System.out.println("scroll to element having " + keyAccess[0] + " value :" + keyAccess[1]);
		miscmethodObj.validateLocator(keyAccess[0]);
		navigationObj.scrollToElement(keyAccess[0], keyAccess[1]);
	}

	// hover over element

	// Note: Doesn't work on Windows firefox
	@When("^I hover over element having \"(.*?)\"$")
	public void hover_over_element(String accessName) throws Exception {
		String[] keyAccess = miscmethodObj.splitAndGet(accessName);
		System.out.println("hover over element having  " + keyAccess[0] + " value :" + keyAccess[1]);
		miscmethodObj.validateLocator(keyAccess[0]);
		navigationObj.hoverOverElement(keyAccess[0], keyAccess[1]);
	}
	// verifying steps and storing

	// step to store element text
	@When("^element having \"([^\"]*)\" text stored to key \"([^\"]*)\"$")
	public void store_element_text(String accessName, String key) throws Exception {
		String[] keyAccess = miscmethodObj.splitAndGet(accessName);
		System.out.println("element having with " + keyAccess[0] + "  " + keyAccess[0] + " and Store to key " + key);
		miscmethodObj.validateLocator(keyAccess[0]);
		assertionObj.saveElementText(keyAccess[0], keyAccess[1], key);
	}

	@When("^element having \"([^\"]*)\" should\\s*((?:not)?)\\s+have text as key \"([^\"]*)\"$")
	public void verify_element_text_key(String accessName, String present, String key) throws Exception {
		String[] keyAccess = miscmethodObj.splitAndGet(accessName);
		System.out.println("element having with " + keyAccess[0] + "  " + keyAccess[1] + " text same as key " + key
				+ " and equals " + present.isEmpty());
		miscmethodObj.validateLocator(keyAccess[0]);
		assertionObj.verifyElementTextToKey(present.isEmpty(), keyAccess[0], keyAccess[1], key);
	}

	@When("^element having \"([^\"]*)\" attribute \"(.*?)\" text stored to key \"([^\"]*)\"$")
	public void store_element_text_attribute(String accessName, String attribute, String key) throws Exception {
		String[] keyAccess = miscmethodObj.splitAndGet(accessName);
		System.out.println("element having with " + keyAccess[0] + "  " + keyAccess[1] + " and Store to key " + key);
		miscmethodObj.validateLocator(keyAccess[0]);
		assertionObj.saveElementTextAttribute(keyAccess[0], keyAccess[1], key, attribute);
	}

	@When("^element having \"([^\"]*)\" attribute \"(.*?)\" should\\s*((?:not)?)\\s+have text as key \"([^\"]*)\"$")
	public void verify_element_text_key_attribute(String accessName, String attribute, String present, String key)
			throws Exception {
		String[] keyAccess = miscmethodObj.splitAndGet(accessName);
		System.out.println("element having with " + keyAccess[0] + "  " + keyAccess[1] + " text same as key " + key
				+ " and equals " + present.isEmpty());
		miscmethodObj.validateLocator(keyAccess[0]);
		assertionObj.verifyElementTextAttributeToKey(present.isEmpty(), keyAccess[0], keyAccess[1], key, attribute);
	}

	// step to store element text
	@When("^store key \"([^\"]*)\" stored to text \"([^\"]*)\"$")
	public void storing_text(String key, String value) throws Exception {
		System.out.println("store key " + key + "with " + value);
		SavingElementsMethods.putValue(key, value);
	}

	// step to store element text
	@When("^verify key \"([^\"]*)\" should\\s*((?:not)?)\\s+have text \"([^\"]*)\"$")
	public void verify_key_text(String key, String present, String value) throws Exception {
		System.out.println("verify key " + key + "with text" + value + " equals to be " + present.isEmpty());
		assertionObj.verifyTwoTextGiven(present.isEmpty(), key, value);
	}

	// step to store element text
	@When("^verify key \"([^\"]*)\" should\\s*((?:not)?)\\s+have same as key \"([^\"]*)\"$")
	public void verify_key_key(String key1, String present, String key2) throws Exception {
		System.out.println("verify key1 " + key1 + "with key2" + key2 + " equals to be " + present.isEmpty());
		assertionObj.verifyTwoTexts(present.isEmpty(), key1, key2);
	}

	@When("^clear all saved values$")
	public void clearSavedValues() throws Exception {
		System.out.println("clear all saved values");
		SavingElementsMethods.emptySaved();
	}

	@When("^print all saved values$")
	public void printSavedValues() throws Exception {
		System.out.println("print all saved values");
		SavingElementsMethods.printAll();
	}

	// Assertion steps
	@When("^I should\\s*((?:not)?)\\s+see page title as \"(.+)\"$")
	public void check_title(String present, String title) throws TestCaseFailed {
		System.out.println("checking pageTitle with " + title);
		assertionObj.checkTitle(title, present.isEmpty());
	}

	// step to check element partial text
	@When("^I should\\s*((?:not)?)\\s+see page title having partial text as \"(.*?)\"$")
	public void check_partial_text(String present, String partialTextTitle) throws TestCaseFailed {
		System.out.println("checking partial with " + partialTextTitle);
		assertionObj.checkPartialTitle(partialTextTitle, present.isEmpty());
	}

	// step to check element text
	@When("^element having \"([^\"]*)\" should\\s*((?:not)?)\\s+have text as \"(.*?)\"$")
	public void check_element_text(String accessName, String present, String value) throws Exception {
		String[] keyAccess = miscmethodObj.splitAndGet(accessName);
		System.out.println("Checking for element having text " + value + "with " + keyAccess[0] + "  " + keyAccess[1]);
		miscmethodObj.validateLocator(keyAccess[0]);
		assertionObj.checkElementText(keyAccess[0], value, keyAccess[1], present.isEmpty());
	}

	// step to check element partial text
	@When("^element having \"([^\"]*)\" should\\s*((?:not)?)\\s+have partial text as \"(.*?)\"$")
	public void check_element_partial_text(String accessName, String present, String value) throws Exception {
		String[] keyAccess = miscmethodObj.splitAndGet(accessName);
		System.out.println(
				"Checking for element having partial text " + value + "with " + keyAccess[0] + "  " + keyAccess[1]);
		miscmethodObj.validateLocator(keyAccess[0]);
		assertionObj.checkElementPartialText(keyAccess[0], value, keyAccess[1], present.isEmpty());
	}

	// step to check attribute value
	@When("^element having \"([^\"]*)\" should\\s*((?:not)?)\\s+have attribute \"(.*?)\" with value \"(.*?)\"$")
	public void check_element_attribute(String accessName, String present, String attrb, String value)
			throws Exception {
		String[] keyAccess = miscmethodObj.splitAndGet(accessName);
		System.out.println(
				"Checking for element having attribute " + value + "with " + keyAccess[0] + "  " + keyAccess[1]);
		miscmethodObj.validateLocator(keyAccess[0]);
		assertionObj.checkElementAttribute(keyAccess[0], attrb, value, keyAccess[1], present.isEmpty());
	}

	// step to check element enabled or not
	@When("^element having \"([^\"]*)\" should\\s*((?:not)?)\\s+be (enabled|disabled)$")
	public void check_element_enable(String accessName, String present, String state) throws Exception {
		String[] keyAccess = miscmethodObj.splitAndGet(accessName);
		System.out.println("element having " + keyAccess[0] + " accessName " + keyAccess[1] + " should " + present
				+ " state " + state);
		miscmethodObj.validateLocator(keyAccess[0]);
		boolean flag = state.equals("enabled");
		if (!present.isEmpty()) {
			flag = !flag;
		}
		assertionObj.checkElementEnable(keyAccess[0], keyAccess[1], flag);
	}

	// step to check element present or not
	@When("^element having \"(.*?)\" should\\s*((?:not)?)\\s+be present$")
	public void check_element_presence_(String accessName, String present) throws Exception {
		String[] keyAccess = miscmethodObj.splitAndGet(accessName);
		System.out.println(
				"Checking for element presence " + present.isEmpty() + "with " + keyAccess[0] + "  " + keyAccess[1]);
		miscmethodObj.validateLocator(keyAccess[0]);
		assertionObj.checkElementPresence(keyAccess[0], keyAccess[1], present.isEmpty());
	}

	// step to assert checkbox is checked or unchecked
	@When("^checkbox having \"(.*?)\" should be (checked|unchecked)$")
	public void is_checkbox_checked(String accessName, String state) throws Exception {
		String[] keyAccess = miscmethodObj.splitAndGet(accessName);
		System.out.println("Checking for check box to be " + state + "with " + keyAccess[0] + "  " + keyAccess[1]);
		miscmethodObj.validateLocator(keyAccess[0]);
		boolean flag = state.equals("checked");
		assertionObj.isCheckboxChecked(keyAccess[0], keyAccess[1], flag);
	}

	// steps to assert radio button checked or unchecked
	@When("^radio button having \"(.*?)\" should be (selected|unselected)$")
	public void is_radio_button_selected(String accessName, String state) throws Exception {
		String[] keyAccess = miscmethodObj.splitAndGet(accessName);
		System.out.println("radio button to be " + state + "with " + keyAccess[0] + "  " + keyAccess[1]);
		miscmethodObj.validateLocator(keyAccess[0]);
		boolean flag = state.equals("selected");
		assertionObj.isRadioButtonSelected(keyAccess[0], accessName, flag);
	}

	// steps to assert option by text from radio button group selected/unselected
	@When("^option \"(.*?)\" by (.+) from radio button group having \"(.*?)\" should be (selected|unselected)$")
	public void is_option_from_radio_button_group_selected(String option, String attrb, String accessName, String state)
			throws Exception {
		String[] keyAccess = miscmethodObj.splitAndGet(accessName);
		System.out.println("option from radio button to be " + state + " with " + keyAccess[0] + " " + keyAccess[1]);
		miscmethodObj.validateLocator(keyAccess[0]);
		boolean flag = state.equals("selected");
		assertionObj.isOptionFromRadioButtonGroupSelected(keyAccess[0], attrb, option, accessName, flag);
	}

	// steps to check link presence
	@When("^link having text \"(.*?)\" should\\s*((?:not)?)\\s+be present$")
	public void check_element_presence(String accessName, String present) throws TestCaseFailed, Exception {
		System.out.println("link having text to be " + present + " with " + ElementsProperties.get(accessName));
		assertionObj.checkElementPresence("linkText", accessName, present.isEmpty());
	}

	// steps to check partail link presence
	@When("^link having partial text \"(.*?)\" should\\s*((?:not)?)\\s+be present$")
	public void check_partial_element_presence(String accessName, String present) throws TestCaseFailed, Exception {
		System.out.println("link having text to be " + present.isEmpty() + " with " + ElementsProperties.get(accessName));
		assertionObj.checkElementPresence("partialLinkText", accessName, present.isEmpty());
	}

	// step to assert javascript pop-up alert text
	@When("^I should see alert text as \"(.*?)\"$")
	public void check_alert_text(String actualValue) throws TestCaseFailed {
		System.out.println("should see alert text as " + actualValue);
		assertionObj.checkAlertText(actualValue);
	}

	// step to select dropdown list
	@When("^option \"(.*?)\" by (.+) from dropdown having \"(.*?)\" should be (selected|unselected)$")
	public void is_option_from_dropdown_selected(String option, String by, String accessName, String state)
			throws Exception {
		String[] keyAccess = miscmethodObj.splitAndGet(accessName);
		System.out.println("option " + option + " by " + by + " from dropdown having " + keyAccess[0] + " "
				+ keyAccess[1] + " should be " + state);
		miscmethodObj.validateLocator(keyAccess[0]);
		boolean flag = state.equals("selected");
		assertionObj.isOptionFromDropdownSelected(keyAccess[0], by, option, keyAccess[1], flag);
	}

	// Input steps

	// enter text into input field steps
	@When("^I enter \"([^\"]*)\" into input field having \"([^\"]*)\"$")
	public void enter_text(String text, String accessName) throws Exception {
		String[] keyAccess = miscmethodObj.splitAndGet(accessName);
		System.out.println("enter input value" + text + " having " + keyAccess[0] + " " + keyAccess[1]);
		miscmethodObj.validateLocator(keyAccess[0]);
		inputObj.enterText(keyAccess[0], text, keyAccess[1]);
	}

	// clear input field steps
	@When("^I clear input field having \"([^\"]*)\"$")
	public void clear_text(String accessName) throws Exception {
		String[] keyAccess = miscmethodObj.splitAndGet(accessName);
		System.out.println("clear input having " + keyAccess[0] + " " + keyAccess[1]);
		miscmethodObj.validateLocator(keyAccess[0]);
		inputObj.clearText(keyAccess[0], keyAccess[1]);
	}

	@When("^I forcefully clear input field having \"([^\"]*)\"$")
	public void clear_inputs(String accessName) throws Exception {
		String[] keyAccess = miscmethodObj.splitAndGet(accessName);
		System.out.println("forcefully clear input field having " + keyAccess[0] + " " + keyAccess[1]);
		miscmethodObj.validateLocator(keyAccess[0]);
		inputObj.deleteKeys(keyAccess[0], keyAccess[1]);
	}

	// select option by text/value from dropdown
	@When("^I select \"(.*?)\" option by (.+) from dropdown having \"(.*?)\"$")
	public void select_option_from_dropdown(String option, String optionBy, String accessName) throws Exception {
		String[] keyAccess = miscmethodObj.splitAndGet(accessName);
		System.out.println("select " + option + " dropdown with " + keyAccess[0] + " " + keyAccess[1]);
		miscmethodObj.validateLocator(keyAccess[0]);
		miscmethodObj.validateOptionBy(optionBy);
		inputObj.selectOptionFromDropdown(keyAccess[0], optionBy, option, keyAccess[1]);
	}

	@When("^dropdown having size of  \"(.*?)\"  from element having \"(.*?)\"$")
	public void select_option_size(String length, String accessName) throws Exception {
		String[] keyAccess = miscmethodObj.splitAndGet(accessName);
		System.out.println("dropdown size " + length + " with " + keyAccess[0] + " " + keyAccess[1]);
		miscmethodObj.validateLocator(keyAccess[0]);
		assertionObj.selectOptionSize(length, keyAccess[0], keyAccess[1]);
	}

	@When("^value \"(.*?)\" should\\s*((?:not)?)\\s+be present in the dropdown from element having \"(.*?)\"$")
	public void selectOptionPresent(String value, String present, String accessName) throws Exception {
		String[] keyAccess = miscmethodObj.splitAndGet(accessName);
		System.out.println("value " + value + "should " + present.isEmpty() + " present dropdown with " + keyAccess[0]
				+ " " + keyAccess[1]);
		miscmethodObj.validateLocator(keyAccess[0]);
		assertionObj.selectOptionPresent(value, present.isEmpty(), keyAccess[0], keyAccess[1]);
	}

	// select option by index from dropdown
	@When("^I select (\\d+) option by index from dropdown having \"(.*?)\"$")
	public void select_option_from_dropdown_by_index(String option, String accessName) throws Exception {
		String[] keyAccess = miscmethodObj.splitAndGet(accessName);
		System.out.println("select " + option + " should dropdown with " + keyAccess[0] + " " + keyAccess[1]);
		miscmethodObj.validateLocator(keyAccess[0]);
		inputObj.selectOptionFromDropdown(keyAccess[0], "selectByIndex", option, keyAccess[1]);
	}

	// select option by text/value from multiselect
	@When("^I select \"(.*?)\" option by (.+) from multiselect dropdown having \"(.*?)\"$")
	public void select_option_from_multiselect_dropdown(String option, String optionBy, String accessName)
			throws Exception {
		String[] keyAccess = miscmethodObj.splitAndGet(accessName);
		System.out.println("select " + option + " optionBy " + optionBy + "should multiselect dropdown with "
				+ keyAccess[0] + " " + keyAccess[1]);
		miscmethodObj.validateLocator(keyAccess[0]);
		miscmethodObj.validateOptionBy(optionBy);
		inputObj.selectOptionFromDropdown(keyAccess[0], optionBy, option, keyAccess[1]);
	}

	// select option by index from multiselect
	@When("^I select (\\d+) option by index from multiselect dropdown having \"(.*?)\"$")
	public void select_option_from_multiselect_dropdown_by_index(String option, String accessName) throws Exception {
		String[] keyAccess = miscmethodObj.splitAndGet(accessName);
		System.out
				.println("select " + option + " should multiselect dropdown with " + keyAccess[0] + " " + keyAccess[1]);
		miscmethodObj.validateLocator(keyAccess[0]);
		inputObj.selectOptionFromDropdown(keyAccess[0], "selectByIndex", option, keyAccess[1]);
	}

	// deselect option by text/value from multiselect
	@When("^I deselect \"(.*?)\" option by (.+) from multiselect dropdown having \"(.*?)\"$")
	public void deselect_option_from_multiselect_dropdown(String option, String optionBy, String accessName)
			throws Exception {
		String[] keyAccess = miscmethodObj.splitAndGet(accessName);
		System.out.println("deselect " + option + " optionBy " + optionBy + "should multiselect dropdown  with "
				+ keyAccess[0] + " " + keyAccess[1]);
		miscmethodObj.validateLocator(keyAccess[0]);
		miscmethodObj.validateOptionBy(optionBy);
		inputObj.deselectOptionFromDropdown(keyAccess[0], optionBy, option, keyAccess[1]);
	}

	// deselect option by index from multiselect
	@When("^I deselect (\\d+) option by index from multiselect dropdown having \"(.*?)\"$")
	public void deselect_option_from_multiselect_dropdown_by_index(String option, String accessName) throws Exception {
		String[] keyAccess = miscmethodObj.splitAndGet(accessName);
		System.out.println(
				"deselect " + option + " should  with multiselect dropdown " + keyAccess[0] + " " + keyAccess[1]);
		miscmethodObj.validateLocator(keyAccess[0]);
		inputObj.deselectOptionFromDropdown(keyAccess[0], "selectByIndex", option, keyAccess[1]);
	}

	// step to select option from mutliselect dropdown list
	/*
	 * @When("^I select all options from multiselect dropdown having (.+) \"(.*?)\"$"
	 * ) public void select_all_option_from_multiselect_dropdown(String accessName)
	 * throws Exception { miscmethod.validateLocator(type); //inputObj
	 * //select_all_option_from_multiselect_dropdown(type, access_name) }
	 */

	// step to unselect option from mutliselect dropdown list
	@When("^I deselect all options from multiselect dropdown having \"(.*?)\"$")
	public void unselect_all_option_from_multiselect_dropdown(String accessName) throws Exception {
		String[] keyAccess = miscmethodObj.splitAndGet(accessName);
		System.out.println(
				"deselect options from multiselect dropdown having " + keyAccess[0] + " accessName " + keyAccess[1]);
		miscmethodObj.validateLocator(keyAccess[0]);
		inputObj.unselectAllOptionFromMultiselectDropdown(keyAccess[0], keyAccess[1]);
	}

	// check checkbox steps
	@When("^I check the checkbox having \"(.*?)\"$")
	public void check_checkbox(String accessName) throws Exception {
		String[] keyAccess = miscmethodObj.splitAndGet(accessName);
		System.out.println("check the checkbox having  " + keyAccess[0] + " accessName " + keyAccess[1]);
		miscmethodObj.validateLocator(keyAccess[0]);
		inputObj.checkCheckbox(keyAccess[0], keyAccess[1]);
	}

	// uncheck checkbox steps
	@When("^I uncheck the checkbox having \"(.*?)\"$")
	public void uncheck_checkbox(String accessName) throws Exception {
		String[] keyAccess = miscmethodObj.splitAndGet(accessName);
		System.out.println("uncheck the checkbox having  " + keyAccess[0] + " accessName " + keyAccess[1]);
		miscmethodObj.validateLocator(keyAccess[0]);
		inputObj.uncheckCheckbox(keyAccess[0], keyAccess[1]);
	}

	// steps to toggle checkbox
	@When("^I toggle checkbox having \"(.*?)\"$")
	public void toggle_checkbox(String accessName) throws Exception {
		String[] keyAccess = miscmethodObj.splitAndGet(accessName);
		System.out.println("toggle checkbox having   " + keyAccess[0] + " accessName " + keyAccess[1]);
		miscmethodObj.validateLocator(keyAccess[0]);
		inputObj.toggleCheckbox(keyAccess[0], keyAccess[1]);
	}

	// step to select radio button
	@When("^I select radio button having \"(.*?)\"$")
	public void select_radio_button(String accessName) throws Exception {
		String[] keyAccess = miscmethodObj.splitAndGet(accessName);
		System.out.println("select radio button having   " + keyAccess[0] + " accessName " + keyAccess[1]);
		miscmethodObj.validateLocator(keyAccess[0]);
		inputObj.selectRadioButton(keyAccess[0], keyAccess[1]);
	}

	// steps to select option by text from radio button group
	@When("^I select \"(.*?)\" option by (.+) from radio button group having \"(.*?)\"$")
	public void select_option_from_radio_btn_group(String option, String by, String accessName) throws Exception {
		String[] keyAccess = miscmethodObj.splitAndGet(accessName);
		System.out.println("select " + option + " optionBy " + by + "should radio button with " + keyAccess[0] + " "
				+ keyAccess[1]);
		miscmethodObj.validateLocator(keyAccess[0]);
		// miscmethodObj.validateOptionBy(optionBy);
		inputObj.selectOptionFromRadioButtonGroup(keyAccess[0], option, by, keyAccess[1]);
	}

	// Click element Steps

	// click on web element
	@When("^I click on element having \"(.*?)\"$")
	public void click(String accessName) throws Exception {
		String[] keyAccess = miscmethodObj.splitAndGet(accessName);
		System.out.println("clcik on element having  " + keyAccess[0] + " " + keyAccess[1]);
		miscmethodObj.validateLocator(keyAccess[0]);
		clickObj.click(keyAccess[0], keyAccess[1]);
	}


	// Forcefully click on element
	@When("^I forcefully click on element having \"(.*?)\"$")
	public void click_forcefully(String accessName) throws Exception {
		String[] keyAccess = miscmethodObj.splitAndGet(accessName);
		System.out.println("forcefully click on element having " + keyAccess[0] + " " + keyAccess[1]);
		miscmethodObj.validateLocator(keyAccess[0]);
		clickObj.clickForcefully(keyAccess[0], keyAccess[1]);
	}

	@When("^I move slider right having \"(.*?)\" in (\\d+) and (\\d+)$")
	public void move_the_slider_right(String accessName, int xDirection, int yDirection) throws Exception {
		String[] keyAccess = miscmethodObj.splitAndGet(accessName);
		System.out.println("move slider right having " + keyAccess[0] + " " + keyAccess[1] + " in direction "
				+ xDirection + " " + yDirection);
		miscmethodObj.validateLocator(keyAccess[0]);
		sliderMethods.moveTheSliderRight(keyAccess[0], keyAccess[1], xDirection, yDirection);
	}

	@When("^I move slider left having \"(.*?)\" in (\\d+) and (\\d+)$")
	public void move_the_slider_left(String accessName, int xDirection, int yDirection) throws Exception {
		String[] keyAccess = miscmethodObj.splitAndGet(accessName);
		System.out.println("move slider left having " + keyAccess[0] + " " + keyAccess[1] + " in direction "
				+ xDirection + " " + yDirection);
		miscmethodObj.validateLocator(keyAccess[0]);
		sliderMethods.moveTheSliderLeft(keyAccess[0], keyAccess[1], xDirection, yDirection);
	}

	// double click on web element
	@When("^I double click on element having \"(.*?)\"$")
	public void double_click(String accessValue) throws Exception {
		String[] keyAccess = miscmethodObj.splitAndGet(accessValue);
		System.out.println("double click on element having " + keyAccess[0] + " " + keyAccess[1]);
		miscmethodObj.validateLocator(keyAccess[0]);
		clickObj.doubleClick(keyAccess[0], keyAccess[1]);
	}

	// steps to click on link
	@When("^I click on link having text \"(.*?)\"$")
	public void click_link(String accessName) {
		System.out.println("click on  text " + ElementsProperties.get(accessName));
		clickObj.click("linkText", ElementsProperties.get(accessName));
	}

	// Step to click on partial link
	@When("^I click on link having partial text \"(.*?)\"$")
	public void click_partial_link(String accessName) {
		System.out.println("click on partial text " + ElementsProperties.get(accessName));
		clickObj.click("partialLinkText", ElementsProperties.get(accessName));
	}

	// Progress methods

	// wait for specific period of time
	@When("^I wait for (\\d+) sec$")
	public void wait(String time) throws NumberFormatException, InterruptedException {
		System.out.println("wait for " + time);
		progressObj.wait(time);
	}

	// wait for specific element to display for specific period of time
	@When("^I wait (\\d+) seconds for element having \"(.*?)\" to display$")
	public void wait_for_ele_to_display(String duration, String accessName) throws Exception {
		String[] keyAccess = miscmethodObj.splitAndGet(accessName);
		System.out.println("wait for elements " + duration + " having " + keyAccess[0] + " " + keyAccess[1]);
		miscmethodObj.validateLocator(keyAccess[0]);
		progressObj.waitForElementToDisplay(keyAccess[0], keyAccess[1], duration);
	}

	// wait for specific element to enable for specific period of time
	@When("^I wait (\\d+) seconds for element having \"(.*?)\" to be enabled$")
	public void wait_for_ele_to_click(String duration, String accessName) throws Exception {
		String[] keyAccess = miscmethodObj.splitAndGet(accessName);
		System.out
				.println("wait for elements to be enabled" + duration + " having " + keyAccess[0] + " " + keyAccess[1]);
		miscmethodObj.validateLocator(keyAccess[0]);
		progressObj.waitForElementToClick(keyAccess[0], keyAccess[1], duration);
	}

	// JavaScript handling steps

	// Step to handle java script
	@When("^I accept alert$")
	public void handle_alert() {
		System.out.println("accept alert");
		javascriptObj.handleAlert("accept");
	}

	// Steps to dismiss java script
	@When("^I dismiss alert$")
	public void dismiss_alert() {
		System.out.println("dismiss alert");
		javascriptObj.handleAlert("dismiss");
	}

	// Screen shot methods

	@When("^I take screenshot$")
	public void take_screenshot() throws IOException {
		System.out.println("take screenshot");
		screenshotObj.addScreenshotTestreport(this.scenario);
	}

	// Configuration steps

	// step to print configuration
	@When("^I print configuration$")
	public void print_config() {
		System.out.println("print configuration");
		configObj.printDesktopConfiguration();
	}

	// @After
	// public final void tearDown() {
	// DriverUtil.closeDriver();
	// }
}
