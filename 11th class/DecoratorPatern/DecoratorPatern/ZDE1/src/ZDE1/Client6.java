/* Client6.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 27.11.2017
 */

package ZDE1;

// Задатак ZDE1:  Додати програм на месту три тачке како би се добиле поруке: 
// Juce je bilo oblacno vreme. 
// Danas je lep dan. 
// Sutra ce biti jos lepsi dan. 

interface Komponenta { void prikazi();} 

class  Dekorator implements Komponenta 
  {  ...    
     Dekorator(Komponenta komp1) {...}    
     @Override
     public void prikazi(){komp.prikazi();} 
  }  

class KonkretniDekoratorA extends Dekorator 
{  KonkretniDekoratorA(Komponenta komp1) {super(komp1); }    
   @Override
   public void prikazi(){super.prikazi(); System.out.println("Danas je lep dan.");} 
} 

class KonkretniDekoratorB  extends Dekorator 
{  KonkretniDekoratorB(Komponenta komp1) {super(komp1);}    
   @Override
   public void prikazi(){super.prikazi(); ...} 
}  

class KonkretnaKomponenta implements Komponenta 
{@Override
 public void prikazi() { ...} 
}  

class Client6 
{ public static void main(String args[])      
   { KonkretnaKomponenta kk = new KonkretnaKomponenta();          
     ...          
     kdb.prikazi();      
   }  
} 