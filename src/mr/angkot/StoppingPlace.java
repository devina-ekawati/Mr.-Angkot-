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
 *  @brief Kelas interface yang menampung sebuah objek tempat pemberhentian
 */
public interface StoppingPlace {
  // Method
  public boolean isEmpty();
  
  /** Menghasilkan reaksi terhadap event yang terjadi
   *  @param angkotEmptySpace Sisa kursi kosong di angkot yang dapat ditempati penumpang
   *  @return Sisa kursi kosong di angkot setelah penumpang naik ke angkot
  */
  //public int reactOnEvent(int angkotEmptySpace);
}