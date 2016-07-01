import com.commands.StatusOfHubCommand;
import com.main.Carrier;
import com.main.Hub;
import com.main.Network;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class StatusOfHubCommandTest {

    private StatusOfHubCommand statusOfHubCommand;

    @Before
    public void setup() {
        statusOfHubCommand = new StatusOfHubCommand();

        Carrier c = new Carrier("Carrier");
        Network.carrierMap.put(c.getName(), c);

        Hub h = new Hub("Hub", "2");
        Network.carrierMap.get(c.getName()).hubs.put(h.getName(), h);

    }

    @After
    public void teardown() {
        statusOfHubCommand = null;
    }


    @Test
    public void hubStatusTest() {
        String carrierName = "Carrier";
        String hub = "Hub";
        statusOfHubCommand.searchByNameOrID(carrierName);
        assertTrue(Network.carrierMap.get(carrierName).hubs.containsKey(hub));
    }


}
