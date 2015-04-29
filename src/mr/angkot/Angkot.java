package mr.angkot;

/**
 ************************************************************************
 *  File ini berisi deklarasi dan implementasi seluruh prototipe 
 *  kelas Angkot dan seluruh makro, konstanta, 
 *  ataupun variabel global yang dibutuhkan
 *
 *  @author Irene Wiliudarsan (13513002)
 *  @author Angela Lynn       (13513032)
 *  @author Devina Ekawati    (13513088)
 *  @since  April 21st, 2015
 ************************************************************************
 */

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.*;
import javax.swing.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Devina
 */
public class Angkot extends JComponent {
  private ArrayList passengers;
  private int capacity;
  private String color;
  private float x;
  private float y;
  private StateContext state;
  private ArrayList<StoppingPlace> stoppingPlaces;
  
  public Angkot(ArrayList<StoppingPlace> _stoppingPlaces) {
    setLayout(null);
    passengers = new ArrayList();
    capacity = 14;
    color = "Yellow";
    x = 100;
    y = 120;
    stoppingPlaces = _stoppingPlaces;
    state = new StateContext(this, stoppingPlaces);
  }
  
  public Angkot(float _x, float _y) {
    setLayout(null);
    passengers = new ArrayList();
    capacity = 14;
    color = "Yellow";
    x = _x;
    y = _y;
    state = new StateContext(this, stoppingPlaces);
  }
  
  public int getCountPassenger() {
    return passengers.size();
  }
  
  public float getXPosition() {
    return x;
  }
  
  public float getYPosition() {
    return y;
  }
  
  public void setX(float _x) {
    x = _x;
  }
  
  public void setY(float _y) {
    y = _y;
  }
  
  public boolean isEmpty() {
    return passengers.isEmpty();
  }
  
  public boolean isFull() {
    return (passengers.size() == 14);
  }
  
  
  @Override
  public void paintComponent (Graphics g) {
    Graphics2D g2d = (Graphics2D) g.create();
    
    super.paintComponent(g2d);
    if (((x >= 1150) && (y <= 500)) || ((x < 150) && (y > 120))) {
      // Angkot di sisi kiri atau sisi kanan
      AffineTransform transform = new AffineTransform();
      transform.rotate(Math.PI/2, x + 100/2, y + 50/2);
      AffineTransform old = g2d.getTransform();
      g2d.transform(transform);
      g2d.setColor(Color.YELLOW);
      g2d.fillRect ((int) x, (int) y, 100, 50);
      g2d.setTransform(old);
    }
    else {  // Angkot di sisi atas atau sisi bawah
      g2d.setColor(Color.YELLOW);
      g2d.fillRect ((int) x, (int) y, 100, 50);
    }
    
    try {
      TimeUnit.MILLISECONDS.sleep(100);
    } catch (InterruptedException ex) {
      Logger.getLogger(Angkot.class.getName()).log(Level.SEVERE, null, ex);
    }
    Thread moveThread = new Thread(new Runnable() {
      public void run() {
        state.doAction(stoppingPlaces);
      }
    });
    //moveThread.start();
    moveThread.run();
    //state.doAction(stoppingPlaces);
    repaint();
  } 
}