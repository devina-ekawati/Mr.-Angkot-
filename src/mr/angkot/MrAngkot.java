/**
 ************************************************************************
 *  File ini berisi program utama aplikasi Mr. Angkot!
 *
 *  @author Irene Wiliudarsan (13513002)
 *  @author Angela Lynn       (13513032)
 *  @author Devina Ekawati    (13513088)
 *  @since  April 21st, 2015
 ************************************************************************
 */
package mr.angkot;

import javax.swing.*;
import java.util.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.awt.image.*;
import java.io.*;

/**
 *
 * @author Devina
 */
public class MrAngkot extends JFrame {
  
  public MrAngkot() {
    super("Mr. Angkot!");
    setSize(1366, 730);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    JLayeredPane lp = getLayeredPane();
    
    // Background
//    try {
//        this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("img/bg.png")))));
//    } catch (IOException e) {
//    };
//    Background background = new Background();
//    background.setBounds(0,0,1366,730);
//    lp.add(background,new Integer(0));    

    Terminal terminal1 = new Terminal("Ganesha", 116, 50);
    terminal1.setBounds(20, 20, 1366, 730);
    AngkotStop angkotStop1 = new AngkotStop("Cimedan", 1091, 50);
    angkotStop1.setBounds(20, 20, 1366, 730);
    AngkotStop angkotStop2 = new AngkotStop("Citangerang", 595, 650);
    angkotStop2.setBounds(20, 20, 1366, 730);
    AngkotStop angkotStop3 = new AngkotStop("Cibandung", 20, 100);
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
    
    lp.add(terminal1, new Integer(2));
    lp.add(angkotStop1, new Integer(2));
    lp.add(angkotStop2, new Integer(2));
    lp.add(angkotStop2, new Integer(2));
    lp.setVisible(true);
  }
  
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // TODO code application logic here
    MrAngkot sl = new MrAngkot();
    sl.setVisible(true);
  }
}