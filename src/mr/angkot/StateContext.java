/**
 ************************************************************************
 *  File ini berisi deklarasi dan implementasi seluruh prototipe 
 *  kelas MoveState dan seluruh makro, konstanta, ataupun 
 *  variabel global yang dibutuhkan
 *
 *  @author Irene Wiliudarsan (13513002)
 *  @author Angela Lynn       (13513032)
 *  @author Devina Ekawati    (13513088)
 *  @since  April 25st, 2015
 ************************************************************************
 */

package mr.angkot;

import java.util.*;
public class StateContext {
  private StateType currentState;
  private ArrayList<StoppingPlace> stoppingPlaces;
   /**
    * Konstruktor
    */
  public StateContext(Angkot angkot, ArrayList<StoppingPlace> _stoppingPlaces) {
    stoppingPlaces = _stoppingPlaces;
    currentState = new StopAtTerminalState(angkot);
  }

  public void setState(StateType state) {
    currentState = state;
  }
  
  public void doAction(ArrayList<StoppingPlace> stoppingPlaces) {
    currentState.doAction(this, stoppingPlaces);
  }
}