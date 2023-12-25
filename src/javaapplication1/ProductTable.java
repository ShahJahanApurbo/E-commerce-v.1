
package javaapplication1;

import com.mysql.cj.jdbc.ClientPreparedStatement;
import com.mysql.cj.jdbc.ConnectionImpl;
import com.mysql.cj.jdbc.result.ResultSetImpl;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ProductTable extends javax.swing.JFrame {

     ConnectionImpl con = null;
       public boolean checkUsername(int id)
   {

        boolean checkUser = false;        
        try {
            ClientPreparedStatement pst = (ClientPreparedStatement) con.prepareStatement("SELECT * FROM product WHERE p_id =?");
            pst.setInt(1, id);
            
            ResultSetImpl r = (ResultSetImpl) pst.executeQuery();
            
           if(r.next())
            {
                checkUser = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return checkUser;
    }
    public ProductTable(){
        con = (ConnectionImpl) DB.dbconnect();
        initComponents();
        try {
            ClientPreparedStatement pst1 = (ClientPreparedStatement) con.prepareStatement("select * from product");
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
                    v2.add(rs.getInt("availability"));
                    v2.add(rs.getString("catagory"));
                    v2.add(rs.getString("description"));
                }
                df.addRow(v2);
            }
        } catch (Exception ex) {
            
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        p_id = new javax.swing.JTextField();
        p_name = new javax.swing.JTextField();
        p_price = new javax.swing.JTextField();
        catagory = new javax.swing.JTextField();
        availability = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        description = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        AddButton = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setText("Product Table");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Description");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("Price");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setText("Product id");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("Catagory");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("Availability");

        p_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p_idActionPerformed(evt);
            }
        });

        catagory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catagoryActionPerformed(evt);
            }
        });

        description.setColumns(20);
        description.setRows(5);
        jScrollPane1.setViewportView(description);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "p_id", "p_name", "price", "availability", "catagory", "description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
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

        AddButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AddButton.setText("INSERT");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        Delete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Delete.setText("DELETE");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        update.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        update.setText("UPDATE");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton1.setText("LOG OUT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton3.setText("REFRESH");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton2.setText("NEXT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jButton1)))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(p_id)
                                .addComponent(p_name)
                                .addComponent(p_price)
                                .addComponent(availability)
                                .addComponent(catagory)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(AddButton)
                                .addGap(18, 18, 18)
                                .addComponent(update)
                                .addGap(18, 18, 18)
                                .addComponent(Delete)))
                        .addGap(56, 56, 56)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 807, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(289, 289, 289)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(402, 402, 402)
                        .addComponent(jButton2)))
                .addContainerGap(719, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton2))
                .addGap(103, 103, 103)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(p_id)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(p_name, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(p_price))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(availability, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(catagory, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AddButton)
                            .addComponent(update)
                            .addComponent(Delete)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void catagoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catagoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_catagoryActionPerformed

    private void p_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_p_idActionPerformed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        int P_id = Integer.parseInt(p_id.getText());
        String P_name = p_name.getText();
        int P_price =Integer.parseInt(p_price.getText());
        int Availability =Integer.parseInt(availability.getText());
        String Catagory = catagory.getText();
        String Description = description.getText();
          if(p_id.getText().equals("") ||p_name.getText().equals("") ||p_price.getText().equals("") ||availability.getText().equals("") ||catagory.getText().equals("") ||description.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Enter product details");
          }
          else if(checkUsername(P_id))
            {
                JOptionPane.showMessageDialog(null, "This product Already Exist");
                
            }
             else{
                try {
            ClientPreparedStatement pst = (ClientPreparedStatement) con.prepareStatement("insert into product(p_id,p_name,p_price,availability,catagory,description) value(?,?,?,?,?,?)");
            pst.setInt(1, P_id);
            pst.setString(2, P_name);
            pst.setInt(3,P_price);
            pst.setInt(4,Availability);
            pst.setString(5,Catagory);
            pst.setString(6,Description);
            pst.executeUpdate();
            p_id.setText("");
            p_name.setText("");
            p_price.setText("");
            availability.setText("");
            catagory.setText("");
            description.setText("");
            
            ClientPreparedStatement pst1 = (ClientPreparedStatement) con.prepareStatement("select * from product");
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
                    v2.add(rs.getInt("availability"));
                    v2.add(rs.getString("catagory"));
                    v2.add(rs.getString("description"));
                }
                df.addRow(v2);
            }
        } catch (Exception ex) {
            
        } 
             }
        
    }//GEN-LAST:event_AddButtonActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        
        DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
        int s1 = jTable1.getSelectedRow();
        int P_id =Integer.parseInt(df.getValueAt(s1,0).toString());
        try {
            ClientPreparedStatement pst = (ClientPreparedStatement) con.prepareStatement("delete from product where p_id=?");
            pst.setInt(1, P_id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Row Deleted");
            p_id.setText("");
            p_name.setText("");
            p_price.setText("");
            availability.setText("");
            catagory.setText("");
            description.setText("");
          
            int a;
            ClientPreparedStatement pst1 = (ClientPreparedStatement) con.prepareStatement("select * from product");
            ResultSetImpl rs = (ResultSetImpl) pst1.executeQuery();
            ResultSetMetaData rd = (ResultSetMetaData) rs.getMetaData();
            a = rd.getColumnCount();
            DefaultTableModel df1 = (DefaultTableModel)jTable1.getModel();
            df1.setRowCount(0);
            while(rs.next()){
                Vector v2 = new Vector();
                for(int i=1;i<=a;i++){
                    v2.add(rs.getInt("p_id"));
                    v2.add(rs.getString("p_name"));
                    v2.add(rs.getInt("p_price"));
                    v2.add(rs.getInt("availability"));
                    v2.add(rs.getString("catagory"));
                    v2.add(rs.getString("description"));
                }
                df1.addRow(v2);
                
            }
        }catch(SQLException ex3){
            
        } 
    }//GEN-LAST:event_DeleteActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        int P_id =Integer.parseInt(p_id.getText());
        String P_name = p_name.getText();
        int P_price =Integer.parseInt(p_price.getText());
        int Availability =Integer.parseInt(availability.getText());
        String Catagory = catagory.getText();
        String Description = description.getText();
        try {
            ClientPreparedStatement pst = (ClientPreparedStatement) con.prepareStatement("update product set p_name=? ,p_price=?,availability=?,catagory=?,description=? where p_id = ?");
            
            pst.setString(1, P_name);
            pst.setInt(2,P_price);
            pst.setInt(3,Availability);
            pst.setString(4,Catagory);
            pst.setString(5,Description);
            pst.setInt(6, P_id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"list updated");
            p_id.setText("");
            p_name.setText("");
            p_price.setText("");
            availability.setText("");
            catagory.setText("");
            description.setText("");
          
            int a;
            ClientPreparedStatement pst1 = (ClientPreparedStatement) con.prepareStatement("select * from product");
            ResultSetImpl rs1 = (ResultSetImpl) pst1.executeQuery();
            ResultSetMetaData rd1 = (ResultSetMetaData) rs1.getMetaData();
            a = rd1.getColumnCount();
            DefaultTableModel df1 = (DefaultTableModel)jTable1.getModel();
            df1.setRowCount(0);
            while(rs1.next()){
                Vector v2 = new Vector();
                for(int i=1;i<=a;i++){
                    v2.add(rs1.getInt("p_id"));
                    v2.add(rs1.getString("p_name"));
                    v2.add(rs1.getInt("p_price"));
                    v2.add(rs1.getInt("availability"));
                    v2.add(rs1.getString("catagory"));
                    v2.add(rs1.getString("description"));
                }
                df1.addRow(v2);
                
            }
        }catch(SQLException ex3){
            
        } 
    }//GEN-LAST:event_updateActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
        int s1 = jTable1.getSelectedRow();
        p_id.setText(df.getValueAt(s1, 0).toString());
        p_name.setText(df.getValueAt(s1, 1).toString());
        p_price.setText(df.getValueAt(s1, 2).toString());
        availability.setText(df.getValueAt(s1, 3).toString());
        catagory.setText(df.getValueAt(s1, 4).toString());
        description.setText(df.getValueAt(s1, 5).toString());

        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Login l = new Login();
        l.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            ClientPreparedStatement pst1 = (ClientPreparedStatement) con.prepareStatement("select * from product order by p_id asc");
            ResultSetImpl rs = (ResultSetImpl) pst1.executeQuery();
            ResultSetMetaData rd = (ResultSetMetaData) rs.getMetaData();
            int n = rd.getColumnCount();
            DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);
            p_id.setText("");
            p_name.setText("");
            p_price.setText("");
            availability.setText("");
            catagory.setText("");
            description.setText("");
            while(rs.next()){
                Vector v2 = new Vector();
                for(int i=1;i<=n;i++){
                    v2.add(rs.getInt("p_id"));
                    v2.add(rs.getString("p_name"));
                    v2.add(rs.getInt("p_price"));
                    v2.add(rs.getInt("availability"));
                    v2.add(rs.getString("catagory"));
                    v2.add(rs.getString("description"));
                }
                df.addRow(v2);
            }
        } catch (Exception ex) {
            
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        reviewTable rt = new reviewTable();
        rt.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ProductTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductTable().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton Delete;
    private javax.swing.JTextField availability;
    private javax.swing.JTextField catagory;
    private javax.swing.JTextArea description;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField p_id;
    private javax.swing.JTextField p_name;
    private javax.swing.JTextField p_price;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
