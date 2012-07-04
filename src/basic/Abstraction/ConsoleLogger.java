package basic.Abstraction;

import basic.Interface.LogLevel;

public class ConsoleLogger extends BasicLogger {

	public ConsoleLogger(LogLevel reqLogLevel) {
		super(reqLogLevel);
		// TODO Auto-generated constructor stub
	}
    
	public boolean log(String msg){
		try{
	        System.out.println(msg); /* Just print it to console */
			}
			catch(Exception e){
				return false;
			}
			return true;
	}
}
