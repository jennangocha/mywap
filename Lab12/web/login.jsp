<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="POST" action="login">
<div><label for="username" id="lbname">Name:</label></div>
<div><input type="text" id="username" name="username" value="${cookie.user.value}"/></div>
<div><label for="password" id="lbPassword">Password:</label></div>
<div><input type="password" id="password" name="password"/></div>
<div>Remember me: <input type="checkbox"
<c:if test="${cookie.containsKey('user')}">
        checked
</c:if> name="remember" value="yes"/></div>
    <div><input type="submit" value="Login" /></div>
</form>
<span style="...">${error_msg}</span>
</body>
</html>
