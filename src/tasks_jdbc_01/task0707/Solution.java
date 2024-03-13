package tasks_jdbc_01.task0707;

import java.sql.*;

/* 
Method wasNull
In the main method, create a connection to the database using the getConnection(String, String, String)
 method of the DriverManager class. Use the URL "jdbc:mysql://localhost:3306/test",
  the user "root" and the same password.
 Get a Statement using the createStatement method without parameters.
 Output to the console from the employee table the values of the name (VARCHAR) and weight (FLOAT) columns,
 separated by a space.

Example output:
Vasya 73.3
Pasha 0.0
Sasha 40.2
Dima null
Sasha null
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
          String resultName = resultSet.getString("name");
          Float resultWeight = resultSet.getFloat("weight");
          System.out.println(resultName + " " + (resultSet.wasNull()?"null":resultWeight));
      }
      statement.close();
      connection.close();
    }
}
