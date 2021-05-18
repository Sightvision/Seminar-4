package se.kth.iv1350.pos.view;
import java.io.*;
import se.kth.iv1350.pos.model.SaleObserver;

public class TotalRevenueFileOutput implements SaleObserver {
    private double totalRevenue;
    private PrintWriter file;
    
    TotalRevenueFileOutput() {
        try{
           file = new PrintWriter(new FileWriter("revenue.txt"), true); 
        }catch(IOException exception){
           System.out.println("Could not create file");
        }
    }
    
    @Override
    public void newSale(double totalPrice){
        totalRevenue += totalPrice;
        file.println("Total Revenue: " + totalRevenue);
    }
}
