import com.commands.StatusOfCarrierCommand
import com.main.Carrier
import com.main.Network
import org.junit.After
import org.junit.Before
import org.junit.Test

public class StatusOfCarrierCommandTest {

    StatusOfCarrierCommand statusOfCarrierCommand;

    @Before
    public void setup() {
        statusOfCarrierCommand = new StatusOfCarrierCommand();

        Carrier c = new Carrier("Carrier");
        Network.carrierMap.put(c.getName(), c);
    }

    @After
    public void teardown() {
        statusOfCarrierCommand = null;
    }


    @Test
    public void carrierStatusTest() {

    }


}
