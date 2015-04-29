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
  
  public Terminal (String _name, float _x, float _y) {
    name = _name;
    x = _x;
    y = _y;
    side = "left";
    passengers = new LinkedList<Passenger>();
  }
  
  @Override
  public String getName() {
    return name;
  }
  
  @Override
  public float getXPosition() {
    return x;
  }
  
  @Override
  public float getYPosition() {
    return y;
  }
  
  @Override
  public String getCountPassengers() {
    return passengers.size() + " penumpang";
  }
  
  @Override
  public void setName(String _name) {
    name = _name;
  }
  
  @Override
  public void setXPosition(float _x) {
    x = _x;
  }
  
  @Override
  public void setYPosition(float _y) {
    y = _y;
  }
  
  @Override
  public void addPassengers(Passenger _passenger) {
    passengers.add(_passenger);
  }
  
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
          if (passengers.size() < 14) {
            Random rand = new Random(); 
            int countPassengers = rand.nextInt(14) + 14;
            for (int i = 0; i < countPassengers; i++) {
              addPassengers(new Passenger());
            }
            int delay = rand.nextInt(1000) + 100;
            try {
              TimeUnit.MILLISECONDS.sleep(delay);
            } catch (InterruptedException ex) {
              Logger.getLogger(Angkot.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        }
      }
    });
    producedPassengersThread.start();
  }
  
  @Override
  public void paintComponent (Graphics graphics) {
    graphics.setFont(new Font("TimesRoman", Font.BOLD, 16));
    graphics.setColor(Color.white);
    
    graphics.drawString(passengers.size() + " penumpang", (int) x, (int) y);
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
      Method getCountPassengers = c.getMethod("getCountPassengers",null);
      Method remove = c.getMethod("remove",null);
      int countPassengersGetOff = (int) getCountPassengers.invoke(angkot);
      for (int i = 0; i < countPassengersGetOff; i++) {
        remove.invoke(angkot);
      }
      
      Method add = c.getMethod("add", Passenger.class);
      int countPassengersGetOn = 14;
      for (int i = 0; i < countPassengersGetOn; i++) {
        passengers.remove();
        add.invoke(angkot,new Passenger());
      }
    }
    catch (SecurityException | NoSuchMethodException exp) {
    side = "oke ";}
    catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
        Logger.getLogger(AngkotStop.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}