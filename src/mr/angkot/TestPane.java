/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mr.angkot;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Devina
 */
public class TestPane extends JPanel {
  public TestPane() {
    setLayout(new BorderLayout());
    add(new Angkot(10, 10));
    add(new Angkot(50, 50), BorderLayout.SOUTH);
  }
}
