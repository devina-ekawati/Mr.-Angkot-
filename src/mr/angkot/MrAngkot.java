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
public class MrAngkot {
  
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // TODO code application logic here
    JFrame window = new JFrame();
    //window.setLayout(new FlowLayout());
    JPanel pane = new JPanel(new FlowLayout());
    window.add(pane);
    Angkot a = new Angkot();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setBounds(0, 0, 1366, 730);
    
    pane.add(new Background());
    pane.add(a);
    //window.add(new Angkot());
    window.setVisible(true);
  }
  
}
