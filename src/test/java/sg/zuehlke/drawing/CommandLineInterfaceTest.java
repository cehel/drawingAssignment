package sg.zuehlke.drawing;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;

/* Created by celineheldner on 2019-02-21 */

public class CommandLineInterfaceTest {

    @Autowired
    private CommandLineInterface commandLineInterface;

    @InjectMocks
    private Canvas canvas;


    @Test
    public void callWithC() {
        commandLineInterface.call("C 40 3");
    }

}