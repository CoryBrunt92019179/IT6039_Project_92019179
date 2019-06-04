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


 


public class ManifestTest {
    
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
    
    
    
    /**
     * this test check if the product will be able to fit the box.
     */
    @Test
    public void remainingCapacityTest() {
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("Tests the remaining capacity in the box");
        assertEquals(20, testBox.remainingCapacity(), 0);
        testBox.addProduct(a2);
        assertEquals(18, testBox.remainingCapacity(), 0);
        testBox.addProduct(b4);
        assertEquals(14, testBox.remainingCapacity(), 0);
    }
    
    /**
     * this test check if the product is fragile or not.
     */
     
    @Test
    public void IsFragileTest() {
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
         System.out.println("Tests if the box is fragile");
        assertEquals(true,a2.isFragile());
        assertEquals(true,b1.isFragile());
        assertEquals(false,a4.isFragile());
        assertEquals(false,b4.isFragile());
    }
    
    
    // this test check if the product is hazardous or not.
    @Test
    public void IsHazardousTest() {
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("Tests if the box is hazardous");
        assertEquals(true,a1.isHazardous());
        assertEquals(false,a3.isHazardous());
        assertEquals(true,b2.isHazardous());
        assertEquals(false,b3.isHazardous());
    }
}
