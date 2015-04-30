/**
 ************************************************************************
 *  File ini berisi deklarasi dan implementasi seluruh prototipe 
 *  kelas Terminal dan seluruh makro, konstanta, 
 *  ataupun variabel global yang dibutuhkan
 *
 *  @author Irene Wiliudarsan (13513002)
 *  @author Angela Lynn       (13513032)
 *  @author Devina Ekawati    (13513088)
 *  @since  April 29st, 2015
 ************************************************************************
 */
package mr.angkot;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/** @class Terminal
 *  @brief Kelas yang menampung sebuah objek terminal yang mengimplementasikan interface StoppingPlace
 */
public class Terminal extends JComponent implements StoppingPlace, Runnable {
  // Atribut
  private String name; //< Nama terminal
  private JLabel countPassengersLabel;
  private float x; //< Posisi absis terminal
  private float y; //< Posisi ordinat terminal
  private String side; //< Posisi terminal pada jalan, bernilai "left" jika berada di kiri jalan dan bernilai "right" jika berada di kanan jalan
  private Queue<Passenger> passengers; //< Menampung penumpang yang ingin menaiki angkot

  // Method
  /** Konstruktor Default
   *
   *  Menghidupkan terminal dengan nama default "Terminal",
   *  posisi di titik 0, dan berada di sisi kiri jalan
   *  Acuan posisi titik ke-0 berada di titik di mana angkot berangkat
   */
  public Terminal() {
    name = "Terminal";
    x = 20;
    y = 20;
    side = "left";
    passengers = new LinkedList<Passenger>();
  }
  
  /** Konstruktor dengan parameter
   *
   *  
   */
  public Terminal (String _name, float _x, float _y) {
    name = _name;
    x = _x;
    y = _y;
    side = "left";
    passengers = new LinkedList<Passenger>();
  }
  
  /** 
   * Getter nama halte
  */
  @Override
  public String getName() {
    return name;
  }
  
  /** 
   * Getter posisi x halte
  */
  @Override
  public float getXPosition() {
    return x;
  }
  
  /** 
   * Getter posisi y halte
  */
  @Override
  public float getYPosition() {
    return y;
  }
  
  /** 
   * Getter jumlah passengers di halte
  */
  @Override
  public String getCountPassengers() {
    return passengers.size() + " penumpang";
  }
  
  /** 
   * Setter nama halte
  */
  @Override
  public void setName(String _name) {
    name = _name;
  }
  
  /** 
   * Setter posisi x halte
  */
  @Override
  public void setXPosition(float _x) {
    x = _x;
  }
  
  /** 
   * Setter posisi y halte
  */
  @Override
  public void setYPosition(float _y) {
    y = _y;
  }
  
  /** 
   * Menambah Passsengers di dalam halte
  */
  @Override
  public void addPassengers(Passenger _passenger) {
    passengers.add(_passenger);
  }
  
  /** 
   * Mengurangi Passsengers di dalam halte
  */
  @Override
  public void removePassengers() {
    passengers.remove();
  }
  
  // Fungsi-fungsi lainnya
  @Override
  public boolean isEmpty() {
    return passengers.isEmpty();
  }
  
  public void run() {
    Thread producedPassengersThread = new Thread(new Runnable() {
      public void run() {
        while (true) {
          //if (passengers.size() <= 14) {
            Random rand = new Random(); 
            int countPassengers = 14;
            for (int i = 0; i < countPassengers; i++) {
              addPassengers(new Passenger());
            }
            int delay = rand.nextInt(5000) + 10;
            try {
              TimeUnit.MILLISECONDS.sleep(delay);
            } catch (InterruptedException ex) {
              Logger.getLogger(Angkot.class.getName()).log(Level.SEVERE, null, ex);
            }
          //}
        }
      }
    });
    producedPassengersThread.start();
  }
  
  @Override
  public void paintComponent (Graphics graphics) {
    graphics.setFont(new Font("TimesRoman", Font.BOLD, 16));
    graphics.setColor(Color.white);
    
    graphics.drawString(passengers.size() + " penumpang" + " " + side, (int) x, (int) y);
    super.paintComponent(graphics);
    graphics.drawString("test",0,0);
    super.paintComponent(graphics);
  }
  
  /** Menurunkan seluruh penumpang saat angkot berhenti di terminal
   *
   *  @param angkotFilledSpace Sisa kursi kosong di angkot yang dapat ditempati penumpang
   *  @return Sisa kursi kosong di angkot setelah penumpang naik ke angkot
   * 
  */
  @Override
  public void reactOnEvent(Angkot angkot) {
    try {
      Class c = angkot.getClass();
      Method getCountPassengers = c.getMethod("getCountPassengers");
      Method clearAll = c.getMethod("clearAll");
      // Penumpang turun ke terminal
      int countPassengersGetOff = (int) getCountPassengers.invoke(angkot);
      clearAll.invoke(angkot);
      
      Method add = c.getMethod("add", Passenger.class);
      Method isFull = c.getMethod("isFull");
      // Penumpang naik ke angkot
      int countPassengersGetOn = 14;
      if ((boolean) isFull.invoke(angkot)) {
      } else {
        for (int i = 0; i < countPassengersGetOn; i++) {
          add.invoke(angkot, passengers.element());
          passengers.remove();
        }
      }
    } catch (SecurityException | NoSuchMethodException exp) {
    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
        Logger.getLogger(AngkotStop.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}