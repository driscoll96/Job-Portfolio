package com.tipperoo.springbootInfrastructure;

import com.stripe.Stripe;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootInfrastructureApplication {
	public static void main(String[] args) {
		//TODO: Need to use secrets manager when host on cloud service
		Stripe.apiKey = "sk_test_51Iwdi8EswD21EFVl4g8KnaIIo5xkF6oj4usvmKcPFkv5dbv5dHp18HT8lM3N3VkAdKRcqstYprIXXi6EtQPfbmoU002eIH02jZ";
		SpringApplication.run(SpringBootInfrastructureApplication.class, args);
	}
}
