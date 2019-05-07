<%--
  Created by IntelliJ IDEA.
  User: I505998
  Date: 5/5/2019
  Time: 9:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
</head>
<body>
<h1>Register Page</h1>
<form action="${ pageContext.request.contextPath }/RegisterServlet" method="post">
    <table class="table table-striped table-bordered table-hover">
        <tr>
            <td>User Name</td>
            <td><input type="text" name="username" /></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password" /></td>
        </tr>
        <tr>
            <td>Nickname</td>
            <td><input type="text" name="nickname" /></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="email" name="email" /></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Submit" /></td>
        </tr>
    </table>

</form>
</body>
</html>
