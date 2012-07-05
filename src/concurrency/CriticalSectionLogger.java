package concurrency;

import basic.Interface.LoggerInterface;
import basic.commons.LogLevel;

/*
 * Pattern - CriticalSection 
 * 
 * These are usually implemented as singletons to provide
 * class level locks as opposed to instance level locks.
 * 
 * Only one instance can log() at a time 
 */

public class CriticalSectionLogger{

	private static CriticalSectionLogger _logger = new CriticalSectionLogger(LogLevel.DEBUG);
	private LogLevel curLogLevel;
	
	private CriticalSectionLogger(LogLevel reqLogLevel){
		curLogLevel = reqLogLevel;
	}

	/* Not performing lazy initialization to avoid synchronized here*/
	public CriticalSectionLogger getInstance(){
		return _logger;
	}
	
	/* This is race-free code unlike loggers in basic Abstraction/Interface*/
	public synchronized boolean log(String msg) {
		try{
	        System.out.println(msg); /* Just print it to console */
			}
			catch(Exception e){
				return false;
			}
			return true;
	}

	public boolean setLogLevel(LogLevel level) {
		curLogLevel = level;
		return true;
	}

	public LogLevel getLogLevel() {
		return curLogLevel;
	}
}
