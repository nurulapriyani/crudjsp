/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nurul.controller;

import com.nurul.dao.mhsDao;
import com.nurul.model.Admin;
import com.nurul.model.mhs;
import com.nurul.model.session;
import com.nurul.util.dbUtil;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author windows 8
 */
public class UserController extends HttpServlet {
    private mhsDao dao;
    private HttpSession sess;
    private session ses;
    private String ipAdd;
    
    public UserController() {
        super();
        dao = new mhsDao();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="/login.jsp";
        String action = "";
        boolean isLogin= false;
        sess= request.getSession(false);
        ipAdd =  request.getRemoteAddr();
        if((String)sess.getAttribute("nameU")!=null && sess.getId()!=null&&ipAdd!=null)
            isLogin = checkSession(sess.getId(), ipAdd, (String) sess.getAttribute("nameU"));   
       
       
        if(request.getParameter("action")!=null) action= request.getParameter("action").trim();
       
        if (isLogin){
            if(action.equalsIgnoreCase("logout"))
            {
                ses= new session();
                try {
                    ses.deleteSession(sess.getId());
                } catch (SQLException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
                sess.invalidate();
            }else if(action.equalsIgnoreCase("addmhs")){
                forward = "/addmhs.jsp";
            }else if(action.equalsIgnoreCase("deletemhs")){
                String id= request.getParameter("id");
                dao.deleteMhs(id);
                forward = "/listmhs.jsp";
                request.setAttribute("users", dao.listMhs()); 
                request.setAttribute("name",sess.getAttribute("nameU").toString());
            }else if(action.equalsIgnoreCase("editmhs")){
                String id= request.getParameter("id");
                forward = "/editmhs.jsp";
                request.setAttribute("user", dao.getMhsById(id)); 
            }else
            {
                forward = "/listmhs.jsp";
                request.setAttribute("users", dao.listMhs()); 
                request.setAttribute("name",sess.getAttribute("nameU").toString());
            }
        }
     
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String forward="/login.jsp";
        boolean isLogin= false;
        sess= request.getSession(false);
        ipAdd =  request.getRemoteAddr();
        if((String)sess.getAttribute("nameU")!=null && sess.getId()!=null&&ipAdd!=null)
            isLogin = checkSession(sess.getId(), ipAdd, (String) sess.getAttribute("nameU"));
        if(request.getParameter("login")!=null)
        {
           String nama= request.getParameter("nama").trim();
           String pass= request.getParameter("pass").trim();
           Admin cek= new Admin();
           if(cek.validateUser(nama, pass)) 
           {
               ipAdd =  request.getRemoteAddr();
               sess=request.getSession();  
               sess.setAttribute("nameU",nama);  
               ses= new session();
               try {
                   ses.setSession(sess.getId(), nama, ipAdd);
               } catch (SQLException ex) {
                   Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
               }
               forward="/listmhs.jsp";
               request.setAttribute("users", dao.listMhs());
           }
        }else if((request.getParameter("addmhs")!=null)&&isLogin){
            mhs mh= new mhs();
            mh.setNpm(request.getParameter("npm").trim());
            mh.setNama(request.getParameter("nama").trim());
            mh.setTgl_lahir(request.getParameter("tgl_lahir"));
            mh.setJk(request.getParameter("jk").trim());
            mh.setAlamat(request.getParameter("alamat").trim());
            dao.addMhs(mh);
            forward="/addmhs.jsp";
            request.setAttribute("msg", "1 record added");
        }else if((request.getParameter("editmhs")!=null)&&isLogin){
            mhs mh= new mhs();
            mh.setNpm(request.getParameter("npm").trim());
            mh.setNama(request.getParameter("nama").trim());
            mh.setTgl_lahir(request.getParameter("tgl_lahir"));
            mh.setJk(request.getParameter("jk").trim());
            mh.setAlamat(request.getParameter("alamat").trim());
            mh.setId(request.getParameter("id").trim());
            dao.editMhs(mh);
            forward="/editmhs.jsp";
            request.setAttribute("user", dao.getMhsById(request.getParameter("id").trim())); 
            request.setAttribute("msg", "1 record edited");
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    public boolean checkSession(String id,String ip, String nama){
       boolean stat=false;
       try {
           Connection con = con = (Connection) dbUtil.getConnection();
           Statement statement = con.createStatement();
           ResultSet rs = statement.executeQuery("select * from tbl_session where id='"+id+"' and ip='"+ip+"' and user='"+nama+"'");
           if (rs.next()) stat=true;  
           statement.close();
       } catch (SQLException ex) {
          ex.printStackTrace();
       }
       return stat;
    }
}
