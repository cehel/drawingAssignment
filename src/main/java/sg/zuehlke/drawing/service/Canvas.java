package sg.zuehlke.drawing.service;

import org.springframework.stereotype.Component;
import sg.zuehlke.drawing.model.Pixel;

import java.util.Collection;

/**
 * Created by celineheldner on 19.02.19.
 */
@Component
public class Canvas {
    private char[][] representation;

    void initCanvas(int width, int height) {
        if (height < 1 || width < 1) {
            throw new IllegalArgumentException("width and height must be bigger than 0!");
        }
        representation = new char[height + 2][width + 2];
        drawEmptyCanvasWithBorder();
    }

    void drawRectangle(int x1, int y1, int x2, int y2) {
        drawHorizontalLine(x1, x2, y1);
        drawHorizontalLine(x1, x2, y2);
        drawVerticalLine(y1, y2, x1);
        drawVerticalLine(y1, y2, x2);
    }

    void drawLine(int x1, int y1, int x2, int y2) throws IllegalArgumentException {
        if (representation == null) {
            throw new UnsupportedOperationException("The canvas needs to be created before starting to draw. Use 'C width height' first.");
        }
        if (!isInsideCanvas(x1, y1) || !isInsideCanvas(x2, y2)) {
            throw new IllegalArgumentException("Line should be within bounds!");
        }
        if (x1 == x2) {
            drawVerticalLine(y1, y2, x1);
        } else if (y1 == y2) {
            drawHorizontalLine(x1, x2, y1);
        } else {
            throw new IllegalArgumentException("Only horizontal or vertical lines can be drawn!");
        }
    }

    char getColor(Pixel pixel) {
        return getColor(pixel.getX(), pixel.getY());
    }

    char getColor(int x, int y) {
        return representation[y][x];
    }

    void fill(int x, int y, char color) {
        if (representation == null) {
            throw new UnsupportedOperationException("The canvas needs to be created before starting to draw. Use 'C width height' first.");
        }
        FillTool filler = new FillTool();
        Collection<Pixel> pixelsToFill = filler.findPixelsToFill(x, y, this);
        for (Pixel pixel : pixelsToFill) {
            representation[pixel.getY()][pixel.getX()] = color;
        }
    }


    private void drawEmptyCanvasWithBorder() {
        for (int i = 0; i < representation.length; i++) {
            for (int j = 0; j < representation[i].length; j++) {
                if (i == 0 || i == representation.length - 1) {
                    representation[i][j] = '-';
                } else if (j == 0 || j == representation[i].length - 1) {
                    representation[i][j] = '|';
                } else {
                    representation[i][j] = ' ';
                }
            }
        }
    }

    boolean isInsideCanvas(Pixel pixel) {
        return isInsideCanvas(pixel.getX(), pixel.getY());
    }

    private boolean isInsideCanvas(int x, int y) {
        if (y < 1 || y >= representation.length - 1) {
            return false;
        }
        if (x < 1 || x >= representation[0].length - 1) {
            return false;
        }
        return true;
    }

    private void drawHorizontalLine(int x1, int x2, int col) {
        drawLine(x1, x2, col, true);
    }

    private void drawVerticalLine(int y1, int y2, int row) {
        drawLine(y1, y2, row, false);
    }

    private void drawLine(int coord1, int coord2, int place, boolean horizontal) {
        int from = Math.min(coord2, coord1);
        int to = Math.max(coord2, coord1);
        for (int i = from; i <= to; i++) {
            if (horizontal) {
                representation[place][i] = 'x';
            } else {
                representation[i][place] = 'x';
            }
        }
    }

    public String toString() {
        String output = "";
        for (int i = 0; i < representation.length; i++) {
            for (int j = 0; j < representation[i].length; j++) {
                output += representation[i][j];
            }
            output += "\n";
        }
        return output;
    }
}
