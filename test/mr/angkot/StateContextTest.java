/*
 * @author Irene Wiliudarsan	(13513002)
 * @author Angela Lynn		(13513032)
 * @author Devina Ekawati	(13513088)
 * @bug Tidak ada bug ditemukan
 */  

package mr.angkot;

import java.util.ArrayList;
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


public class StateContextTest {
  
  public StateContextTest() {
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
   * Test of setState method, of class StateContext.
   */
  @Test
  public void testSetState() {
    System.out.println("setState");
    ArrayList<StoppingPlace> stoppingPlaces = new ArrayList<StoppingPlace>();
    Angkot angkot = new Angkot(stoppingPlaces);
    StateType state = new StopAtTerminalState(angkot);
    StateContext instance = new StateContext(angkot,stoppingPlaces);
    instance.setState(state);
  }

  /**
   * Test of doAction method, of class StateContext.
   */
  @Test
  public void testDoAction() {
    System.out.println("doAction");
    ArrayList<StoppingPlace> stoppingPlaces = new ArrayList<StoppingPlace>();
    Angkot angkot = new Angkot(stoppingPlaces);
    StateContext instance = new StateContext(angkot, stoppingPlaces);
    instance.doAction(stoppingPlaces);
  }
  
}
