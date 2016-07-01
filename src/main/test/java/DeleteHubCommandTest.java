import com.commands.DeleteHubCommand;
import com.main.Carrier;
import com.main.Hub;
import com.main.Network;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class DeleteHubCommandTest {


    private DeleteHubCommand deleteHubCommand;

    @Before
    public void setup() {
        deleteHubCommand = new DeleteHubCommand();

        Carrier c = new Carrier("Carrier");
        Network.carrierMap.put(c.getName(), c);

        Hub h = new Hub("Hub", "2");
        Network.carrierMap.get(c.getName()).hubs.put(h.getName(), h);
    }

    @After
    public void teardown() {
        deleteHubCommand = null;
    }


    @Test
    public void deleteCarrierTest() {

        String carrier = "Carrier";
        String hub = "Hub";

        deleteHubCommand.deleteHub(carrier, hub);
        assertFalse(Network.carrierMap.get(carrier).hubs.containsKey(hub));
    }

}
