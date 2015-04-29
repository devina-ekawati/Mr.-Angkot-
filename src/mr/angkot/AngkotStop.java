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
import java.util.*;
import javax.swing.*;

/** @class AngkotStop
 *  @brief Kelas yang menampung sebuah objek halte yang mengimplementasikan interface StoppingPlace
 */
public class AngkotStop extends JComponent implements StoppingPlace {
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
    name = "Pemberhentian";
    countPassengersLabel = new JLabel (passengers.size() + "penumpang");
    countPassengersLabel.setOpaque(true);
    countPassengersLabel.setBackground(Color.red);
    countPassengersLabel.setBounds((int) x, (int) y, 100, 50);
    x = 0;
    y = 0;
    side = "left";
  }
  
  public AngkotStop(String _name, float _x, float _y) {
    name = _name;
    x = _x;
    y = _y;
    countPassengersLabel = new JLabel (passengers.size() + " orang");
  }

  public float getXPosition() {
    return x;
  }
  
  public float getYPosition() {
    return y;
  }
  
  public String getCountPassengers() {
    return passengers.size() + " penumpang";
  }
   
  public void setXPosition(float _x) {
    x = _x;
  }
  
  public void setYPosition(float _y) {
    y = _y;
  }
  
  public void addPassengers(Passenger _passenger) {
    passengers.add(_passenger);
  }
  
  public void removePassengers() {
    passengers.remove();
  }
  
  // Fungsi- fungsi lainnya
  @Override
  public boolean isEmpty() {
    return passengers.isEmpty();
  }
  
  /** Menghasilkan reaksi terhadap event yang terjadi
   *
   *  
   *  @param angkotEmptySpace Sisa kursi kosong di angkot yang dapat ditempati penumpang
   *  @return Sisa kursi kosong di angkot setelah penumpang naik ke angkot
  */
  //@Override
  public void reactOnEvent(int angkotEmptySpace, int countPassengersGetOff) {
    // Menaikkan penumpang ke angkot
    int i = 0;
    while ((!passengers.isEmpty()) && (i<=angkotEmptySpace)) {
      passengers.remove();
      i++;
    }
    // Menurunkan penumpang dari angkot
    for (i=0; i<countPassengersGetOff; i++) {
      //passengers.add()
    }
  }
}