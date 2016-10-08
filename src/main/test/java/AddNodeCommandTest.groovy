import com.commands.AddNodeCommand
import com.main.Network
import com.main.PopulateValues
import spock.lang.Specification

class AddNodeCommandTest extends Specification{


    AddNodeCommand addNodeCommand;


    def setup() {
        addNodeCommand = new AddNodeCommand()
        PopulateValues pop = new PopulateValues()
        pop.defaultValues()
    }

    def node() {
        when:
        String inputData = 'Three';
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));
        addNodeCommand.node()
        then:
        addNodeCommand.doesCarrierExist(inputData)
        cleanup:
        Network.carrierMap.clear()
    }


    def nextHub() {
        when:
        String inputData = 'Three';
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));
        addNodeCommand.nextHub(inputData)
        then:
        !addNodeCommand.doesHubExist('Three', inputData)
    }


    def nodeExist() {
        when:
        String inputData = 'node4';
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));
        addNodeCommand.node('Three', 'Hub2')
        then:
        !addNodeCommand.doesNodeExist('Three', 'Hub2', inputData)

    }

}
