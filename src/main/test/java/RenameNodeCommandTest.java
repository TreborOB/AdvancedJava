import com.commands.RenameNodeCommand;
import com.main.Carrier;
import com.main.Hub;
import com.main.Network;
import com.main.Node;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RenameNodeCommandTest {


    private RenameNodeCommand renameNodeCommand;

    @Before
    public void setup() {
        renameNodeCommand = new RenameNodeCommand();

        Carrier c = new Carrier("Carrier");
        Network.carrierMap.put(c.getName(), c);

        Hub h = new Hub("Hub", "2");
        Network.carrierMap.get(c.getName()).hubs.put(h.getName(), h);

        Node n = new Node("Node", "3");
        Network.carrierMap.get(c.getName()).hubs.get(h.getName()).nodes.put(n.getName(), n);
    }


    @After
    public void teardown() {
        renameNodeCommand = null;
    }

    @Test
    public void renameNodeTest() {

        String carrier = "Carrier";
        String hub = "Hub";
        String node = "Node";
        String newNodeName = "New node";

        renameNodeCommand.renameNode(carrier, hub, node, newNodeName);
        assertTrue(Network.carrierMap.get(carrier).hubs.get(hub).nodes.containsKey(newNodeName));
    }
}
