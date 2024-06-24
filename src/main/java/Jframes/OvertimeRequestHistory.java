package Jframes;

import Classes.db; // Import the db class
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class OvertimeRequestHistory extends javax.swing.JFrame {
    private String userID;
    
    public OvertimeRequestHistory(String userID) {
        this.userID = userID;
        initComponents();
        fetchData();
    }
    
    public void fetchData(){
        try{
            // Get the connection from db class
            Connection con = db.mycon();
            
            // Check if the connection to db class is successful
            if(con != null){
                
                // SQL query to join user_accounts and overtime_requests based on employeeID
                String query = "SELECT orq.status, orq.requestedDate, orq.overtimeDate, orq.startTime, orq.endTime, orq.totalHours, orq.reason " +
                               "FROM overtime_requests orq " +
                               "JOIN user_accounts ua ON orq.employeeID = ua.employeeID " +
                               "WHERE ua.userID = ?";
                
                // Create a prepared statement
                PreparedStatement pst = con.prepareStatement(query);
                pst.setString(1, this.userID); // Set the userID parameter
                
                // Execute the query
                ResultSet rs = pst.executeQuery();
                
                // Get the table model from tblOvertimeHistory
                DefaultTableModel model = (DefaultTableModel) tblOvertimeHistory.getModel();
                model.setRowCount(0); // Clear existing data
                
                // Add rows of data to the table model
                while(rs.next()){
                    model.addRow(new Object[]{
                        rs.getString("status"),
                        rs.getString("requestedDate"),
                        rs.getString("overtimeDate"),
                        rs.getString("startTime"),
                        rs.getString("endTime"),
                        rs.getString("totalHours"),
                        rs.getString("reason")                   
                    });                  
                }
                    
                // Close the operation
                con.close();
                pst.close();
                rs.close();
                
            }
                else{
                JOptionPane.showMessageDialog(this, "No database found!", "Notification", JOptionPane.WARNING_MESSAGE);
            } 
        }
        catch(Exception e){
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

        btnRequestOvertime = new Button.DarkButton();
        btnDashboard = new Button.Button();
        btnLogout = new Button.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOvertimeHistory = new javax.swing.JTable();
        darkButton1 = new Button.DarkButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRequestOvertime.setText("Request Overtime");
        btnRequestOvertime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestOvertimeActionPerformed(evt);
            }
        });
        getContentPane().add(btnRequestOvertime, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 90, -1, -1));

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
        getContentPane().add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 10, -1, 30));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        tblOvertimeHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Status", "Requested Date", "Date of Overtime", "Start Time", "End TIme", "Total Hour/s", "Reason"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblOvertimeHistory);
        if (tblOvertimeHistory.getColumnModel().getColumnCount() > 0) {
            tblOvertimeHistory.getColumnModel().getColumn(0).setPreferredWidth(125);
            tblOvertimeHistory.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblOvertimeHistory.getColumnModel().getColumn(2).setPreferredWidth(125);
            tblOvertimeHistory.getColumnModel().getColumn(3).setPreferredWidth(125);
            tblOvertimeHistory.getColumnModel().getColumn(4).setPreferredWidth(125);
            tblOvertimeHistory.getColumnModel().getColumn(5).setPreferredWidth(125);
            tblOvertimeHistory.getColumnModel().getColumn(6).setPreferredWidth(250);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 940, 390));

        darkButton1.setText("Cancel Request");
        getContentPane().add(darkButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 90, 160, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/OvertimeHistoryBackground.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 590));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRequestOvertimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestOvertimeActionPerformed
         // Create an instance of OvertimeRequest and display it
        OvertimeRequest overtimeRequest = new OvertimeRequest(userID);
        overtimeRequest.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRequestOvertimeActionPerformed

    private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboardActionPerformed
        // Create an instance of the Dashboard frame
        HomeDashboard dashboard = new HomeDashboard(userID);
        // Set the visibility of the Dashboard frame to true
        dashboard.setVisible(true);
        // Close the Overtime Request frame
        this.dispose(); // Assuming this is the Login frame
    }//GEN-LAST:event_btnDashboardActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // Create an instance of LoginNew and display it
        LogInNew loginNew = new LogInNew();
        loginNew.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

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
            java.util.logging.Logger.getLogger(OvertimeRequestHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OvertimeRequestHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OvertimeRequestHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OvertimeRequestHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private Button.Button btnDashboard;
    private Button.Button btnLogout;
    private Button.DarkButton btnRequestOvertime;
    private Button.DarkButton darkButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblOvertimeHistory;
    // End of variables declaration//GEN-END:variables
}
