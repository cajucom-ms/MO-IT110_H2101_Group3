package Jframes;

import Classes.db; // Import the db class
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;


public class OvertimeRequestAdmin extends javax.swing.JFrame {

    private String userID;
    
    public OvertimeRequestAdmin(String userID) {
        this.userID = userID;
        initComponents();
        fetchData();
    }
    
    public void fetchData(){
        
        try {
            // Get the connection from db class
            Connection con = db.mycon();
        
            // Check if the connection to db class is successful
            if(con != null){
                // Create a Statement
                Statement st = con.createStatement();
                
                // Execute a query to retrieve data from the overtime_requests.sql
                String query = "SELECT * FROM overtime_requests";
                ResultSet rs = st.executeQuery(query);
                
                // Get the table model from tblOvertime
                DefaultTableModel model = (DefaultTableModel) tblOvertime.getModel();
                model.setRowCount(0); // Clear existing data
                
                // Add rows to the table model
                while(rs.next()){
                    model.addRow(new Object[]{
                        rs.getString("status"),
                        rs.getString("requestedDate"),
                        rs.getString("employeeID"),
                        rs.getString("employeeName"),
                        rs.getString("overtimeDate"),
                        rs.getString("startTime"),
                        rs.getString("endTime"),
                        rs.getString("totalHours"),
                        rs.getString("reason")                        
                    });
                }
                
                // Close the connection
                rs.close();
                st.close();
                con.close();
            } else {
                    System.out.println("Unable to get connection!");
            }           
        } catch(Exception e){
            e.printStackTrace();
        }
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnDashboard = new Button.Button();
        btnLogout = new Button.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOvertime = new javax.swing.JTable();
        txtEmployeeID = new javax.swing.JTextField();
        btnEmployeeID = new Button.DarkButton();
        labelEmployeeID = new javax.swing.JLabel();
        darkButton1 = new Button.DarkButton();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnDashboard.setText("Dashboard");
        btnDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDashboardActionPerformed(evt);
            }
        });
        getContentPane().add(btnDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 30));

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(919, 10, 100, 30));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        tblOvertime.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Status", "Requested Date", "Employee ID", "Employee Name", "Date of Overtime", "Start Time", "End Time", "Total Hour/s", "Reason"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblOvertime.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(tblOvertime);
        if (tblOvertime.getColumnModel().getColumnCount() > 0) {
            tblOvertime.getColumnModel().getColumn(0).setPreferredWidth(125);
            tblOvertime.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblOvertime.getColumnModel().getColumn(2).setPreferredWidth(125);
            tblOvertime.getColumnModel().getColumn(3).setPreferredWidth(150);
            tblOvertime.getColumnModel().getColumn(4).setPreferredWidth(125);
            tblOvertime.getColumnModel().getColumn(5).setPreferredWidth(125);
            tblOvertime.getColumnModel().getColumn(6).setPreferredWidth(125);
            tblOvertime.getColumnModel().getColumn(7).setPreferredWidth(125);
            tblOvertime.getColumnModel().getColumn(8).setPreferredWidth(250);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 940, 390));

        txtEmployeeID.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtEmployeeID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmployeeIDActionPerformed(evt);
            }
        });
        getContentPane().add(txtEmployeeID, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 100, 140, 30));

        btnEmployeeID.setText("Search");
        btnEmployeeID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeeIDActionPerformed(evt);
            }
        });
        getContentPane().add(btnEmployeeID, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 100, 100, 30));

        labelEmployeeID.setBackground(new java.awt.Color(255, 255, 255));
        labelEmployeeID.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        labelEmployeeID.setForeground(new java.awt.Color(255, 255, 255));
        labelEmployeeID.setText("Enter Employee ID:");
        getContentPane().add(labelEmployeeID, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, -1, 30));

        darkButton1.setText("Refresh");
        darkButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                darkButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(darkButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 100, -1, 30));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/OvertimeAdminBackground.png"))); // NOI18N
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboardActionPerformed
        // Create an instance of the Dashboard frame
        AdminHomeDashboard dashboard = new AdminHomeDashboard(userID);
        // Set the visibility of the Dashboard frame to true
        dashboard.setVisible(true);
        // Close the Request Leave frame
        this.dispose(); // Assuming this is the Login frame
    }//GEN-LAST:event_btnDashboardActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // Redirects to Login Dashboard Page
        new LogInNew().setVisible(true); dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void txtEmployeeIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmployeeIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmployeeIDActionPerformed

    private void btnEmployeeIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeeIDActionPerformed
        // TODO add your handling code here:
        try{
            String employeeID = txtEmployeeID.getText();
            
            Connection con = db.mycon();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM overtime_requests WHERE employeeID=?");
            pst.setString(1, employeeID);
            ResultSet rs = pst.executeQuery();
            
            DefaultTableModel model = (DefaultTableModel) tblOvertime.getModel();
            model.setRowCount(0);
            
            if(rs.next() == true){
                model.addRow(new Object[]{
                        rs.getString("status"),
                        rs.getString("requestedDate"),
                        rs.getString("employeeID"),
                        rs.getString("employeeName"),
                        rs.getString("overtimeDate"),
                        rs.getString("startTime"),
                        rs.getString("endTime"),
                        rs.getString("totalHours"),
                        rs.getString("reason")                                               
                    });
                con.close();
                pst.close();
                rs.close();
            } else{
                    JOptionPane.showMessageDialog(this, "Employee ID cannot be empty. Please enter a valid Employee ID.", "Notification", JOptionPane.INFORMATION_MESSAGE);
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnEmployeeIDActionPerformed

    private void darkButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_darkButton1ActionPerformed
        // Refresh the tblOvertimeRequest
        fetchData();
    }//GEN-LAST:event_darkButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(OvertimeRequestAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OvertimeRequestAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OvertimeRequestAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OvertimeRequestAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new OvertimeRequestAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private Button.Button btnDashboard;
    private Button.DarkButton btnEmployeeID;
    private Button.Button btnLogout;
    private Button.DarkButton darkButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelEmployeeID;
    private javax.swing.JTable tblOvertime;
    private javax.swing.JTextField txtEmployeeID;
    // End of variables declaration//GEN-END:variables
}
