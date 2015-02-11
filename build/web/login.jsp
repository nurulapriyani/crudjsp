<%-- 
    Document   : login
    Created on : Feb 11, 2015, 5:43:22 AM
    Author     : windows 8
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="assets/css/bootstrap.css" rel="stylesheet">
        <title>Form Login</title>
    </head>
    <body>
         <div class="container">
            <form class="form-signin" method="post" action="UserController">
              <h2 class="form-signin-heading">Please sign in</h2>
              <label for="inputEmail" class="sr-only">Username</label>
              <input type="text" class="form-control" placeholder="Username" name="nama" required autofocus>
              <label for="inputPassword" class="sr-only">Password</label>
              <input type="password" class="form-control" name="pass" placeholder="Password" required>
              <br/><button class="btn btn-lg btn-primary btn-block" type="submit" name="login">Sign in</button>
            </form>

          </div> <!-- /container -->
    </body>
</html>
