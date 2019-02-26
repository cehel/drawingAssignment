package sg.zuehlke.drawing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

/**
 * Created by celineheldner on 19.02.19.
 */
@ShellComponent
public class CommandLineInterface {

    private Canvas canvas;

    @Autowired
    public CommandLineInterface(Canvas canvas) {
        this.canvas = canvas;
    }

    @ShellMethod(value = "Draw new canvas with width and height", key = "C")
    String drawCanvas(int width, int height) {
        canvas.initCanvas(width, height);
        return canvas.toString();
    }

    @ShellMethod(value = "Draw Line from x1, y1 to x2, y2", key = "L")
    String drawLine(int x1, int y1, int x2, int y2) {
        canvas.drawLine(x1, y1, x2, y2);
        return canvas.toString();
    }

    @ShellMethod(value = "Draw Rectangle from x1, y1 to x2, y2", key = "R")
    String drawRectangle(int x1, int y1, int x2, int y2) {
        canvas.drawRectangle(x1, y1, x2, y2);
        return canvas.toString();
    }

    @ShellMethod(value = "Fill on point x, y with color", key = "B")
    String fill(int x, int y, char c) {
        canvas.fill(x, y, c);
        return canvas.toString();
    }

    @ShellMethod(value = "Quit the program", key = "Q")
    public void quit() {
        System.exit(0);
    }
}