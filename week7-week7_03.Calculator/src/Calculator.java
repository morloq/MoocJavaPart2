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
public class Calculator {
    private Reader reader = new Reader();
    private int operations = 0;
    
    public void start() {
        while (true) {
            System.out.print("command: ");
            String command = reader.readString();
            if (command.equals("end")) {
                break;
            }

            if (command.equals("sum")) {
                sum();
            } else if (command.equals("difference")) {
                difference();
            } else if (command.equals("product")) {
                product();
            }
        }

        statistics();
    }
    
    private void sum()
    {
        int[] array = enterValues();
        System.out.println("sum of the values " + (array[0] + array[1]));
        operations++;
    }
    
    private void difference()
    {
        int[] array = enterValues();
        System.out.println("difference of the values " + (array[0] - array[1]) + "\n");
        operations++;
    }
    
    private void product()
    {
        int[] array = enterValues();
        System.out.println("product of the values " + (array[0] * array[1]));
        operations++;
    }
    
    private void statistics()
    {
        System.out.println("Calculations done " + operations);
    }
    private int[] enterValues()
    {
        int[] array = new int[2];
        System.out.print("value1: ");
        array[0] = reader.readInteger();
        System.out.print("value2: ");
        array[1] = reader.readInteger();
        return array;
    }
}