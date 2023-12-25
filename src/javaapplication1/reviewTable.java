
package javaapplication1;

import com.mysql.cj.jdbc.ClientPreparedStatement;
import com.mysql.cj.jdbc.ConnectionImpl;
import com.mysql.cj.jdbc.result.ResultSetImpl;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class reviewTable extends javax.swing.JFrame {
ConnectionImpl con = null;
    public reviewTable() {
        con = (ConnectionImpl) DB.dbconnect();
        initComponents();
        try {
            ClientPreparedStatement pst1 = (ClientPreparedStatement) con.prepareStatement("select * from review");
            ResultSetImpl rs = (ResultSetImpl) pst1.executeQuery();
            ResultSetMetaData rd = (ResultSetMetaData) rs.getMetaData();
            int n = rd.getColumnCount();
            DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);
            while(rs.next()){
                Vector v2 = new Vector();
                for(int i=1;i<=n;i++){
                    v2.add(rs.getInt("review_id"));
                    v2.add(rs.getInt("product_id"));
                    v2.add(rs.getInt("customer_id"));
                    v2.add(rs.getInt("rating"));
                    v2.add(rs.getString("title"));
                    v2.add(rs.getString("review_text"));
                    v2.add(rs.getString("review_reply"));
                }
                df.addRow(v2);
            }
        } catch (Exception ex) {
            
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        review_reply = new javax.swing.JTextArea();
        update = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "review_id", "product_id", "customer_id", "rating", "title", "review_text", "review_reply"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setText("Review Table");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Review Reply");

        review_reply.setColumns(20);
        review_reply.setRows(5);
        jScrollPane2.setViewportView(review_reply);

        update.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        update.setText("ADD");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(564, 564, 564)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(566, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(update))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
        
        
        String Review_reply = review_reply.getText();
        DefaultTableModel df1 = (DefaultTableModel)jTable1.getModel();
        int s1 = jTable1.getSelectedRow();
        int R_id = (int) df1.getValueAt(s1, 0);
        if(Review_reply.equals("")){
            JOptionPane.showMessageDialog(null,"Add comment first");
        }
        else{
        
        try {
            ClientPreparedStatement pst1 = (ClientPreparedStatement) con.prepareStatement("update review set review_reply = ? where review_id = ?");
            pst1.setString(1, Review_reply);
            pst1.setInt(2,R_id);
            pst1.executeUpdate();
            review_reply.setText("");   
        } catch (Exception ex) {
            
        }
        try {
            ClientPreparedStatement pst = (ClientPreparedStatement) con.prepareStatement("select * from review");
            ResultSetImpl rs = (ResultSetImpl) pst.executeQuery();
            ResultSetMetaData rd = (ResultSetMetaData) rs.getMetaData();
            int n = rd.getColumnCount();
            DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);
            while(rs.next()){
                Vector v2 = new Vector();
                for(int i=1;i<=n;i++){
                    v2.add(rs.getInt("review_id"));
                    v2.add(rs.getInt("product_id"));
                    v2.add(rs.getInt("customer_id"));
                    v2.add(rs.getInt("rating"));
                    v2.add(rs.getString("title"));
                    v2.add(rs.getString("review_text"));
                    v2.add(rs.getString("review_reply"));
                }
                df.addRow(v2);
            }
        } catch (Exception ex) {
            
        }
        }
        
    }//GEN-LAST:event_updateActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new reviewTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea review_reply;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
