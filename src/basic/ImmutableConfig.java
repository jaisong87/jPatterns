package basic;

import basic.commons.LogLevel;


/*
 * Pattern - Immutable
 * 
 * Immutable is initialized once and then 
 * member attributes are only queried but not reset.
 * This pattern also provides thread safety without 
 * synchronized 
 */

public class ImmutableConfig {
	private String dev;// "Jaison George";
	private String devContact;// "jaisong87@gmail.com";
	private LogLevel defaultLogLevel;// LogLevel.DEBUG;
	private String defaultLogFile;// "log001";

	public ImmutableConfig(String developer, String developerContact, LogLevel lgLevel, String logFile){
		dev = developer;
		devContact = developerContact;
		defaultLogLevel = lgLevel;
		defaultLogFile = logFile;
	}
	
	public String getDev(){
		return dev;
	}

	public String getDevContact(){
		return devContact;
	}
	
	public LogLevel getLogLevel(){
		return defaultLogLevel;
	}
	
	public String getLogFile()
	{
		return defaultLogFile;
	}
}
