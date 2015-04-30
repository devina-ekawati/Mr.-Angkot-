/*
 * @author Irene Wiliudarsan	(13513002)
 * @author Angela Lynn		(13513032)
 * @author Devina Ekawati	(13513088)
 * @bug Tidak ada bug ditemukan
 */

package mr.angkot;

import java.awt.Graphics;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
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
  @org.junit.Test
  public void testGetCountPassengers() {
    System.out.println("getCountPassengers");
    Angkot instance = new Angkot(0,0);
    int expResult = 0;
    int result = instance.getCountPassengers();
    assertEquals(expResult, result);
  }

  /**
   * Test of getEmptySpace method, of class Angkot.
   */
  @org.junit.Test
  public void testGetEmptySpace() {
    System.out.println("getEmptySpace");
    Angkot instance = new Angkot(0,0);
    int expResult = 14;
    int result = instance.getEmptySpace();
    assertEquals(expResult, result);
  }

  /**
   * Test of getXPosition method, of class Angkot.
   */
  @org.junit.Test
  public void testGetXPosition() {
    System.out.println("getXPosition");
    Angkot instance = new Angkot(2F,3F);
    float expResult = 2.0F;
    float result = instance.getXPosition();
    assertEquals(expResult, result, 0.0);
  }

  /**
   * Test of getYPosition method, of class Angkot.
   */
  @org.junit.Test
  public void testGetYPosition() {
    System.out.println("getYPosition");
    Angkot instance = new Angkot(2F,3F);
    float expResult = 3.0F;
    float result = instance.getYPosition();
    assertEquals(expResult, result, 0.0);
  }

  /**
   * Test of setX method, of class Angkot.
   */
  @org.junit.Test
  public void testSetX() {
    System.out.println("setX");
    float _x = 5.0F;
    Angkot instance = new Angkot(2F,3F);
    instance.setX(_x);
  }

  /**
   * Test of setY method, of class Angkot.
   */
  @org.junit.Test
  public void testSetY() {
    System.out.println("setY");
    float _y = 2.0F;
    Angkot instance = new Angkot(2F,3F);
    instance.setY(_y);
  }

  /**
   * Test of add method, of class Angkot.
   */
  @org.junit.Test
  public void testAdd() {
    System.out.println("add");
    Passenger passenger = new Passenger();
    Angkot instance = new Angkot(2F, 3F);
    instance.add(passenger);
  }

  /**
   * Test of clear method, of class Angkot.
   */
  @org.junit.Test
  public void testClear() {
    System.out.println("clear");
    int index = 0;
    Angkot instance = new Angkot(2F, 3F);
    Passenger passenger = new Passenger();
    instance.add(passenger);
    instance.clear(index);
  }

  /**
   * Test of clearAll method, of class Angkot.
   */
  @org.junit.Test
  public void testClearAll() {
    System.out.println("clearAll");
    Angkot instance = new Angkot(2F, 3F);
    Passenger passenger = new Passenger();
    instance.add(passenger);
    instance.clearAll();
  }

  /**
   * Test of isEmpty method, of class Angkot.
   */
  @org.junit.Test
  public void testIsEmpty() {
    System.out.println("isEmpty");
    Angkot instance = new Angkot(2F, 3F);
    boolean expResult = true;
    boolean result = instance.isEmpty();
    assertEquals(expResult, result);
  }

  /**
   * Test of isFull method, of class Angkot.
   */
  @org.junit.Test
  public void testIsFull() {
    System.out.println("isFull");
    Angkot instance = new Angkot(2F, 3F);
    boolean expResult = false;
    boolean result = instance.isFull();
    assertEquals(expResult, result);
  }

  /**
   * Test of run method, of class Angkot.
   */
  @org.junit.Test
  public void testRun() {
    System.out.println("run");
    Angkot instance = new Angkot(2F, 3F);
    instance.run();
  }

  /**
   * Test of paintComponent method, of class Angkot.
   */
  @org.junit.Test
  public void testPaintComponent() {
    System.out.println("paintComponent");
    Graphics g = null;
    Angkot instance = new Angkot(2F, 3F);
    instance.paintComponent(g);
  }
  
}
