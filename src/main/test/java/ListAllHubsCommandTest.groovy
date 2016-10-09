import com.commands.ListAllHubsCommand
import com.main.Carrier
import com.main.Network
import org.junit.After
import org.junit.Before
import org.junit.Test

public class ListAllHubsCommandTest {


    ListAllHubsCommand listAllHubsCommand;

    @Before
    public void setup() {
        listAllHubsCommand = new ListAllHubsCommand();

        Carrier c = new Carrier("Carrier");
        Network.carrierMap.put(c.getName(), c);


    }

    @After
    public void teardown() {
        listAllHubsCommand = null;
    }

    @Test
    public void listAllHubsTest() {

        String carrier = "Carrier";
        listAllHubsCommand.listAllHubs(carrier);

    }


}


