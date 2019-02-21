package sg.zuehlke.drawing;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

/* Created by celineheldner on 2019-02-21 */

public class CommandLineInterfaceTest {

    private CommandLineInterface commandLineInterface;

    @Mock
    private Canvas canvas = mock(Canvas.class);

    @Before
    public void init(){
        commandLineInterface = new CommandLineInterface(canvas);
    }

    @Test
    public void drawCanvas() {
        commandLineInterface.drawCanvas(20,40);
        verify(canvas, times(1)).initCanvas(20, 40);
    }

    @Test
    public void drawRectangle() {
        commandLineInterface.drawCanvas(20,40);
        commandLineInterface.drawRectangle(1,4, 3, 1);
        verify(canvas, times(1)).drawRectangle(1, 4, 3, 1);
    }

    @Test
    public void drawLine() {
        commandLineInterface.drawCanvas(20,40);
        commandLineInterface.drawLine(1,4, 3, 4);
        verify(canvas, times(1)).drawLine(1, 4, 3, 4);
    }

    @Test
    public void fill() {
        commandLineInterface.drawCanvas(20,40);
        commandLineInterface.fill(1,4, '0');
        verify(canvas, times(1)).fill(1, 4, '0');
    }
}