<%-- 
    Document   : addmhs
    Created on : Feb 11, 2015, 7:19:47 AM
    Author     : windows 8
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="assets/css/bootstrap.css" rel="stylesheet">
        <title>Add Mahasiswa</title>
    </head>
    <body>
        <div align="center" width="500px">
            <h2>Add Data</h2>
            <a href="UserController?action=listmhs"  class="btn">List Mahasiswa</a><br/></br/>
            <% if(request.getAttribute("msg")!=null)out.print("<div class='alert alert-success' role='alert'>"+(String)request.getAttribute("msg")+"</div>");%>
            <form method="post" action="UserController">
                <table >
                    <tr><td>NPM</td><td><input type="text" name="npm" id="npm"></td></tr>
                    <tr><td>Nama</td><td><input type="text" name="nama" id="nama"></td></tr>
                    <tr><td>Tgl lahir</td><td><input type="date" name="tgl_lahir" id="tgl_lahir"></td></tr>
                    <tr><td>Jk</td><td><input type="radio" name="jk" id="jk" value="L">L<input type="radio" name="jk" id="jk" value="P">P</td></tr>
                    <tr><td>Alamat</td><td><textarea cols="22" rows="5" name="alamat" id="alamat"></textarea></td></tr>
                    <tr><td><input type="submit" name="addmhs" class="btn btn-primary"></td><td></td></tr>
                </table>
            </form>
        </div>
    </body>
</html>
