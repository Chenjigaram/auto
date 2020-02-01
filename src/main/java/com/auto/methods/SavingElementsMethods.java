package com.auto.methods;

import java.util.HashMap;
import java.util.Map;

public class SavingElementsMethods extends SelectElementByType implements BaseTest{

	public static Map<String,String> elementSaved = new HashMap<String,String>();
	
	public static String getValue(String key) {
		return elementSaved.get(key);
	}
	
	public static void putValue(String key,String value) {
		elementSaved.put(key,value);
	}
	
	public static void printAll() {
		System.out.println("****** ALL Keys ********");
		for(String value : elementSaved.keySet()) {
			System.out.println(value+" : "+elementSaved.get(value));
		}
	}
	
	public static void emptySaved() {
		elementSaved.clear();
	}
	
}
