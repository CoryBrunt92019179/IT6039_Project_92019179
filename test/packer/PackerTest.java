/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packer;

import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import packer.Customer;
/**
 *
 * @author Cory
 */
public class PackerTest {
    // Test data  
    Product a1 = new Product("Product1", 0, true, true);
    Product a2 = new Product("Product2", 2, true, true);
    Product a3 = new Product("Product3", 3, false, true);
    Product a4 = new Product("Product4", 4, true, false);
    Product a5 = new Product("Product9", 4, false, false);
    
    
    Product b1 = new Product("Product5", 0, true, true);
    Product b2 = new Product("Product6", 2, true, true);
    Product b3 = new Product("Product7", 20, false, true);
    Product b4 = new Product("Product8", 4, true, false);
    
    Coordinates testCoordinates1 = new Coordinates(0,0);
    Coordinates testCoordinates2 = new Coordinates(30,40);
    Coordinates testCoordinates3 = new Coordinates(2000,4000);
    Coordinates testCoordinates4 = new Coordinates(2300,4300);
    Coordinates testCoordinates5 = new Coordinates(3000,5000);
    
    Address testAddress1 = new Address("123 here St", "Overthere", "Old", "E343", testCoordinates1);
    Address testAddress2 = new Address("321 Back St", "Christly", "Holly Oaks", "C333", testCoordinates2);
    Address testAddress3 = new Address("55 Some St", "Somewhere", "Elsewhere", "E555", testCoordinates3);
    Address testAddress4 = new Address("65 Bob Pl", "there", "Old Town", "E399", testCoordinates4);
    Address testAddress5 = new Address("77 next Pl", "kool", "Mighty", "E600", testCoordinates5);
    
    Depot testDepot0 = new Depot("Test Depot", testAddress1);
    Depot testDepot4 = new Depot("Test Depot", testAddress5);
    Customer testCustomer = new Customer("Test Customer", testAddress2);
    Customer testCustomer1 = new Customer("Test Customer1", testAddress3);
    Box testBox = new Box(testCustomer,testDepot0);
    Box testBox1 = new Box(testCustomer1,testDepot4);
    
    
    
     @BeforeClass
    public static void setUpClass() {
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("Testing Packer Class...");
       
    }
    
    /**
     * this test check if the customers address is on the label.
     */
    
    @Test
    public void boxAddressLabelTest() {
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("Tests if the box address is correct");
        System.out.println("");
        String expectedLable
                = testCustomer + "\n"
                + testCustomer.getClosestAddressTo(testDepot0);

        System.out.println(expectedLable + "\n\n");
        System.out.println(testBox.getLabel());

        assertEquals(expectedLable + "\n\n", testBox.getLabel());
        
        
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("Tests if the box address is correct");
        System.out.println("");
        
       String expectedLable1
                = testCustomer1 + "\n"
                + testCustomer1.getClosestAddressTo(testDepot4);

        System.out.println(expectedLable1 + "\n\n");
        System.out.println(testBox1.getLabel());
        
        assertEquals(expectedLable1 + "\n\n", testBox1.getLabel());
    }
    
    
    /**
     * this test check if the box is using the closest address to depot.
     */
    
    @Test
    public void boxAddressClosestTest() {
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("Tests if the box address is closest to depot");
    testCustomer.addAddress(testAddress4);
     assertEquals(testAddress4, testCustomer.getClosestAddressTo(testDepot4));
     
     assertEquals(testAddress2, testCustomer.getClosestAddressTo(testDepot0));
    }
     
}
