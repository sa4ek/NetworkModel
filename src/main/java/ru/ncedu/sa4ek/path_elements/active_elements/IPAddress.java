package ru.ncedu.sa4ek.path_elements.active_elements;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * Created by sa4ek on 25.12.14.
 */
public class IPAddress {
    byte[] ip_raw;

    public IPAddress() {

        Random r = new Random();
        String randomIPAddress = r.nextInt(256) + "." + r.nextInt(256) + "." + r.nextInt(256) + "." + r.nextInt(256);
        try {
            InetAddress ip = Inet4Address.getByName(randomIPAddress);
            ip_raw = ip.getAddress();
        } catch (UnknownHostException e) {
            System.out.println("error in IP, check the format < 192.168.1.1 >(IPv4).");
        }
    }

    public IPAddress(String ip_text){
        InetAddress ip;
        try {
            ip = Inet4Address.getByName(ip_text);
            ip_raw = ip.getAddress();
        } catch (UnknownHostException e) {
            System.out.println("error in IP, check the format < 192.168.1.1 >(IPv4).");
        }
    }

    public void setIp(String ip_text) {
        InetAddress ip;
        try {
            ip = Inet4Address.getByName(ip_text);
            ip_raw = ip.getAddress();
        } catch (UnknownHostException e) {
            System.out.println("error in IP, check the format < 192.168.1.1 >(IPv4).");
        }
    }

    public byte[] getIp()  {
        return ip_raw;
    }

    public String toString(){
        try {
            return Inet4Address.getByAddress(ip_raw).getHostAddress();
        } catch (UnknownHostException e) {
            System.out.println("Couldn't recognize IP");
            return null;
        }
    }

}
