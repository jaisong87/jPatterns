/**
 * 
 */
package basic.Interface;

/**
 * @author jaisong87
 * Logger - Example for an interface
 */
public interface Logger {
public boolean log(String msg); /*Log message to device*/
public boolean setLogLevel(LogLevel level);   /*Set the log level*/
public LogLevel getLogLevel();
}
