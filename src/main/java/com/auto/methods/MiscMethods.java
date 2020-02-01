package com.auto.methods;

import java.util.Arrays;

import com.auto.utilities.ElementsProperties;

public class MiscMethods 
{
	public boolean valid_locator_type(String type)
	{
		return Arrays.asList("id","class","css","name","xpath").contains(type);
	}


	public void validateLocator(String type) throws Exception
	{
		if(!valid_locator_type(type))
			throw new Exception("Invalid locator type - "+type);
	}
	
	public boolean valid_option_by(String option_by)
	{
		return Arrays.asList("text","value","index").contains(option_by);
	}


	public void validateOptionBy(String optionBy) throws Exception
	{
		if(!valid_option_by(optionBy))
			throw new Exception("Invalid option by - "+optionBy);
	}
	
	public String[] splitAndGet(String key) {
		String[] keyAccess = new String[2];
		String value = ElementsProperties.get(key);
		keyAccess[0] = value.substring(0, value.indexOf(",")).trim();
		keyAccess[1] = value.substring(value.indexOf(",")+1).trim();
		return keyAccess;
	}
}
