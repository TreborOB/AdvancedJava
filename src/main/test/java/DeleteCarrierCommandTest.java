import com.commands.DeleteCarrierCommand;
import com.main.Carrier;
import com.main.Network;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class DeleteCarrierCommandTest {

    private DeleteCarrierCommand deleteCarrierCommand;

    @Before
    public void setup() {
        deleteCarrierCommand = new DeleteCarrierCommand();

        Carrier c = new Carrier("Carrier");
        Network.carrierMap.put(c.getName(), c);
    }


    @After
    public void teardown() {
        deleteCarrierCommand = null;
    }


    @Test
    public void deleteCarrierTest() {

        String carrier = "Carrier";

        deleteCarrierCommand.deleteCarrier(carrier);
        assertFalse(Network.carrierMap.containsKey(carrier));
    }


}
