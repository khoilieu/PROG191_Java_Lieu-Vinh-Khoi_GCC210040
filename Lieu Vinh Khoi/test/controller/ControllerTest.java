/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.Product;
import model.XFile;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Liêu Vinh Khôi
 */
public class ControllerTest {
    
    public ControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of checkLogin method, of class Controller.
     */
    @Test
    public void testCheckLogin() {
        System.out.println("checkLogin");
        String user = "";
        String pass = "";
        Controller instance = new Controller();
        instance.checkLogin(user, pass);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadcbPro method, of class Controller.
     */
    @Test
    public void testLoadcbPro() {
        System.out.println("loadcbPro");
        Controller instance = new Controller();
        instance.loadcbPro();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadFile method, of class Controller.
     */
    @Test
    public void testLoadFile() {
        System.out.println("loadFile");
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.loadFile();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadFileSale method, of class Controller.
     */
    @Test
    public void testLoadFileSale() {
        System.out.println("loadFileSale");
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.loadFileSale();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletePro method, of class Controller.
     */
    @Test
    public void testDeletePro() {
        Controller con = new Controller();
        ArrayList<Product> proList = (ArrayList<Product>) XFile.readObject(con.filePath);
        
        int size = 3;
        
        assertEquals(size, proList.size());
    }

    /**
     * Test of saveFilePro method, of class Controller.
     */
    @Test
    public void testSaveFilePro() {
        System.out.println("saveFilePro");
        Controller instance = new Controller();
        instance.saveFilePro();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readFilePro method, of class Controller.
     */
    @Test
    public void testReadFilePro() {
        System.out.println("readFilePro");
        Controller instance = new Controller();
        instance.readFilePro();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readFileAcc method, of class Controller.
     */
    @Test
    public void testReadFileAcc() {
        System.out.println("readFileAcc");
        Controller instance = new Controller();
        instance.readFileAcc();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addSale method, of class Controller.
     */
    @Test
    public void testAddSale() {
        System.out.println("addSale");
        Controller instance = new Controller();
        instance.addSale();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of testSale method, of class Controller.
     */
    @Test
    public void testTestSale() {
        System.out.println("testSale");
        Controller instance = new Controller();
        instance.testSale();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPro method, of class Controller.
     */
    @Test
    public void testAddPro() {
        Controller con = new Controller();
        ArrayList<Product> proList = (ArrayList<Product>) XFile.readObject(con.filePath);
        String names = "Bia 1";
        String prices = "1234";
        String nations = "Korean";
        String dess = "dsd";
        int indexNation = 2;
        
        assertTrue("fail", con.addPro(names, prices, nations, dess, indexNation));
    }

    /**
     * Test of upPro method, of class Controller.
     */
    @Test
    public void testUpPro() {
        Controller con = new Controller();
        ArrayList<Product> proList = (ArrayList<Product>) XFile.readObject(con.filePath);
        int prices = 123;
        assertEquals(prices, proList.get(0).getPrice());   
    }

    /**
     * Test of loadImg method, of class Controller.
     */
    @Test
    public void testLoadImg() {
        System.out.println("loadImg");
        Controller instance = new Controller();
        instance.loadImg();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
