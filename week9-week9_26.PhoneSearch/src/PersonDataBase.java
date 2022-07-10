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
public class PersonDataBase {
    private Map<String,Set<String>> numbers;
    private Map<String,Set<String>> address;
    
    public PersonDataBase()
    {
        this.numbers = new HashMap<String,Set<String>>();
        this.address = new HashMap<String,Set<String>>();
    }
    
    public void addNumber(String name, String number)
    {
        if(!this.numbers.containsKey(name))
        {
            this.numbers.put(name,new HashSet<String>());//if not contained, add name in number
            
        }
        this.numbers.get(name).add(number);//add number to name stored
    }
    
    public List<String> getNumber(String name)
    {
        List<String> wantedNumber = new ArrayList<String>();
        if(!numbers.containsKey(name))
        {
            //return empty list
        }
        else
        {
            Set<String> numbers = this.numbers.get(name);
            for(String n : numbers)
            {
                wantedNumber.add(n);
            }
        }
        return wantedNumber;
    }
    
    public String getName(String number)
    {
        String name = "";
        
        for(Set<String> s : this.numbers.values())
        {
            if(s.contains(number))//forgot to check if number is even found!
            {
                for(String n : this.numbers.keySet())
                {
                    if(this.numbers.get(n).equals(s))
                    {
                        name += n;
                    }
                }
            }
        }
        return name;
    }
    
    public void addAddress(String name, String streetandcity)
    {
        if(!address.containsKey(name))
        {
            this.address.put(name, new HashSet<String>());
        }
        this.address.get(name).add(streetandcity);
    }
    
    public Set<String> getAddress(String name)
    {
        Set<String> addressofperson = new HashSet<String>();
        if(!this.address.containsKey(name))
        {
            
        }
        else
        {
            addressofperson = this.address.get(name);
        }
        return addressofperson;
    }
    
    public void remove(String name)
    {
        if(this.numbers.containsKey(name))
        {
            this.numbers.remove(name);
        }
        if(this.address.containsKey(name))
        {
            this.address.remove(name);
        }
    }
    
    public Set<String> filteredInformation(String keyword)
    {
        Set<String> result = new HashSet<String>();
        if(!keyword.isEmpty())
        {
            for(String s : this.numbers.keySet())
            {
                if(s.contains(keyword))
                {
                    result.add(s);
                }
            }
            for(String s : this.address.keySet())
            {
                if(s.contains(keyword))
                {
                    result.add(s);
                }
            }
            for(String set : this.address.keySet())
            {
                for(String l : address.get(set))
                {
                    if(l.contains(keyword))
                    {
                        result.add(set);
                    }
                }
            }
        }
        else
        {
            for(String s : this.numbers.keySet())
            {
                result.add(s);
            }
            for(String s : this.address.keySet())
            {
                result.add(s);
            }
        }
        return result;
    }
}