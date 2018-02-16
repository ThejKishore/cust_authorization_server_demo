package com.kish.demooauthserver;

import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

@SpringBootApplication
public class DemooauthserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemooauthserverApplication.class, args);

		/*SpringApplication springApplication = new SpringApplication();
		springApplication.setBanner(new Banner() {
			@Override
			public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
				out.print("Thej Kishore Karuneegar");
			}
		});
		springApplication.setBannerMode(Banner.Mode.OFF);
		springApplication.run(DemooauthserverApplication.class,args);
*/
	}

	@Bean
	CommandLineRunner runner() {
		return (args) -> {
			System.out.println("----");
		};
	}


}
