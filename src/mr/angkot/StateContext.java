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

   /**
    * Konstruktor
    */
  public StateContext(Angkot angkot, ArrayList<Terminal> listOfTerminal) {
    currentState = new MoveState(angkot, listOfTerminal);
  }

  public void setState(StateType state) {
    currentState = state;
  }
  
  public void doAction() {
    currentState.doAction(this);
  }
}