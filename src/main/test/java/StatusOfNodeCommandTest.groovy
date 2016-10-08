import com.commands.StatusOfNodeCommand
import org.junit.After
import org.junit.Before

public class StatusOfNodeCommandTest {


    StatusOfNodeCommand statusOfNodeCommand;

    @Before
    public void setup() {
        statusOfNodeCommand = new StatusOfNodeCommand();



    }

    @After
    public void teardown() {
        statusOfNodeCommand = null;
    }


    //@Test
    public void nodeStatusTest() {
    }


}

