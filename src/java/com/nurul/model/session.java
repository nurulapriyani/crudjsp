/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nurul.model;

import com.nurul.util.dbUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

/**
 *
 * @author windows 8
 */
public class session {
   private Connection con;
   private  Statement statement ;
    
    public session(){
        con = (Connection) dbUtil.getConnection();
    }
    public void setSession(String id,String nama,String ip) throws SQLException
    {
         statement = con.createStatement();
         statement.executeUpdate("INSERT INTO tbl_session values('"+id+"','"+ip+"','"+nama+"')");
         
    }
    public void deleteSession(String id)throws SQLException{
         statement = con.createStatement();
         statement .executeUpdate("DELETE FROM tbl_session WHERE id='"+id+"'");
         statement .close();
    }
    
}
