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

    // Create terminal 1 (ntar d taronya d kelas terminal)
    JLabel terminal2 = new JLabel("Terminal 2");
    terminal2.setOpaque(true);
    terminal2.setBackground(Color.green);
    terminal2.setBounds(1200, 20, 100, 50);
    
    JLabel terminal3 = new JLabel("Terminal 3");
    terminal3.setOpaque(true);
    terminal3.setBackground(Color.pink);
    terminal3.setBounds(1200, 600, 100, 50);
    
    /* JLabel bottom = new JLabel();
    bottom.setBackground(Color.black);
    bottom.setBounds(60, 60, 50, 50); */
    
    // Background
    try {
        this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("img/bg.png")))));
    } catch (IOException e) {
    };
//    Background background = new Background();
//    background.setBounds(0,0,1366,730);
//    lp.add(background,new Integer(0));    

    Angkot a1 = new Angkot();
    a1.setBounds(0, 0, 1366, 730);
    Terminal terminal1 = new Terminal();
    //JLabel terminal1 = new JLabel("Terminal 1");
    //terminal1.setOpaque(true);
    //terminal1.setBackground(Color.red);
    terminal1.setBounds(20, 20, 100, 50);
    
    // Place the buttons in different layers
    lp.add(a1, new Integer(1));
    lp.add(terminal1, new Integer(2));
    lp.add(terminal2, new Integer(3));
    lp.add(terminal3, new Integer(4));
    
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