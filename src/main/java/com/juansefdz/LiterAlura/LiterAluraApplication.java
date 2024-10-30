package com.juansefdz.LiterAlura;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.juansefdz.LiterAlura.Main.Menu;

@SpringBootApplication
public class LiterAluraApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(LiterAluraApplication.class, args);
        Menu menu = context.getBean(Menu.class); 
        menu.menu(); 
    }
}