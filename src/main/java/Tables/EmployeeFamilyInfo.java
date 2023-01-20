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
public class EmployeeFamilyInfo {
    public static void insertData(JFrame frame) {
        final String sql = "CALL `insertFamilyInfo`("
                + "(SELECT MAX(`emp_id`) FROM `TblEmployee_PersonalInfo`), "
                + "(SELECT MAX(`spouse_id`) FROM `TblSpouse_Info`), "
                + "(SELECT MAX(`parents_id`) FROM `TblParents_Info`), "
                + "(SELECT MAX(`child_id`) FROM `TblChildren_Info`))";
        
        try {
            PreparedStatement ps = DBConn.getConn().prepareStatement(sql);

            // try to insert data
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeFamilyInfo.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(frame, ex, "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void alterAutoIncrement() {
        try {
            // rearrange emp_id
            String[] arrange = {"SET @count = 0", "UPDATE `TblFamily_Info` SET `fam_id` = @count:= @count + 1",
                "ALTER TABLE `TblFamily_Info` AUTO_INCREMENT = 1"};
            
            Statement st = DBConn.getConn().createStatement();
            
            for (String query : arrange) {
                st.addBatch(query);
            }
            
            st.executeBatch();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeFamilyInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
