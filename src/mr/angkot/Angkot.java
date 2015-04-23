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
    x = 10;
    y = 100;
  }
  
  public Angkot(int _x, int _y) {
    setLayout(null);
    passengers = new ArrayList();
    capacity = 14;
    color = "Yellow";
    x = _x;
    y = _y;
  }
  
  public void move(boolean inX, boolean inY) {
    if (inX) {
     x += 50;
    }
    else if (inY) {
      y += 50;
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
    super.paintComponent(g2d);
    g2d.setColor(Color.BLUE);
    g2d.fillRect (x, y, 100, 50);
    
    try {
      TimeUnit.MILLISECONDS.sleep(500);
    } catch (InterruptedException ex) {
      Logger.getLogger(Angkot.class.getName()).log(Level.SEVERE, null, ex);
    }
    boolean inX = true;
    boolean inY = false;
    if ((x >= 1200) && (y <= 500)) {
      g2d.clearRect(x, y, 100, 50);
      AffineTransform transform = new AffineTransform();
      transform.rotate(Math.PI/2, x + 100/2, y + 50/2);
      AffineTransform old = g2d.getTransform();
      g2d.transform(transform);
      g2d.setColor(Color.BLUE);
      g2d.fillRect (x, y, 100, 50);
      g2d.setTransform(old);
      inX = false;
      inY = true;
    }
    move(inX, inY);
  } 
}

