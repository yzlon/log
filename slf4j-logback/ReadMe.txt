
一、encoder：
	负责两件事，一是把日志信息转换成字节数组，二是把字节数组写入到输出流。
	目前PatternLayoutEncoder 是唯一有用的且默认的encoder ，有一个<pattern>节点，用来设置日志的输入格式。使用“%”加“转换符”方式，如果要输出“%”，则必须用“\”对“\%”进行转义。
	例如：
		Xml代码  
		<encoder>   
		   <pattern>%-4relative [%thread] %-5level %logger{35} - %msg%n</pattern>   
		</encoder  
	<pattern>里面的转换符说明：
		c{length }、lo{length } 、logger{length } ：输出日志的logger名，可有一个整形参数，功能是缩短logger名，设置为0表示只输入logger最右边点符号之后的字符串。
			%logger	    mainPackage.sub.sample.Bar	mainPackage.sub.sample.Bar
			%logger{0}	mainPackage.sub.sample.Bar	Bar
			%logger{5}	mainPackage.sub.sample.Bar	m.s.s.Bar
			%logger{10}	mainPackage.sub.sample.Bar	m.s.s.Bar
			%logger{15}	mainPackage.sub.sample.Bar	m.s.sample.Bar
			%logger{16}	mainPackage.sub.sample.Bar	m.sub.sample.Bar
			%logger{26}	mainPackage.sub.sample.Bar	mainPackage.sub.sample.Bar
		C{length }、class{length }： 	输出执行记录请求的调用者的全限定名。参数与上面的一样。尽量避免使用，除非执行速度不造成任何问题。
		contextName、cn ：输出上下文名称。
		d{pattern}、date{pattern } ： 输出日志的打印日志，模式语法与java.text.SimpleDateFormat 兼容。
			%d	                                2006-10-20 14:06:49,812
			%date	                            2006-10-20 14:06:49,812
			%date{ISO8601}	                    2006-10-20 14:06:49,812
			%date{HH:mm:ss.SSS}	                14:06:49.812
			%date{dd MMM yyyy ;HH:mm:ss.SSS}	20 oct. 2006;14:06:49.812
		F/file ：输出执行记录请求的java源文件名。尽量避免使用，除非执行速度不造成任何问题。
		caller{depth}、caller{depth, evaluator-1, ... evaluator-n}；输出生成日志的调用者的位置信息，整数选项表示输出信息深度。	
		L/line：输出执行日志请求的行号。尽量避免使用，除非执行速度不造成任何问题。
		m/msg/message：输出应用程序提供的信息。
		M/method ： 输出执行日志请求的方法名。尽量避免使用，除非执行速度不造成任何问题。
		n：输出平台相关的分行符“\n”或者“\r\n”。
		p/le/level ：输出日志级别。
		r/relative：输出从程序启动到创建日志记录的时间，单位是毫秒
		t/thread：输出产生日志的线程名。
		replace(p){r, t}： p 为日志内容，r 是正则表达式，将p 中符合r 的内容替换为t 。
			例如， "%replace(%msg){'\s', ''}"
	格式修饰符，与转换符共同使用：
		可选的格式修饰符位于“%”和转换符之间。
		第一个可选修饰符是左对齐 标志，符号是减号“-”；
		接着是可选的最小宽度 修饰符，用十进制数表示。
		如果字符小于最小宽度，则左填充或右填充，默认是左填充（即右对齐），填充符为空格。
		如果字符大于最小宽度，字符永远不会被截断。最大宽度 修饰符，符号是点号"."后面加十进制数。
		如果字符大于最大宽度，则从前面截断。点符号“.”后面加减号“-”在加数字，表示从尾部截断。
		例如：%-4relative 表示，将输出从程序启动到创建日志记录的时间 进行左对齐 且最小宽度为4。	
	filter:过滤器
		执行一个过滤器会有返回个枚举值，即DENY，NEUTRAL，ACCEPT其中之一。
			返回DENY，日志将立即被抛弃不再经过其他过滤器；
			返回NEUTRAL，有序列表里的下个过滤器过接着处理日志；
			返回ACCEPT，日志会被立即处理，不再经过剩余过滤器。
		过滤器被添加到<Appender> 中，为<Appender> 添加一个或多个过滤器后，可以用任意条件对日志进行过滤。<Appender> 有多个过滤器时，按照配置顺序执行。		
		下面是几个常用的过滤器：
			LevelFilter： 级别过滤器，根据日志级别进行过滤。如果日志级别等于配置级别，过滤器会根据onMath 和 onMismatch接收或拒绝日志。有以下子节点：
				<level>:设置过滤级别
				<onMatch>:用于配置符合过滤条件的操作DENY，NEUTRAL，ACCEPT其中之一
				<onMismatch>:用于配置不符合过滤条件的操作DENY，NEUTRAL，ACCEPT其中之一
				例如：将过滤器的日志级别配置为INFO，所有INFO级别的日志交给appender处理，非INFO级别的日志，被过滤掉。
					<filter class="ch.qos.logback.classic.filter.LevelFilter">   
						<level>INFO</level>   
						<onMatch>ACCEPT</onMatch>   
						<onMismatch>DENY</onMismatch>   
					</filter>     	
			
			ThresholdFilter： 临界值过滤器，过滤掉低于指定临界值的日志。当日志级别等于或高于临界值时，过滤器返回NEUTRAL；当日志级别低于临界值时，日志会被拒绝。
				例如：过滤掉所有低于INFO级别的日志。
					<!-- 过滤掉 TRACE 和 DEBUG 级别的日志-->   
				    <filter class="ch.qos.logback.classic.filter.ThresholdFilter">   
				     	<level>INFO</level>   
				    </filter> 
			EvaluatorFilter： 求值过滤器，评估、鉴别日志是否符合指定条件。有以下子节点：
				evaluator:鉴别器
					常用的鉴别器是JaninoEventEvaluato，也是默认的鉴别器，它以任意的Java布尔值表达式作为求值条件，求值条件在配置文件解释过成功被动态编译，布尔值表达式返回true就表示符合过滤条件。
					evaluator有个子标签expression和matcher
						expression，用于配置求值条件。求值表达式作用于当前日志，logback向求值表达式暴露日志的各种字段：、
							Name	        Type	         Description
							event	        LoggingEvent	  与记录请求相关联的原始记录事件，下面所有变量都来自event，例如，event.getMessage()返回下面"message"相同的字符串
							message	        String	                         日志的原始消息，例如，设有logger mylogger，"name"的值是"AUB"，对于 mylogger.info("Hello {}",name); "Hello {}"就是原始消息。
							formatedMessage	String	                         日志被各式话的消息，例如，设有logger mylogger，"name"的值是"AUB"，对于 mylogger.info("Hello {}",name); "Hello Aub"就是格式化后的消息。
							logger	        String	         logger 名。
							loggerContext	LoggerContextVO  日志所属的logger上下文。
							level	        int	                                    级别对应的整数值，所以 level > INFO 是正确的表达式。
							timeStamp	    long	                         创建日志的时间戳。
							marker	        Marker	                         与日志请求相关联的Marker对象，注意“Marker”有可能为null，所以你要确保它不能是null。
							mdc	            Map	                                    包含创建日志期间的MDC所有值得map。访问方法是：mdc.get("myKey") 。
																mdc.get()返回的是Object不是String，要想调用String的方法就要强转，例如，
															 	((String) mdc.get("k")).contains("val") .MDC可能为null，调用时注意。
							throwable	    java.lang.Throwable	    如果没有异常与日志关联"throwable" 变量为 null. 不幸的是， "throwable" 不能被序列化。在远程系统上永远为null，对于与位置无关的表达式请使用下面的变量throwableProxy
							throwableProxy	IThrowableProxy	    与日志事件关联的异常代理。如果没有异常与日志事件关联，则变量"throwableProxy" 为 null. 当异常被关联到日志事件时，"throwableProxy" 在远程系统上不会为null  
						matcher：匹配器，尽管可以使用String类的matches()方法进行模式匹配，但会导致每次调用过滤器时都会创建一个新的Pattern对象，为了消除这种开销，可以预定义一个或多个matcher对象，定义后就可以在求值表达式中重复引用。
							matcher中包含两个子标签，
								name：用于定义matcher的名字，求值表达式中使用这个名字来引用matcher；
								regex：用于配置匹配条件。
				onMatch:用于配置符合过滤条件的操作
				onMismatch:用于配置不符合过滤条件的操作
				例如：过滤掉所有日志消息中不包含“billing”字符串的日志。
					<filter class="ch.qos.logback.core.filter.EvaluatorFilter">         
						<evaluator> <!-- 默认为 ch.qos.logback.classic.boolex.JaninoEventEvaluator -->   
							<expression>return message.contains("billing");</expression>   
						</evaluator>   
						<OnMatch>ACCEPT</OnMatch>  
						<OnMismatch>DENY</OnMismatch>  
					</filter>
				又如：带匹配器的过滤器
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

