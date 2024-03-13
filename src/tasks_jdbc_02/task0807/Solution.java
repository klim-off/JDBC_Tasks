package tasks_jdbc_02.task0807;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/* 
task0807
***
In the HikariCPDataSource constructor , configure HikariCP:

initialize the fieldconfig;

set the fieldconfigparameters for connecting to the database: URL "jdbc:mysql://localhost:3306/test" , user "root" and the same password;

initialize the fieldds, passing the field to the constructorconfig.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        List<Employee> employees = new ArrayList<>();
        try (Connection con = HikariCPDataSource.getConnection();
             PreparedStatement pst = con.prepareStatement("select * from employee");
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                employees.add(new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("smth")));
            }
        }

        employees.forEach(System.out::println);
    }
}
