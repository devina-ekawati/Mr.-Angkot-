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
public class Angkot extends JComponent implements Runnable {
  private ArrayList passengers;
  private int capacity;
  private String color;
  private float x;
  private float y;
  private StateContext state;
  
  public Angkot() {
    setLayout(null);
    passengers = new ArrayList();
    capacity = 14;
    color = "Yellow";
    x = 100;
    y = 120;
    state = new StateContext(this);
  }
  
  public Angkot(float _x, float _y) {
    setLayout(null);
    passengers = new ArrayList();
    capacity = 14;
    color = "Yellow";
    x = _x;
    y = _y;
    state = new StateContext(this);
  }
  
  public int getCountPassenger() {
    return passengers.size();
  }
  
  public float getXPosition() {
    return x;
  }
  
  public float getYPosition() {
    return y;
  }
  
  public void setX(float _x) {
    x = _x;
  }
  
  public void setY(float _y) {
    y = _y;
  }
  
  public boolean isEmpty() {
    return passengers.isEmpty();
  }
  
  public boolean isFull() {
    return (passengers.size() == 14);
  }
  
  public void run() {
    Passenger passenger = new Passenger();
    for (int i = 0; i < passenger.getOn(); i++) {
      passengers.add(passenger);
    }
  }
  
  @Override
  public void paintComponent (Graphics g) {
    Graphics2D g2d = (Graphics2D) g.create();
    
    super.paintComponent(g2d);
    if (((x >= 1150) && (y <= 500)) || ((x < 150) && (y > 120))) {
      // Angkot di sisi kiri atau sisi kanan
      AffineTransform transform = new AffineTransform();
      transform.rotate(Math.PI/2, x + 100/2, y + 50/2);
      AffineTransform old = g2d.getTransform();
      g2d.transform(transform);
      g2d.setColor(Color.BLUE);
      g2d.fillRect ((int) x, (int) y, 100, 50);
      g2d.setTransform(old);
    }
    else {  // Angkot di sisi atas atau sisi bawah
      g2d.setColor(Color.BLUE);
      g2d.fillRect ((int) x, (int) y, 100, 50);
    }
    
    try {
      TimeUnit.MILLISECONDS.sleep(500);
    } catch (InterruptedException ex) {
      Logger.getLogger(Angkot.class.getName()).log(Level.SEVERE, null, ex);
    }
    state.doAction();
    repaint();
  } 
}