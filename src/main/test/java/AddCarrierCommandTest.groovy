import com.commands.AddCarrierCommand
import com.main.Network
import spock.lang.Specification

public class AddCarrierCommandTest extends Specification {

    AddCarrierCommand addCarrierCommand;


    def setup() {
        addCarrierCommand = new AddCarrierCommand();
    }

    def 'does carrier exist test'(){
        when:
        String inputData = 'Three';
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));
        addCarrierCommand.execute()
        then:
        addCarrierCommand.doesCarrierExist(inputData)
        cleanup:
        Network.carrierMap.clear()
    }


    def 'add carrier test'(){
        when:
        String carrierName = 'Carrier';
        addCarrierCommand.addCarrier(carrierName);
        then:
        Network.carrierMap.size() == 1
    }

}
