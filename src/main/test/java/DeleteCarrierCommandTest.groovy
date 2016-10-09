import com.commands.AddCarrierCommand
import com.commands.DeleteCarrierCommand
import com.main.Carrier
import com.main.Network
import com.main.PopulateValues
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.spockframework.compiler.model.Spec
import spock.lang.Specification



public class DeleteCarrierCommandTest extends Specification{

    DeleteCarrierCommand deleteCarrierCommand;

    @Before
    public void setup() {
        deleteCarrierCommand = new DeleteCarrierCommand();
        PopulateValues pop = new PopulateValues()
        pop.defaultValues()
    }



    public void teardown() {
        deleteCarrierCommand = null;
    }

    public void 'does carrier exist test'() {
            when:
            String inputData = 'Carrier';
            System.setIn(new ByteArrayInputStream(inputData.getBytes()));
            deleteCarrierCommand.execute()
            then:
            !deleteCarrierCommand.doesCarrierExist(inputData)
        }



    public void 'delete carrier test'() {
        when:
        deleteCarrierCommand.deleteCarrier('Three')
        then:
        !deleteCarrierCommand.doesCarrierExist('Three')
    }


}


