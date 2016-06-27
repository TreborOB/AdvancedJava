package com.tests;


import com.main.*;
import org.junit.Assert;
import org.junit.Test;

public class AddNodeCommandTest {


    private Carrier c = new Carrier("Vodafone");

    Alarm alarm = new Alarm();


    private Hub h = new Hub("Hub1", 1);
    private Node n = new Node("Node1", 2);

    @Test
    public void addNodeTest() {

        Network.carrierMap.put(c.getName(), c);
        Network.carrierMap.get(c.getName()).hubs.put(h.getName(), h);
        Network.carrierMap.get(c.getName()).hubs.get(h.getName()).nodes.put(n.getName(), n);

        Assert.assertTrue(Network.carrierMap.get(c.getName()).hubs.get(h.getName()).nodes.size() == 1);
    }



}
