/**
 * 
 */
package basic.Interface;

import basic.commons.LogLevel;

/**
 * @author jaisong87
 * Logger - Example for an interface
 */
public interface LoggerInterface {
public boolean log(String msg); /*Log message to device*/
public boolean setLogLevel(LogLevel level);   /*Set the log level*/
public LogLevel getLogLevel();
}
