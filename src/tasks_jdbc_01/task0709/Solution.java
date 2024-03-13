package tasks_jdbc_01.task0709;

import java.sql.*;

/* 
Method getObject
****
create a connection to the database using the getConnection(String, String, String)
 method of the DriverManager class. Use the URL "jdbc:mysql://localhost:3306/test",
  the user "root" and the same password. Get a Statement using the createStatement method without parameters.

Output to the console from the employee table the values of the columns name (VARCHAR), weight (FLOAT),
 birthday (DATE) and inn (LONG) separated by a space.

Example output:
Pasha 73.7 null 2222222222
Nastya null 1997-07-17 null
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
       Connection connection = DriverManager.getConnection(
               "jdbc:mysql://localhost:3306/test", "root", "root"
       );
       Statement statement = connection.createStatement();
       ResultSet results = statement.executeQuery("select name, weight,birthday, inn from employee");
        while (results.next()) {
            System.out.printf("%s %s %s %s\n",
                    results.getString("name"),
                    results.getObject("weight", Float.class),
                    results.getDate("birthday"),
                    results.getObject("inn", Long.class));
        }
       statement.close();
       connection.close();
    }
}
