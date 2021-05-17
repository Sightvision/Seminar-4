package se.kth.iv1350.pos.view;

import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.integration.*;
import se.kth.iv1350.pos.model.*;
/**
 * The View of the program which runs a runFakeExecution task.
 */
public class View {
    private Controller contr;
    
    /**
     * Creates a new instance, that uses the specified controller for all calls to other layers.
     * 
     * @param contr The controller to use for all calls to other layers.
     */
    public View(Controller contr) {
        this.contr = contr;
    }
    
    /**
     * Performs a fake sale by calling all system operations in the controller.
     * If item identifier 100 is entered the simulatation for an offline db/server starts.
     */
    public void runFakeExecution() {
    	contr.startSale();
    	System.out.println("Försäljning startad.");
           
        try{
            SaleDTO saleDTO = contr.enterItem(1, 10);
            System.out.println("Föremål:      " + saleDTO.getItems().get(0).getItemDTO().getItemDescription() + "    " +  saleDTO.getItems().get(0).getItemDTO().getPrice() + " SEK");
        } catch(ItemIdentifierNotValidException exception){
            System.err.println("Invalid item identifier!");
        } catch(DataBaseOfflineException exception){
            System.err.println("Database seems to be offline! Please contact support : 0707415041");
        }
        
    	//SaleDTO saleDTO = contr.enterItem(10, 10);
        //System.out.println("Föremål:      " + saleDTO.getItems().get(0).getItemDTO().getItemDescription() + "    " +  saleDTO.getItems().get(0).getItemDTO().getPrice() + " SEK");
        //System.out.println("Running total:                                          " + saleDTO.getTotalPrice() + " SEK");

    	
    	contr.endSale();
        System.out.println("Försäljning avslutad.");
    	double change = contr.pay(100,"Cash");
        System.out.println("Växel:              " + change + " SEK");
    	contr.print();
    }
}

