/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diseasedisgnosis;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.TableView;

/**
 *
 * @author RationalTabs
 */
public class ViewPatients extends javax.swing.JInternalFrame {

    DefaultTableModel dtm = new DefaultTableModel(new Object[]{"ID", "Name", "Gender",  "DOB", "BloodGroup", "Contact", "Address", "CreatedOn"}, 0);
    
    /**
     * Creates new form ViewPatients
     */
    public ViewPatients() {
        initComponents();
        
//        viewPatients();
        
    }
    
//    void viewPatients()
//    {
//        try
//        {
//            DC o = new DC();
//            Object[] res = o.viewPatients();
//            ResultSet rs = (ResultSet)res[0];
//            Connection con = (Connection)res[1];
//
//            while(rs.next()) {  
//                
//                Vector<String> row = new Vector<String>();
//                row.addElement(String.valueOf(rs.getInt("ID")));
//                row.addElement(rs.getString("Name"));
//                row.addElement(rs.getString("Gender"));
//                row.addElement(rs.getString("DOB"));
//                row.addElement(rs.getString("BloodGroup"));
//                row.addElement(rs.getString("Contact"));
//                row.addElement(rs.getString("Address"));
//                row.addElement(String.valueOf(rs.getDate("CreatedDate")));
//                
//                dtm.addRow(row);
//                
//                
//            }
//            rs.close();
//            con.close();
//            
//            jTable1.setModel(dtm);
//            
//        }
//        catch(Exception e)
//        {
//            JOptionPane.showMessageDialog(rootPane, "ERROR in loading patient records");
//            
//        }
//    
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("View Patients"));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

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

        jPanel1.add(jScrollPane1);

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
