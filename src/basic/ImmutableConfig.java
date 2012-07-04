package basic;

import basic.Interface.LogLevel;

/*
 * Immutable Config is initialized once and then 
 * they are only queried.
 * This pattern also provides thread safety without 
 * synchronized 
 * 
 * This class could be made singleton, static depending on
 * the used case.
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
