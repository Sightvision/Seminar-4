package se.kth.iv1350.pos.model;

import java.time.LocalTime;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SaleDTOTest {
    private SaleDTO saleDTO;
    
    public SaleDTOTest() {
        saleDTO = new SaleDTO(java.time.LocalTime.now(), "Gittans Livs", 0,  0, 0, null);   
    }

    @Test
    public void testUpdateTotalPrice() {
        System.out.println("updateTotalPrice");
        double amount = 100;
        int quantity = 2;
        double totalVAT = 10;
        saleDTO.updateTotalPrice(amount, quantity, totalVAT);
        double expResult = 220;
        double result = saleDTO.getTotalPrice();
        assertEquals(expResult, result, "Expected result did not equal result");
    }

    @Test
    public void testUpdateTotalVAT() {
        System.out.println("updateTotalVAT");
        double amount = 100;
        int quantity = 2;
        saleDTO.updateTotalVAT(100, 2);
        double expResult = 200;
        double result = saleDTO.getTotalVAT();
        assertEquals(expResult, result, "Expected result did not equal result");
    }

    @Test
    public void testUpdateNameOfItems() {
        System.out.println("updateNameOfItems");
        ItemDTO itemDTO = new ItemDTO("Karrékotlett med Ben Skivad ca 1kg ICA", 87, 12);
        Item item = new Item(1, itemDTO, 100);
        saleDTO.updateItems(item);
        String expResult = "Karrékotlett med Ben Skivad ca 1kg ICA";
        String result = saleDTO.getItems().get(0).getItemDTO().getItemDescription();
        assertEquals(expResult, result, "Expected result did not equal result");
    }
}
