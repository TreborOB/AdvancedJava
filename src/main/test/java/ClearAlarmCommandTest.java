import com.commands.ClearAlarmCommand;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ClearAlarmCommandTest {

    private ClearAlarmCommand clearAlarmCommand;

    @Before
    public void setup() {
        clearAlarmCommand = new ClearAlarmCommand();

    }

    @After
    public void teardown() {
        clearAlarmCommand = null;
    }


    @Test
    public void clearAllHubAlarmsTest() {


    }

}


