/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mr.angkot;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Devina
 */
public class MrAngkot extends JFrame {
  
  public MrAngkot() {
    super("Mr. Angkot !");
    setSize(1366, 730);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    JLayeredPane lp = getLayeredPane();

    // Create terminal 1 (ntar d taronya d kelas terminal)
    JLabel terminal1 = new JLabel("Terminal 1");
    terminal1.setOpaque(true);
    terminal1.setBackground(Color.red);
    terminal1.setBounds(20, 20, 100, 50);
    
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
    
    Angkot a1 = new Angkot();
    a1.setBounds(0, 0, 1366, 730);
    
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
