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
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MoveState implements StateType {
  private Angkot angkot;
  
   /**
    * Konstruktor
    */
  public MoveState(Angkot _angkot) {
    angkot = _angkot;
  }
  
   /**
    * Melakukan aksi tertentu saat angkot sedang bergerak
    * 
    * @param stateContext Konteks state
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
//    int i = 0;
//    boolean found = false;
//    StoppingPlace place = stoppingPlaces.get(i);
//    while (!found && i<stoppingPlaces.size()) {
//      place = stoppingPlaces.get(i);
//      float distanceX = (angkot.getXPosition()-place.getXPosition())*(angkot.getXPosition()-place.getXPosition());
//      float distanceY = (angkot.getYPosition()-place.getYPosition())*(angkot.getYPosition()-place.getYPosition());
//      float distance = (float) Math.sqrt(distanceX + distanceY);
//      if (distance < 200) {
//        found = true;
//      } else {
//        i++;
//        
//      }
//    }
//    if (found) {
//      if (place.getName().contains("Terminal")) {
//        stateContext.setState(new StopAtTerminalState(angkot));
//      } else {
//        stateContext.setState(new StopAtAngkotStopState(angkot));
//      }
//      found = false;
//    }
    //if (angkot.getXPosition() > 200) {
//      stateContext.setState(new StopAtTerminalState(angkot.getXPosition(),angkot.getYPosition(),angkot));
    //}
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