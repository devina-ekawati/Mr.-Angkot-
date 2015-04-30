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
  * Menciptakan objek angkot dengan nilai capacity = 14, x = 100, y = 120
  * @param _stoppingPlaces merupakan list dari seluruh tempat pemberhentian
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
  * Menciptakan objek angkot dengan nilai capacity = 14, rray list passengers dan stoppingPlaces kosong
  * @param _x merupakan posisi koordinat x angkot
  * @param _y merupakan posisi koordinat y angkot
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
  * Memperoleh jumlah passengers di dalam angkot
  * @return jumlah passengers di dalam angkot
  */
  public int getCountPassengers() {
    return passengers.size();
  }
  
  /**
  * Getter jumlah tempat kosong di dalam angkot
  * Memperoleh jumlah tempat yang masih tersisa di dalam angkot
  * @return jumlah tempat yang tersisa di dalam angkot
  */
  public int getEmptySpace() {
    return capacity - getCountPassengers();
  }
  
  /**
  * Getter posisi x angkot
  * Memperoleh posisi koordinat x angkot
  * @return posisi koordinat x angkot
  */
  public float getXPosition() {
    return x;
  }
  
  /**
  * Getter posisi y angkot
  * Memperoleh posisi koordinat y angkot
  * @return posisi koordinat y angkot
  */
  public float getYPosition() {
    return y;
  }
  
  /**
  * Setter posisi x angkot
  * Mengganti nilai x angkot dengan _x
  * @param _x merupakan posisi yang akan menggantikan posisi x angkot sekarang
  */
  public void setX(float _x) {
    x = _x;
  }
  
  /**
  * Setter posisi y angkot
  * Mengganti nilai y angkot dengan _x
  * @param _y merupakan posisi yang akan menggantikan posisi y angkot sekarang
  */
  public void setY(float _y) {
    y = _y;
  }
  
  /**
  * Menambah jumlah penumpang ke dalam angkot
  * Menambah passnger ke dalam angkot ke dalam array list passengers
  * @param passenger passenger yang ditambahkan ke dalam angkot
  */
  public void add(Passenger passenger) {
    passengers.add(passenger);
  }
  
  /**
  * Mengurangi jumlah penumpang dari dalam angkot
  * Menghapus passenger pada index tertentu dalam array list
  * @param index merupakan index array list
  */
  public void clear(int index) {
    passengers.remove(index);
  }
  
  /**
  * Mengurangi jumlah seluruh penumpang dari dalam angkot
  * Menghapus seluruh passenger dari array list passengers
  */
  public void clearAll() {
    passengers.clear();
  }
  
  /**
  * Mengecek apaakah angkot masih kosong atau tidak
  * Angkot kosong jika array list passengers kosong
  * @return true jika angkot kosong dan false jika tidak
  */
  public boolean isEmpty() {
    return passengers.isEmpty();
  }
  
  /**
  * Mengecek apaakah angkot sudah penuh atau tidak
  * Angkot penuh jika ukuran array list sama dengan kapasitas angkot
  * @return true jika angkot penuh dan false jika tidak 
  */
  public boolean isFull() {
    return (passengers.size() == capacity);
  }
  
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