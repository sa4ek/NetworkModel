package ru.ncedu.sa4ek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sa4ek on 07.01.15.
 */
public class MainRoute {
    public static void main(String[] args) throws IOException, RouteNotFoundException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String command = reader.readLine();
            if(command.equals("exit")) System.exit(0);
            else if(command.equals("route")) {
                System.out.println("Please enter: id1, id2 (separated by commas)");
                String s = reader.readLine();
                String arg[] = s.split(", ");
                Network network = new Network();
                RouteProvider provider = new RouteProviderImpl();
                System.out.println(provider.getRoute(Integer.parseInt(arg[0]), Integer.parseInt(arg[1]), network));

            }
            /*
            else if(command.equals("route -ip")){
                System.out.println("Please enter: ip1, ip2 (separated by commas)");
                String s = reader.readLine();
                String arg[] = s.split(", ");
                Network network = new Network();
                RouteProvider provider = new RouteProviderImpl();
                System.out.println(provider.getRoute(arg[0], arg[1], network));
            }
            */
            else {
                System.out.println("Use: route/route -ip/exit");
            }

        }

    }
}
