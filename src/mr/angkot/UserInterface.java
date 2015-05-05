/**
 ************************************************************************
 *  File ini berisi deklarasi dan implementasi seluruh prototipe 
 *  kelas UserInterface dan seluruh makro, konstanta, 
 *  ataupun variabel global yang dibutuhkan
 *
 *  @author Irene Wiliudarsan (13513002)
 *  @author Angela Lynn       (13513032)
 *  @author Devina Ekawati    (13513088)
 *  @since  April 29th, 2015
 ************************************************************************
 */

package mr.angkot;

import javax.swing.*;
import java.util.*;
import javax.imageio.*;
import java.io.*;

/** @class UserInterface
 *  Kelas yang menampung sebuah objek yang bertanggungjawab atas 
 *  inisialisasi dan tampilan aplikasi
 */
public class UserInterface extends JFrame {
  /**Konstruktor Default
   * 
   * Menghidupkan objek UserInterface yang melakukan menghidupkan angkot,
   * terminal, halte, dan background serta menampilkannya ke layar.
   */
  public UserInterface() {
    super("Mr. Angkot!");
    setSize(1366, 730);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    JLayeredPane lp = getLayeredPane();
    
    // Background
    try {
        this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("img/bg.png")))));
    } catch (IOException e) {
    };  

    Terminal terminal1 = new Terminal("Terminal Ganesha", 116, 50);
    terminal1.setBounds(20, 20, 1366, 730);
    AngkotStop angkotStop1 = new AngkotStop("Halte Cimedan", 1091, 50);
    angkotStop1.setBounds(20, 20, 1366, 730);
    AngkotStop angkotStop2 = new AngkotStop("Halte Citangerang", 595, 650);
    angkotStop2.setBounds(20, 20, 1366, 730);
    AngkotStop angkotStop3 = new AngkotStop("Halte Cibandung", 0, 460);
    angkotStop3.setBounds(20, 20, 1366, 730);
    
    ArrayList<StoppingPlace> stoppingPlaces = new ArrayList<StoppingPlace>();
    stoppingPlaces.add(terminal1);
    stoppingPlaces.add(angkotStop1);
    stoppingPlaces.add(angkotStop2);
    stoppingPlaces.add(angkotStop3);
    
    Angkot a1 = new Angkot(stoppingPlaces);
    a1.setBounds(0, 0, 1366, 730);
    
    // Place the buttons in different layers
    lp.add(a1, new Integer(1));
    new Thread(a1).start();
    lp.add(terminal1, new Integer(2));
    new Thread(terminal1).start();
    lp.add(angkotStop1, new Integer(2));
    new Thread(angkotStop1).start();
    lp.add(angkotStop2, new Integer(2));
    new Thread(angkotStop2).start();
    lp.add(angkotStop3, new Integer(2));
    new Thread(angkotStop3).start();
    lp.setVisible(true);
  }
}
