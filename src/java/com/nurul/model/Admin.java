/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nurul.model;

import com.nurul.util.dbUtil;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author windows 8
 */
public class Admin {
    private Connection con;
   
    public Admin(){
        con = (Connection) dbUtil.getConnection();
    }
    public boolean validateUser(String nama, String pass){
        boolean stat= false;
        try {
            //MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(pass.getBytes());
            byte[] digest = md.digest();
            StringBuffer sb = new StringBuffer();
            for (byte b : digest) {
                    sb.append(String.format("%02x", b & 0xff));
            }
            
            //sha1
            MessageDigest md2 = MessageDigest.getInstance("SHA1");
            md2.update(sb.toString().substring(2, 20).getBytes());
            byte[] digest2 = md2.digest();
            StringBuffer sb2 = new StringBuffer();
            for (byte b : digest2) {
                    sb2.append(String.format("%02x", b & 0xff));
            }

            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("select * from tbl_admin where username='"+nama+"' and password='"+sb2.toString()+"'");
            if (rs.next()) stat=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return stat;
    }
}
