<%@ page import="Domain.model.Kamp" %>
<% Kamp kamp = (Kamp) request.getAttribute("kamp"); %><%--
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
    <title>gevonden</title>
</head>
<body>
<header>
    <nav>
        <ul>
            <li><a href="Servlet?command=home"> Home </a></li>
            <li><a href="Servlet?command=overzicht"> Overzicht </a></li>
            <li><a href="toevoegen.jsp"> Toevoegen </a></li>
            <li><a href="zoekKamp.jsp"> Zoek Kamp</a></li>
        </ul>
    </nav>
</header>
<main>
    <h1>Kamp gevonden</h1>
<p>
    <%=kamp.getJaar() + " kampplaats: " + kamp.getPlaats() + " thema: " + kamp.getThema()%>
</p>
</main>
</body>
</html>
