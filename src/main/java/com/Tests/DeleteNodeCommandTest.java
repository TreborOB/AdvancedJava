package com.tests;


import com.main.*;
import org.junit.Assert;
import org.junit.Test;

public class DeleteNodeCommandTest {

    @Test
    public void deleteHubTest(){

        Carrier c = new Carrier("Vodafone");
        Hub h = new Hub("Hub1", 1);
        Node n = new Node("Node1", 2);


        Network.carrierMap.put(c.getName(), c);
        Network.carrierMap.get(c.getName()).hubs.put(h.getName(), h);
        Network.carrierMap.get(c.getName()).hubs.get(h.getName()).nodes.put(n.getName(), n);

        Network.carrierMap.get(c.getName()).hubs.get(h.getName()).nodes.remove(n.getName());

        Assert.assertTrue(Network.carrierMap.get(c.getName()).hubs.get(h.getName()).nodes.size() == 0);

    }

}
