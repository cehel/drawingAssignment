package sg.zuehlke.drawing;


import sg.zuehlke.drawing.model.Pixel;

import java.util.*;

/**
 * Created by celineheldner on 19.02.19.
 */
class FillTool {
    private Canvas canvas;
    private Set<Pixel> toBeColored = new HashSet<>();
    private List<Pixel> toBeVisited = new ArrayList<>();
    private Set<Pixel> alreadyVisited = new HashSet<>();
    private char currentColor;


    Collection<Pixel> findPixelsToFill(int x, int y, Canvas canvas) {
        init();
        this.canvas = canvas;
        this.toBeVisited.add(new Pixel(x, y));
        this.currentColor = canvas.getColor(x, y);
        fill();
        return toBeColored;
    }

    private void init(){
        toBeColored.clear();
        toBeVisited.clear();
        alreadyVisited.clear();
    }

    private void fill(){
        while(!toBeVisited.isEmpty()){
            Pixel pixel = toBeVisited.get(0);
            if (pixelHasCurrentColor(pixel)) {
                this.toBeColored.add(pixel);
            }
            toBeVisited.remove(pixel);
            alreadyVisited.add(pixel);
            addToVisit(pixel.getX(), pixel.getY());
        }
    }

    private boolean pixelHasCurrentColor(Pixel pixel) {
        return canvas.getColor(pixel) == currentColor;
    }

    private void addToVisit(int x, int y) {
        Pixel pixelAbove = new Pixel(x - 1, y);
        Pixel pixelBelow = new Pixel(x + 1, y);
        Pixel pixelLeft = new Pixel(x, y - 1);
        Pixel pixelRight = new Pixel(x, y + 1);

        addPixelToVisit(pixelAbove);
        addPixelToVisit(pixelBelow);
        addPixelToVisit(pixelLeft);
        addPixelToVisit(pixelRight);

    }

    private void addPixelToVisit(Pixel pixel) {
        if (
                canvas.isInsideCanvas(pixel)
                && canvas.getColor(pixel) == currentColor
                && !alreadyVisited.contains(pixel)
                && !toBeVisited.contains(pixel))
        {
            toBeVisited.add(pixel);
        }
    }
}
