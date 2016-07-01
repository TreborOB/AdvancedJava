import com.commands.ListAllNodesCommand;
import com.main.Carrier;
import com.main.Hub;
import com.main.Network;
import com.main.Node;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class ListAllNodesCommandTest {


    private ListAllNodesCommand listAllNodesCommand;

    @Before
    public void setup() {
        listAllNodesCommand = new ListAllNodesCommand();

        Carrier c = new Carrier("Carrier");
        Network.carrierMap.put(c.getName(), c);

        Hub h = new Hub("Hub", "2");
        Network.carrierMap.get(c.getName()).hubs.put(h.getName(), h);

        Node n = new Node("Node", "3");
        Network.carrierMap.get(c.getName()).hubs.get(h.getName()).nodes.put(n.getName(), n);

    }

    @After
    public void teardown() {
        listAllNodesCommand = null;
    }

    @Test
    public void listAllCarriersTest() {

        String carrier = "Carrier";
        String hub = "Hub";
        String node = "Node";

        listAllNodesCommand.listAllNodes(carrier, hub);
        assertTrue(Network.carrierMap.get(carrier).hubs.get(hub).nodes.containsKey(node));


    }


}
