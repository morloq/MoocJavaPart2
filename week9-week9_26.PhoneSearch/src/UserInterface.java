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
public class UserInterface{
    private PersonDataBase database;
    
    public UserInterface()
    {
        this.database = new PersonDataBase();
    }
    
    public void start(Scanner scanner)
    {
        menu();
        
        while(true)
        {
            System.out.println("");
            System.out.print("command: ");
            String command = scanner.nextLine();
          
            
            if(command.equals("x"))
            {
                break;
            }
            else if(command.equals("1"))
            {
                System.out.print("whose number: ");
                String name = scanner.nextLine();
                System.out.print("number: ");
                String number = scanner.nextLine();
                database.addNumber(name, number);
            }
            else if(command.equals("2"))
            {
                System.out.print("whose number: ");
                String name = scanner.nextLine();
                List<String> desirednumber = database.getNumber(name);
                if(!desirednumber.isEmpty())
                {
                    for(String n : desirednumber)
                    {
                        System.out.println("  " +  n);
                    }
                }
                else
                    System.out.print("  not found\n");
            }
            else if(command.equals("3"))
            {
                System.out.print("number: ");
                String number = scanner.nextLine();
                String searched = database.getName(number);
                if(!searched.isEmpty())
                {
                    System.out.println("  " + searched);
                }
                else
                    System.out.print("  not found\n");
            }
            else if(command.equals("4"))
            {
                System.out.print("whose address: ");
                String name = scanner.nextLine();
                System.out.print("street: ");
                String street = scanner.nextLine();
                System.out.print("city: ");
                String city = scanner.nextLine();
                String streetandcity = street + " " + city;
                database.addAddress(name, streetandcity);
            }
            else if(command.equals("5"))
            {
                System.out.print("whose information: ");
                String name = scanner.nextLine();
                
                Set<String> addressofperson = database.getAddress(name);
                List<String> numbersofperson = database.getNumber(name);
                
                if(!(numbersofperson.isEmpty() && addressofperson.isEmpty()))
                {
                    
                    if(!addressofperson.isEmpty())
                    {
                        System.out.print("  address: ");
                        for(String s : addressofperson)
                        {
                            System.out.print(s + "\n");
                        }
                    }
                    else
                        System.out.println("  address unknown");


                    if(!numbersofperson.isEmpty())
                    {
                        System.out.println("  phone numbers:");
                        for(String n : numbersofperson)
                        {
                            System.out.println("   " + n);
                        }
                    }
                    else
                        System.out.println("  phone number not found");
                    
                }
                else
                    System.out.println("  not found");
                
                
                
            }
            else if(command.equals("6"))
            {
                System.out.print("whose information: ");
                String name = scanner.nextLine();
                database.remove(name);
            }
            else if(command.equals("7"))
            {
                System.out.print("keyword (if empty, all listed): ");
                String keyword = scanner.nextLine();
                System.out.println("");
                Set<String> results = database.filteredInformation(keyword);
                if(results.isEmpty())
                {
                    System.out.println("  keyword not found");
                }
                if(!results.isEmpty())
                {
                    List<String> resultlist = new ArrayList<String>(results);
                    Collections.sort(resultlist);
                    for(String s : resultlist)
                    {
                        System.out.println(" " + s);
                        Set<String> sAddress = database.getAddress(s);
                        if(!sAddress.isEmpty())
                        {
                            System.out.print("  address: ");
                            for(String address : sAddress)
                            {
                                System.out.print(address + "\n");
                            }
                        }
                        else
                            System.out.println("  address unknown");
                        
                        List<String> sNumbers = database.getNumber(s);
                        if(!sNumbers.isEmpty())
                        {
                            System.out.println("  phone numbers:");
                            for(String n : sNumbers)
                            {
                                System.out.println("   " + n);
                            }
                        }
                        else
                            System.out.println("  phone number not found");
                    }
                }
            }
        }
    }
    public void menu()
    {
        System.out.print("phone search\n" +
        "available operations:\n" +
        " 1 add a number\n" +
        " 2 search for a number\n" +
        " 3 search for a person by phone number\n" +
        " 4 add an address\n" +
        " 5 search for personal information\n" +
        " 6 delete personal information\n" +
        " 7 filtered listing\n" +
        " x quit\n");
    }
}