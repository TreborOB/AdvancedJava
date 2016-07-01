import com.commands.RenameHubCommand;
import com.main.Carrier;
import com.main.Hub;
import com.main.Network;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RenameHubCommandTest {


    private RenameHubCommand renameHubCommand;

    @Before
    public void setup() {
        renameHubCommand = new RenameHubCommand();

        Carrier c = new Carrier("Carrier");
        Network.carrierMap.put(c.getName(), c);

        Hub h = new Hub("Hub", "2");
        Network.carrierMap.get(c.getName()).hubs.put(h.getName(), h);
    }


    @After
    public void teardown() {
        renameHubCommand = null;
    }


    @Test
    public void renameHubTest() {

        String carrier = "Carrier";
        String hub = "Hub";
        String newCarrierName = "New Carrier";

        renameHubCommand.renameHub(carrier, hub, newCarrierName);
        assertTrue(Network.carrierMap.get(carrier).hubs.containsKey(newCarrierName));
    }

}
