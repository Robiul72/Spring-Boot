package com.javawhizz.stripePayment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StripePaymentApplication {

    public static String apikey;

    public static void main(String[] args) {
		SpringApplication.run(StripePaymentApplication.class, args);
	}

}
