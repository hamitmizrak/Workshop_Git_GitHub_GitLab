package com.hamitmizrak;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import java.util.TimeZone;

// Mongo aktif etmek ici
// @EnableMongoRepositories

// Aspect aktif etmek icin
// @EnableAspectJAutoProxy(proxyTargetClass = true)

// Asenkron açmak icin
// @EnableAsync

// SCAN
// @EntityScan(basePackages = "com.hamitmizrak.data.entity") //Entity bulamadığı zaman
// @EnableJpaRepositories(basePackages = "com.hamitmizrak.data.repository") //Repository bulamadığı zaman

// Spring Cache aktif etmek gerekiyor.
// @EnableCaching

// Auditing Aktif etmek
@EnableJpaAuditing(auditorAwareRef = "auditorAwareBeanMethod")

// Spring Security
@SpringBootApplication(exclude = {
		//SecurityAutoConfiguration.class,
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
		org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class
}
)
public class JavaFullStackDeveloper10Application extends SpringBootServletInitializer { // extends SpringBootServletInitializer


	// for Tomcat
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(JavaFullStackDeveloper10Application.class);
	}

	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("IST"));
	}

	public static void main(String[] args)  {

		// devtools active isActive
		// System.setProperty("spring.devtools.restart.enabled","true");

		// PORT Ayarlamak
        /*
        SpringApplication app = new SpringApplication(TurgutUniversitySpringAllInOneApplication.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "8083"));
        app.run(args);
         */

		//Disables headless JOptionPane
		System.setProperty("java.awt.headless", "false");

		SpringApplication.run(JavaFullStackDeveloper10Application.class, args);
	}
}
