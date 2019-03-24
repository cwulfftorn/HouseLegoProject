/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author christianwulff
 */
public class DBConnector {
    
    private static final String URL = "jdbc:mysql://localhost:3306/legohus";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password1234";

    private static Connection singleton;

    public static void setConnection( Connection con ) {
        
        singleton = con;
    }

    public static Connection connection() throws ClassNotFoundException, SQLException {
        if ( singleton == null ) {
            
//            Class.forName( "com.mysql.cj.jdbc.Driver" );
//            singleton = DriverManager.getConnection( URL, USERNAME, PASSWORD );
            Class.forName("com.mysql.cj.jdbc.Driver");
            Properties props = new Properties();
            props.put("user", USERNAME);
            props.put("password", PASSWORD);
            props.put("allowMultiQueries", true);
            props.put("useUnicode", true);
            props.put("useJDBCCompliantTimezoneShift", true);
            props.put("useLegacyDatetimeCode", false);
            props.put("serverTimezone", "CET");
            singleton = DriverManager.getConnection(URL, props);
            DBConnector.setConnection(singleton);
        }
        return singleton;
    }
    
}
