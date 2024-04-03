/* Client7.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 27.11.2017
 */

package ZFA1;

// Задатак ZFA1: Додати програм на месту три тачке како би се добиле поруке: 
// Juce je bilo oblacno vreme. 
// Danas je lep dan. 
// Sutra ce biti jos lepsi dan.  


class Client7 
{ public static void main(String args[])   
    {  Fasada f = new Fasada();        
       ...     
    } 
}   

class Fasada 
 {   Podsistem1 pod1;   
     ...   
     Fasada() {pod1 = new Podsistem1();...}   
     void prikazipod1(){pod1.prikazipod1();}   
     ...
}    

class Podsistem1 {   void prikazipod1() {System.out.println("Juce je bilo oblacno vreme.");} }   

class Podsistem2 {   void prikazipod2() {... }   

class Podsistem3 {   void prikazipod3() {System.out.println("Sutra ce biti jos lepsi dan.");} }  
