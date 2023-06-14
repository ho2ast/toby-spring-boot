package tobyspring.helloboot;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import tobyspring.config.MySpringBootApplication;

import javax.annotation.PostConstruct;

@MySpringBootApplication
public class HellobootApplication {
//	@Bean
//	public HelloController helloController(HelloService helloService) {
//		return new HelloController(helloService);
//	}
//
//	@Bean
//	public HelloService helloService() {
//		return new SimpleHelloService();
//	}
//	@Bean
//	public ServletWebServerFactory servletWebServerFactory() {
//		return new TomcatServletWebServerFactory();
//	}
//
//	@Bean
//	public DispatcherServlet dispatcherServlet() {
//		return new DispatcherServlet();
//	}

	private final JdbcTemplate jdbcTemplate;

	public HellobootApplication(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@PostConstruct
	void init() {
		jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
	}

	@Bean
	ApplicationRunner applicationRunner(Environment env) {
		return arg -> {
			String name = env.getProperty("my.name");
			System.out.println("my.name: " + name);
		};
	}

	public static void main(String[] args) {
		// Spring Container init
		// Using @Bean
		SpringApplication.run(HellobootApplication.class, args);

//		GenericWebApplicationContext applicationContext = new GenericWebApplicationContext() {
//			@Override
//			protected void onRefresh() {
//				super.onRefresh();
//				// DispatcherServlet
//				ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
//				WebServer webServer = serverFactory.getWebServer(servletContext -> {
//					servletContext.addServlet("dispatcherServlet",
//							new DispatcherServlet(this)
//					).addMapping("/*");
//				});
//				webServer.start();
//			}
//		};
//		GenericWebApplicationContext applicationContext = new GenericWebApplicationContext()
//		applicationContext.registerBean(HelloController.class);
//		applicationContext.registerBean(SimpleHelloService.class);
//		applicationContext.refresh();

		// DispatcherServlet
//		ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
//		WebServer webServer = serverFactory.getWebServer(servletContext -> {
//			servletContext.addServlet("dispatcherServlet",
//					new DispatcherServlet(applicationContext)
//			).addMapping("/*");
//		});

//		WebServer webServer = serverFactory.getWebServer(servletContext -> {
//			servletContext.addServlet("frontcontroller", new HttpServlet() {
//				@Override
//				protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//					// 인증, 보안, 다국어, 공통 기능
//					if (req.getRequestURI().equals("/hello") && req.getMethod().equals(HttpMethod.GET.name())) {
//						String name = req.getParameter("name");
//
//						HelloController helloController = applicationContext.getBean(HelloController.class);
//						String ret = helloController.hello(name);
//
//						resp.setContentType(MediaType.TEXT_PLAIN_VALUE);
//						resp.getWriter().print(ret);
//					}
//					else {
//						resp.setStatus(HttpStatus.NOT_FOUND.value());
//					}
//				}
//			}).addMapping("/*");
//		});
//		webServer.start();
	}
}
