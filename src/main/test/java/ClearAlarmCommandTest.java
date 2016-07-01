import com.commands.ClearAlarmCommand;
import com.main.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;


public class ClearAlarmCommandTest {

    private ClearAlarmCommand clearAlarmCommand;

    @Before
    public void setup() {
        clearAlarmCommand = new ClearAlarmCommand();

        Carrier c = new Carrier("Carrier");
        Network.carrierMap.put(c.getName(), c);

        Hub h = new Hub("Hub", "2");
        Network.carrierMap.get(c.getName()).hubs.put(h.getName(), h);

        Node n = new Node("Node", "3");
        Network.carrierMap.get(c.getName()).hubs.get(h.getName()).nodes.put(n.getName(), n);

        Date date = new Date();
        Alarm alarm = new Alarm("Unit unavailable", "Unit unavailable remedy", date);
        Network.carrierMap.get(c.getName()).hubs.get(h.getName()).hubAlarms.add(alarm);

    }

    @After
    public void teardown() {
        clearAlarmCommand = null;
    }


    @Test
    public void clearAllHubAlarmsTest() {

        String carrier = "Carrier";
        String hubName = "Hub";
        clearAlarmCommand.clearAllHubAlarms(carrier, hubName);

        assertTrue(Network.carrierMap.get(carrier).hubs.get("Hub").hubAlarms.isEmpty());
    }

    @Test
    public void clearAllNodesCommandTest() {

        String carrier = "Carrier";
        String hubName = "Hub";
        String node = "Node";
        clearAlarmCommand.clearAllNodeAlarms(carrier, hubName, node);
        assertTrue(Network.carrierMap.get(carrier).hubs.get("Hub").nodes.get(node).nodeAlarms.isEmpty());
    }

}


