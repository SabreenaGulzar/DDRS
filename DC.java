/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diseasedisgnosis;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;




public class DC {
    
    Connection c = null;
    CN o = null;
    
    
    int registerPatient(String name, String gender, String dob, String bloodGroup, String contact, String address)
    {
        int res = -1;
        try {
                //LOGIN CODE
                
           
            o = new CN();
            c = o.Connect();
            
            CallableStatement cs;
            cs = c.prepareCall("exec proc_RegisterPatient ?, ?, ?, ?, ?, ?, ?");
            
            cs.setString(1, name);
            cs.setString(2, gender);
            cs.setString(3, dob);
            cs.setString(4, bloodGroup);
            cs.setString(5, contact);
            cs.setString(6, address);
            cs.registerOutParameter("Res", java.sql.Types.INTEGER);
            
            cs.execute();
            
            res = cs.getInt("Res");
            
            return res;
            
            } catch (SQLException ex) {
                return res;
            }
    }
    
    Boolean saveDisease(int PatientID, String DiseaseName, String DepartmentName)
    {
        Boolean res=true;
        try {
            o = new CN();
            c = o.Connect();
            
            CallableStatement cs;
            cs = c.prepareCall("exec saveDiseaseDetails ?, ?, ? ");
            
            cs.setInt(1, PatientID);
            cs.setString(2, DiseaseName);
            cs.setString(3, DepartmentName);
            res = cs.execute();
            
            return res;
            
            } catch (SQLException ex) {
                return false;
            }
    }
    
    
    
    Object[] searchSymptoms(String searchKey, String symtpomsList)
    {
        try {
                //LOGIN CODE
                
           
            o = new CN();
            c = o.Connect();
            
            CallableStatement cs;
            cs = c.prepareCall("exec proc_searchSymptom ?, ?");
            cs.setString(1, searchKey);
            cs.setString(2, symtpomsList);
            
            ResultSet rs = cs.executeQuery();
            
            return new Object[]{rs, c};
            
            
            } catch (SQLException ex) {
                
                return null;
            }
    }
    
    Object[] getDiseaseDetails(int PatientID)
    {
        try {
                //LOGIN CODE
                
           
            o = new CN();
            c = o.Connect();
            
            CallableStatement cs;
            cs = c.prepareCall("exec getDiseaseDetails ?");
            cs.setInt(1, PatientID);
            
            ResultSet rs = cs.executeQuery();
            
            return new Object[]{rs, c};
            
            
            } catch (SQLException ex) {
                
                return null;
            }
    }
    
    Object[] getSymptoms(String Disease)
    {
        try {
                //LOGIN CODE
                
           
            o = new CN();
            c = o.Connect();
            
            CallableStatement cs;
            cs = c.prepareCall("exec getSymptoms ?");
            cs.setString(1, Disease);
            
            ResultSet rs = cs.executeQuery();
            
            return new Object[]{rs, c};
            
            
            } catch (SQLException ex) {
                
                return null;
            }
    }
    
    Object[] viewPatients(String Key)
    {
        try {
                //LOGIN CODE
                
           
            o = new CN();
            c = o.Connect();
            
            CallableStatement cs;
            cs = c.prepareCall("exec proc_getPatients ? ");
            cs.setString(1, Key);
            
            ResultSet rs = cs.executeQuery();
            
            return new Object[]{rs, c};
            
            
            } catch (SQLException ex) {
                
                return null;
            }
    }
    
    
    ResultSet TestMethod()
    {
        try {
                //LOGIN CODE
                
                
            o = new CN();
            c = o.Connect();
            
            CallableStatement cs;
                
            cs = c.prepareCall("proc_Test");
                
            ResultSet rs = cs.executeQuery();
            return rs;
            
            
            } catch (SQLException ex) {
                
                return null;
            }
    }
    
    
}
