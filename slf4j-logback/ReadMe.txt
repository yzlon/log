
һ��encoder��
	���������£�һ�ǰ���־��Ϣת�����ֽ����飬���ǰ��ֽ�����д�뵽�������
	ĿǰPatternLayoutEncoder ��Ψһ���õ���Ĭ�ϵ�encoder ����һ��<pattern>�ڵ㣬����������־�������ʽ��ʹ�á�%���ӡ�ת��������ʽ�����Ҫ�����%����������á�\���ԡ�\%������ת�塣
	���磺
		Xml����  
		<encoder>   
		   <pattern>%-4relative [%thread] %-5level %logger{35} - %msg%n</pattern>   
		</encoder  
	<pattern>�����ת����˵����
		c{length }��lo{length } ��logger{length } �������־��logger��������һ�����β���������������logger��������Ϊ0��ʾֻ����logger���ұߵ����֮����ַ�����
			%logger	    mainPackage.sub.sample.Bar	mainPackage.sub.sample.Bar
			%logger{0}	mainPackage.sub.sample.Bar	Bar
			%logger{5}	mainPackage.sub.sample.Bar	m.s.s.Bar
			%logger{10}	mainPackage.sub.sample.Bar	m.s.s.Bar
			%logger{15}	mainPackage.sub.sample.Bar	m.s.sample.Bar
			%logger{16}	mainPackage.sub.sample.Bar	m.sub.sample.Bar
			%logger{26}	mainPackage.sub.sample.Bar	mainPackage.sub.sample.Bar
		C{length }��class{length }�� 	���ִ�м�¼����ĵ����ߵ�ȫ�޶����������������һ������������ʹ�ã�����ִ���ٶȲ�����κ����⡣
		contextName��cn ��������������ơ�
		d{pattern}��date{pattern } �� �����־�Ĵ�ӡ��־��ģʽ�﷨��java.text.SimpleDateFormat ���ݡ�
			%d	                                2006-10-20 14:06:49,812
			%date	                            2006-10-20 14:06:49,812
			%date{ISO8601}	                    2006-10-20 14:06:49,812
			%date{HH:mm:ss.SSS}	                14:06:49.812
			%date{dd MMM yyyy ;HH:mm:ss.SSS}	20 oct. 2006;14:06:49.812
		F/file �����ִ�м�¼�����javaԴ�ļ�������������ʹ�ã�����ִ���ٶȲ�����κ����⡣
		caller{depth}��caller{depth, evaluator-1, ... evaluator-n}�����������־�ĵ����ߵ�λ����Ϣ������ѡ���ʾ�����Ϣ��ȡ�	
		L/line�����ִ����־������кš���������ʹ�ã�����ִ���ٶȲ�����κ����⡣
		m/msg/message�����Ӧ�ó����ṩ����Ϣ��
		M/method �� ���ִ����־����ķ���������������ʹ�ã�����ִ���ٶȲ�����κ����⡣
		n�����ƽ̨��صķ��з���\n�����ߡ�\r\n����
		p/le/level �������־����
		r/relative������ӳ���������������־��¼��ʱ�䣬��λ�Ǻ���
		t/thread�����������־���߳�����
		replace(p){r, t}�� p Ϊ��־���ݣ�r ��������ʽ����p �з���r �������滻Ϊt ��
			���磬 "%replace(%msg){'\s', ''}"
	��ʽ���η�����ת������ͬʹ�ã�
		��ѡ�ĸ�ʽ���η�λ�ڡ�%����ת����֮�䡣
		��һ����ѡ���η�������� ��־�������Ǽ��š�-����
		�����ǿ�ѡ����С��� ���η�����ʮ��������ʾ��
		����ַ�С����С��ȣ�������������䣬Ĭ��������䣨���Ҷ��룩������Ϊ�ո�
		����ַ�������С��ȣ��ַ���Զ���ᱻ�ضϡ������ ���η��������ǵ��"."�����ʮ��������
		����ַ���������ȣ����ǰ��ضϡ�����š�.������Ӽ��š�-���ڼ����֣���ʾ��β���ضϡ�
		���磺%-4relative ��ʾ��������ӳ���������������־��¼��ʱ�� ��������� ����С���Ϊ4��	
	filter:������
		ִ��һ�����������з��ظ�ö��ֵ����DENY��NEUTRAL��ACCEPT����֮һ��
			����DENY����־���������������پ���������������
			����NEUTRAL�������б�����¸������������Ŵ�����־��
			����ACCEPT����־�ᱻ�����������پ���ʣ���������
		����������ӵ�<Appender> �У�Ϊ<Appender> ���һ�������������󣬿�����������������־���й��ˡ�<Appender> �ж��������ʱ����������˳��ִ�С�		
		�����Ǽ������õĹ�������
			LevelFilter�� �����������������־������й��ˡ������־����������ü��𣬹����������onMath �� onMismatch���ջ�ܾ���־���������ӽڵ㣺
				<level>:���ù��˼���
				<onMatch>:�������÷��Ϲ��������Ĳ���DENY��NEUTRAL��ACCEPT����֮һ
				<onMismatch>:�������ò����Ϲ��������Ĳ���DENY��NEUTRAL��ACCEPT����֮һ
				���磺������������־��������ΪINFO������INFO�������־����appender������INFO�������־�������˵���
					<filter class="ch.qos.logback.classic.filter.LevelFilter">   
						<level>INFO</level>   
						<onMatch>ACCEPT</onMatch>   
						<onMismatch>DENY</onMismatch>   
					</filter>     	
			
			ThresholdFilter�� �ٽ�ֵ�����������˵�����ָ���ٽ�ֵ����־������־������ڻ�����ٽ�ֵʱ������������NEUTRAL������־��������ٽ�ֵʱ����־�ᱻ�ܾ���
				���磺���˵����е���INFO�������־��
					<!-- ���˵� TRACE �� DEBUG �������־-->   
				    <filter class="ch.qos.logback.classic.filter.ThresholdFilter">   
				     	<level>INFO</level>   
				    </filter> 
			EvaluatorFilter�� ��ֵ��������������������־�Ƿ����ָ���������������ӽڵ㣺
				evaluator:������
					���õļ�������JaninoEventEvaluato��Ҳ��Ĭ�ϵļ����������������Java����ֵ���ʽ��Ϊ��ֵ��������ֵ�����������ļ����͹��ɹ�����̬���룬����ֵ���ʽ����true�ͱ�ʾ���Ϲ���������
					evaluator�и��ӱ�ǩexpression��matcher
						expression������������ֵ��������ֵ���ʽ�����ڵ�ǰ��־��logback����ֵ���ʽ��¶��־�ĸ����ֶΣ���
							Name	        Type	         Description
							event	        LoggingEvent	  ���¼�����������ԭʼ��¼�¼����������б���������event�����磬event.getMessage()��������"message"��ͬ���ַ���
							message	        String	                         ��־��ԭʼ��Ϣ�����磬����logger mylogger��"name"��ֵ��"AUB"������ mylogger.info("Hello {}",name); "Hello {}"����ԭʼ��Ϣ��
							formatedMessage	String	                         ��־����ʽ������Ϣ�����磬����logger mylogger��"name"��ֵ��"AUB"������ mylogger.info("Hello {}",name); "Hello Aub"���Ǹ�ʽ�������Ϣ��
							logger	        String	         logger ����
							loggerContext	LoggerContextVO  ��־������logger�����ġ�
							level	        int	                                    �����Ӧ������ֵ������ level > INFO ����ȷ�ı��ʽ��
							timeStamp	    long	                         ������־��ʱ�����
							marker	        Marker	                         ����־�����������Marker����ע�⡰Marker���п���Ϊnull��������Ҫȷ����������null��
							mdc	            Map	                                    ����������־�ڼ��MDC����ֵ��map�����ʷ����ǣ�mdc.get("myKey") ��
																mdc.get()���ص���Object����String��Ҫ�����String�ķ�����Ҫǿת�����磬
															 	((String) mdc.get("k")).contains("val") .MDC����Ϊnull������ʱע�⡣
							throwable	    java.lang.Throwable	    ���û���쳣����־����"throwable" ����Ϊ null. ���ҵ��ǣ� "throwable" ���ܱ����л�����Զ��ϵͳ����ԶΪnull��������λ���޹صı��ʽ��ʹ������ı���throwableProxy
							throwableProxy	IThrowableProxy	    ����־�¼��������쳣�������û���쳣����־�¼������������"throwableProxy" Ϊ null. ���쳣����������־�¼�ʱ��"throwableProxy" ��Զ��ϵͳ�ϲ���Ϊnull  
						matcher��ƥ���������ܿ���ʹ��String���matches()��������ģʽƥ�䣬���ᵼ��ÿ�ε��ù�����ʱ���ᴴ��һ���µ�Pattern����Ϊ���������ֿ���������Ԥ����һ������matcher���󣬶����Ϳ�������ֵ���ʽ���ظ����á�
							matcher�а��������ӱ�ǩ��
								name�����ڶ���matcher�����֣���ֵ���ʽ��ʹ���������������matcher��
								regex����������ƥ��������
				onMatch:�������÷��Ϲ��������Ĳ���
				onMismatch:�������ò����Ϲ��������Ĳ���
				���磺���˵�������־��Ϣ�в�������billing���ַ�������־��
					<filter class="ch.qos.logback.core.filter.EvaluatorFilter">         
						<evaluator> <!-- Ĭ��Ϊ ch.qos.logback.classic.boolex.JaninoEventEvaluator -->   
							<expression>return message.contains("billing");</expression>   
						</evaluator>   
						<OnMatch>ACCEPT</OnMatch>  
						<OnMismatch>DENY</OnMismatch>  
					</filter>
				���磺��ƥ�����Ĺ�����
					<filter class="ch.qos.logback.core.filter.EvaluatorFilter">   
      					<evaluator>           
        					<matcher>   
	          					<Name>odd</Name>   
	          					<!-- filter out odd numbered statements -->   
	          					<regex>statement [13579]</regex>   
        					</matcher>   
       						<expression>odd.matches(formattedMessage)</expression>   
      					</evaluator>   
  						<OnMismatch>NEUTRAL</OnMismatch>   
     					<OnMatch>DENY</OnMatch>   
    				</filter>      

