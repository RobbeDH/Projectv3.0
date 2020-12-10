<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: robbe
  Date: 12/10/2020
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="stijl.css">
    <title>Kampen | zoeken</title>
</head>
<jsp:include page="header.jsp">
    <jsp:param name="actual" value="zoekForm"/>
</jsp:include>
<body>
<h1>Kamp zoeken</h1>
<c:if test="${not empty errors}">
    <div class="error">
        <ul>
            <c:forEach items="${errors}" var="error">
                <li>${error}</li>
            </c:forEach>
        </ul>
    </div>
</c:if>
<form method="GET" action="Servlet">
    <p>
        <label for="jaar"> Jaar </label>
        <input id="jaar" name="jaar">
        <input type="hidden" name="command" value="zoekKamp">
    </p>
    <p>
        <button type="submit" id="submit" class="knop">Zoek</button>
    </p>

</form>
</body>
</html>
