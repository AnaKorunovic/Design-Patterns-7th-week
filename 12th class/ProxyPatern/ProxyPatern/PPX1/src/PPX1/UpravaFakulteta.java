/* UpravaFakulteta.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 27.11.2017
 */

package PPX1;


// Кориснички захтев PPX1: Управа Факултета је послала захтев Јава тиму Лабораторије за
// софтверско  инжењерство да направи (састави)  понуду за израду софтверског система последипломских студија ФОН-а. У понуди треба се наведе:
// а) Програмски језик у коме ће се развијати програм.
// б) Систем за управљање базом података у коме ће се чувати подаци.
// Управа Факултета ће надзирати (контролисати) израду понуда. Јава тим са ФОН-а је послао захтев Јава тиму фирме JavaGroup да направи наведену понуду.

class UpravaFakulteta   // Client
{  SILAB sil;
   UpravaFakulteta(SILAB sil1){sil = sil1;}

  void Konstruisi()
    { sil.kreirajProgramskiJezik();
      sil.kreirajSUBP();
      sil.kreirajPonudu();
    }

   public static void main(String args[])
	{  UpravaFakulteta uf;
   	    JavaTimGroupPonuda jtg = new JavaTimGroupPonuda();
	    JavaTimPonuda jat = new JavaTimPonuda(jtg);
	    uf = new UpravaFakulteta(jat);
	    uf.Konstruisi();
            System.out.println("Ponuda java tima: " + jat.vratiPonudu());
        }
  }

// Улога: Дефинише заједнички интерфејс за JavaTimGroupPonuda  и JavaTimPonuda класе тако да се JavaTimPonuda 
// објекат може користити свуда где се очекује JavaTimGroupPonuda  објекат.
abstract class  SILAB // Subject
{  ProgramskiJezik  pj;
    SUBP subp;
    Ponuda pon;
   abstract void kreirajProgramskiJezik();
   abstract void kreirajSUBP();
   abstract void kreirajPonudu();
   abstract String vratiPonudu();
 }

class Ponuda {String ponuda;}

// Улога: Садржи референцу које омогућава JavaTimPonuda  објекту приступ до JavaTimGroupPonuda  објекту. 
// Обезбеђује интерфејс идентичан са интерфејсом SILAB тако да JavaTimPonuda објекат може заменити 
// JavaTimGroupPonuda  објекат Контролише приступ до JavaTimGroupPonuda објекта и може бити одговоран за његово //креирање и брисање.
class JavaTimPonuda extends SILAB //  Proxy
{ JavaTimGroupPonuda jtgp;
  JavaTimPonuda(JavaTimGroupPonuda jtgp1) {jtgp=jtgp1;}
  @Override
  public void kreirajProgramskiJezik(){jtgp.kreirajProgramskiJezik();}
  @Override
  public void kreirajSUBP() { jtgp.kreirajSUBP();}
  @Override
  public void kreirajPonudu() { jtgp.kreirajPonudu();}
  @Override
  public String vratiPonudu(){return jtgp.vratiPonudu();}
}

// Улога: Дефинише JavaTimGroupPonuda  објекат који репрезентује  JavaTimPonuda објекат.
class JavaTimGroupPonuda extends SILAB // RealSubject 
{  JavaTimGroupPonuda() {pon = new Ponuda();}
   @Override
   public void kreirajProgramskiJezik(){pj = new Java();}
   @Override
   public void kreirajSUBP() { subp = new MySQL();}
   @Override
   public void kreirajPonudu() { pon.ponuda = "Programski jezik-" + pj.vratiProgramskiJezik() + " SUBP-" + subp.vratiSUBP();}
   @Override
   public String vratiPonudu(){return pon.ponuda;}
}

interface ProgramskiJezik {String vratiProgramskiJezik();}

class Java implements ProgramskiJezik {
 @Override
 public String vratiProgramskiJezik(){return "Java";}}

class VB implements ProgramskiJezik {
 @Override
 public String vratiProgramskiJezik(){return "VB";}}

interface SUBP {String vratiSUBP();}

class MySQL implements SUBP {
 @Override
 public String vratiSUBP(){return "MySQL";}}

class MSAccess implements SUBP {
 @Override
 public String vratiSUBP(){return "MS Access";}}
   

