package tasks_jdbc_01.task0705;

import java.sql.*;

/* 
task0705
create a connection to the database using the getConnection(String, String, String) method of the DriverManager
 class. Use the URL "jdbc:mysql://localhost:3306/test", the user "root" and the same password.
  Get a Statement using the createStatement method without parameters.
Print the minimum value of the age column of the employee table to the console. Column type - INT.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
       Connection connection = DriverManager.getConnection(
               "jdbc:mysql://localhost:3306/test","root","root"
       );
       Statement statement = connection.createStatement();
       ResultSet results = statement.executeQuery("select min(age) from employee");
        results.next();
           int minAge = results.getInt(1);
           System.out.println(minAge);
       statement.close();
       connection.close();
    }
}
