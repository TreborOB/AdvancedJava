import com.commands.AddNodeCommand;
import org.junit.After;
import org.junit.Before;

public class AddNodeCommandTest {


    AddNodeCommand addNodeCommand;

    @Before
    public void setup() {
        addNodeCommand = new AddNodeCommand();


    }


    @After
    public void teardown() {
        addNodeCommand = null;
    }



}
