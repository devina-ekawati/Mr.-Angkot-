/**
 ************************************************************************
 *  File ini berisi deklarasi dan implementasi seluruh prototipe 
 *  kelas AngkotStop dan seluruh makro, konstanta, 
 *  ataupun variabel global yang dibutuhkan
 *
 *  @author Irene Wiliudarsan (13513002)
 *  @author Angela Lynn       (13513032)
 *  @author Devina Ekawati    (13513088)
 *  @since  April 29th, 2015
 ************************************************************************
 */
package mr.angkot;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.lang.reflect.Method;

/** @class AngkotStop
 *  @brief Kelas yang menampung sebuah objek halte yang mengimplementasikan interface StoppingPlace
 */
public class AngkotStop extends JComponent implements StoppingPlace, Runnable {
  // Atribut
  private String name; //< Nama halte
  private JLabel countPassengersLabel;
  private float x; //< Posisi absis halte
  private float y;  //< Posisi ordinat halte
  private String side; //< Posisi halte pada jalan, bernilai "left" jika berada di kiri jalan dan bernilai "right" jika berada di kanan jalan
  private Queue<Passenger> passengers; //< Menampung penumpang yang ingin menaiki angkot

  // Method
  /** 
   * Konstruktor
  */
  public AngkotStop() {
    name = "Halte";
    x = 0;
    y = 0;
    side = "left";
    passengers = new LinkedList<Passenger>();
  }
  
  /** 
   * Konstruktor
   * @param _name Nama halte
   * @param _x Posisi x halte
   * @param _y Posisi y halte
  */
  public AngkotStop(String _name, float _x, float _y) {
    name = _name;
    x = _x;
    y = _y;
    side = "left";
    passengers = new LinkedList<Passenger>();
  }

  /** 
   * Getter nama halte
   * @return Nama halte
  */
  @Override
  public String getName() {
    return name;
  }
  
  /** 
   * Getter posisi x halte
   * @return Posisi x halte
  */
  @Override
  public float getXPosition() {
    return x;
  }
  
  /** 
   * Getter posisi y halte
   * @return Posisi y halte
  */
  @Override
  public float getYPosition() {
    return y;
  }
  
  /** 
   * Getter jumlah passengers di halte
   * @return Jumlah penumpang di halte
  */
  @Override
  public String getCountPassengers() {
    return passengers.size() + " penumpang";
  }
   
  /** 
   * Setter nama halte
   * @param _name Nama halte
  */
  @Override
  public void setName(String _name) {
    name = _name;
  }
  
  /** 
   * Setter posisi x halte
   * @param _x Posisi x halte
  */
  @Override
  public void setXPosition(float _x) {
    x = _x;
  }
  
  /** 
   * Setter posisi y halte
   * @param _y Posisi y halte
  */
  @Override
  public void setYPosition(float _y) {
    y = _y;
  }
  
  /** 
   * Menambah Passsengers di dalam halte
   * @param _passenger Menambah penumpang di dalam halte
  */
  @Override
  public void addPassengers(Passenger _passenger) {
    passengers.add(_passenger);
  }
  
  /** 
   * Mengurangi Passengers di dalam halte
  */
  @Override
  public void removePassengers() {
    passengers.remove();
  }
  
  // Fungsi- fungsi lainnya
  /** 
   * Mengecek apakah halte masih kosong
   * @return True apabila halte kosong
  */
  @Override
  public boolean isEmpty() {
    return passengers.isEmpty();
  }
  
  @Override
  public void run() {
    Thread producedPassengersThread = new Thread(new Runnable() {
      public void run() {
        while (true) {
        Random rand = new Random(); 
        int countPassengers = rand.nextInt(2);
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
  
  /** Menghasilkan reaksi terhadap event yang terjadi
   *  @param angkot Angkot
  */
  @Override
  public void reactOnEvent(Angkot angkot) {
    try {
      Class c = angkot.getClass();
      Method getCountPassengers = c.getMethod("getCountPassengers");
      Method clear = c.getMethod("clear",Integer.TYPE);
      Random randGetOff = new Random();
      int countPassengersGetOff;
      if ((int) getCountPassengers.invoke(angkot) != 0) {
        countPassengersGetOff = randGetOff.nextInt((int) getCountPassengers.invoke(angkot));
      }
      else {
        countPassengersGetOff = 0;
      }
      for (int i = 0; i < countPassengersGetOff; i++) {
        clear.invoke(angkot,(int) getCountPassengers.invoke(angkot) - 1);
      }
      
      Method getEmptySpace = c.getMethod("getEmptySpace");
      Method add = c.getMethod("add", Passenger.class);
      Random randGetOn = new Random();
      int countPassengersGetOn;
      if (((int) getEmptySpace.invoke(angkot) > 0) && (passengers.size() > 0)) {
        if ((int) getEmptySpace.invoke(angkot) < passengers.size()) {
          countPassengersGetOn = randGetOn.nextInt((int) getEmptySpace.invoke(angkot));
        }
        else {
          countPassengersGetOn = randGetOn.nextInt(passengers.size());
        }
      }
      else {
        countPassengersGetOn = 0;
      }
      for (int i = 0; i < countPassengersGetOn; i++) {
        passengers.remove();
        add.invoke(angkot,new Passenger());
      }
    }
    catch (SecurityException | NoSuchMethodException exp) {}
    catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
        Logger.getLogger(AngkotStop.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
