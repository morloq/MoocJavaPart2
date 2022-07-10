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
public class Storehouse {
    
    private Map<String,Integer> stock;
    private Map<String,Integer> storehouse;
    
    public Storehouse()
    {
        this.storehouse = new HashMap<String,Integer>();
        this.stock = new HashMap<String,Integer>();
    }
    
    public void addProduct(String product, int price, int stock)
    {
        this.storehouse.put(product, price);
        this.stock.put(product, stock);
    }
    
    public int price(String product)
    {
        if(storehouse.containsKey(product))
        {
            return storehouse.get(product);
        }
        else
            return -99;
    }
    
    public int stock(String product)
    {
        if(stock.containsKey(product))
        {
            return stock.get(product);
        }
        else
            return 0;
    }
    
    public boolean take(String product)
    {
        if(storehouse.containsKey(product) && stock(product) > 0)
        {
            stock.put(product, stock.get(product) -1);
            return true;
        }
        else
            return false;
    }
    
    public Set<String> products()
    {
        Set<String> storedproducts = storehouse.keySet();
        return storedproducts;
    }
}