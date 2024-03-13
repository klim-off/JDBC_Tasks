package tasks_jdbc_01.task0701;

import java.sql.*;

/* 
task0701
create a connection to the database using the getConnection(String, String, String) method of the DriverManager class.
 Use the URL "jdbc:mysql://localhost:3306/test", the user "root" and the same password.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

       Connection connection = DriverManager.getConnection(
               "jdbc:mysql://localhost:3306/test","root","root"
       );
       Statement statement = connection.createStatement();
       connection.close();
    }
}
