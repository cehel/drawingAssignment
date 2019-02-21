package sg.zuehlke.drawing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class DrawingApplication{

    public static void main(String[] args) {
        SpringApplication.run(DrawingApplication.class, args);
    }
}

