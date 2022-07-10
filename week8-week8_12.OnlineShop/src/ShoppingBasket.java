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
public class ShoppingBasket {
    
    private Map<String,Purchase> purchases;
    
    public ShoppingBasket()
    {
        this.purchases = new HashMap<String,Purchase>();
        
    }
    
    public void add(String product, int price)
    {
        Purchase purchase;
        if(!purchases.containsKey(product))//if basket already contains product, don't creae a new purchase
        {
           purchase = new Purchase(product, 1, price);
           purchases.put(product, purchase);
        }
        else
        {
            purchase = purchases.get(product);//without this line, every product will be increased
            purchase.increaseAmount();
            purchases.put(product, purchase);
        }
    }
    
    public int price()
    {
        ArrayList<Purchase> products = new ArrayList<Purchase>(purchases.values());
        
        int price = 0;
        for(Purchase p : products)
        {
            price += p.price();
        }
        return price;
    }
    
    public void print()
    {
        ArrayList<Purchase> products = new ArrayList<Purchase>(purchases.values());
        for(Purchase p : products)
        {
            System.out.println(p);// returns product: amount because we overrode toString in Purchase
        }
    }
}