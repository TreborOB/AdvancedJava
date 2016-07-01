import com.main.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class SuggestedRemediesCommandTest {


    private SuggestedRemediesCommandTest suggestedRemediesCommandTest;

    @Before
    public void setup() {
        suggestedRemediesCommandTest = new SuggestedRemediesCommandTest();

        Carrier c = new Carrier("Carrier");
        Network.carrierMap.put(c.getName(), c);

        Hub h = new Hub("Hub", "2");
        Network.carrierMap.get(c.getName()).hubs.put(h.getName(), h);

        Node n = new Node("Node", "3");
        Network.carrierMap.get(c.getName()).hubs.get(h.getName()).nodes.put(n.getName(), n);

        Date date = new Date();
        Alarm alarm = new Alarm("Alarm", "Alarm Remedy", date);
        Network.carrierMap.get(c.getName()).hubs.get(h.getName()).hubAlarms.add(alarm);

        Network.carrierMap.get(c.getName()).hubs.get(h.getName()).nodes.get(n.getName()).nodeAlarms.add(alarm);
    }


    @After
    public void teardown() {
        suggestedRemediesCommandTest = null;
    }

    @Test
    public void hubRemediesTest() {

    }


    @Test
    public void nodeRemediesTest() {

    }


}
