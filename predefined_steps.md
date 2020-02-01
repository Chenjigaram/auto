# predifined Steps

* Navigation Steps
* Assertion Steps
* Input Steps
* Click Steps
* Progress Steps
* Screenshot Steps
* Configuration Steps
* Slider actions



## slider steps
To move slider 

	When I move slider right having "(.*?)" in {x-direction} and {y-direction}
	When I move slider left having "(.*?)" in {x-direction} and {y-direction}

## Navigation Steps

To open/close URL and to navigate between pages use following steps :

	Then I navigate to "([^\"]*)"
	Then I navigate forward
	Then I navigate back
	Then I refresh page

To switch between windows use following steps :

	Then I switch to new window
	Then I switch to previous window
	Then I switch to window having title "(.*?)"
	Then I close new window
	Then I switch to main window

To switch between frames use following steps :	

	Then I switch to frame having (index|id|name|xpath|css) \"(.*?)
	Then I switch to main content
	
To interact with browser use following steps :    

	Then I resize browser window size to width (\d+) and height (\d+)
	Then I maximize browser window
	Then I close browser

To zoom in/out webpage use following steps :

	Then I zoom in page
	Then I zoom out page

To zoom out webpage till necessary element displays use following steps :

	Then I zoom out page till I see element having "(.*?)"

To reset webpage view use following step :

	Then I reset page view

To scroll webpage use following steps :
	
	Then I scroll to top of page
	Then I scroll to end of page

To scroll webpage to specific element use following steps :

	Then I scroll to element having "(.*?)"


To hover over a element use following steps :

	Then I hover over element having "(.*?)"

verifying and storing Steps
----------------------------------
To store key and value

	Then store key \"([^\"]*)\" stored to text \"([^\"]*)\
	Then element having \"([^\"]*)\" text stored to key \"([^\"]*)\"
	Then element having \"([^\"]*)\" should have text as key \"([^\"]*)\"
	Then element having \"([^\"]*)\" should not have text as key \"([^\"]*)\"
	Then element having \"([^\"]*)\" attribute \"(.*?)\" text stored to key \"([^\"]*)\"
	Then element having \"([^\"]*)\" attribute \"(.*?)\" should have text as key \"([^\"]*)\"
	Then element having \"([^\"]*)\" attribute \"(.*?)\" should not have text as key \"([^\"]*)\"
	Then verify key \"([^\"]*)\" should have text \"([^\"]*)\"
	Then verify key \"([^\"]*)\" should not have text \"([^\"]*)\"
	Then verify key \"([^\"]*)\" should have same as key \"([^\"]*)\"
	Then verify key \"([^\"]*)\" should not have same as key \"([^\"]*)\"
	Then clear all saved values
	Then print all saved values



Assertion Steps
---------------
To assert that page title can be found use following step :

	Then I should see page title as "(.*?)"
	Then I should not see page title as "(.*?)"
	Then I should see page title having partial text as "(.*?)"
	Then I should not see page title having partial text as "(.*?)"
    
#### Steps For Asserting Element Text

To assert element text use any of the following steps :

	Then element having "([^\"]*)" should have text as "(.*?)"


	Then element having "([^\"]*)" should have partial text as "(.*?)"

	
	Then element having "([^\"]*)" should not have text as "(.*?)"


	Then element having "([^\"]*)" should not have partial text as "(.*?)"

	
#### Steps For Asserting Element Attribute

To assert element attribute use any of the following steps : 

	Then element having "([^\"]*)" should have attribute "(.*?)" with value "(.*?)"

	
	Then element having "([^\"]*)" should not have attribute "(.*?)" with value "(.*?)"

	

#### Steps For Asserting Element Accesibility

To assert that element is enabled use any of the following steps :

	Then element having "([^\"]*)" should be enabled


To assert that element is disabled use any of the following steps :

	Then element having "([^\"]*)" should be disabled


#### Steps For Asserting Element Visibility

To assert that element is present use any of the following steps :

	Then element having "([^\"]*)" should be present

	
To assert that element is not present use any of the following steps:

	Then element having "([^\"]*)" should not be present

	
#### Steps For Asserting Checkbox

To assert that checkbox is checked use any of the following steps :

	Then checkbox having "(.*?)" should be checked


To assert that checkbox is unchecked use any of the following steps :

	Then checkbox having "(.*?)" should be unchecked


#### Steps For Asserting Dropdown List

To check the length of dropdown

	Then dropdown having size of  \"(.*?)\"  from element having (.+) \"(.*?)\
	Then value \"(.*?)\" should (not) be present in the dropdown from element having (.+) \"(.*?)\

To assert that option by text from dropdown list selected use following steps :

	Then option "(.*?)" by text from dropdown having "(.*?)" should be selected


To assert that option by value from dropdown list selected use following steps :

	Then option "(.*?)" by value from dropdown having "(.*?)" should be selected

	
To assert that option by text from dropdown list unselected use following steps :

	Then option "(.*?)" by text from dropdown having "(.*?)" should be unselected


To assert that option by value from dropdown list unselected use following steps :

	Then option "(.*?)" by value from dropdown having "(.*?)" should be unselected
   

