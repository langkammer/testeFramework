package br.com.robson.provaframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class RodarMain {

	public static void main(String[] args) {
		SpringApplication.run(RodarMain.class, args);
	}

}
