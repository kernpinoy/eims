package com.group10.AdminGUI;

import Tables.DBConn;
import Tables.EmployeeChildData;
import Tables.EmployeeEducationInfo;
import Tables.EmployeeOccupationInfo;
import Tables.EmployeeParentsInfo;
import Tables.EmployeePersonalInfo;
import Tables.EmployeeSpouseInfo;
import com.group10.AdminGUI.dashboardView;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Sophia de Guzman
 */
public class ViewMore_Admin extends javax.swing.JFrame {
    private int emp_id;
    private static dashboardView view = null;
    
    /**
     * Creates new form ViewMore_Admin
     */
    public ViewMore_Admin() {
        setVisible(true);
        initComponents();
    }
    
    public ViewMore_Admin(int emp_id) {
        setVisible(true);
        initComponents();
        this.emp_id = emp_id;
    }
    
    public ViewMore_Admin(dashboardView newView) {
        setVisible(true);
        initComponents();
        view = newView;
    }
    
    private void resetFields() {
        pi_surName.setText("");
        pi_firstName.setText("");
        pi_midName.setText("");
        pi_nameExt.setSelectedIndex(0);
        pi_DOB.setText("");
        pi_pob.setText("");
        pi_genderBox.setSelectedIndex(0);
        pi_civilstats.setSelectedIndex(0);
        pi_age.setText("");
        pi_bloodType.setText("");
        pi_weight.setText("");
        pi_height.setText("");
        pi_citizenship.setText("");
        pi_religion.setText("");
        pi_resiAdd.setText("");
        pi_permaAdd.setText("");
        pi_emailAdd.setText("");
        pi_telNum.setText("");
        pi_mobNum.setText("");
        pi_gsis.setText("");
        pi_pagibig.setText("");
        pi_philhealth.setText("");
        pi_sssID.setText("");
        pi_tin.setText("");
        elem_schlname.setText("");     
        elem_schladd.setText("");
        elem_yeargrad.setText("");
        sec_schlname.setText("");
        sec_schladd.setText("");
        sec_yearReal.setText("");
        ter_schlname.setText("");
        ter_schladd.setText("");
        ter_degree.setText("");
        ter_yeargrad.setText("");
        spouse_surname.setText("");
        spouse_firstName.setText("");
        spouse_middleName.setText("");
        spouse_nameExt.setSelectedItem("");
        spouse_occuReal.setText("");
        spouse_contactnum.setText("");
        child_surname.setText("");
        child_firstname.setText("");
        child_midname.setText("");
        child_DOB.setText("");
        // father
        father_surname.setText("");
        father_fname.setText("");
        father_mname.setText("");
        father_nameExt.setSelectedIndex(0);
                    
        // mother
        mother_surname.setText("");
        mother_firstname.setText("");
        mother_middlename.setText("");
        job_dept.setSelectedItem("");
        job_post.setText("");
        job_status.setSelectedIndex(0);
        job_startDate.setText("");
        job_leaveDate.setText("");
        job_titleSelector.setSelectedItem("");
        job_rate.setText("");
    }
    
