package sg.zuehlke.drawing.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by celineheldner on 19.02.19.
 */
@RunWith(Parameterized.class)
public class CanvasBorderTest {

    private Canvas canvas = new Canvas();

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 4, 5, "-------\n|     |\n|     |\n|     |\n|     |\n-------\n" },
                { 3, 4, "------\n|    |\n|    |\n|    |\n------\n" },
                { 3, 8, "----------\n|        |\n|        |\n|        |\n----------\n" },
        });
    }

    @Parameterized.Parameter
    public int heightInput;

    @Parameterized.Parameter(1)
    public int widthInput;

    @Parameterized.Parameter(2)
    public String canvasExpected;

    @Test
    public void testDrawCanvas() {
        //given
        canvas.initCanvas(widthInput, heightInput);

        //when
        String output = canvas.toString();

        //then
        System.out.println(output);
        Assert.assertEquals(canvasExpected, output);
    }

}