/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sara
 */
import java.util.*;
public class UserInterface {
    private final Map<String,Plane> planes;
    private final Map<String, Map<String,Plane>> flights;
    
    public UserInterface()
    {
        this.planes = new HashMap<String,Plane>();
        this.flights = new HashMap<String,Map<String,Plane>>();
    }
    public void start(Scanner scanner)
    {
        System.out.println("Airport panel");
        System.out.println("--------------------");
        System.out.println("");
        
        while(true)
        {
            System.out.println("Choose operation:\n" +
                               "[1] Add airplane\n" +
                               "[2] Add flight\n" +
                               "[x] Exit\n" +
                                "> ");
            
            String command = scanner.nextLine();
            
            if(command.equals("1"))//add airplane
            {
                System.out.print("Give plane ID: ");
                String planeID = scanner.nextLine();
                System.out.print("Give plane capacity: ");
                String planeCapacity = scanner.nextLine();
                this.planes.put(planeID, new Plane(planeID, planeCapacity));//added airplane
            }
            else if(command.equals("2"))//add flight
            {
                System.out.print("Give plane ID: ");
                String planeID = scanner.nextLine();
                System.out.print("Give departure airport code: ");
                String departure = scanner.nextLine();
                System.out.print("Give destination airport code: ");
                String destination = scanner.nextLine();
                String departureToDestination = departure + "-" + destination;
                Plane currentPlane = new Plane("a","b");
                for(String x : this.planes.keySet())
                {
                    if(x.equals(planeID))
                    {
                        currentPlane = this.planes.get(x);
                    }
                }
                this.flights.put(departureToDestination, new HashMap<String,Plane>());
                this.flights.get(departureToDestination).put(planeID, currentPlane);//does that work?
            }
            else if(command.equals("x"))
            {
                break;
            }
        }
        
        System.out.println("");
        
        System.out.println("Flight service");
        System.out.println("------------");
        System.out.println("");
        
        while(true)
        {
            System.out.println("Choose operation:\n" +
                               "[1] Print planes\n" +
                               "[2] Print flights\n" +
                               "[3] Print plane info\n" +
                               "[x] Quit\n" +
                               "> ");
            
            String command = scanner.nextLine();
            if(command.equals("1"))//print planes
            {
                for(String x : this.planes.keySet())
                {
                    System.out.println(x + " (" + this.planes.get(x).getCapacity() + " ppl)");
                }
            }
            else if(command.equals("2"))//print flights
            {
                for(String x : this.flights.keySet())
                {
                    Map<String,Plane> current = this.flights.get(x);
                    String ID = "";
                    for(String y : current.keySet())
                    {
                        ID = y;//plane ID?
                    }
                    System.out.println(ID + " ("+ current.get(ID).getCapacity() + " ppl) " + "(" + x + ")");
                }
                System.out.println("");
            }
            else if(command.equals("3"))//print plane info
            {
                System.out.print("Give plane ID: ");
                String planeID = scanner.nextLine();
                for(String x : this.planes.keySet())
                {
                    if(x.equals(planeID))
                    {
                        System.out.println(x + " (" + this.planes.get(x).getCapacity() + " ppl)");
                    }
                }
                System.out.println("");
            }
            else if (command.equals("x"))
            {
                break;
            }
        }
    }
}