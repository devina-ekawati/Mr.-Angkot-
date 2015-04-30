/*
 * @author Irene Wiliudarsan	(13513002)
 * @author Angela Lynn		(13513032)
 * @author Devina Ekawati	(13513088)
 * @bug Tidak ada bug ditemukan
 */  

package mr.angkot;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.NoSuchElementException;
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


public class AngkotStopTest {
  
  public AngkotStopTest() {
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
   * Test of getName method, of class AngkotStop.
   */
  @Test
  public void testGetName() {
    System.out.println("getName");
    AngkotStop instance = new AngkotStop("Terminal Ganesha",45,45);
    String expResult = "Terminal Ganesha";
    String result = instance.getName();
    assertEquals(expResult, result);
  }

  /**
   * Test of getXPosition method, of class AngkotStop.
   */
  @Test
  public void testGetXPosition() {
    System.out.println("getXPosition");
    AngkotStop instance = new AngkotStop();
    float expResult = 0.0f;
    float result = instance.getXPosition();
    assertEquals(expResult, result, 0.0);
  }

  /**
   * Test of getYPosition method, of class AngkotStop.
   */
  @Test
  public void testGetYPosition() {
    System.out.println("getYPosition");
    AngkotStop instance = new AngkotStop("Halte",50,35);
    float expResult = 35.0F;
    float result = instance.getYPosition();
    assertEquals(expResult, result, 0.0);
  }

  /**
   * Test of getCountPassengers method, of class AngkotStop.
   */
  @Test
  public void testGetCountPassengers() {
    System.out.println("getCountPassengers");
    AngkotStop instance = new AngkotStop();
    String expResult = "0 penumpang";
    String result = instance.getCountPassengers();
    assertEquals(expResult, result);
  }

  /**
   * Test of setName method, of class AngkotStop.
   */
  @Test
  public void testSetName() {
    System.out.println("setName");
    String _name = "Terminal Ganesha";
    AngkotStop instance = new AngkotStop();
    instance.setName(_name);
  }

  /**
   * Test of setXPosition method, of class AngkotStop.
   */
  @Test
  public void testSetXPosition() {
    System.out.println("setXPosition");
    float _x = 45.0f;
    AngkotStop instance = new AngkotStop();
    instance.setXPosition(_x);
  }

  /**
   * Test of setYPosition method, of class AngkotStop.
   */
  @Test
  public void testSetYPosition() {
    System.out.println("setYPosition");
    float _y = 20.0F;
    AngkotStop instance = new AngkotStop();
    instance.setYPosition(_y);
  }

  /**
   * Test of addPassengers method, of class AngkotStop.
   */
  @Test
  public void testAddPassengers() {
    System.out.println("addPassengers");
    Passenger _passenger = new Passenger();
    AngkotStop instance = new AngkotStop();
    instance.addPassengers(_passenger);
  }

  /**
   * Test of removePassengers method, of class AngkotStop.
   */
  @Test
  public void testRemovePassengers() {
    System.out.println("removePassengers");
    AngkotStop instance = new AngkotStop();
    instance.addPassengers(new Passenger());
    instance.removePassengers();
  }

  /**
   * Test of isEmpty method, of class AngkotStop.
   */
  @Test
  public void testIsEmpty() {
    System.out.println("isEmpty");
    AngkotStop instance = new AngkotStop();
    boolean expResult = true;
    boolean result = instance.isEmpty();
    assertEquals(expResult, result);
  }

  /**
   * Test of reactOnEvent method, of class AngkotStop.
   */
  @Test
  public void testReactOnEvent() {
    System.out.println("reactOnEvent");
    Angkot angkot = new Angkot(new ArrayList<StoppingPlace>());
    AngkotStop instance = new AngkotStop();
    try {
      instance.reactOnEvent(angkot);
    }
    catch (NoSuchElementException exp) {}
  }

  /**
   * Test of run method, of class AngkotStop.
   */
  @Test
  public void testRun() {
    System.out.println("run");
    AngkotStop instance = new AngkotStop();
    instance.run();
  }
}
