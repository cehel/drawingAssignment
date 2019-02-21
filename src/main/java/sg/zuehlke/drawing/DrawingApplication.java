package sg.zuehlke.drawing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class DrawingApplication implements CommandLineRunner {
    @Autowired
    private CommandLineInterface commandLineInterface;

    public static void main(String[] args) {
        SpringApplication.run(DrawingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        String command = "";
        while (!command.equals("Q")) {
            System.out.print("Enter command: ");
            command = scanner.nextLine();
            System.out.println(commandLineInterface.call(command));
        }

    }
}

