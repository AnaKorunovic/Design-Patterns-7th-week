/* UpravaFakulteta.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 27.11.2017
 */

package PPX1;


// ���������� ������ PPX1: ������ ��������� �� ������� ������ ���� ���� ����������� ��
// ����������  ���������� �� ������� (�������)  ������ �� ������ ����������� ������� ��������������� ������ ���-�. � ������ ����� �� ������:
// �) ���������� ����� � ���� �� �� �������� �������.
// �) ������ �� �������� ����� �������� � ���� �� �� ������ ������.
// ������ ��������� �� ��������� (������������) ������ ������. ���� ��� �� ���-� �� ������ ������ ���� ���� ����� JavaGroup �� ������� �������� ������.

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

// �����: �������� ��������� �������� �� JavaTimGroupPonuda  � JavaTimPonuda ����� ���� �� �� JavaTimPonuda 
// ������ ���� ��������� ����� ��� �� ������ JavaTimGroupPonuda  ������.
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

// �����: ������ ��������� ��� �������� JavaTimPonuda  ������ ������� �� JavaTimGroupPonuda  ������. 
// �������� �������� ��������� �� ���������� SILAB ���� �� JavaTimPonuda ������ ���� �������� 
// JavaTimGroupPonuda  ������ ���������� ������� �� JavaTimGroupPonuda ������ � ���� ���� ��������� �� ������ //�������� � �������.
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

// �����: �������� JavaTimGroupPonuda  ������ ��� �����������  JavaTimPonuda ������.
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
   

