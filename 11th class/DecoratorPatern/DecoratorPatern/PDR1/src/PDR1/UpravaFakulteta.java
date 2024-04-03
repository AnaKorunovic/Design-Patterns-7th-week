/* UpravaFakulteta.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 27.11.2017
 */

package PDR1;

// Кориснички захтев PDR1 : Управа Факултета треба да прошири понуду Јава тима са датумом када је издата понуда. 
// Након тога понуду треба проширити са местом где је издата понуда.


interface Komponenta   // Component
{ void prikaziPonudu();}
// Улога: Чува референцу на  Komponenta објекат. Дефинише интерфејс који је у складу са интерфејсом Komponenta.	
class  Dekorator implements Komponenta // Decorator
{   Komponenta komp;
    Dekorator(Komponenta komp1) {komp = komp1;}
    @Override
    public void prikaziPonudu(){komp.prikaziPonudu();}
}
// Улога: Додаје одговорност до UpravaFakulteta објектa.
class Datum extends Dekorator  // Concrete Decorator 1
{   String dat;
    Datum(Komponenta komp1) {super(komp1); dat = "28.08.2014";}
    @Override
    public void prikaziPonudu(){super.prikaziPonudu(); System.out.println("Datum: " + dat);}
}
class Mesto extends Dekorator  // Concrete Decorator 2
{   String mes;
    Mesto(Komponenta komp1) {super(komp1);mes="Beograd";}
    @Override
    public void prikaziPonudu(){super.prikaziPonudu(); System.out.println("Mesto: " + mes);}
}
// Улога: Дефинише  објекат коме ће бити додата одговорност  динамички.
class UpravaFakulteta implements Komponenta  // ConcreteComponent
{ SILAB sil; // Builder
  UpravaFakulteta(SILAB sil1){sil = sil1;}
  void Konstruisi()
    { sil.kreirajProgramskiJezik();
      sil.kreirajSUBP();
      sil.kreirajPonudu();
    }

   public static void main(String args[])
     {  UpravaFakulteta uf;
        JavaTimPonuda jat = new JavaTimPonuda();  // ConcreteBuilder1
         uf = new UpravaFakulteta(jat);
         uf.Konstruisi();
         Datum dat = new Datum(uf);
         Mesto mes = new Mesto(dat);
          // Moglo je i ovako da se napise: Mesto mes = new Mesto(new Datum(uf));
          mes.prikaziPonudu();
          // u ovom primeru se prvo pojavljuje mesto pa datum na ponudi
          //  mes = new Mesto(uf);dat = new Datum(mes); dat.prikaziPonudu();
      }
   @Override
   public void prikaziPonudu(){System.out.println("Ponuda java tima: \n" + sil.vratiPonudu());}
}

abstract class  SILAB 
{  ProgramskiJezik  pj;  SUBP subp; 
    Ponuda pon;
   abstract void kreirajProgramskiJezik();
   abstract void kreirajSUBP();
   abstract void kreirajPonudu();
   abstract String vratiPonudu();
 }

class Ponuda {String ponuda;} 

class JavaTimPonuda extends SILAB 
{ JavaTimPonuda() {pon = new Ponuda();}
  @Override
  public void kreirajProgramskiJezik(){pj = new Java();}
  @Override
  public void kreirajSUBP() { subp = new MySQL();}
  @Override
  public void kreirajPonudu() { pon.ponuda = "Programski jezik-" + pj.vratiProgramskiJezik() + " SUBP-" + subp.vratiSUBP();} 
  @Override
  public String vratiPonudu(){return pon.ponuda;}
}
class VBTimPonuda extends SILAB {  
  VBTimPonuda(){pon = new Ponuda();}
  @Override
  public void kreirajProgramskiJezik(){pj = new VB();}
  @Override
  public void kreirajSUBP() {subp = new MSAccess();}
  @Override
  public void kreirajPonudu() { pon.ponuda = "Programski jezik-" + pj.vratiProgramskiJezik() + " SUBP-" + subp.vratiSUBP();}
  @Override
  public String vratiPonudu(){return pon.ponuda;}
}

interface ProgramskiJezik  {String vratiProgramskiJezik();}
class Java implements ProgramskiJezik 
 { @Override
   public String vratiProgramskiJezik(){return "Java";}}

class VB implements ProgramskiJezik 
 {  @Override
    public String vratiProgramskiJezik(){return "VB";}}

interface SUBP {String vratiSUBP();}
class MySQL implements SUBP 
 { @Override
   public String vratiSUBP(){return "MySQL";}}

class MSAccess implements SUBP  
 { @Override
   public String vratiSUBP(){return "MS Access";}}

