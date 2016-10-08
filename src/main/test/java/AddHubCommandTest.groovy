import com.commands.AddHubCommand
import com.main.Carrier
import com.main.Network
import com.main.PopulateValues
import spock.lang.Specification

class AddHubCommandTest extends Specification{

    AddHubCommand addHubCommand;

    def setup() {
        PopulateValues pop = new PopulateValues()
        pop.defaultValues()
        addHubCommand = new AddHubCommand()
    }

    def hub(){
        when:
        String inputData = 'Three';
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));
        addHubCommand.hub()
        then:
        addHubCommand.doesCarrierExist(inputData)
        cleanup:
        Network.carrierMap.clear()
    }


    def nextHub(){
        when:
        String inputData = 'Three';
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));
        addHubCommand.nextHub(inputData)
        then:
        addHubCommand.doesHubExist('Three', inputData)

    }

    def hubId(){
        assert addHubCommand.doesHubIDExist('Three', '2')
    }

    def addHub(){
        assert 'Hub2' in Network.carrierMap.get('Three').hubs.name
    }


}