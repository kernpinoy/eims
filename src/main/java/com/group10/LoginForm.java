package com.group10;

import Tables.DBConn;
import HelperClass.SaveExceptions;
import HelperClass.UserLogin;
import com.group10.AdminGUI.dashboardView;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author pam
 */
public class LoginForm extends javax.swing.JFrame {
    // SQL class
    DBConn conn = null;
    
    public LoginForm() {
        conn = new DBConn(2);
        initComponents();
        setVisible(true);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        headerMessage = new javax.swing.JLabel();
        labelUserName = new javax.swing.JLabel();
        textFieldUserName = new javax.swing.JTextField();
        labelPassword = new javax.swing.JLabel();
        chkBoxShowHidePass = new javax.swing.JCheckBox();
        btnLogin = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(400, 500));

        mainPanel.setBorder(new javax.swing.border.MatteBorder(null));

        headerPanel.setBackground(new java.awt.Color(102, 153, 255));

        headerMessage.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        headerMessage.setForeground(new java.awt.Color(255, 255, 255));
        headerMessage.setText("Welcome back!");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(headerMessage)
                .addContainerGap(177, Short.MAX_VALUE))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(headerMessage)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        labelUserName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelUserName.setForeground(new java.awt.Color(153, 153, 153));
        labelUserName.setText("Username");

        textFieldUserName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textFieldUserName.setForeground(new java.awt.Color(153, 153, 153));

        labelPassword.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelPassword.setForeground(new java.awt.Color(153, 153, 153));
        labelPassword.setText("Password");

        chkBoxShowHidePass.setText(" Show password");
        chkBoxShowHidePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkBoxShowHidePassActionPerformed(evt);
            }
        });

        btnLogin.setBackground(new java.awt.Color(102, 153, 255));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        passwordField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        passwordField.setForeground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelUserName)
                    .addComponent(labelPassword)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkBoxShowHidePass))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(labelUserName)
                .addGap(18, 18, 18)
                .addComponent(textFieldUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelPassword)
                .addGap(18, 18, 18)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(chkBoxShowHidePass)
                .addGap(18, 18, 18)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 87, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chkBoxShowHidePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkBoxShowHidePassActionPerformed
        if (chkBoxShowHidePass.isSelected()) {
            passwordField.setEchoChar((char) 0);
        } else {
            passwordField.setEchoChar('*');
        }
    }//GEN-LAST:event_chkBoxShowHidePassActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        UserLogin.setUsername(textFieldUserName.getText());
        UserLogin.setPassword(String.valueOf(passwordField.getPassword()));
        
        if (UserLogin.getUsername().isBlank() || UserLogin.getPassword().isBlank()) {
            JOptionPane.showMessageDialog(this, "Username or password field cannot be blank!", 
                    "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // check if zero, bring the admin dashboard
        switch(DBConn.login(UserLogin.getUsername(), UserLogin.getPassword())) {
            case 0 -> {
                SwingUtilities.invokeLater(() -> {
                    // spawn Admin_Dashboard
                    new dashboardView().setVisible(true);
                    this.dispose();
                });
            }
            
            default -> JOptionPane.showMessageDialog(this, "Invalid username/password!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JCheckBox chkBoxShowHidePass;
    private javax.swing.JLabel headerMessage;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelUserName;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField textFieldUserName;
    // End of variables declaration//GEN-END:variables
}
