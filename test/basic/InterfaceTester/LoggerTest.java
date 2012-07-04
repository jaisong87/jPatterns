package basic.InterfaceTester;

import org.junit.Test;

import basic.Interface.ConsoleLogger;
import basic.Interface.FileLogger;

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
		ConsoleLogger logc = new ConsoleLogger();
		boolean writeSuccess = logc.log("Hello World!");
		assert(writeSuccess);
	}
}