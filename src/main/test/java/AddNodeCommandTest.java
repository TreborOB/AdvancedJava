
import com.commands.AddNodeCommand;
import com.main.Carrier;
import com.main.Hub;
import com.main.Network;
import com.main.Node;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddNodeCommandTest {


    AddNodeCommand addNodeCommand;

    @Before
    public void setup() {
        addNodeCommand = new AddNodeCommand();

        Carrier c = new Carrier("Carrier");
        Network.carrierMap.put(c.getName(), c);

        Hub h = new Hub("Hub", "2");
        Network.carrierMap.get(c.getName()).hubs.put(h.getName(), h);

        Node n = new Node("Node", "3");
        Network.carrierMap.get(c.getName()).hubs.get(h.getName()).nodes.put(n.getName(), n);
    }


    @After
    public void teardown() {
        addNodeCommand = null;
    }


    @Test
    public void addNodeTest() {

        String carrierName = "Carrier";
        String hubName = "Hub";
        String nodeName = "Node";
        String nodeID = "4";

        addNodeCommand.addNode(carrierName, hubName, nodeName, nodeID);
        assertTrue(Network.carrierMap.get(carrierName).hubs.get(hubName).nodes.containsKey(nodeName));

    }


    @Test
    public void checkIDForTrueTest() {

        String carrier = "Carrier";
        String hubName = "Hub";
        String ID = "1";

        assertTrue(addNodeCommand.checkID(carrier, hubName, ID));
    }

    @Test
    public void checkIDForFalseTest() {

        String carrier = "Carrier";
        String hubName = "Hub";
        String ID = "2";

        assertTrue(addNodeCommand.checkID(carrier, hubName, ID));

    }

    @Test
    public void chosenCarrierTest() {

        String carrier = "Carrier";
        String response = addNodeCommand.chosenCarrier(carrier);
        assertEquals(response, "Carrier");

    }

    @Test
    public void chosenHubTest() {

        String carrier = "Carrier";
        String hub = "Hub";
        String response = addNodeCommand.chosenHub(carrier, hub);
        assertEquals(response, "Hub");

    }

}
