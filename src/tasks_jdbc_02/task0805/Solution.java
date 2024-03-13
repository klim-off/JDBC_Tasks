package tasks_jdbc_02.task0805;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Set;

/* 
task0805
***
create a connection to the database using the getConnection(String, String, String) method of the DriverManager class .
Use the URL "jdbc:mysql://localhost:3306/test" , user "root" and the same password.

Get a PreparedStatement using the prepareStatement method , passing a variable as a parametersql.
Add all employees from the employees set to the table .
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        Set<Employee> employees = Set.of(
                new Employee("Vasya", 33, "lead"),
                new Employee("Pasha", 40, "dev"),
                new Employee("Sasha", 40, "lead"),
                new Employee("Dima", 40, "director"),
                new Employee("Sasha", 40, "dev"));
        String sql = "insert into employee (name, age, smth) values (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
             PreparedStatement statement = connection.prepareStatement(sql)) {
            //напишите тут ваш код
            for (Employee employee : employees) {
                statement.setString(1, employee.getName());
                statement.setInt(2, employee.getAge());
                statement.setString(3, employee.getSmth());
                int count = statement.executeUpdate();
            }
        }
    }
}
