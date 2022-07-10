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
public class Hand implements Comparable<Hand>{
    
    private List<Card> hand;
    
    public Hand()
    {
        this.hand = new ArrayList<Card>();
    }
    public void add(Card card)
    {
        hand.add(card);
    }
    
    public int sum()
    {
        int sum = 0;
        
        for(Card card : hand)
        {
            sum += card.getValue();
        }
        
        return sum;
    }
    
    @Override
    public int compareTo(Hand otherhand)
    {
        if(this.sum() == otherhand.sum())
        {
            return 0;
        }
        else if (this.sum() > otherhand.sum())
        {
            return 1;
        }
        else
            return -1;
    }
    
    public void sort()
    {
        Collections.sort(hand);
    }
    
    public void print()
    {
        for(Card card : hand)
        {
            System.out.println(card);
        }
    }
    
    public void sortAgainstSuit()
    {
        Collections.sort(hand, new SortAgainstSuitAndValue());
    }
}