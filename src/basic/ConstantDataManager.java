package basic;

import basic.commons.LogLevel;


/*
 * Pattern - ConstantDataManager
 * 
 * All the constant data could be grouped into a
 * constantDataManager and used across the Framework.
 * The basic idea it to keep all the constants grouped
 * in one single place.
 */
public class ConstantDataManager {
	public static final String Dev = "Jaison George";
	public static final String DevContact = "jaisong87@gmail.com";
	public static final LogLevel defaultLogLevel = LogLevel.DEBUG;
	public static final String defaultLogFile = "log001";
}
