package se.kth.iv1350.pos.model;

import java.util.*;

/**
 * SaleDTO, Sale data transfer object. Groups variables related to a sale.
 */
public class SaleDTO {
	private java.time.LocalTime time;
	private String nameOfStore;
	private double totalDiscount;
	private double totalVAT;
	private double totalPrice;
	private List<Item> items;

	/**
	 * Creates an instance of SaleDTO.
	 * @param time Holds the current time of the sale
	 * @param nameOfStore Holds Name of the store
	 * @param totalDiscount	Holds the total Discount for the sale
	 * @param totalVAT Holds the total VAT
	 * @param totalPrice Holds the total Price
	 * @param items Holds the current Sale Items
	 */
	public SaleDTO(java.time.LocalTime time, String nameOfStore, double totalDiscount, double totalVAT,
			double totalPrice, List<Item> items) {
		this.time = time;
		this.nameOfStore = nameOfStore;
		this.totalDiscount = totalDiscount;
		this.totalVAT = totalVAT;
		this.totalPrice = totalPrice;
		this.items = new ArrayList<>();
	}

	/**
     * Returns the localtime.
     * @return time returns the local time.
     */
	public java.time.LocalTime getTime() {
		return this.time;
	}

	/**
     * Returns the name of the store.
     * @return nameOfStore
     */
	public String getNameOfStore() {
		return this.nameOfStore;
	}

	/**
	 * Return total VAT of the sale
	 * @return totalVAT, holds the total VAT for the sale
	 */
	public double getTotalVAT() {
		return this.totalVAT;
	}

	/**
	 * Returns the total Price of the sale
	 * @return totalPrice, holds the total Price of the Sale
	 */
	public double getTotalPrice() {
		return this.totalPrice;
	}

	/**
	 * Returns a list of items in the current sale
	 * @return items, holds the current Sale items
	 */
	public List<Item> getItems() {
		return this.items;
	}

	/**
     * This method updates the total price for the sale.
     * @param amount the cost of the item.
     * @param quantity the quantity of the item.
     * @param totalVAT the total VAT
     */
	public void updateTotalPrice(double amount, int quantity, double totalVAT) {
		this.totalPrice += (amount * quantity) + (totalVAT * (double)quantity) ;
	}

	/**
     * Updates the total VAT for the entire sale.
     * @param amount the price of the item.
     * @param quantity the quantity of the item.
     */
	public void updateTotalVAT(double vat, int quantity) {
		this.totalVAT += (vat* quantity);
	}

	/**
     * Adds the item to the arraylist nameOfItems.
     * @param item the item being added to the list.
     */
	public void updateItems(Item item) {
		items.add(item);
	}
}