������ͨjava������spring-bootlogback �����ļ�
	Logback����ͨ��XML����ȡclasspath��logback.xml��logback-test.xml�ļ���
	��һ��spring bootӦ�ó�������԰�logback.xml�ļ�����Դ�ļ��С�
	������logback.xml�ļ������·��������Ҫʹ��logback.configurationfile��ָ��λ�ã���������
		-DLogback.configurationFile=/path/to/Logback.xml
						
����log4j��logback��Ҫ�Ƚ�
	������Ȼ������ͬ����log4j���ѱ��йܸ�Apache�����ά���������Դ�2012��5��֮���û�и����ˡ�
	��logback�ӳ�����ʼ���������߱���ȡ��log4j��Ŀ�Ŀ����ģ����һ����logback�̳���log4j�������÷���ʹ��ѧϰ��Ǩ�Ƶĳɱ����ߣ�
	��һ����logback��������Ҫ��������log4j���������ڴ��������Ļ����£�����������һЩlog4j��û�еĹ��ܣ��罫��־�ļ�ѹ����zip���ȣ�
�ġ�Spring MVC����slf4j-logback
	1���������
		<dependency>  
			<groupId>ch.qos.logback</groupId>  
	 	  	<artifactId>logback-classic</artifactId>  
	    	<version>1.1.3</version>  
		</dependency>  
		<dependency>  
		    <groupId>org.logback-extensions</groupId>  
		    <artifactId>logback-ext-spring</artifactId>  
		    <version>0.1.2</version>  
		</dependency>  
		<dependency>  
		    <groupId>org.slf4j</groupId>  
		    <artifactId>jcl-over-slf4j</artifactId>  
		    <version>1.7.12</version>  
		</dependency>
			������ʾ�Ǽ�������Ҫ�����������У�
				��һ��logback-classic������logback���������slf4j-api.jar��logback-core.jar��logback-classsic.jar
				�ڶ���logback-ext-spring���ɹٷ��ṩ�Ķ�Spring��֧�֣��ṩLogbackConfigListener���������þ��൱��log4j�е�Log4jConfigListener��
				������jcl-over-slf4j��������SpringԴ�����д���ʹ�õ���commons-logging�滻��slf4j��ֻ����������������֮����ܿ���Spring��ܱ����ӡ����־������ֻ�ܿ����������Լ���ӡ����־  
	2����дlogback.xml		
		logback��log4jһ����Ҳ��Ҫ��classpath�б�д�����ļ�����logback�����ļ��ƺ���log4j����һЩ��log4j����֧��xml��ʽ�������ļ�����֧��properties��ʽ�ģ���logbackֻ֧��xml��ʽ�ġ�
		���ڹٷ��ṩ��һ�����߹��ߣ����Խ�log4j��properties�ļ�ֱ��ת����logback��xml�ļ�		
	3������web.xml
		��log4j���ƣ�logback���ɵ�Spring MVC��Ŀ�У�Ҳ��Ҫ��web.xml�н������ã�ͬ��Ҳ������һ��configlocation��һ��configlistener��������ʾ��
		<context-param>  
			<param-name>logbackConfigLocation</param-name>  
			<param-value>classpath:logback.xml</param-value>  
		</context-param>  
		<listener>  
			<listener-class>ch.qos.logback.ext.spring.web.LogbackConfigListener</listener-class>  
		</listener>  	
	4������
		���Կ�����slf4j-log4j��slf4j-logback���ɵ�Spring MVC�����ƹ㵽����java Web��Ŀ�У��Ĳ����������ͬ�ġ�
		������Ϻ󣬾Ϳ���ͨ��slf4j�ṩ��API���ص�logback����log4j���ľ���ʵ�֣�ֱ�ӽ�����־������
		ʹ��slf4j-api��ʱ����Ҫע����ǣ�slf4j�����˵���ģʽ����Ŀ�д�����ÿһ��Loggerʵ�����ᰴ�㴫���name�������Class<?>ʵ��Ҳ�ᱻת����String�͵�name�����浽һ����̬��ConcurrentHashMap�У�
		���ֻҪname����Class<?>ʵ������ͬ��ÿ�η��ص�ʵ���϶���ͬһ��Loggerʵ����������ȫû��Ҫ��Loggerʵ����Ϊ������̬��Ա��������ȡ���ɡ�		
			