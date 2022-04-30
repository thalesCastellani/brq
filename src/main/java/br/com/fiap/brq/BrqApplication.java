package br.com.fiap.brq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class BrqApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrqApplication.class, args);
	}

}
