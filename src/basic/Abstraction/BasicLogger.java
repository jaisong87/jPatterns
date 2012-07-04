package basic.Abstraction;

import basic.commons.LogLevel;

public abstract class BasicLogger {
	private LogLevel myLogLevel;
	
	public BasicLogger(LogLevel reqLogLevel){
		myLogLevel = reqLogLevel;
	}
	
	public abstract boolean log(String msg); /*Log message to device*/
	
	public boolean setLogLevel(LogLevel level){   /*Set the log level*/
		myLogLevel = level;
		return true;
	}
	
	public LogLevel getLogLevel(){
		return myLogLevel;
	}
}
