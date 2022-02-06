package pl.robertprogramista.testasync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class TestAsyncApplication {
	public static void main(String[] args) {
		SpringApplication.run(TestAsyncApplication.class, args);
	}
}
