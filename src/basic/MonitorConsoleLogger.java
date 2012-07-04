package basic;

import basic.Abstraction.BasicLogger;
import basic.commons.LogLevel;

/*
 * Pattern - Monitor
 * 
 * Monitor provides thread safety at instance level.
 * For the same object instances , methods which are 
 * synchronized are mutually exclusive 
 * 
 * @Refer CriticalSection for Class Level locking
 */
public class MonitorConsoleLogger extends BasicLogger {

	public MonitorConsoleLogger(LogLevel logLevel){
		super(logLevel);
	}
	
	@Override
	public boolean log(String msg) {
		try{
	        System.out.println(msg); /* Just print it to console */
			}
			catch(Exception e){
				return false;
			}
			return true;
	}

}
