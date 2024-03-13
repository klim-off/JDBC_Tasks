package tasks_jdbc_01.task0704;

import java.sql.*;

/* 
task0704
create a connection to the database using the getConnection(String, String, String) method of the DriverManager
 class. Use the URL "jdbc:mysql://localhost:3306/test",
 the user "root" and the same password. Get a Statement using the createStatement method without parameters.
  Using this Statement, run a database query: get all rows and columns from the employee table.
Print the values of the name column to the console, each value on a new line. Column type is string.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Connection connection = DriverManager.getConnection(
         "jdbc:mysql://localhost:3306/test","root","root"
        );
       Statement statement = connection.createStatement();
       ResultSet resultSet = statement.executeQuery("select * from employee");

       while (resultSet.next()){
           String name = resultSet.getString("name");
           System.out.println(name);
       }
       statement.close();
       connection.close();
    }
}
