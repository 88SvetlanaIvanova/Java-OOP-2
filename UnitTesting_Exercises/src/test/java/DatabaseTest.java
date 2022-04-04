import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p01_Database.Database;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
     private static final Integer[]NUMBERS= {1, 2, 3, 4 };
    private Database database;
    @Before public  void  prepare() throws OperationNotSupportedException{
        database = new Database(NUMBERS);
    }
    @Test public void testConstructorShouldCreateValidDatabase() throws OperationNotSupportedException {

     Integer[] dbElements = database.getElements();

        Assert.assertEquals
                ("Count of db elementsis incorrect", dbElements.length, NUMBERS.length);
        for (int i = 0; i <NUMBERS.length ; i++) {
            Assert.assertEquals("we have different elements in the database", dbElements[i], NUMBERS[i]);
        }


    }
}
