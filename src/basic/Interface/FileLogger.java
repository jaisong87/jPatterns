/**
 * 
 */
package basic.Interface;

import java.io.FileOutputStream;

/**
 * @author jaison
 *
 */
public class FileLogger implements LoggerInterface {

	private String logFile;
	private FileOutputStream loggerOutStream;
    private LogLevel myLogLevel;
	/* (non-Javadoc)
	 * @see basic.Interface.Logger#log()
	 */
	public FileLogger(String myLogFile){
		myLogLevel = LogLevel.DEBUG;
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

	/* (non-Javadoc)
	 * @see basic.Interface.Logger#setLogLevel(basic.Interface.LogLevel)
	 */
	@Override
	public boolean setLogLevel(LogLevel level) {
		myLogLevel = level;
		return false;
	}

	/* (non-Javadoc)
	 * @see basic.Interface.Logger#getLogLevel()
	 */
	@Override
	public LogLevel getLogLevel() {
		return myLogLevel;
	}
}