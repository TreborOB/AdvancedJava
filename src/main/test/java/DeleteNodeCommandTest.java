import com.commands.DeleteNodeCommand;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DeleteNodeCommandTest {


    private DeleteNodeCommand deleteNodeCommand;

    @Before
    public void setup() {
        deleteNodeCommand = new DeleteNodeCommand();

    }

    @After
    public void teardown() {
        deleteNodeCommand = null;
    }


    @Test
    public void deleteCarrierTest() {

    }


}