#### Steps For Asserting Radio Button

To assert that radio button selected use any of the following steps :

	Then radio button having "(.*?)" should be selected


To assert that radio button not selected use any of the following steps :

	Then radio button having "(.*?)" should be unselected


To assert that radio button group selected by text use any of the following steps :

	Then option "(.*?)" by text from radio button group having "(.*?)" should be selected

	
To assert that radio button group selected by value use any of the following steps :

	Then option "(.*?)" by value from radio button group having "(.*?)" should be selected


To assert that radio button group not selected by text use any of the following steps :

	Then option "(.*?)" by text from radio button group having "(.*?)" should be unselected


To assert that radio button group not selected by value use any of the following steps :

	Then option "(.*?)" by value from radio button group having "(.*?)" should be unselected


#### Steps For Asserting Links

To assert that link is present use following steps :

	Then link having text "(.*?)" should be present
	Then link having partial text "(.*?)" should be present

To assert that link is not present use following steps :

	Then link having text "(.*?)" should not be present
	Then link having partial text "(.*?)" should not be present

#### Steps For Asserting Javascript Pop-Up Alert 

To assert text on javascipt pop-up alert use following step :

	Then I should see alert text as "(.*?)"

#### Steps For Asserting Difference in images : Not Implemented

To assert difference in actual image and expected image (from remotely hosted) use following steps :

	Then actual image having  "(.*?)" and expected image having url "(.*?)" should be similar


To assert difference in actual image and expected image (from local machine) use following steps :

	Then actual image having  "(.*?)" and expected image having image_name "(.*?)" should be similar


To assert difference in actual image and expected image (from same webpage) use following steps :

	Then actual image having  "(.*?)" and expected image having id "(.*?)" should be similar



Input Steps
-----------

#### Steps For TextFields

To enter text into input field use following steps :

	When I enter "([^\"]*)" into input field having "([^\"]*)"

	
To clear input field use following steps :

	When I clear input field having "([^\"]*)"

To clear input forcefully field use following steps :

	When I forcefully clear input field having "([^\"]*)"


#### Steps For Dropdown List :

To select option by text from dropdown use following steps :

	When I select "(.*?)" option by text from dropdown having "(.*?)"


To select option by index from dropdown use following steps :

	When I select (\d+) option by index from dropdown having "(.*?)"


To select option by value from dropdown use following steps :

	When I select "(.*?)" option by value from dropdown having "(.*?)"


#### Steps For Multiselect List :

To select option by text from multiselect dropdown use following steps :

	When I select "(.*?)" option by text from multiselect dropdown having "(.*?)"

	
To select option by index from multiselect dropdown use following steps :

	When I select (\d+) option by index from multiselect dropdown having "(.*?)"


To select option by value from multiselect dropdown use following steps :

	When I select "(.*?)" option by value from multiselect dropdown having "(.*?)"


To deselect option by text from multiselect dropdown use following steps :

	When I deselect "(.*?)" option by text from multiselect dropdown having "(.*?)"

	
To deselect option by index from multiselect dropdown use following steps :

	When I deselect (\d+) option by index from multiselect dropdown having "(.*?)"

		
To deselect option by value from multiselect dropdown use following steps :

	When I deselect "(.*?)" option by value from multiselect dropdown having "(.*?)"

	
To select all options from multiselect use following steps : *Not Implemented*

	When I select all options from multiselect dropdown having "(.*?)"

	
To deselect all options from multiselect use following steps :

	When I deselect all options from mutliselect dropdown having "(.*?)"


#### Steps For Checkboxes

To check the checkbox use following steps :

	When I check the checkbox having "(.*?)"


To uncheck the checkbox use following steps :

	When I uncheck the checkbox having "(.*?)"


To toggle checkbox use following steps

	When I toggle checkbox having "(.*?)"


#### Steps For Radio Buttons

To select radio button use following steps :

	When I select radio button having "(.*?)"



To select one radio button by text from radio button group use following steps :

	When I select "(.*?)" option by text from radio button group having "(.*?)"


To select one radio button by value from radio button group use following steps :

	When I select "(.*?)" option by value from radio button group having "(.*?)"



Click Steps
-----------
To click on web element use following steps :

	When I click on element having "(.*?)"


To forcefully click on web element use following steps (if above steps do not work) :

	When I forcefully click on element having "(.*?)"


To double click on web element use following steps :

	When I double click on element having "(.*?)"


To click on links use following steps :

	When I click on link having text "(.*?)"
	When I click on link having partial text "(.*?)"

Progress Steps
--------------
To implicitly wait for specific time use following step :

	Then I wait for (\d+) sec
	
To wait for specific element to display use following steps :

	Then I wait (\d+) seconds for element having "(.*?)" to display


To wait for specific element to enable use following steps : why it is clickable in code

	Then I wait (\d+) seconds for element having "(.*?)" to enable


Javascript Handling Steps
-------------------------
To handle javascript pop-up use following steps :

	Then I accept alert 
	Then I dismiss alert
  

Screenshot Steps 
----------------
To take screenshot use following step :

	Then I take screenshot


Configuration Steps
-------------------
To print testing configuration use following step :

	Then I print configuration
