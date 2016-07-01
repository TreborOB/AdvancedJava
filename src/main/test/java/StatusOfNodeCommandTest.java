import com.commands.StatusOfNodeCommand;
import com.main.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class StatusOfNodeCommandTest {


    private StatusOfNodeCommand statusOfNodeCommand;

    @Before
    public void setup() {
        statusOfNodeCommand = new StatusOfNodeCommand();

        Carrier c = new Carrier("Carrier");
        Network.carrierMap.put(c.getName(), c);

        Hub h = new Hub("Hub", "2");
        Network.carrierMap.get(c.getName()).hubs.put(h.getName(), h);

        Node n = new Node("Node", "3");
        Network.carrierMap.get(c.getName()).hubs.get(h.getName()).nodes.put(n.getName(), n);

        Date date = new Date();
        Alarm alarm = new Alarm("Unit unavailable", "Unit available remedy", date);
        Network.carrierMap.get(c.getName()).hubs.get(h.getName()).nodes.get(n.getName()).nodeAlarms.add(alarm);


    }

    @After
    public void teardown() {
        statusOfNodeCommand = null;
    }


    //@Test
    public void nodeStatusTest() {
        String carrierName = "Carrier";
        String hub = "Hub";
        String node = "Node";

        statusOfNodeCommand.searchByNameOrID(carrierName, hub);
        assertTrue(Network.carrierMap.get(carrierName).hubs.get(hub).nodes.containsKey(node));
    }

    @Test
    public void searchAvailabilityTest() {

        String carrier = "Carrier";
        String hub = "Hub";

        String status = statusOfNodeCommand.searchAvailability(carrier, hub);
        assertEquals("", status);
    }


}

