
package javaapplication1;

import com.mysql.cj.jdbc.ClientPreparedStatement;
import com.mysql.cj.jdbc.ConnectionImpl;
import com.mysql.cj.jdbc.result.ResultSetImpl;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import static javaapplication1.Login.c_id;
import static javaapplication1.MD5.getMd5;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class MainCart extends javax.swing.JFrame {
    public static int Total = 0;
    int remain =0;
     ConnectionImpl con = null;
    public MainCart() {
        con = (ConnectionImpl) DB.dbconnect();
        initComponents();
        render();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Total_Price = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        increment = new javax.swing.JButton();
        decreament = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Available_Balance = new javax.swing.JTextField();
        Remaining_Balance = new javax.swing.JTextField();
        Pin = new javax.swing.JTextField();
        Pay = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setText("My Cart");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("Available Balance");

        Total_Price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Total_PriceActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Name", "Price", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setText("REFRESH");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Quantity");

        increment.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        increment.setText("+");
        increment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incrementActionPerformed(evt);
            }
        });

        decreament.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        decreament.setText("-");
        decreament.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decreamentActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setText("Remaining Balance");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setText("Total Price ");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setText("Enter Pin");

        Available_Balance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Available_BalanceActionPerformed(evt);
            }
        });

        Remaining_Balance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Remaining_BalanceActionPerformed(evt);
            }
        });

        Pin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PinActionPerformed(evt);
            }
        });

        Pay.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Pay.setText("Click to Pay");
        Pay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Total_Price)
                            .addComponent(Available_Balance, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                            .addComponent(Remaining_Balance, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                            .addComponent(Pin, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                            .addComponent(Pay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 807, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(364, 364, 364)
                        .addComponent(jLabel1)))
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(decreament)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(increment)
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1)
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(increment)
                            .addComponent(decreament))
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(112, 112, 112)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Total_Price, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(Available_Balance, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(Remaining_Balance, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(Pin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addComponent(Pay)))
                .addContainerGap(97, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
//        DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
//        int s1 = jTable1.getSelectedRow();
//        Global g = new Global();
//        g.product_id = Integer.parseInt((String) df.getValueAt(s1,0));

        
    }//GEN-LAST:event_jTable1MouseClicked


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MainPage mp = new MainPage();
        mp.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void Total_PriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Total_PriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Total_PriceActionPerformed

    private void incrementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_incrementActionPerformed
        // TODO add your handling code here:
        DefaultTableModel df1 = (DefaultTableModel)jTable1.getModel();
        int s = jTable1.getSelectedRow();
        int P_id = (int) df1.getValueAt(s, 0);
        
        try {
            ClientPreparedStatement pst2 = (ClientPreparedStatement) con.prepareStatement("select quantity from cart where p_id =? and c_id=?");
            pst2.setInt(1,P_id);
            pst2.setInt(2,c_id);
            ResultSetImpl rs1 = (ResultSetImpl) pst2.executeQuery();
            ResultSetMetaData rd = (ResultSetMetaData) rs1.getMetaData();
            int n = rd.getColumnCount();
            int Quantity =0;
            if(rs1.next()){
                Quantity = rs1.getInt("quantity");   
            }
            Quantity++;
            ClientPreparedStatement pst = (ClientPreparedStatement) con.prepareStatement("update cart set quantity=? where p_id = ? and c_id=?");
            pst.setInt(1,Quantity);
            pst.setInt(2,P_id);
            pst.setInt(3,c_id);
            pst.executeUpdate();
            render();
        } catch (SQLException ex) {
            
        }
        
    }//GEN-LAST:event_incrementActionPerformed

    private void decreamentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decreamentActionPerformed
        // TODO add your handling code here:
        DefaultTableModel df1 = (DefaultTableModel)jTable1.getModel();
        int s = jTable1.getSelectedRow();
        int P_id = (int) df1.getValueAt(s, 0);
        
        try {
            ClientPreparedStatement pst2 = (ClientPreparedStatement) con.prepareStatement("select quantity from cart where p_id =? and c_id=?");
            pst2.setInt(1,P_id);
            pst2.setInt(2,c_id);
            ResultSetImpl rs1 = (ResultSetImpl) pst2.executeQuery();
            ResultSetMetaData rd = (ResultSetMetaData) rs1.getMetaData();
            int n = rd.getColumnCount();
            int Quantity =0;
            if(rs1.next()){
                Quantity = rs1.getInt("quantity");   
            }
            Quantity--;
            if(Quantity==0){
                ClientPreparedStatement pst = (ClientPreparedStatement) con.prepareStatement("delete from cart where p_id = ? and c_id=?");
                pst.setInt(1,P_id);
                pst.setInt(2,c_id);
                pst.executeUpdate();
            }else{
                ClientPreparedStatement pst = (ClientPreparedStatement) con.prepareStatement("update cart set quantity=? where p_id = ? and c_id=?");
                pst.setInt(1,Quantity);
                pst.setInt(2,P_id);
                pst.setInt(3,c_id);
                pst.executeUpdate();
            }
            

            render();
        } catch (SQLException ex) {
            
        }
    }//GEN-LAST:event_decreamentActionPerformed

    private void Available_BalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Available_BalanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Available_BalanceActionPerformed

    private void Remaining_BalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Remaining_BalanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Remaining_BalanceActionPerformed

    private void PinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PinActionPerformed

    private void PayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PayActionPerformed
        // TODO add your handling code here:
        String getPassword = getMd5(Pin.getText());
