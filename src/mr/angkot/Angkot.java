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
 * Konstruktor
 */
public class Angkot extends JComponent implements Runnable {
  // Atribut
  private ArrayList<StoppingPlace> stoppingPlaces;
  private ArrayList<Passenger> passengers;
  private int capacity;
  private float x;
  private float y;
  private StateContext state;
  
  /**
  * Konstruktor dengan parameter
  */
  public Angkot(ArrayList<StoppingPlace> _stoppingPlaces) {
    setLayout(null);
    passengers = new ArrayList<>();
    capacity = 14;
    x = 100;
    y = 120;
    stoppingPlaces = _stoppingPlaces;
    state = new StateContext(this, stoppingPlaces);
  }
  
  /**
  * Konstruktor dengan parameter
  */
  public Angkot(float _x, float _y) {
    setLayout(null);
    passengers = new ArrayList<>();
    capacity = 14;
    x = _x;
    y = _y;
    stoppingPlaces = new ArrayList<>();
    state = new StateContext(this, stoppingPlaces);
  }
  
  /**
  * Getter jumlah passengers
  */
  public int getCountPassengers() {
    return passengers.size();
  }
  
  /**
  * Getter jumlah tempat kosong di dalam angkot
  */
  public int getEmptySpace() {
    return capacity - getCountPassengers();
  }
  
  /**
  * Getter posisi x angkot
  */
  public float getXPosition() {
    return x;
  }
  
  /**
  * Getter posisi y angkot
  */
  public float getYPosition() {
    return y;
  }
  
  /**
  * Setter posisi x angkot
  */
  public void setX(float _x) {
    x = _x;
  }
  
  /**
  * Setter posisi y angkot
  */
  public void setY(float _y) {
    y = _y;
  }
  
  /**
  * Menambah jumlah penumpang ke dalam angkot
  */
  public void add(Passenger passenger) {
    passengers.add(passenger);
  }
  
  /**
  * Mengurangi jumlah penumpang dari dalam angkot
  */
  public void clear(int index) {
    passengers.remove(index);
  }
  
  /**
  * Mengurangi jumlah seluruh penumpang dari dalam angkot
  */
  public void clearAll() {
    passengers.clear();
  }
  
  /**
  * Mengecek apaakah angkot masih kosong atau tidak
  */
  public boolean isEmpty() {
    return passengers.isEmpty();
  }
  
  /**
  * Mengecek apaakah angkot sudah penuh atau tidak
  */
  public boolean isFull() {
    return (passengers.size() == capacity);
  }
  
  /**
  * Override dari runnable untuk menjalankan thread
  */
  @Override
  public void run() {
    try {
      TimeUnit.MILLISECONDS.sleep(500);
    } catch (InterruptedException ex) {
      Logger.getLogger(Angkot.class.getName()).log(Level.SEVERE, null, ex);
    }
    state.doAction(stoppingPlaces);
    repaint();
  }
  
  /**
  * Override dari JComponent untuk menampilkan objek ke layar
  */
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
    g2d.drawString(passengers.size() + " penumpang",x,y);
    run();
  } 
}