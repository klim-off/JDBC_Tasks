package tasks_jdbc_01.task0703;

import java.sql.*;

/* 
task0703
create a connection to the database using the getConnection(String, String, String)
 method of the DriverManager class. Use the URL "jdbc:mysql://localhost:3306/test",
  the user "root" and the same password.
  Get a Statement using the createStatement method without parameters.
  Using this Statement, run a database query: get all rows and columns from the employee table.
 Close Statement and Connection.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test", "root","root"
        );
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from employee");
        statement.close();
        connection.close();
    }
}
