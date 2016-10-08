import com.commands.DeleteHubCommand
import org.junit.After
import org.junit.Before
import org.junit.Test

public class DeleteHubCommandTest {


    DeleteHubCommand deleteHubCommand;

    @Before
    public void setup() {
        deleteHubCommand = new DeleteHubCommand();

    }

    @After
    public void teardown() {
        deleteHubCommand = null;
    }


    @Test
    public void deleteCarrierTest() {

    }

}
