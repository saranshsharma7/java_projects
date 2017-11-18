/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complaint_management;

import Buslogic.clsacc;
import Buslogic.clsaccprp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author csgroup
 */
public class frmact extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmact
     */
    public frmact() {
        initComponents();
        setClosable(true);
        loaddata();
        setTitle("Manage Accounts");
        setLocation(100,100);
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
    }
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtactnam = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cmbacttyp = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cmbloc = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtphnno = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtadd = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Account Name");

        jLabel2.setText("Account Type");

        cmbacttyp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BroadBand", "DTH" }));

        jLabel3.setText("Location");

        cmbloc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chandigarh", "Panchkula", "Mohali" }));

        jLabel4.setText("Phone No");

        jLabel5.setText("Address");

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Account No", "Account Name", "Account Type", "Location", "Phone No"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Cancel");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jButton2)
                        .addGap(34, 34, 34)
                        .addComponent(jButton3)
                        .addGap(29, 29, 29)
                        .addComponent(jButton4))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtactnam)
                        .addComponent(cmbacttyp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbloc, 0, 171, Short.MAX_VALUE)
                        .addComponent(txtphnno))
                    .addComponent(txtadd, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtactnam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbacttyp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbloc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtphnno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtadd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2)
                        .addComponent(jButton3)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void clear()
    {
        txtactnam.setText("");
        txtadd.setText("");
        txtphnno.setText("");
    }
    public void loaddata()
    {
 DefaultTableModel mod=(DefaultTableModel)jTable2.getModel();
 mod.setRowCount(0);
 clsacc obj=new clsacc();
 List<clsaccprp> k=obj.disp_rec();
 for(clsaccprp p:k)
 {
       Object[] rowdata=new Object[5];
       rowdata[0]=p.getaccno();
       rowdata[1]=p.getaccnam();
       rowdata[2]=p.getacctyp();
       rowdata[3]=p.getaccloc();
       rowdata[4]=p.getaccphnno();
       mod.addRow(rowdata);
 }
      jTable2.setModel(mod);
    }
           
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      if(txtactnam.getText().equals("") || 
              txtphnno.getText().equals("") ||
              txtadd.getText().equals(""))
      JOptionPane.showMessageDialog(this,"Please fill entries");
      else  
      {
          clsaccprp objprp=new clsaccprp();
          clsacc obj=new clsacc();
          objprp.setaccnam(txtactnam.getText());
          objprp.setaccadd(txtadd.getText());
     objprp.setaccloc(cmbloc.getSelectedItem().toString());
     objprp.setacctyp(cmbacttyp.getSelectedItem().toString());
     objprp.setaccphnno(txtphnno.getText());
     objprp.setacccrtdat(new Date());
          obj.save_rec(objprp);
          //code to clear textboxes and fill table
          clear();
          loaddata();
      } 
    }//GEN-LAST:event_jButton1ActionPerformed

    int acod;
    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
       int idx=jTable2.getSelectedRow();
       if(idx!=-1)
       {
          acod=(int)jTable2.getValueAt(idx,0);
    txtactnam.setText(jTable2.getValueAt(idx,1).toString());
    txtphnno.setText(jTable2.getValueAt(idx,4).toString());
    cmbacttyp.setSelectedItem(
            jTable2.getValueAt(idx, 2).toString()      
    );
    cmbloc.setSelectedItem(
            jTable2.getValueAt(idx,3).toString());
          clsacc obj=new clsacc();
          clsaccprp p=obj.find_rec(acod);
     txtadd.setText(p.getaccadd());
          jButton2.setEnabled(true);
          jButton3.setEnabled(true);
       }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        if(txtactnam.getText().equals("") || 
              txtphnno.getText().equals("") ||
              txtadd.getText().equals(""))
      JOptionPane.showMessageDialog(this,"Please fill entries");
      else  
      {
          clsaccprp objprp=new clsaccprp();
          clsacc obj=new clsacc();
          objprp.setaccnam(txtactnam.getText());
          objprp.setaccadd(txtadd.getText());
     objprp.setaccloc(cmbloc.getSelectedItem().toString());
     objprp.setacctyp(cmbacttyp.getSelectedItem().toString());
     objprp.setaccphnno(txtphnno.getText());
     objprp.setacccrtdat(new Date());
     objprp.setaccno(acod);
          obj.upd_rec(objprp);
          jButton2.setEnabled(false);
          jButton3.setEnabled(false);
          //code to clear textboxes and fill table
          clear();
          loaddata();
      } 
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        clsacc obj=new clsacc();
        clsaccprp objprp=new clsaccprp();
        objprp.setaccno(acod);
        obj.del_rec(objprp);
        clear();
        loaddata();
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        clear();
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbacttyp;
    private javax.swing.JComboBox<String> cmbloc;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txtactnam;
    private javax.swing.JTextField txtadd;
    private javax.swing.JTextField txtphnno;
    // End of variables declaration//GEN-END:variables
}
