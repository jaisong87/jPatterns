package basic.Interface;

import basic.commons.LogLevel;

/*
 * ConsoleLogger implementing the Interface Logger
 */
public class ConsoleLogger implements LoggerInterface {
    
	public ConsoleLogger(){
	//Do nothing
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

	@Override
	public boolean setLogLevel(LogLevel level) {
		return true;
	}

	@Override
	public LogLevel getLogLevel() {
		return null;
	}

}