二、普通java程序，如spring-bootlogback 配置文件
	Logback配置通过XML，读取classpath的logback.xml或logback-test.xml文件。
	在一个spring boot应用程序，你可以把logback.xml文件在资源文件夹。
	如果你的logback.xml文件以外的路径，你需要使用logback.configurationfile来指定位置，像这样：
		-DLogback.configurationFile=/path/to/Logback.xml
						
三、log4j与logback简要比较
	两者虽然作者相同，但log4j早已被托管给Apache基金会维护，并且自从2012年5月之后就没有更新了。
	而logback从出生开始就是其作者奔着取代log4j的目的开发的，因此一方面logback继承了log4j大量的用法，使得学习和迁移的成本不高，
	另一方面logback在性能上要明显优于log4j，尤其是在大量并发的环境下，并且新增了一些log4j所没有的功能（如将日志文件压缩成zip包等）
四、Spring MVC集成slf4j-logback
	1、添加依赖
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
			如上所示是集成所需要的依赖，其中：
				第一个logback-classic包含了logback本身所需的slf4j-api.jar、logback-core.jar及logback-classsic.jar
				第二个logback-ext-spring是由官方提供的对Spring的支持，提供LogbackConfigListener，它的作用就相当于log4j中的Log4jConfigListener；
				第三个jcl-over-slf4j是用来把Spring源代码中大量使用到的commons-logging替换成slf4j，只有在添加了这个依赖之后才能看到Spring框架本身打印的日志，否则只能看到开发者自己打印的日志  
	2、编写logback.xml		
		logback与log4j一样，也需要在classpath中编写配置文件。但logback配置文件似乎比log4j复杂一些：log4j不仅支持xml格式的配置文件，还支持properties格式的，而logback只支持xml格式的。
		好在官方提供了一个在线工具，可以将log4j的properties文件直接转换成logback的xml文件		
	3、配置web.xml
		与log4j类似，logback集成到Spring MVC项目中，也需要在web.xml中进行配置，同样也是配置一个configlocation和一个configlistener，如下所示：
		<context-param>  
			<param-name>logbackConfigLocation</param-name>  
			<param-value>classpath:logback.xml</param-value>  
		</context-param>  
		<listener>  
			<listener-class>ch.qos.logback.ext.spring.web.LogbackConfigListener</listener-class>  
		</listener>  	
	4、其它
		可以看出，slf4j-log4j和slf4j-logback集成到Spring MVC（或推广到其它java Web项目中）的步骤大体是相同的。
		集成完毕后，就可以通过slf4j提供的API隐藏掉logback（或log4j）的具体实现，直接进行日志处理了
		使用slf4j-api的时候，需要注意的是：slf4j采用了单例模式，项目中创建的每一个Logger实例都会按你传入的name（传入的Class<?>实例也会被转换成String型的name）保存到一个静态的ConcurrentHashMap中；
		因此只要name（或Class<?>实例）相同，每次返回的实际上都是同一个Logger实例。所以完全没必要把Logger实例作为常量或静态成员，随用随取即可。		
			