    private void refreshPersonalInfo() {
        String sql = "SELECT * FROM `TblEmployee_PersonalInfo` WHERE `emp_id` = ?";
        
        SwingUtilities.invokeLater(() -> {
            try {
                PreparedStatement ps = DBConn.getConn().prepareStatement(sql);
            
                // set the string as the input in the search box
                ps.setString(1, viewMore_searchBox.getText());
                ResultSet rs = ps.executeQuery();
                
                // update gui 
                if (rs.next()) {
                    pi_surName.setText(rs.getString("lname"));
                    pi_firstName.setText(rs.getString("fname"));
                    pi_midName.setText(rs.getString("mname"));
                    pi_nameExt.setSelectedItem(rs.getString("name_ext"));
                    pi_DOB.setText(rs.getString("bdate"));
                    pi_pob.setText(rs.getString("pdate"));
                    pi_genderBox.setSelectedItem(rs.getString("gender"));
                    pi_civilstats.setSelectedItem(rs.getString("cstatus"));
                    pi_age.setText(rs.getString("age"));
                    pi_bloodType.setText(rs.getString("blood_type"));
                    pi_weight.setText(rs.getString("weight"));
                    pi_height.setText(rs.getString("height"));
                    pi_citizenship.setText(rs.getString("citizenship"));
                    pi_religion.setText(rs.getString("religion"));
                    pi_resiAdd.setText(rs.getString("res_add"));
                    pi_permaAdd.setText(rs.getString("perm_add"));
                    pi_emailAdd.setText(rs.getString("email_add"));
                    pi_telNum.setText(rs.getString("tel_no"));
                    pi_mobNum.setText(rs.getString("mobile_no"));
                    pi_gsis.setText(rs.getString("gsisID_no"));
                    pi_pagibig.setText(rs.getString("pagIbigID_no"));
                    pi_philhealth.setText(rs.getString("sss_no"));
                    pi_sssID.setText(rs.getString("sss_no"));
                    pi_tin.setText(rs.getString("tin_no"));
                }
                
            } catch(SQLException ex) {
                JOptionPane.showMessageDialog(this, ex, "Error!", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
    
    private void refreshEducDetails() {
        SwingUtilities.invokeLater(() -> {
            String sql = "SELECT * FROM `TblEducation_Info` WHERE `educ_id` = ?";
            
            try {
                PreparedStatement ps = DBConn.getConn().prepareStatement(sql);
            
                // set the string as the input in the search box
                ps.setString(1, viewMore_searchBox.getText());
                ResultSet rs = ps.executeQuery();
                
                if (rs.next()) {
                    elem_schlname.setText(rs.getString("elem_name"));     
                    elem_schladd.setText(rs.getString("elem_add"));
                    elem_yeargrad.setText(rs.getString("elem_year"));
                    sec_schlname.setText(rs.getString("sec_name"));
                    sec_schladd.setText(rs.getString("sec_add"));
                    sec_yearReal.setText(rs.getString("sec_year"));
                    ter_schlname.setText(rs.getString("ter_name"));
                    ter_schladd.setText(rs.getString("ter_add"));
                    ter_degree.setText(rs.getString("ter_course"));
                    ter_yeargrad.setText(rs.getString("ter_year"));
                }
            } catch(SQLException ex) {
                JOptionPane.showMessageDialog(this, ex, "Error!", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
    
    private void refreshSpouse() {
        SwingUtilities.invokeLater(() -> {
            String sql = "SELECT * FROM `TblSpouse_Info` WHERE `spouse_id` = ?;";
            
            try {
                PreparedStatement ps = DBConn.getConn().prepareStatement(sql);
            
                // set the string as the input in the search box
                ps.setString(1, viewMore_searchBox.getText());
                ResultSet rs = ps.executeQuery();
                
                if (rs.next()) {
                    spouse_surname.setText(rs.getString("spouse_lname"));
                    spouse_firstName.setText(rs.getString("spouse_fname"));
                    spouse_middleName.setText(rs.getString("spouse_mname"));
                    spouse_nameExt.setSelectedItem(rs.getString("spouse_extname"));
                    spouse_occuReal.setText(rs.getString("spouse_occu"));
                    spouse_contactnum.setText(rs.getString("spouse_tel"));
                }
            } catch(SQLException ex) {
                JOptionPane.showMessageDialog(this, ex, "Error!", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
    
    private void refreshChild() {
        SwingUtilities.invokeLater(() -> {
            String sql = "SELECT * FROM `TblChildren_Info` WHERE `child_id` = ?";
            
            try {
                PreparedStatement ps = DBConn.getConn().prepareStatement(sql);
            
                // set the string as the input in the search box
                ps.setString(1, viewMore_searchBox.getText());
                ResultSet rs = ps.executeQuery();
                
                if (rs.next()) {
                    child_surname.setText(rs.getString("child_lname"));
                    child_firstname.setText(rs.getString("child_fname"));
                    child_midname.setText(rs.getString("child_extname"));
                    child_DOB.setText(rs.getString("bdate"));
                }
            } catch(SQLException ex) {
                JOptionPane.showMessageDialog(this, ex, "Error!", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
    
    private void refreshParents() {
        SwingUtilities.invokeLater(() -> {
            String sql = "SELECT * FROM `TblParents_Info` WHERE `parents_id` = ?";
            
            try {
                PreparedStatement ps = DBConn.getConn().prepareStatement(sql);
            
                // set the string as the input in the search box
                ps.setString(1, viewMore_searchBox.getText());
                ResultSet rs = ps.executeQuery();
                
                if (rs.next()) {
                    // father
                    father_surname.setText(rs.getString("father_lname"));
                    father_fname.setText(rs.getString("father_fname"));
                    father_mname.setText(rs.getString("father_mname"));
                    father_nameExt.setSelectedItem(rs.getString("father_extname"));
                    
                    // mother
                    mother_surname.setText(rs.getString("mother_lname"));
                    mother_firstname.setText(rs.getString("mother_fname"));
                    mother_middlename.setText(rs.getString("mother_mname"));
                }
            } catch(SQLException ex) {
                JOptionPane.showMessageDialog(this, ex, "Error!", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
    
    private void refreshJobDetails() {
        SwingUtilities.invokeLater(() -> {
            String sql = "SELECT * FROM `TblEmployee_Occupation` WHERE `emoccu_id` = ?";
            
            try {
                PreparedStatement ps = DBConn.getConn().prepareStatement(sql);
            
                // set the string as the input in the search box
                ps.setString(1, viewMore_searchBox.getText());
                ResultSet rs = ps.executeQuery();
                
                if (rs.next()) {
                    job_dept.setSelectedItem(rs.getString("dept_title"));
                    job_post.setText(rs.getString("emp_post"));
                    job_status.setSelectedItem(rs.getString("emp_status"));
                    job_startDate.setText(rs.getString("starting_date"));
                    job_leaveDate.setText(rs.getString("leaving_date"));
                    job_titleSelector.setSelectedItem(rs.getString("salary_title"));
                    job_rate.setText(rs.getString("mon_rate"));
                }
            } catch(SQLException ex) {
                JOptionPane.showMessageDialog(this, ex, "Error!", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        viewMore_searchBox = new javax.swing.JTextField();
        viewMore_searchBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        ViewMore_UpdateBtn = new javax.swing.JButton();
        ViewMore_DeleteBtn = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        pi_surName = new javax.swing.JTextField();
        pi_firstName = new javax.swing.JTextField();
        pi_midName = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        pi_nameExt = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        pi_DOB = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        pi_pob = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        pi_civilstats = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        pi_age = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        pi_height = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        pi_weight = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        pi_bloodType = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        pi_citizenship = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        pi_religion = new javax.swing.JTextField();
        pi_genderBox = new javax.swing.JComboBox<>();
        jPanel11 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        pi_emailAdd = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        pi_telNum = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        pi_mobNum = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        pi_permaAdd = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        pi_resiAdd = new javax.swing.JTextArea();
        pi_sss = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        pi_gsis = new javax.swing.JTextField();
        pi_pagibig = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        pi_philhealth = new javax.swing.JTextField();
        pi_sssID = new javax.swing.JTextField();
        pi_tin = new javax.swing.JTextField();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        elem_schlname = new javax.swing.JTextField();
        elem_schladd = new javax.swing.JTextField();
        elem_yeargrad = new javax.swing.JTextField();
        jPanel20 = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        sec_yeargrad = new javax.swing.JLabel();
        sec_schlname = new javax.swing.JTextField();
        sec_schladd = new javax.swing.JTextField();
        sec_yearReal = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        ter_schlname = new javax.swing.JTextField();
        ter_schladd = new javax.swing.JTextField();
        ter_degree = new javax.swing.JTextField();
        jLabel80 = new javax.swing.JLabel();
        ter_yeargrad = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        child_surname = new javax.swing.JTextField();
        child_firstname = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        child_midname = new javax.swing.JTextField();
        child_nameExt = new javax.swing.JComboBox<>();
        jLabel51 = new javax.swing.JLabel();
        child_DOB = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        father_surname = new javax.swing.JTextField();
        father_nameExt = new javax.swing.JComboBox<>();
        jLabel58 = new javax.swing.JLabel();
        father_fname = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        father_mname = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        mother_surname = new javax.swing.JTextField();
        mother_firstname = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        mother_middlename = new javax.swing.JTextField();
        jPanel17 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        spouse_surname = new javax.swing.JTextField();
        spouse_firstName = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        spouse_middleName = new javax.swing.JTextField();
        spouse_nameExt = new javax.swing.JComboBox<>();
        jLabel65 = new javax.swing.JLabel();
        spouse_occuReal = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        spouse_contactnum = new javax.swing.JTextField();
        jPanel22 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        job_startDate = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        job_post = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        job_status = new javax.swing.JComboBox<>();
        jLabel86 = new javax.swing.JLabel();
        job_leaveDate = new javax.swing.JTextField();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        job_rate = new javax.swing.JTextField();
        job_titleSelector = new javax.swing.JComboBox<>();
        job_dept = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 187, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel1.setText("EMPLOYEE RECORDS");

        jLabel16.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel16.setText("Employee ID");

        viewMore_searchBox.setBackground(new java.awt.Color(242, 242, 242));
        viewMore_searchBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewMore_searchBoxActionPerformed(evt);
            }
        });

        viewMore_searchBtn.setBackground(new java.awt.Color(56, 99, 188));
        viewMore_searchBtn.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        viewMore_searchBtn.setForeground(new java.awt.Color(255, 255, 255));
        viewMore_searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-search-more-24.png"))); // NOI18N
        viewMore_searchBtn.setText("SEARCH");
        viewMore_searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewMore_searchBtnActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ACTIONS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(102, 153, 255))); // NOI18N

        ViewMore_UpdateBtn.setBackground(new java.awt.Color(56, 99, 188));
        ViewMore_UpdateBtn.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        ViewMore_UpdateBtn.setForeground(new java.awt.Color(255, 255, 255));
        ViewMore_UpdateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-inscription-24.png"))); // NOI18N
        ViewMore_UpdateBtn.setText("UPDATE");
        ViewMore_UpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewMore_UpdateBtnActionPerformed(evt);
            }
        });

        ViewMore_DeleteBtn.setBackground(new java.awt.Color(56, 99, 188));
        ViewMore_DeleteBtn.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        ViewMore_DeleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        ViewMore_DeleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-trash-32.png"))); // NOI18N
        ViewMore_DeleteBtn.setText("DELETE");
        ViewMore_DeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewMore_DeleteBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(ViewMore_UpdateBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ViewMore_DeleteBtn)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ViewMore_UpdateBtn)
                    .addComponent(ViewMore_DeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPane2.setForeground(new java.awt.Color(56, 99, 188));
        jTabbedPane2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 51, 153), new java.awt.Color(0, 0, 0)));

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 51, 153), null), "Primary", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI Semibold", 0, 12), new java.awt.Color(51, 153, 255))); // NOI18N
        jPanel8.setToolTipText("Name");

        jLabel19.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel19.setText("Surname");

        jLabel20.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel20.setText("First Name");

        jLabel21.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel21.setText("Middle Name");

        pi_surName.setBackground(new java.awt.Color(241, 241, 241));
        pi_surName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pi_surNameActionPerformed(evt);
            }
        });

        pi_firstName.setBackground(new java.awt.Color(241, 241, 241));

        pi_midName.setBackground(new java.awt.Color(241, 241, 241));

        jLabel22.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel22.setText("Name Ext.");

        pi_nameExt.setBackground(new java.awt.Color(241, 241, 241));
        pi_nameExt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Jr.", "Sr." }));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel19)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pi_nameExt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pi_surName, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                    .addComponent(pi_firstName)
                    .addComponent(pi_midName))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(pi_surName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(pi_firstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(pi_midName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(pi_nameExt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 51, 102), null), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 0, 13), new java.awt.Color(0, 145, 213))); // NOI18N

        jLabel23.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel23.setText("Date of Birth");

        pi_DOB.setBackground(new java.awt.Color(241, 241, 241));

        jLabel24.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel24.setText("Place of Birth");

        pi_pob.setBackground(new java.awt.Color(241, 241, 241));

        jLabel25.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel25.setText("Gender");

        jLabel26.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel26.setText("Civil Status");

        pi_civilstats.setBackground(new java.awt.Color(241, 241, 241));
        pi_civilstats.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single", "Married", "Widowed", "Separated" }));

        jLabel28.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel28.setText("Age");

        pi_age.setBackground(new java.awt.Color(241, 241, 241));

        jLabel29.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel29.setText("Height (m)");

        pi_height.setBackground(new java.awt.Color(241, 241, 241));

        jLabel30.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel30.setText("Weight (kg)");

        pi_weight.setBackground(new java.awt.Color(241, 241, 241));
        pi_weight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pi_weightActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel31.setText("Blood Type");

        pi_bloodType.setBackground(new java.awt.Color(241, 241, 241));
        pi_bloodType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pi_bloodTypeActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel32.setText("Citizenship");

        pi_citizenship.setBackground(new java.awt.Color(241, 241, 241));

        jLabel33.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel33.setText("Religion");

        pi_religion.setBackground(new java.awt.Color(241, 241, 241));

        pi_genderBox.setBackground(new java.awt.Color(241, 241, 241));
        pi_genderBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", " " }));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pi_DOB, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(pi_civilstats, javax.swing.GroupLayout.Alignment.LEADING, 0, 170, Short.MAX_VALUE)
                                .addComponent(pi_pob, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pi_height, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pi_age, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pi_weight, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pi_bloodType, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                            .addComponent(pi_genderBox, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pi_citizenship)
                            .addComponent(pi_religion, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))))
                .addContainerGap(239, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pi_DOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(pi_pob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(pi_genderBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(pi_civilstats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(pi_age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(pi_bloodType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(pi_height, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(pi_weight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(pi_citizenship, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pi_religion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 51, 102), null), "Contact Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Semibold", 1, 12), new java.awt.Color(0, 145, 213))); // NOI18N

        jLabel34.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel34.setText("Residential Address");

        jLabel35.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel35.setText("Permanent Address");

        jLabel36.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel36.setText("Email Address");

        pi_emailAdd.setBackground(new java.awt.Color(241, 241, 241));
        pi_emailAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pi_emailAddActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel37.setText("Telephone No.");

        pi_telNum.setBackground(new java.awt.Color(241, 241, 241));

        jLabel38.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel38.setText("Mobile No.");

        pi_mobNum.setBackground(new java.awt.Color(241, 241, 241));
        pi_mobNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pi_mobNumActionPerformed(evt);
            }
        });

        pi_permaAdd.setBackground(new java.awt.Color(241, 241, 241));
        pi_permaAdd.setColumns(20);
        pi_permaAdd.setRows(5);
        jScrollPane1.setViewportView(pi_permaAdd);

        pi_resiAdd.setBackground(new java.awt.Color(241, 241, 241));
        pi_resiAdd.setColumns(20);
        pi_resiAdd.setRows(5);
        jScrollPane2.setViewportView(pi_resiAdd);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel34))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel37)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pi_telNum, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                            .addComponent(pi_mobNum)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(pi_emailAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 18, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pi_emailAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pi_telNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pi_mobNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pi_sss.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 51, 153), null), "Other Information", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI Semibold", 0, 12), new java.awt.Color(51, 153, 255))); // NOI18N
        pi_sss.setToolTipText("Name");

        jLabel39.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel39.setText("GSIS ID No.");

        jLabel40.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel40.setText("PAG-IBIG ID No.");

        pi_gsis.setBackground(new java.awt.Color(241, 241, 241));
        pi_gsis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pi_gsisActionPerformed(evt);
            }
        });

        pi_pagibig.setBackground(new java.awt.Color(241, 241, 241));
        pi_pagibig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pi_pagibigActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel41.setText("PHILHEALTH No.");

        jLabel42.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel42.setText("SSS No.");

        jLabel43.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel43.setText("TIN No.");

        pi_philhealth.setBackground(new java.awt.Color(241, 241, 241));

        pi_sssID.setBackground(new java.awt.Color(241, 241, 241));

        pi_tin.setBackground(new java.awt.Color(241, 241, 241));

        javax.swing.GroupLayout pi_sssLayout = new javax.swing.GroupLayout(pi_sss);
        pi_sss.setLayout(pi_sssLayout);
        pi_sssLayout.setHorizontalGroup(
            pi_sssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pi_sssLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pi_sssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pi_sssLayout.createSequentialGroup()
                        .addGroup(pi_sssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41)
                            .addComponent(jLabel42)
                            .addComponent(jLabel43))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pi_sssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pi_sssID)
                            .addComponent(pi_tin)
                            .addComponent(pi_philhealth)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pi_sssLayout.createSequentialGroup()
                        .addGroup(pi_sssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40)
                            .addComponent(jLabel39))
                        .addGap(18, 18, 18)
                        .addGroup(pi_sssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pi_gsis, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pi_pagibig, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(23, 23, 23))
        );
        pi_sssLayout.setVerticalGroup(
            pi_sssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pi_sssLayout.createSequentialGroup()
                .addGroup(pi_sssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(pi_gsis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pi_sssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(pi_pagibig, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pi_sssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(pi_philhealth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pi_sssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(pi_sssID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pi_sssLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(pi_tin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pi_sss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(7, 7, 7)
                        .addComponent(pi_sss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addGap(66, 66, 66))
        );

        jTabbedPane2.addTab("Personal Information", jPanel4);

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 51, 153), null), "Elementary", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI Semibold", 0, 12), new java.awt.Color(51, 153, 255))); // NOI18N
        jPanel19.setToolTipText("Name");

        jLabel69.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel69.setText("Name of School");

        jLabel70.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel70.setText("School Address");

        jLabel71.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel71.setText("Year Graduated");

        elem_schlname.setBackground(new java.awt.Color(241, 241, 241));
        elem_schlname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elem_schlnameActionPerformed(evt);
            }
        });

        elem_schladd.setBackground(new java.awt.Color(241, 241, 241));

        elem_yeargrad.setBackground(new java.awt.Color(241, 241, 241));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel69, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel71)
                    .addComponent(jLabel70, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(elem_yeargrad, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(elem_schlname, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE)
                    .addComponent(elem_schladd))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel69)
                    .addComponent(elem_schlname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel70)
                    .addComponent(elem_schladd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel71)
                    .addComponent(elem_yeargrad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 51, 153), null), "Secondary", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI Semibold", 0, 12), new java.awt.Color(51, 153, 255))); // NOI18N
        jPanel20.setToolTipText("Name");

