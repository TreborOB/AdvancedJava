import com.commands.RenameCarrierCommand;
import com.main.Carrier;
import com.main.Network;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RenameCarrierCommandTest {


    private RenameCarrierCommand renameCarrierCommand;

    @Before
    public void setup() {
        renameCarrierCommand = new RenameCarrierCommand();

        Carrier c = new Carrier("Carrier");
        Network.carrierMap.put(c.getName(), c);

    }


    @After
    public void teardown() {
        renameCarrierCommand = null;
    }


    @Test
    public void renameCarrierTest() {

        String carrier = "Carrier";
        String newCarrierName = "New Carrier";

        renameCarrierCommand.renameCarrier(carrier, newCarrierName);
        assertTrue(Network.carrierMap.containsKey("New Carrier"));

    }

}
