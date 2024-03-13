package tasks_jdbc_01.task0702;

import java.sql.*;

/* 
task0702
 create a connection to the database using the getConnection(String, String, String)
 method of the DriverManager class. Use the URL "jdbc:mysql://localhost:3306/test",
  the user "root" and the same password. Get a Statement using the createStatement method without parameters.
  Using this Statement, run the query "select 7 * 8".
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test", "root","root"
        );
          Statement statement = connection.createStatement();
          ResultSet resultSet = statement.executeQuery("select 7 * 8");

          statement.close();
          connection.close();
    }
}
