package net.nishat.vc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AppConnection {
    public static Connection getConnection(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            return DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.31:1522:prod",
                                    "apps", "mskiz145");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
