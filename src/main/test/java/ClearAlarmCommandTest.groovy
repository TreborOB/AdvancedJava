import com.commands.AddNodeCommand
import com.commands.ClearAlarmCommand
import com.main.Network
import com.main.PopulateValues
import spock.lang.Specification

class ClearAlarmCommandTest extends Specification{

        ClearAlarmCommand clearAlarmCommand;

        def setup() {
            clearAlarmCommand = new ClearAlarmCommand()
            PopulateValues pop = new PopulateValues()
            pop.defaultValues()
        }


        def clearAlarm(){
            when:
            String inputData = 'Three';
            System.setIn(new ByteArrayInputStream(inputData.getBytes()));
            clearAlarmCommand.clearAlarm()
            then:
            clearAlarmCommand.doesCarrierExist(inputData)
        }


        def clearHubAlarm(){
            when:
            String inputData = 'Hub2';
            System.setIn(new ByteArrayInputStream(inputData.getBytes()));
            clearAlarmCommand.clearAlarm()
            then:
            clearAlarmCommand.doesHubExist('Three', inputData)
        }



}


