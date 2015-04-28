/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mr.angkot;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.*;
import javax.swing.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Windows7
 */
public class Passenger {
  private boolean available;
  
  public Passenger() {}
  
  public synchronized int getOn() {
    while (!available) {
      try {
        wait();
      }
      catch (InterruptedException exp) {}
    }
    available = false;
    notify();
    return 5;
  }
  
  public synchronized void stay() {
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
