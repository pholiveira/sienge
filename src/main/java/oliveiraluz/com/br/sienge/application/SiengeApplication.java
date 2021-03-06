package oliveiraluz.com.br.sienge.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication(scanBasePackages = "oliveiraluz.com.br.sienge.*")
public class SiengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SiengeApplication.class, args);
	}
}
