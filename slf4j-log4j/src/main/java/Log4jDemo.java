import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4jDemo {
	private static final Logger logger = LoggerFactory.getLogger(Log4jDemo.class);

	public static void showLog4jLog() {

		logger.trace("this is trace");
		logger.debug("this is debug!");
		logger.info("this is info!");
		logger.warn("this is warn!");
		logger.error("this is error!");

	}
}
