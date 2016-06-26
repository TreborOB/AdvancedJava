package com.tests;


import com.main.Carrier;
import com.main.Hub;
import com.main.Network;
import org.junit.Assert;
import org.junit.Test;

public class DeleteHubCommandTest {


    @Test
    public void deleteHubTest(){

        Carrier c = new Carrier("Vodafone");
        Hub h = new Hub("Hub1", 1);

        Network.carrierMap.put(c.getName(), c);
        Network.carrierMap.get(c.getName()).hubs.put(h.getName(), h);

        Network.carrierMap.get(c.getName()).hubs.remove(h.getName());

        Assert.assertTrue(Network.carrierMap.get(c.getName()).hubs.size() == 0);

    }


}
