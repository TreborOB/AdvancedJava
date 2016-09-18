package com.main


/**
 * Created by robertobrien on 14/09/2016.
 */
class PopulateValues {

    void defaultValues() {

        Carrier c1 = new Carrier("Vodafone")
        Carrier c2 = new Carrier("Three")
        Carrier c3 = new Carrier("Meteor")

        Hub h1 = new Hub("Hub1", "1")
        Hub h2 = new Hub("Hub2", "2")
        Hub h3 = new Hub("Hub3", "3")

        Node n1 = new Node("Node1", "1")
        Node n2 = new Node("Node2", "2")
        Node n3 = new Node("Node3", "3")


        def date = new Date()

        Alarm alarm1 = new Alarm("Power outa", "Power outage remedy", date)
        Alarm alarm2 = new Alarm("Dark fibre", "Dark fibre remedy", date)
        Alarm alarm3 = new Alarm("Dark fibre", "Dark fibre remedy", date)
        Alarm alarm4 = new Alarm("Unit Unavailable", "Unit Unavailable remedy", date)
        Alarm alarm5 = new Alarm("Power outage", "Power outage remedy", date)
        Alarm alarm6 = new Alarm("Optical loss", "Optical loss remedy", date)


        h1.hubAlarms.add(alarm1)
        h1.hubAlarms.add(alarm2)
        h1.hubAlarms.add(alarm5)

        h2.hubAlarms.add(alarm3)
        h2.hubAlarms.add(alarm4)
        h2.hubAlarms.add(alarm6)

        h3.hubAlarms.add(alarm3)
        h3.hubAlarms.add(alarm4)
        h3.hubAlarms.add(alarm6)

        n1.nodeAlarms.add(alarm1)
        n1.nodeAlarms.add(alarm2)
        n1.nodeAlarms.add(alarm3)

        n2.nodeAlarms.add(alarm4)
        n2.nodeAlarms.add(alarm5)
        n2.nodeAlarms.add(alarm6)

        n3.nodeAlarms.add(alarm4)
        n3.nodeAlarms.add(alarm5)
        n3.nodeAlarms.add(alarm6)


        Network.carrierMap.put(c1.getName(), c1)
        Network.carrierMap.put(c2.getName(), c2)
        Network.carrierMap.put(c3.getName(), c3)

        Network.carrierMap.get(c1.hubs.put(h1.getName(), h1))
        Network.carrierMap.get(c2.hubs.put(h2.getName(), h2))
        Network.carrierMap.get(c3.hubs.put(h3.getName(), h3))

        Network.carrierMap.get(c1.hubs.get(h1.nodes.put(h1.getName(), h1)))
        Network.carrierMap.get(c2.hubs.get(h2.nodes.put(h2.getName(), h2)))
        Network.carrierMap.get(c3.hubs.get(h3.nodes.put(h3.getName(), h3)))

    }

}
