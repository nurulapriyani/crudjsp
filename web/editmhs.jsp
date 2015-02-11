<%-- 
    Document   : editmhs
    Created on : Feb 11, 2015, 12:56:31 PM
    Author     : windows 8
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="assets/css/bootstrap.css" rel="stylesheet">
        <title>Edit Mahasiswa</title>
    </head>
    <body>
        <div width="500px" align="center">
            <h2>Edit Data</h2>
            <a href="UserController?action=listmhs"  class="btn">List Mahasiswa</a><br/><br/>
            <% if(request.getAttribute("msg")!=null)out.print("<div class='alert alert-success' role='alert'>"+(String)request.getAttribute("msg")+"</div>");%>
            <form method="post" action="UserController">
                <table >
                    <c:forEach items="${user}" var="row">
                        <tr><td>NPM</td><td><input type="text" name="npm" id="npm" value="${row.npm}"/></td></tr>
                        <tr><td>Nama</td><td><input type="text" name="nama" id="nama" value="${row.nama}"/></td></tr>
                        <tr><td>Tgl lahir</td><td><input type="date" name="tgl_lahir" id="tgl_lahir" value="${row.tgl_lahir}"/></td></tr>
                        <tr><td>Jk</td><td>
                         <% if(request.getParameter("row.jk")=="L"){%>
                           <input type="radio" name="jk" id="jk" value="L" checked>L<input type="radio" name="jk" id="jk" value="P">P</td></tr>
                         <% }else{ %>
                            <input type="radio" name="jk" id="jk" value="L" >L<input type="radio" name="jk" id="jk" value="P" checked>P</td></tr>
                        <% } %>
                        <tr><td>Alamat</td><td><textarea cols="22" rows="5" name="alamat" id="alamat"><c:out value="${row.alamat}"/></textarea></td></tr>
                        <tr><td></td><td><input type="hidden" name="id" id="id" value="${row.id}"/></td></tr>
                        <tr><td><input type="submit" name="editmhs"  class="btn btn-primary"></td><td></td></tr>
                    </c:forEach>
                </table>
            </form>
        </div>
    </body>
</html>

