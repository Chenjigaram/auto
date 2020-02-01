package com.auto.methods;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ErrorHandlingMethods 
{
	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	public void validateParameters(String platform, String browserType, String appPath)
	{
		if(platform.equals("desktop"))
		{
			if(Arrays.asList("ff","ie","chrome","safari","opera").contains(browserType))
				printErrorDesktop();
		}
		else if(platform.equals("android"))
			printErrorAndroid(browserType,appPath);
		else if(platform.equals("iOS"))
			LOG.error("Not Implemented...");
		else
			printInvalidPlatform();
	}
	

	private void printErrorDesktop()
	{
		LOG.error("\nInappropraite desktop browser : \"#{ENV['BROWSER']}\"");
		LOG.error("\nUsage : cucumber BROWSER=browser_name");
		LOG.error("\nBrowser Supported  :\n");
		LOG.error("\n1.ie\n2.chrome\n3.ff\n4.safari\n5.opera");
		System.exit(0);
	}
	 

	public void printErrorAndroid(String browserType,String appPath)
	{
	  /*if browser_type=='ff' and app_path==nil
	    puts "\nOops... not mentioned \"Browser\" or \"App path\""
	    print_error_android_app
	    print_error_android_web
	    Process.exit(0) 
	  elsif browser_type!='ff' and !%w(native chrome).include? browser_type
	    puts "\nOops... not supported browser"
	    print_error_android_web
	    Process.exit(0) 
	  end
	end*/
	}
	
	public void printInvalidPlatform()
	{
		LOG.error("\nOops... Invalid Platform");
		LOG.error("\nSupported platform are \"android\" and \"iOS\".");
		LOG.error("\nTo run on Desktop no need to mention platform.");
		System.exit(0);
	}
}
