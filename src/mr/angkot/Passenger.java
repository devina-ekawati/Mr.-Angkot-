/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mr.angkot;

/**
 *
 * @author Windows7
 */
public class Passenger {
  private boolean available;
  
  synchronized int getOn(int countPassenger) {
    while (!available) {
      try {
        wait();
      }
      catch (InterruptedException exp) {}
    }
    available = false;
    notify();
    return countPassenger;
  }
  
  synchronized void stay() {
    while (available) {
      try {
        wait();
      }
      catch (InterruptedException exp) {}      
    }
    available = true;
    notify();    
  }
}
