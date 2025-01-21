package az.atlacademy.libraryclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LibraryclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryclientApplication.class, args);
	}

}
