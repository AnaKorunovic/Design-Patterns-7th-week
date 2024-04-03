/* UpravaFakulteta.java

@author Prof. Dr. Sinisa Vlajic,
University of Belgrade
Faculty of Organizational Sciences
Department of Software Engineering
Software Engineering Laboratory
27.11.2017
 */
package pfw11;

// User request PFW11: The Faculty Management requested from the Java team to prepare their offer in the following three different formats:
// Offer of the Java team.
// Author: Software Engineering Lab.
// Programming language: Java.
// SUBP:MySQL.
// *******************************
// Offer of the Java team. Author: Software Engineering Lab.
// Programming language: Java. SUBP:MySQL.
// *******************************
// Offer of the Java team.
// Author: Software Engineering Lab.
// Programming language: Java.
// SUBP:MySQL.
// *******************************
// The Head of the Software Engineering Laboratory requested from the Java team to keep the offer elements in one place,
// to avoid redundancy of the same offer elements in different requested offer formats.

class FacultyManagement {

    static SILAB sil;

    public static void main(String args[]) {
        sil = new JavaTeamOffer();
        sil.createProgrammingLanguage();
        sil.createDBMS();
        sil.createOffer1();
        sil.createOffer2();
        sil.createOffer3();
        sil.showOffers();
    }
}

class Offer {
    String offer;
}

abstract class SILAB {

    ProgrammingLanguage pl;
    DBMS dbms;
    Offer offer;

    abstract void createProgrammingLanguage();

    abstract void createDBMS();

    abstract void createOffer1();

    abstract void createOffer2();

    abstract void createOffer3();

    abstract void showOffers();
}

class JavaTeamOffer extends SILAB // Client
{

    OfferElementsFactory fep;

    JavaTeamOffer() {
        fep = new OfferElementsFactory();
        offer = new Offer();
    }

    @Override
    void createProgrammingLanguage() {
        pl = new Java();
    }

    @Override
    void createDBMS() {
        dbms = new MySQL();
    }

    @Override
    void createOffer1() {
        fep.addElementOffer("Java team proposal.", "\n");
        fep.addElementOffer("Author: Software Engineering Lab.", "\n");
        fep.addElementOffer("Programming language: " + pl.returnProgrammingLanguage() + ".", "\n");
        fep.addElementOffer("DBMS:" + dbms.returnDBMS() + ".", "\n");
        fep.addElementOffer("*******************************", "\n");
    }

    @Override
    void createOffer2() {
        fep.addElementOffer("Java team proposal. ", "\t");
        fep.addElementOffer("Author: Software Engineering Lab.", "\n");
        fep.addElementOffer("Programming language: " + pl.returnProgrammingLanguage() + ". ", "");
        fep.addElementOffer("DBMS:" + dbms.returnDBMS()+ ".", "\n");
        fep.addElementOffer("*******************************", "\n");
    }

    @Override
    void createOffer3() {
        fep.addElementOffer("Java team proposal. ", "\n\t");
        fep.addElementOffer("Author: Software Engineering Lab.", "\n\t\t");
        fep.addElementOffer("Programming language: " + pl.returnProgrammingLanguage() + ".", "\n\t\t");
        fep.addElementOffer("DBMS:" + dbms.returnDBMS() + ".", "");
    }

    @Override
    void showOffers() {
        offer.offer = "";
        for (int i = 0; i < fep.returnNumberOfOfferElements(); i++) {
            offer.offer = offer.offer + fep.oe[i].returnState();
        }
        System.out.println(offer.offer);
    }
}

interface ProgrammingLanguage {

    String returnProgrammingLanguage();
}

class Java implements ProgrammingLanguage {

    @Override
    public String returnProgrammingLanguage() {
        return "Java";
    }
}

interface DBMS {

    String returnDBMS();
}

class MySQL implements DBMS {

    @Override
    public String returnDBMS() {
        return "MySQL";
    }
}

class OfferElementsFactory // FlyweightFactory
{

    OfferElement oe[];
    int numberOfElements;

    OfferElementsFactory() {
        oe = new OfferElement[30];
        numberOfElements = 0;
    }

    void addElementOffer(String sharedOfferElement, String unsharedOfferElement) {
        boolean signal = false;
        for (int i = 0; i < numberOfElements; i++) {
            if (oe[i].returnState().equals(sharedOfferElement)) {
                oe[numberOfElements++] = oe[i];
                signal = true;
                break;
            }
        }

        if (!signal) {
            oe[numberOfElements++] = new SharedOfferElement(sharedOfferElement);
        }
        oe[numberOfElements++] = new UnsharedOfferElement(unsharedOfferElement);
    }

    int returnNumberOfOfferElements() {
        return numberOfElements;
    }

    void setNumberOfOfferElements(int numberOfElements1) {
        numberOfElements = numberOfElements1;
    }
}

abstract class OfferElement // Flyweight
{

    abstract String returnState();
}

class SharedOfferElement extends OfferElement // ConcreteFlyweight
{

    String sharedState;

    SharedOfferElement(String sharedState1) {
        sharedState = sharedState1;
    }

    @Override
    String returnState() {
        return sharedState;
    }
}

class UnsharedOfferElement extends OfferElement // UnsharedConcreteFlyweight
{

    String unsharedState;

    UnsharedOfferElement(String unsharedState1) {
        unsharedState = unsharedState1;
    }

    @Override
    public String returnState() {
        return unsharedState;
    }
}
