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

public class MoveState implements StateType {
  private ArrayList<Terminal> listOfTerminal;
  private Angkot angkot;
  
   /**
    * Konstruktor
    */
  public MoveState(Angkot _angkot, ArrayList<Terminal> _listOfTerminal) {
    listOfTerminal = _listOfTerminal;
    angkot = _angkot;
  }
  
   /**
    * Melakukan aksi tertentu saat angkot sedang bergerak
    * 
    * @param stateContext Konteks state
    */
  @Override
  public void doAction(final StateContext stateContext) {
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
    
    if (inX && upRight) {  // angkot di sisi atas
      angkot.setX(angkot.getXPosition()+50);
    }
    else if (inY && upRight) { // angkot di sisi kanan
      angkot.setY(angkot.getYPosition()+50);
    }
    else if (inX && !upRight) {  // angkot di sisi bawah
      angkot.setX(angkot.getXPosition()-50);
    }
    else if (inY && !upRight) {  // angkot di sisi kiri
      angkot.setY(angkot.getYPosition()-50);
    }
    if (angkot.getXPosition() > 200) {
//      stateContext.setState(new StopAtTerminalState(angkot.getXPosition(),angkot.getYPosition(),angkot));
    }
  }
}