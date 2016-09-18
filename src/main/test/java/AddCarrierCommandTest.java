import com.commands.AddCarrierCommand;
import com.main.Network;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertTrue;

public class AddCarrierCommandTest {

    AddCarrierCommand addCarrierCommand;

    @Before
    public void setUp() {
        addCarrierCommand = new AddCarrierCommand();
    }


    @Test
    public void carrier() {

    }


    @Test
    public void addCarrier() {
        String carrierName = "Carrier";
        addCarrierCommand.addCarrier(carrierName);
        assertTrue(Network.carrierMap.containsKey(carrierName));
    }




}
