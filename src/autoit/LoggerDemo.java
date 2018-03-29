package autoit;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;


public class LoggerDemo 
{
	public Logger log = Logger.getLogger(LoggerDemo.class);
	
	public void loggerDebug()
	{
		log.debug("This is a debug method");
	}
	
	public void loggerInfo()
	{
		log.info("This is an information about AUT");
	}

	public void loggerError()
	{
		log.error("this is an error message");
	}
	
	public void loggerFatal()
	{
		log.fatal("This is a fatal error occurred during execution");
	}
	
	public void loggerWarn()
	{
		log.warn("This is a warning message");
	}
	
	@Test
	public void loggerDemo()
	{
		loggerDebug();
		loggerError();
		loggerFatal();
		loggerWarn();
		loggerInfo();
		
		
	}
}
