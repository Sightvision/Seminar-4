package se.kth.iv1350.pos.view;
import se.kth.iv1350.pos.model.SaleObserver;
/**
 * 
 */
class TotalRevenueView implements SaleObserver {
    private double totalRevenue;
    
    /**
     * 
     */
    TotalRevenueView(){
        this.totalRevenue = 0;
    }
    /**
     * 
     * @param totalPrice 
     */
    @Override
    public void newSale(double totalPrice){
        totalRevenue += totalPrice;
        System.out.println("Total revenue: " + totalRevenue);
    }
}
