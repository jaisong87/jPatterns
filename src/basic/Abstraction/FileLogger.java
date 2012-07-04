package basic.Abstraction;

import java.io.FileOutputStream;

import basic.commons.LogLevel;

public class FileLogger extends BasicLogger {
	private String logFile;
	private FileOutputStream loggerOutStream;

	public FileLogger(LogLevel reqLogLevel) {
		super(reqLogLevel);
	}

	public FileLogger(String myLogFile){
		super(LogLevel.DEBUG);
		logFile = myLogFile;
    	try{
    		loggerOutStream = new FileOutputStream(logFile);
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
	}

	@Override
	public boolean log(String msg) {
        boolean writeFailed = false;
		try{
        	loggerOutStream.write(msg.getBytes());
        }
        catch(Exception e)
        {
        	writeFailed = true;
        	e.printStackTrace();
        }
		finally{
			if(writeFailed)
			{
			System.out.println("Write Failed!!!");	
			return false;
			}
		}
        return true;
	}

}
