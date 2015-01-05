package ru.ncedu.sa4ek.path_elements.active_elements;

import org.junit.Assert;
import org.junit.Test;

import java.net.UnknownHostException;


public class IPAddressTest {
    @Test
    public void testAdress() throws UnknownHostException {
        IPAddress ipAddress = new IPAddress();
        //String test_ip = "192.168.1.1";
        //ipAddress.setIp(test_ip);
        //Assert.assertEquals(test_ip, ipAddress.toString());
        System.out.println(ipAddress);
    }

}