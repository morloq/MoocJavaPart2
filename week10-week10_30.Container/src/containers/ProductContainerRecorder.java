/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

/**
 *
 * @author Admin
 */
public class ProductContainerRecorder extends ProductContainer{
    
    private final ContainerHistory containerHistory = new ContainerHistory();
    
    public ProductContainerRecorder(String productName, double capacity, double initialVolume)
    {
        super(productName, capacity);
        super.volume = initialVolume;
        this.containerHistory.add(initialVolume);
    }
    
    @Override
    public void addToTheContainer(double amount) {
        if (amount < 0) {
            return;
        }
        if (amount <= getCurrentCapacity()) {
            volume = volume + amount;
            this.containerHistory.add(volume);
        } else {
            volume = capacity;
            this.containerHistory.add(volume);
        }
    }
    
    @Override
    public double takeFromTheContainer(double amount) {
        if (amount < 0) {
            return 0.0;
        }
        if (amount > volume) {
            double everything = volume;
            volume = 0.0;
            this.containerHistory.add(volume);
            return everything;
        }

        volume = volume - amount;
        this.containerHistory.add(volume);
        return amount;
    }
    
    public void printAnalysis()
    {
        double variance = containerHistory.variance();
        System.out.println(   "Product: " + super.getName() + "\n"
                + "History: " + containerHistory.toString() + "\n"
                + "Greatest product amount: " + containerHistory.maxValue() + "\n"
                + "Smallest product amount: " + containerHistory.minValue() + "\n"
                + "Average: " + containerHistory.average() + "\n"
                + "Greatest change: " + containerHistory.greatestFluctuation() + "\n"
                + "Variance: " + variance);
    }
    
    public String history()
    {
        return containerHistory.toString();
    }
}