package ar.gov.anses.sidu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import ar.gov.anses.sidu.configuration.ConfigurationReader;

@EnableScheduling
@EntityScan(basePackages = { "ar.gov.anses.sidu.entity" })
@ComponentScan(basePackages = { "ar.gov.anses.sidu" })
@SpringBootApplication
@EnableJpaRepositories("ar.gov.anses.sidu.repository")
public class Application extends SpringBootServletInitializer {

	public Application() {
		// SpringApplication.run(Application.class);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		ConfigurationReader cr = new ConfigurationReader();
		try {
			if (!cr.loadConfiguration())
				throw new Exception("Error al cargar la configuracion");
			return application.sources(Application.class);
		} catch (Exception e) {
			e.printStackTrace();
			return application.sources(Application.class);
		}
	}

	public static void main(String[] args) throws Exception {
		ConfigurationReader cr = new ConfigurationReader();
		if (cr.loadConfiguration())
			SpringApplication.run(applicationClass, args);
		else
			throw new Exception("Error al cargar la configuracion");
	}

	private static Class<Application> applicationClass = Application.class;

}