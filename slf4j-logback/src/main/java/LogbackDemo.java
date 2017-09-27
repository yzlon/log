import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackDemo {
	public static final Logger logger = LoggerFactory.getLogger(LogbackDemo.class);

	public static void showLogbackLog() {
		logger.trace("this is trace");
		logger.debug("this is debug!");
		logger.info("this is info!");
		logger.warn("this is warn!");
		logger.error("this is error!");
	}

}
