
import com.commands.CreateAlarmCommand
import com.main.Network
import com.main.PopulateValues
import spock.lang.Specification


public class CreateAlarmCommandTest extends Specification{


    private CreateAlarmCommand createAlarmCommand;

    def setup() {
        PopulateValues pop = new PopulateValues()
        pop.defaultValues()
        createAlarmCommand = new CreateAlarmCommand()
    }


    def tearDown(){
        createAlarmCommand = null
    }


    def 'does carrier exist test'(){
        when:
        String inputData = 'Three';
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));
        createAlarmCommand.execute()
        then:
        createAlarmCommand.doesCarrierExist(inputData)
        cleanup:
        Network.carrierMap.clear()
    }


    def 'clear alarm on hub'(){
        when:
        String inputData = 'Hub2';
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));
        createAlarmCommand.createAlarmOnHub('Three')
        then:
        createAlarmCommand.doesHubExist('Three', inputData)
        cleanup:
        Network.carrierMap.clear()
    }

    def 'clear alarm on node'(){
        when:
        String inputData = 'Hub2';
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));
        createAlarmCommand.createAlarmOnNode('Three')
        then:
        createAlarmCommand.doesHubExist('Three', inputData)
        cleanup:
        Network.carrierMap.clear()
    }
}

