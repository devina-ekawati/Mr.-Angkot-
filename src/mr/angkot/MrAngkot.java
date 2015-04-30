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

/** @class MrAngkot
 *  Kelas yang merupakan program utama dari aplikasi Mr. Angkot!
 *  Kelas ini menurunkan kelas JFrame yang akan menampilkan UserInterface
 */
public class MrAngkot extends JFrame {
  /**Program utama
   * 
   * Membentuk sebuah objek dari kelas UserInterface
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    UserInterface sl = new UserInterface();
    sl.setVisible(true);
  }
}