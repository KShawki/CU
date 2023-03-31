<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<<html>
<head>
    <title>Login Form</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h2>Login Page</h2><br>
<div class="login">
    <form id="login" method="get" action="StudentLogin">
        <label><b>User Id
        </b>
        </label>
        <input type="text" name="Uname" id="Uname" placeholder="Username">
        <br><br>
        <label><b>Password
        </b>
        </label>
        <input type="Password" name="Pass" id="Pass" placeholder="Password">
        <br><br>
        <a href = ""><input type="submit" name="log" id="log" value="Log In Here"> </a>
        <br><br>
    </form>
</div>
</body>
</html>