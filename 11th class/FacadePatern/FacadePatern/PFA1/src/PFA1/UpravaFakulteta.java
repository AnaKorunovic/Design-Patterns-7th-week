/* UpravaFakulteta.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 27.11.2017
 */

package PFA1;


// ���������� ������ PFA1 : ������ ��������� ����� �� ������ �������� ������ ������, 
// ���� ��� �� �� ������� ����� �� ����� ������� ������� �� ������ ��� ����� ���������� 
// �� �������� ����� �� ���������� ��������.

class UpravaFakulteta // client
{ KomisijaZaPonude kzp;
  UpravaFakulteta(){kzp = new KomisijaZaPonude();}

  public static void main(String args[])
	{  UpravaFakulteta uf = new UpravaFakulteta(); 
	   uf.kzp.odrediFormatPonude(args[0]); 
	   uf.kzp.kreirajPonuduJavaTima(); 
	   uf.kzp.Konstruisi(); 
	   uf.kzp.prikaziPonudu(); 
    }
}

// �����: ��� ��� ����� ���������� (FormatPonude, SILAB) �� ��������� �� ������� ������� ��  �������. ������� ����������� �� ������� ���������� ������� �� ������� ���������.
class KomisijaZaPonude  // Facade
{   FormatPonude fp;
    SILAB sil;
    void odrediFormatPonude(String arg)	  
      {  if (arg.equals("1")) fp = new FormatPonude1();
         if (arg.equals("2")) fp = new FormatPonude2();
      }
    void kreirajPonuduJavaTima(){sil = new JavaTimPonuda();}
    void Konstruisi(){  sil.kreirajProgramskiJezik();  sil.kreirajSUBP();sil.kreirajPonudu(fp);}
    void prikaziPonudu(){System.out.println("Ponuda java tima: " + sil.vratiPonudu());} 
}
// �����: ������������� ������������ ���������������. ������� �������  ��� �� ������ ��  facade (KomisijaZaPonude)  // ������. �� ���� �� �� facade ������, ��� �� ����� ��������� �� ����.
abstract class  SILAB  
{  ProgramskiJezik  pj;
   SUBP subp;
   Ponuda pon;
   abstract void kreirajProgramskiJezik();
   abstract void kreirajSUBP();
   public String vratiPonudu(){return pon.ponuda;}
   public void kreirajPonudu(FormatPonude fp) { pon.ponuda = fp.vratiFormatPonude(this);}
 }

class JavaTimPonuda extends SILAB 
{ JavaTimPonuda() {pon = new Ponuda();}
  @Override
  public void kreirajProgramskiJezik(){pj = new Java();}
  @Override
  public void kreirajSUBP() { subp = new MySQL();}
  @Override
  public String vratiPonudu(){return "Autor: Lab za soft. inzenjerstvo: " + pon.ponuda;}
}

class VBTimPonuda extends SILAB 
{ VBTimPonuda(){pon = new Ponuda();}
  @Override
  public void kreirajProgramskiJezik(){pj = new VB();}
  @Override
  public void kreirajSUBP() {subp = new MSAccess();}
}

class Ponuda {String ponuda;}

// �����: �������� �������� �� ��������������� �����  (FormatPonude1, FormatPonude2).
abstract class FormatPonude   
{  abstract String vratiFormatPonude(SILAB sil);
}

// �����: ������������ ��������FormatPonude. 
class FormatPonude1 extends FormatPonude   
{ @Override
  String vratiFormatPonude(SILAB sil)
      {  return  "Programski jezik-" + sil.pj.vratiProgramskiJezik() + "  SUBP-" + sil.subp.vratiSUBP();}
}

class FormatPonude2 extends FormatPonude 
{
  @Override
  String vratiFormatPonude(SILAB sil)
    { return  "SUBP-" + sil.subp.vratiSUBP() + " Programski jezik-" + sil.pj.vratiProgramskiJezik();}
}

interface ProgramskiJezik {String vratiProgramskiJezik();}
class Java implements ProgramskiJezik 
 { @Override
   public String vratiProgramskiJezik(){return "Java";}}

class VB implements ProgramskiJezik 
 { @Override
   public String vratiProgramskiJezik(){return "VB";}}

interface SUBP {String vratiSUBP();}

class MySQL implements SUBP
  { @Override
    public String vratiSUBP(){return "MySQL";}}

class MSAccess implements SUBP 
  { @Override
    public String vratiSUBP(){return "MS Access";}}

