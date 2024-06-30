//Steps for JDBC
//1.Register the driver
//2.Create Connection
//3.Create Statement
//4.Execute Query
//5.Close connection
package bank.management.system;

import java.sql.*;

public class Conn {

    Connection c;
    Statement s;

    public Conn() {
        try {
            //Class.forName(com.mysql.cj.jdbc.Driver);
            c = DriverManager.getConnection("jdbc:mysql:///bankManagementSystem", "root", "XXXXXXX");
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
