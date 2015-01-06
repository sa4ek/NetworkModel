package ru.ncedu.sa4ek;

import org.junit.Test;

import java.util.*;
import java.util.Map.*;

import static org.junit.Assert.*;

public class NetworkTest {
 /*   @Test
    public void pathElementsGet(){
        Network net = new Network();
        HashMap<Integer, PathElement> map = net.getPathElements();
        for(Entry e: map.entrySet()){
            assertEquals(((PathElement)e.getValue()).getId(), e.getKey());
            System.out.println("value.id = " + ((PathElement)e.getValue()).getId() + " key = " + e.getKey());
        }
    }
  */
    @Test
    public void connectionsTest(){
        Network net = new Network();
        HashMap<Integer, PathElement> map = net.getPathElements();
        for(Entry e: map.entrySet()){
            Collection<PathElement> list = ((PathElement) e.getValue()).getConnections();
            for(PathElement pe: list)
                assertEquals(list.isEmpty(), true);
        }
    }
}