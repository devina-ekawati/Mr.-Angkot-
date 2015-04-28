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
 * @author Windows7
 */
public class Background extends JComponent {
  public Background() {
    setLayout(null);
  }
  
  @Override
  public void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2D) g.create();
    // Trotoar
    g2d.setColor(Color.LIGHT_GRAY);
    g2d.fillRect (0,0,1350,692);
    // Jalan
    g2d.setColor(Color.GRAY);
    g2d.fillRect (90,90,1170,512);
    // Rumput
    g2d.setColor(Color.GREEN);
    g2d.fillRect (210,210,930,272);
  }
}