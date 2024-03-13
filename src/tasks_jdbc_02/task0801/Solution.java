package tasks_jdbc_02.task0801;

import java.sql.*;

/* 
Working with transactions
***
 create a connection to the database using the getConnection(String, String, String) method of the DriverManager class .
Use the URL "jdbc:mysql://localhost:3306/test" , user "root" and the same password.
Disable AutoCommit.
Get a Statement using the createStatement method without parameters.

Employee (employee table) with fieldnameequal to Diego , increase the salary value by 2000.
To employee (employee table) with fieldnameequal to Amigo , increase the salary value by 500.
Commit.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
       Connection connection = DriverManager.getConnection(
               "jdbc:mysql://localhost:3306/test", "root", "root"
       );
       connection.setAutoCommit(false);
       Statement statement = connection.createStatement();

       int rowCount1 = statement.executeUpdate("update employee set salary = salary + 2000 where name = 'Diego'");
       int rowCount2 = statement.executeUpdate("update employee set salary = salary + 500 where name = 'Amigo'");

       connection.commit();
       statement.close();
       connection.close();
    }
}
