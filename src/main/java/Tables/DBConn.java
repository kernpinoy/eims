/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tables;

import HelperClass.SaveExceptions;
import com.group10.Main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pam
 */
public class DBConn {
    // database connection details
    private static final String username = "root";
    private static final String password = "root";
    private static final String dbLink = "jdbc:mysql://localhost:3306/";
    private static final String[] schemaNames = {"emdbmisProd", "emdbmisTest"};
    
    private static Connection conn = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    private static ResultSetMetaData metadata = null;
    
    public DBConn(int deployStatus) {
        try {
            switch(deployStatus) {
                case 1 -> {
                    conn = DriverManager.getConnection(dbLink + schemaNames[0],
                            username, password);
                }
                    
                case 2 -> {
                    conn = DriverManager.getConnection(dbLink + schemaNames[1],
                            username, password);
                }
            }
        } catch(SQLException e) {
            Logger.getLogger(DBConn.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public static Connection getConn() {
        return conn;
    }

    public static PreparedStatement getPs() {
        return ps;
    }

    public static ResultSet getRs() {
        return rs;
    }

    public static ResultSetMetaData getMetaData() {
        return metadata;
    }
    
    public static int login(String username, String password) {
        // TODO: check wheter login is admin, hr or reg user
        
        String sql = "SELECT `user_type` FROM `TblUsers` WHERE `username` = ? AND `password` = ?";
        
        try {
            // set the sql statement
            ps = conn.prepareStatement(sql);
            
            // fill up the question marks
            ps.setString(1, username);
            ps.setString(2, password);
            
            // save the query to a ResultSet object
            rs = ps.executeQuery();
            
            // check if something returned
            if (rs.next()) {
                // return the value of user_type
                return rs.getInt("user_type");
            }
                    
        } catch(SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            SaveExceptions.setEx(ex);
        }
        
        return -1;
    }
    
    public static int registerNewUser(final String[] newUserDetails) {
        try {
            String sql = "INSERT INTO `TblUsers` (`name`, `contact_number`, `job_dept`, `position`, `username`, `password`, `user_type`) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            // set the values
            for (int i = 0, n = newUserDetails.length; i < n; i++) {
                ps.setString(i + 1, newUserDetails[i]);
            }
            
            ps.executeUpdate();
            
            return 1;
            
        } catch (SQLException ex) {
            Logger.getLogger(DBConn.class.getName()).log(Level.SEVERE, null, ex);
            SaveExceptions.setEx(ex);
        }
        
        return -1;
    }
}
