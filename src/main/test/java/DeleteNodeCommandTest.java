import com.commands.DeleteNodeCommand;
import com.main.Carrier;
import com.main.Hub;
import com.main.Network;
import com.main.Node;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class DeleteNodeCommandTest {


    private DeleteNodeCommand deleteNodeCommand;

    @Before
    public void setup() {
        deleteNodeCommand = new DeleteNodeCommand();

        Carrier c = new Carrier("Carrier");
        Network.carrierMap.put(c.getName(), c);

        Hub h = new Hub("Hub", "2");
        Network.carrierMap.get(c.getName()).hubs.put(h.getName(), h);

        Node n = new Node("Node", "3");
        Network.carrierMap.get(c.getName()).hubs.get(h.getName()).nodes.put(n.getName(), n);
    }

    @After
    public void teardown() {
        deleteNodeCommand = null;
    }


    @Test
    public void deleteCarrierTest() {

        String carrier = "Carrier";
        String hub = "Hub";
        String node = "Node";

        deleteNodeCommand.deleteNode(carrier, hub, node);
        assertFalse(Network.carrierMap.get(carrier).hubs.get(hub).nodes.containsKey(node));
    }


}
