package tasks_jdbc_02.task0806;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

/* 
task0806
***
create a connection to the database using the getConnection(String, String, String) method of the DriverManager class .
Use the URL "jdbc:mysql://localhost:3306/test" , user "root" and the same password.

Get a Statement using the createStatement method without parameters.
Get all rows and columns from the employee table.
Convert them into objects Employee and put them in the employees set .
*/

public class Solution {

    public static Set<Employee> employees = new HashSet<>();

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
      Connection connection = DriverManager.getConnection(
              "jdbc:mysql://localhost:3306/test", "root", "root"
      );

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from employee");

        while (resultSet.next()){
            Employee employee = new Employee(resultSet.getInt(1),
                                             resultSet.getString(2),
                                             resultSet.getInt(3),
                                             resultSet.getString(4));
            employees.add(employee);
        }

        connection.close();
        statement.close();
        employees.forEach(System.out::println);
    }
}
