import com.commands.AddCarrierCommand;
import com.main.Network;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddCarrierCommandTest {

    AddCarrierCommand addCarrierCommand;

    @Before
    public void setUp() {
        addCarrierCommand = new AddCarrierCommand();
    }


    @Test
    public void addCarrierTest() {

        String carrierName = "Carrier";
        addCarrierCommand.addCarrier(carrierName);

        assertTrue(Network.carrierMap.containsKey(carrierName));
    }


    @Test
    public void addCarrierDuplicate() {

        String carrierName = "Carrier";
        addCarrierCommand.addCarrier(carrierName);
        addCarrierCommand.addCarrier(carrierName);

        assertTrue(Network.carrierMap.size() == 1);
    }

    @Test
    public void chosenCarrierTest() {

        String carrier = "Carrier";
        String response = addCarrierCommand.chosenCarrier(carrier);
        assertEquals(response, "Carrier");

    }


}
