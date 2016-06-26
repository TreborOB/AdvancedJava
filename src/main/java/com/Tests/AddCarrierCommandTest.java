package com.tests;


import com.main.Carrier;
import com.main.Network;
import org.junit.Assert;
import org.junit.Test;

public class AddCarrierCommandTest {


    @Test
    public void addCarrierTest(){

        Carrier c = new Carrier();
        Network.carrierMap.put("Vodafone", c);
        Assert.assertTrue(Network.carrierMap.size()==1);
    }
}
