package com.mydomain.DbService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mydomain.DbService.model.Customer;
import com.mydomain.DbService.repository.CustomerRepository;

/**
 * Hello world!
 *
 *INSERT INTO USER(ID, CLIENT_ID, CLIENT_NAME, USER_ADDRESS, USER_FIRST_NAME, USER_ID, USER_LAST_NAME, USER_PHONE)
VALUES (2, '456', 'BestBuy', '9490 foxhill dr', 'Kondi',88,'mailaram','1234567891')
 */
@SpringBootApplication
public class App 
{
	private static final Logger log = LoggerFactory.getLogger(App.class);
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
    @Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Customer("Jack", "Bauer","Wallmart","1234"));
			repository.save(new Customer("Chloe", "O'Brian","BestBuy","6789"));
			repository.save(new Customer("Kim", "Bauer","Kohls","0980"));
			repository.save(new Customer("David", "Palmer","SamsClub","7654"));
			repository.save(new Customer("Michelle", "Dessler","Target","4356"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			repository.findById(1L)
				.ifPresent(customer -> {
					log.info("Customer found with findById(1L):");
					log.info("--------------------------------");
					log.info(customer.toString());
					log.info("");
				});

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByClientName("Wallmart").forEach(bauer -> {
				log.info(bauer.toString());
			});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			// 	log.info(bauer.toString());
			// }
			log.info("");
		};
	}
}
