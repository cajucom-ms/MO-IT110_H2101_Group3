/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Jframes;

import java.math.BigDecimal;

/**
 *
 * @author User
 */
public class ViewSingleEmployee extends javax.swing.JFrame {
    
    private String userID;

    /**
     * Creates new form leaveRequestHistory
     */
    
    // Default constructor
    public ViewSingleEmployee(String userID) {
        this.userID = userID;
        initComponents();
        // Set default or empty values for form fields
        jLastName.setText("");
        jFirstName.setText("");
        jBirthday.setText("");
        jAddress.setText("");
        jPhoneNumber.setText("");
        jSssNumber.setText("");
        jPhilhealthNumber.setText("");
        jTinNumber.setText("");
        jPagibigNumber.setText("");
        jPosition.setText("");
        jImmediateSupervisor.setText("");
        jBasicSalary.setText("");
        jRiceSubsidy.setText("");
        jPhoneAllowance.setText("");
        jClothingAllowance.setText("");
        jGrossSemiMonthlyRate.setText("");
        jHourlyRate.setText("");
        jStatus.setText("");
    }
    
    
    // Parameterized constructor
    public ViewSingleEmployee(String userID, int employeeID, String lastName, String firstName, java.sql.Date birthday, String address,
                          String phoneNumber, String sssNumber, String philhealthNumber, String tinNumber,
                          String pagibigNumber, String status, String position, String immediateSupervisor,
                          BigDecimal basicSalary, BigDecimal riceSubsidy, BigDecimal phoneAllowance, 
                          BigDecimal clothingAllowance, BigDecimal grossSemiMonthlyRate, BigDecimal hourlyRate) {
        this.userID = userID;
        initComponents();
        
        // Set form fields with passed data
        jEmployeeID.setText(String.valueOf(employeeID));
        jLastName.setText(lastName);
        jFirstName.setText(firstName);
        jBirthday.setText(birthday.toString());
        jAddress.setText(address);
        jPhoneNumber.setText(phoneNumber);
        jSssNumber.setText(sssNumber);
        jPhilhealthNumber.setText(philhealthNumber);
        jTinNumber.setText(tinNumber);
        jPagibigNumber.setText(pagibigNumber);
        jPosition.setText(position);
        jImmediateSupervisor.setText(immediateSupervisor);
        
        
        // Convert BigDecimal values to String before setting them to text fields
        jBasicSalary.setText(basicSalary.toString());
        jRiceSubsidy.setText(riceSubsidy.toString());
        jPhoneAllowance.setText(phoneAllowance.toString());
        jClothingAllowance.setText(clothingAllowance.toString());
        jGrossSemiMonthlyRate.setText(grossSemiMonthlyRate.toString());
        jHourlyRate.setText(hourlyRate.toString());
        
        
        jStatus.setText(status.toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jFirstName = new javax.swing.JLabel();
        jBirthday = new javax.swing.JLabel();
        jPhoneNumber = new javax.swing.JLabel();
        jAddress = new javax.swing.JLabel();
        jLastName = new javax.swing.JLabel();
        jPhilhealthNumber = new javax.swing.JLabel();
        jTinNumber = new javax.swing.JLabel();
        jPagibigNumber = new javax.swing.JLabel();
        jSssNumber = new javax.swing.JLabel();
        goBackToViewAllEmployee = new Button.DarkButton();
        jHourlyRate = new javax.swing.JLabel();
        jClothingAllowance = new javax.swing.JLabel();
        jGrossSemiMonthlyRate = new javax.swing.JLabel();
        jPhoneAllowance = new javax.swing.JLabel();
        jRiceSubsidy = new javax.swing.JLabel();
        jBasicSalary = new javax.swing.JLabel();
        jStatus = new javax.swing.JLabel();
        jImmediateSupervisor = new javax.swing.JLabel();
        jEmployeeID = new javax.swing.JLabel();
        jPosition = new javax.swing.JLabel();
        button2 = new Button.Button();
        button1 = new Button.Button();
        employeeProfileBackground = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("View Single Employee");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jFirstName.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jFirstName.setForeground(new java.awt.Color(54, 117, 136));
        jFirstName.setText("Ging");
        getContentPane().add(jFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, -1, -1));

        jBirthday.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jBirthday.setForeground(new java.awt.Color(54, 117, 136));
        jBirthday.setText("Jan-01-1990");
        getContentPane().add(jBirthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 230, -1, -1));

