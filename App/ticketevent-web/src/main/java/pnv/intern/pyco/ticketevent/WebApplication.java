package pnv.intern.pyco.ticketevent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class WebApplication extends SpringBootServletInitializer{
	public static void main(String[] args) throws Exception {
		SpringApplication app = new SpringApplication(WebApplication.class);
		
		app.run(args);

	}

}
