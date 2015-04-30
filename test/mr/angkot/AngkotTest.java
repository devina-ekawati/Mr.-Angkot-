/*
 * @author Irene Wiliudarsan	(13513002)
 * @author Angela Lynn		(13513032)
 * @author Devina Ekawati	(13513088)
 * @bug Tidak ada bug ditemukan
 */  

package mr.angkot;

import java.awt.Graphics;
import java.awt.Graphics2D;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Windows7
 */


public class AngkotTest {
  
  public AngkotTest() {
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
   * Test of getCountPassengers method, of class Angkot.
   */
  @Test
  public void testGetCountPassengers() {
    System.out.println("getCountPassengers");
    Angkot instance = new Angkot(30,50);
    int expResult = 0;
    int result = instance.getCountPassengers();
    assertEquals(expResult, result);
  }

  /**
   * Test of getEmptySpace method, of class Angkot.
   */
  @Test
  public void testGetEmptySpace() {
    System.out.println("getEmptySpace");
    Angkot instance = new Angkot(45,45);
    int expResult = 14;
    int result = instance.getEmptySpace();
    assertEquals(expResult, result);
  }

  /**
   * Test of getXPosition method, of class Angkot.
   */
  @Test
  public void testGetXPosition() {
    System.out.println("getXPosition");
    Angkot instance = new Angkot(40,20);
    float expResult = 40.0F;
    float result = instance.getXPosition();
    assertEquals(expResult, result, 0.0);
  }

  /**
   * Test of getYPosition method, of class Angkot.
   */
  @Test
  public void testGetYPosition() {
    System.out.println("getYPosition");
    Angkot instance = new Angkot(40,20);
    float expResult = 20.0F;
    float result = instance.getYPosition();
    assertEquals(expResult, result, 0.0);
  }

  /**
   * Test of setX method, of class Angkot.
   */
  @Test
  public void testSetX() {
    System.out.println("setX");
    float _x = 35.0F;
    Angkot instance = new Angkot(30,30);
    instance.setX(_x);
  }

  /**
   * Test of setY method, of class Angkot.
   */
  @Test
  public void testSetY() {
    System.out.println("setY");
    float _y = 80.0F;
    Angkot instance = new Angkot(20,20);
    instance.setY(_y);
  }

  /**
   * Test of add method, of class Angkot.
   */
  @Test
  public void testAdd() {
    System.out.println("add");
    Passenger passenger = new Passenger();
    Angkot instance = new Angkot(35,35);
    instance.add(passenger);
  }

  /**
   * Test of clear method, of class Angkot.
   */
  @Test
  public void testClear() {
    System.out.println("clear");
    int index = 0;
    Angkot instance = new Angkot(45,45);
    Passenger pass = new Passenger();
    Passenger pass2 = new Passenger();
    instance.add(pass);
    instance.add(pass2);
    instance.clear(index);
  }

  /**
   * Test of clearAll method, of class Angkot.
   */
  @Test
  public void testClearAll() {
    System.out.println("clearAll");
    Angkot instance = new Angkot(30,30);
    Passenger pass = new Passenger();
    Passenger pass2 = new Passenger();
    instance.add(pass);
    instance.add(pass2);
    instance.clearAll();
  }

  /**
   * Test of isEmpty method, of class Angkot.
   */
  @Test
  public void testIsEmpty() {
    System.out.println("isEmpty");
    Angkot instance = new Angkot(50,50);
    boolean expResult = true;
    boolean result = instance.isEmpty();
    assertEquals(expResult, result);
  }

  /**
   * Test of isFull method, of class Angkot.
   */
  @Test
  public void testIsFull() {
    System.out.println("isFull");
    Angkot instance = new Angkot(45,45);
    boolean expResult = false;
    boolean result = instance.isFull();
    assertEquals(expResult, result);
  }

  /**
   * Test of run method, of class Angkot.
   */
  @Test
  public void testRun() {
    System.out.println("run");
    Angkot instance = new Angkot(60,40);
    instance.run();
  }
}
