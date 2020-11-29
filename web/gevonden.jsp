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
    <h1>Kamp gevonden</h1>
    <p>
        ${kamp.jaar} kampplaats: ${kamp.plaats}
    </p>
    <p>
        U heeft al ${zoekCount} kampen opgezocht
    </p>
</main>
</body>
</html>
