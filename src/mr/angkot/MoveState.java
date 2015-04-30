/**
 ************************************************************************
 *  File ini berisi deklarasi dan implementasi seluruh prototipe 
 *  kelas MoveState dan seluruh makro, konstanta, ataupun 
 *  variabel global yang dibutuhkan
 *
 *  @author Irene Wiliudarsan (13513002)
 *  @author Angela Lynn       (13513032)
 *  @author Devina Ekawati    (13513088)
 *  @since  April 21st, 2015
 ************************************************************************
 */

package mr.angkot;

import java.util.*;

/** @class MoveState
 *  Kelas yang menampung sebuah status saat angkot bergerak. 
 *  Kelas ini mengimplemantasikan kelas interface StateType
 */
public class MoveState implements StateType {
  // Atribut
  private Angkot angkot; //< Angkot yang berada dalam status bergerak
  
   /**Konstruktor dengan parameter
    *   
    * Menghidupkan status MoveState dengan parameter angkot yang berasal
    * dari masukkan pengguna
    */
  public MoveState(Angkot _angkot) {
    angkot = _angkot;
  }
  
   /**Melakukan aksi tertentu saat angkot sedang bergerak
    * 
    * Angkot bergerak dengan arah gerakan sesuai dengan letak angkot.
    * Apabila angkot bertemu dangan sebuah terminal, angkot akan berpindah ke 
    * status StopAtTerminalState. Apabila angkot bertemu dengan sebuah halte,
    * angkot akan berpindah ke status StopAtAngkotStopState
    * 
    * @param stateContext Konteks state
    * @param stoppingPlaces Array yang menampung seluruh tempat pemberhentian yang ada
    */
  @Override
  public void doAction(final StateContext stateContext, ArrayList<StoppingPlace> stoppingPlaces) {
    boolean inX, inY, upRight;
    if (((angkot.getXPosition() >= 1150) && (angkot.getYPosition() <= 500)) || ((angkot.getXPosition() < 150) && (angkot.getYPosition() > 120))) {
      inX = false;
      inY = true;
      if ((angkot.getXPosition() >= 1150) && (angkot.getYPosition() <= 500)) {  // Angkot di sisi kanan
        upRight = true;
      }
      else {
        upRight = false;
      }
    }
    else {
      inX = true;
      inY = false;
      if ((angkot.getXPosition() >= 150) && (angkot.getYPosition() > 500)) {  // Angkot di sisi bawah
        upRight = false;
      }
      else {
        upRight = true;
      }
    }
    
    if (inX && upRight) {  // Angkot di sisi atas
      angkot.setX(angkot.getXPosition()+50);
    }
    else if (inY && upRight) { // Angkot di sisi kanan
      angkot.setY(angkot.getYPosition()+50);
    }
    else if (inX && !upRight) {  // Angkot di sisi bawah
      angkot.setX(angkot.getXPosition()-50);
    }
    else if (inY && !upRight) {  // Angkot di sisi kiri
      angkot.setY(angkot.getYPosition()-50);
    }
    if ((angkot.getXPosition() == 150) && (angkot.getYPosition() == 120)) {
      stateContext.setState(new StopAtTerminalState(angkot));
    }
    else if ((angkot.getXPosition() == 1100) && (angkot.getYPosition() == 120)) {
      stateContext.setState(new StopAtAngkotStopState(angkot));
    }
    else if ((angkot.getXPosition() == 550) && (angkot.getYPosition() == 520)) {
      stateContext.setState(new StopAtAngkotStopState(angkot));
    }
    else if ((angkot.getXPosition() == 100) && (angkot.getYPosition() == 420)) {
      stateContext.setState(new StopAtAngkotStopState(angkot));
    }
  }
}