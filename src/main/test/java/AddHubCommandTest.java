import com.commands.AddHubCommand;
import com.main.Carrier;
import com.main.Network;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddHubCommandTest {


    private AddHubCommand addHubCommand;

    @Before
    public void setup() {
        addHubCommand = new AddHubCommand();
        Carrier c = new Carrier("Carrier");
        Network.carrierMap.put(c.getName(), c);
    }

    @After
    public void teardown() {
        addHubCommand = null;
    }


    @Test
    public void addHubTest() {

        String carrierName = "Carrier";
        String hubName = "Hub";
        String hubID = "1";

        addHubCommand.addHub(carrierName, hubName, hubID);
        assertTrue(Network.carrierMap.get(carrierName).hubs.containsKey(hubName));
    }

    @Test
    public void checkIDForTrueTest() {

        String carrier = "Carrier";
        String id = "1";

        assertTrue(addHubCommand.checkID(carrier, id));
    }

    @Test
    public void checkIDForFalseTest() {

        String carrier = "Carrier";
        String id = "2";

        assertTrue(addHubCommand.checkID(carrier, id));
    }

    @Test
    public void chosenCarrierTest() {

        String carrier = "Carrier";
        String hub = "Hub";
        String response = addHubCommand.chosenHub(carrier, hub);
        assertEquals(response, "Hub");

    }


}
