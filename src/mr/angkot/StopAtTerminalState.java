/**
 ************************************************************************
 *  File ini berisi deklarasi dan implementasi seluruh prototipe 
 *  kelas StopAtTerminalState dan seluruh makro, konstanta, 
 *  ataupun variabel global yang dibutuhkan
 *
 *  @author Irene Wiliudarsan (13513002)
 *  @author Angela Lynn           (13513032)
 *  @author Devina Ekawati      (13513088)
 *  @since  April 21st, 2015
 ************************************************************************
 */

package mr.angkot;

public class StopAtTerminalState implements StateType {
  private float x;
  private float y;
  private Angkot angkot;
  
  /**
    * Konstruktor
    */
  public StopAtTerminalState(float _x, float _y, Angkot _angkot) {
    x = _x;
    y = _y;
    angkot = _angkot;
  }

   /**
    * Melakukan aksi tertentu saat angkot berhenti di terminal
    * 
    * @param stateContext Konteks state
    */
  @Override
  public void doAction(final StateContext stateContext) {
    new Thread(angkot).start();
  }
}