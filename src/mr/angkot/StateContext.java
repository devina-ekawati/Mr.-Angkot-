/**
 ************************************************************************
 *  File ini berisi deklarasi dan implementasi seluruh prototipe 
 *  kelas MoveState dan seluruh makro, konstanta, ataupun 
 *  variabel global yang dibutuhkan
 *
 *  @author Irene Wiliudarsan (13513002)
 *  @author Angela Lynn           (13513032)
 *  @author Devina Ekawati      (13513088)
 *  @since  April 25st, 2015
 ************************************************************************
 */

package mr.angkot;

public class StateContext {
  private StateType currentState;

   /**
    * Konstruktor
    */
  public StateContext(Angkot angkot) {
    setState(new MoveState(angkot));
  }

  public void setState(StateType state) {
    currentState = state;
  }
  
  public void doAction() {
    currentState.doAction(this);
  }
}