        jLabel73.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel73.setText("Name of School");

        jLabel74.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel74.setText("School Address");

        sec_yeargrad.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        sec_yeargrad.setText("Year Graduated");

        sec_schlname.setBackground(new java.awt.Color(241, 241, 241));
        sec_schlname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sec_schlnameActionPerformed(evt);
            }
        });

        sec_schladd.setBackground(new java.awt.Color(241, 241, 241));

        sec_yearReal.setBackground(new java.awt.Color(241, 241, 241));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel73, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sec_yeargrad)
                    .addComponent(jLabel74, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sec_yearReal, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sec_schlname, javax.swing.GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
                    .addComponent(sec_schladd))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel73)
                    .addComponent(sec_schlname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel74)
                    .addComponent(sec_schladd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sec_yeargrad)
                    .addComponent(sec_yearReal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 51, 153), null), "Tertiary", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI Semibold", 0, 12), new java.awt.Color(51, 153, 255))); // NOI18N
        jPanel21.setToolTipText("Name");

        jLabel77.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel77.setText("Name of School");

        jLabel78.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel78.setText("School Address");

        jLabel79.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel79.setText("Degree/Course");

        ter_schlname.setBackground(new java.awt.Color(241, 241, 241));
        ter_schlname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ter_schlnameActionPerformed(evt);
            }
        });

        ter_schladd.setBackground(new java.awt.Color(241, 241, 241));

        ter_degree.setBackground(new java.awt.Color(241, 241, 241));

        jLabel80.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel80.setText("Year Graduated");

        ter_yeargrad.setBackground(new java.awt.Color(241, 241, 241));

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel77, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel79)
                    .addComponent(jLabel80)
                    .addComponent(jLabel78, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ter_yeargrad, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ter_schlname, javax.swing.GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)
                    .addComponent(ter_schladd)
                    .addComponent(ter_degree))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel77)
                    .addComponent(ter_schlname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel78)
                    .addComponent(ter_schladd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel79)
                    .addComponent(ter_degree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel80)
                    .addComponent(ter_yeargrad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Educational Background", jPanel18);

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 51, 153), null), "Children Information", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI Semibold", 0, 12), new java.awt.Color(51, 153, 255))); // NOI18N
        jPanel13.setToolTipText("Name");

        jLabel46.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel46.setText("Surname");

        jLabel47.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel47.setText("First Name");

        jLabel48.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel48.setText("Middle Name");

        child_surname.setBackground(new java.awt.Color(241, 241, 241));
        child_surname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                child_surnameActionPerformed(evt);
            }
        });

        child_firstname.setBackground(new java.awt.Color(241, 241, 241));

        jLabel49.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel49.setText("Name Ext.");

        child_midname.setBackground(new java.awt.Color(241, 241, 241));

        child_nameExt.setBackground(new java.awt.Color(241, 241, 241));
        child_nameExt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Jr.", "Sr." }));

        jLabel51.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel51.setText("Date of Birth");

        child_DOB.setBackground(new java.awt.Color(241, 241, 241));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(child_surname, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel47)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(child_firstname, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel48)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(child_midname, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel49)
                        .addGap(18, 18, 18)
                        .addComponent(child_nameExt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(child_DOB, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(child_surname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(child_firstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(child_midname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(child_nameExt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(child_DOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "Parent's' Information", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Symbol", 1, 12), new java.awt.Color(51, 153, 255))); // NOI18N

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 51, 153), null), "Father's Information", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI Semibold", 0, 12), new java.awt.Color(51, 153, 255))); // NOI18N
        jPanel14.setToolTipText("Name");

        jLabel55.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel55.setText("Father's Surname");

        jLabel56.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel56.setText("Father's First Name");

        father_surname.setBackground(new java.awt.Color(241, 241, 241));

        father_nameExt.setBackground(new java.awt.Color(241, 241, 241));
        father_nameExt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Jr.", "Sr." }));
        father_nameExt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                father_nameExtActionPerformed(evt);
            }
        });

        jLabel58.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel58.setText("Father's Name Ext.");

        father_fname.setBackground(new java.awt.Color(241, 241, 241));

        jLabel53.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel53.setText("Father's Middle Name");

        father_mname.setBackground(new java.awt.Color(241, 241, 241));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel55)
                            .addComponent(jLabel56))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(father_surname, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(father_fname)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel58))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(father_nameExt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(father_mname, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel55)
                    .addComponent(father_surname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(father_fname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(father_mname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(father_nameExt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 51, 153), null), "Mother's Maiden Name", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI Semibold", 0, 12), new java.awt.Color(51, 153, 255))); // NOI18N
        jPanel16.setToolTipText("Name");

        jLabel57.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel57.setText("Mother's Surname");

        jLabel59.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel59.setText("Mother's First Name");

        mother_surname.setBackground(new java.awt.Color(241, 241, 241));
        mother_surname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mother_surnameActionPerformed(evt);
            }
        });

        mother_firstname.setBackground(new java.awt.Color(241, 241, 241));

        jLabel54.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel54.setText("Mother's Middle Name");

        mother_middlename.setBackground(new java.awt.Color(241, 241, 241));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel57)
                            .addComponent(jLabel59))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(mother_surname, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(mother_firstname)))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mother_middlename, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel57)
                    .addComponent(mother_surname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mother_firstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(mother_middlename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 22, Short.MAX_VALUE))
        );

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 51, 153), null), "Spouse Information", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI Semibold", 0, 12), new java.awt.Color(51, 153, 255))); // NOI18N
        jPanel17.setToolTipText("Name");

        jLabel60.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel60.setText("Surname");

        jLabel61.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel61.setText("First Name");

        jLabel62.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel62.setText("Middle Name");

        spouse_surname.setBackground(new java.awt.Color(241, 241, 241));
        spouse_surname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spouse_surnameActionPerformed(evt);
            }
        });

        spouse_firstName.setBackground(new java.awt.Color(241, 241, 241));

        jLabel63.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel63.setText("Name Ext.");

        spouse_middleName.setBackground(new java.awt.Color(241, 241, 241));

        spouse_nameExt.setBackground(new java.awt.Color(241, 241, 241));
        spouse_nameExt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Jr.", "Sr." }));

        jLabel65.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel65.setText("Occupation");

        spouse_occuReal.setBackground(new java.awt.Color(241, 241, 241));

        jLabel66.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel66.setText("Contact No.");

        spouse_contactnum.setBackground(new java.awt.Color(241, 241, 241));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel62)
                            .addComponent(jLabel63))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spouse_nameExt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spouse_middleName, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel66, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel65, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(spouse_occuReal)
                            .addComponent(spouse_contactnum, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel60)
                        .addGap(18, 18, 18)
                        .addComponent(spouse_surname, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel61)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spouse_firstName, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60)
                    .addComponent(spouse_surname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spouse_firstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62)
                    .addComponent(spouse_middleName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63)
                    .addComponent(spouse_nameExt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65)
                    .addComponent(spouse_occuReal, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66)
                    .addComponent(spouse_contactnum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Family Background", jPanel12);

        jPanel25.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel82.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel82.setText("Position");

        jLabel83.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel83.setText("Job Department");

        job_startDate.setBackground(new java.awt.Color(241, 241, 241));
        job_startDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                job_startDateActionPerformed(evt);
            }
        });

        jLabel84.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel84.setText("Start Date");

        job_post.setBackground(new java.awt.Color(241, 241, 241));
        job_post.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                job_postActionPerformed(evt);
            }
        });

        jLabel85.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel85.setText("Status");

        job_status.setBackground(new java.awt.Color(241, 241, 241));
        job_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Unpaid Leave of Absence", "Paid Leave of Absence", "Suspended", "Terminated", "Resigned", "Deceased", "Retiree", " " }));

        jLabel86.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel86.setText("Leave Date");

        job_leaveDate.setBackground(new java.awt.Color(241, 241, 241));
        job_leaveDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                job_leaveDateActionPerformed(evt);
            }
        });

        jLabel88.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel88.setText("Salary Title");

        jLabel89.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel89.setText("Monthly Rate");

        job_rate.setBackground(new java.awt.Color(241, 241, 241));
        job_rate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                job_rateActionPerformed(evt);
            }
        });

        job_titleSelector.setBackground(new java.awt.Color(241, 241, 241));
        job_titleSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SG 1", "SG 2", "SG 3", "SG 4", "SG 5", "SG 6", "SG 7", "SG 8", "SG 9", "SG 10", "SG 11", "SG 12", "SG 13", "SG 14", "SG 15", "SG 16", "SG 17", "SG 18", "SG 19", "SG 20", "SG 21", "SG 22", "SG 23", "SG 24", "SG 25", "SG 26", "SG 27", "SG 28", "SG 29", "SG 30", "SG 31", "SG 32", "SG 33" }));

        job_dept.setBackground(new java.awt.Color(241, 241, 241));
        job_dept.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Human Resources", "Operations Management", "Information Technology", "Marketing/Sales", "Accounting and Finance", "Research and Development", "Manufacturing", "Procurement", "Legal" }));

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel25Layout.createSequentialGroup()
                        .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(job_startDate, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(job_post, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(job_status, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(job_dept, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(job_leaveDate, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(job_titleSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(job_rate, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(139, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel83)
                    .addComponent(job_dept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel82)
                    .addComponent(job_post, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel85)
                    .addComponent(job_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel84)
                    .addComponent(job_startDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel86)
                    .addComponent(job_leaveDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel88)
                    .addComponent(job_titleSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(job_rate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel89))
                .addContainerGap(103, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(269, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Employment Details", jPanel22);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 936, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(44, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(viewMore_searchBox, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(viewMore_searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(viewMore_searchBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(viewMore_searchBtn)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bg.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 620));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewMore_searchBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewMore_searchBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewMore_searchBoxActionPerformed

    private void viewMore_searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewMore_searchBtnActionPerformed
        SwingUtilities.invokeLater(() -> {
            refreshPersonalInfo();
            refreshEducDetails();
            refreshSpouse();
            refreshChild();
            refreshParents();
            refreshJobDetails();
        });
    }//GEN-LAST:event_viewMore_searchBtnActionPerformed

    private void pi_surNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pi_surNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pi_surNameActionPerformed

    private void pi_weightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pi_weightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pi_weightActionPerformed

    private void pi_bloodTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pi_bloodTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pi_bloodTypeActionPerformed

    private void pi_emailAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pi_emailAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pi_emailAddActionPerformed

    private void pi_mobNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pi_mobNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pi_mobNumActionPerformed

    private void pi_gsisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pi_gsisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pi_gsisActionPerformed

    private void pi_pagibigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pi_pagibigActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pi_pagibigActionPerformed

    private void elem_schlnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elem_schlnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_elem_schlnameActionPerformed

    private void sec_schlnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sec_schlnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sec_schlnameActionPerformed

    private void ter_schlnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ter_schlnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ter_schlnameActionPerformed

    private void child_surnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_child_surnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_child_surnameActionPerformed

    private void father_nameExtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_father_nameExtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_father_nameExtActionPerformed

    private void spouse_surnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spouse_surnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_spouse_surnameActionPerformed

    private void job_startDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_job_startDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_job_startDateActionPerformed

    private void job_postActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_job_postActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_job_postActionPerformed

    private void job_leaveDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_job_leaveDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_job_leaveDateActionPerformed

    private void job_rateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_job_rateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_job_rateActionPerformed

    private void mother_surnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mother_surnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mother_surnameActionPerformed

    private void ViewMore_UpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewMore_UpdateBtnActionPerformed
        // update the db
        SwingUtilities.invokeLater(() -> {
            String[] persoInfo = {
                pi_surName.getText(),
                pi_firstName.getText(),
                pi_midName.getText(),
                pi_nameExt.getSelectedItem().toString(),
                pi_genderBox.getSelectedItem().toString(),
                
                pi_height.getText(),
                pi_weight.getText(),
                pi_bloodType.getText(),
                pi_civilstats.getSelectedItem().toString(),
                pi_DOB.getText(),
                pi_pob.getText(), 
                pi_age.getText(),
                pi_religion.getText(),
                pi_citizenship.getText(),
                
                pi_resiAdd.getText(),
                pi_permaAdd.getText(),
                pi_emailAdd.getText(),
                pi_telNum.getText(),
                pi_mobNum.getText(),
                
                pi_gsis.getText(),
                pi_pagibig.getText(),
                pi_philhealth.getText(),
                pi_sssID.getText(),
                pi_tin.getText(),
                
                viewMore_searchBox.getText()
            };
            
            String[] dataEduc = {
                elem_schlname.getText(),
                elem_schladd.getText(),
                elem_yeargrad.getText(),
                sec_schlname.getText(),
                sec_schladd.getText(),
                sec_yearReal.getText(),
                ter_schlname.getText(),
                ter_schladd.getText(),
                ter_degree.getText(),
                ter_yeargrad.getText(),
                viewMore_searchBox.getText()
            };
            
            String[] dataSpouse = {
                spouse_surname.getText(),
                spouse_firstName.getText(),
                spouse_middleName.getText(),
                spouse_nameExt.getSelectedItem().toString(),
                spouse_occuReal.getText(),
                spouse_contactnum.getText(),
                viewMore_searchBox.getText()
            };
            
            String[] dataChild = {
                child_surname.getText(),
                child_firstname.getText(),
                child_midname.getText(),
                child_nameExt.getSelectedItem().toString(),
                child_DOB.getText(),
                viewMore_searchBox.getText()
            };
            
            String[] dataParents = {
                father_surname.getText(),
                father_fname.getText(),
                father_mname.getText(),
                father_nameExt.getSelectedItem().toString(),
                mother_surname.getText(),
                mother_firstname.getText(),
                mother_middlename.getText(),
                viewMore_searchBox.getText()
            };
            
            String[] dataOccu = {
                job_dept.getSelectedItem().toString(),
                job_post.getText(),
                job_status.getSelectedItem().toString(),
                job_startDate.getText(),
                job_leaveDate.getText(),
                job_titleSelector.getSelectedItem().toString(),
                job_rate.getText(),
                viewMore_searchBox.getText()
            };
            
            // update personal info
            EmployeePersonalInfo.update(persoInfo, this);
            // update employee info
            EmployeeEducationInfo.update(dataEduc, this);
            // update spouse
            EmployeeSpouseInfo.update(dataSpouse, this);
            // update children
            EmployeeChildData.update(dataChild, this);
            // update parent
            EmployeeParentsInfo.update(dataParents, this);
            // update occupation
            EmployeeOccupationInfo.update(dataOccu, this);
            
            // refresh other frame
            SwingUtilities.invokeLater(() -> {
                view.updateEmployeeTableView();
            });
        });

        JOptionPane.showMessageDialog(this, "Successfuly updated!", "Success!", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_ViewMore_UpdateBtnActionPerformed

    private void ViewMore_DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewMore_DeleteBtnActionPerformed
        // refresh other frame
        SwingUtilities.invokeLater(() -> {
            EmployeePersonalInfo.delete(this, viewMore_searchBox.getText());
            view.updateEmployeeTableView();
            resetFields();
        });
        
         JOptionPane.showMessageDialog(this, "Successfuly deleted!", "Success!", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_ViewMore_DeleteBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ViewMore_DeleteBtn;
    private javax.swing.JButton ViewMore_UpdateBtn;
    private javax.swing.JPanel bg;
    private javax.swing.JTextField child_DOB;
    private javax.swing.JTextField child_firstname;
    private javax.swing.JTextField child_midname;
    private javax.swing.JComboBox<String> child_nameExt;
    private javax.swing.JTextField child_surname;
    private javax.swing.JTextField elem_schladd;
    private javax.swing.JTextField elem_schlname;
    private javax.swing.JTextField elem_yeargrad;
    private javax.swing.JTextField father_fname;
    private javax.swing.JTextField father_mname;
    private javax.swing.JComboBox<String> father_nameExt;
    private javax.swing.JTextField father_surname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JComboBox<String> job_dept;
    private javax.swing.JTextField job_leaveDate;
    private javax.swing.JTextField job_post;
    private javax.swing.JTextField job_rate;
    private javax.swing.JTextField job_startDate;
    private javax.swing.JComboBox<String> job_status;
    private javax.swing.JComboBox<String> job_titleSelector;
    private javax.swing.JTextField mother_firstname;
    private javax.swing.JTextField mother_middlename;
    private javax.swing.JTextField mother_surname;
    private javax.swing.JTextField pi_DOB;
    private javax.swing.JTextField pi_age;
    private javax.swing.JTextField pi_bloodType;
    private javax.swing.JTextField pi_citizenship;
    private javax.swing.JComboBox<String> pi_civilstats;
    private javax.swing.JTextField pi_emailAdd;
    private javax.swing.JTextField pi_firstName;
    private javax.swing.JComboBox<String> pi_genderBox;
    private javax.swing.JTextField pi_gsis;
    private javax.swing.JTextField pi_height;
    private javax.swing.JTextField pi_midName;
    private javax.swing.JTextField pi_mobNum;
    private javax.swing.JComboBox<String> pi_nameExt;
    private javax.swing.JTextField pi_pagibig;
    private javax.swing.JTextArea pi_permaAdd;
    private javax.swing.JTextField pi_philhealth;
    private javax.swing.JTextField pi_pob;
    private javax.swing.JTextField pi_religion;
    private javax.swing.JTextArea pi_resiAdd;
    private javax.swing.JPanel pi_sss;
    private javax.swing.JTextField pi_sssID;
    private javax.swing.JTextField pi_surName;
    private javax.swing.JTextField pi_telNum;
    private javax.swing.JTextField pi_tin;
    private javax.swing.JTextField pi_weight;
    private javax.swing.JTextField sec_schladd;
    private javax.swing.JTextField sec_schlname;
    private javax.swing.JTextField sec_yearReal;
    private javax.swing.JLabel sec_yeargrad;
    private javax.swing.JTextField spouse_contactnum;
    private javax.swing.JTextField spouse_firstName;
    private javax.swing.JTextField spouse_middleName;
    private javax.swing.JComboBox<String> spouse_nameExt;
    private javax.swing.JTextField spouse_occuReal;
    private javax.swing.JTextField spouse_surname;
    private javax.swing.JTextField ter_degree;
    private javax.swing.JTextField ter_schladd;
    private javax.swing.JTextField ter_schlname;
    private javax.swing.JTextField ter_yeargrad;
    private javax.swing.JTextField viewMore_searchBox;
    private javax.swing.JButton viewMore_searchBtn;
    // End of variables declaration//GEN-END:variables
}