        jPhoneNumber.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPhoneNumber.setForeground(new java.awt.Color(54, 117, 136));
        jPhoneNumber.setText("09123456789");
        getContentPane().add(jPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 170, -1, -1));

        jAddress.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jAddress.setForeground(new java.awt.Color(54, 117, 136));
        jAddress.setText("123 Luzon, Philippines");
        getContentPane().add(jAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 260, 420, -1));

        jLastName.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLastName.setForeground(new java.awt.Color(54, 117, 136));
        jLastName.setText("Lee");
        getContentPane().add(jLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 170, -1, -1));

        jPhilhealthNumber.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPhilhealthNumber.setForeground(new java.awt.Color(54, 117, 136));
        jPhilhealthNumber.setText("000123456789");
        getContentPane().add(jPhilhealthNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 420, -1, -1));

        jTinNumber.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTinNumber.setForeground(new java.awt.Color(54, 117, 136));
        jTinNumber.setText("123-456-789-000");
        getContentPane().add(jTinNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 460, -1, -1));

        jPagibigNumber.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPagibigNumber.setForeground(new java.awt.Color(54, 117, 136));
        jPagibigNumber.setText("987654321000");
        getContentPane().add(jPagibigNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 380, -1, -1));

        jSssNumber.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jSssNumber.setForeground(new java.awt.Color(54, 117, 136));
        jSssNumber.setText("00-1234567-8");
        getContentPane().add(jSssNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 340, 130, -1));

        goBackToViewAllEmployee.setText("Go Back");
        goBackToViewAllEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBackToViewAllEmployeeActionPerformed(evt);
            }
        });
        getContentPane().add(goBackToViewAllEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 80, -1, -1));

        jHourlyRate.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jHourlyRate.setForeground(new java.awt.Color(54, 117, 136));
        jHourlyRate.setText("514.00");
        getContentPane().add(jHourlyRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 500, -1, 20));

        jClothingAllowance.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jClothingAllowance.setForeground(new java.awt.Color(54, 117, 136));
        jClothingAllowance.setText("5,000.00");
        getContentPane().add(jClothingAllowance, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 420, 70, 20));

        jGrossSemiMonthlyRate.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGrossSemiMonthlyRate.setForeground(new java.awt.Color(54, 117, 136));
        jGrossSemiMonthlyRate.setText("45,000.00");
        getContentPane().add(jGrossSemiMonthlyRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 460, -1, 20));

        jPhoneAllowance.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPhoneAllowance.setForeground(new java.awt.Color(54, 117, 136));
        jPhoneAllowance.setText("5,000.00");
        getContentPane().add(jPhoneAllowance, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 380, -1, 20));

        jRiceSubsidy.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jRiceSubsidy.setForeground(new java.awt.Color(54, 117, 136));
        jRiceSubsidy.setText("5,000.00");
        getContentPane().add(jRiceSubsidy, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 340, 70, 20));

        jBasicSalary.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jBasicSalary.setForeground(new java.awt.Color(54, 117, 136));
        jBasicSalary.setText("50,000.00");
        getContentPane().add(jBasicSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 500, -1, 20));

        jStatus.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jStatus.setForeground(new java.awt.Color(54, 117, 136));
        jStatus.setText("Employed");
        getContentPane().add(jStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 200, -1, 20));

        jImmediateSupervisor.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jImmediateSupervisor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jImmediateSupervisor.setText("Allan Smith");
        getContentPane().add(jImmediateSupervisor, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 500, 130, 20));

        jEmployeeID.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jEmployeeID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jEmployeeID.setText("10001");
        getContentPane().add(jEmployeeID, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, 100, 20));

        jPosition.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jPosition.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPosition.setText("IT");
        getContentPane().add(jPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 440, 140, 20));

        button2.setText("Dashboard");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        getContentPane().add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 30));

        button1.setText("Logout");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        getContentPane().add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 10, -1, 30));

        employeeProfileBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Profile Page.png"))); // NOI18N
        employeeProfileBackground.setText("jLabel3");
        getContentPane().add(employeeProfileBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 580));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // Create an instance of the Dashboard frame
        AdminHomeDashboard dashboard = new AdminHomeDashboard(userID);
        // Set the visibility of the Dashboard frame to true
        dashboard.setVisible(true);
        // Close the Profile Page frame
        this.dispose(); // Assuming this is the Login frame
    }//GEN-LAST:event_button2ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // Create an instance of LoginNew and display it
        LogInNew loginNew = new LogInNew();
        loginNew.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_button1ActionPerformed

    private void goBackToViewAllEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackToViewAllEmployeeActionPerformed

        // Redirects to View All Employees Admin Page
        ViewAllEmployee viewAllEmployee = new ViewAllEmployee(userID);
        viewAllEmployee.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_goBackToViewAllEmployeeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewSingleEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewSingleEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewSingleEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewSingleEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Button.Button button1;
    private Button.Button button2;
    private javax.swing.JLabel employeeProfileBackground;
    private Button.DarkButton goBackToViewAllEmployee;
    private javax.swing.JLabel jAddress;
    private javax.swing.JLabel jBasicSalary;
    private javax.swing.JLabel jBirthday;
    private javax.swing.JLabel jClothingAllowance;
    private javax.swing.JLabel jEmployeeID;
    private javax.swing.JLabel jFirstName;
    private javax.swing.JLabel jGrossSemiMonthlyRate;
    private javax.swing.JLabel jHourlyRate;
    private javax.swing.JLabel jImmediateSupervisor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLastName;
    private javax.swing.JLabel jPagibigNumber;
    private javax.swing.JLabel jPhilhealthNumber;
    private javax.swing.JLabel jPhoneAllowance;
    private javax.swing.JLabel jPhoneNumber;
    private javax.swing.JLabel jPosition;
    private javax.swing.JLabel jRiceSubsidy;
    private javax.swing.JLabel jSssNumber;
    private javax.swing.JLabel jStatus;
    private javax.swing.JLabel jTinNumber;
    // End of variables declaration//GEN-END:variables
}
