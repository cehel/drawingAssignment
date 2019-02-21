package sg.zuehlke.drawing;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/* Created by celineheldner on 2019-02-15 */


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
    public void testDrawCanvasFails() {
        //given then
        canvas.initCanvas(20, 0);
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