import com.commands.AddHubCommand
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

    def 'Does carrier exist test'(){
        when:
        String inputData = 'Three';
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));
        addHubCommand.execute()
        then:
        addHubCommand.doesCarrierExist(inputData)
        cleanup:
        Network.carrierMap.clear()
    }


    def 'does hub exist test'(){
        when:
        String inputData = 'Three';
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));
        addHubCommand.nextHub(inputData)
        then:
        addHubCommand.doesHubExist('Three', inputData)

    }

    def 'check if hub id already exists'(){
        assert addHubCommand.doesHubIDExist('Three', '2')
    }

    def 'add hub test'(){
        assert 'Hub2' in Network.carrierMap.get('Three').hubs.name
    }


}