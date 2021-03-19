/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diseasedisgnosis;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author RationalTabs
 */
public class viewPatientList extends javax.swing.JInternalFrame {

    /**
     * Creates new form viewPatientList
     */
    JDesktopPane jPane=null;
    public viewPatientList( JDesktopPane pane) {
        initComponents();
        
        jPane= pane;
        viewPatients();
        setBounds(0,0, 750, 500);
        
    }

    
    void viewPatients()
    {
        try
        {
            DC o = new DC();
            Object[] res = o.viewPatients(txtSearch.getText().trim());
            ResultSet rs = (ResultSet)res[0];
            Connection con = (Connection)res[1];

            
            
            pnlList.setLayout(new GridLayout(0, 1,0,1));
            pnlSymptomList.setViewportView(pnlList);

            while(rs.next()) {                

                JPanel pnl = new JPanel();
                pnl.setLayout(null);
                pnl.setPreferredSize(new Dimension(700, 300));

                JLabel lblName = new JLabel("Name: ");
                lblName.setBounds(20, 15, 200, 24);

                JTextField txtName = new JTextField();
                txtName.setText(rs.getString("Name"));
                txtName.setBounds(20, 42, 340, 24);
                
                
                JLabel lblGender = new JLabel("Gender: ");
                lblGender.setBounds(370, 15, 200, 24);

                JTextField txtGender = new JTextField();
                txtGender.setText(rs.getString("Gender"));
                txtGender.setBounds(370, 42, 340, 24);
                
                
                JLabel lblDOB = new JLabel("DOB: ");
                lblDOB.setBounds(20, 70, 140, 24);

                JTextField txtDOB = new JTextField();
                txtDOB.setText(rs.getString("DOB"));
                txtDOB.setBounds(20, 98, 340, 24);
                
                
                JLabel lblBloodGroup = new JLabel("Blood Group: ");
                lblBloodGroup.setBounds(370, 70, 140, 24);

                JTextField txtBloodGroup = new JTextField();
                txtBloodGroup.setText(rs.getString("BloodGroup"));
                txtBloodGroup.setBounds(370, 98, 340, 24);
                
                
                JLabel lblContact = new JLabel("Contact: ");
                lblContact.setBounds(20, 126, 140, 24);

                JTextField txtContact = new JTextField();
                txtContact.setText(rs.getString("Contact"));
                txtContact.setBounds(20, 154, 340, 24);
                
                JLabel lblDate = new JLabel("Dated: ");
                lblDate.setBounds(370, 126, 140, 24);

                JTextField txtDate = new JTextField();
                txtDate.setText(rs.getString("CreatedDate"));
                txtDate.setBounds(370, 154, 340, 24);
                
                
                JLabel lblAddress = new JLabel("Address: ");
                lblAddress.setBounds(20, 182, 140, 24);

                JTextArea txtAddress = new JTextArea();
                txtAddress.setText(rs.getString("Address"));
                txtAddress.setBorder(new LineBorder(Color.LIGHT_GRAY));
                txtAddress.setBounds(0, 0, 340, 60);
                txtAddress.setLineWrap(true);
                txtAddress.setWrapStyleWord(true);
                JScrollPane scroll = new JScrollPane (txtAddress, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                scroll.setBounds(20, 210, 340, 60);
                scroll.setHorizontalScrollBar(null);

                JButton btn = new JButton("VIEW DISEASE");
                btn.setName(Integer.toString(rs.getInt("ID")));
                btn.setBounds(370, 210, 120, 26);
                btn.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
//                          JOptionPane.showMessageDialog(rootPane, "CLICKED." + ((JButton)e.getSource()).getText());
                        JButton bClk = ((JButton)e.getSource());
                        JTextField jtxtName = (JTextField)bClk.getParent().getComponent(1);
                        JTextField jtxtGender = (JTextField)bClk.getParent().getComponent(3);
                        JTextField jtxtDOB = (JTextField)bClk.getParent().getComponent(5);
                        JTextField jtxtBloodGroup = (JTextField)bClk.getParent().getComponent(7);
                        JTextField jtxtContact = (JTextField)bClk.getParent().getComponent(9);
                        JTextField jtxtDate = (JTextField)bClk.getParent().getComponent(11);
//                        JScrollPane pn = ((JScrollPane)bClk.getParent().getComponent(13));
//                        JTextArea jtxtAddress = ((ViewPort)((JScrollPane)bClk.getParent().getComponent(13)).getComponent(0)).;

                        PatientDetails det = new PatientDetails(Integer.valueOf(bClk.getName()), jtxtName.getText().trim(), jtxtGender.getText().trim(), jtxtDOB.getText().trim(), jtxtBloodGroup.getText().trim(), jtxtContact.getText().trim(), "");
                        det.setVisible(true);
                        jPane.add(det);
                        det.requestFocus(true);
                        
                        
                    }
                });

                pnl.add(lblName);
                pnl.add(txtName);
                pnl.add(lblGender);
                pnl.add(txtGender);
                pnl.add(lblDOB);
                pnl.add(txtDOB);
                pnl.add(lblBloodGroup);
                pnl.add(txtBloodGroup);
                pnl.add(lblContact);
                pnl.add(txtContact);
                pnl.add(lblDate);
                pnl.add(txtDate);
                pnl.add(lblAddress);
                pnl.add(scroll);
                
                pnl.add(btn);

                pnl.setBorder(new TitledBorder("Patient ID: " + String.valueOf(rs.getString("ID"))));

                pnlList.setVisible(true);
                pnlList.add(pnl);
                pnlList.revalidate();
                pnlList.repaint();

            }
            pnlSymptomList.revalidate();
            pnlSymptomList.repaint();
            rs.close();
            con.close();

        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(rootPane, "ERROR in loading patient records");
            
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

        pnlmain = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        pnlSymptomList = new javax.swing.JScrollPane();
        pnlList = new javax.swing.JPanel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Patient List");
        setInheritsPopupMenu(true);
        setNextFocusableComponent(jButton1);

        pnlmain.setLayout(new java.awt.BorderLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(679, 40));

        txtSearch.setNextFocusableComponent(jButton1);
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Search Key:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jButton1)
                .addContainerGap(190, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        pnlmain.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        pnlSymptomList.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        pnlSymptomList.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        pnlSymptomList.setViewportBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlSymptomList.setAutoscrolls(true);
        pnlSymptomList.setViewportView(pnlList);

        pnlmain.add(pnlSymptomList, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlmain, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        pnlList.removeAll();
        viewPatients();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnlList;
    private javax.swing.JScrollPane pnlSymptomList;
    private javax.swing.JPanel pnlmain;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
