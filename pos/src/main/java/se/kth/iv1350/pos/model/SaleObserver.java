package se.kth.iv1350.pos.model;

public interface SaleObserver {
    /**
     * @param totalPrice 
     */
    public void newSale(double totalPrice);
}
