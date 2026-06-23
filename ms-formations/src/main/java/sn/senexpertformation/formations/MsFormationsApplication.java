package sn.senexpertformation.formations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients // ← AJOUTER CETTE LIGNE
public class MsFormationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsFormationsApplication.class, args);
	}
}