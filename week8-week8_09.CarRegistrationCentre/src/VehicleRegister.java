/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
public class VehicleRegister {
    
    private HashMap<RegistrationPlate, String> owners;
    
    public VehicleRegister()
    {
        this.owners = new HashMap<RegistrationPlate, String>();
    }
    
    public boolean add(RegistrationPlate plate, String owner)
    {
        if(owners.containsKey(plate) && owners.get(plate) == null || !owners.containsKey(plate))
            /* if the plate is in the list but no owner registered, add it.
            Or if the plate is not registered, add it*/
        {
            this.owners.put(plate, owner);
            return true;
        }
        else
            return false;
    }
    public String get(RegistrationPlate plate)
    {
        if(owners.containsKey(plate))
        {
            return owners.get(plate);
        }
        else
            return null;
    }
    public boolean delete(RegistrationPlate plate)
    {
        if(owners.containsKey(plate))
        {
            owners.remove(plate);
            return true;
        }
        else
            return false;
    }
    public void printRegistrationPlates()
    {
        for(RegistrationPlate key : owners.keySet())
        {
            System.out.println(key);
        }
    }
    public void printOwners()
    {
        Set<String> set = new HashSet<String>(owners.values());
        for(String s : set)
        {
            System.out.println(s);
        }
    }
}