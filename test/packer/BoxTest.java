/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packer;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Cory
 */
public class BoxTest {
    
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
    
    Address testAddress3 = new Address("321 Back St", "Christly", "Holly Oaks", "C333", testCoordinates1);
    Address testAddress4 = new Address("55 Some St", "Somewhere", "Elsewhere", "E555", testCoordinates2);
    
    Depot testDepot0 = new Depot("Test Depot", testAddress3);
    Depot testDepot4 = new Depot("Test Depot", testAddress4);
    Customer testCustomer = new Customer("Test Customer", testAddress3);
    Box testBox = new Box(testCustomer,testDepot0);
    Box testBox2 = new Box(testCustomer,testDepot0);
                
                
    @BeforeClass
    public static void setUpClass() {
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("Testing box class...");
       
    }
    
    /**
     * this test check if the product can fit in the box.
     */
    
     @Test
    public void canFitTest() {
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("Tests if the box can fit product");
        assertEquals(true, testBox.canFit(a2));
        assertEquals(false, testBox.canFit(b3));
    }
    
    
    /**
     * this test check if the box is heavy and over 15kg or not.
     */
    @Test
    public void isHeavyTest() {
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("Tests if the box is heavy");
        testBox.addProduct(a2, 8);
        assertEquals(true, testBox.isHeavy());  
    }
    
    
    /**
     * this test check if the products need or don't need special labels.
     */
    
    @Test
    public void incorrectLabelTest () {
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("Tests if the box labeling is correct");
        testBox.addProduct(a5);
        assertEquals(false, testBox.isHeavy());
        assertEquals(false, testBox.isHazardous());
        assertEquals(false, testBox.isFragile());
        testBox.addProduct(b2, 10);
        assertEquals(true, testBox.isHeavy());
        assertEquals(true, testBox.isHazardous());
        assertEquals(true, testBox.isFragile());
    }
    
    
}
