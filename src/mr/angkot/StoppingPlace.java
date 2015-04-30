/**
 ************************************************************************
 *  File ini berisi deklarasi seluruh prototipe 
 *  kelas interface StoppingPlace dan seluruh makro, konstanta, 
 *  ataupun variabel global yang dibutuhkan
 *
 *  @author Irene Wiliudarsan (13513002)
 *  @author Angela Lynn       (13513032)
 *  @author Devina Ekawati    (13513088)
 *  @since  April 29st, 2015
 ************************************************************************
 */
package mr.angkot;

/** @class StoppingPlace
 *  Kelas interface yang menampung sebuah objek tempat pemberhentian.
 *  Tempat pemberhentian dapat berupa terminal maupun halte.
 */
public interface StoppingPlace {
  // Method
  /**Getter Nama
   * 
   * Mengembalikan nama dari tempat pemberhentian
   * @return Nama tempat pemberhentian
   */
  public String getName();
  
  /**Getter absis dari posisi
   * 
   * Mengembalikan nilai absis dari posisi tempat pemberhentian
   * @return Posisi absis tempat pemberhentian
   */
  public float getXPosition();
  
  /**Getter ordinat dari posisi
   * 
   * Mengembalikan nilai ordinat dari posisi tempat pemberhentian
   * @return Posisi absis tempat pemberhentian
   */
  public float getYPosition();
  
  /**Getter String jumlah penumpang
   * 
   * Mengembalikan jumlah penumpang dan kata " penumpang" yang terdapat 
   * di tempat pemberhentian   
   * @return Jumlah penumpang yang digabung dengan kata " penumpang"
   */
  public String getCountPassengers();
  
  /**Setter nama tempat pemberhentian
   * 
   * Mengubah nama tempat pemberhentian menjadi _name
   * @param _name Nama tempat pemberhentian yang baru
   */
  public void setName(String _name);
  
  /**Setter posisi absis tempat pemberhentian
   * 
   * Mengubah posisi absis tempat pemberhentian menjadi _x
   * @param _x Posisi absis tempat pemberhentian yang baru
   */
  public void setXPosition(float _x);
  
  /**Setter posisi ordinat tempat pemberhentian
   * 
   * Mengubah posisi ordinat tempat pemberhentian menjadi _x
   * @param _y Posisi ordinat tempat pemberhentian yang baru
   */
  public void setYPosition(float _y);
  
  /**Menambah penumpang ke antrian tempat pemberhentian
   * 
   * Menambah penumpang yang bertipe Passenger ke dalam antrian penumpang 
   * di tempat pemberhentian
   * @param _passenger Penumpang yang akan dimasukkan ke antrian
   */
  public void addPassengers(Passenger _passenger);
  
  /**Menghapus penumpang dari antrian tempat pemberhentian
   * 
   * Menghapus penumpang yang bertipe Passenger dari antrian penumpang di tempat pemberhentian
   */
  public void removePassengers();
  
  /**Memeriksa apakah tempat pemberhentian dalam kondisi kosong
   * 
   * @return true jika antrian penumpang dalam kondisi kosong 
   * dan false jika antrian penumpang dalam kondisi terisi
   */
  public boolean isEmpty();
  
  /** Menghasilkan reaksi terhadap event yang terjadi
   *  @param angkot Angkot yang akan bereaksi saat suatu event dilakukan
  */
  public void reactOnEvent(Angkot angkot);
}