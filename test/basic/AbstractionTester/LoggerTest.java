package basic.AbstractionTester;

import org.junit.Test;

import basic.Abstraction.ConsoleLogger;
import basic.Abstraction.FileLogger;
import basic.commons.LogLevel;

public class LoggerTest {

	@Test
	public void testFileLogger()
	{
		FileLogger logf = new FileLogger("log001");
		boolean writeSuccess = logf.log("Hello World!");
		assert(writeSuccess);
	}
    @Test
	public void testConsoleLogger()
	{
		ConsoleLogger logc = new ConsoleLogger(LogLevel.DEBUG);
		boolean writeSuccess = logc.log("Hello World!");
		assert(writeSuccess);
	}
}