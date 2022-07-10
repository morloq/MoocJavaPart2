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
public class Person {
    
    private String name;
    private Education educationTitle;
    
    public Person(String name, Education e)
    {
        this.name = name;
        this.educationTitle = e;
    }
    
    public Education getEducation()
    {
        return this.educationTitle;
    }
    
    @Override
    public String toString()
    {
        return name + ", " + educationTitle;
    }
}