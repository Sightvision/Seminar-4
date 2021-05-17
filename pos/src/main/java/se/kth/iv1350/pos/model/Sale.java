package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.integration.*;
import se.kth.iv1350.pos.model.*;
import se.kth.iv1350.pos.controller.Controller;
import java.time.*;
import java.util.*;

/**
 * Represents one sale, one customer.
 */
public class Sale {
    private LocalTime time; 
    private SaleDTO saleInformation;
    private Receipt receipt;
    private List<Item> items;
    private List<Integer> customerItemsQuantity = new ArrayList<>();

    /**
	 * Creates a new instance of sale and saves the time.
	 */
    public Sale () {
    	this.time = LocalTime.now();
    	this.items = new ArrayList<>();
    	this.saleInformation = new SaleDTO(time, "Gittans Livs", 0,  0, 0, null);
    }

    /**
	 * Returns an arraylist with all items of the class "Item".
	 * @return items an arraylist containing all items.
	 */
    public List<Item> getItems() {
    	return this.items;
    }

    /**
	 * Returns the customer's item quantity.
	 * @return customerItemsQuantity quantity of items the customer wants to buy.
	 */
    public List<Integer> getCustomerItemsQuantity(){
    	return this.customerItemsQuantity;
    }

    /**
	 * Returns the sale information for the sale.
	 * @return saleInformation contains the information of the sale.
	 */
    public SaleDTO getSaleInformation() {
        return this.saleInformation;
    }
    
    /**
	 * Adds an item to the current sale.
	 * @param item the item that is being added.
	 * @param quantity the quantity of the item being added.
	 */
    public void addItem(Item item, int quantity) {
    	this.saleInformation.updateTotalVAT(item.getItemDTO().getVAT(), quantity);
    	this.saleInformation.updateTotalPrice(item.getItemDTO().getPrice(), quantity, (item.getItemDTO().getVAT()));
        isDuplicateItem(item, quantity);
    }
    /**
	 * Handles duplicate items by increasing the quantity by one for the given item.
	 * @param currentItem the duplicate item.
	 * @param quantity the quantity of this item.
	 */
    public void isDuplicateItem(Item item, int quantity) {
        boolean found = false;
    	for(Item currentItem : items) {
    		if(currentItem.getItemIdentifier() == item.getItemIdentifier()) {   
    			found = true;
    			customerItemsQuantity.set(items.indexOf(currentItem), (customerItemsQuantity.get(items.indexOf(currentItem)) + quantity));
    		}
    	}
        if(found == false) {
    		items.add(item);
    		saleInformation.updateItems(item);
                customerItemsQuantity.add(quantity);
    	}
    }
    
    /**
	 * Returns the receipt.
	 * @param sale the sale that is being handled.
	 * @return recepit the receipt of the sale.
	 */
    public Receipt getReceipt(Sale sale) {
        this.receipt = new Receipt(sale.getSaleInformation());
    	return receipt;
    }
}
