<%-- 
    Document   : daftarmhs
    Created on : Feb 10, 2015, 12:56:10 PM
    Author     : windows 8
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="assets/css/bootstrap.css" rel="stylesheet">
        <title>List Mahasiswa</title>
    </head>
    <body>
        <div class="container">
            <h1>Hello <c:out value="${name}"/>!</h1><br/>
            <p><a href="UserController?action=logout">Logout</a></p><br/>
            <a href="UserController?action=addmhs" class="btn btn-primary">Add Record</a><br/><br/>

            <table class="table table-striped table-bordered">
                <tr> 
                    <th>No.</th>
                    <th>NPM</th>
                    <th>Nama</th>
                    <th>Tgl Lahir</th>
                    <th>Jenis Kelamin</th>
                    <th>Alamat</th>
                    <th>Action</th>
                </tr>
                <% int i=1;%>
            <c:forEach items="${users}" var="row">
                <tr>
                    <td><% out.print(""+i++); %></td>
                    <td> <c:out value="${row.npm}"/> </td>
                    <td> <c:out value="${row.nama}"/> </td>
                    <td> <c:out value="${row.tgl_lahir}"/>
                    <td> <c:out value="${row.jk}"/>
                    <td> <c:out value="${row.alamat}"/>
                    <td> <a href="UserController?action=editmhs&id=<c:out value="${row.id}"/>"> Edit</a>
                         <a href="UserController?action=deletemhs&id=<c:out value="${row.id}"/>" onclick="return confirm('do you really want to delete this record?')" style="color:red"> Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </table>
        </div>
    </body>
</html>
