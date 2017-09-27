һ��Log4j���
	Log4j��������Ҫ�������
		Loggers(��¼��)��
		Appenders (���Դ)��
		Layouts(����)��
	����ɼ����Ϊ��־�����־Ҫ����ĵط�����־�Ժ�����ʽ�����
	�ۺ�ʹ������������������ɵؼ�¼��Ϣ�����ͺͼ��𣬲�����������ʱ������־�������ʽ��λ�á�

	1��Loggers	
		Loggers����ڴ�ϵͳ�б���Ϊ�������DEBUG��INFO��WARN��ERROR��FATAL��
		�������������˳��ģ�DEBUG < INFO < WARN < ERROR < FATAL���ֱ�����ָ��������־��Ϣ����Ҫ�̶ȣ�������һ�����Ҫ��
		Log4j��һ������ֻ������𲻵����趨�������־��Ϣ������Loggers�����趨ΪINFO����INFO��WARN��ERROR��FATAL�������־��Ϣ����������������INFO�͵�DEBUG�򲻻������

	2��Appenders
		���ú�ʹ����־����ֻ��Log4j�Ļ������ܣ�Log4j��־ϵͳ���ṩ���ǿ��Ĺ��ܣ������������־�������ͬ�ĵط��������̨��Console�����ļ���Files���ȣ�
		���Ը������������ļ���С�����µ��ļ���������������ʽ���͵������ط��ȵȡ�
		��ʹ�õ������£�
			org.apache.log4j.ConsoleAppender������̨��
			org.apache.log4j.FileAppender���ļ���
			org.apache.log4j.DailyRollingFileAppender��ÿ�����һ����־�ļ���
			org.apache.log4j.RollingFileAppender���ļ���С����ָ���ߴ��ʱ�����һ���µ��ļ���
			org.apache.log4j.WriterAppender������־��Ϣ������ʽ���͵�����ָ���ĵط���
		����ģʽ��
			log4j.appender.appenderName = className
			log4j.appender.appenderName.Option1 = value1
			��
			log4j.appender.appenderName.OptionN = valueN

	3��Layouts
		��ʱ�û�ϣ�������Լ���ϲ�ø�ʽ���Լ�����־�����Log4j������Appenders�ĺ��渽��Layouts�����������ܡ�
		Layouts�ṩ������־�����ʽ�������HTML��ʽ������ָ����ʽ��������־��������Ϣ����ʽ�Ͱ�����־ʱ�䡢�̡߳�������Ϣ����ʽ��
		��ʹ�õ������£�
			org.apache.log4j.HTMLLayout����HTML�����ʽ���֣�
			org.apache.log4j.PatternLayout����������ָ������ģʽ��
			org.apache.log4j.SimpleLayout��������־��Ϣ�ļ������Ϣ�ַ�����
			org.apache.log4j.TTCCLayout��������־������ʱ�䡢�̡߳�������Ϣ��
		����ģʽ��
			log4j.appender.appenderName.layout =className
			log4j.appender.appenderName.layout.Option1 = value1
			��
			log4j.appender.appenderName.layout.OptionN = valueN

