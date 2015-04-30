/*
 * @author Irene Wiliudarsan	(13513002)
 * @author Angela Lynn		(13513032)
 * @author Devina Ekawati	(13513088)
 * @bug Tidak ada bug ditemukan
 */  

package mr.angkot;

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


public class StoppingPlaceTest {
  
  public StoppingPlaceTest() {
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
   * Test of getName method, of class StoppingPlace.
   */
  @Test
  public void testGetName() {
    System.out.println("getName");
    StoppingPlace instance = new Terminal("Terminal Ganesha",45,45);
    String expResult = "Terminal Ganesha";
    String result = instance.getName();
    assertEquals(expResult, result);
  }

  /**
   * Test of getXPosition method, of class StoppingPlace.
   */
  @Test
  public void testGetXPosition() {
    System.out.println("getXPosition");
    StoppingPlace instance = new Terminal();
    float expResult = 20.0f;
    float result = instance.getXPosition();
    assertEquals(expResult, result, 0.0);
  }

  /**
   * Test of getYPosition method, of class StoppingPlace.
   */
  @Test
  public void testGetYPosition() {
    System.out.println("getYPosition");
    StoppingPlace instance = new AngkotStop("Halte",50,35);
    float expResult = 35.0F;
    float result = instance.getYPosition();
    assertEquals(expResult, result, 0.0);
  }

  /**
   * Test of getCountPassengers method, of class StoppingPlace.
   */
  @Test
  public void testGetCountPassengers() {
    System.out.println("getCountPassengers");
    StoppingPlace instance = new AngkotStop();
    String expResult = "0 penumpang";
    String result = instance.getCountPassengers();
    assertEquals(expResult, result);
  }

  /**
   * Test of setName method, of class StoppingPlace.
   */
  @Test
  public void testSetName() {
    System.out.println("setName");
    String _name = "Terminal Ganesha";
    StoppingPlace instance = new Terminal();
    instance.setName(_name);
  }

  /**
   * Test of setXPosition method, of class StoppingPlace.
   */
  @Test
  public void testSetXPosition() {
    System.out.println("setXPosition");
    float _x = 45.0f;
    StoppingPlace instance = new AngkotStop();
    instance.setXPosition(_x);
  }

  /**
   * Test of setYPosition method, of class StoppingPlace.
   */
  @Test
  public void testSetYPosition() {
    System.out.println("setYPosition");
    float _y = 20.0F;
    StoppingPlace instance = new AngkotStop();
    instance.setYPosition(_y);
  }

  /**
   * Test of addPassengers method, of class StoppingPlace.
   */
  @Test
  public void testAddPassengers() {
    System.out.println("addPassengers");
    Passenger _passenger = new Passenger();
    StoppingPlace instance = new AngkotStop();
    instance.addPassengers(_passenger);
  }

  /**
   * Test of removePassengers method, of class StoppingPlace.
   */
  @Test
  public void testRemovePassengers() {
    System.out.println("removePassengers");
    StoppingPlace instance = new Terminal();
    instance.addPassengers(new Passenger());
    instance.removePassengers();
  }

  /**
   * Test of isEmpty method, of class StoppingPlace.
   */
  @Test
  public void testIsEmpty() {
    System.out.println("isEmpty");
    StoppingPlace instance = new Terminal();
    boolean expResult = true;
    boolean result = instance.isEmpty();
    assertEquals(expResult, result);
  }

  /**
   * Test of reactOnEvent method, of class StoppingPlace.
   */
  @Test
  public void testReactOnEvent() {
    System.out.println("reactOnEvent");
    Angkot angkot = new Angkot(new ArrayList<StoppingPlace>());
    StoppingPlace instance = new Terminal();
    try {
      instance.reactOnEvent(angkot);
    }
    catch (NoSuchElementException exp) {}
  }

  public class StoppingPlaceImpl implements StoppingPlace {

    public String getName() {
      return "";
    }

    public float getXPosition() {
      return 0.0F;
    }

    public float getYPosition() {
      return 0.0F;
    }

    public String getCountPassengers() {
      return "";
    }

    public void setName(String _name) {
    }

    public void setXPosition(float _x) {
    }

    public void setYPosition(float _y) {
    }

    public void addPassengers(Passenger _passenger) {
    }

    public void removePassengers() {
    }

    public boolean isEmpty() {
      return false;
    }

    public void reactOnEvent(Angkot angkot) {
    }
  }
  
}
