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
    * Konstruktor dengan paramter
    * Menciptakan objek dengan atribut angkot dan stoppingPlaces sesuai dengan parameter
    * @param _angkot dengan status tertentu
    * @param _stoppingPlaces merupakan list tempat pemberhentian
    */
  public StateContext(Angkot angkot, ArrayList<StoppingPlace> _stoppingPlaces) {
    stoppingPlaces = _stoppingPlaces;
    currentState = new MoveState(angkot);
  }
  /**
    * Setter menjadi state tertentu
    * Mengubah state angkot menjadi state sesuai dengan parameter
    * @param state merupakan state yang baru
    */
  public void setState(StateType state) {
    currentState = state;
  }
  
  /**
    * Melakukan aksi terhadap state tertentu
    * Melakukan aksi sesuai dengan state angkot dan tempat pemberhentian angkot,
    * apakah tempat pemberhentian berupa terminal atau halte
    * @param stoppingPlaces merupakan list tempat pemberhentian
    */
  public void doAction(ArrayList<StoppingPlace> stoppingPlaces) {
    currentState.doAction(this, stoppingPlaces);
  }
}