/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personnel;

/**
 *
 * @author Admin
 */
import java.util.*;
public class Employees {
    
    List<Person> employees;
    
    public Employees()
    {
        this.employees = new ArrayList<Person>();
    }
    
    public void add(Person person)
    {
        employees.add(person);
    }
    
    public void add(List<Person> person)
    {
        Iterator<Person> iterator = person.iterator();
        while(iterator.hasNext())
        {
            employees.add(iterator.next());
        }
    }
    
    public void print()
    {
        Iterator<Person> iterator = employees.iterator();
        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }
    
    public void print(Education education)
    {
        Iterator<Person> iterator = employees.iterator();
        while(iterator.hasNext())
        {
            Person current = iterator.next();
            if(current.getEducation().equals(education))
            {
                System.out.println(current);
            }
        }
    }
    
    public void fire(Education education)
    {
        Iterator<Person> iterator = employees.iterator();
        while(iterator.hasNext())
        {
            if(iterator.next().getEducation().equals(education))
            {
                iterator.remove();
            }
        }
    }
}