/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import function.GeneralException;
import function.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author christianwulff
 */
public class UserMapper {
    
    public static void createUser( User user ) throws GeneralException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "INSERT INTO user (email, password, role) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, user.getEmail() );
            ps.setString( 2, user.getPassword() );
            ps.setString( 3, user.getRole() );
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            String id = ids.getString( 1 );
            user.setId( id );
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new GeneralException( ex.getMessage() );
        }
    }

    public static User login( String email, String password ) throws GeneralException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "SELECT id, role FROM user "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, email );
            ps.setString( 2, password );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                String role = rs.getString( "role" );
                String id = rs.getString( "id" );
                User user = new User( email, password, role );
                user.setId( id );
                return user;
            } else {
                throw new GeneralException( "Could not validate user" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new GeneralException(ex.getMessage());
        }
    }
    
}
