package tasks_jdbc_01.task0706;

import java.sql.*;

/* 
task0706
create a connection to the database using the getConnection(String, String, String) method of the DriverManager
 class. Use the URL "jdbc:mysql://localhost:3306/test", the user "root" and the same password.
  Get a Statement using the createStatement method without parameters.
  Run the query "select * from employee limit 1". For each result column, display the column name in the console
   and the column type in parentheses.
Example output: id(INT) name(VARCHAR) age(INT) smth(VARCHAR)
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
       Connection connection = DriverManager.getConnection(
               "jdbc:mysql://localhost:3306/test","root", "root"
       );
       Statement statement = connection.createStatement();

       ResultSet resultSet = statement.executeQuery("select * from employee limit 1");
       ResultSetMetaData metaData = resultSet.getMetaData();
        for (int i = 1; i <= metaData.getColumnCount() ; i++) {
           String name = metaData.getColumnName(i);
           String typeName = metaData.getColumnTypeName(i);

            System.out.println(name + "(" + typeName +")" );
        }

       statement.close();
       connection.close();
    }
}
