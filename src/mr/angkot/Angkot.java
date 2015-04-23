package mr.angkot;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import javax.swing.JComponent;
import java.awt.Rectangle;
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
    passengers = new ArrayList();
    capacity = 14;
    color = "Yellow";
    x = 10;
    y = 10;
  }
  
  public void move() {
    /*if (x == 110) {
      try {
        TimeUnit.MILLISECONDS.sleep(500);
      } catch (InterruptedException ex) {
        Logger.getLogger(Angkot.class.getName()).log(Level.SEVERE, null, ex);
      }
    }*/
    x += 50;
    repaint();
  }
  
  public boolean isEmpty() {
    return passengers.isEmpty();
  }
  
  public boolean isFull() {
    return (passengers.size() == 14);
  }
  
  @Override
  public void paint (Graphics g) {
    g.setColor(Color.BLUE);
    g.fillRect (x, y, 100, 50);
    
    try {
      TimeUnit.MILLISECONDS.sleep(500);
    } catch (InterruptedException ex) {
      Logger.getLogger(Angkot.class.getName()).log(Level.SEVERE, null, ex);
    }
    move();
  } 
}

