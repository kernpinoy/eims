/*
 * The MIT License
 *
 * Copyright 2023 pam.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package Tables;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author pam
 */
public class EmployeePersonalInfo {
    private final static String tableName = "TblEmployee_PersonalInfo";
    
    // method to insert data 
    public static void insertData(final String[] data, JFrame frame) {
        try {
            String sql = "CALL `insertEmployeeInfo`(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                    + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = DBConn.getConn().prepareStatement(sql);
            
            // set the parameters
            for (int i = 0, n = data.length; i < n; i++) {
                ps.setString(i + 1, data[i]);
            }
            
            // execute insertion
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeePersonalInfo.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(frame, ex, "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void alterAutoIncrement() {
        try {
            // rearrange emp_id
            String[] arrange = {"SET @count = 0", "UPDATE `TblEmployee_PersonalInfo` SET `emp_id` = @count:= @count + 1",
                "ALTER TABLE `TblEmployee_PersonalInfo` AUTO_INCREMENT = 1"};
            
            Statement st = DBConn.getConn().createStatement();
            
            for (String query : arrange) {
                st.addBatch(query);
            }
            
            st.executeBatch();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeePersonalInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void delete(JFrame frame, String emp_id) {
        final String sql = "DELETE FROM TblEmployee_PersonalInfo WHERE `emp_id` = ?";
        
        try {
            PreparedStatement ps = DBConn.getConn().prepareStatement(sql);
            
            ps.setString(1, emp_id);
            
            // execute insertion
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeePersonalInfo.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(frame, ex, "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void update(String[] data, JFrame frame) {
        final String sql = """
                           UPDATE `TblEmployee_PersonalInfo`
                           SET
                           `lname` = ?,
                           `fname` = ?,
                           `mname` = ?,
                           `name_ext` = ?,
                           `gender` = ?,
                           `height` = ?,
                           `weight` = ?,
                           `blood_type` = ?,
                           `cstatus` = ?,
                           `bdate` = ?,
                           `pdate` = ?,
                           `age` = ?,
                           `religion` = ?,
                           `citizenship` = ?,
                           `res_add` = ?,
                           `perm_add` = ?,
                           `email_add` = ?,
                           `tel_no` = ?,
                           `mobile_no` = ?,
                           `gsisID_no` = ?,
                           `pagIbigID_no` = ?,
                           `philhealthID_no` = ?,
                           `sss_no` = ?,
                           `tin_no` = ?
                           WHERE `emp_id` = ?
                           """;
        
        try {
            PreparedStatement ps = DBConn.getConn().prepareStatement(sql);
            
            // set string
            for (int i = 0; i < data.length; i++) {
                ps.setString(i + 1, data[i]);
            }
            
            // execute insertion
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeePersonalInfo.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(frame, ex, "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
}