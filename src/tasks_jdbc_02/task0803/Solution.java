package tasks_jdbc_02.task0803;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/* 
task0803 - parameters
***
 create a connection to the database using the getConnection(String, String, String) method of the DriverManager class .
Use the URL "jdbc:mysql://localhost:3306/test" , user "root" and the same password.
Get a PreparedStatement using the prepareStatement method , passing a variable as a parametersql.
Set the appropriate parameters for the request using variablesname,ageAndsmth.

Complete the request.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        String name = "Harry";
        int age = 18;
        String smth = "Senior pomidor";
        String sql = "insert into employee (name, age, smth) values (?, ?, ?)";
        //напишите тут ваш код
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test","root", "root"
        );

        PreparedStatement prst = connection.prepareStatement(sql);

        // Установка параметров
        prst.setString(1, name);
        prst.setInt(2, age);
        prst.setString(3, smth);


// Выполнение запроса
        prst.executeUpdate();
        prst.close();
        connection.close();
    }
}
