package Jframes;

import com.raven.swing.TimePicker;
import org.jdatepicker.JDatePicker;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import Classes.db;
import java.sql.*;

public class OvertimeRequest extends javax.swing.JFrame {
    private String userID;

    public OvertimeRequest(String userID) {
        this.userID = userID;
        initComponents();
        addTimePickerListeners(); // Add event listeners after initializing components
        fetchEmployeeDetails();
    }

    private void calculateTimeDifference() {
    try {
        // Assuming clockStartTime and clockEndTime are the time picker components
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");

        // Retrieve start time and end time from time pickers
        String startTimeStr = clockStartTime.getSelectedTime();
        String endTimeStr = clockEndTime.getSelectedTime();

        // Parse the times
        LocalTime startTime = LocalTime.parse(startTimeStr, formatter);
        LocalTime endTime = LocalTime.parse(endTimeStr, formatter);

        // Calculate the difference
        Duration duration = Duration.between(startTime, endTime);
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;

        // Display the result in txtTotalHours
        txtTotalHours.setText(String.format("%02d hrs, %02d mins", hours, minutes));
    } catch (Exception e) {
        e.printStackTrace();
        txtTotalHours.setText("Invalid Time");
        }
    }
    
    private void addTimePickerListeners() {
        // Add action listeners to the time picker components
        clockStartTime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                calculateTimeDifference();
            }
        });

        clockEndTime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                calculateTimeDifference();
            }
        });
    }

    private void fetchEmployeeDetails(){
        try{
            // Get the connection to the db database
            Connection con = db.mycon();
            
            if(con != null){
                
                // Create a statement
                Statement st = con.createStatement();
                
                // Execute a query to retrieve employee details based on userID
                String query = "SELECT employeeID, CONCAT(firstName, ' ', lastName) as employeeName FROM user_accounts WHERE userID = '" + userID + "'";
                ResultSet rs = st.executeQuery(query);
                
                // Set employeeName and userID in text field
                if(rs.next()){
                    txtEmployeeNumber.setText(rs.getString("employeeID"));
                    txtEmployeeName.setText(rs.getString("employeeName"));
                    }
                // Close the connection
                rs.close();
                st.close();
                con.close();
                
            }else{
                System.out.println("Database connection failed!");
            }
        }catch(Exception e){
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

        clockStartTime = new com.raven.swing.TimePicker();
        clockEndTime = new com.raven.swing.TimePicker();
        btnSubmit = new Button.DarkButton();
        btnClear = new Button.Button();
        btnGoBack = new Button.DarkButton();
        labelOvertimeDate = new javax.swing.JLabel();
        txtOvertimeDate = new com.toedter.calendar.JDateChooser();
        labelStartTime = new javax.swing.JLabel();
        labelEndTime = new javax.swing.JLabel();
        labelTotalHours = new javax.swing.JLabel();
        txtTotalHours = new javax.swing.JFormattedTextField();
        labelReason = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtReason = new javax.swing.JTextArea();
        btnAttachFile = new Button.DarkButton();
        btnDashboard = new Button.Button();
        btnLogout = new Button.Button();
        txtStartTime = new javax.swing.JTextField();
        txtEndTime = new javax.swing.JTextField();
        btnEndTime = new javax.swing.JButton();
        btnStartTime = new javax.swing.JButton();
        labelEmployeeNumber = new javax.swing.JLabel();
        txtEmployeeNumber = new javax.swing.JLabel();
        labelEmployeeName = new javax.swing.JLabel();
        txtEmployeeName = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        clockStartTime.setForeground(new java.awt.Color(0, 153, 153));
        clockStartTime.setDisplayText(txtStartTime);

        clockEndTime.setForeground(new java.awt.Color(0, 153, 153));
        clockEndTime.setDisplayText(txtEndTime);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1040, 590));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        getContentPane().add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 490, 160, -1));

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        getContentPane().add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 490, 160, -1));

        btnGoBack.setText("Go Back");
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnGoBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 90, -1, -1));

        labelOvertimeDate.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelOvertimeDate.setText("Overtime Date:");
        getContentPane().add(labelOvertimeDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, -1, 20));
        getContentPane().add(txtOvertimeDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 260, -1));

        labelStartTime.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelStartTime.setText("Start Time: ");
        getContentPane().add(labelStartTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, -1, 20));

        labelEndTime.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelEndTime.setText("End Time: ");
        getContentPane().add(labelEndTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, -1, 20));

        labelTotalHours.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelTotalHours.setText("Total Time:");
        getContentPane().add(labelTotalHours, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 200, -1, -1));

        txtTotalHours.setEditable(false);
        txtTotalHours.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotalHours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalHoursActionPerformed(evt);
            }
        });
        getContentPane().add(txtTotalHours, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 200, 120, -1));

        labelReason.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelReason.setText("Reason:");
        getContentPane().add(labelReason, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 240, -1, -1));

        txtReason.setColumns(20);
        txtReason.setForeground(new java.awt.Color(153, 153, 153));
        txtReason.setRows(5);
        txtReason.setName(""); // NOI18N
        jScrollPane2.setViewportView(txtReason);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 240, 310, 150));

        btnAttachFile.setBackground(new java.awt.Color(120, 121, 123));
        btnAttachFile.setForeground(new java.awt.Color(0, 0, 0));
        btnAttachFile.setText("Attach File");
        btnAttachFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAttachFileActionPerformed(evt);
            }
        });
        getContentPane().add(btnAttachFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 410, -1, -1));

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

        txtStartTime.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtStartTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStartTimeActionPerformed(evt);
            }
        });
        getContentPane().add(txtStartTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 120, 20));

        txtEndTime.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtEndTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEndTimeActionPerformed(evt);
            }
        });
        getContentPane().add(txtEndTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 120, 20));

        btnEndTime.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        btnEndTime.setText("Choose End Time");
        btnEndTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEndTimeActionPerformed(evt);
            }
        });
        getContentPane().add(btnEndTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 400, 130, -1));

        btnStartTime.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        btnStartTime.setText("Choose Start Time");
        btnStartTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartTimeActionPerformed(evt);
            }
        });
        getContentPane().add(btnStartTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 350, 130, -1));

        labelEmployeeNumber.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelEmployeeNumber.setText("Employee No:");
        getContentPane().add(labelEmployeeNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, -1, 20));

        txtEmployeeNumber.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtEmployeeNumber.setText("Employee Number");
        getContentPane().add(txtEmployeeNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, -1, -1));

        labelEmployeeName.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelEmployeeName.setText("Employee Name:");
        getContentPane().add(labelEmployeeName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, -1, 20));

        txtEmployeeName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtEmployeeName.setText("Employee Name");
        getContentPane().add(txtEmployeeName, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, -1, -1));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/RequestOvertimeBackground.png"))); // NOI18N
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 590));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtTotalHoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalHoursActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalHoursActionPerformed

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        // TODO add your handling code here:
        OvertimeRequestHistory OvertimeRequest = new OvertimeRequestHistory(userID);
        OvertimeRequest.setVisible(true);
        this.dispose();     
    }//GEN-LAST:event_btnGoBackActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // Clear all inputs so that user won't manually clear each box and calendar.
        txtOvertimeDate.setDate(null);
        txtStartTime.setText("");
        txtEndTime.setText("");
        txtTotalHours.setText("");
        txtReason.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // Getting the data from the form fields
        String employeeID = txtEmployeeNumber.getText();
        String employeeName = txtEmployeeName.getText();
        java.util.Date utilDate = txtOvertimeDate.getDate();
        Date overtimeDate = new Date(utilDate.getTime());
        String startTime = txtStartTime.getText();
        String endTime = txtEndTime.getText();
        String totalHours = txtTotalHours.getText();
        String reason = txtReason.getText();
        
        // SQL query to input data into overtime_requests database        
        try{
            
            Statement st = db.mycon().createStatement();
            st.executeUpdate("INSERT INTO overtime_requests (employeeID,employeeName,overtimeDate,startTime,endTime,totalHours,reason,status)" 
                    + "VALUES('"+employeeID+"','"+employeeName+"','"+overtimeDate+"','"+startTime+"','"+endTime+"','"+totalHours+"','"+reason+"', 'Pending')");
            
        // Show a confirmation message to notify the user when an overtime request is successful
            JOptionPane.showMessageDialog(this, "Request sent successfully. Wait for approval", "Overtime Request", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        // Clear all inputs like clear button
        txtOvertimeDate.setDate(null);
        txtStartTime.setText("");
        txtEndTime.setText("");
        txtTotalHours.setText("");
        txtReason.setText("");
    }//GEN-LAST:event_btnSubmitActionPerformed

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

    private void txtEndTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEndTimeActionPerformed
        // Call calculateTimeDifference when start time is set
        calculateTimeDifference();
    }//GEN-LAST:event_txtEndTimeActionPerformed

    private void txtStartTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStartTimeActionPerformed
        // Call calculateTimeDifference when start time is set
        calculateTimeDifference();
    }//GEN-LAST:event_txtStartTimeActionPerformed
   
    private void btnStartTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartTimeActionPerformed
        // TODO add your handling code here:
        clockStartTime.showPopup(this, 100, 100);
    }//GEN-LAST:event_btnStartTimeActionPerformed

    private void btnEndTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEndTimeActionPerformed
        // TODO add your handling code here:
        clockEndTime.showPopup(this, 100, 100);
    }//GEN-LAST:event_btnEndTimeActionPerformed

    private void btnAttachFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAttachFileActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "File attached successfully.", "Attach File", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnAttachFileActionPerformed

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
            java.util.logging.Logger.getLogger(OvertimeRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OvertimeRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OvertimeRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OvertimeRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OvertimeRequest("userID").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private Button.DarkButton btnAttachFile;
    private Button.Button btnClear;
    private Button.Button btnDashboard;
    private javax.swing.JButton btnEndTime;
    private Button.DarkButton btnGoBack;
    private Button.Button btnLogout;
    private javax.swing.JButton btnStartTime;
    private Button.DarkButton btnSubmit;
    private com.raven.swing.TimePicker clockEndTime;
    private com.raven.swing.TimePicker clockStartTime;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelEmployeeName;
    private javax.swing.JLabel labelEmployeeNumber;
    private javax.swing.JLabel labelEndTime;
    private javax.swing.JLabel labelOvertimeDate;
    private javax.swing.JLabel labelReason;
    private javax.swing.JLabel labelStartTime;
    private javax.swing.JLabel labelTotalHours;
    private javax.swing.JLabel txtEmployeeName;
    private javax.swing.JLabel txtEmployeeNumber;
    private javax.swing.JTextField txtEndTime;
    private com.toedter.calendar.JDateChooser txtOvertimeDate;
    private javax.swing.JTextArea txtReason;
    private javax.swing.JTextField txtStartTime;
    private javax.swing.JFormattedTextField txtTotalHours;
    // End of variables declaration//GEN-END:variables
}
