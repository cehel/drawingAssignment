package sg.zuehlke.drawing.service;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by celineheldner on 19.02.19.
 */
public class CanvasTest {

    private Canvas canvas = new Canvas();


    @Test
    public void testDrawLine() {
        //given
        canvas.initCanvas(20, 4);
        canvas.drawLine(1,2,6,2);
        canvas.drawLine(6,3,6,4);

        //when
        String output = canvas.toString();
        System.out.println(output);

        //then
        String expected =
                "----------------------\n" +
                "|                    |\n" +
                "|xxxxxx              |\n" +
                "|     x              |\n" +
                "|     x              |\n" +
                "----------------------\n";
        Assert.assertEquals(expected, output);
    }

    @Test
    public void testDrawRectangle() {
        //given
        canvas.initCanvas(20, 4);
        canvas.drawRectangle(14, 1, 18, 3);

        //when
        String output = canvas.toString();
        System.out.println(output);

        //then
        String expected =
                "----------------------\n" +
                "|             xxxxx  |\n" +
                "|             x   x  |\n" +
                "|             xxxxx  |\n" +
                "|                    |\n" +
                "----------------------\n";
        Assert.assertEquals(expected, output);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testDrawLineFails() {
        //given then
        canvas.initCanvas(20, 4);
        canvas.drawLine(6,3,6,5);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testDrawLineWithIllegalCoordinates() {
        //given then
        canvas.initCanvas(20, 4);
        canvas.drawLine(1, 3, 3, 1);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testDrawCanvasFails() {
        //given then
        canvas.initCanvas(20, 0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testDrawFillFails() {
        //given then
        canvas.fill(2, 1, 'c');
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testDrawLineWithoutFails() {
        //given then
        canvas.drawLine(1, 2, 1,6);
    }

    @Test
    public void testFillCanvas() {
        //given
        canvas.initCanvas(20, 4);
        canvas.drawRectangle(14, 1, 18, 3);
        canvas.drawLine(1,2,6,2);
        canvas.drawLine(6,3,6,4);
        canvas.fill(10, 3, 'o');

        //when
        String output = canvas.toString();
        System.out.println(output);

        //then
        String expected =
                "----------------------\n" +
                "|oooooooooooooxxxxxoo|\n" +
                "|xxxxxxooooooox   xoo|\n" +
                "|     xoooooooxxxxxoo|\n" +
                "|     xoooooooooooooo|\n" +
                "----------------------\n";
        Assert.assertEquals(expected, output);
    }

    @Test
    public void testfillRectangleBorderAndInside() {
        //given
        canvas.initCanvas(20, 4);
        canvas.drawRectangle(14, 1, 18, 3);
        canvas.fill(14, 1, 'm');
        canvas.fill(15, 2, 'c');

        //when
        String output = canvas.toString();
        System.out.println(output);

        //then
        String expected =
                "----------------------\n" +
                "|             mmmmm  |\n" +
                "|             mcccm  |\n" +
                "|             mmmmm  |\n" +
                "|                    |\n" +
                "----------------------\n";
        Assert.assertEquals(expected, output);
    }
}