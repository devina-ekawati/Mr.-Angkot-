/**
 ************************************************************************
 *  File ini berisi deklarasi dan implementasi seluruh prototipe 
 *  kelas Passenger dan seluruh makro, konstanta, ataupun 
 *  variabel global yang dibutuhkan
 *
 *  @author Irene Wiliudarsan (13513002)
 *  @author Angela Lynn       (13513032)
 *  @author Devina Ekawati    (13513088)
 *  @since  April 21st, 2015
 ************************************************************************
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
