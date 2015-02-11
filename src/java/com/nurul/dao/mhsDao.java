/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nurul.dao;

import com.nurul.model.mhs;
import com.nurul.util.dbUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author windows 8
 */
public class mhsDao {
    private Connection con;
    
    public mhsDao(){
        con = (Connection) dbUtil.getConnection();
    }
    public List<mhs> listMhs()
    {
        List<mhs> mhss= new ArrayList<mhs>();
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("select * from tbl_mhs");
            while (rs.next()) {
                 mhs mh= new mhs();
                 mh.setId(rs.getString("id"));
                 mh.setNama(rs.getString("nama"));
                 mh.setNpm(rs.getString("npm"));
                 mh.setTgl_lahir(rs.getString("tgl_lahir"));
                 mh.setJk(rs.getString("jk"));
                 mh.setAlamat(rs.getString("alamat"));
                 mhss.add(mh);
            }
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
            }
        return mhss;
    }
    public void addMhs(mhs mh)
    {
        try {
            Statement statement = con.createStatement();
            statement.executeUpdate("INSERT INTO tbl_mhs VALUES(0,'"+mh.getNpm()+"','"+mh.getNama()+"','"+mh.getTgl_lahir()+"','"+mh.getJk()+"','"+mh.getAlamat()+"')");
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
     public void deleteMhs(String id)
    {
        try {
            Statement statement = con.createStatement();
            statement.executeUpdate("DELETE FROM tbl_mhs WHERE id="+id);
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
     public List<mhs> getMhsById(String id)
    {
        List<mhs> mhss= new ArrayList<mhs>();
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM tbl_mhs WHERE id="+id);
            while (rs.next()) {
                 mhs mh= new mhs();
                 mh.setId(rs.getString("id"));
                 mh.setNama(rs.getString("nama"));
                 mh.setNpm(rs.getString("npm"));
                 mh.setTgl_lahir(rs.getString("tgl_lahir"));
                 mh.setJk(rs.getString("jk"));
                 mh.setAlamat(rs.getString("alamat"));
                 mhss.add(mh);
            }
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
            }
        return mhss;
    }
      public void editMhs(mhs mh)
    {
        try {
            Statement statement = con.createStatement();
            statement.executeUpdate("UPDATE tbl_mhs SET npm='"+mh.getNpm()+"', nama='"+mh.getNama()+"', tgl_lahir='"+mh.getTgl_lahir()+"', jk='"+mh.getJk()+"',alamat='"+mh.getAlamat()+"' WHERE id="+mh.getId());
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
