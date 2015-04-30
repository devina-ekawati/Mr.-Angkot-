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


public class StateTypeTest {
  
  public StateTypeTest() {
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
   * Test of doAction method, of class StateType.
   */
  @Test
  public void testDoAction() {
    System.out.println("doAction");
    ArrayList<StoppingPlace> stoppingPlaces = new ArrayList<StoppingPlace>();
    Angkot angkot = new Angkot(stoppingPlaces);
    StateContext stateContext = new StateContext(angkot,stoppingPlaces);
    StateType instance = new StopAtAngkotStopState(angkot);
    instance.doAction(stateContext, stoppingPlaces);
  }

  public class StateTypeImpl implements StateType {

    public void doAction(StateContext stateContext, ArrayList<StoppingPlace> stoppingPlaces) {
    }
  }
  
}
