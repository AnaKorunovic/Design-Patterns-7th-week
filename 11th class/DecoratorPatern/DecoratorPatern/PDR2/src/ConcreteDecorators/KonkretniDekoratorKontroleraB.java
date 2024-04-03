/* KonkretniDekoratorKontroleraB.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 19.11.2017
 */
package ConcreteDecorators;

import AbstractProductA.EkranskaForma;
import Component.Kontroler;
import Decorator.DekoratorKontroler;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;

public class KonkretniDekoratorKontroleraB extends DekoratorKontroler{  // ConcretreDecoratorB
  public KonkretniDekoratorKontroleraB(Kontroler pred, Kontroler osnovni)
     {super(pred); 
      ef = osnovni.getEkranskaForma();
      Povezi(osnovni);} 
  
    // Dadaje se novo ponasanje postojecem ponasanju.
     @Override
     public void Povezi(Kontroler kon) { // Kada se aktivira JFrame fokus se prebacuje na polje BrojIndeksa.
                
        ef.addWindowListener( new WindowAdapter() {
                  @Override
                  //public void windowOpened( WindowEvent e ){
                   public void  windowActivated ( WindowEvent e ){
                  ef.getPanel().getBrojIndeksa1().requestFocus();
                  ef.getPanel().getNadji().setVisible(false);
                  }});
        
   kon.Povezi(this); // Povezivanje konkretnog dekoratora sa osluskivacem.
  }
  
  // Dadaje se novo ponasanje postojecem ponasanju.
     
   @Override
    public boolean kreirajDomenskiObjekat(){
         ef.getPanel().getBrojIndeksa1().requestFocusInWindow();
         kon.startAudioKlip("create.wav");
         kon.setIkonu("create.jpg");
         prikaziOsnovnuIkonu();
        return super.kreirajDomenskiObjekat();} 
    
    @Override
    public boolean obrisiDomenskiObjekat(){
        kon.startAudioKlip("delete.wav");
        kon.setIkonu("delete.jpg");
        prikaziOsnovnuIkonu();
        return super.obrisiDomenskiObjekat();} 
    
    @Override
    public boolean promeniDomenskiObjekat(){
        kon.startAudioKlip("update.wav");
        kon.setIkonu("update.jpg");
        prikaziOsnovnuIkonu();
        return super.promeniDomenskiObjekat();} 
    
    @Override
    public boolean nadjiDomenskiObjekat(){
        kon.startAudioKlip("find.wav");
        kon.setIkonu("find.gif");
        prikaziOsnovnuIkonu();
        return super.nadjiDomenskiObjekat();} 
   
     public void prikaziOsnovnuIkonu() 
     { 
      
       Timer timer = new Timer();
  
       timer.schedule(new TimerTask() {
       @Override
       public void run() {
       kon.setIkonu("AkreditacijaSILAB.jpg");
       }
      }, 5000);
    }
}
