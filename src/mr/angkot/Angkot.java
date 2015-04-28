package mr.angkot;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.*;
import javax.swing.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Devina
 */
public class Angkot extends JComponent {
  private ArrayList passengers;
  private int capacity;
  private String color;
  private int x;
  private int y;
  
  public Angkot() {
    setLayout(null);
    passengers = new ArrayList();
    capacity = 14;
    color = "Yellow";
    x = 100;
    y = 120;
  }
  
  public Angkot(int _x, int _y) {
    setLayout(null);
    passengers = new ArrayList();
    capacity = 14;
    color = "Yellow";
    x = _x;
    y = _y;
  }
  
  public void move(boolean inX, boolean inY, boolean upRight) {
    if (inX & upRight) {  // angkot di sisi atas
     x += 50;
    }
    else if (inY & upRight) { // angkot di sisi kanan
      y += 50;
    }
    else if (inX & !upRight) {  // angkot di sisi bawah
      x -= 50;
    }
    else if (inY & !upRight) {  // angkot di sisi kiri
      y -= 50;
    }
    repaint();
  }
  
  public boolean isEmpty() {
    return passengers.isEmpty();
  }
  
  public boolean isFull() {
    return (passengers.size() == 14);
  }
  
  @Override
  public void paintComponent (Graphics g) {
    Graphics2D g2d = (Graphics2D) g.create();
    boolean inX, inY, upRight;
    
    super.paintComponent(g2d);
    if (((x >= 1150) && (y <= 500)) || ((x < 150) && (y > 120))) {
      // Angkot di sisi kiri atau sisi kanan
      AffineTransform transform = new AffineTransform();
      transform.rotate(Math.PI/2, x + 100/2, y + 50/2);
      AffineTransform old = g2d.getTransform();
      g2d.transform(transform);
      g2d.setColor(Color.BLUE);
      g2d.fillRect (x, y, 100, 50);
      g2d.setTransform(old);
      inX = false;
      inY = true;
      if ((x >= 1150) && (y <= 500)) {  // Angkot di sisi kanan
        upRight = true;
      }
      else {
        upRight = false;
      }
    }
    else {  // Angkot di sisi atas atau sisi bawah
      g2d.setColor(Color.BLUE);
      g2d.fillRect (x, y, 100, 50);
      inX = true;
      inY = false;
      if ((x >= 150) && (y > 500)) {  // Angkot di sisi bawah
        upRight = false;
      }
      else {
        upRight = true;
      }
    }
    
    try {
      TimeUnit.MILLISECONDS.sleep(500);
    } catch (InterruptedException ex) {
      Logger.getLogger(Angkot.class.getName()).log(Level.SEVERE, null, ex);
    }
    move(inX, inY, upRight);
  } 
}