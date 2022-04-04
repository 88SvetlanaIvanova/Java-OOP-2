import p01_Database.Database;

import javax.naming.OperationNotSupportedException;

public class Main {
    public static void main(String[] args)throws OperationNotSupportedException {
      Database db = new Database(1, 2, 3);
      db.add(5);
      db.remove();
    }
}
