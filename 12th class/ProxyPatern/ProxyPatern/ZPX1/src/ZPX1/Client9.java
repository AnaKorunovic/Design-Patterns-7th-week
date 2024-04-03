/* Client9.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 27.11.2017
 */

package ZPX1;

// Кориснички захтев RZPX1: Додати програм на месту три тачке како би се добила порука: 
// Danas je lep dan!!!


class Client9   
{  ...
   Client9(Subject sub1){sub = sub1;}
    
    public static void main(String[] args) {
        RealSubject rs = new RealSubject();
        ...
        Client9 cl = new Client9(pr);
        ...
    }
    
    void Request(){sub.Request();}
}


abstract class  Subject 
{  
   ...
}

class Proxy extends Subject
{
  RealSubject rs;
  Proxy(RealSubject rs1){rs=rs1;}
  @Override
  void Request(){rs.Request();}
}

class RealSubject extends ...
{@Override
 void Request(){...}
}

