import com.commands.CreateAlarmCommand;
import com.main.Carrier;
import com.main.Hub;
import com.main.Network;
import com.main.Node;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CreateAlarmCommandTest {


    private CreateAlarmCommand createAlarmCommand;

    @Before
    public void setup() {
        createAlarmCommand = new CreateAlarmCommand();

        Carrier c = new Carrier("Carrier");
        Network.carrierMap.put(c.getName(), c);

        Hub h = new Hub("Hub", "2");
        Network.carrierMap.get(c.getName()).hubs.put(h.getName(), h);

        Node n = new Node("Node", "3");
        Network.carrierMap.get(c.getName()).hubs.get(h.getName()).nodes.put(n.getName(), n);

    }

    @After
    public void teardown() {
        createAlarmCommand = null;
    }


    @Test
    public void createHubAlarmTest() {


    }


}

