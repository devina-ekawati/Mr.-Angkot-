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
  // Konstruktor
  public AngkotStop() {
    name = "Halte";
    x = 0;
    y = 0;
    side = "left";
    passengers = new LinkedList<Passenger>();
  }
  
  public AngkotStop(String _name, float _x, float _y) {
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
  
  // Fungsi- fungsi lainnya
  @Override
  public boolean isEmpty() {
    return passengers.isEmpty();
  }
  
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
    graphics.drawString(side + passengers.size() + " penumpang", (int) x, (int) y);
    super.paintComponent(graphics);
  }
  
  /** Menghasilkan reaksi terhadap event yang terjadi
   *
   *  
   *  @param angkotEmptySpace Sisa kursi kosong di angkot yang dapat ditempati penumpang
   *  @return Sisa kursi kosong di angkot setelah penumpang naik ke angkot
  */
  @Override
  public void reactOnEvent(Angkot angkot) {
    // Menaikkan penumpang ke angkot
//    int i = 0;
//    while ((!passengers.isEmpty()) && (i<=angkotEmptySpace)) {
//      passengers.remove();
//      i++;
//    }
    try {
      Class c = angkot.getClass();
      Method getCountPassengers = c.getMethod("getCountPassengers");
      Method remove = c.getMethod("remove",null);
      Random randGetOff = new Random();
      int countPassengersGetOff = randGetOff.nextInt((int) getCountPassengers.invoke(angkot));
      for (int i = 0; i < countPassengersGetOff; i++) {
        remove.invoke(angkot);
      side = "oke" + countPassengersGetOff + i;
      }
      
      Method getEmptySpace = c.getMethod("getEmptySpace");
      Method add = c.getMethod("add", Passenger.class);
      Random randGetOn = new Random();
      int countPassengersGetOn;
      if ((int) getEmptySpace.invoke(angkot) < passengers.size()) {
        countPassengersGetOn = randGetOn.nextInt((int) getEmptySpace.invoke(angkot));
      }
      else {
        countPassengersGetOn = randGetOn.nextInt(passengers.size());
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
//    // Menurunkan penumpang dari angkot
//    for (i=0; i<countPassengersGetOff; i++) {
//      //passengers.add()
//    }
    

//    // Menurunkan penumpang dari angkot
//    for (i=0; i<countPassengersGetOff; i++) {
//      //passengers.add()
//    }
  }
}
