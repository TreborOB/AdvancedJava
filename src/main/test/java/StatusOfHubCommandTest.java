import com.commands.StatusOfHubCommand;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class StatusOfHubCommandTest {

    private StatusOfHubCommand statusOfHubCommand;

    @Before
    public void setup() {
        statusOfHubCommand = new StatusOfHubCommand();

    }

    @After
    public void teardown() {
        statusOfHubCommand = null;
    }


    @Test
    public void hubStatusTest() {

    }


}