�����������
	��ʵ��Ӧ���У�ҪʹLog4j��ϵͳ�������������趨�����ļ��������ļ���ʵ��Ҳ���Ƕ�Logger��Appender��Layout������Ӧ�趨��
	Log4j֧�����������ļ���ʽ��һ����XML��ʽ���ļ���һ����properties�����ļ���
	������properties�����ļ�Ϊ������log4j.properties�����á�
		1�����ø�Logger��
			log4j.rootLogger = [ level ] , appenderName1, appenderName2, ��
			log4j.additivity.org.apache=false����ʾLogger�����ڸ�Logger��appender�������Ĭ��Ϊtrue��
			level ���趨��־��¼����ͼ��𣬿����ֵ��OFF��FATAL��ERROR��WARN��INFO��DEBUG��ALL�����Զ���ļ���Log4j����ֻʹ���м��ĸ�����ͨ���������趨���������Կ���Ӧ�ó�������Ӧ�������־��Ϣ�Ŀ��أ������������趨��INFO������Ӧ�ó���������DEBUG�������־��Ϣ�����ᱻ��ӡ������
			appenderName������ָ����־��ϢҪ������������ͬʱָ��������Ŀ�ĵأ��ö��Ÿ�����
			���磺log4j.rootLogger��INFO,A1,B2,C3

	2��������־��Ϣ���Ŀ�ĵأ�appender����
		log4j.appender.appenderName = className
			appenderName���Զ���appderName����log4j.rootLogger������ʹ�ã�
			className������ֵ���£�
				(1)org.apache.log4j.ConsoleAppender������̨��ѡ�����£�
					Threshold=WARN��ָ����־��Ϣ������������Ĭ��ΪDEBUG��
					ImmediateFlush=true����ʾ������Ϣ���ᱻ�����������Ϊfalse�������Ĭ��ֵ��true��
					Target=System.err��Ĭ��ֵ��System.out��
				(2)org.apache.log4j.FileAppender���ļ���ѡ�
					Threshold=WARN��ָ����־��Ϣ������������Ĭ��ΪDEBUG��
					ImmediateFlush=true����ʾ������Ϣ���ᱻ�����������Ϊfalse�������Ĭ��ֵ��true��
					Append=false��true��ʾ��Ϣ���ӵ�ָ���ļ��У�false����Ϣ����ָ�����ļ����ݣ�Ĭ��ֵ��true��
					File=D:/logs/logging.log4j��ָ����Ϣ�����logging.log4j�ļ��С�
				(3)org.apache.log4j.DailyRollingFileAppender��ÿ�����һ����־�ļ���ѡ�
					Threshold=WARN��ָ����־��Ϣ������������Ĭ��ΪDEBUG��
					ImmediateFlush=true����ʾ������Ϣ���ᱻ�����������Ϊfalse�������Ĭ��ֵ��true��
					Append=false��true��ʾ��Ϣ���ӵ�ָ���ļ��У�false����Ϣ����ָ�����ļ����ݣ�Ĭ��ֵ��true��
					File=D:/logs/logging.log4j��ָ����ǰ��Ϣ�����logging.log4j�ļ��С�
					DatePattern='.'yyyy-MM��ÿ�¹���һ����־�ļ�����ÿ�²���һ���µ���־�ļ�����ǰ�µ���־�ļ���Ϊlogging.log4j��ǰһ���µ���־�ļ���Ϊlogging.log4j.yyyy-MM��
					���⣬Ҳ����ָ�����ܡ��졢ʱ���ֵ���������־�ļ�����Ӧ�ĸ�ʽ���£�
						1)'.'yyyy-MM��ÿ��
						2)'.'yyyy-ww��ÿ��
						3)'.'yyyy-MM-dd��ÿ��
						4)'.'yyyy-MM-dd-a��ÿ������
						5)'.'yyyy-MM-dd-HH��ÿСʱ
						6)'.'yyyy-MM-dd-HH-mm��ÿ����
				(4)org.apache.log4j.RollingFileAppender���ļ���С����ָ���ߴ��ʱ�����һ���µ��ļ���ѡ�
					Threshold=WARN��ָ����־��Ϣ������������Ĭ��ΪDEBUG��
					ImmediateFlush=true����ʾ������Ϣ���ᱻ�����������Ϊfalse�������Ĭ��ֵ��true��
					Append=false��true��ʾ��Ϣ���ӵ�ָ���ļ��У�false����Ϣ����ָ�����ļ����ݣ�Ĭ��ֵ��true��
					File=D:/logs/logging.log4j��ָ����Ϣ�����logging.log4j�ļ��С�
					MaxFileSize=100KB����׺������KB, MB ����GB������־�ļ�����ô�Сʱ�������Զ�����������ԭ���������Ƶ�logging.log4j.1�ļ��С�
					MaxBackupIndex=2��ָ�����Բ����Ĺ����ļ�������������磬��Ϊ2����Բ���logging.log4j.1��logging.log4j.2���������ļ���һ��logging.log4j�ļ���
				(5)org.apache.log4j.WriterAppender������־��Ϣ������ʽ���͵�����ָ���ĵط���
	3��������־��Ϣ�������ʽ��Layout����
		log4j.appender.appenderName.layout=className
			className������ֵ���£�
				(1)org.apache.log4j.HTMLLayout����HTML�����ʽ���֣�ѡ�
					LocationInfo=true�����java�ļ����ƺ��кţ�Ĭ��ֵ��false��
					Title=My Logging�� Ĭ��ֵ��Log4J Log Messages��
				(2)org.apache.log4j.PatternLayout����������ָ������ģʽ��ѡ�
					ConversionPattern=%m%n���趨�������ĸ�ʽ��ʾ��Ϣ��
					��ʽ������˵����
						%p�������־��Ϣ�����ȼ�����DEBUG��INFO��WARN��ERROR��FATAL��
						%d�������־ʱ�������ڻ�ʱ�䣬Ĭ�ϸ�ʽΪISO8601��Ҳ���������ָ����ʽ���磺%d{yyyy/MM/dd HH:mm:ss,SSS}��
						%r�������Ӧ�ó��������������log��Ϣ�ķѵĺ�������
						%t�������������־�¼����߳�����
						%l�������־�¼��ķ���λ�ã��൱��%c.%M(%F:%L)����ϣ�������ȫ�����������ļ����Լ��ڴ����е����������磺test.TestLog4j.main(TestLog4j.java:10)��
						%c�������־��Ϣ��������Ŀ��ͨ�������������ȫ����
						%M�����������־��Ϣ�ķ�������
						%F�������־��Ϣ����ʱ���ڵ��ļ����ơ�
						%L:����������е��кš�
						%m:�����������ָ���ľ�����־��Ϣ��
						%n�����һ���س����з���Windowsƽ̨Ϊ"rn"��Unixƽ̨Ϊ"n"��
						%x������͵�ǰ�߳��������NDC(Ƕ����ϻ���)�������õ���java servlets�����Ķ�ͻ����̵߳�Ӧ���С�
						%%�����һ��"%"�ַ���
					���⣬��������%���ʽ�ַ�֮��������η�����������С���ȡ���󳤶ȡ����ı��Ķ��뷽ʽ���磺
						1) c��ָ�����category�����ƣ���С�ĳ�����20�����category�����Ƴ���С��20�Ļ���Ĭ�ϵ�������Ҷ��롣
						2)%-20c��"-"�ű�ʾ����롣
						3)%.30c��ָ�����category�����ƣ����ĳ�����30�����category�����Ƴ��ȴ���30�Ļ����ͻὫ��߶�����ַ��ص�����С��30�Ļ�Ҳ���Ჹ�ո�
 				(3)org.apache.log4j.SimpleLayout��������־��Ϣ�ļ������Ϣ�ַ�����
				(4)org.apache.log4j.TTCCLayout��������־������ʱ�䡢�̡߳����ȵ���Ϣ��

����Spring MVC����slf4j-log4j
	spring MVC����slf4j-log4j�Ĺ��̣����£�
		1����pom.xml�ļ������slf4j-log4j������(һ���͹���)����ɺ��classpath�н���������jar�����ֱ��ǣ�slf4j-api.jar��log4j.jar��slf4j-log4j.jar
			<dependency>
				<groupId>org.slf4j</groupId>
				<artifactId>slf4j-log4j12</artifactId>
			</dependency>
		2���ڵ�ǰclasspath�����log4j.properties�����ļ�������log4j�Ĳ����﷨��д���ļ�
		3������������ɺ���ͨ��Java��Ŀ����ʹ��slf4j-log4j������־������
		4������Java Web��Ŀ������Ҫ��web.xml�ļ�������Log4jConfigLocation��Log4jConfigListener	
			<!--����log4j�������ļ�λ��-->
			<context-param>
			    <param-name>log4jConfigLocation</param-name>
			    <param-value>classpath:log4j.properties</param-value>
			</context-param>
			<!--ʹ�ü�������log4j�������ļ�-->
			<listener>
			    <listener-class>org.springframework.web.util.Log4jConfigListener</listener-class>
			</listener>		
				
