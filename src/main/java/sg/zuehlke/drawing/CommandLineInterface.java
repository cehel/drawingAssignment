package sg.zuehlke.drawing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by celineheldner on 20.02.19.
 */
@Service
public class CommandLineInterface {

    @Autowired
    private Canvas canvas;

    /**
     *
     * @param command: Currently the following commands are supported:
     *               'C [width] [height]' Create Canvas
     *               'L [x1] [y1] [x2] [y2]' Draw Line
     *               'R [x1] [y1] [x2] [y2]' Draw Rectangle
     *               'B [x] [y] [color]' fill with character-color
     *               'Q' quit the program
     * @return The string representation of the drawing
     */
    public String call( String command ){
        if( command == null || command.isEmpty()) {
            return "Please enter a command";
        }
        char function = command.charAt(0);
        switch (function) {
            case 'C':
                return drawCanvas(command);
            case 'L':
                return drawLine(command);
            case 'R':
                return drawRectangle(command);
            case 'B':
                return fill(command);
            case 'Q':
                return "PROGRAM EXIT";
            default:
                return "Please enter a valid command";
        }
    }


    private String drawCanvas(String command){
        final String[] arguments = command.split(" ");
        if (arguments.length < 3) {
            return "Not enough arguments provided to create Canvas with command 'C width height'";
        }
        try {
            int width = Integer.parseInt(arguments[1]);
            int height = Integer.parseInt(arguments[2]);
            canvas.initCanvas(width, height);
            return canvas.toString();
        }
        catch (NumberFormatException e)
        {
            return "Arguments provided were not numbers for command 'C width height'";
        }
    }


    private String drawLine(String command) {
        final String[] arguments = command.split(" ");
        if (arguments.length < 5) {
            return "Not enough arguments provided to draw Line with command 'L x1 y1 x2 y2'";
        }
        try {

            int x1 = Integer.parseInt(arguments[1]);
            int y1 = Integer.parseInt(arguments[2]);
            int x2 = Integer.parseInt(arguments[3]);
            int y2 = Integer.parseInt(arguments[4]);

            if (canvas == null){
                return "First create a canvas with command: 'C width height'";
            }
            canvas.drawLine(x1, y1, x2, y2);
            return canvas.toString();


        } catch (NumberFormatException e) {
            return "Arguments provided were not numbers for command 'L x1 y1 x2 y2'";
        } catch (IllegalArgumentException ex) {
            return ex.getMessage();
        }
    }

    private String drawRectangle(String command) {
        final String[] arguments = command.split(" ");
        if (arguments.length < 5) {
            return "Not enough arguments provided to draw Rectangle with command 'R x1 y1 x2 y2'";
        }
        try {

            int x1 = Integer.parseInt(arguments[1]);
            int y1 = Integer.parseInt(arguments[2]);
            int x2 = Integer.parseInt(arguments[3]);
            int y2 = Integer.parseInt(arguments[4]);

            if (canvas == null){
                return "First create a canvas with command: 'C width height'";
            }
            canvas.drawRectangle(x1, y1, x2, y2);
            return canvas.toString();


        } catch (NumberFormatException e) {
            return "Arguments provided were not numbers for command 'R x1 y1 x2 y2'";
        } catch (IllegalArgumentException ex) {
            return ex.getMessage();
        }
    }

    private String fill(String command) {
        final String[] arguments = command.split(" ");
        if (arguments.length < 4) {
            return "Not enough arguments provided to fill canvas with command 'B x y c'";
        }
        try {

            int x = Integer.parseInt(arguments[1]);
            int y = Integer.parseInt(arguments[2]);
            char c = arguments[3].charAt(0);

            if (canvas == null){
                return "First create a canvas with command: 'C width height'";
            }
            canvas.fill(x, y, c);
            return canvas.toString();


        } catch (NumberFormatException e) {
            return "Arguments provided were not numbers for command 'R x1 y1 x2 y2'";
        } catch (IllegalArgumentException ex) {
            return ex.getMessage();
        }
    }

}
