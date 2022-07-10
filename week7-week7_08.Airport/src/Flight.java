/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
import java.util.*;
public class Flight {
    private final String departuretodestination;
    private final Map<String,Plane> flightInfo;
    public Flight(String departuretodestination)
    {
        this.departuretodestination = departuretodestination;
        this.flightInfo = new HashMap<String,Plane>();
    }
}