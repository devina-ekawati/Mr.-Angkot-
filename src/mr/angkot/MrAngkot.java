/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mr.angkot;

import javax.swing.JFrame;

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
    Angkot a = new Angkot();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setBounds(30, 30, 300, 300);
    window.add(a);
    window.setVisible(true);
    
  }
  
}
