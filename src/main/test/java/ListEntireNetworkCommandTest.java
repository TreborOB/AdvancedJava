import com.commands.ListEntireNetworkCommand;
import com.main.Carrier;
import com.main.Hub;
import com.main.Network;
import com.main.Node;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;
import static org.junit.Assert.*;


public class ListEntireNetworkCommandTest {

    ListEntireNetworkCommand listEntireNetworkCommand;

    @Before
    public void setup() {
        listEntireNetworkCommand = new ListEntireNetworkCommand();

        Carrier c = new Carrier("Carrier");
        Network.carrierMap.put(c.getName(), c);

        Hub h = new Hub("Hub", "2");
        Network.carrierMap.get(c.getName()).hubs.put(h.getName(), h);

        Node n = new Node("Node", "3");
        Network.carrierMap.get(c.getName()).hubs.get(h.getName()).nodes.put(n.getName(), n);

    }

    @After
    public void teardown() {
        listEntireNetworkCommand = null;
    }

    @Test
    public void listAllCarriersTest() {
        listEntireNetworkCommand.listNetwork();
        assertFalse(Network.carrierMap.isEmpty());
    }

}
