package com.tests;


import com.main.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class ListAllNodesCommandsTest {



    @Test
    public void listAllNodesTest(){


        Alarm alarm = new Alarm();


        Carrier c = new Carrier("Vodafone");
        Hub h = new Hub("Hub1", 1, alarm);
        Node n = new Node();

        Network.carrierMap.put(c.getName(), c);
        Network.carrierMap.put(c.getName(), c).hubs.put(h.getName(), h);
        Network.carrierMap.put(c.getName(), c).hubs.put(h.getName(), h).nodes.put(n.getName(), n);

        String s = "";

        for (Map.Entry<String, Node> entry: Network.carrierMap.get(c.getName()).hubs.get(h.getName()).nodes.entrySet()) {
            s = entry.getKey();
        }
        Assert.assertEquals(n.getName(), s);

    }
}
