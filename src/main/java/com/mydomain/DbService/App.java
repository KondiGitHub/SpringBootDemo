package com.mydomain.DbService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 *INSERT INTO USER(ID, CLIENT_ID, CLIENT_NAME, USER_ADDRESS, USER_FIRST_NAME, USER_ID, USER_LAST_NAME, USER_PHONE)
VALUES (2, '456', 'BestBuy', '9490 foxhill dr', 'Kondi',88,'mailaram','1234567891')
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
