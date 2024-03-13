package tasks_jdbc_01.task0708;

import java.sql.*;
import java.time.LocalDateTime;

/* 
Getting the date
create a connection to the database using the getConnection(String, String, String) method of the DriverManager
 class. Use the URL "jdbc:mysql://localhost:3306/test", the user "root" and the same password.
 Get a Statement using the createStatement method without parameters.

Output to the console from the employee table the values of the name (VARCHAR) and created (TIMESTAMP) columns,
 separated by a space. Represent the values of the created column as LocalDateTime.

Example output:
Vasya 2020-01-01T10:10:10
Pasha 2019-12-31T23:40:10

*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
      Connection connection = DriverManager.getConnection(
              "jdbc:mysql://localhost:3306/test", "root", "root"
      );
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("select name, created from employee");

      while (resultSet.next()) {
          String resultName = resultSet.getString("name");
          LocalDateTime resultTime = resultSet.getObject("created", LocalDateTime.class );
          System.out.println(resultName + " " + resultTime);
      }
      statement.close();
      connection.close();
    }
}
