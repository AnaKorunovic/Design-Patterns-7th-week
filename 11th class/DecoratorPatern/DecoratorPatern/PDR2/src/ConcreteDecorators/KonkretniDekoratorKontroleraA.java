/* KonkretniDekoratorKontroleraA.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 19.11.2017
 */
package ConcreteDecorators;

import Component.Kontroler;
import Decorator.DekoratorKontroler;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class KonkretniDekoratorKontroleraA extends DekoratorKontroler{ // ConcretreDecoratorA
  
    // Dadaje se novo stanje postojecim stanjima.
    JLabel loperacija;
    
    public KonkretniDekoratorKontroleraA(Kontroler osnovni)
     {super(osnovni);
      ef = osnovni.getEkranskaForma();
      loperacija = new JLabel("Operacija");
      loperacija.setLocation(0, 0);
      loperacija.setSize(354, 282);
      loperacija.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/AkreditacijaSILAB.jpg")));
      ef.getPanel().add(loperacija);
     } 
    
     @Override
     public void setIkonu(String nazivIkone)
     { ImageIcon ii = new javax.swing.ImageIcon(getClass().getResource("/Images/" + nazivIkone));
      
       loperacija.setIcon(ii); 
     }
     
     public void startAudioKlip(String nazivKlipa)
     {  
         
        URL url = getClass().getResource("/AudioClips/" + nazivKlipa);
           
             
        AudioInputStream audioIn;
        try {
            audioIn = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (Exception ex) {System.out.println("Greska:" + ex);
           

     }
    }     
        
}   
        
