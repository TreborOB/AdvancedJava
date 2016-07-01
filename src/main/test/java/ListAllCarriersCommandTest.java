import com.commands.ListAllCarriersCommand;
import com.main.Carrier;
import com.main.Network;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListAllCarriersCommandTest {


    private ListAllCarriersCommand listAllCarriersCommand;

    @Before
    public void setup() {
        listAllCarriersCommand = new ListAllCarriersCommand();

        Carrier c = new Carrier("Carrier");
        Network.carrierMap.put(c.getName(), c);
    }

    @After
    public void teardown() {
        listAllCarriersCommand = null;
    }

    @Test
    public void listAllCarriersTest() {
        listAllCarriersCommand.listAllCarriers();
        assertFalse(Network.carrierMap.isEmpty());
    }


}
