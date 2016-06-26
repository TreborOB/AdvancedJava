package com.tests;

import com.main.Carrier;
import com.main.Hub;
import com.main.Network;
import org.junit.Assert;
import org.junit.Test;

public class AddHubCommandTest {


    @Test
    public void addHubTest(){

        Carrier c = new Carrier("Vodafone");
        Network.carrierMap.put(c.getName(), c);

        Hub h = new Hub();

        Network.carrierMap.get(c.getName()).hubs.put(h.getName(), h);
        Assert.assertTrue(Network.carrierMap.get(c.getName()).hubs.size()==1);

    }
}
