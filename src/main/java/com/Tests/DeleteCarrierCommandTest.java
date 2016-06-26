package com.tests;


import com.main.Carrier;
import com.main.Network;
import org.junit.Assert;
import org.junit.Test;

public class DeleteCarrierCommandTest {


    @Test
    public void deleteCarrierTest(){

        Carrier c = new Carrier("Vodafone");
        Network.carrierMap.put(c.getName(), c);

        Network.carrierMap.remove(c.getName());

        Assert.assertTrue(Network.carrierMap.size() == 0);

    }



}
