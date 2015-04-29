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

import java.awt.Color;
import java.util.*;
import javax.swing.*;

/** @class Terminal
 *  @brief Kelas yang menampung sebuah objek terminal yang mengimplementasikan interface StoppingPlace
 */
public class Terminal extends JComponent implements StoppingPlace {
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
    passengers = new LinkedList<Passenger>();
    countPassengersLabel = new JLabel (passengers.size() + "penumpang");
    countPassengersLabel.setOpaque(true);
    countPassengersLabel.setBackground(Color.red);
    countPassengersLabel.setBounds((int) x, (int) y, 100, 50);
    x = 20;
    y = 20;
    side = "left";
  }
  
  public Terminal (String _name, float _x, float _y) {
    name = _name;
    x = _x;
    y = _y;
    passengers = new LinkedList<Passenger>();
    countPassengersLabel = new JLabel (passengers.size() + "orang");
    countPassengersLabel.setOpaque(true);
    countPassengersLabel.setBackground(Color.red);
    countPassengersLabel.setBounds((int) x, (int) y, 100, 50);
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
  
  // Fungsi-fungsi lainnya
  @Override
  public boolean isEmpty() {
    return passengers.isEmpty();
  }
  
  /** Menurunkan seluruh penumpang saat angkot berhenti di terminal
   *
   *  @param angkotFilledSpace Sisa kursi kosong di angkot yang dapat ditempati penumpang
   *  @return Sisa kursi kosong di angkot setelah penumpang naik ke angkot
   * 
  */
  //@Override
  public void reactOnEvent(ArrayList<Passenger> angkotPassengers) {
    for (Passenger passengerTemp: angkotPassengers) {
      passengers.add(passengerTemp);
    }
    angkotPassengers.clear();
  }
}