//        Total = Integer.parseInt(Total_Price.getText());
//        Amount = Integer.parseInt(Available_Balance.getText());
        try{
            ClientPreparedStatement pst1 = (ClientPreparedStatement) con.prepareStatement("select * from customer where customer_id=? and password=?");
            pst1.setInt(1,c_id);
            pst1.setString(2, getPassword);
            ResultSetImpl rs = (ResultSetImpl) pst1.executeQuery();
            while(rs.next()){
                JOptionPane.showMessageDialog(null,"Payment Successfull");
                  try{
                    ClientPreparedStatement pst = (ClientPreparedStatement) con.prepareStatement("update payment set amount = ? where c_id=?");
                    pst.setInt(1,remain);
                      System.out.println(remain);
                    pst.setInt(2, c_id);
                    pst.executeQuery();
//                    ClientPreparedStatement pst1 = (ClientPreparedStatement) con.prepareStatement("delete from cart where c_id=?");
//                    pst1.setInt(1, c_id);
//                    pst1.executeQuery();
                    render();
                }catch(SQLException e){
                }
            }
            
        }catch(SQLException e){
        }
    }//GEN-LAST:event_PayActionPerformed
    public void render(){
        try{
            ClientPreparedStatement pst1 = (ClientPreparedStatement) con.prepareStatement("select p_id,p_name,p_price,quantity from cart where c_id=?");
            pst1.setInt(1,c_id);
            ResultSetImpl rs = (ResultSetImpl) pst1.executeQuery();
            ResultSetMetaData rd = (ResultSetMetaData) rs.getMetaData();
            int n = rd.getColumnCount();
            DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);
            while(rs.next()){
                Vector v2 = new Vector();
                for(int i=1;i<=n;i++){
                    v2.add(rs.getInt("p_id"));
                    v2.add(rs.getString("p_name"));
                    v2.add(rs.getInt("p_price"));
                    v2.add(rs.getInt("quantity"));
                }
                df.addRow(v2);
            }
        }catch(SQLException e){}
        
        try{
            ClientPreparedStatement pst1 = (ClientPreparedStatement) con.prepareStatement("select p_price, quantity from cart where c_id=?");
            pst1.setInt(1,c_id);
            ResultSetImpl rs = (ResultSetImpl) pst1.executeQuery();
            while(rs.next()){
                int Price = rs.getInt("p_price");
                int Quantity = rs.getInt("quantity");
                Total += Price*Quantity;
            }
            Total_Price.setText(""+Total);
            
        }catch(SQLException e){
        }
        try{
            ClientPreparedStatement pst1 = (ClientPreparedStatement) con.prepareStatement("select amount from payment where c_id=?");
            pst1.setInt(1,c_id);
            ResultSetImpl rs = (ResultSetImpl) pst1.executeQuery();
            int Amount = 0;
            while(rs.next()){
                Amount = rs.getInt("amount");
            }
            Available_Balance.setText(""+Amount+" - "+Total);
            Remaining_Balance.setText(""+(Amount-Total));
            remain = Amount-Total;
            System.out.println(remain);
        }catch(SQLException e){
        }
        Total = 0;
    }

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
            java.util.logging.Logger.getLogger(MainCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainCart().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Available_Balance;
    private javax.swing.JButton Pay;
    private javax.swing.JTextField Pin;
    private javax.swing.JTextField Remaining_Balance;
    private javax.swing.JTextField Total_Price;
    private javax.swing.JButton decreament;
    private javax.swing.JButton increment;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
