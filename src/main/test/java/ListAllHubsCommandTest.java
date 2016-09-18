import com.commands.ListAllHubsCommand;
import com.main.Carrier;
import com.main.Hub;
import com.main.Network;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ListAllHubsCommandTest {


    private ListAllHubsCommand listAllHubsCommand;

    @Before
    public void setup() {
        listAllHubsCommand = new ListAllHubsCommand();

        Carrier c = new Carrier("Carrier");
        Network.carrierMap.put(c.getName(), c);

        Hub h = new Hub("Hub", "2");

    }

    @After
    public void teardown() {
        listAllHubsCommand = null;
    }

    @Test
    public void listAllHubsTest() {

        String carrier = "Carrier";
        String hub = "Hub";

        listAllHubsCommand.listAllHubs(carrier);

    }


}


