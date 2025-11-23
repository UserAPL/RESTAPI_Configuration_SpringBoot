package in.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan

public class RestApiConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiConfigApplication.class, args);
	}


}
