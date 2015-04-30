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


public class TerminalTest {
  
  public TerminalTest() {
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
   * Test of getName method, of class Terminal.
   */
  @Test
  public void testGetName() {
    System.out.println("getName");
    Terminal instance = new Terminal("Terminal Ganesha",45,45);
    String expResult = "Terminal Ganesha";
    String result = instance.getName();
    assertEquals(expResult, result);
  }

  /**
   * Test of getXPosition method, of class Terminal.
   */
  @Test
  public void testGetXPosition() {
    System.out.println("getXPosition");
    Terminal instance = new Terminal();
    float expResult = 20.0f;
    float result = instance.getXPosition();
    assertEquals(expResult, result, 0.0);
  }

  /**
   * Test of getYPosition method, of class Terminal.
   */
  @Test
  public void testGetYPosition() {
    System.out.println("getYPosition");
    Terminal instance = new Terminal("Halte",50,35);
    float expResult = 35.0F;
    float result = instance.getYPosition();
    assertEquals(expResult, result, 0.0);
  }

  /**
   * Test of getCountPassengers method, of class Terminal.
   */
  @Test
  public void testGetCountPassengers() {
    System.out.println("getCountPassengers");
    Terminal instance = new Terminal();
    String expResult = "0 penumpang";
    String result = instance.getCountPassengers();
    assertEquals(expResult, result);
  }

  /**
   * Test of setName method, of class Terminal.
   */
  @Test
  public void testSetName() {
    System.out.println("setName");
    String _name = "Terminal Ganesha";
    Terminal instance = new Terminal();
    instance.setName(_name);
  }

  /**
   * Test of setXPosition method, of class Terminal.
   */
  @Test
  public void testSetXPosition() {
    System.out.println("setXPosition");
    float _x = 45.0f;
    Terminal instance = new Terminal();
    instance.setXPosition(_x);
  }

  /**
   * Test of setYPosition method, of class Terminal.
   */
  @Test
  public void testSetYPosition() {
    System.out.println("setYPosition");
    float _y = 20.0F;
    Terminal instance = new Terminal();
    instance.setYPosition(_y);
  }

  /**
   * Test of addPassengers method, of class Terminal.
   */
  @Test
  public void testAddPassengers() {
    System.out.println("addPassengers");
    Passenger _passenger = new Passenger();
    Terminal instance = new Terminal();
    instance.addPassengers(_passenger);
  }

  /**
   * Test of removePassengers method, of class Terminal.
   */
  @Test
  public void testRemovePassengers() {
    System.out.println("removePassengers");
    Terminal instance = new Terminal();
    instance.addPassengers(new Passenger());
    instance.removePassengers();
  }

  /**
   * Test of isEmpty method, of class Terminal.
   */
  @Test
  public void testIsEmpty() {
    System.out.println("isEmpty");
    Terminal instance = new Terminal();
    boolean expResult = true;
    boolean result = instance.isEmpty();
    assertEquals(expResult, result);
  }

  /**
   * Test of reactOnEvent method, of class Terminal.
   */
  @Test
  public void testReactOnEvent() {
    System.out.println("reactOnEvent");
    Angkot angkot = new Angkot(new ArrayList<StoppingPlace>());
    Terminal instance = new Terminal();
    for (int i = 0; i < 14; i++) {
      instance.addPassengers(new Passenger());
    }
    instance.reactOnEvent(angkot);
  }

  /**
   * Test of run method, of class Terminal.
   */
  @Test
  public void testRun() {
    System.out.println("run");
    Terminal instance = new Terminal();
    instance.run();
  }
}
