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

        def tearDown(){
            clearAlarmCommand = null
            Network.carrierMap.clear()
        }


        def 'does carrier exist test'(){
            when:
            String inputData = 'Three';
            System.setIn(new ByteArrayInputStream(inputData.getBytes()));
            clearAlarmCommand.execute()
            then:
            clearAlarmCommand.doesCarrierExist(inputData)
        }


        def 'does hub exist test'(){
            when:
            String inputData = 'Hub2';
            System.setIn(new ByteArrayInputStream(inputData.getBytes()));
            clearAlarmCommand.clearHubAlarm('Three')
            then:
            clearAlarmCommand.doesHubExist('Three', inputData)
        }

         def 'clear all hub alarms test'(){
             when:
             String inputData = 'Hub2';
             System.setIn(new ByteArrayInputStream(inputData.getBytes()));
             clearAlarmCommand.clearAllHubAlarms('Three', inputData)
             then:
             Network.carrierMap.get('Three').hubs.get(inputData).hubAlarms.isEmpty()

         }

         def 'clear specific alarms test'(){
             when:
             String inputData = '2';
             System.setIn(new ByteArrayInputStream(inputData.getBytes()));
             clearAlarmCommand.clearSpecificHubAlarms('Three', 'Hub2')
             then:
             !Network.carrierMap.get('Three').hubs.get('Hub2').hubAlarms.alarmType.contains("Optical Loss")
         }


          def 'clear node alarm test'(){
              when:
              String inputData = 'Three';
              System.setIn(new ByteArrayInputStream(inputData.getBytes()));
              clearAlarmCommand.clearNodeAlarm(inputData)
              then:
              clearAlarmCommand.doesCarrierExist('Three')
          }


           def 'does node exist test'(){
               when:
               String inputData = 'Node2';
               System.setIn(new ByteArrayInputStream(inputData.getBytes()));
               clearAlarmCommand.node('Three', 'Hub2')
               then:
               clearAlarmCommand.doesNodeExist('Three', 'Hub2', inputData)
           }


           def 'clear all node alarms'(){
               when:
               clearAlarmCommand.clearAllNodeAlarms('Three', 'Hub2', 'Node2')
               then:
               Network.carrierMap.get('Three').hubs.get('Hub2').nodes.get('Node2').nodeAlarms.isEmpty()
            }


            def 'clear specific node alarms'(){
              when:
              String inputData = '2';
              System.setIn(new ByteArrayInputStream(inputData.getBytes()));
              clearAlarmCommand.clearSpecificNodeAlarms('Three', 'Hub2', 'Node2')
              then:
              !Network.carrierMap.get('Three').hubs.get('Hub2').nodes.get('Node2').nodeAlarms.alarmType.contains("Optical Loss")
            }

}


