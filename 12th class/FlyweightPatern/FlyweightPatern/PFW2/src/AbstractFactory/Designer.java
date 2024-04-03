/* Designer.java
 * @author Prof. Dr. Sinisa Vlajic,
 * University of Belgrade
 * Faculty of Organizational Sciences
 * Department of Software Engineering
 * Software Engineering Laboratory
 * 06.11.2017
 */

package AbstractFactory;

import AbstractProductA.*;
import AbstractProductB.*;
import AbstractProductC.*;

public interface Designer {
       ScreenForm createScreenForm();   
       DatabaseBroker createDatabaseBroker();
       Controller createController(ScreenForm sf, DatabaseBroker dbb);   
}
