<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dylan
  Date: 23-4-2020
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="stijl.css">
    <title>Kampen | gevonden</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<main>
    <h1>Kamp ${kamp.jaar} gevonden</h1>
    <p>
        ${kamp.jaar} kampplaats: ${kamp.plaats}
    </p>
    <c:choose>
    <c:when test="${zoekCount == 1}">
    <p>
        U heeft al ${zoekCount} kamp opgezocht
    </p>
    </c:when>
    <c:otherwise>
        <p>
            U heeft al ${zoekCount} kampen opgezocht
        </p>
    </c:otherwise>
    </c:choose>
</main>
</body>
</html>
