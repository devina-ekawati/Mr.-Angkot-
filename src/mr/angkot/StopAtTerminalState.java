/**
 ************************************************************************
 *  File ini berisi deklarasi dan implementasi seluruh prototipe 
 *  kelas StopAtTerminalState dan seluruh makro, konstanta, 
 *  ataupun variabel global yang dibutuhkan
 *
 *  @author Irene Wiliudarsan (13513002)
 *  @author Angela Lynn       (13513032)
 *  @author Devina Ekawati    (13513088)
 *  @since  April 21st, 2015
 ************************************************************************
 */

package mr.angkot;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StopAtTerminalState implements StateType {
  private Angkot angkot;
  
  /**
    * Konstruktor dengan parameter
    * Menciptakan objek dengan atribut angkot sesuai dengan parameter
    * @param _angkot yang akan berhenti pada terminal
    */
  public StopAtTerminalState(Angkot _angkot) {
    angkot = _angkot;
  }

   /**
    * Melakukan aksi tertentu saat angkot berhenti di terminal
    * 
    * @param stateContext Konteks state
    */
  @Override
  public void doAction(final StateContext stateContext, ArrayList<StoppingPlace> stoppingPlaces) {
    stoppingPlaces.get(0).reactOnEvent(angkot);
    try {
      TimeUnit.MILLISECONDS.sleep(2000);
    } catch (InterruptedException ex) {
      Logger.getLogger(Angkot.class.getName()).log(Level.SEVERE, null, ex);
    }
    stateContext.setState(new MoveState(angkot));
  }
}