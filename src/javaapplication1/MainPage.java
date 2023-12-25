
package javaapplication1;

import com.mysql.cj.jdbc.ClientPreparedStatement;
import com.mysql.cj.jdbc.ConnectionImpl;
import com.mysql.cj.jdbc.result.ResultSetImpl;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.util.Vector;
import static javaapplication1.Login.c_id;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MainPage extends javax.swing.JFrame {
    public static int p_id=1;
    ConnectionImpl con = null;
    public MainPage() {
        con = (ConnectionImpl) DB.dbconnect();
        initComponents();
        String query = "SELECT p_id, p_name, p_price, availability, catagory, description, rating FROM product LEFT JOIN (SELECT product_id, AVG(rating) AS rating FROM review GROUP BY product_id) AS reviewe ON p_id = product_id";

        try {
            ClientPreparedStatement pst1 = (ClientPreparedStatement) con.prepareStatement(query);
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
                    v2.add(rs.getFloat("rating"));
                }
                df.addRow(v2);
            }
        } catch (Exception ex) {
            
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        refreash = new javax.swing.JButton();
        searchText = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cartButton = new javax.swing.JButton();
        reviewButton = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("E-commerce Shop");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "p_id", "p_name", "p_price", "availability", "catagory", "description", "rating"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
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
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Sorting");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Price");

        jButton1.setText("Ascending ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Descending ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton3.setText("LOG OUT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        refreash.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        refreash.setText("REFRESH");
        refreash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreashActionPerformed(evt);
            }
        });

        searchText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextActionPerformed(evt);
            }
        });

        search.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        search.setText("SEARCH");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Review");

        cartButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        cartButton.setText("ADD TO CART");
        cartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartButtonActionPerformed(evt);
            }
        });

        reviewButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        reviewButton.setText("REVIEWS");
        reviewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reviewButtonActionPerformed(evt);
            }
        });

        jButton4.setText("Ascending ");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Descending ");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(refreash)
                .addGap(199, 199, 199)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 323, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(search))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(reviewButton)
                        .addGap(18, 18, 18)
                        .addComponent(cartButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 745, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(refreash)
                            .addComponent(jLabel1)
                            .addComponent(search)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cartButton)
                    .addComponent(reviewButton))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton4)
                                .addComponent(jButton5))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            ClientPreparedStatement pst1 = (ClientPreparedStatement) con.prepareStatement("SELECT p_id, p_name, p_price, availability, catagory, description, rating FROM product LEFT JOIN (SELECT product_id, AVG(rating) AS rating FROM review GROUP BY product_id) AS reviewe ON p_id = product_id order by p_price asc");
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
                    v2.add(rs.getFloat("rating"));
                    
                }
                df.addRow(v2);
            }
        } catch (Exception ex) {
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            ClientPreparedStatement pst1 = (ClientPreparedStatement) con.prepareStatement("SELECT p_id, p_name, p_price, availability, catagory, description, rating FROM product LEFT JOIN (SELECT product_id, AVG(rating) AS rating FROM review GROUP BY product_id) AS reviewe ON p_id = product_id order by p_price desc");
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
                    v2.add(rs.getFloat("rating"));
                }
                df.addRow(v2);
            }
        } catch (Exception ex) {
            
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Login l = new Login();
        l.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void refreashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreashActionPerformed
        searchText.setText("");
        try {
            ClientPreparedStatement pst1 = (ClientPreparedStatement) con.prepareStatement("SELECT p_id, p_name, p_price, availability, catagory, description, rating FROM product LEFT JOIN (SELECT product_id, AVG(rating) AS rating FROM review GROUP BY product_id) AS reviewe ON p_id = product_id order by p_id asc");
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
                    v2.add(rs.getFloat("rating"));
                }
                df.addRow(v2);
            }
        } catch (Exception ex) {
            
        }
    }//GEN-LAST:event_refreashActionPerformed

    private void searchTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        String SearchText = searchText.getText();
        try {
            String query = "SELECT p_id, p_name, p_price, availability, catagory, description, rating FROM product LEFT JOIN (SELECT product_id, AVG(rating) AS rating FROM review GROUP BY product_id) AS review ON p_id = product_id where p_name like '"+SearchText+"%'";
            ClientPreparedStatement pst1 = (ClientPreparedStatement) con.prepareStatement(query);
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
                    v2.add(rs.getFloat("rating"));
                }
                df.addRow(v2);
            }
        } catch (Exception ex) {
            
        }
        
    }//GEN-LAST:event_searchActionPerformed

    private void cartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cartButtonActionPerformed
        // TODO add your handling code here:
        if(p_id == 0){
            JOptionPane.showMessageDialog(null,"Select a product");
        }else{
            try {
                DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
                int s1 = jTable1.getSelectedRow();
                ClientPreparedStatement pst = (ClientPreparedStatement) con.prepareStatement("insert into cart(p_id,c_id,p_name,p_price,quantity) value(?,?,?,?,?)");
                pst.setInt(1, (int) df.getValueAt(s1,0));
                pst.setInt(2, c_id);
                pst.setString(3, (String) df.getValueAt(s1,1));
                pst.setInt(4, (int) df.getValueAt(s1,2));
                pst.setInt(5,1);
                pst.executeUpdate();
  
        } catch (Exception ex) {
            
        } 
            MainCart mc= new MainCart();
            mc.setVisible(true);
            dispose();           
        }
        
    }//GEN-LAST:event_cartButtonActionPerformed

    private void reviewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reviewButtonActionPerformed
        // TODO add your handling code here:
        if(p_id == 0){
            JOptionPane.showMessageDialog(null,"Select a product");
        }else{
            review r = new review();
            r.setVisible(true);
            dispose();           
        }

        
    }//GEN-LAST:event_reviewButtonActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
        DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
        int s1 = jTable1.getSelectedRow();
        
        p_id = (int) df.getValueAt(s1,0);
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try {
            ClientPreparedStatement pst1 = (ClientPreparedStatement) con.prepareStatement("SELECT p_id, p_name, p_price, availability, catagory, description, rating FROM product LEFT JOIN (SELECT product_id, AVG(rating) AS rating FROM review GROUP BY product_id) AS reviewe ON p_id = product_id order by rating asc");
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
                    v2.add(rs.getFloat("rating"));
                    
                }
                df.addRow(v2);
            }
        } catch (Exception ex) {
            
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        try {
            ClientPreparedStatement pst1 = (ClientPreparedStatement) con.prepareStatement("SELECT p_id, p_name, p_price, availability, catagory, description, rating FROM product LEFT JOIN (SELECT product_id, AVG(rating) AS rating FROM review GROUP BY product_id) AS reviewe ON p_id = product_id order by rating desc");
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
                    v2.add(rs.getFloat("rating"));
                    
                }
                df.addRow(v2);
            }
        } catch (Exception ex) {
            
        }
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cartButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton refreash;
    private javax.swing.JButton reviewButton;
    private javax.swing.JButton search;
    private javax.swing.JTextField searchText;
    // End of variables declaration//GEN-END:variables
}
