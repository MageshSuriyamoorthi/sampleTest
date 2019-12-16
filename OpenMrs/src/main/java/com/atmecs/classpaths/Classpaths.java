package com.atmecs.classpaths;

import java.io.File;


public class Classpaths {
	public static String USERDIR = System.getProperty("user.dir");

	public static String RESOURCEFILE = USERDIR + File.separator + "src" + File.separator + "test" + File.separator
			+ "resources";
	public static String CHROMEFILE = USERDIR + File.separator + "lib" + File.separator + "chromedriver.exe";

	public static String FIREFOXFILE = USERDIR + File.separator + "lib" + File.separator + "geckodriver.exe";

	public static String IEFILE = USERDIR + File.separator + "lib" + File.separator + "IEDriverServer.exe";

	public static String LOG4JFILE = RESOURCEFILE + File.separator + "log4j" + File.separator + "log4j.properties";

	public static String CONFIGFILE = USERDIR + File.separator + "config.properties";
	
	public static String HOMEPAGELOC = RESOURCEFILE + File.separator + "locator" + File.separator +"homepagelocator.properties";
	
	public static String HOMEPAGETESTDATA = RESOURCEFILE + File.separator + "testdata" + File.separator +"testdata.xlsx";
}
