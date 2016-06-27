package com.tests;


import com.main.Alarm;
import com.main.Carrier;
import com.main.Hub;
import com.main.Network;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class ListAllHubsCommandTest {


    @Test
    public void listAllHubsTest(){

        Carrier c = new Carrier("Vodafone");
        Hub h = new Hub("Hub1", 1);

        Network.carrierMap.put(c.getName(), c);
        Network.carrierMap.put(c.getName(), c).hubs.put(h.getName(), h);

        String s = "";

            for (Map.Entry<String, Hub> entry: Network.carrierMap.get(c.getName()).hubs.entrySet()) {
                s = entry.getKey();
            }
        Assert.assertEquals(h.getName(), s);

    }





}
