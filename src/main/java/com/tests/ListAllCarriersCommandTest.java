package com.tests;


import com.main.Carrier;
import com.main.Network;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class ListAllCarriersCommandTest {


         @Test
         public void listAllCarriersTest(){

             Carrier c = new Carrier("Vodafone");

             String s = "";

             Network.carrierMap.put(c.getName(), c);

             for (Map.Entry<String, Carrier> entry: Network.carrierMap.entrySet()) {
                 s = entry.getKey();
             }

             Assert.assertEquals(c.getName(), s);

      }
}
