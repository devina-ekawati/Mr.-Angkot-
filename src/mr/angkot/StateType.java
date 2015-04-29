/**
 ************************************************************************
 *  File ini berisi deklarasi seluruh prototipe 
 *  kelasinterface StateType dan seluruh makro, konstanta, ataupun 
 *  variabel global yang dibutuhkan
 *
 *  @author Irene Wiliudarsan (13513002)
 *  @author Angela Lynn       (13513032)
 *  @author Devina Ekawati    (13513088)
 *  @since  April 21st, 2015
 ************************************************************************
 */

package mr.angkot;

public interface StateType {
   /**
    * Interface untuk melakukan aksi tertentu sesuai dengan state
    * 
    * @param stateContext Konteks state
    */
   void doAction(StateContext stateContext);
}