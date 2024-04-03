/* Client8.java
 * @author  Prof. Dr. Sinisa Vlajic,
 * University of Belgrade
 * Faculty of Organizational Sciences
 * Department of Software Engineering
 * Software Engineering Laboratory
 * 27.11.2017
 */

package ZFW1;

// Task ZFW1: Add program code at the three dots to obtain messages:
// Today is a beautiful day.
// Tomorrow will be even better.
// Yesterday was cloudy.
// ***************************
// Today is a beautiful day. Tomorrow will be even better.
// Yesterday was cloudy.

class Client8 {
    public static void main(String[] args) {
       FlyweightFactory ff = new FlyweightFactory(); 
       ff.addFlyweight(...);
       ff.addFlyweight("Tomorrow will be even better.", "\n");
       ff.addFlyweight(...);
       ff.showFlyweight();
       ...
       ff = new FlyweightFactory();
       ff.addFlyweight("Today is a beautiful day.", " ");
       ff.addFlyweight(...);
       ff.addFlyweight("Yesterday was cloudy.", "");
       ff.showFlyweight();
    }
}


class FlyweightFactory { 
    Flyweight fw[];
    int flyweightCounter;

    FlyweightFactory() {
        fw = new Flyweight[30];
        flyweightCounter = 0;
    }

    void addFlyweight(String sharedState, String unsharedState) {
        boolean signal = false;
        for (int i = 0; i < flyweightCounter; i++) {
            if (fw[i].getState().equals(sharedState)) {
                fw[flyweightCounter++] = fw[i];
                signal = true; 
                break; 
            }
        }

        if (...) fw[flyweightCounter++] = new ConcreteFlyweight(...);
        fw[flyweightCounter++] = new UnsharedConcreteFlyweight(...);
    }
  
    void showFlyweight() {
        String message = "";
        for (int i = 0; i < flyweightCounter; i++) { 
            message = message + fw[i].getState(); 
        }
        System.out.println(message);
    }
}
  


abstract class Flyweight {
    abstract String getState();
}

class ConcreteFlyweight extends ... { 
    String sharedState;
    ConcreteFlyweight(String sharedState1) { sharedState = sharedState1; }
  
    @Override
    String getState() { return sharedState; }
}

class UnsharedConcreteFlyweight extends Flyweight { 
    String unsharedState;
    UnsharedConcreteFlyweight(String unsharedState1) { unsharedState = unsharedState1; }
  
    @Override
    public String getState() { return unsharedState; }
}
