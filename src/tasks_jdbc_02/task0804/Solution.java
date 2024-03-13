package tasks_jdbc_02.task0804;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/* 
task0804 - batch mode
***
create a connection to the database using the getConnection(String, String, String) method of the DriverManager class .
Use the URL "jdbc:mysql://localhost:3306/test" , user "root" and the same password.
Get a PreparedStatement using the prepareStatement method , passing a variable as a parametersql.

In batch mode, add five records to the table:

('employee_0', 30, 'i = 0'),
('employee_1', 31, 'i = 1'),
...
('employee_4', 34, 'i = 4').
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        String sql = "insert into employee (name, age, smth) values (?, ?, ?)";
        //напишите тут ваш код
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test", "root","root"
        );
        PreparedStatement prst = connection.prepareStatement(sql);
        for (int i = 0; i < 5; i++) {
            prst.setString(1,"employee_"+i);
            prst.setInt(2,30 + i);
            prst.setString(3,"i = " + i );
            prst.addBatch();
        }
        int[] result = prst.executeBatch();
        prst.close();
        connection.close();
    }
}
